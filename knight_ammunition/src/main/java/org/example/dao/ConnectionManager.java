package org.example.dao;


import org.example.constants.Constants;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static final String DATABASE_URL = "jdbc:mysql://" + Constants.dbHost + ":" + Constants.dbPort + "/" + Constants.dbName;

    private ConnectionManager() {
    }

    public static Connection createConnection() throws SQLException {
        return DriverManager.getConnection(DATABASE_URL, Constants.dbUser, Constants.dbPass);
    }
}

