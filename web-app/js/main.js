requirejs.config({
    baseUrl: '/k/static/js',
    paths: {
        'jquery': '../bower_components/jquery/jquery',
        'angular': '../bower_components/angular/angular',
        'bootstrap': '../bower_components/bootstrap/dist/js/bootstrap',
        'angular-resource': '../bower_components/angular-resource/angular-resource',
        'angular-cookies': '../bower_components/angular-cookies/angular-cookies',
        'angular-sanitize': '../bower_components/angular-sanitize/angular-sanitize',
        'angular-route': '../bower_components/angular-route/angular-route',
        'ng-infinite-scroll': '../bower_components/nginfinitescroll/build/ng-infinite-scroll',
        'classie': '../bower_components/classie/classie',
        'eventie': '../bower_components/eventie/eventie',
        'doc-ready': '../bower_components/doc-ready/doc-ready',
        'eventEmitter': '../bower_components/eventEmitter/EventEmitter',
        'get-style-property': '../bower_components/get-style-property/get-style-property',
        'get-size': '../bower_components/get-size/get-size',
        'matches-selector': '../bower_components/matches-selector/matches-selector',
        'outlayer': '../bower_components/outlayer/outlayer',
        'packery': '../bower_components/packery/js/packery',
        'jquery-bridget': '../bower_components/jquery-bridget/jquery.bridget'
    },
    shim: {
        'jquery': {
            exports: '$'
        },
        'angular': {
            exports: 'angular'
        },
        'bootstrap': ['jquery'],
        'angular-resource': ['angular'],
        'angular-cookies': ['angular'],
        'angular-sanitize': ['angular'],
        'angular-route': ['angular'],
        'ng-infinite-scroll': ['angular']
    }
});

require(['jquery',
    'angular',
    'app',
    'bootstrap'], function( $, angular ) {

    'use strict';

    angular.bootstrap(document, ['kaleido']);

});