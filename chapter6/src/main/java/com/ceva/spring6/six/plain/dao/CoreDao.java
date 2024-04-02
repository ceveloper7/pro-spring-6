package com.ceva.spring6.six.plain.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Interface que agrupa metodos relacionados con la gestion de conexiones y comunicacion con
 * la BD
 */
public interface CoreDao {
    default Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/spring6?useSSL=false",
                "root", "root");
    }

    default void closeConnection(Connection connection) throws SQLException {
        if (connection == null) {
            return;
        }
        connection.close();
    }
}
