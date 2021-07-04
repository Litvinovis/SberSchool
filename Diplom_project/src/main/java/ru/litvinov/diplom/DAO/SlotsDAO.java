package ru.litvinov.diplom.DAO;

import org.springframework.stereotype.Component;
import ru.litvinov.diplom.models.Master;
import ru.litvinov.diplom.models.Slots;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class SlotsDAO {
    private static final String URL = "jdbc:postgresql://localhost:5432/servicesDB";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "12345";

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

    public static List<Slots> index() {
        List<Slots> slots = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM slots";
            ResultSet resultSet = statement.executeQuery(SQL);
            while(resultSet.next()) {
                Slots temp = new Slots();

                temp.setPhoneNumber(resultSet.getString("phoneNumber"));
                temp.setName(resultSet.getString("name"));
                temp.setDay(resultSet.getString("day"));
                temp.setTime(resultSet.getString("time"));
                temp.setId(resultSet.getInt("id"));

                slots.add(temp);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return slots;
    }

    public static Slots show(int id) {
        Slots slots = null;

        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * FROM slots WHERE id=?");

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            slots = new Slots();

            slots.setId(resultSet.getInt("id"));
            slots.setPhoneNumber(resultSet.getString("phoneNumber"));
            slots.setName(resultSet.getString("name"));
            slots.setDay(resultSet.getString("day"));
            slots.setTime(resultSet.getString("time"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return slots;
    }

    public static void save(Slots slots) {
        int counter = 0;

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM slots";
            ResultSet resultSet = statement.executeQuery(SQL);
            while(resultSet.next()) {
              counter++;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO slots VALUES(?, ?, ?, ?, ?)");

            preparedStatement.setInt(1, ++counter);
            preparedStatement.setString(2, slots.getName());
            preparedStatement.setString(3, slots.getDay());
            preparedStatement.setString(4, slots.getTime());
            preparedStatement.setString(5, slots.getPhoneNumber());

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void delete(int id) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM slots WHERE id=?");

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
