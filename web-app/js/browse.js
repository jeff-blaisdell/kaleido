require(['jquery', 'packery/packery', 'jquery-bridget', 'jquery-infinitescroll'], function( $, Packery ) {

    var $posts = $('.browse-posts')
    $posts.packery({
        'itemSelector': 'div.browse-post',
        'gutter': 5
    })

    $('.browse-posts').infinitescroll({
        nextSelector: ".browse-nav a.next",
        navSelector: ".browse-nav",
        itemSelector: "div.browse-post",
        bufferPx: 40,
        errorCallback: function (e) {
            if (console) {
                console.log(['error on infinite scroll.', e])
            }
        }
    }, function(items) {
        $posts.packery( 'appended', items )
    });

});