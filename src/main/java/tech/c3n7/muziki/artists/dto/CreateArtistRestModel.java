package tech.c3n7.muziki.artists.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;

public class CreateArtistRestModel {
    @NotNull(message = "This field is required.")
    MultipartFile cover;
    @NotBlank(message = "This field is required.")
    private String name;

    public CreateArtistRestModel(String name) {
        this.name = name;
    }

    public CreateArtistRestModel(String name, MultipartFile cover) {
        this.name = name;
        this.cover = cover;
    }

    public CreateArtistRestModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MultipartFile getCover() {
        return cover;
    }

    public void setCover(MultipartFile cover) {
        this.cover = cover;
    }
}
