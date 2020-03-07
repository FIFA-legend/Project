package by.itcollege.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    private static final String URL = "jdbc:mysql://localhost:3306/park";
    public static final String LOGIN = "root";
    public static final String PASSWORD = "0987654321KnKn";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, LOGIN, PASSWORD);
    }
}
