define(['app'], function( app ) {
    'use strict';

    app.factory('StateService', ['$state', function ($state) {

        var state = undefined;

        if ( $state.current ) {
            state = $state.current.name;
        }

        return {
            get: function() {
                return state;
            },
            set: function( st ) {
                state = st;
            }
        };

    }]);
});
