define(['app'], function( app ) {
	'use strict';

	app.controller('PostController', ['$scope', '$stateParams', 'Posts', function ($scope, $stateParams, Posts) {

		$scope.post = undefined;

		Posts.get({ 'id' : $stateParams.postId })
			.success(function( data ) {
				$scope.post = data;
			});

	}]);

});
