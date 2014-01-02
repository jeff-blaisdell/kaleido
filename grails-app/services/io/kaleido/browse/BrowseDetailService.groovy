package io.kaleido.browse

import org.bson.types.ObjectId

class BrowseDetailService {

    def customConversionService

    def findPost(id) {
        def post = Post.findById(new ObjectId(id as String))
        return customConversionService.convert(post)

    }

}
