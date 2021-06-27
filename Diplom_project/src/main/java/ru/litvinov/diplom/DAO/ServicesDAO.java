package ru.litvinov.diplom.DAO;

import org.springframework.stereotype.Component;
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
}
