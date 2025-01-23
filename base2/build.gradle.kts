import com.plugin.gradle.kt.Version
import com.plugin.gradle.kt.Version.Test

plugins {
    id("com.plugin.gradle.library")
    id("com.plugin.gradle.total")
    alias(libs.plugins.gradle.ksp)
}

android {
    namespace = "com.qianqi.base2"
}

dependencies {
    with(Version.Kotlin) {
        add(reflect.first, reflect.second)
        add(stdlib.first, stdlib.second)
    }

    with(Test) {
        add(junit.first, junit.second)
        add(androidJUnit.first, androidJUnit.second)
        add(espresso.first, espresso.second)
    }

    api(project(":base_di"))
}