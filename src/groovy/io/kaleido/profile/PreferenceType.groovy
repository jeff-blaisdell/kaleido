package io.kaleido.profile

public enum PreferenceType {

    UNDER_CONSTRUCTION_NOTIFICATION("UNDER_CONSTRUCTION_NOTIFICATION", "An opt-in to being sent emails regarding to the go-live status of web site.");

    private String type;
    private String description;

    private PreferenceType(String type, String description) {
        this.type = type;
        this.description = description;
    }

    String getType() {
        return type
    }

    void setType(String type) {
        this.type = type
    }

    String getDescription() {
        return description
    }

    void setDescription(String description) {
        this.description = description
    }
}