package com.hasantuncay.mobsec.common.crypto

import org.bouncycastle.jcajce.spec.MLKEMParameterSpec
import org.bouncycastle.jce.provider.BouncyCastleProvider

import java.security.KeyPair
import java.security.KeyPairGenerator
import java.security.PrivateKey
import java.security.PublicKey
import java.security.SecureRandom
import javax.crypto.KeyGenerator

/**
 * PQC (Post-Quantum Cryptography) Manager
 * NIST FIPS 203 ML-KEM (Kyber-768) implementation using BouncyCastle
 */
object PqcManager {

    private val bcProvider = BouncyCastleProvider()

    data class KemResult(
        val secretKey: ByteArray,
        val encapsulation: ByteArray
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false
            other as KemResult
            if (!secretKey.contentEquals(other.secretKey)) return false
            if (!encapsulation.contentEquals(other.encapsulation)) return false
            return true
        }

        override fun hashCode(): Int {
            var result = secretKey.contentHashCode()
            result = 31 * result + encapsulation.contentHashCode()
            return result
        }
    }

    fun generateMlKemKeyPair(): KeyPair {
        val keyPairGenerator = KeyPairGenerator.getInstance("ML-KEM", bcProvider)
        keyPairGenerator.initialize(MLKEMParameterSpec.ml_kem_768, SecureRandom())
        return keyPairGenerator.generateKeyPair()
    }

    fun encapsulate(publicKey: PublicKey): KemResult {
        val keyGenerator = KeyGenerator.getInstance("ML-KEM", bcProvider)
        keyGenerator.init(org.bouncycastle.jcajce.spec.KEMGenerateSpec(publicKey, "AES"), SecureRandom())
        val secretKey = keyGenerator.generateKey()
        
        val keyWithEncapsulation = secretKey as org.bouncycastle.jcajce.SecretKeyWithEncapsulation
        
        return KemResult(
            secretKey = keyWithEncapsulation.encoded,
            encapsulation = keyWithEncapsulation.encapsulation
        )
    }

    fun decapsulate(privateKey: PrivateKey, encapsulation: ByteArray): ByteArray {
        val keyGenerator = KeyGenerator.getInstance("ML-KEM", bcProvider)
        keyGenerator.init(org.bouncycastle.jcajce.spec.KEMExtractSpec(privateKey, encapsulation, "AES"))
        val secretKey = keyGenerator.generateKey()
        return secretKey.encoded
    }
}
