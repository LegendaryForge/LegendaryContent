plugins {
    `java-library`
}

repositories {
    mavenCentral()
}

dependencies {
    // Composite build substitution will replace this with the included LegendaryCore build.
    implementation("com.example:LegendaryCore:1.0.0")
implementation("com.example:Legendary:1.0.0")

    testImplementation(platform("org.junit:junit-bom:5.10.2"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(25))
    }
}
