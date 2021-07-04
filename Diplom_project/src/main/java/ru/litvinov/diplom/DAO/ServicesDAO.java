package ru.litvinov.diplom.DAO;

import org.springframework.stereotype.Component;
import ru.litvinov.diplom.models.Master;
import ru.litvinov.diplom.models.Services;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class ServicesDAO {
    // так делать не хорошо, нужно в отдельный файл
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

    public static List<Services> index() {
        List<Services> services = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM services";
            ResultSet resultSet = statement.executeQuery(SQL);
            while(resultSet.next()) {
                Services temp = new Services();

                temp.setId(resultSet.getInt("id"));
                temp.setName(resultSet.getString("name"));
                temp.setCost(resultSet.getInt("cost"));
                temp.setDescription(resultSet.getString("description"));

                services.add(temp);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return services;
    }

    public static Services show(int id) {
        Services service = null;

        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * FROM services WHERE id=?");

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            service = new Services();

            service.setId(resultSet.getInt("id"));
            service.setName(resultSet.getString("name"));
            service.setCost(resultSet.getInt("cost"));
            service.setDescription(resultSet.getString("description"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return service;
    }

    public static void save(Services services) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO services VALUES(1, ?, ?, ?)");

            preparedStatement.setString(1, services.getName());
            preparedStatement.setInt(2, services.getCost());
            preparedStatement.setString(3, services.getDescription());

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void update(int id, Services updateServices) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("UPDATE services SET name=?, cost=?, description=? WHERE id=?");

            preparedStatement.setString(1, updateServices.getName());
            preparedStatement.setInt(2, updateServices.getCost());
            preparedStatement.setString(3, updateServices.getDescription());
            preparedStatement.setInt(4, id);

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void delete(int id) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM services WHERE id=?");

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
