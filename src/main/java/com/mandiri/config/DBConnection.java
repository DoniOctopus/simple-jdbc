package com.mandiri.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection connection;
    public static Connection getConnection(){
        if(connection == null){
            try{
                connection = DriverManager
                        .getConnection("jdbc:postgresql://localhost:5432/enigma_academy", "postgres", "P@ssw0rd");
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        return connection;
    }
    public static void closes() throws SQLException {
        connection.close();
        connection = null;
    }
}
