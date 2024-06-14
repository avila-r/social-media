val mainClass: String by project

plugins {

    kotlin("plugin.spring") version "1.9.24"
    kotlin("jvm") version "1.9.24"

    /*
     * Shadow jar's build plugin
     */
    id("com.github.johnrengelman.shadow") version "8.1.1"

    /*
     * Spring for Kotlin
     */
    id("org.springframework.boot") version "3.3.0"
    id("io.spring.dependency-management") version "1.1.5"

}

group = "com.avila"
version = "0.1"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    /*
     * Spring Boot's Starters
     */
        implementation("org.springframework.boot:spring-boot-starter-security")
        implementation("org.springframework.boot:spring-boot-starter-web")

        implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
        implementation("org.jetbrains.kotlin:kotlin-reflect")

    /*
     * Tests
     */
        // JUnit for Kotlin
        testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")

        // JUnit Vintage Engine support
        testRuntimeOnly("org.junit.platform:junit-platform-launcher")

        // Spring tests
        testImplementation("org.springframework.boot:spring-boot-starter-test")
        testImplementation("org.springframework.security:spring-security-test")

}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.shadowJar {
    manifest {
        attributes["Main-Class"] = mainClass
    }
}

tasks.jar {
     manifest {
         attributes["Main-Class"] = mainClass
     }
}
