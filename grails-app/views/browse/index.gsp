<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title><g:message code="browse.index.page.title" /></title>
</head>
<body>
<main class="l-globalwidth">
    <section class="posts" data-columns>
        <g:each var="post" in="${posts}">
            <div class="post">
                <img class="img-responsive" src="http://placehold.it/${post.imageFileName}" alt="${post.title}">
                <h5>${post.title}</h5>
            </div>
        </g:each>
    </section>
</main>
</body>
<r:require modules="browse"/>
</html>
