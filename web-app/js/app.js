define(['angular',
    'angular-cookies',
    'angular-resource',
    'angular-sanitize',
    'angular-route',
    'ng-infinite-scroll'
], function( angular ) {

    'use strict';

    var app = angular.module('kaleido', [
        'ngCookies',
        'ngResource',
        'ngSanitize',
        'ngRoute',
        'infinite-scroll'
    ]);

    app.config(function ($routeProvider) {
        $routeProvider
            .when('/', {
                templateUrl: 'views/main.html',
                controller: 'MainCtrl'
            })
            .otherwise({
                redirectTo: '/'
            });
    });

    return app;


});