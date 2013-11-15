requirejs.config({
    baseUrl: '/kaleido/static/js',
    paths: {
        'jquery': 'jquery/jquery-1.10.2.min'
    },
    shim: {
        'bootstrap': ['jquery'],
        'handlebars': {
            exports: 'Handlebars'
        },
        'modernizr': {
            exports: 'Modernizr'
        },
        'underscore': '_'
    }
});