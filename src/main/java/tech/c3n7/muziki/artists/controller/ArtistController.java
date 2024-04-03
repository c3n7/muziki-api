package tech.c3n7.muziki.artists.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.c3n7.muziki.artists.dto.ArtistListResponseDTO;
import tech.c3n7.muziki.artists.dto.CreateArtistRestModel;
import tech.c3n7.muziki.artists.entity.Artist;
import tech.c3n7.muziki.artists.service.ArtistService;

@RestController
@RequestMapping("/artists")
public class ArtistController {
    @Autowired
    private ArtistService artistService;

    @GetMapping
    public ArtistListResponseDTO getArtists(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "20") int size) {
        return artistService.findAll(page, size);
    }

    @PostMapping
    public Artist createArtist(@Valid @ModelAttribute CreateArtistRestModel artist) {
        return artistService.createArtist(artist.getName(), artist.getCover());
    }
}
