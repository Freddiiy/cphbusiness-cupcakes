package controller;

import model.Cupcake;
import model.User;
import persistance.Database;

import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class CupcakeController {
    private final Database database;

    public CupcakeController(Database database) {
        this.database = database;
    }

    public void insertOrderToDB(Cupcake cupcake, String sessionId) {
        String sql = "INSERT INTO Orders (id_bottom, id_topping, amount, id_user) VALUES(" +
                "(SELECT id_bottom FROM Bottom WHERE name = ?), " +
                "(SELECT id_topping FROM Topping WHERE name = ?), " +
                "?," +
                " (SELECT id_user FROM Users WHERE sessionID = ?))";

        try (Connection connection = database.connect()) {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, cupcake.getBottom());
            ps.setString(2, cupcake.getTopping());
            ps.setInt(3, cupcake.getAmount());
            ps.setString(4, sessionId);

            ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
