package mashup.mashuprestservice.client.data;

import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import mashup.mashuprestservice.model.Album;
import org.springframework.util.StreamUtils;

public class MusicBrainzData {
    private String artistWikidataId;
    private List<Album> albums;

    public MusicBrainzData(JsonNode rootNode) {
        setArtistWikidataId(getWikidataIdFromRelationsNode(rootNode));
        setAlbums(getAlbumsFromReleaseGroups(rootNode));
    }

    public String getArtistWikidataId() {
        return artistWikidataId;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    private void setArtistWikidataId(String artistWikidataId) {
        this.artistWikidataId = artistWikidataId;
    }

    private void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    private String getWikidataIdFromRelationsNode(JsonNode rootNode) {
        ArrayNode relationsNode = (ArrayNode) rootNode.path("relations");
        Stream<JsonNode> relations = StreamSupport.stream(Spliterators
                .spliteratorUnknownSize(relationsNode.elements(),
                        Spliterator.ORDERED),false);

        JsonNode wikiNode = relations.filter(relationNode -> relationNode.path("type").textValue().equals("wikidata")).findFirst().orElseThrow(() -> new RuntimeException("The type wikidata was not found"));
        String wikidataId = wikiNode.findPath("url").findPath("resource").textValue().replace("https://www.wikidata.org/wiki/","");
        return wikidataId;
    }

    //TODO
    /*
    private String getWikidataTitleFromRelationsNode(JsonNode rootNode) {
    }
    */

    private List<Album> getAlbumsFromReleaseGroups(JsonNode rootNode) {
        ArrayNode releaseGroups = (ArrayNode) rootNode.path("release-groups");

        Stream<JsonNode> albumNodes = StreamSupport.stream(Spliterators
                .spliteratorUnknownSize(releaseGroups.elements(),
                        Spliterator.ORDERED),false);

        return albumNodes
                .map(albumNode -> {return new Album(
                        albumNode.path("id").textValue(),
                        albumNode.path("title").textValue(),
                        "");
                })
                .collect(Collectors.toList());
    }

}
