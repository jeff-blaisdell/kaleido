requirejs.config({
    baseUrl: '/kaleido/static/js',
    paths: {
        'jquery': 'jquery/jquery-1.10.2.min',
        'classie': 'packery/classie',
        'eventie': 'packery/eventie',
        'doc-ready': 'packery/doc-ready',
        'eventEmitter': 'packery/eventEmitter',
        'get-style-property': 'packery/get-style-property',
        'get-size': 'packery/get-size',
        'matches-selector': 'packery/matches-selector',
        'outlayer': 'packery/outlayer',
        'packery': 'packery',
        'jquery-bridget': 'packery/jquery-bridget/jquery.bridget'
    },
    shim: {
        'bootstrap': ['jquery'],
        'handlebars': {
            exports: 'Handlebars'
        },
        'modernizr': {
            exports: 'Modernizr'
        },
        'underscore': '_',
        'jquery-infinitescroll': ['jquery'],
        'jquery-bridget': ['jquery'],
        'packery': ['jquery-bridget']
    }
});