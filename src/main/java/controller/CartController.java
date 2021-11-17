package controller;

import model.CartItems;
import persistance.Database;

import java.sql.*;

public class CartController {
    private final Database database;

    public CartController(Database database) {
        this.database = database;
    }

    public void addToCart(CartItems cartItems, String sessionId) {
        int idKey = 0;

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

            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("No affected rows");
            }

            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                idKey = generatedKeys.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        if (idKey == 0) {
            System.out.println("No key retrieved");
        } else {
            String insertIdToCart = "INSERT INTO Cart (id_cartitems, id_user) VALUES(?, (SELECT id_user FROM Users WHERE sessionID = ?))";

            try (Connection connection = database.connect()) {
                PreparedStatement ps = connection.prepareStatement(insertIdToCart);
                ps.setInt(1, idKey);
                ps.setString(2, sessionId);

                ps.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
