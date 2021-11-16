package controller;

import model.CustomCupcake;
import persistance.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class CupcakeController {
    private final Database database;

    public CupcakeController(Database database) {
        this.database = database;
    }

    public boolean insertOrderToDB(CustomCupcake customCupcake, String sessionId) {
        System.out.println(customCupcake.getBottom() + " " + customCupcake.getTopping());

        if (sessionId == null) return false;

        String sql = "INSERT INTO Orders (id_bottom, id_topping, amount, id_user) VALUES(" +
                "(SELECT id_bottom FROM Bottom WHERE name = ?), " +
                "(SELECT id_topping FROM Topping WHERE name = ?), " +
                "?, " +
                "(SELECT id_user FROM Users WHERE sessionID = ?))";

        try (Connection connection = database.connect()) {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, customCupcake.getBottom());
            ps.setString(2, customCupcake.getTopping());
            ps.setInt(3, customCupcake.getAmount());
            ps.setString(4, sessionId);

            ps.executeUpdate();
            return true;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}
