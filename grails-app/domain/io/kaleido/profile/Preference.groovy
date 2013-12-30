package io.kaleido.profile

import org.bson.types.ObjectId

class Preference {

    ObjectId id
    String email
    PreferenceType type
    boolean active

    static constraints = {
        email blank:false, unique:false, maxSize:100
        type nullable:false, blank:false
        active nullable:false, blank:false
    }

    static mapping = {
        compoundIndex email:1, type:1, indexAttributes: [unique:true]
    }
}
