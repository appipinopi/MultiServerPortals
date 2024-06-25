plugins {
    id("java")
}

group = "com.example"
version = "1.0.0"

repositories {
    mavenCentral()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven("https://oss.sonatype.org/content/repositories/snapshots")
}

dependencies {
    compileOnly("org.spigotmc:spigot-api:1.16.5-R0.1-SNAPSHOT")
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

tasks.register<Copy>("copyPluginYml") {
    from("src/main/resources")
    include("plugin.yml")
    into("$buildDir/classes/java/main")
}

tasks.build {
    dependsOn("copyPluginYml")
}
