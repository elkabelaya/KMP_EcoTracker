import com.codingfeline.buildkonfig.compiler.FieldSpec.Type.STRING
import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidMultiplatformLibrary)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.serialization)
    alias(libs.plugins.sqldelight)
    alias(libs.plugins.buildkonfig)
}

kotlin {
    listOf(
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "Shared"
            isStatic = true
            linkerOpts("-lsqlite3")
        }
    }
    
    jvm()
    
    js {
        browser()
    }
    
    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser()
    }
    
    android {
       namespace = "ru.elkabelaya.ecotracker.shared"
       compileSdk = libs.versions.android.compileSdk.get().toInt()
       minSdk = libs.versions.android.minSdk.get().toInt()
    
       compilerOptions {
           jvmTarget = JvmTarget.JVM_11
       }
       androidResources {
           enable = true
       }
       withHostTest {
           isIncludeAndroidResources = true
       }
       withDeviceTestBuilder {
           sourceSetTreeName = "test"
       }.configure {
           instrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
       }
    }
    
    sourceSets {
        androidMain.dependencies {
            implementation(libs.compose.uiToolingPreview)
            implementation(libs.compose.uiTooling)
            implementation(libs.sqldelight.android.driver)
            implementation(libs.sqldelight.async)
            implementation(libs.ktor.client.android)
        }
        commonMain.dependencies {
            implementation(libs.compose.runtime)
            implementation(libs.compose.foundation)
            implementation(libs.compose.material3)
            implementation(libs.compose.ui)
            implementation(libs.compose.components.resources)
            implementation(libs.compose.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodelCompose)
            implementation(libs.androidx.lifecycle.runtimeCompose)
            implementation(libs.navigation.compose)
            implementation(libs.serialization.json)
            implementation(libs.compose.material.icons.extended)
            implementation(libs.koin.core)
            implementation(libs.koin.compose)
            implementation(libs.koin.compose.viewmodel)
            implementation(libs.sqldelight.runtime)
            implementation(libs.sqldelight.coroutines)
            implementation(libs.kotlinx.coroutines.core)
            implementation(libs.ktor.client.core)
            implementation(libs.ktor.client.content.negotiation)
            implementation(libs.ktor.serialization.kotlinx.json)
            implementation(libs.ktor.client.logging)
            implementation(libs.ktor.client.auth)
            implementation(libs.vico)

        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }

        webMain.dependencies {
            implementation(libs.wrappers.browser)
            implementation(libs.sqldelight.driver.webworker)
            implementation(npm("@sqlite.org/sqlite-wasm", "3.53.0-build1"))

            implementation(npm("@cashapp/sqldelight-sqljs-worker", libs.versions.sqlDelight.get()))
            implementation(npm("sql.js", libs.versions.sqljs.get()))

            implementation(devNpm("copy-webpack-plugin", libs.versions.copy.webpack.plugin.get()))
            
            implementation(libs.ktor.client.js)
        }

        nativeMain.dependencies {
            implementation(libs.ktor.client.darwin)
        }

        iosMain.dependencies {

            implementation(libs.sqldelight.native.driver)
        }

        jvmMain.dependencies {
            implementation(libs.sqldelight.driver.desktop)
            implementation(libs.ktor.client.cio)
        }
    }
}

sqldelight {
    databases {
        create("EcoTrackDatabase") {
            packageName = "ru.elkabelaya.ecotracker.db"
            generateAsync.set(true)
        }
    }
}

fun getEnvProperty(key: String): String {
    //для CI/CD
    System.getenv(key)?.let { return it }

    val envFile = rootProject.file(".env")
    if (envFile.exists()) {
        val envLines = envFile.readLines()
        for (line in envLines) {
            if (line.trim().startsWith("#") || !line.contains("=")) continue
            val parts = line.split("=", limit = 2)
            if (parts[0].trim() == key) return parts[1].trim().removeSurrounding("\"", "\"")
        }
    }

    return ""
}

buildkonfig {
    packageName = "generated.gradle.buildkonfig"

    defaultConfigs {
        buildConfigField(STRING, "API_URL", getEnvProperty("API_URL"))
    }
}