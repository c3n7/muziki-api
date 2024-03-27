package tech.c3n7.muziki.artists.service;

import tech.c3n7.muziki.artists.dto.ArtistListResponseDTO;
import tech.c3n7.muziki.artists.entity.Artist;

import java.util.List;

public interface ArtistService {
    ArtistListResponseDTO findAll(int pageSize, int pageNumber);
}
