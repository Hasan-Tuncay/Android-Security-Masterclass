plugins {
    id("mobsec.android.feature")
}

android {
    namespace = "com.hasantuncay.mobsec.maswe0003"
}

dependencies {
    implementation(libs.androidx.security.crypto)
    implementation(libs.tink.android)
    implementation(libs.bouncycastle.bcprov)
    implementation(libs.bouncycastle.bcpkix)
    implementation(libs.androidx.datastore.preferences)
    implementation(libs.androidx.datastore)
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)
    ksp(libs.androidx.room.compiler)
    implementation(libs.sqlcipher)
}
