<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title><g:message code="browse.index.page.title" /></title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href='http://fonts.googleapis.com/css?family=The+Girl+Next+Door' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'bootstrap.css')}" type="text/css">
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'bootstrap-theme.css')}" type="text/css">

    <style>

        .banner-bg {
            background: url('/k/static/images/brush-lines-sm.jpg') no-repeat;
            background-size: 100% 100%;
            width: 100%;
            height: 100%;
            max-width: 1200px;
            position: absolute;
            top: 0;
            left: 0;
        }

        .banner .name { font-family: 'The Girl Next Door', cursive; font-size: 4em; color: #FFFFFF; }
        .banner .call-out { margin-top: -18px; margin-bottom: 15px; }
        .call-out { color: #FFFFFF; }
        .call-out .color1 { color: #135573; }
        .call-out .color2 { color: #FF0055; }
        .call-out .color3 { color: #3BD3FF; }
        .call-out .color4 { color: #67F611; }
        .overlay blockquote { color: #FFFFFF; padding: 5px 5px; border-left: none; }
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
            }

        }


    </style>
</head>
<body>
    <div class="main uc-main">

        <!-- Empty div holding background image style rules. -->
        <div class="banner-bg"></div>

        <!-- Primary content area. -->
        <div class="container">
            <div class="row">
                <div class="col-md-6">

                    <div class="banner">
                        <h1 class="name">Kaleido.io</h1>
                        <h2 class="call-out">
                            <small>
                                <span class="color1">Coming&nbsp;Soon!</span>
                            </small>
                        </h2>
                    </div>

                    <div class="content">
                        <form>
                            <div class="input-group">
                                <input type="email" class="form-control" placeholder="Here's my e-mail address.">
                                <span class="input-group-btn">
                                    <button class="btn btn-info" type="button">Notify Me</button>
                                </span>
                            </div>
                        </form>
                    </div>

                    <div class="footer">
                        <h2 class="call-out">
                            <small>
                                <span class="color2">Community</span> |
                                <span class="color3">Expression</span> |
                                <span class="color4">Art</span>
                            </small>
                        </h2>
                    </div>

                </div>
            </div>
        </div>
    </div>
</body>
</html>