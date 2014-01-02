package io.kaleido.marshaller

import grails.converters.JSON
import io.kaleido.browse.Post

class PostMarshaller {

    private static final String DATE_FORMAT = "yyyyMMddkkmmssSS"

    void register() {
        JSON.registerObjectMarshaller(Post) { Post post ->
            def map = marshaller(post)
            if (post.posts) {
                map.posts = []
                for (int i = 0; i < post.posts.size(); i++) {
                    def p = post.posts.get(i)
                    map.posts.add(marshaller(p));
                }
            }
            return map
        }
    }

    def marshaller = { post ->
        return [
                id: post.id.toString(),
                title: post.title,
                email: post.user?.email,
                publishedDate: post.publishedDate.format(DATE_FORMAT),
                imageUrl: post.imageUrl
        ]
    }


}
