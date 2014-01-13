package io.kaleido.browse

import io.kaleido.profile.PreferenceType

class UnderConstructionController {

    def preferenceService

    def index() {
        boolean notified = false

        if (params.email) {
            preferenceService.save(params.email as String, PreferenceType.UNDER_CONSTRUCTION_NOTIFICATION, true)
            notified = true
        }

        render(view: 'underConstruction', model: [notified: notified, email: params.email])
    }
}
