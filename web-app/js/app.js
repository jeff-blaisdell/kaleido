define(['angular',
	'jquery',
	'angular-cookies',
	'angular-resource',
	'angular-sanitize',
    'angular-ui-router',
	'ng-infinite-scroll',
	'directive/packery'
], function( angular ) {

	'use strict';

	var app = angular.module('kaleido', [
		'ngCookies',
		'ngResource',
		'ngSanitize',
        'ui.router',
		'infinite-scroll',
		'packery'
	]);

	app.config(function ($stateProvider, $urlRouterProvider, $locationProvider) {

        $locationProvider.html5Mode(true);


        // For any unmatched url, redirect to /state1
        $urlRouterProvider.otherwise("/k");

        // Define States
        var states = {
            home : {
                name        : 'home',
                url         : '/k',
                templateUrl : '/k/view/browse.html'
            },
            post : {
                name        : 'post',
                parent      : 'home',
                url         : '/p/{postId}',
                views       : {
                    '': {
                        templateUrl : '/k/view/post.html'
                    }
                }
            }
        };

        // Add States to State Manager.
        $stateProvider
            .state(states.home)
            .state(states.post);

	});

	return app;
});