# ProGuard / R8 Rules for :app-attacker
# Malicious POC / Adversary Simulator

-keepattributes SourceFile,LineNumberTable

# Ensure Hilt / Navigation3 reflection and entry points are preserved if obfuscated
-keep class com.hasantuncay.mobsec.attacker.** { *; }
