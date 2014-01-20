define([
	'app'
], function( app ) {
	'use strict';

	app.factory('Posts', ['$http', function ($http) {

		return {
			get: function( params ) {
				params = params || {};
				if (params.page) {
					return $http.get('/k/browse/' + params.page);
				} else if (params.id) {
					return $http.get('/k/posts/' + params.id);
				} else {
					return $http.get('/k/browse');
				}
			}
		};

	}]);
});
