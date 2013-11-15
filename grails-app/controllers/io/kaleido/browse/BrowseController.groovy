package io.kaleido.browse

import grails.converters.JSON
import java.text.SimpleDateFormat


class BrowseController {

    public static final int MAX_POSTS_ON_PAGE = 25

    def browseService

    def index() {

        def date = (params.pos == null ? null: new Date(Long.parseLong(params.pos as String)))
        def posts = browseService.selectPostsByPublishedDate(date)

        render(view: 'index', model: paginatePosts(posts, params.pos, MAX_POSTS_ON_PAGE))
    }

    def paginatePosts = { posts, prevPage, max ->
        def items = []
        def nextPage
        if (posts) {
            for (post in posts) {
                items.add([
                        id: post.id.toString(),
                        title: post.title,
                        email: post.user?.email,
                        publishedDate: post.publishedDate.format('MM/dd/yy kk:mm:ss'),
                        imageUrl: "http://placehold.it/" + post.imageFileName
                ])
            }
        }
        if (items.size() >= max) {
            SimpleDateFormat df = new SimpleDateFormat('MM/dd/yy kk:mm:ss')
            nextPage = df.parse(items.last().publishedDate as String).getTime()
        }
        return ['posts': items, 'prevPage': prevPage, 'nextPage': nextPage]
    }
}
