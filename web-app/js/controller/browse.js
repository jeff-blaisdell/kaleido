define(['app', 'service/post', 'service/state'], function( app ) {

	'use strict';

	app.controller('BrowseController', ['$scope', 'Posts', function ($scope, Posts) {

		$scope.currentPage = 1;
		$scope.posts = [];

		$scope.addMoreItems = function () {
			selectPosts($scope.currentPage);
		};

		function selectPosts(page) {

			var params = {};
			if ( page ) {
				params.page = page;
			}

			Posts.get(params)
				.success(function( data ) {
					if (data && data.length > 0) {
						$scope.posts = $scope.posts.concat(data);
						$scope.currentPage++;
					}
				});
		}

	}]);
});
