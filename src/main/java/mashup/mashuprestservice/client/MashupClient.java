package mashup.mashuprestservice.client;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import mashup.mashuprestservice.client.data.CoverArtArchiveData;
import mashup.mashuprestservice.client.data.MusicBrainzData;
import mashup.mashuprestservice.client.data.WikiData;
import mashup.mashuprestservice.model.Album;
import mashup.mashuprestservice.model.Artist;
import reactor.core.publisher.Mono;

public class MashupClient {
    private final MusicBrainzClient musicBrainzClient;
    private final WikipediaClient wikipediaClient;
    private final CoverArtArchiveClient coverArtClient;

    public MashupClient(MusicBrainzClient musicBrainzClient, WikipediaClient wikipediaClient, CoverArtArchiveClient coverArtClient) {
        this.musicBrainzClient = musicBrainzClient;
        this.wikipediaClient = wikipediaClient;
        this.coverArtClient = coverArtClient;
    }

    public String getArtistInfoByMbid(String mbid) {
        MusicBrainzData musicBrainzData = musicBrainzClient.getMusicBrainzDataForMbid(mbid);
        String id = musicBrainzData.getArtistWikidataId();
        //WikiData wikiData = wikipediaClient.getWikiDataFromId(id);
       // String artistDescription = wikiData.getArtistDescription();
        List<Album> albums = musicBrainzData.getAlbums();
        for(Album album : albums) {
            //album.setImage(coverArtClient.getCoverArtArchiveDataForMbid(album.getId()).getImageUrl());
        }

        Artist artist = new Artist(mbid, " ", albums);
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "";
        try {
            jsonString = mapper.writeValueAsString(artist);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "A problem with parsing the artist object occured";
        }
        return jsonString;
    }
}
