package model;

public class Cupcake {
    private int id;
    private String name;
    private String desc;
    private String imageURL;
    private String bottom;
    private int bottomID;
    private double bottomPrice;
    private String topping;
    private int toppingID;
    private double toppingPrice;
    private double totalPrice;
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

    public Cupcake(String bottom, double bottomPrice, String topping, double toppingPrice, double totalPrice, int amount) {
        this.bottom = bottom;
        this.bottomPrice = bottomPrice;
        this.topping = topping;
        this.toppingPrice = toppingPrice;
        this.totalPrice = totalPrice;
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

    public double getBottomPrice() {
        return bottomPrice;
    }

    public int getToppingID() {
        return toppingID;
    }

    public double getToppingPrice() {
        return toppingPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
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