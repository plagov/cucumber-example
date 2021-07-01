plugins {
  id("org.jetbrains.kotlin.jvm") version "1.5.20"
}

val cucumberVersion = "6.10.4"

repositories {
  jcenter()
  mavenCentral()
}

dependencies {
  implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
  implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

  implementation("io.kotlintest:kotlintest-runner-junit5:3.4.2")
  implementation("com.google.inject:guice:5.0.1")

  implementation("io.cucumber:cucumber-java:$cucumberVersion")
  implementation("io.cucumber:cucumber-junit:$cucumberVersion")
  implementation("io.cucumber:cucumber-guice:$cucumberVersion")

  implementation("org.testcontainers:selenium:1.15.3")
  implementation("com.codeborne:selenide:5.22.2")
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

tasks.withType<Test> {
  useJUnitPlatform()
  systemProperty("cucumber.filter.tags", System.getProperty("tags"))
}
