define(['angular',
	'jquery',
	'angular-cookies',
	'angular-resource',
	'angular-sanitize',
	'angular-route',
	'ng-infinite-scroll',
	'directive/packery'
], function( angular ) {

	'use strict';

	var app = angular.module('kaleido', [
		'ngCookies',
		'ngResource',
		'ngSanitize',
		'ngRoute',
		'infinite-scroll',
		'packery'
	]);

	app.config(function ($routeProvider, $locationProvider) {

        $locationProvider.html5Mode(true);

		$routeProvider
			.when('/k', {
                templateUrl: '/k/view/browse.html',
				controller: 'MainController'
			})
            .when('/k/b/p/:postId', {
                templateUrl: '/k/view/post.html',
                controller: 'PostController'
            })
			.otherwise({
				redirectTo: '/k'
			});
	});

	return app;

});