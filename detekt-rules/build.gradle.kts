import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.kotlin

plugins {
    alias(libs.plugins.kotlinJvm)
}

dependencies {
    compileOnly(libs.detekt.api)
}
