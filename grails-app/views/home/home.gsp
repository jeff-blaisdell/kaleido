<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title><g:message code="home.index.page.title" /></title>
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'home.css')}" type="text/css">
</head>
<body>

    <div packery class="browse-posts clearfix" ng-controller="BrowseController" ng-show="posts" infinite-scroll="addMoreItems()">
        <div class="browse-post packery-brick" ng-repeat="post in posts">
            <a href="#">
                <img class="ng-cloak" ng-src="{{ post.imageUrl }}" alt="{{ post.title }}">
                <h5 class="ng-cloak">{{ post.title }}</h5>
            </a>
        </div>
    </div>

</body>
</html>