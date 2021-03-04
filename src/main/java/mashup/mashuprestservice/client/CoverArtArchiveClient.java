package mashup.mashuprestservice.client;

import com.fasterxml.jackson.databind.JsonNode;
import mashup.mashuprestservice.client.data.CoverArtArchiveData;
import mashup.mashuprestservice.client.data.MusicBrainzData;
import org.springframework.web.reactive.function.client.WebClient;

public class CoverArtArchiveClient {
    private String BASE_URI = "http://coverartarchive.org/";
    private WebClient webClient;

    public CoverArtArchiveClient() {
        this.webClient = WebClient.create(BASE_URI);
    }

    public CoverArtArchiveData getCoverArtArchiveDataForMbid(String mbid) {
        return new CoverArtArchiveData(getExternalApiResponseFromMbid(mbid));
    }

    private JsonNode getExternalApiResponseFromMbid(String mbid) {
        return webClient.get()
                        .uri("release-group/{mbid}", mbid)
                        .retrieve()
                        .bodyToMono(JsonNode.class)
                        .block();
    }
}
