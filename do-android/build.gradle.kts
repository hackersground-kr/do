// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id(Plugins.application).version(Versions.android).apply(false)
    id(Plugins.library).version(Versions.android).apply(false)
    id(Plugins.kotlinAndroid).version(Versions.kotlinAndroid).apply(false)
    id("org.jetbrains.kotlin.jvm") version "1.8.20" apply false
}