package io.kaleido.converter

import io.kaleido.browse.Post

class PostConverter {

    def canConvert(Object obj) {
        return (obj != null && obj instanceof Post)
    }

    def convert(Object obj) {

        def post = [
            id: obj.id.toString(),
            title: obj.title,
            email: obj.user?.email,
            publishedDate: obj.publishedDate,
            imageUrl: "http://placehold.it/" + obj.imageFileName
        ]

        if (obj.posts) {
            def posts = []
            for (p in obj.posts) {
                posts.add(convert(p))
            }
            post.posts = posts
        }

        return post
    }

}
