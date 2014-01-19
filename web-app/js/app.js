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
		$urlRouterProvider.otherwise('/k');

		// Define Application States
		$stateProvider
			.state('home', {
				url         : '/k',
				templateUrl : '/k/view/browse.html'
			})
			.state('home.post', {
				url         : '/p/{postId}',
				templateUrl : '/k/view/browse.html',
				views       : {
					'home.post' : {
						templateUrl : '/k/view/post.html'
					}
				}
			});

	});

	return app;
});