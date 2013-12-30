<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title><g:message code="browse.index.page.title" /></title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href='http://fonts.googleapis.com/css?family=Coming+Soon' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=The+Girl+Next+Door' rel='stylesheet' type='text/css'>

    <link rel="stylesheet" href="${resource(dir: 'css', file: 'bootstrap.css')}" type="text/css">
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'bootstrap-theme.css')}" type="text/css">

    <script>document.write('<script src="http://' + (location.host || 'localhost').split(':')[0] + ':35729/livereload.js?snipver=1"></' + 'script>')</script>

    <style>

        .logo { font-family: 'The Girl Next Door'; font-size: 4em; color: #FF8C06; }
        .call-out { color: #FFFFFF; }
        .call-out .color1 { color: #135573; }
        .call-out .color2 { color: #FF0055; }
        .call-out .color3 { color: #3BD3FF; }
        .call-out .color4 { color: #FF8C06; }
        .overlay blockquote { color: #FFFFFF; padding: 5px 5px; border-left: none; }
        .underline { text-decoration: underline; }
        .input-group { max-width: 400px; }

        @media (min-width: 550px) {
            body { background: url('/k/static/images/paper.jpg') repeat-x; background-size: 90px auto; }

            .banner-bg {
                background: url('/k/static/images/brush-lines.jpg') no-repeat;
                background-size: 100% 100%;
                width: 100%;
                height: 100%;
                max-width: 1200px;
                position: absolute;
                top: 0;
                left: 0;
                z-index: -1;
            }

            .logo { color: #FFFFFF; }
            .call-out .color4 { color: #FFFFFF; }

        }


    </style>
</head>
<body>
    <div class="main">
        <div class="banner-bg"></div>
        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <h1 class="logo">Kaleido.io</h1>
                    <div class="input-group">
                        <input type="email" class="form-control" placeholder="Here's my e-mail address.">
                        <span class="input-group-btn">
                            <button class="btn btn-info" type="button">Notify Me</button>
                        </span>
                    </div>
                    <h2 class="call-out">
                        <small>
                            <span class="color1">Community</span> |
                            <span class="color2">Expression</span> |
                            <span class="color3">Art</span> &mdash;
                            <span class="color4 underline">Coming&nbsp;Soon!</span>
                        </small>
                    </h2>
                </div>
            </div>
        </div>
    </div>
</body>
</html>