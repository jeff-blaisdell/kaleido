define([
	'app'
], function( app ) {

	'use strict';

	app.controller('PostController', ['$scope', '$stateParams', 'Posts', function ($scope, $stateParams, Posts) {

		function init() {
			Posts.get({ 'id' : $stateParams.postId })
				.success(function( data ) {
					$scope.post = data;
				});
		}

		/**
		 * Initialize $scope.
		 */
		$scope.post = undefined;


		/**
		 * Initialize controller.
		 */
		init();

	}]);

});
