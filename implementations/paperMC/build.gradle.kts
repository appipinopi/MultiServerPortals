plugins {
    kotlin("jvm") version "1.8.10"
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

group = "com.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://papermc.io/repo/repository/maven-public/")
}

dependencies {
    val minecraftVersions = listOf(
        "1.8",
        "1.8.3",
        "1.8.4",
        "1.8.5",
        "1.8.6",
        "1.8.7",
        "1.8.8",
        "1.9",
        "1.9.2",
        "1.9.4",
        "1.10",
        "1.10.2",
        "1.11",
        "1.11.1",
        "1.11.2",
        "1.12",
        "1.12.1",
        "1.12.2",
        "1.13",
        "1.13.1",
        "1.13.2",
        "1.14",
        "1.14.1",
        "1.14.2",
        "1.14.3",
        "1.14.4",
        "1.15",
        "1.15.1",
        "1.15.2",
        "1.16.1",
        "1.16.2",
        "1.16.3",
        "1.16.4",
        "1.16.5",
        "1.17",
        "1.17.1",
        "1.18",
        "1.18.1",
        "1.18.2",
        "1.19",
        "1.19.1",
        "1.19.2",
        "1.19.3",
        "1.19.4",
        "1.20",
        "1.20.1",
        "1.20.2",
        "1.20.3",
        "1.20.4",
        "1.20.5",
        "1.20.6",
        "1.21"
    )

    minecraftVersions.forEach { version ->
        implementation("io.papermc.paper:paper-api:$version-R0.1-SNAPSHOT")
    }
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }

    shadowJar {
        archiveClassifier.set("")
        archiveVersion.set("")
    }

    processResources {
        filesMatching("plugin.yml") {
            expand(project.properties)
        }
    }
}
