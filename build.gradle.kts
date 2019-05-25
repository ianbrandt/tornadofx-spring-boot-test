import org.gradle.api.JavaVersion.*
import org.gradle.api.tasks.testing.logging.TestLogEvent.*
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	kotlin("jvm") version "1.3.31"
	id("org.springframework.boot") version "2.1.5.RELEASE"
	id("org.jetbrains.kotlin.plugin.spring") version "1.3.31"
	id("org.unbroken-dome.test-sets") version "2.1.1"
	id("com.github.ben-manes.versions") version "0.21.0"
}

repositories {
	mavenCentral()
	jcenter()
}

testSets {
	"integrationTest" {
		dirName = "it"
	}
}

dependencies {
	val coroutinesVersion = "1.2.1"
	val junitVersion = "5.4.2"
	val springVersion = "5.1.7.RELEASE"
	val springBootVersion = "2.1.5.RELEASE"

	implementation(kotlin("stdlib"))
	implementation(kotlin("stdlib-jdk8"))
	implementation(kotlin("reflect"))
	implementation("javax.inject:javax.inject:1")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-javafx:$coroutinesVersion")
	implementation("org.springframework.boot:spring-boot-starter:$springBootVersion")
	implementation("no.tornado:tornadofx:1.7.19")
	testImplementation("org.assertj:assertj-core:3.12.2")
	testImplementation("org.junit.jupiter:junit-jupiter:$junitVersion")
	testImplementation("io.mockk:mockk:1.9.3")
	"integrationTestImplementation"("org.springframework:spring-test:$springVersion")
	"integrationTestImplementation"("org.springframework.boot:spring-boot-test:$springBootVersion")
	"integrationTestImplementation"("org.testfx:testfx-junit5:4.0.15-alpha")
	testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
}

java {
	sourceCompatibility = VERSION_1_8
	targetCompatibility = VERSION_1_8
}

tasks {

	withType<KotlinCompile> {
		kotlinOptions.jvmTarget = VERSION_1_8.toString()
	}

	withType<Test> {
		useJUnitPlatform()
		testLogging {
			showStandardStreams = true
			events(PASSED, SKIPPED, FAILED, STANDARD_OUT, STANDARD_ERROR)
		}
	}

	check {
		dependsOn("integrationTest")
	}

	getByName<Wrapper>("wrapper") {
		gradleVersion = "5.4.1"
		distributionType = Wrapper.DistributionType.ALL
	}
}
