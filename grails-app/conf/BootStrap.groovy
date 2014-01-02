import io.kaleido.browse.Post
import io.kaleido.profile.Address
import io.kaleido.profile.Role
import io.kaleido.profile.User
import io.kaleido.profile.UserRole
import org.springframework.web.context.support.WebApplicationContextUtils

import javax.servlet.ServletConfig

class BootStrap {

    def browseService;

    def init = { servletContext ->

        // Get spring
        def springContext = WebApplicationContextUtils.getWebApplicationContext( servletContext )

        // Configure Custom JSON Serialization.
        springContext.getBean( "customMarshallerService" ).register()

        //Configure Security Roles
        def userRole = Role.findByAuthority('ROLE_USER') ?: new Role(authority: 'ROLE_USER').save(failOnError: true)
        def adminRole = Role.findByAuthority('ROLE_ADMIN') ?: new Role(authority: 'ROLE_ADMIN').save(failOnError: true)
        Role.findByAuthority('ROLE_FACEBOOK') ?: new Role(authority: 'ROLE_FACEBOOK').save(failOnError: true)

        def adminUser = User.findByEmail('jeff.j.blaisdell@gmail.com') ?: new User(
                email: 'jeff.j.blaisdell@gmail.com',
                password: 'password',
                firstName: 'Jeff',
                lastName: 'Blaisdell',
                birthDate: Date.parse('MMM dd yyyy', 'May 05 1981'),
                address: new Address(
                        line1: '7172 Jenner Bay S',
                        city: 'Cottage Grove',
                        state: 'MN',
                        country: 'US',
                        postalCode: '55016',
                        location: [lat: 44.848217d, long: -92.911141d]
                ),
                enabled: true).save(failOnError: true)

        adminUser.save()

        if (!adminUser.authorities.contains(adminRole)) {
            UserRole.create(adminUser, adminRole)
        }

        if (!adminUser.authorities.contains(userRole)) {
            UserRole.create(adminUser, userRole)
        }

        def imageSizes = ["350", "450", "550", "650"]

        def lookupBackgroundColor = { size ->
            if ("350".equals(size) ) {
                return "F2505D"
            } else if ("450".equals(size) ) {
                return "416EF2"
            } else if ("550".equals(size) ) {
                return "F2E85C"
            } else if ("650".equals(size) ) {
                return "F28749"
            }
            return "73323E"
        }

        def post = Post.first()
        def currentTime = new Date(System.currentTimeMillis())
        if (!post) {
            int day = 0;
            for (int i = 1000; i > 0; i--) {

                def imageSize = imageSizes[i%imageSizes.size()]
                def color = lookupBackgroundColor(imageSize)
                def publishedDate = currentTime.minus(day++)

                def p = new Post(
                    title: 'My Post #' + i,
                    description: 'An example post.',
                    keywords: 'Example Demo',
                    imageFileName: '350x' + imageSize  + '/' + color + '/ffffff/&text=Image',
                    content: 'A really interesting post about really cool stuff.',
                    publishedDate: publishedDate,
                    user: adminUser,
                    posts: new ArrayList<Post>()
                )

                for (int x = 0; x < 5; x++) {
                    def s = imageSizes[x%imageSizes.size()]
                    def c = lookupBackgroundColor(s)
                    def r = new Post(
                            title: 'My Post ' + getLetter(x),
                            description: 'An example post.',
                            keywords: 'Example Demo',
                            imageFileName: '650x' + (2 * Integer.parseInt(s))  + '/' + c + '/ffffff/&text=Image',
                            content: 'A really interesting post about really cool stuff.',
                            publishedDate: publishedDate,
                            user: adminUser
                    )
                    p.posts.add(r)
                }

                p.save(failOnError: true, flush: true)
            }
        }

        browseService.initialize();

    }

    def getLetter(int i) {
        String letter;
        switch (i) {
            case 0:
                letter = "A"
                break;
            case 1:
                letter = "B"
                break;
            case 2:
                letter = "C"
                break;
            case 3:
                letter = "D"
                break;
            case 4:
                letter = "E"
                break;
            default:
                letter =  "E"
                break;
        }
        return letter
    }

    def destroy = {
    }
}
