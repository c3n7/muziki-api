package tech.c3n7.muziki.artists.dto;

import tech.c3n7.muziki.artists.entity.Artist;

import java.util.List;

public class ArtistListResponseDTO {
    private List<Artist> data;
    private int pageNumber;
    private int pageSize;

    public ArtistListResponseDTO(List<Artist> data, int pageNumber, int pageSize) {
        this.data = data;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }

    public List<Artist> getData() {
        return data;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }
}
