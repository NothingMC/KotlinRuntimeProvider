import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.0"
    id("com.github.johnrengelman.shadow") version "7.0.0"
}

group = "io.github.nothingmc.exampleplugin"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.powernukkit:powernukkit:1.5.1.0-PN")
}

tasks.test {
    useJUnit()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = JavaVersion.VERSION_17.toString()
}

tasks {
    shadowJar {
        dependencies {
            exclude(dependency("org.powernukkit:powernukkit:1.5.1.0-PN"))
        }
        archiveClassifier.set("")
    }
}
