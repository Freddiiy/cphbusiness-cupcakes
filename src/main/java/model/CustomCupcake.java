package model;

public class CustomCupcake {
    private int id;
    private String bottom;
    private double bottomPrice;
    private String topping;
    private double toppingPrice;
    private double totalPrice;
    private int amount;

    public CustomCupcake(String bottom, String topping, int amount) {
        this.bottom = bottom;
        this.topping = topping;
        this.amount = amount;
    }

    public CustomCupcake(String bottom, double bottomPrice, String topping, double toppingPrice, double totalPrice, int amount) {
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

    public void setId(int id) {
        this.id = id;
    }

    public String getBottom() {
        return bottom;
    }

    public void setBottom(String bottom) {
        this.bottom = bottom;
    }

    public double getBottomPrice() {
        return bottomPrice;
    }

    public void setBottomPrice(double bottomPrice) {
        this.bottomPrice = bottomPrice;
    }

    public String getTopping() {
        return topping;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }

    public double getToppingPrice() {
        return toppingPrice;
    }

    public void setToppingPrice(double toppingPrice) {
        this.toppingPrice = toppingPrice;
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

    public void setAmount(int amount) {
        this.amount = amount;
    }

}
