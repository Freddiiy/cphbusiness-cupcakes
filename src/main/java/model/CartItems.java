package model;

public class CartItems {
    private int id;
    private String bottom;
    private String topping;
    private int amount;

    public CartItems(int id, String bottom, String topping, int amount) {
        this.id = id;
        this.bottom = bottom;
        this.topping = topping;
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

    public String getTopping() {
        return topping;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
