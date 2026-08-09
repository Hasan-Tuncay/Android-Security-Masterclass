# MASWE-0002 Secure Storage and Cryptography Architecture

This document explains the secure storage strategies, cryptographic standards, and architectural decisions (with cause-and-effect relationships) implemented within the scope of the Android Security Masterclass (MASWE-0002) vectors.

## 1. Why Google Tink?

In the past, the standard Java Cryptography Architecture (JCA) classes such as `Cipher`, `KeyGenerator`, and `SecretKey` were widely used for encryption on the Android platform. However, using these low-level primitives directly led to numerous fatal security vulnerabilities, such as incorrect Initialization Vector (IV) management and flawed padding choices (e.g., `AES/ECB/PKCS5Padding`).

To resolve this, we use Google's **Tink** library. Tink abstracts cryptographic operations through what it calls "Primitives," making it extremely difficult to misuse cryptography.

### What is AEAD (Authenticated Encryption with Associated Data)?
In this project, **AEAD** is used to encrypt both the `EncryptedDataStoreSerializer` (DataStore) and the ephemeral Cache files.
AEAD not only encrypts the data (confidentiality) but also attaches a mathematical signature/tag (MAC) to the encrypted payload (integrity). If an attacker tampers with even a single byte of the encrypted file on disk (e.g., a JSON document), Tink AEAD will detect this manipulation during decryption and refuse to return the data, throwing an exception instead.

* **Aead (Standard):** Loads the entire payload into the device's memory (RAM) and encrypts/decrypts it at once. It is highly suitable for Jetpack DataStore, SharedPreferences, and small configuration files (JSON). Care must be taken to ensure payloads are small to avoid memory bloat.
* **StreamingAead (Stream Encryption):** Specifically designed for large files such as PDF documents, videos, and audio recordings. Instead of loading the massive file into RAM at once, it reads, encrypts, and writes the data to disk in chunks. The deprecated `EncryptedFile` wrapper used this under the hood. However, due to performance bottlenecks, it is now highly recommended to use Tink's `StreamingAead` directly via Java's `InputStream` and `OutputStream`.

## 2. Why Are `EncryptedSharedPreferences` and `EncryptedFile` Deprecated?

As you can see in the implementations of Vector 1 and Vector 5, we utilized the `EncryptedSharedPreferences` and `EncryptedFile` components from the `androidx.security.crypto` library.

**IMPORTANT EDUCATIONAL NOTE:** Both of these components have been officially declared **Deprecated** by Google as of April 2025.
Reasons for Deprecation:
1. Chronic "Keyset corruption" exceptions affecting users on certain OEM devices.
2. Performance bottlenecks and Application Not Responding (ANR) issues caused by synchronous I/O operations occurring on the Main Thread.

So why are they still in our codebase?
**Answer:** This Masterclass is an educational and awareness project. Over 90% of production apps and enterprise projects in the industry still heavily rely on this legacy "Wrapper" architecture. These classes are intentionally kept here as a "Legacy" example so that students can recognize real-world code, understand its flaws, and learn its history. We simply added `@Suppress("DEPRECATION")` to hide the IDE warnings.

* **Modern Best Practice:** Instead of `EncryptedSharedPreferences`, use **Jetpack DataStore + Tink AEAD** (demonstrated in Vector 2); instead of `EncryptedFile`, use **Tink StreamingAead** directly.

## 3. Post-Quantum Cryptography (PQC) and Android Classloader Conflicts

To mitigate the threat of quantum computers breaking current encryption standards (specifically asymmetric algorithms like RSA and ECC via Shor's Algorithm) in seconds, we integrated the **NIST FIPS 203 standardized ML-KEM (Kyber)** algorithm into the project using Bouncy Castle 1.85 (`PqcManager.kt`).

During this integration, we addressed a chronic Android OS limitation known as "Provider Shadowing":
* The Android OS kernel contains a heavily outdated, restricted, and non-updatable cryptographic provider named `"BC"` (Bouncy Castle).
* When attempting to register our newly imported Bouncy Castle 1.85 using the global JCA command `Security.addProvider(BouncyCastleProvider())`, Android often rejects or ignores it because a provider with the name `"BC"` already exists.
* This results in the code being unable to locate the Post-Quantum "ML-KEM" algorithm, throwing a `NoSuchAlgorithmException`.

**Implemented Architectural Solution:**
We completely bypassed the JCA Global Registry. Instead, we instantiated `BouncyCastleProvider` as a local Kotlin object and passed it directly to the factory methods, e.g., `KeyPairGenerator.getInstance("ML-KEM", bcProvider)`. This approach perfectly circumvents Android's Classloader and Provider Shadowing conflicts. It is currently the industry's definitive "Best Practice" for safely utilizing custom, modern cryptographic libraries embedded within an Android app.
