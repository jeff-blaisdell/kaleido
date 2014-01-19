class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?"{
            constraints {
                // apply constraints here
            }
        }
        "/"(controller: "home", action:"index")
        "/p/${postId}"(controller: "home", action:"index")
        "/b/uc"(controller: "underConstruction", action:"index")
        "/browse/${page}"(controller: "browse", action: "show")
        "/posts/${id}"(controller: "post", action: "show")
    }
}
