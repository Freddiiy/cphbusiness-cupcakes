package persistance;

import entities.User;

import java.sql.Connection;
import java.sql.SQLException;

public class UserLogic {
    private Database database;

    public UserLogic(Database database) {
        this.database = database;
    }

    public void insertUser(User user) {

    }

    public void getUser(String email, String password) {
        try(Connection connection = database.connect()) {

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
