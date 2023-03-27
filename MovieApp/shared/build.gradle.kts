plugins {
    kotlin(BuildPlugins.MULTIPLATFORM)
    id(BuildPlugins.ANDROID_LIBRARY)
    id(BuildPlugins.SQLDELIGHT_PLUGIN)
}

kotlin {
    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = BuildDependencyVersions.JVM_TARGET
            }
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(AppDependencies.SQLDELIGHT_COMMON)
                implementation(AppDependencies.SQLDELIGHT_COROUTINES)
                implementation(AppDependencies.KOTLINX_COROUTINES)
                implementation(AppDependencies.KTOR_CLIENT_CORE)
                implementation(AppDependencies.KTOR_CONTENT)
                implementation(AppDependencies.KTOR_SERIALIZATION_JSON)
                implementation(AppDependencies.KTOR_LOGGING)
                implementation(AppDependencies.KOTLIN_SERIALIZE)

            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(AppDependencies.SQLDELIGHT_ANDROID)
                implementation(AppDependencies.KTOR_CLIENT_OKHTTP)
            }
        }
        val androidUnitTest by getting
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
            dependencies {
                implementation(AppDependencies.SQLDELIGHT_IOS)
                implementation(AppDependencies.KTOR_CLIENT_DARWIN)
            }
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

sqldelight {
    database(AppConfig.SQLDELIGHT_DB_NAME) {
        packageName = AppConfig.SQLDELIGHT_DB_PACKAGE_NAME
        sourceFolders = listOf(AppConfig.SQLDELIGHT_DB_SOURCESET)
    }
}

android {
    namespace = AppConfig.NAMESPACE
    compileSdk = AppConfig.compileSdk
    defaultConfig {
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
    }
}