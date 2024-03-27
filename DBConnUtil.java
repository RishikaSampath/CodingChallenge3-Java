package util;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnUtil {
    public static Connection getConnection(String connectionString) throws SQLException {
        return DriverManager.getConnection(connectionString);
    }

    public static Connection getConnectionFromPropertyFile(String propertyFileName) throws IOException, SQLException {
        String connectionString = DBPropertyUtil.getConnectionString(propertyFileName);
        return getConnection(connectionString);
    }
}
