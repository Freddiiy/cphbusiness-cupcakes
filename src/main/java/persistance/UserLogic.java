package persistance;

import entities.User;

import javax.servlet.http.HttpSession;
import java.sql.*;
import java.util.ArrayList;

public class UserLogic {
    private final Database database;

    public UserLogic(Database database) {
        this.database = database;
    }

    public boolean isLoggedIn(HttpSession session, User user) {
        return session.getAttribute("email").equals(user.getEmail()) && user.getPassword().equals(getUserFromDb( (String) session.getAttribute("email"), user.getPassword()).getPassword());
    }

    //Insert data
    public void insertUserToDb(User user) {
        String sql = "INSERT INTO Users (email, password, balance, role, sessionID) VALUES(?, ?, ?, ?, ?)";

        try (Connection connection = database.connect()) {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ps.setInt(3, 0);
            ps.setString(4, user.getRole());
            ps.setString(5, user.getSessionID());

            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void updateSessionID(String email, HttpSession session) {
        String sessionID = session.getId();

        String sql = "UPDATE Users SET sessionID = ? WHERE email = ?";

        try (Connection connection = database.connect()) {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, sessionID);
            ps.setString(2, email);

            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    //Get data

    public User getUserFromDb(String email, String password) {
        String sql = "SELECT * from Users WHERE email = ?";

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
                String sessionIDFromDb = resultSet.getString("sessionID");

                if(email.equals(emailFromDb) && password.equals(passwordFromDb)) {
                    return new User(id, emailFromDb, passwordFromDb, balanceFromDb, roleFromDb, sessionIDFromDb);
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

    // Checks
    public boolean emailExists(String email) {
        String sql = "SELECT COUNT(*) FROM Users WHERE email = ? ";

        try(Connection connection = database.connect()) {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, email);

            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                System.out.println(resultSet.getInt("COUNT(*)"));
                return resultSet.getInt("COUNT(*)") > 0;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }

    public boolean validateSession(HttpSession session) {
        String sessionID = session.getId();

        String sql = "SELECT email, role, sessionID FROM Users WHERE sessionID = ?";
        try (Connection connection = database.connect()) {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, sessionID);

            ResultSet resultSet = ps.executeQuery();
            if(resultSet.next()) {
                return sessionID.equals(resultSet.getString("sessionID"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

}
