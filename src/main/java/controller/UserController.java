package controller;

import at.favre.lib.crypto.bcrypt.BCrypt;
import model.User;
import persistance.Database;

import javax.servlet.http.HttpSession;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.sql.*;
import java.text.DecimalFormat;

public class UserController {
    private final Database database;

    public UserController(Database database) {
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
            ps.setString(2, hashPassword(user.getPassword()));
            ps.setInt(3, 0);
            ps.setString(4, user.getRole());
            ps.setString(5, user.getSessionID());

            ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public User getUserBySessionId(String sessionId) {
        String sql = "SELECT (id_user ,email, balance, role) from Users WHERE sessionID = ?";

        try (Connection connection = database.connect()) {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, sessionId);

            ResultSet resultSet = ps.executeQuery();
            if(resultSet.next()) {
                int id = resultSet.getInt("id_user");
                String emailFromDb = resultSet.getString("email");
                double balanceFromDb = resultSet.getDouble("balance");
                String roleFromDb = resultSet.getString("role");
                return new User(id, emailFromDb, balanceFromDb, roleFromDb, sessionId);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public String[] getOrdersFromDb(String sessionId) {
        String sql = "SELECT (id_order, id_bottom, id_topping, amount, id_user) from Orders WHERE sessionID = ?";

        try(Connection connection = database.connect()) {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, sessionId);

            ResultSet resultSet = ps.executeQuery();
            if(resultSet.next()) {

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updateSessionID(String email, String sessionID) {
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
        String sql = "SELECT id_user, email, password, balance, role, sessionID from Users WHERE email = ?";

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

                if(email.equals(emailFromDb) && matchHashedPassword(password, passwordFromDb)) {
                    return new User(id, emailFromDb, passwordFromDb, balanceFromDb, roleFromDb, sessionIDFromDb);
                }

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public String getBalance(User user) {
        String sql = "SELECT balance FROM Users WHERE email=?";

        try(Connection connection = database.connect()) {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, user.getEmail());

            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                double balance = resultSet.getDouble("balance");
                user.setBalance(balance);

                DecimalFormat df = new DecimalFormat("#0.00");
                return df.format(balance);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "Error";
    }

    // Checks
    public boolean emailExists(String email) {
        String sql = "SELECT COUNT(*) FROM Users WHERE email = ?";

        try(Connection connection = database.connect()) {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, email);

            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
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

    public byte[] getSalt() {
        byte[] salt = new byte[16];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(salt);
        return salt;
    }

    public String hashPassword(String password) {
        byte[] bcryptChars = BCrypt.withDefaults().hash(6, getSalt(), password.getBytes(StandardCharsets.UTF_8));

        return new String(bcryptChars, StandardCharsets.UTF_8);
    }

    public boolean matchHashedPassword(String password, String hash) {
        BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), hash);
        return result.verified;
    }
}
