plugins {
    id("org.jetbrains.kotlin.jvm") version "1.3.61"
}

val cucumberVersion = "4.8.0"

repositories {
    jcenter()
    mavenCentral()
}

dependencies {
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    implementation("io.kotlintest:kotlintest-runner-junit5:3.4.2")
    implementation("com.google.inject:guice:4.2.2")

    implementation("io.cucumber:cucumber-java:$cucumberVersion")
    implementation("io.cucumber:cucumber-junit:$cucumberVersion")
    implementation("io.cucumber:cucumber-guice:$cucumberVersion")

    implementation("org.testcontainers:selenium:1.12.4")
    implementation("com.codeborne:selenide:5.6.0")
}

val cucumberRuntime by configurations.creating {
    extendsFrom(configurations["testImplementation"])
}

task("cucumber") {
    dependsOn("assemble", "compileTestKotlin")
    doLast {
        javaexec {
            main = "io.cucumber.core.cli.Main"
            classpath = cucumberRuntime + sourceSets.main.get().output + sourceSets.test.get().output
            args = listOf("--plugin", "pretty", "--glue", "io.plagov.steps", "src/test/resources")
        }
    }
}

tasks.withType<Test>{
    useJUnitPlatform()
}
