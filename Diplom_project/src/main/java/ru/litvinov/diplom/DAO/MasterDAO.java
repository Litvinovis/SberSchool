package ru.litvinov.diplom.DAO;

import org.springframework.stereotype.Component;
import ru.litvinov.diplom.models.Master;
import ru.litvinov.diplom.models.Services;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class MasterDAO {
    // так делать не хорошо, нужно в отдельный файл
    private static final String URL = "jdbc:postgresql://localhost:5432/servicesDB";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "12345";
    private static int counter = 0;

    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static List<Master> index() {
        List<Master> masters = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM masters";
            ResultSet resultSet = statement.executeQuery(SQL);
            while(resultSet.next()) {
                Master temp = new Master();

                temp.setId(resultSet.getInt("id"));
                temp.setName(resultSet.getString("name"));
                temp.setArea(resultSet.getString("area"));
                temp.setBio(resultSet.getString("biography"));

                masters.add(temp);
                counter++;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return masters;
    }

    public static Master show(int id) {
        Master master = null;

        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * FROM masters WHERE id=?");

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            master = new Master();

            master.setId(resultSet.getInt("id"));
            master.setName(resultSet.getString("name"));
            master.setArea(resultSet.getString("area"));
            master.setBio(resultSet.getString("biography"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return master;
    }

    public void save(Master master) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO masters VALUES(?, ?, ?, ?)");

            preparedStatement.setInt(1, ++counter);
            preparedStatement.setString(2, master.getName());
            preparedStatement.setString(3, master.getArea());
            preparedStatement.setString(4, master.getBio());

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void update(int id, Master updateMaster) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("UPDATE masters SET name=?, area=?, bio=? WHERE id=?");

            preparedStatement.setString(1, updateMaster.getName());
            preparedStatement.setString(2, updateMaster.getArea());
            preparedStatement.setString(3, updateMaster.getBio());
            preparedStatement.setInt(4, id);

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void delete(int id) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM masters WHERE id=?");

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
