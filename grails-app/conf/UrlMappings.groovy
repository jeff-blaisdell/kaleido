class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?"{
            constraints {
                // apply constraints here
            }
        }
        "/"(controller: "browse", action:"browse")
        "/b/uc"(controller: "browse", action:"underConstruction")
        "/b/d/$id"(controller: "browseDetail", action:"detail")
        "/b/dj/$id"(controller: "browseDetail", action:"json")
        "/a"(controller: "account", action: "account")
        "/a/si"(controller: "signIn", action: "signin")
        "/a/so"(controller: "signOut", action: "signout")
        "/a/pr"(controller: "passwordReset", action: "passwordReset")
        "/a/cp"(controller: "passwordReset", action: "changePassword")
        "/a/r"(controller: "registration", action: "register")
        "/a/c"(controller: "registration", action: "create")
        "/a/v"(controller: "registration", action: "verifyRegistration")
        "500"(controller: 'error', action: 'internalServerError')
        "403"(controller: 'error', action: 'forbidden')
        "404"(controller: 'error', action: 'notFound')
    }
}
