package io.kaleido.browse

import grails.rest.RestfulController;

class PostController extends RestfulController {

    static responseFormats = ['json', 'xml']

    def postService

    def show() {
        def post = postService.findPost(params.id)
        render post
    }

    def save() {}

    def update() {}

    def delete() {}
}
