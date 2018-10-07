import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.0-rc-146"
    id("org.springframework.boot") version "2.0.5.RELEASE"
}

apply {
    plugin("io.spring.dependency-management")
}

buildscript {
    val kotlinVersion = "1.3.0-rc-146"
    extra["kotlin_version"] = kotlinVersion

    repositories {
        jcenter()
        mavenCentral()
        maven("https://repo.spring.io/milestone")
        maven("http://dl.bintray.com/kotlin/kotlin-eap")
        maven("https://jcenter.bintray.com")
    }
    dependencies {
        classpath(
            "org.springframework.boot:spring-boot-gradle-plugin:2.0.5" +
                    ".RELEASE")
        classpath("org.jetbrains.kotlin:kotlin-allopen:$kotlinVersion")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
        classpath("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion")
        classpath("org.jetbrains.kotlin:kotlin-reflect")
        classpath("org.jetbrains.kotlin:kotlin-test:$kotlinVersion")
        classpath("org.jetbrains.kotlin:kotlin-test-junit5:$kotlinVersion")
        classpath("org.jetbrains.kotlin:kotlin-noarg:$kotlinVersion")
    }
}

group = "com.improve_future"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    jcenter()
    maven("https://repo.spring.io/milestone")
    maven("http://dl.bintray.com/kotlin/kotlin-eap")
    maven("https://jcenter.bintray.com")
}

dependencies {
    val kotlinVersion = extra["kotlin_version"] as String
    compile(kotlin("stdlib-jdk8"))
    testCompile("org.jetbrains.kotlin:kotlin-test:$kotlinVersion")
    testCompile("org.jetbrains.kotlin:kotlin-test-junit5:$kotlinVersion")
    //compile("org.springframework.boot:spring-boot-starter-web")
    //compile("org.springframework.boot:spring-boot-starter-security")
    compile("org.springframework.boot:spring-boot-starter-webflux")
    compile("org.jetbrains.kotlin:kotlin-reflect")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}