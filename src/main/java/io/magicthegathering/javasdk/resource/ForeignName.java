package io.magicthegathering.javasdk.resource;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ForeignName {

    private String name;

    private String imageUrl;

    private String language;

    @JsonProperty("multiverseid")
    private int multiverseId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getMultiverseId() {
        return multiverseId;
    }

    public void setMultiverseId(int multiverseId) {
        this.multiverseId = multiverseId;
    }
}
