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
        "500"(controller: 'error', action: 'internalServerError')
        "403"(controller: 'error', action: 'forbidden')
        "404"(controller: 'error', action: 'notFound')
        "/a"(controller: "account", action: "account")
        "/a/si"(controller: "signIn", action: "signin")
        "/a/so"(controller: "signOut", action: "signout")
        "/a/pr"(controller: "passwordReset", action: "passwordReset")
        "/a/cp"(controller: "passwordReset", action: "changePassword")
        "/a/r"(controller: "registration", action: "register")
        "/a/c"(controller: "registration", action: "create")
        "/a/v"(controller: "registration", action: "verifyRegistration")
    }
}
