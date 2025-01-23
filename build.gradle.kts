@file:Suppress("DSL_SCOPE_VIOLATION")

val logger: Logger = Logging.getLogger("rootProject")

tasks.register("clean", Delete::class) {
    delete(layout.buildDirectory)
}

tasks.register("JavaCompile", JavaCompile::class) {
    this.options.encoding = "UTF-8"
}

allprojects {
    val file = rootProject.layout.buildDirectory.file(name).get().asFile
    logger.info("name:${name} buildDir:${file.path}")
    layout.buildDirectory.set(file)
}

plugins {
    id("com.plugin.gradle.library") apply false
    id("com.plugin.gradle.total") apply false
    alias(libs.plugins.gradle.android) apply false
    alias(libs.plugins.gradle.agp.application) apply false
    alias(libs.plugins.gradle.agp.library) apply false
    alias(libs.plugins.gradle.navigation) apply false
    alias(libs.plugins.compose.compiler) apply false
    id("com.github.ben-manes.versions") version "0.51.0"
    alias(libs.plugins.gradle.ksp) apply false
    alias(libs.plugins.fly.aop) apply true
    alias(libs.plugins.android.dynamic.feature) apply false
}