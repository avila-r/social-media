val mainClass: String by project

plugins {
	id("org.springframework.boot") version "3.3.0"
	id("io.spring.dependency-management") version "1.1.5"
	kotlin("plugin.jpa") version "1.9.24"
	kotlin("jvm") version "1.9.24"
	kotlin("plugin.spring") version "1.9.24"

	/*
     * Shadow jar's build plugin
     */
	id("com.github.johnrengelman.shadow") version "8.1.1"
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
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")

	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")

	/*
     * PostgreSQL
     */
	implementation("org.postgresql:postgresql:42.7.3")

	/*
     * Tests
     */
		// JUnit for Kotlin
		testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")

		// JUnit Vintage Engine support
		testRuntimeOnly("org.junit.platform:junit-platform-launcher")

		// AssertJ
		testImplementation("org.assertj:assertj-core")

		// Mockito
		testImplementation("org.mockito:mockito-core")

		// Test datasource
		testImplementation("com.h2database:h2")

		// Spring tests
		testImplementation("org.springframework.boot:spring-boot-starter-test")
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
