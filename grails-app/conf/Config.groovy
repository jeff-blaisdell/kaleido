// locations to search for config files that get merged into the main config;
// config files can be ConfigSlurper scripts, Java properties files, or classes
// in the classpath in ConfigSlurper format

// grails.config.locations = [ "classpath:${appName}-config.properties",
//                             "classpath:${appName}-config.groovy",
//                             "file:${userHome}/.grails/${appName}-config.properties",
//                             "file:${userHome}/.grails/${appName}-config.groovy"]

// if (System.properties["${appName}.config.location"]) {
//    grails.config.locations << "file:" + System.properties["${appName}.config.location"]
// }

grails.project.groupId = kaleido // change this to alter the default package name and Maven publishing destination
grails.mime.file.extensions = true // enables the parsing of file extensions from URLs into the request format
grails.mime.use.accept.header = false
grails.mime.types = [
    all:           '*/*',
    atom:          'application/atom+xml',
    css:           'text/css',
    csv:           'text/csv',
    form:          'application/x-www-form-urlencoded',
    html:          ['text/html','application/xhtml+xml'],
    js:            'text/javascript',
    json:          ['application/json', 'text/json'],
    multipartForm: 'multipart/form-data',
    rss:           'application/rss+xml',
    text:          'text/plain',
    xml:           ['text/xml', 'application/xml']
]

// URL Mapping Cache Max Size, defaults to 5000
//grails.urlmapping.cache.maxsize = 1000

// What URL patterns should be processed by the resources plugin
//grails.resources.adhoc.patterns = ['/images/*', '/plugins/*']
grails.resources.adhoc.excludes = ['**']
grails.resources.processing.enabled = false

// The default codec used to encode data with ${}
grails.views.default.codec = "none" // none, html, base64
grails.views.gsp.encoding = "UTF-8"
grails.converters.encoding = "UTF-8"
// enable Sitemesh preprocessing of GSP pages
grails.views.gsp.sitemesh.preprocess = true
// scaffolding templates configuration
grails.scaffolding.templates.domainSuffix = 'Instance'

// Set to false to use the new Grails 1.2 JSONBuilder in the render method
grails.json.legacy.builder = false
// enabled native2ascii conversion of i18n properties files
grails.enable.native2ascii = true
// packages to include in Spring bean scanning
grails.spring.bean.packages = []
// whether to disable processing of multi part requests
grails.web.disable.multipart=false

// request parameters to mask when logging exceptions
grails.exceptionresolver.params.exclude = ['password']

// configure auto-caching of queries by default (if false you can cache individual queries with 'cache: true')
grails.hibernate.cache.queries = false

environments {
    development {
        grails.logging.jul.usebridge = true
    }
    production {
        grails.logging.jul.usebridge = false
        // TODO: grails.serverURL = "http://www.changeme.com"
    }
}

// log4j configuration
log4j = {
    // Example of changing the log pattern for the default console appender:
    //
    //appenders {
    //    console name:'stdout', layout:pattern(conversionPattern: '%c{2} %m%n')
    //}

    error  'org.codehaus.groovy.grails.web.servlet',        // controllers
           'org.codehaus.groovy.grails.web.pages',          // GSP
           'org.codehaus.groovy.grails.web.sitemesh',       // layouts
           'org.codehaus.groovy.grails.web.mapping.filter', // URL mapping
           'org.codehaus.groovy.grails.web.mapping',        // URL mapping
           'org.codehaus.groovy.grails.commons',            // core / classloading
           'org.codehaus.groovy.grails.plugins',            // plugins
           'org.codehaus.groovy.grails.orm.hibernate',      // hibernate integration
           'org.springframework',
           'org.hibernate',
           'net.sf.ehcache.hibernate'
}

grails {
    mail {
        host = "smtp.gmail.com"
        port = 465
        username = "jeff.blaisdell@gmail.com"
        password = "mavb55"
        props = ["mail.smtp.auth":"true",
                "mail.smtp.socketFactory.port":"465",
                "mail.smtp.socketFactory.class":"javax.net.ssl.SSLSocketFactory",
                "mail.smtp.socketFactory.fallback":"false"]
    }
}

// Added by the Spring Security Core plugin:
grails.plugins.springsecurity.userLookup.userDomainClassName = 'io.kaleido.profile.User'
grails.plugins.springsecurity.userLookup.usernamePropertyName = 'email'
grails.plugins.springsecurity.userLookup.authorityJoinClassName = 'io.kaleido.profile.UserRole'
grails.plugins.springsecurity.authority.className = 'io.kaleido.profile.Role'
grails.plugins.springsecurity.useSecurityEventListener = true
grails.plugins.springsecurity.password.algorithm = 'bcrypt'
grails.plugins.springsecurity.password.bcrypt.logrounds = 15
grails.plugins.springsecurity.successHandler.defaultTargetUrl='/'
grails.plugins.springsecurity.securityConfigType = "Annotation"
grails.plugins.springsecurity.adh.errorPage='/error/forbidden'
grails.plugins.springsecurity.auth.loginFormUrl='/account/signin'
grails.plugins.springsecurity.failureHandler.defaultFailureUrl='/account/signin'
grails.plugins.springsecurity.facebook.domain.classname='io.kaleido.profile.FacebookUser'
grails.plugins.springsecurity.facebook.appId='514394148640546'
grails.plugins.springsecurity.facebook.secret='e8f381273a740f99cde4509f38bc5a49'
grails.plugins.springsecurity.facebook.permissions='email,user_birthday,user_location'
grails.plugins.springsecurity.facebook.autoCreate.roles='ROLE_USER,ROLE_FACEBOOK'
grails.plugins.springsecurity.facebook.filter.redirect.failureHandler='redirectFailureHandlerExample'
grails.plugins.springsecurity.facebook.filter.redirect.successHandler='redirectSuccessHandlerExample'
grails.plugins.springsocial.facebook.clientId='514394148640546'
grails.plugins.springsocial.facebook.clientSecret='e8f381273a740f99cde4509f38bc5a49'
grails.plugins.springsecurity.facebook.taglib.button.img='/images/facebook-connect.png'

user {
    register {
        emailBody = '''\
Hi $user.firstName,<br/>
<br/>
You (or someone pretending to be you) created an account with this email address.<br/>
<br/>
If you made the request, please click&nbsp;<a href="$url">here</a> to finish the registration.
'''
        emailFrom = 'do.not.reply@localhost'
        emailSubject = 'New Account'
        defaultRoleNames = ['ROLE_USER']
        postRegisterUrl = null // use defaultTargetUrl if not set
    }

    passwordReset {
        emailBody = '''\
Hi $user.firstName,<br/>
<br/>
You (or someone pretending to be you) requested that your password be reset.<br/>
<br/>
If you didn't make this request then ignore the email; no changes have been made.<br/>
<br/>
If you did make the request, then click <a href="$url">here</a> to reset your password.
'''
        emailFrom = 'do.not.reply@localhost'
        emailSubject = 'Password Reset'
        postResetUrl = null // use defaultTargetUrl if not set
    }
}
// Uncomment and edit the following lines to start using Grails encoding & escaping improvements

/* remove this line 
// GSP settings
grails {
    views {
        gsp {
            encoding = 'UTF-8'
            htmlcodec = 'xml' // use xml escaping instead of HTML4 escaping
            codecs {
                expression = 'html' // escapes values inside null
                scriptlet = 'none' // escapes output from scriptlets in GSPs
                taglib = 'none' // escapes output from taglibs
                staticparts = 'none' // escapes output from static template parts
            }
        }
        // escapes all not-encoded output at final stage of outputting
        filteringCodecForContentType {
            //'text/html' = 'html'
        }
    }
}
remove this line */
