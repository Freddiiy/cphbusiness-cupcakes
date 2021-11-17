package model;

public class Cupcake {
    private Integer id;
    private String name;
    private String desc;
    private String imageURL;
    private int bottomID;
    private int bottomPrice;
    private int toppingID;
    private int toppingPrice;

    public Cupcake(Integer id, String name, String desc, String imageURL, int bottomID, int bottomPrice, int toppingID, int toppingPrice) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.imageURL = imageURL;
        this.bottomID = bottomID;
        this.bottomPrice = bottomPrice;
        this.toppingID = toppingID;
        this.toppingPrice = toppingPrice;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public String getImageURL() {
        return imageURL;
    }

    public int getBottomID() {
        return bottomID;
    }

    public int getBottomPrice() {
        return bottomPrice;
    }

    public int getToppingID() {
        return toppingID;
    }

    public int getToppingPrice() {
        return toppingPrice;
    }
}