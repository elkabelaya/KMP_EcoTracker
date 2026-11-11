plugins {
    // this is necessary to avoid the plugins to be loaded multiple times
    // in each subproject's classloader
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.androidMultiplatformLibrary) apply false
    alias(libs.plugins.composeMultiplatform) apply false
    alias(libs.plugins.composeCompiler) apply false
    alias(libs.plugins.kotlinJvm) apply false
    alias(libs.plugins.kotlinMultiplatform) apply false
    alias(libs.plugins.serialization) apply false
    alias(libs.plugins.buildkonfig) apply false
    alias(libs.plugins.detekt)
}

detekt {
    source.setFrom(
        "shared/src/commonMain/kotlin",
        "shared/src/androidMain/kotlin",
        "shared/src/iosMain/kotlin",
        "shared/src/jsMain/kotlin",
        "shared/src/jvmMain/kotlin",
        "shared/src/nativeMain/kotlin",
        "shared/src/wasmJsMain/kotlin",
        "shared/src/webMain/kotlin"
    )
    config.setFrom(files("$rootDir/config/detekt/detekt.yml"))
    buildUponDefaultConfig = true
}

dependencies {
    detektPlugins(project(":detekt-rules"))
    detektPlugins(libs.detekt.formatting)
}

tasks.register<Exec>("installGitHooks") {
    description = "Настраивает Git на использование хуков из папки .githooks"
    group = "git hooks"
    commandLine("git", "config", "core.hooksPath", ".githooks")
}

tasks.matching { it.name == "prepareKotlinBuildScriptModel" }.configureEach {
    dependsOn("installGitHooks")
}