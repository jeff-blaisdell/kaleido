requirejs.config({
	baseUrl: '/k/js',
	paths: {
		'jquery': '../bower_components/jquery/jquery',
		'angular': '../bower_components/angular/angular',
		'bootstrap': '../bower_components/bootstrap/dist/js/bootstrap',
		'angular-resource': '../bower_components/angular-resource/angular-resource',
		'angular-cookies': '../bower_components/angular-cookies/angular-cookies',
		'angular-sanitize': '../bower_components/angular-sanitize/angular-sanitize',
		'angular-route': '../bower_components/angular-route/angular-route',
		'angular-animate': '../bower_components/angular-animate/angular-animate',
		'angular-ui-router': '../bower_components/angular-ui-router/release/angular-ui-router',
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
		'images-loaded': '../bower_components/imagesloaded/imagesloaded',
        'file-upload': '../bower_components/ng-file-upload/angular-file-upload',
        'file-upload-html5-shim': '../bower_components/ng-file-upload/angular-file-upload-html5-shim',
        'file-upload-shim': '../bower_components/ng-file-upload/angular-file-upload-shim'
	},
	shim: {
		'jquery': {
			exports: '$'
		},
		'angular': {
            deps: ['file-upload-shim'],
			exports: 'angular'
		},
		'bootstrap': ['jquery'],
		'angular-resource': ['angular'],
		'angular-cookies': ['angular'],
		'angular-sanitize': ['angular'],
		'angular-route': ['angular'],
		'angular-animate': ['angular'],
		'angular-ui-router': ['angular'],
		'ng-infinite-scroll': ['angular'],
        'file-upload': ['angular'],
		'jquery-bridget': ['jquery'],
		'packery/packery': ['jquery-bridget'],
		'images-loaded': ['jquery']
	}
});

require([
	'jquery',
	'angular',
	'app',
	'bootstrap',
	'controller/main',
	'controller/browse',
	'controller/account-links',
	'controller/post'
], function( $, angular ) {

	'use strict';

	angular.bootstrap(document, ['kaleido']);

});