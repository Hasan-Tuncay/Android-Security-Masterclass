# MASTG-BEST-0003: Data Class Sanitization (toString Redaction)

## 📌 Overview
This scenario demonstrates the official Android Security recommendation for preventing accidental **Log Info Disclosure**. Even if logging interceptors and ProGuard rules are configured correctly, a developer might accidentally log an entire domain object using string interpolation (e.g., `Log.d("Dump", userData.toString())`).

If standard Kotlin `data class` structures are used, the compiler automatically generates a `toString()` method that dumps all properties of the object in plaintext.

## ❌ Vulnerable Implementation
In a standard, unredacted data class:

```kotlin
data class PciDssData(
    val primaryAccountNumber: String,
    val cardVerificationCode: String
)

fun logData() {
    val data = PciDssData("4532111122223333", "123")
    
    // Developer accidentally leaves this in the code
    Log.d("SecurityTag", "User Data: $data")
    
    // OUTPUT IN LOGCAT: 
    // User Data: PciDssData(primaryAccountNumber=4532111122223333, cardVerificationCode=123)
}
```

This leads to a catastrophic data breach, exposing PCI-DSS data directly to the system Logcat.

## ✅ Secure Implementation (`:common`)
Following the official Android documentation, the most robust "Developer-Proof" mitigation is to explicitly override the `toString()` method in all sensitive domain models.

We implemented this across our highly sensitive classes in the `:common` module (e.g., `GdprPiiData`, `PciDssData`, `SystemData`).

### Secure Code Example
```kotlin
data class PciDssData(
    val primaryAccountNumber: String,
    val cardVerificationCode: String
) {
    /** 
     * OFFICIAL ANDROID SECURITY BEST PRACTICE:
     * Returns a redacted value to avoid accidental inclusion in logs if a developer 
     * inadvertently calls Log.d("Data", cardData.toString()).
     */
    override fun toString() = "[REDACTED_PCI_DSS_DATA]"
}
```

Now, even if a junior developer accidentally calls `Log.d("SecurityTag", "User Data: $data")`, the output will safely be:
```
User Data: [REDACTED_PCI_DSS_DATA]
```

This creates an impenetrable domain layer where the objects themselves refuse to leak their internal state.
