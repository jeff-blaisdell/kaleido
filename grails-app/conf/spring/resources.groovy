import io.kaleido.converter.CustomConversionService
import io.kaleido.marshaller.PostMarshaller
import io.kaleido.converter.PostConverter
import io.kaleido.marshaller.CustomMarshallerService
import io.kaleido.profile.AuthFailureListener
import io.kaleido.profile.AuthSuccessListener
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler

// Place your Spring DSL code here
beans = {

    userDetailsService(io.kaleido.profile.CustomUserDetailsService)

    redirectFailureHandlerExample(SimpleUrlAuthenticationFailureHandler) {
        defaultFailureUrl = '/failed' //redirect to this URL when authentication fails
    }

    redirectSuccessHandlerExample(SimpleUrlAuthenticationSuccessHandler) {
        defaultTargetUrl = '/' //redirect to this URL when authentication fails
    }

    authFailureListener(AuthFailureListener) {
        profileService = profileService
    }

    authSuccessListener(AuthSuccessListener) {
        profileService = profileService
    }

    customMarshallerService( CustomMarshallerService ) {
        marshallers = [
                new PostMarshaller()
        ]
    }

    customConversionService( CustomConversionService ) {
        converters = [
            new PostConverter()
        ]
    }

}
