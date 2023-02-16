import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    val kotlinVersion = "1.6.10"
    val springBootVersion = "2.6.3"
    val springDependencyManagementVersion = "1.0.11.RELEASE"
    val ktlintVersion = "10.2.0"
    val googleProtobufVersion = "0.9.2"

    id("org.springframework.boot") version springBootVersion
    id("io.spring.dependency-management") version springDependencyManagementVersion
    id("org.jlleitschuh.gradle.ktlint") version ktlintVersion
    id("org.jlleitschuh.gradle.ktlint-idea") version ktlintVersion
    id("com.google.protobuf") version googleProtobufVersion
    kotlin("jvm") version kotlinVersion
    kotlin("plugin.spring") version kotlinVersion
    kotlin("plugin.jpa") version kotlinVersion
    kotlin("kapt") version kotlinVersion
}

allprojects {
    group = "com.gdgo.spring.template"
    version = "0.0.1-SNAPSHOT"

    repositories {
        mavenCentral()
    }
}

subprojects {
    val mockkVersion = "1.12.2"
    val kotestVersion = "5.0.3"

    apply(plugin = "idea")
    apply(plugin = "kotlin")
    apply(plugin = "kotlin-spring")
    apply(plugin = "kotlin-jpa")
    apply(plugin = "kotlin-kapt")
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "org.jlleitschuh.gradle.ktlint")
    apply(plugin = "org.jlleitschuh.gradle.ktlint-idea")
    apply(plugin = "com.google.protobuf")

    configure<io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension> {
        imports(
            delegateClosureOf<io.spring.gradle.dependencymanagement.dsl.ImportsHandler> {
                mavenBom("org.springframework.cloud:spring-cloud-dependencies:2021.0.0")
            }
        )
    }

    java {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "17"
        }
    }

    configurations {
        compileOnly {
            extendsFrom(configurations.annotationProcessor.get())
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }

    dependencies {
        implementation("org.springframework.boot:spring-boot-starter")
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

        annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")

        testImplementation("org.springframework.boot:spring-boot-starter-test") {
            exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
        }
        /* mockk */
        testImplementation("io.mockk:mockk:$mockkVersion")
        /* kotest */
        testImplementation("io.kotest:kotest-runner-junit5:$kotestVersion")
        testImplementation("io.kotest:kotest-assertions-core:$kotestVersion")
        testImplementation("io.kotest:kotest-property:$kotestVersion")
    }

    kotlin.sourceSets.main {
        kotlin.srcDir("$buildDir/generated/source/kapt/main")
    }

    tasks.bootJar { enabled = false }
    tasks.jar { enabled = true }
}

tasks.bootJar { enabled = false }
tasks.jar { enabled = true }
