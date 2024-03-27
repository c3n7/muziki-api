package tech.c3n7.muziki.artists.dto;

import tech.c3n7.muziki.artists.entity.Artist;

import java.util.List;

public class ArtistListResponseDTO {
    private final List<Artist> data;
    private final int pageNumber;
    private final int pageSize;
    private final int from;
    private final int to;
    private final long total;

    public ArtistListResponseDTO(List<Artist> data, int pageNumber, int pageSize, long total) {
        this.data = data;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.total = total;
        this.from = pageSize * (pageNumber - 1) + 1;
        this.to = pageSize * pageNumber;
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

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    public long getTotal() {
        return total;
    }
}
