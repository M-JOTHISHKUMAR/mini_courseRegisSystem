package com.university.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHandler {
    private static Connection connection = null;
    private static final String DB_URL = "jdbc:mysql://localhost:3306/university_db?useSSL=false";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Jothish@123";

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return connection;
    }
}
