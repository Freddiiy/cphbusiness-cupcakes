package controller;

import model.CartItems;
import model.Cupcake;
import model.CustomCupcake;
import model.User;
import persistance.Database;

import java.sql.*;

public class CartItemsController {
    private final Database database;

    public CartItemsController(Database database) {
        this.database = database;
    }


}
