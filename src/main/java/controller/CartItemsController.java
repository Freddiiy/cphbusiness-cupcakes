package controller;

import model.CartItems;
import model.Cupcake;
import model.CustomCupcake;
import model.User;
import persistance.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class CartItemsController {
    private final Database database;

    public CartItemsController(Database database) {
        this.database = database;
    }

    public void addToCart(CartItems cartItems, String sessionId) {
        String sql = "INSERT INTO CartItems (id_bottom, id_topping, id_user, amount) VALUES(" +
                "(SELECT id_bottom FROM Bottom WHERE name = ?)," +
                "(SELECT id_topping FROM Topping WHERE name = ?)," +
                "(SELECT id_user FROM Users WHERE sessionID = ?)," +
                "?)";

        try (Connection connection = database.connect()) {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, cartItems.getBottom());
            ps.setString(2, cartItems.getTopping());
            ps.setString(3, sessionId);
            ps.setInt(4, cartItems.getAmount());

            ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
