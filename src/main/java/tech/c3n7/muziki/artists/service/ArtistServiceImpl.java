package tech.c3n7.muziki.artists.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import tech.c3n7.muziki.artists.dao.ArtistRepository;
import tech.c3n7.muziki.artists.dto.ArtistListResponseDTO;
import tech.c3n7.muziki.artists.entity.Artist;

import java.util.List;

@Service
public class ArtistServiceImpl implements ArtistService {
    @Autowired
    private ArtistRepository artistRepository;

    @Override
    public ArtistListResponseDTO findAll(int pageNumber, int pageSize) {
        List<Artist> artists = artistRepository.findByDeletedAtIsNull(PageRequest.of(pageNumber - 1, pageSize));
        long total = artistRepository.countByDeletedAtIsNull();
        return new ArtistListResponseDTO(artists, pageNumber, pageSize, total);
    }

    @Override
    public ArtistListResponseDTO findByName(String name, int pageNumber, int pageSize) {
        List<Artist> artists = artistRepository.findByNameAndDeletedAtIsNull(name, PageRequest.of(pageNumber - 1, pageSize));
        long total = artistRepository.countByNameAndDeletedAtIsNull(name);
        return new ArtistListResponseDTO(artists, pageNumber, pageSize, total);
    }

    @Override
    public Artist createArtist(String name) {
        Artist artist = new Artist();
        artist.setName(name);
        artistRepository.save(artist);

        return artist;
    }
}
