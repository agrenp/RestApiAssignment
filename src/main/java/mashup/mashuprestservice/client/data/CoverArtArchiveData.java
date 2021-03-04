package mashup.mashuprestservice.client.data;

import com.fasterxml.jackson.databind.JsonNode;
import mashup.mashuprestservice.client.CoverArtArchiveClient;

public class CoverArtArchiveData {
    private String imageUrl;

    public CoverArtArchiveData(JsonNode rootnode) {
        setImageUrl(getImageUrlFromNode(rootnode));
    }

    public String getImageUrl() {
        return imageUrl;
    }

    private String setImageUrl(String imageUrl) {
        return this.imageUrl = imageUrl;
    }

    private String getImageUrlFromNode (JsonNode rootNode) {
        return rootNode.findPath("image").textValue();
    }
}
