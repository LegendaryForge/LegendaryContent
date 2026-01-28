rootProject.name = "LegendaryContent"

includeBuild("../LegendaryCore") {
    dependencySubstitution {
        substitute(module("com.example:LegendaryCore")).using(project(":"))
    }
}
