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
                <a href="${createLink(controller: 'browseDetail', action: 'detail', params: [id: post.id])}">
                    <img src="${post.imageUrl}" alt="${post.title}">
                    <h5>${post.title}</h5>
                </a>
            </div>
        </g:each>
    </section>
    <section class="browse-nav">
        <g:if test="${prevPage}">
            <a class="btn btn-link prev" href="${createLink(controller: 'browse', action: 'browse', params : [page: prevPage])}">Previous</a>
        </g:if>
        <g:if test="${nextPage}">
            <a class="btn btn-link next" href="${createLink(controller: 'browse', action: 'browse', params : [page: nextPage])}">Next</a>
        </g:if>
    </section>
</main>
</body>
</html>
