import java.sql.*;

public class DataBase {
    private static final String URL = "jdbc:postgresql://localhost:5432/GorillaCars_development";
    private static final String USER = "kozzze";
    private static final String PASSWORD = "123";

    private static DataBase instance;
    private Connection connection;

    private DataBase() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static DataBase getInstance() {
        if (instance == null) {
            synchronized (DataBase.class) {
                if (instance == null) {
                    instance = new DataBase();
                }
            }
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public static ResultSet getCars() {
        String sql = "SELECT cars.id, cars.brand, cars.model, cars.price, cars.year, cars.description, " +
                "active_storage_blobs.key AS image_key, active_storage_blobs.filename " +
                "FROM cars " +
                "JOIN active_storage_attachments ON active_storage_attachments.record_id = cars.id " +
                "AND active_storage_attachments.record_type = 'Car' " +
                "JOIN active_storage_blobs ON active_storage_attachments.blob_id = active_storage_blobs.id";
        try {
            Connection conn = getInstance().getConnection();
            Statement stmt = conn.createStatement();
            return stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}