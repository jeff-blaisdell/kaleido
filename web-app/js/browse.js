require(['jquery', 'packery/packery', 'jquery-bridget', 'jquery-infinitescroll'], function( $ ) {

    // Selector containing the browse page's posts.
    var $posts = $('.browse-posts');

    // HTML Progress Bar
    var $progressBar = $('<div id="noTrespassingOuterBarG" class="browse-progress-bar"><div id="noTrespassingFrontBarG" class="noTrespassingAnimationG"><div class="noTrespassingBarLineG"></div><div class="noTrespassingBarLineG"></div><div class="noTrespassingBarLineG"></div><div class="noTrespassingBarLineG"></div><div class="noTrespassingBarLineG"></div><div class="noTrespassingBarLineG"></div></div></div>');


    //Initialize Packery Grid.
    $posts.packery({
        'itemSelector': 'div.browse-post',
        'gutter': 5
    });

    /**
     * jQuery infinite-scroll requires an <img>
     * tag contained in progress-bar to hide on end.
     * Override w/ version that simply hides the progress bar.
     */
    $.extend($.infinitescroll.prototype,{
        _showdonemsg_kaleido_browse: function () {

            var opts = this.options;

            opts.loading.msg.hide();

            // user provided callback when done
            opts.errorCallback.call($(opts.contentSelector)[0],'done');
        }
    });

    // Initialize infinite-scroll.
    $posts.infinitescroll({
        loading: {
            msg: $progressBar,
            speed: 'fast'
        },
        nextSelector: ".browse-nav a.next",
        navSelector: ".browse-nav",
        itemSelector: ".browse-post",
        contentSelector: '.browse-posts',
        bufferPx: 40,
        dataType: 'html',
        behavior: 'kaleido_browse',
        errorCallback: function (e) {
            if (console) {
                console.log(['error on infinite scroll.', e])
            }
        }
    }, function(items) {
        $posts.packery( 'appended', items )
    });

});