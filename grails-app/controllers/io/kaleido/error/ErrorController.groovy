package io.kaleido.error

class ErrorController {

    def notFound() {
        render(view: '404')
    }

    def forbidden() {
        render(view: '403')
    }

    def internalServerError() {
        render(view: '500')
    }

}
