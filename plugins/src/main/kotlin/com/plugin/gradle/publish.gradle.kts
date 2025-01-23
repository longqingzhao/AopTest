package com.plugin.gradle

import com.plugin.gradle.kt.getAllNeedDependency
import groovy.util.Node
import groovy.util.NodeList


plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    `maven-publish`
}

android {
    publishing {
        singleVariant("debug") {
            this.withSourcesJar()
        }
    }
}

publishing {
    publications {
        afterEvaluate {
            register<MavenPublication>("release") {
                from(components["release"])
                groupId = android.namespace
                artifactId = android.namespace?.split(".")?.last()
                version = "111"

                pom {
                    withXml {
                        val nodeList = asNode().get("dependencies") as NodeList
                        val allNeed = getAllNeedDependency()
                        nodeList.forEach { node ->
                            if (node is Node) {
                                node.children().forEach { childNode ->
                                    if (childNode is Node) {
                                        val groupIdStr = (childNode["groupId"] as NodeList).text()!!
                                        val artifactIdStr =
                                            (childNode["artifactId"] as NodeList).text()!!
                                        val scopeNodeList = (childNode["scope"] as NodeList)
                                        val scope = scopeNodeList.text()!!
                                        if (
                                            allNeed.any {
                                                it.contains(groupIdStr) &&
                                                        it.contains(artifactIdStr) &&
                                                        !scope.contains("compile")
                                            }
                                        ) {
                                            ((scopeNodeList[0] as Node).value() as NodeList).clear()
                                            ((scopeNodeList[0] as Node).value() as NodeList).add("compile")
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

            }
        }
    }
    repositories {
        maven {
            isAllowInsecureProtocol = true
            setUrl("http://...")
            credentials {
                username = "..."
                password = "..."
            }
        }
    }
}