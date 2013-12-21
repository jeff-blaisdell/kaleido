<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title><g:message code="browse.index.page.title" /></title>
</head>
<body>
<main class="l-globalwidth">
    <section class="browse posts clearfix" data-columns>
        <g:each var="post" in="${posts}">
            <div class="post">
                <img class="img-responsive" src="${post.imageUrl}" alt="${post.title}">
                <h5>${post.title}</h5>
            </div>
        </g:each>
    </section>
    <section class="browse btn-group">
        <g:if test="${prevPage}">
            <g:link class="btn btn-primary" controller="browse" action="index" params="[pos: prevPage]">Previous</g:link>
        </g:if>
        <g:if test="${nextPage}">
            <g:link class="btn btn-primary" controller="browse" action="index" params="[pos: nextPage]">Next</g:link>
        </g:if>
    </section>
</main>
</body>
<r:require modules="browse"/>
</html>
