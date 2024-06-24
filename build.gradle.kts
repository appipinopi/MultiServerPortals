plugins {
    id("java")
}

group = "com.example"
version = "1.0.0"

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    implementation("org.spigotmc:spigot-api:1.16.5-R0.1-SNAPSHOT")
}

tasks {
    jar {
        from(configurations.compileClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
        duplicatesStrategy = DuplicatesStrategy.INCLUDE
        manifest {
            attributes["Main-Class"] = "com.example.multiserverportals.PaperMain"
        }
        from("src/main/resources") {
            include("plugin.yml")
            include("config.yml")
        }
    }
}
