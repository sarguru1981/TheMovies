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
}