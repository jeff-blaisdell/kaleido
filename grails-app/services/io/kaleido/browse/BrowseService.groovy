package io.kaleido.browse


class BrowseService {

    private static final int MAX_POSTS_PER_PAGE = 25
    private static final String DATE_FORMAT = "yyyyMMddkkmmssSS"
    private static Object[] POST_PAGES = null;
    private static int TOTAL_POSTS = 0;
    private static int TOTAL_PAGES = 0;

    /**
     * The following method is executed from Bootstrap.groovy on initialization.
     * On startup pre-compute all the pages of posts to show on home page.  This
     * will be then used by the infinite scrolling functionality.
     */
    def initialize() {

        // Gather all the posts we will show.
        def posts = selectPosts();

        TOTAL_POSTS = (posts == null ? 0 : posts.size());

        if (!posts) {
            TOTAL_PAGES = 0;
            return;
        }

        // Break the posts up into a set amount of pages.
        TOTAL_PAGES = Math.ceil((double) posts.size() / MAX_POSTS_PER_PAGE);
        POST_PAGES = new Object[TOTAL_PAGES];

        // Build the page models and store in an array of the pages.
        for (int p = 0; p < TOTAL_PAGES; p++) {
            int start = p * MAX_POSTS_PER_PAGE;
            int end = start + MAX_POSTS_PER_PAGE;
            end = (end  > TOTAL_POSTS ? TOTAL_POSTS : end);
            List<Post> items = posts.subList(start, end);
            Map page = buildPage(items, p + 2, p);
            POST_PAGES[p] = page;
        }

    }

    /**
     * Lookup the appropriate page of posts.
     * @param pageNumber
     * @return A page map [posts {List<Post>}, nextPage {Integer}, prevPage {Integer}].
     */
    def selectPage(Integer pageNumber) {

        if (!POST_PAGES)
            return null;

        if (!pageNumber || pageNumber == 0)
            return POST_PAGES[0];

        if (pageNumber > TOTAL_PAGES)
            return null;

        return POST_PAGES[pageNumber -1];
    }

    /**
     * Build map representing page model.
     * @param posts A list of posts for a page.
     * @param nextPost The post to trigger the next page.
     * @param prevPost The post to trigger the previous page.
     * @return
     */
    private static Map buildPage(posts, nextPage, prevPage) {
        def dateFormat = DATE_FORMAT
        def items = []
        nextPage = (nextPage > TOTAL_PAGES ? null : nextPage);
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
        def posts = Post.findAll(sort: 'publishedDate', order: 'desc', max: 1000, cache: false) {
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
