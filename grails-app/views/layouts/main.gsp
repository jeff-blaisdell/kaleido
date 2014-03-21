<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title><g:layoutTitle default="Kaleido"/></title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="${resource(dir: 'css', file: 'main.css')}" type="text/css">

    <script type="text/javascript">
        // Facebook adds ugly hash on auth redirect.
        if (window.location.hash == '#_=_') {
            window.location.hash = ''; // for older browsers, leaves a # behind
            history.pushState('', document.title, window.location.pathname); // nice and clean
            e.preventDefault(); // no page reload
        }
    </script>
    <g:layoutHead/>
    <r:layoutResources />
</head>
<body class="kaleido">

    <div class="browse l-globalwidth" ng-controller="MainController">

        <section class="nav-section l-globalwidth clearfix ng-cloak" ng-controller="AccountLinksController">
            <nav class="pull-right">
                <ul class="nav nav-pills">
                    <li><a target="_self" href="/k">Home</a></li>
                    <li ng-hide="isSignedIn()"><a target="_self" href="/k/a/si">Sign In</a></li>
                    <li ng-show="isSignedIn()"><a target="_self" href="/k/a/so">Sign Out</a></li>
                    <li ng-show="isSignedIn()"><a target="_self" href="/k/a">My Account</a></li>
                </ul>
                <span ng-show="isSignedIn()" class="nav-welcome">Welcome {{ user.firstName }}</span>
            </nav>

            <header class="header">
                <img class="img-responsive" alt="Kaleido" src="http://placehold.it/1000x250/ffffff/00000/&text=Banner">
            </header>
        </section>

        <g:layoutBody/>

    </div>

    <script data-main="/k/js/main.js" src="/k/bower_components/requirejs/require.js"></script>

</body>
</html>
