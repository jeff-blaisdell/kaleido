<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title><g:message code="detail.index.page.title" /></title>
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'detail.css')}" type="text/css">
</head>
<body>
<main class="browse l-globalwidth">
    <h1>Post and Responses.</h1>
    <g:if test="${post}">
        <div class="browse-post">
            <img src="${post.imageUrl}" alt="${post.title}">
            <h5>${post.title}</h5>
        </div>
        <g:if test="${post.posts}">
            <g:each var="p" in="${post.posts}">
                <div class="browse-post">
                    <img src="${p.imageUrl}" alt="${p.title}">
                    <h5>${p.title}</h5>
                </div>
            </g:each>
        </g:if>
    </g:if>

    <script id="post-data" type="application/json">
        ${data}
    </script>
</main>
</body>
<r:require modules="detail"/>
</html>
