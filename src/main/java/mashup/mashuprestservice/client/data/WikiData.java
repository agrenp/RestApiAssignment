package mashup.mashuprestservice.client.data;

import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

public class WikiData {
    private String artistDescription;

    public WikiData(JsonNode rootNode){
        setArtistDescription(getArtistDescriptionFromWikiNode(rootNode));
    }

    public String getArtistDescription() {
        return artistDescription;
    }

    private String setArtistDescription(String artistDescription) {
        return this.artistDescription = artistDescription;
    }

    private String getArtistDescriptionFromWikiNode(JsonNode rootNode) {
        System.out.println("Rootnode in wiki " + rootNode.toPrettyString());
        //ArrayNode siteLinksNode = (ArrayNode) rootNode.findValue("sitelinks");
        JsonNode siteLinksNode = rootNode.findValue("sitelinks");
        //String artistDescription = siteLinksNode.findPath("enwiki").findPath("title").textValue();
        String artistDescription = siteLinksNode.toPrettyString();
        System.out.println("Artist description: " + artistDescription);
        return artistDescription;
    }
}
