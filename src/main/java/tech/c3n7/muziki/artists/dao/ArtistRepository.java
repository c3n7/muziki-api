package tech.c3n7.muziki.artists.dao;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import tech.c3n7.muziki.artists.entity.Artist;

import java.util.List;

public interface ArtistRepository extends JpaRepository<Artist, Integer> {
    List<Artist> findByDeletedAtIsNull();
    List<Artist> findByDeletedAtIsNull(Pageable pageable);

    long countByDeletedAtIsNull();
}
