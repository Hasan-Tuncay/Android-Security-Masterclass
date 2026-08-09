plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)
}

android {
    namespace = "com.hasantuncay.mobsec.secure"
    compileSdk = 37

    defaultConfig {
        applicationId = "com.hasantuncay.mobsec.secure"
        minSdk = 26
        targetSdk = 37
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    packaging {
        resources.excludes.add("META-INF/LICENSE.md")
        resources.excludes.add("META-INF/LICENSE")
    }
}

dependencies {
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    
    // Security & Cryptography
    implementation(libs.androidx.security.crypto)
    implementation(libs.tink.android)
    implementation(libs.bouncycastle.bcprov)
    implementation(libs.bouncycastle.bcpkix)
    
    // DataStore
    implementation(libs.androidx.datastore.preferences)
    implementation(libs.androidx.datastore)

    // Room & SQLCipher
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)
    ksp(libs.androidx.room.compiler)
    implementation(libs.sqlcipher)

    implementation(libs.okhttp.logging)
    implementation(libs.androidx.navigation3.runtime)
    implementation(libs.androidx.navigation3.ui)
    implementation(libs.timber)
    implementation(project(":common"))
    implementation(project(":features:maswe0001"))
    implementation(project(":features:maswe0006"))
    implementation(project(":features:maswe0007"))
    implementation(project(":features:maswe0008"))
    implementation(project(":features:maswe0009"))
    implementation(project(":features:maswe0010"))
    implementation(project(":features:maswe0011"))
    implementation(project(":features:maswe0012"))
    implementation(project(":features:maswe0013"))
    implementation(project(":features:maswe0014"))
    implementation(project(":features:maswe0015"))
    implementation(project(":features:maswe0016"))
    implementation(project(":features:maswe0017"))
    implementation(project(":features:maswe0018"))
    implementation(project(":features:maswe0019"))
    implementation(project(":features:maswe0020"))
    implementation(project(":features:maswe0021"))
    implementation(project(":features:maswe0022"))
    implementation(project(":features:maswe0023"))
    implementation(project(":features:maswe0024"))
    implementation(project(":features:maswe0025"))
    implementation(project(":features:maswe0026"))
    implementation(project(":features:maswe0027"))
    implementation(project(":features:maswe0028"))
    implementation(project(":features:maswe0029"))
    implementation(project(":features:maswe0030"))
    implementation(project(":features:maswe0031"))
    implementation(project(":features:maswe0032"))
    implementation(project(":features:maswe0033"))
    implementation(project(":features:maswe0034"))
    implementation(project(":features:maswe0035"))
    implementation(project(":features:maswe0036"))
    implementation(project(":features:maswe0037"))
    implementation(project(":features:maswe0038"))
    implementation(project(":features:maswe0039"))
    implementation(project(":features:maswe0040"))
    implementation(project(":features:maswe0041"))
    implementation(project(":features:maswe0042"))
    implementation(project(":features:maswe0043"))
    implementation(project(":features:maswe0044"))
    implementation(project(":features:maswe0045"))
    implementation(project(":features:maswe0046"))
    implementation(project(":features:maswe0047"))
    implementation(project(":features:maswe0048"))
    implementation(project(":features:maswe0049"))
    implementation(project(":features:maswe0050"))
    implementation(project(":features:maswe0051"))
    implementation(project(":features:maswe0052"))
    implementation(project(":features:maswe0053"))
    implementation(project(":features:maswe0054"))
    implementation(project(":features:maswe0055"))
    implementation(project(":features:maswe0056"))
    implementation(project(":features:maswe0057"))
    implementation(project(":features:maswe0058"))
    implementation(project(":features:maswe0059"))
    implementation(project(":features:maswe0060"))
    implementation(project(":features:maswe0061"))
    implementation(project(":features:maswe0062"))
    implementation(project(":features:maswe0063"))
    implementation(project(":features:maswe0064"))
    implementation(project(":features:maswe0065"))
    implementation(project(":features:maswe0066"))
    implementation(project(":features:maswe0067"))
    implementation(project(":features:maswe0068"))
    implementation(project(":features:maswe0069"))
    implementation(project(":features:maswe0070"))
    implementation(project(":features:maswe0071"))
    implementation(project(":features:maswe0072"))
    implementation(project(":features:maswe0073"))
    implementation(project(":features:maswe0074"))
    implementation(project(":features:maswe0075"))
    implementation(project(":features:maswe0076"))
    implementation(project(":features:maswe0077"))
    implementation(project(":features:maswe0078"))
    implementation(project(":features:maswe0005"))
    implementation(project(":features:maswe0004"))
    implementation(project(":features:maswe0003"))
    implementation(project(":features:maswe0002"))
    implementation(libs.errorprone.annotations)
    
    testImplementation(libs.junit)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
    debugImplementation(libs.androidx.compose.ui.tooling)
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
    implementation(libs.androidx.hilt.navigation.compose)
}