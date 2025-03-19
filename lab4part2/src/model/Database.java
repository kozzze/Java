package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private static final String URL = "jdbc:postgresql://localhost:5432/GorillaCars_development";
    private static final String USER = "kozzze";
    private static final String PASSWORD = "123";

    private static Database instance;
    private Connection connection;

    private Database() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Database getInstance() {
        if (instance == null) {
            synchronized (Database.class) {
                if (instance == null) {
                    instance = new Database();
                }
            }
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public List<Car> getAllCars() {
        List<Car> cars = new ArrayList<>();
        String sql = "SELECT cars.brand, cars.model, cars.year, cars.price, cars.description, " +
                "active_storage_blobs.key AS image_key, active_storage_blobs.filename " +
                "FROM cars " +
                "JOIN active_storage_attachments ON active_storage_attachments.record_id = cars.id " +
                "AND active_storage_attachments.record_type = 'Car' " +
                "JOIN active_storage_blobs ON active_storage_attachments.blob_id = active_storage_blobs.id";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String imageKey = rs.getString("image_key");
                String fileName = rs.getString("filename");

                String subPath = imageKey.substring(0, 2) + "/" + imageKey.substring(2, 4) + "/";
                String imagePath = "/Users/kozzze/Desktop/Учеба/5 семестр/Паттерны_проектирования/labs/GorillaCars/storage/"
                        + subPath + imageKey;

                Car car = new Car(
                        rs.getString("brand"),
                        rs.getString("model"),
                        rs.getInt("year"),
                        rs.getString("price"),
                        rs.getString("description"),
                        imagePath
                );
                cars.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }
}