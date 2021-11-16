package persistance;

import model.Cupcake;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CupcakeInfo {
    private final Database database;
    public CupcakeInfo(Database database) {
        this.database = database;
    }

    public String[] getItemFromID(String id) {
        String sql = "SELECT * FROM ItemDescriptions WHERE itemID = ?";
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

    public List getAllItems() {
        String sql = "SELECT * FROM ItemDescriptions";
        List<Cupcake> list = new ArrayList<>();
        try(Connection connection = database.connect()) {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                list.add(new Cupcake(
                    resultSet.getInt("itemID"),
                    resultSet.getString("name"),
                    resultSet.getString("desc"),
                    resultSet.getString("imageURL")
                ));
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
}
