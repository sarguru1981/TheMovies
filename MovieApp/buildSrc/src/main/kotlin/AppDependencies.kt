object AppDependencies {

    const val COMPOSE_UI = "androidx.compose.ui:ui:${BuildDependencyVersions.COMPOSE_VERSION}"
    const val COMPOSE_UI_TOOLING = "androidx.compose.ui:ui-tooling:${BuildDependencyVersions.COMPOSE_VERSION}"
    const val COMPOSE_UI_TOOLING_PREVIEW = "androidx.compose.ui:ui-tooling-preview:${BuildDependencyVersions.COMPOSE_VERSION}"
    const val COMPOSE_FOUNDATION = "androidx.compose.foundation:foundation:${BuildDependencyVersions.COMPOSE_VERSION}"
    const val COMPOSE_MATERIAL = "androidx.compose.material:material:${BuildDependencyVersions.COMPOSE_VERSION}"
    const val COMPOSE_ACTIVITY = "androidx.activity:activity-compose:${BuildDependencyVersions.COMPOSE_ACTIVITY_VERSION}"

    //SQLDelight
    const val SQLDELIGHT_COMMON = "com.squareup.sqldelight:runtime:${BuildDependencyVersions.SQLDELIGHT_VERSION}"
    const val SQLDELIGHT_ANDROID = "com.squareup.sqldelight:android-driver:${BuildDependencyVersions.SQLDELIGHT_VERSION}"
    const val SQLDELIGHT_IOS = "com.squareup.sqldelight:native-driver:${BuildDependencyVersions.SQLDELIGHT_VERSION}"

    //Coroutines
    const val SQLDELIGHT_COROUTINES = "com.squareup.sqldelight:coroutines-extensions:${BuildDependencyVersions.SQLDELIGHT_VERSION}"
    const val KOTLINX_COROUTINES = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${BuildDependencyVersions.COROUTINES_VERSION}"

    //Coroutines - Android
    const val COROUTINES_ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${BuildDependencyVersions.COROUTINES_VERSION}"

    //Ktor
    const val KTOR_CLIENT_CORE = "io.ktor:ktor-client-core:${BuildDependencyVersions.KTOR_VERSION}"
    const val KTOR_CONTENT = "io.ktor:ktor-client-content-negotiation:${BuildDependencyVersions.KTOR_VERSION}"
    const val KTOR_SERIALIZATION_JSON = "io.ktor:ktor-serialization-kotlinx-json:${BuildDependencyVersions.KTOR_VERSION}"
    const val KTOR_LOGGING = "io.ktor:ktor-client-logging:${BuildDependencyVersions.KTOR_VERSION}"
    const val KTOR_CLIENT_JSON = "io.ktor:ktor-client-json:${BuildDependencyVersions.KTOR_VERSION}"

    //Ktor-Android
    const val KTOR_CLIENT_OKHTTP = "io.ktor:ktor-client-android:${BuildDependencyVersions.KTOR_VERSION}"

    //Ktor-IOS
    const val KTOR_CLIENT_IOS = "io.ktor:ktor-client-ios:${BuildDependencyVersions.KTOR_VERSION}"

    //Others
    const val KOTLIN_SERIALIZE = "org.jetbrains.kotlinx:kotlinx-serialization-core:${BuildDependencyVersions.SERIALIZE_VERSION}"

    //Koin
    const val KOIN_ANDROID = "io.insert-koin:koin-android:${BuildDependencyVersions.KOIN_VERSION}"
    const val KOIN_CORE = "io.insert-koin:koin-core:${BuildDependencyVersions.KOIN_VERSION}"
    const val KOIN_ANDROID_COMPOSE = "io.insert-koin:koin-androidx-compose:${BuildDependencyVersions.KOIN_COMPOSE_VERSION}"

    //DataStore
    const val ANDROID_PREF_DATASTORE = "androidx.datastore:datastore-preferences:${BuildDependencyVersions.DATASTORE_VERSION}"

    //GSON
    const val GSON = "com.google.code.gson:gson:${BuildDependencyVersions.GSON_VERSION}"

    //MOKO MVVM
    const val MOKO_MVVM = "dev.icerock.moko:mvvm-core:${BuildDependencyVersions.MOKO_MVVM_VERSION}"

    //COIL
    const val COIL = "io.coil-kt:coil-compose:${BuildDependencyVersions.COIL_VERSION}"

    //NAVIGATION
    const val NAVIGATION = "androidx.navigation:navigation-compose:${BuildDependencyVersions.NAVIGATION_VERSION}"

    //CONSTRAINT
    const val CONSTRAINT = "androidx.constraintlayout:constraintlayout-compose:${BuildDependencyVersions.CONSTRAINT_VERSION}"
}