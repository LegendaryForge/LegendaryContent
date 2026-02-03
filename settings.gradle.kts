rootProject.name = "LegendaryContent"

includeBuild("../LegendaryCore") {
    dependencySubstitution {
        substitute(module("com.example:LegendaryCore")).using(project(":"))
    }
}

includeBuild("../Legendary") {
dependencySubstitution {
substitute(module("com.example:Legendary")).using(project(":"))
}
}
