package com.plugin.gradle.kt

import org.gradle.api.Project
import org.gradle.kotlin.dsl.extra
import java.text.SimpleDateFormat
import java.util.*

fun getDate(): String =
    SimpleDateFormat("yyyy/MM/dd.HH:mm:ss.SSS", Locale.CHINESE).format(Date())


fun Project.addAllNeedDependency(name: String) {
    val all = (extra[ALL_DEPENDENCY] as? List<*>)?.map { "$it" } ?: emptyList()
    val newData = ArrayList<String>()
    newData.addAll(all)
    newData.add(name)
    extra[ALL_DEPENDENCY] = newData
}

fun Project.getAllNeedDependency(): List<String> {
    return (extra[ALL_DEPENDENCY] as? List<*>)?.map { "$it" } ?: emptyList()
}
