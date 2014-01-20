grails.servlet.version = "2.5" // Change depending on target container compliance (2.5 or 3.0)
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.target.level = 1.6
grails.project.source.level = 1.6
//grails.project.war.file = "target/${appName}-${appVersion}.war"

// uncomment (and adjust settings) to fork the JVM to isolate classpaths
//grails.project.fork = [
//   run: [maxMemory:1024, minMemory:64, debug:false, maxPerm:256]
//]

grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // specify dependency exclusions here; for example, uncomment this to disable ehcache:
        // excludes 'ehcache'
    }
    log "info" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    checksums true // Whether to verify checksums on resolve
    legacyResolve false // whether to do a secondary resolve on plugin installation, not advised and here for backwards compatibility

    repositories {
        inherits true // Whether to inherit repository definitions from plugins

        grailsPlugins()
        grailsHome()
        grailsCentral()

        mavenLocal()
        mavenCentral()

        // uncomment these (or add new ones) to enable remote dependency resolution from public Maven repositories
        mavenRepo "http://snapshots.repository.codehaus.org"
        mavenRepo "http://repository.codehaus.org"
        mavenRepo "http://download.java.net/maven/2/"
        mavenRepo "http://repository.jboss.com/maven2/"
        mavenRepo "http://maven.springframework.org/release"
        mavenRepo "http://maven.springframework.org/snapshot"
        mavenRepo "http://maven.springframework.org/milestone"
    }

    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes e.g.
        def springSocialVersion = "1.0.2.RELEASE"
        compile("org.springframework.social:spring-social-core:${springSocialVersion}")
        compile("org.springframework.social:spring-social-facebook:${springSocialVersion}")
        compile("org.springframework.social:spring-social-web:${springSocialVersion}")
        compile("org.springframework.security:spring-security-crypto:3.1.0.RELEASE")
        compile "net.sf.ehcache:ehcache-core:2.4.6"
        compile("commons-lang:commons-lang:2.6")
        compile("javax.inject:javax.inject:1")
    }

    plugins {
        compile ":spring-security-core:1.2.7.3"
        compile ":spring-security-facebook:0.14.5"
        compile ":spring-social-core:0.1.31"
        compile ":spring-social-facebook:0.1.32"
        compile ":mail:1.0.1" {
            excludes 'spring-test'
        }
        compile ":cache:1.0.1"
        compile ":mongodb:1.3.3"
        compile ":mongodb-compound-index-attributes:1.1"
        runtime ":jquery:1.10.2"
        runtime ":resources:1.2.1"
        build ":tomcat:7.0.42"

    }
}
