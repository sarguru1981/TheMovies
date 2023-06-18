plugins {
    //trick: for the same plugin versions in all sub-modules
    id(BuildPlugins.ANDROID_APPLICATION).version(BuildDependencyVersions.ANDROID_APP_LIBRARY_VERSION).apply(false)
    id(BuildPlugins.ANDROID_LIBRARY).version(BuildDependencyVersions.ANDROID_APP_LIBRARY_VERSION).apply(false)
    kotlin(BuildPlugins.ANDROID).version(BuildDependencyVersions.ANDROID_MULTIPLATFORM_VERSION).apply(false)
    kotlin(BuildPlugins.MULTIPLATFORM).version(BuildDependencyVersions.ANDROID_MULTIPLATFORM_VERSION).apply(false)
}

buildscript {

    dependencies {
        classpath (BuildPlugins.SQLDELIGHT_GRADLE_PLUGIN)
        classpath (BuildPlugins.SERIALIZATION_PLUGIN)
        classpath ("org.jlleitschuh.gradle:ktlint-gradle:11.3.2")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
