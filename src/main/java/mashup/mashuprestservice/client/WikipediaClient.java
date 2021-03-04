package mashup.mashuprestservice.client;

import com.fasterxml.jackson.databind.JsonNode;
import mashup.mashuprestservice.client.data.MusicBrainzData;
import mashup.mashuprestservice.client.data.WikiData;
import org.springframework.web.reactive.function.client.WebClient;

public class WikipediaClient {
    private String BASE_URI = "https://en.wikipedia.org/w/api.php";
    private WebClient webClient;

    public WikipediaClient() {
        this.webClient = WebClient.create(BASE_URI);
    }

    public WikiData getWikiDataFromId(String wikidataId) {
        return new WikiData(getExternalApiResponseFromId(wikidataId));
    }

    private JsonNode getExternalApiResponseFromId(String wikidataId) {
        return webClient.get()
                        .uri("?action=wbgetentities&ids={wikidataId}&format=json&props=sitelinks", wikidataId)
                        .retrieve()
                        .bodyToMono(JsonNode.class)
                        .block();
    }
}
