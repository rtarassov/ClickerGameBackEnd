package com.solodev.clickergamebackend.dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    public static Connection getDBConnection() {
        Connection connection = null;
        String USERNAME = "root";
        String PASSWORD = "root";
        String DRIVER = "com.mysql.jdbc.Driver";
        String URL = "jdbc:mysql://localhost:3308/ClickerGameDatabase?max-connections=1";

        try {
            // Register JDBC driver
            Class.forName(DRIVER);
            // Connect to database
            if (connection == null || connection.isClosed()) {

                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
