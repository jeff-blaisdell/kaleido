package io.kaleido.profile

class PreferenceService {

    def save(String email, PreferenceType type, boolean active) {
        if (active) {
            Preference preference = new Preference(email: email, type: type, active: active);
            preference.save()
        }
    }
}
