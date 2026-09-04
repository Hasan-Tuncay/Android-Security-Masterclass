plugins {
    `kotlin-dsl`
}

dependencies {
    implementation(libs.android.gradlePlugin)
    implementation(libs.kotlin.gradlePlugin)
    implementation(libs.compose.compiler.gradlePlugin)
    implementation(libs.ksp.gradlePlugin)
    implementation(libs.hilt.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("mobsecAndroidLibrary") {
            id = "mobsec.android.library"
            implementationClass = "com.hasantuncay.mobsec.buildlogic.AndroidLibraryConventionPlugin"
        }
        register("mobsecAndroidFeature") {
            id = "mobsec.android.feature"
            implementationClass = "com.hasantuncay.mobsec.buildlogic.AndroidFeatureConventionPlugin"
        }
        register("mobsecAndroidApplication") {
            id = "mobsec.android.application"
            implementationClass = "com.hasantuncay.mobsec.buildlogic.AndroidApplicationConventionPlugin"
        }
    }
}
