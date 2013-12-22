require(['jquery', 'packery/packery', 'jquery-bridget', 'jquery-infinitescroll'], function( $ ) {

    var $posts = $('.browse-posts');

    $posts.packery({
        'itemSelector': 'div.browse-post',
        'gutter': 5
    });

    $posts.infinitescroll({
        nextSelector: ".browse-nav a.next",
        navSelector: ".browse-nav",
        itemSelector: "div.browse-post",
        bufferPx: 40,
        dataType: 'html',
        errorCallback: function (e) {
            if (console) {
                console.log(['error on infinite scroll.', e])
            }
        }
    }, function(items) {
        $posts.packery( 'appended', items )
    });

});