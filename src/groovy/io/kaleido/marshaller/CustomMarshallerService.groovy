package io.kaleido.marshaller

class CustomMarshallerService {

    List marshallers = []

    def register() {
        marshallers.each{ it.register() }
    }

}
