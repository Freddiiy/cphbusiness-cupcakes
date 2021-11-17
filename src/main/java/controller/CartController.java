package controller;

import model.CartItems;
import model.Cupcake;
import model.CustomCupcake;
import persistance.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartController {
    private final Database database;

    public CartController(Database database) {
        this.database = database;
    }

    public void addToCart(CartItems cartItems, String sessionId) {
        int idKey = 0;

        String sql = "INSERT INTO Cartitems (id_bottom, id_topping, id_user, amount) VALUES(" +
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

    public List getCart(String sessionId) {
        String sql = "SELECT Bottom.name, Bottom.bottomPrice, Topping.name, Topping.toppingPrice, ((Bottom.bottomPrice + Topping.toppingPrice) * Cartitems.amount) AS total_price, Cartitems.amount FROM Cart " +
                "INNER JOIN Cartitems ON Cart.id_cartitems = Cartitems.id_cartitems " +
                "INNER JOIN Bottom ON Cartitems.id_bottom = Bottom.id_bottom " +
                "INNER JOIN Topping ON Cartitems.id_topping = Topping.id_topping " +
                "INNER JOIN Users ON Cart.id_user = Users.id_user " +
                "WHERE Users.id_user = (SELECT id_user FROM Users WHERE sessionID = ?)";

        List<Cupcake> list = new ArrayList<>();

        try(Connection connection = database.connect()) {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, sessionId);

            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()) {
                list.add(new Cupcake(
                        resultSet.getString("Bottom.name"),
                        resultSet.getDouble("Bottom.bottomPrice"),
                        resultSet.getString("Topping.name"),
                        resultSet.getDouble("Topping.toppingPrice"),
                        resultSet.getDouble("total_price"),
                        resultSet.getInt("amount")));

            }
            System.out.println(list.get(1).getName());
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;

    }
}
