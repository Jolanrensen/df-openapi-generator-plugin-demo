import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "2.0.20-dev-2972"
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenLocal()
    maven("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/dev/")
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlinx:dataframe:0.13.1-dev-3109")
    kotlinCompilerPluginClasspath("org.jetbrains.kotlinx.dataframe:compiler-plugin-all:0.13.1-dev-3109")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}

tasks.withType<KotlinCompile> {
    compilerOptions.languageVersion.set(org.jetbrains.kotlin.gradle.dsl.KotlinVersion.KOTLIN_2_0)
    kotlinOptions.jvmTarget = "1.8"
    compilerExecutionStrategy.set(org.jetbrains.kotlin.gradle.tasks.KotlinCompilerExecutionStrategy.IN_PROCESS)
    kotlinOptions.freeCompilerArgs += listOf("-P", "plugin:org.jetbrains.kotlinx.dataframe:path=${buildDir.absolutePath}")
}

application {
    mainClass.set("MainKt")
}