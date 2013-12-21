package io.kaleido.browse

import java.text.SimpleDateFormat


class BrowseController {

    def browseService

    def browse() {
        def format = browseService.getDateFormat()
        def df = new SimpleDateFormat(format)
        def date = (params.page ? df.parse(params.page as String) : null)
        def page = browseService.selectPostPage(date)

        render(view: 'browse', model: page)
    }

}
