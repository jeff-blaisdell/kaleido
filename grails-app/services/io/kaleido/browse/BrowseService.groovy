package io.kaleido.browse


class BrowseService {

    /**
     * Responsible for returning the next [max] posts less then the
     * date parameter.
     * @param date The date to compare posts against.
     * @param max The maximum number of posts to return.
     */
    def selectPostsByPublishedDate(Date date) {
       def posts

       if (date) {
           posts =  Post.findAll(max: 25, sort: 'publishedDate', order: 'desc') {
               publishedDate < date
           }
       } else {
           posts = Post.findAll(max: 25, sort: 'publishedDate', order: 'desc') {}
       }

       return posts
    }

}
