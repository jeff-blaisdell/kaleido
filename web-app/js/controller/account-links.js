define([
	'app'
], function( app ) {

	'use strict';

	app.controller('AccountLinksController', ['$scope', function ($scope) {

		$scope.user = {
			firstName: 'Jeff',
			lastName: 'Blaisdell'
		};

		$scope.isSignedIn = function () {
			return false;
		};

	}]);
});
