<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title><g:message code="browse.index.page.title" /></title>
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'browse.css')}" type="text/css">
</head>
<body>
<main class="browse l-globalwidth">
    <section class="browse-posts clearfix" data-columns>
        <g:each var="post" in="${posts}">
            <div class="browse-post">
                <img class="img-responsive" src="${post.imageUrl}" alt="${post.title}">
                <h5>${post.title}</h5>
            </div>
        </g:each>
    </section>
    <section class="browse-nav">
        <g:if test="${prevPageUrl}">
            <a class="btn btn-link prev" href="${prevPageUrl}">Previous</a>
        </g:if>
        <g:if test="${nextPageUrl}">
            <a class="btn btn-link next" href="${nextPageUrl}">Next</a>
        </g:if>
    </section>
</main>
</body>
<r:require modules="browse"/>
</html>
