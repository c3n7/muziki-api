package tech.c3n7.muziki.artists.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;
import tech.c3n7.muziki.artists.dto.ArtistListResponseDTO;
import tech.c3n7.muziki.artists.dto.CreateArtistDTO;
import tech.c3n7.muziki.artists.entity.Artist;
import tech.c3n7.muziki.artists.service.ArtistService;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@TestPropertySource("/application-test.properties")
@AutoConfigureMockMvc
@SpringBootTest
@Transactional
public class ArtistControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ArtistService artistService;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void getArtistsHttpRequest() throws Exception {
        artistService.createArtist("John Doe");
        artistService.createArtist("Jane Doe");

        mockMvc.perform(MockMvcRequestBuilders.get("/artists"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data", hasSize(2)))
                .andExpect(jsonPath("$.pageSize", equalTo(20)))
                .andExpect(jsonPath("$.pageNumber", equalTo(1)));

    }

    @Test
    public void createArtistHttpRequest() throws Exception {
        CreateArtistDTO artist = new CreateArtistDTO("John Doe");

        mockMvc.perform(MockMvcRequestBuilders.post("/artists")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(artist)))
                .andExpect(status().isOk());

        ArtistListResponseDTO artists = artistService.findByName("John Doe", 1, 20);
         assertEquals(artists.getData().getFirst().getName(), "John Doe");
    }
}
