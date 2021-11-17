package model;

public class Cupcake {
    private int id;
    private String name;
    private String desc;
    private String imageURL;
    private String bottom;
    private int bottomID;
    private int bottomPrice;
    private String topping;
    private int toppingID;
    private int toppingPrice;
    private int amount;

    public Cupcake(int id, String name, String desc, String imageURL, int bottomID, int bottomPrice, int toppingID, int toppingPrice) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.imageURL = imageURL;
        this.bottomID = bottomID;
        this.bottomPrice = bottomPrice;
        this.toppingID = toppingID;
        this.toppingPrice = toppingPrice;
    }

    public Cupcake(String bottom, String topping, int amount) {
        this.bottom = bottom;
        this.topping = topping;
        this.amount = amount;
    }

    public int getId() {
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

    public int getAmount() {
        return amount;
    }

    public String getBottom() {
        return bottom;
    }

    public String getTopping() {
        return topping;
    }
}