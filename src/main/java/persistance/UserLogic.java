package persistance;

import entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class UserLogic {
    private final Database database;

    public UserLogic(Database database) {
        this.database = database;
    }

    public void insertUserToDb(User user) {
        String sql = "INSERT INTO Users (username, password, balance, role) VALUES(?, ?, ?, ?)";

        try (Connection connection = database.connect()) {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ps.setInt(3, 0);
            ps.setString(4, user.getRole());

            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void getUserFromDb(String email, String password) {
        try(Connection connection = database.connect()) {

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
