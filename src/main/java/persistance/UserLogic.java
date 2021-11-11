package persistance;

import entities.User;

import javax.servlet.http.HttpSession;
import java.sql.*;

public class UserLogic {
    private final Database database;

    public UserLogic(Database database) {
        this.database = database;
    }

    public boolean isLoggedIn(HttpSession session, User user) {
        return session.getAttribute("email").equals(user.getEmail());
    }

    public void insertUserToDb(User user) {
        String sql = "INSERT INTO Users (email, password, balance, role) VALUES(?, ?, ?, ?)";

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

    public User getUserFromDb(String email, String password) {
        String sql = "SELECT * from Users WHERE email=?";

        try(Connection connection = database.connect()) {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, email);

            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id_user");
                String emailFromDb = resultSet.getString("email");
                String passwordFromDb = resultSet.getString("password");
                int balanceFromDb = resultSet.getInt("balance");
                String roleFromDb = resultSet.getString("role");

                if(email.equals(emailFromDb) && password.equals(passwordFromDb)) {
                    return new User(id, emailFromDb, passwordFromDb, balanceFromDb, roleFromDb);
                }

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public boolean userExists(User user) {
        return user != null;
    }

}
