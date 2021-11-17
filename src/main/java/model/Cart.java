package model;

public class Cart {
    private int id;
    private int userId;
    private int orderItemsId;

    public Cart(int id, int userId, int orderItemsId) {
        this.id = id;
        this.userId = userId;
        this.orderItemsId = orderItemsId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getOrderItemsId() {
        return orderItemsId;
    }

    public void setOrderItemsId(int orderItemsId) {
        this.orderItemsId = orderItemsId;
    }
}
