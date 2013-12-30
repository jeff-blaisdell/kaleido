package io.kaleido.browse

import io.kaleido.profile.PreferenceType

class BrowseController {

    def browseService
    def preferenceService

    def browse() {
        def page = browseService.selectPage(params.page ? Integer.parseInt(params.page as String) : null)

        render(view: 'browse', model: page)
    }

    /**
     * Under Construction / Coming Soon page used while site is being built.
     */
    def underConstruction() {

        boolean notified = false

        if (params.email) {
            preferenceService.save(params.email as String, PreferenceType.UNDER_CONSTRUCTION_NOTIFICATION, true)
            notified = true
        }

        render(view: 'underConstruction', model: [notified: notified, email: params.email])
    }

}
