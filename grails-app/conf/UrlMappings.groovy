class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?"{
            constraints {
                // apply constraints here
            }
        }
        "/"(controller: "home", action:"index")
        "/b/uc"(controller: "underConstruction", action:"index")
    }
}
