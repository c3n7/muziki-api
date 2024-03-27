package tech.c3n7.muziki.artists.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tech.c3n7.muziki.artists.dto.ArtistListResponseDTO;
import tech.c3n7.muziki.artists.entity.Artist;
import tech.c3n7.muziki.artists.service.ArtistService;

import java.util.List;

@RestController
@RequestMapping("/artists")
public class ArtistController {
    @Autowired
    private ArtistService artistService;

    @GetMapping
    public ArtistListResponseDTO getArtists(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "20") int size)
    {
        return artistService.findAll(page, size);
    }
}
