plugins {
    id(BuildPlugins.ANDROID_APPLICATION)
    kotlin(BuildPlugins.ANDROID)
}

android {
    namespace = AppConfig.NAMESPACE
    compileSdk = AppConfig.compileSdk
    defaultConfig {
        applicationId = AppConfig.APPLICATION_ID
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = BuildDependencyVersions.KOTLIN_COMPILER_EXTENSION_VERSION
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = BuildDependencyVersions.JVM_TARGET
    }
}

dependencies {
    implementation(project(BuildModules.SHARED_MODULE))

    addDependenciesForCompose()

    implementation(AppDependencies.COROUTINES_ANDROID)

    implementation(AppDependencies.KOIN_ANDROID_COMPOSE)

    implementation(AppDependencies.COIL)

    implementation(AppDependencies.NAVIGATION)

    implementation(AppDependencies.CONSTRAINT)
}