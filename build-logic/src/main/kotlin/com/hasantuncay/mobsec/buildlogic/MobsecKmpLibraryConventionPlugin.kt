package com.hasantuncay.mobsec.buildlogic

import com.android.build.api.dsl.KotlinMultiplatformAndroidLibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.findByType
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.compose.compiler.gradle.ComposeCompilerGradlePluginExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class MobsecKmpLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("org.jetbrains.kotlin.multiplatform")
                apply("com.android.kotlin.multiplatform.library")
                apply("org.jetbrains.kotlin.plugin.serialization")
                apply("com.android.lint")
            }

            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

            val kotlin = extensions.getByType<KotlinMultiplatformExtension>()
            with(kotlin) {
                jvmToolchain(17)
                
                // Add iOS targets if needed in the future
                iosArm64()
                iosSimulatorArm64()

                compilerOptions {
                    freeCompilerArgs.add("-Xexpect-actual-classes")
                }

                sourceSets.apply {
                    getByName("commonMain").dependencies {
                        implementation(libs.findLibrary("kotlin-stdlib").get())
                        api(libs.findLibrary("kotlinx-serialization-json").get())
                        api(libs.findLibrary("touchlab-kermit").get())
                    }
                    getByName("commonTest").dependencies {
                        implementation(libs.findLibrary("kotlin-test").get())
                        implementation(libs.findLibrary("kotlinx-coroutines-test").get())
                        implementation(libs.findLibrary("junit").get())
                    }
                }
            }

            val androidExtension = kotlin.extensions.findByType<KotlinMultiplatformAndroidLibraryExtension>()
                ?: extensions.findByType<KotlinMultiplatformAndroidLibraryExtension>()

            androidExtension?.apply {
                namespace = "com.hasantuncay.mobsec.${project.name.replace("-", "")}"
                compileSdk = 35
                minSdk = 26
                experimentalProperties["android.experimental.kmp.enableAndroidResources"] = true
                withHostTest {}
            }

            tasks.register("test") {
                dependsOn(tasks.matching { it.name == "allTests" || it.name == "testDebugUnitTest" })
            }
        }
    }
}
