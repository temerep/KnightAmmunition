package org.example.dao;

import org.example.entity.*;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class AbstractDao<T extends Entity> implements IDao<T> {
    protected Connection connection;
    protected Statement statement;

    public void close(Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
// log
        }
    }
    public void setConnection(Connection connection) {
        this.connection = connection;
    }

}
