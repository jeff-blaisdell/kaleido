package io.kaleido.browse

class BrowseController {

    def browseService

    def browse() {
        def page = browseService.selectPage(params.page ? Integer.parseInt(params.page as String) : null)

        render(view: 'browse', model: page)
    }

    /**
     * Under Construction / Coming Soon page used while site is being built.
     */
    def underConstruction() {
        render(view: 'underConstruction')
    }

}
