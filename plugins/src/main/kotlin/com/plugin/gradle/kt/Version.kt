package com.plugin.gradle.kt

import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.api.internal.catalog.VersionCatalogView
import org.gradle.kotlin.dsl.getByType


object Version {

    private val Project.libs: VersionCatalogView
        get() = extensions.getByType<VersionCatalogsExtension>().named("libs") as VersionCatalogView

    private val getVersion: Project.(name: String) -> String =
        { name -> libs.findVersion(name).get().requiredVersion }

    @Suppress("unused")
    object Json {
        private const val VERSION = "2.10.1"
        val gson = "implementation" to "com.google.code.gson:gson:$VERSION"
    }

    @Suppress("unused")
    object Android {
        private const val DATASTORE_VERSION = "1.1.1"
        private const val LIFECYCLE = "2.8.7"
        private val Project.nav: String
            get() = getVersion("navigation")

        const val TARGET_SDK: Int = 35

        const val MIN_SDK = 21

        const val COMPILE_SDK = "35"

        val profile = "implementation" to "androidx.profileinstaller:profileinstaller:1.3.1"
        val core = "implementation" to "androidx.core:core-ktx:1.15.0"
        val activity = "implementation" to "androidx.activity:activity-ktx:1.9.3"
        val fragment = "implementation" to "androidx.fragment:fragment-ktx:1.8.5"
        val appcompat = "implementation" to "androidx.appcompat:appcompat:1.7.0"
        val material = "implementation" to "com.google.android.material:material:1.12.0"
        val constraintlayout =
            "implementation" to "androidx.constraintlayout:constraintlayout:2.2.0"
        val lifecycleViewModel =
            "implementation" to "androidx.lifecycle:lifecycle-viewmodel-ktx:${LIFECYCLE}"
        val lifecycleSavedstate =
            "implementation" to "androidx.lifecycle:lifecycle-viewmodel-savedstate:${LIFECYCLE}"
        val lifecycleRuntime =
            "implementation" to "androidx.lifecycle:lifecycle-runtime-ktx:${LIFECYCLE}"
        val lifecycleLiveData =
            "implementation" to "androidx.lifecycle:lifecycle-livedata-ktx:${LIFECYCLE}"
        val datastore = "implementation" to "androidx.datastore:datastore:$DATASTORE_VERSION"
        val datastorePreferences =
            "implementation" to "androidx.datastore:datastore-preferences:$DATASTORE_VERSION"
        val datastoreCore =
            "implementation" to "androidx.datastore:datastore-core:$DATASTORE_VERSION"
        val datastorePreferencesCore =
            "implementation" to "androidx.datastore:datastore-preferences-core:$DATASTORE_VERSION"

        val work = "implementation" to "androidx.work:work-runtime-ktx:2.10.0"
        val recycleView = "implementation" to "androidx.recyclerview:recyclerview:1.3.1"
        val recycleViewSelection =
            "implementation" to "androidx.recyclerview:recyclerview-selection:1.1.0"


        val Project.navFragment get() = "implementation" to "androidx.navigation:navigation-fragment:$nav"
        val Project.navFragmentKtx get() = "implementation" to "androidx.navigation:navigation-fragment-ktx:$nav"
        val Project.navUi get() = "implementation" to "androidx.navigation:navigation-ui:$nav"
        val Project.navUiKtx get() = "implementation" to "androidx.navigation:navigation-ui-ktx:$nav"
        val Project.navDynamic get() = "implementation" to "androidx.navigation:navigation-dynamic-features-fragment:$nav"

        val composeAX = "implementation" to "androidx.activity:activity-compose:1.9.3"
        val composeBom = "implementation" to "androidx.compose:compose-bom:2024.12.01"
        val composeUI = "implementation" to "androidx.compose.ui:ui"
        val composeUIGraphics = "implementation" to "androidx.compose.ui:ui-graphics"
        val composeUITooling = "implementation" to "androidx.compose.ui:ui-tooling"
        val composeUIPre = "implementation" to "androidx.compose.ui:ui-tooling-preview"
        val composeUITestManifest = "implementation" to "androidx.compose.ui:ui-test-manifest"
        val composeUITestJunit4 = "implementation" to "androidx.compose.ui:ui-test-junit4"
        val composeMaterial3 = "implementation" to "androidx.compose.material3:material3"

    }

    @Suppress("unused")
    object Aop {
        private val Project.aopVersion
            get() = getVersion("aop_version")

        val Project.flyAop
            get() = "api" to "io.github.FlyJingFish.AndroidAop:android-aop-core:$aopVersion"

        val Project.flyExtraAop
            get() = "api" to "io.github.FlyJingFish.AndroidAop:android-aop-extra:$aopVersion"

        val Project.flyKsp
            get() = "ksp" to "io.github.FlyJingFish.AndroidAop:android-aop-ksp:$aopVersion"

        val Project.flyProcess
            get() = "annotationProcessor" to "io.github.FlyJingFish.AndroidAop:android-aop-processor:$aopVersion"
    }

    @Suppress("unused")
    object Kotlin {
        private const val COROUTINES_VERSION = "1.7.3"

        val Project.reflect
            get() = "implementation" to "org.jetbrains.kotlin:kotlin-reflect:${getVersion("kotlin")}"

        val Project.bom
            get() = "implementation" to dependencies.platform(
                "org.jetbrains.kotlin:kotlin-bom:${
                    getVersion(
                        "kotlin"
                    )
                }"
            )

        val cor_jvm =
            "implementation" to "org.jetbrains.kotlinx:kotlinx-coroutines-core-jvm:$COROUTINES_VERSION"
        val cor =
            "implementation" to "org.jetbrains.kotlinx:kotlinx-coroutines-core:$COROUTINES_VERSION"
        val cor_ =
            "implementation" to "org.jetbrains.kotlinx:kotlinx-coroutines-android:$COROUTINES_VERSION"
        val Project.stdlib
            get() = "implementation" to "org.jetbrains.kotlin:kotlin-stdlib:${getVersion("kotlin")}"
    }

    @Suppress("unused")
    object Http {
        val retrofit = "implementation" to "com.squareup.retrofit2:retrofit:2.9.0"
        val retrofit_gson = "implementation" to "com.squareup.retrofit2:converter-gson:2.9.0"
        val okhttp_log = "implementation" to "com.squareup.okhttp3:logging-interceptor:4.11.0"
    }

    @Suppress("unused")
    object Glide {
        private const val VERSION = "4.15.1"
        val glide = "implementation" to "com.github.bumptech.glide:glide:$VERSION"
        val http = "implementation" to "com.github.bumptech.glide:okhttp3-integration:$VERSION"
    }

    @Suppress("unused")
    object Log {
        val log4j = "implementation" to "log4j:log4j:1.2.17"
        val slf4j = "implementation" to "org.slf4j:slf4j-api:2.0.7"
        val windpipe = "implementation" to "de.mindpipe.android:android-logging-log4j:1.0.3"
    }

    object Test {
        val junit = "testImplementation" to "junit:junit:4.13.2"
        val androidJUnit = "androidTestImplementation" to "androidx.test.ext:junit:1.1.5"
        val espresso = "androidTestImplementation" to "androidx.test.espresso:espresso-core:3.5.0"
    }

    @Suppress("unused")
    object Room {
        private const val ROOM_VERSION = "2.5.2"
        val runtime = "implementation" to "androidx.room:room-runtime:$ROOM_VERSION"
        val compiler = "annotationProcessor" to "androidx.room:room-compiler:$ROOM_VERSION"
        val compilerKsp = "ksp" to "androidx.room:room-compiler:$ROOM_VERSION"
        val compilerKapt = "kapt" to "androidx.room:room-compiler:$ROOM_VERSION"
        val ktx = "implementation" to "androidx.room:room-ktx:$ROOM_VERSION"
        val test = "testImplementation" to "androidx.room:room-testing:$ROOM_VERSION"
        val paging = "implementation" to "androidx.room:room-paging:$ROOM_VERSION"
    }

    object DI {
        private const val DI_VERSION = "7.24.1"
        val core = "implementation" to "org.kodein.di:kodein-di:${DI_VERSION}"
    }

    /**
     * room套件
     */
    @Suppress("unused")
    fun DependencyHandler.room() {
        with(Room) {
            add(runtime.first, runtime.second)
            add(compilerKsp.first, compilerKsp.second)
            add(ktx.first, ktx.second)
            add(test.first, test.second)
            add(paging.first, paging.second)
        }
    }


    /**
     * android compose套件
     */
    fun DependencyHandler.androidComposeSuite() {
        with(Android) {
            add(appcompat.first, appcompat.second)
            add(core.first, core.second)
            add(lifecycleRuntime.first, lifecycleRuntime.second)

            add(composeBom.first, platform(composeBom.second))

            add(composeAX.first, composeAX.second)
            add(composeUI.first, composeUI.second)

            add(composeUIGraphics.first, composeUIGraphics.second)
            add(composeUITooling.first, composeUITooling.second)
            add(composeUIPre.first, composeUIPre.second)

            add(composeMaterial3.first, composeMaterial3.second)

            add(composeUITestManifest.first, composeUITestManifest.second)
            add(composeUITestJunit4.first, composeUITestJunit4.second)
        }
        with(Test) {
            add(junit.first, junit.second)
            add(androidJUnit.first, androidJUnit.second)
            add(espresso.first, espresso.second)
        }
    }

}