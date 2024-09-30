import org.openapitools.generator.gradle.plugin.tasks.GenerateTask

plugins {
    kotlin("jvm") version "2.0.20"

    kotlin("plugin.serialization") version "2.0.20"

    // allows us to create generateApisGuru, a task that generates the code to
    // freely interop with the apis.guru API based on its OpenAPI spec.
    id("org.openapi.generator") version "7.8.0"
}

val generateApisGuru by tasks.creating(GenerateTask::class) {
    group = "openapi tools"
    generatorName = "kotlin" // http client
    library = "jvm-ktor" // makes sure we use ktor
    additionalProperties.putAll(
        mapOf(
            "serializationLibrary" to "jackson",
            "dateLibrary" to "kotlinx-datetime",
            "generateOneOfAnyOfWrappers" to "true",
            "artifactId" to "apis-guru",
        )
    )
    // path to the local OpenAPI file of apis.guru
    inputSpec = file("apisGuru.yaml").absolutePath
    packageName = "guru.apis.apisGuru"
    generateModelTests = false
    generateApiTests = false
    outputDir = file("genApisGuru").absolutePath
    generateModelDocumentation = false
    generateApiDocumentation = false
}

repositories {
    maven("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/dev/")
    mavenCentral()
}

dependencies {
    // this dependency is made available through settings.gradle.kts and holds the generated code
    implementation("guru.apis:apis-guru")

    implementation("org.jetbrains.kotlinx:dataframe:0.14.0-dev-3926")
    kotlinCompilerPluginClasspath("org.jetbrains.kotlinx.dataframe:compiler-plugin-all:0.14.0-dev-3926")
    testImplementation(kotlin("test"))

    implementation("io.ktor:ktor-client-core:2.3.9")
    implementation("io.ktor:ktor-client-cio:2.3.9")
    implementation("io.ktor:ktor-client-content-negotiation:2.3.9")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(11)
}

tasks.compileKotlin {
    compilerOptions {
        freeCompilerArgs.add("-Xlambdas=class")
        freeCompilerArgs.addAll("-P", "plugin:org.jetbrains.kotlinx.dataframe:path=${projectDir.absolutePath}")
        freeCompilerArgs.addAll(
            "-P",
            "plugin:org.jetbrains.kotlinx.dataframe:schemas=${
                layout.buildDirectory.file("generated").get().asFile.absolutePath
            }"
        )
    }
    compilerExecutionStrategy.set(org.jetbrains.kotlin.gradle.tasks.KotlinCompilerExecutionStrategy.IN_PROCESS)
}