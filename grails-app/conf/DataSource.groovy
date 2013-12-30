
// environment specific settings
environments {
    development {
        grails {
            mongo {
                host = "127.0.0.1"
                port = 27017
                username = "kaleido"
                password = "kaleido"
                databaseName = "kaleido-alpha"
            }
        }
    }
    test {
        grails {
            mongo {
                host = "127.0.0.1"
                port = 27017
                username = "kaleido"
                password = "kaleido"
                databaseName = "kaleido-alpha"
            }
        }
    }
    production {
        grails {
            mongo {
                host = "127.0.0.1"
                port = 27017
                username = "kaleido"
                password = "TrickyDicky21"
                databaseName = "kaleido"
            }
        }
    }
}
