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
        String sql = "SELECT * FROM PremadeCupcake, bottom.price, topping.price WHERE id_item = ?";
        String[] info = new String[5];

        try(Connection connection = database.connect()) {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, Integer.parseInt(id));

            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                info[0] = resultSet.getString("name");
                info[1] = resultSet.getString("desc");
                info[2] = resultSet.getString("imageURL");
                info[3] = String.valueOf(resultSet.getDouble("bottom.price"));
                info[4] = String.valueOf(resultSet.getDouble("topping.price"));
            }
            return info;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return info;
    }

    public List getAllItems() {
        String sql = "SELECT PremadeCupcake.*, Bottom.bottomPrice, Topping.toppingPrice \n" +
                "FROM PremadeCupcake\n" +
                "JOIN Bottom ON PremadeCupcake.bottom = Bottom.id_bottom\n" +
                "JOIN Topping ON PremadeCupcake.topping = Topping.id_topping ORDER BY id_item;";
        List<Cupcake> list = new ArrayList<>();
        try(Connection connection = database.connect()) {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                list.add(new Cupcake(
                    resultSet.getInt("id_item"),
                    resultSet.getString("name"),
                    resultSet.getString("desc"),
                    resultSet.getString("imageURL"),
                    resultSet.getInt("bottomPrice"),
                    resultSet.getInt("toppingPrice")
                ));
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
}
