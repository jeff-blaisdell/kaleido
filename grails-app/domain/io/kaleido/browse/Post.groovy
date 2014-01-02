package io.kaleido.browse

import io.kaleido.profile.User
import org.bson.types.ObjectId

class Post {

    ObjectId id
    String title
    String description
    String keywords
    String imageFileName
    String content
    Date publishedDate
    User user
    ArrayList<Post> posts

    static embedded = ['posts']

    static mapping = {
        publishedDate index:true
    }

    static constraints = {
        title blank:true, maxSize:25
        description blank:true, maxSize:200
        keywords blank:true, maxSize:25
        imageFileName blank:true, maxSize:3000
        content blank:true, maxSize:1000
        publishedDate blank:false
        user blank:false
    }
}
