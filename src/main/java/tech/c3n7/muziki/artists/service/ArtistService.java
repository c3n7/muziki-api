package tech.c3n7.muziki.artists.service;

import org.springframework.web.multipart.MultipartFile;
import tech.c3n7.muziki.artists.dto.ArtistListResponseDTO;
import tech.c3n7.muziki.artists.entity.Artist;

import java.util.List;
import java.util.Optional;

public interface ArtistService {
    ArtistListResponseDTO findAll(int pageNumber, int pageSize);

    ArtistListResponseDTO findByName(String name, int pageNumber, int pageSize);

    Artist createArtist(String name, Optional<MultipartFile> cover);
}
