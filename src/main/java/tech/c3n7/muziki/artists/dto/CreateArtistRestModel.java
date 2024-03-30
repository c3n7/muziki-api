package tech.c3n7.muziki.artists.dto;

import jakarta.validation.constraints.NotBlank;

public class CreateArtistRestModel {
    @NotBlank(message="This field is required.")
    private String name;

    public CreateArtistRestModel(String name) {
        this.name = name;
    }

    public CreateArtistRestModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
