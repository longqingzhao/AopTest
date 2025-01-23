import com.plugin.gradle.kt.Version

plugins {
    id("com.plugin.gradle.total")
    alias(libs.plugins.gradle.android)
    alias(libs.plugins.gradle.agp.application)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.gradle.ksp)
    alias(libs.plugins.fly.aop)
}

android {

    namespace = "com.example.aoptest"
    compileSdk = Version.Android.COMPILE_SDK.toInt()
    defaultConfig {
        minSdk = Version.Android.MIN_SDK
        targetSdk = Version.Android.TARGET_SDK
        applicationId = "com.qianqi.programmer"
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    buildFeatures {
        compose = true
        aidl = true
        buildConfig = true
    }
    composeOptions {
//        kotlinCompilerExtensionVersion = "1.5.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    dynamicFeatures += setOf(":dynamicfeature")
}


tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    compilerOptions {
        freeCompilerArgs.addAll(
            "-opt-in=kotlin.RequiresOptIn",
            "-Xjvm-default=all"
        )
    }
}

dependencies {
    with(Version) {
        androidComposeSuite()
    }
    with(Version.Kotlin) {
        add(reflect.first, reflect.second)
        add(stdlib.first, stdlib.second)
    }
    implementation(project(":base2"))
}