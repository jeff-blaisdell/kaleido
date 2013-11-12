package io.kaleido.browse

class BrowseController {

    def index() {
        def posts = Post.findAll()

        render(view: 'index', model: ['posts': posts])
    }
}
