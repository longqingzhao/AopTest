import com.plugin.gradle.kt.Version
import com.plugin.gradle.kt.Version.Test

plugins {
    id("com.plugin.gradle.library")
    id("com.plugin.gradle.total")
    alias(libs.plugins.gradle.ksp)
//    alias(libs.plugins.fly.aop)
}

android {
    namespace = "com.qianqi.di"
}

dependencies {
    with(Version.Android) {
        add(appcompat.first, appcompat.second)
    }
    with(Version.Kotlin) {
        add(reflect.first, reflect.second)
        add(stdlib.first, stdlib.second)
    }

    add(Version.DI.core.first, Version.DI.core.second)

    with(Version.Aop) {
        add(flyAop.first, flyAop.second)
        add(flyKsp.first, flyKsp.second)
        add(flyExtraAop.first, flyExtraAop.second)
    }

    with(Test) {
        add(junit.first, junit.second)
        add(androidJUnit.first, androidJUnit.second)
        add(espresso.first, espresso.second)
    }
}