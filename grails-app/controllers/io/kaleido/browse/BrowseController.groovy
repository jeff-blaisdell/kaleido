package io.kaleido.browse

class BrowseController {

    def browseService

    def browse() {
        def page = browseService.selectPage(params.page ? Integer.parseInt(params.page as String) : null)

        render(view: 'browse', model: page)
    }

}
