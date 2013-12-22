package io.kaleido.browse


class BrowseService {
    private static final int MAX_POSTS_PER_PAGE = 25
    private static final String DATE_FORMAT = "yyyyMMddkkmmssSS"
    private Object[] postPages;
    private int totalPosts;
    private int totalPages;

    def initialize() {

        def posts = selectPosts();
        totalPosts = (posts == null ? 0 : posts.size());

        if (!posts) {
            totalPages = 0;
            return;
        }

        totalPages = Math.ceil((double) posts.size() / MAX_POSTS_PER_PAGE);
        postPages = new Object[totalPages];


        for (int p = 0; p < totalPages; p++) {
            int start = p * MAX_POSTS_PER_PAGE;
            int end = start + MAX_POSTS_PER_PAGE;
            end = (end  > totalPosts ? totalPosts : end);
            List<Post> items = posts.subList(start, end);
            Map page = this.buildPage(items, p + 2, p);
            postPages[p] = page;
        }

    }


    def selectPage(Integer pageNumber) {

        if (!postPages)
            return null;

        if (!pageNumber || pageNumber == 0)
            return postPages[0];

        if (pageNumber > totalPages)
            return null;

        return postPages[pageNumber -1];
    }

    /**
     * Build map representing page model.
     * @param posts A list of posts for a page.
     * @param nextPost The post to trigger the next page.
     * @param prevPost The post to trigger the previous page.
     * @return
     */
    def Map buildPage(posts, nextPage, prevPage) {
        def dateFormat = DATE_FORMAT
        def items = []
        nextPage = (nextPage > totalPages ? null : nextPage);
        prevPage = (prevPage < 0 ? null : prevPage);

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

        return ['posts': items, 'nextPage': nextPage, 'prevPage': prevPage]
    }

    /**
     * Select the posts.
     * @return A list of posts
     */
    private static List<Post> selectPosts() {
        Date startDate = getStartDate();
        Date endDate = getEndDate();
        def posts = Post.findAll(sort: 'publishedDate', order: 'desc', cache: false) {
            publishedDate < startDate && publishedDate > endDate
        }
        return posts
    }

    /**
     * The start date to use when determining pagination window.
     * @return Date
     */
    private static Date getStartDate() {
        def date = new Date()

        return date.clearTime()
    }

    /**
     * The end date to use when determining pagination window.
     * @return Date
     */
    private static Date getEndDate() {
        def date = new Date().clearTime()
        int year = date[Calendar.YEAR]
        date.set(year: year - 1)
        return date
    }

}
