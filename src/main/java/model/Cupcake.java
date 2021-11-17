package model;

public class Cupcake {
    private Integer id;
    private String name;
    private String disc;
    private String imageURL;
    private int bottomPrice;
    private int toppingPrice;

    public Cupcake(Integer id, String name, String disc, String imageURL, int bottomPrice, int toppingPrice) {
        this.id = id;
        this.name = name;
        this.disc = disc;
        this.imageURL = imageURL;
        this.bottomPrice = bottomPrice;
        this.toppingPrice = toppingPrice;
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

    public int getBottomPrice() {
        return bottomPrice;
    }

    public int getToppingPrice() {
        return toppingPrice;
    }
}