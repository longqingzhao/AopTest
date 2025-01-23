package com.plugin.gradle

import com.plugin.gradle.kt.Version


plugins {
    base
}

configurations.all {
    resolutionStrategy {
        with(Version.Kotlin) {
        }
    }
}