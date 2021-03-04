package mashup.mashuprestservice.client;

import com.fasterxml.jackson.databind.JsonNode;
import mashup.mashuprestservice.client.data.MusicBrainzData;
import org.springframework.web.reactive.function.client.WebClient;

public class MusicBrainzClient {
    private String BASE_URI = "http://musicbrainz.org/ws/2";
    private WebClient webClient;

    public MusicBrainzClient() {
        this.webClient = WebClient.create(BASE_URI);
    }

    public MusicBrainzData getMusicBrainzDataForMbid(String mbid) {
        return new MusicBrainzData(getExternalApiResponseFromMbid(mbid));
    }

    private JsonNode getExternalApiResponseFromMbid(String mbid) {
        return webClient.get()
                        .uri("/artist/{mbid}?&fmt=json&inc=url-rels+release-groups", mbid)
                        .retrieve()
                        .bodyToMono(JsonNode.class)
                        .block();
    }
}
