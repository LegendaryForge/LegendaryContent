plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

rootProject.name = "LegendaryContent"

includeBuild("../LegendaryCore") {
    dependencySubstitution {
        substitute(module("com.example:LegendaryCore")).using(project(":"))
    }
}

includeBuild("../Legendary") {
dependencySubstitution {
substitute(module("io.github.legendaryforge:Legendary")).using(project(":"))
}
}
