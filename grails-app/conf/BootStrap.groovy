import io.kaleido.browse.Post
import io.kaleido.profile.Address
import io.kaleido.profile.Role
import io.kaleido.profile.User
import io.kaleido.profile.UserRole
import org.apache.commons.lang.math.RandomUtils

class BootStrap {

    def init = { servletContext ->

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

                new Post(
                    title: 'My Post #' + i,
                    description: 'An example post.',
                    keywords: 'Example Demo',
                    imageFileName: '350x' + imageSize  + '/' + color + '/ffffff/&text=Image',
                    content: 'A really interesting post about really cool stuff.',
                    publishedDate: publishedDate,
                    user: adminUser
                ).save(failOnError: true)
            }
        }

    }

    def destroy = {
    }
}
