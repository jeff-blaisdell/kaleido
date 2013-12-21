package io.kaleido.browse


class BrowseService {

    private static final int MAX_POSTS_PER_PAGE = 25
    private static final String DATE_FORMAT = "yyyyMMddkkmmssSS"

    def grailsLinkGenerator

    /**
     * Selects the posts for a given page.
     * A page is determine by the next set of posts
     * after a particular date.  If no date specified
     * the caller will be returned the first page.
     * @param current A date parameter representing the current page.
     * @return A map representing the page model.
     */
    def selectPostPage(Date current) {
        def page
        def posts
        def nextPost
        def prevPost
        def startDate = getStartDate()
        def endDate = getEndDate()
        def maxPost = getMaxPost(startDate)
        def minPost = getMinPost(endDate)

        if (!current || current.compareTo(maxPost.publishedDate) == 0) {
            posts = selectFirstPagePosts(startDate, endDate)
        } else {
            posts = this.selectPostsForPage(startDate, endDate, current)
        }

        if (posts) {
            nextPost = this.findNextPost(minPost, posts)
            prevPost = this.findPrevPost(startDate, endDate, current, maxPost, posts)
        }

        page = buildPage(posts, nextPost, prevPost)

        return page
    }

    /**
     * Build map representing page model.
     * @param posts A list of posts for a page.
     * @param nextPost The post to trigger the next page.
     * @param prevPost The post to trigger the previous page.
     * @return
     */
    def Map buildPage(posts, nextPost, prevPost) {
        def dateFormat = DATE_FORMAT
        def items = []
        def nextPageUrl
        def prevPageUrl
        if (posts) {
            for (post in posts) {
                items.add([
                        id: post.id.toString(),
                        title: post.title,
                        email: post.user?.email,
                        publishedDate: post.publishedDate.format(dateFormat),
                        imageUrl: "http://placehold.it/" + post.imageFileName
                ])
            }
        }

        if (nextPost)
            nextPageUrl = grailsLinkGenerator.link(controller: 'browse', action: 'browse', absolute: true, params: [page: nextPost.publishedDate.format(dateFormat), title: nextPost.title])

        if (prevPost)
            prevPageUrl = grailsLinkGenerator.link(controller: 'browse', action: 'browse', absolute: true, params: [page: prevPost.publishedDate.format(dateFormat), title: prevPost.title])

        return ['posts': items, 'nextPageUrl': nextPageUrl, 'prevPageUrl': prevPageUrl]
    }

    def String getDateFormat() {
        return DATE_FORMAT
    }

    /**
     * The start date to use when determining pagination window.
     * @return Date
     */
    def Date getStartDate() {
        def date = new Date()

        return date.clearTime()
    }

    /**
     * The end date to use when determining pagination window.
     * @return Date
     */
    def Date getEndDate() {
        def date = new Date().clearTime()
        int year = date[Calendar.YEAR]
        date.set(year: year - 1)
        return date
    }

    /**
     * Returns the post with the most recent publish date
     * after the given start date.
     * @param startDate
     * @return Post
     */
    private Post getMaxPost(startDate) {
        def maxPost = Post.findAll(max: 1, sort: 'publishedDate', order: 'desc') {
            publishedDate < startDate
        }
        maxPost = (maxPost ? maxPost.first() : null)
        return maxPost
    }

    /**
     * Returns the post with the oldest publish date
     * prior to the given end date.
     * @param endDate
     * @return Post
     */
    private Post getMinPost(endDate) {
        def minPost = Post.findAll(max: 1, sort: 'publishedDate', order: 'asc') {
            publishedDate > endDate
        }
        minPost = (minPost ? minPost.first() : null)
        return minPost
    }

    /**
     * Select the first pages' posts.
     * @param startDate
     * @param endDate
     * @return A list of posts
     */
    private List<Post> selectFirstPagePosts(startDate, endDate) {
        def posts = Post.findAll(max: MAX_POSTS_PER_PAGE, sort: 'publishedDate', order: 'desc') {
            publishedDate < startDate && publishedDate > endDate
        }
        return posts
    }

    /**
     * Select the posts for a give page.
     * @param startDate
     * @param endDate
     * @param current
     * @return A list of posts
     */
    private List<Post> selectPostsForPage(startDate, endDate, current) {
        def posts = Post.findAll(max: MAX_POSTS_PER_PAGE, sort: 'publishedDate', order: 'desc') {
            publishedDate < current
            publishedDate < startDate && publishedDate > endDate
        }
        return posts
    }

    /**
     * Determine the post that triggers the next page
     * @param minPost
     * @param posts
     * @return A post
     */
    private Post findNextPost(Post minPost, List<Post> posts) {
        def nextPost = posts.last()
        if (nextPost.publishedDate.compareTo(minPost.publishedDate) <= 0) {
            nextPost = null
        }
        return nextPost
    }

    /**
     * Determine the post that triggers the previous page
     * @param startDate
     * @param endDate
     * @param current
     * @param maxPost
     * @param posts
     * @return A post
     */
    private Post findPrevPost(startDate, endDate, current, Post maxPost, List<Post> posts) {
        def prevPost = Post.findAll(max: MAX_POSTS_PER_PAGE , sort: 'publishedDate', order: 'asc') {
            publishedDate > current
            publishedDate < startDate && publishedDate > endDate
        }
        prevPost = (prevPost ? prevPost.last() : null)

        if (prevPost) {
            if (prevPost.publishedDate.compareTo(maxPost.publishedDate) > 0) {
                prevPost = null
            } else if (prevPost.publishedDate.compareTo(posts.first().publishedDate) == 0) {
                prevPost = null
            }
        }

        return prevPost
    }
}
