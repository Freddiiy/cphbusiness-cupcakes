package model;

public class Cupcake {
    private Integer id;
    private String name;
    private String disc;
    private String imageURL;

    public Cupcake(Integer id, String name, String disc, String imageURL) {
        this.id = id;
        this.name = name;
        this.disc = disc;
        this.imageURL = imageURL;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDisc() {
        return disc;
    }

    public String getImageURL() {
        return imageURL;
    }
}