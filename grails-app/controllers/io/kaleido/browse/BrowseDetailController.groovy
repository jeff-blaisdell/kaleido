package io.kaleido.browse

import grails.converters.JSON

class BrowseDetailController {

    def browseDetailService

    def detail() {
        def post = browseDetailService.findPost(params.id)
        render(view: 'detail', model: [post: post, data: post as JSON])
    }

}
