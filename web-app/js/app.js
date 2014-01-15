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

	app.config(function ($routeProvider) {
		$routeProvider
			.when('/', {
				controller: 'MainController'
			})
			.otherwise({
				redirectTo: '/'
			});
	});

	return app;

});