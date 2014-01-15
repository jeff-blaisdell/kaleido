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
		'classie': '../bower_components/classie',
		'eventie': '../bower_components/eventie',
		'doc-ready': '../bower_components/doc-ready',
		'eventEmitter': '../bower_components/eventEmitter',
		'get-style-property': '../bower_components/get-style-property',
		'get-size': '../bower_components/get-size',
		'matches-selector': '../bower_components/matches-selector',
		'outlayer': '../bower_components/outlayer',
		'packery': '../bower_components/packery/js',
		'jquery-bridget': '../bower_components/jquery-bridget/jquery.bridget',
        'images-loaded': '../bower_components/imagesLoaded/imagesLoaded'
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
		'ng-infinite-scroll': ['angular'],
        'jquery-bridget': ['jquery'],
        'packery/packery': ['jquery-bridget'],
        'images-loaded': ['jquery']
	}
});

require(['jquery',
		 'angular',
		 'app',
		 'bootstrap',
		 'controller/main',
		 'controller/browse',
		 'controller/accountLinks'
], function( $, angular ) {

	'use strict';

	angular.bootstrap(document, ['kaleido']);

});