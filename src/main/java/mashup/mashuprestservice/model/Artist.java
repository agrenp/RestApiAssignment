package mashup.mashuprestservice.model;

import java.util.List;

public class Artist {
    private String mbid;
    private String description;
    private List<Album> albums;

    /**
     * Constructor for representation of an artist
     * 
     * @param mbid          unique identifier of the artist
     * @param description   description of the artist
     * @param albums        a list of all albums created by the artist
     */
    public Artist(String mbid, String description, List<Album> albums) {
        this.mbid = mbid;
        this.description = description;
        this.albums = albums;
    }

    public String getMbid() {
        return mbid;
    }

    public String getDescription() {
        return description;
    }

    public List<Album> getAlbums() {
        return albums;
    }
}