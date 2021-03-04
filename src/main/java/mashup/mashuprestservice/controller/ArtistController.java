package mashup.mashuprestservice.controller;

import mashup.mashuprestservice.client.MashupClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArtistController {
    private final MashupClient mashupClient;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    public ArtistController(MashupClient mashupClient) {
        this.mashupClient = mashupClient;
    }

    @GetMapping("mbid/{mbid}")
    public String artist(@PathVariable String mbid) {
        return mashupClient.getArtistInfoByMbid(mbid);
    }
}
