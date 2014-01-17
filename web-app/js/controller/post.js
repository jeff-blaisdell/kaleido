define(['app'], function( app ) {
    'use strict';

    app.controller('PostController', ['$scope', '$routeParams', 'Posts', function ($scope, $routeParams, Posts) {

        $scope.post = undefined;

        Posts.get({ 'id' : $routeParams.postId })
            .success(function( data ) {
                $scope.post = data;
            });

    }]);

});
