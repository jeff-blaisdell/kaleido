<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title><g:message code="home.index.page.title" /></title>
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'browse.css')}" type="text/css">
</head>
<body>

    <section class="browse-posts clearfix" ng-controller="BrowseController" ng-show="posts" infinite-scroll="addMoreItems()">
        <div class="browse-post" ng-repeat="post in posts">
            <a href="#">
                <img ng-src="{{ post.imageUrl }}" alt="{{ post.title }}">
                <h5>{{ post.title }}</h5>
            </a>
        </div>
    </section>

</body>
</html>