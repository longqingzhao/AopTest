import com.plugin.gradle.kt.Version

plugins {
    alias(libs.plugins.android.dynamic.feature)
    alias(libs.plugins.gradle.android)
    id("com.plugin.gradle.total")
    alias(libs.plugins.gradle.ksp)
//    alias(libs.plugins.fly.aop)
}
android {
    namespace = "com.example.dynamicfeature"
    compileSdk = Version.Android.COMPILE_SDK.toInt()

    defaultConfig {
        minSdk = Version.Android.MIN_SDK
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation(project(":app"))

    with(Version) {
        androidComposeSuite()
    }
    with(Version.Kotlin) {
        add(reflect.first, reflect.second)
        add(stdlib.first, stdlib.second)
    }

    implementation(project(":base_di"))
}