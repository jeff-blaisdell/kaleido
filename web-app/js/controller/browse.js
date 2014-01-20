define(['app', 'service/post'], function( app ) {

	'use strict';

	app.controller('BrowseController', ['$scope', '$state', '$location', 'Posts', function ($scope, $state, $location, Posts) {

		/**
		 * Retrieves post from backend.
		 * @param page The current page of posts the user is on.
		 */
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

		/**
		 * Event handler for Angular UI-Router's $stateChangeStartEvent.
		 * The browse page needs to show / hide the infinite scroll
		 * when a user is viewing the post detail page.  This handler
		 * encapsulates that logic.
		 * @see https://github.com/angular-ui/ui-router/wiki#state-change-events for parameter descriptions.
		 */
		function onStateChangeStart(evt, toState, toParams, fromState, fromParams) {
			if ( toState.name === 'home' ) {
				$scope.isPostStateActive = false;
				if ( fromState.name === 'home.post' ) {
					$location.hash(fromParams.postId);
				}
			} else if ( toState.name === 'home.post' ) {
				$scope.isPostStateActive = true;
			}
		}

        /**
         * Callback for infinite-scroll directive used to fetch
         * next page of content.
         */
		function addMoreItems() {
			selectPosts($scope.currentPage);
		}

        /**
         * Initialize $scope.
         */
		$scope.isPostStateActive = ($state.current.name === 'home.post');
		$scope.currentPage = 1;
		$scope.posts = [];
		$scope.addMoreItems = addMoreItems;
		$scope.$on('$stateChangeStart', onStateChangeStart);

	}]);
});
