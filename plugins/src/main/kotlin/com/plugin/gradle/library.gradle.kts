package com.plugin.gradle

import com.plugin.gradle.kt.Version

plugins {
    id("org.jetbrains.kotlin.android")
    id("com.android.library")
}

android {
    compileSdk = Version.Android.COMPILE_SDK.toInt()
    defaultConfig {
        minSdk = Version.Android.MIN_SDK
        lint.targetSdk = Version.Android.TARGET_SDK
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_11)
        targetCompatibility(JavaVersion.VERSION_11)
    }

    kotlinOptions {
        jvmTarget = "11"
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    compilerOptions {
        freeCompilerArgs.addAll(
            "-opt-in=kotlin.RequiresOptIn",
            "-Xjvm-default=all"
        )
    }
}