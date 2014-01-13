package io.kaleido.browse

import grails.rest.RestfulController

class BrowseController extends RestfulController {

    static responseFormats = ['json', 'xml']

    def browseService

    def index() {
        def posts = browseService.selectPosts()
        def totalPages = browseService.getTotalPages();

        respond posts, model: [totalPages: totalPages]
    }

    def show() {
        def posts = browseService.selectPosts(params.page ? Integer.parseInt(params.page as String) : null)
        def totalPages = browseService.getTotalPages();

        respond posts, model: [totalPages: totalPages]
    }

}
