package tech.c3n7.muziki.artists.dto;

import jakarta.validation.constraints.NotBlank;

public class CreateArtistDTO {
    @NotBlank(message="This field is required.")
    private String name;

    public CreateArtistDTO(String name) {
        this.name = name;
    }

    public CreateArtistDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
