import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "me.nabeeeeel"
version = "1.0.1"

plugins {
    kotlin("jvm") version "1.4.10"
}

repositories {
    mavenCentral()
    jcenter()
    maven{
        url = uri("https://oss.sonatype.org/content/repositories/snapshots")
    }
}

dependencies {
    implementation("me.jakejmattson:DiscordKt:0.21.0-SNAPSHOT")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"

}