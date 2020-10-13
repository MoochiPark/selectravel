import org.jetbrains.kotlin.gradle.tasks.KotlinCompile


object Version {
//  const val springBoot = "2.3.4.RELEASE"
//  const val springDependencyManagement = "1.0.10.RELEASE"
//  const val kotlinPlugin = "1.4.10"
  const val queryDsl = "4.4.0"
}


plugins {
  id("org.springframework.boot") version "2.3.4.RELEASE"
  id("io.spring.dependency-management") version "1.0.10.RELEASE"
  kotlin("jvm") version "1.4.10"
  kotlin("plugin.spring") version "1.4.10"
  kotlin("plugin.jpa") version "1.4.10"
  kotlin("kapt") version "1.4.10"

}

allprojects {
  group = "io.wisoft.daewon"
  version = "2020.41.0"

  repositories {
    google()
    jcenter()
    mavenCentral()
  }
}

dependencies {
  implementation("org.springframework.boot:spring-boot-starter-data-jpa")
  implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
  implementation("org.springframework.boot:spring-boot-starter-web")
  implementation("org.springframework.boot:spring-boot-starter-webflux")
  implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
  implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
  implementation("org.jetbrains.kotlin:kotlin-reflect")
  implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
  implementation("com.querydsl:querydsl-jpa:4.2.1")
  implementation("org.modelmapper:modelmapper:2.3.7")
  implementation("org.postgresql:postgresql:42.2.12")
  kapt("com.querydsl:querydsl-apt:${Version.queryDsl}:jpa")

  runtimeOnly("org.springframework.boot:spring-boot-devtools")
  kapt("org.springframework.boot:spring-boot-configuration-processor")
  kapt(group = "com.querydsl", name = "querydsl-apt", classifier = "jpa")
  testImplementation("org.springframework.boot:spring-boot-starter-test") {
    exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
  }
  testImplementation("io.projectreactor:reactor-test")
}

sourceSets["main"].withConvention(org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet::class) {
  kotlin.srcDir("$buildDir/generated/source/kapt/main")
}

tasks.withType<Test> {
  useJUnitPlatform()
  testLogging {
    events("passed", "skipped", "failed")
  }
}

tasks.withType<KotlinCompile> {
  kotlinOptions {
    freeCompilerArgs = listOf("-Xjsr305=strict")
    jvmTarget = "11"
  }
}

tasks {
  compileTestKotlin {
    kotlinOptions {
      freeCompilerArgs = listOf("-Xjsr305=strict")
      jvmTarget = "11"
    }
  }
}

tasks.withType<Wrapper> {
  gradleVersion = "6.6.1"
  distributionType = Wrapper.DistributionType.BIN
}