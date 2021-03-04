package mashup.mashuprestservice.model;

public class Album {
    private String id;
    private String title;
    private String image;

    /**
     * Constructor for representation of an album
     * 
     * @param id        unique identifier for the album
     * @param title     title of the album
     * @param image     url-source to image
     */
    public Album(String id, String title, String image) {
        this.id = id;
        this.title = title;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public String setImage(String image) {
        return this.image = image;
    }

}