package io.kaleido.profile

import org.springframework.dao.DataIntegrityViolationException

class PreferenceService {

    def save(String email, PreferenceType type, boolean active) {
        if (active) {
            Preference preference = new Preference(email: email, type: type, active: active);
            try {
                preference.save(flush: true)
            } catch (DataIntegrityViolationException e) {
              log.debug("DB unique key violation while inserting profile preference.", e)
            }
        }
    }
}
