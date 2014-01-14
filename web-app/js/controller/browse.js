define(['app', 'service/post'], function( app ) {
	'use strict';

	app.controller('BrowseController', ['$scope', 'Posts', function ($scope, Posts) {
		$scope.posts = [];

		Posts.get()
			.success(function( data ) {
				$scope.posts = data;
			});

	}]);
});
