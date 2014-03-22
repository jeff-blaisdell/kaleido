<!DOCTYPE html>
<html>
<head>
    <title><g:message code="profile.signIn.page.title" /></title>
    <meta name="layout" content="main">
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'signin.css')}" type="text/css">
</head>
<body>
<main>

    <div class="col-sm-6 col-sm-offset-3">
        <div class="panel panel-default signin-panel">
            <div class="panel-body innerAll">
                <form id="signin-form" name="signin" action="${authUrl}" method="post">
                    <h3><g:message code="profile.signIn.form.label" default="Sign In" /></h3>
                    <fieldset>
                        <div class="form-group">
                            <label for="j_username">
                                <g:message code="user.email.label" default="Email:" />
                            </label>
                            <div class="input-group">
                                <span class="input-group-addon">@</span>
                                <g:field type="email" class="form-control" name="j_username" required="true" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="j_password">
                                <g:message code="user.password.label" default="Password:" />
                            </label>
                            <g:field type="password" class="form-control" name="j_password" required="true" />
                        </div>

                        <div class="form-group">
                            <h6>
                                <g:link controller="passwordReset" action="passwordReset">
                                    <g:message code="profile.signIn.forgot.password" />
                                </g:link>
                            </h6>
                        </div>

                        <g:if test="${flash.message}">
                            <div class="alert alert-danger alert-dismissable">
                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                ${flash.message}
                            </div>
                        </g:if>

                        <div class="checkbox">
                            <label for="rememberMeCheckBox">
                                <g:message id="rememberMeCheckBox" code="user.rememberMe.label" default="Remember Me:" />
                            </label>
                            <g:checkBox name="${rememberMeParameter}" checked="${hasCookie}" />
                        </div>

                        <div class="form-group">
                            <button type="submit" class="btn btn-primary" name="update" id="update">
                                <i class="fa fa-user"></i>
                                <span>Sign In</span>
                            </button>
                        </div>

                        <div class="form-group">
                            <a href="/k/j_spring_security_facebook_redirect" class="btn btn-inverse">
                                <i class="fa fa-facebook"></i>
                                <span>Sign In with Facebook</span>
                            </a>
                        </div>
                    </fieldset>
                </form>
            </div>
        </div>
    </div>

    <div class="col-sm-6 col-sm-offset-3 text-center">
        <g:link controller="registration" action="register">
            <input type="button" class="btn btn-default" value="${message(code: 'profile.signIn.registration.button')}"/>
        </g:link>
    </div>

</main>
</body>
</html>
