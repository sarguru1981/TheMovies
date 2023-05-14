object BuildPlugins {
    const val ANDROID_APPLICATION = "com.android.application"
    const val ANDROID_LIBRARY = "com.android.library"
    const val ANDROID = "android"
    const val MULTIPLATFORM = "multiplatform"

    // SQLDelight
    const val SQLDELIGHT_GRADLE_PLUGIN = "com.squareup.sqldelight:gradle-plugin:${BuildDependencyVersions.SQLDELIGHT_VERSION}"
    const val SQLDELIGHT_PLUGIN = "com.squareup.sqldelight"

    // Serialization
    const val SERIALIZATION_PLUGIN = "org.jetbrains.kotlin:kotlin-serialization:${BuildDependencyVersions.SERIALIZE_PLUGIN_VERSION}"
    const val SERIALIZE_PLUGIN = "plugin.serialization"
}