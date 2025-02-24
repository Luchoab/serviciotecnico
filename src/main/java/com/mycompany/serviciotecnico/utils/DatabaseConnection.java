package com.mycompany.serviciotecnico.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/serviciotecnico";
    private static final String user = "root";
    private static final String password = "1234";

    private static Connection cn = null;

    private DatabaseConnection() {
    }

    ;
    
    public static Connection getConnection() throws ClassNotFoundException {
        if (cn == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                cn = DriverManager.getConnection(URL, user, password);
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return cn;
    }

    public static void closeConnection() {

        if (cn != null) {
            try {
                cn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}
