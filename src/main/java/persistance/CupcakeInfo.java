package persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

public class CupcakeInfo {
    private final Database database;
    public CupcakeInfo(Database database) {
        this.database = database;
    }

    public String[] getItemFromID(String id) {
        String sql = "SELECT * FROM ItemDescriptions WHERE id_item = ?";
        String[] info = new String[3];

        try(Connection connection = database.connect()) {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, Integer.parseInt(id));

            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                info[0] = resultSet.getString("name");
                info[1] = resultSet.getString("desc");
                info[2] = resultSet.getString("imageURL");
            }
            return info;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return info;
    }
}
