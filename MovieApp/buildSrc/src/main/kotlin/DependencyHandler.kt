import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler


fun DependencyHandler.implementation(dependencyNotation: String): Dependency? =
    add("implementation", dependencyNotation)


fun DependencyHandler.api(dependencyNotation: String): Dependency? =
    add("api", dependencyNotation)


fun DependencyHandler.kapt(dependencyNotation: String): Dependency? =
    add("kapt", dependencyNotation)


fun DependencyHandler.debugImplementation(dependencyNotation: String): Dependency? =
    add("debugImplementation", dependencyNotation)


fun DependencyHandler.testImplementation(dependencyNotation: String): Dependency? =
    add("testImplementation", dependencyNotation)


fun DependencyHandler.androidTestImplementation(dependencyNotation: String): Dependency? =
    add("androidTestImplementation", dependencyNotation)

fun DependencyHandler.addDependenciesForCompose() {
    implementation(AppDependencies.COMPOSE_UI)
    implementation(AppDependencies.COMPOSE_MATERIAL)
    implementation(AppDependencies.COMPOSE_UI_TOOLING)
    implementation(AppDependencies.COMPOSE_UI_TOOLING_PREVIEW)
    implementation(AppDependencies.COMPOSE_FOUNDATION)
    implementation(AppDependencies.COMPOSE_ACTIVITY)
}