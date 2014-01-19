define(['app', 'service/post'], function( app ) {

	'use strict';

	app.controller('BrowseController', ['$scope', '$state', '$location', 'Posts', function ($scope, $state, $location, Posts) {

		$scope.isPostStateActive = ($state.current.name === 'home.post');
		$scope.currentPage = 1;
		$scope.posts = [];

		$scope.addMoreItems = function () {
			selectPosts($scope.currentPage);
		};

		$scope.$on('$stateChangeStart', function(evt, toState, toParams, fromState, fromParams) {
			if ( toState.name === 'home' ) {
				$scope.isPostStateActive = false;
				if ( fromState.name === 'home.post' ) {
					$location.hash(fromParams.postId);
				}
			} else if ( toState.name === 'home.post' ) {
				$scope.isPostStateActive = true;
			}
		});

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
