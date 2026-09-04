plugins {
    id("mobsec.android.application")
}

android {
    namespace = "com.hasantuncay.mobsec.attacker"

    defaultConfig {
        applicationId = "com.hasantuncay.mobsec.attacker"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    implementation(libs.androidx.compose.material.icons.extended)
    implementation(libs.androidx.navigation3.runtime)
    implementation(libs.androidx.navigation3.ui)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
}
