plugins {
    `kotlin-dsl`
}

allprojects {
    val rootDirectory = rootProject.layout.buildDirectory.file(name).get()
    val file = rootDirectory.asFile.parentFile?.parentFile?.parentFile
    logger.info("name:${name} buildDir:${file?.path}")
    layout.buildDirectory.set(File(File(file, "build"), "configBuild"))
}

dependencies {
    compileOnly(embeddedKotlin("gradle-plugin"))
    implementation(gradleApi())
    implementation(gradleKotlinDsl())
    implementation(libs.gradlePlugin.android)
    implementation(libs.gradlePlugin.kotlin.android)
}