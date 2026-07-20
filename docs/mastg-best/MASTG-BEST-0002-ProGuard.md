# MASTG-BEST-0002: Remove Logging Code (Memory Leaks)

## 📌 Overview
This scenario demonstrates the hidden dangers of memory leaks caused by `StringBuilder` allocations when logging sensitive data. Even if standard logging code is removed or stripped in production, improper implementation can still leave sensitive data exposed in the RAM (Heap Memory).

## ❌ Vulnerable Implementation (`:app-vulnerable`)
In a standard logging scenario, developers often use String Interpolation (or String concatenation) to print variables:

```kotlin
Log.d("SecurityTag", "User Password: ${appData.password}")
// OR
Log.d("SecurityTag", "User Password: " + appData.password)
```

**The Vulnerability:**
When the Android compiler processes this line, it translates the string concatenation into a `StringBuilder` allocation in the bytecode:
`new StringBuilder("User Password: ").append(password).toString()`

Even if you use a ProGuard/R8 rule to strip `Log.d` calls in the Release build, the ProGuard rule only deletes the method call itself. The `StringBuilder` allocation and the resulting `.toString()` object are **NOT** guaranteed to be stripped. 
As a result, the user's plaintext password is loaded into the device's RAM. An attacker who compromises the device and takes a Memory Dump of the application will find the plaintext password sitting in the heap, despite the fact that nothing was ever printed to the system Logcat.

## ✅ Secure Implementation (`:app-secure`)
To mitigate this hidden memory leak, we implemented a Custom Logging Architecture that strictly relies on variable arguments (`vararg`) and compiler directives.

### 1. Custom Logging Facility (`SecureLog.kt`)
We created a custom logging class that completely prohibits string interpolation at the call site.

```kotlin
// INSTEAD OF: Timber.d("Key: $key")
// WE DO:
SecureLog.d("SecureSystem", "Simulated Check - Master Key is present: %s", appData.systemContext.masterCryptoKeyAesGcm)
```

The `SecureLog` class handles the `String.format` internally, ensuring that no `StringBuilder` is allocated in the calling function.

### 2. ProGuard / R8 Integration (`proguard-rules.pro`)
To ensure that absolutely zero memory is allocated for these logs in the production environment, we explicitly tell the R8 compiler that our custom `SecureLog` class has no side effects:

```proguard
-assumenosideeffects class com.hasantuncay.mobsec.secure.utils.SecureLog {
    public static void d(java.lang.String, java.lang.String, java.lang.Object[]);
    public static void e(java.lang.String, java.lang.String, java.lang.Object[]);
    public static void i(java.lang.String, java.lang.String, java.lang.Object[]);
    public static void w(java.lang.String, java.lang.String, java.lang.Object[]);
}
```

**The Result:**
When the `:app-secure` module is built in **Release Mode** (`minifyEnabled = true`), the R8 compiler analyzes the bytecode. Because of the `-assumenosideeffects` rule, it identifies that `SecureLog.d(...)` does nothing that affects the app state. It then **completely strips the entire line** from the compiled bytecode. 
No `StringBuilder` is created, no formatting occurs, and the sensitive master key is never converted to a plaintext String object in the RAM!
