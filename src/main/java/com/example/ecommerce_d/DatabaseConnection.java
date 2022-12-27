package com.example.ecommerce_d;

import java.sql.*;
import java.util.Stack;

public class DatabaseConnection {

    Connection con = null;
    String SQLURl = "jdbc:mysql://localhost:3306/ecommerce?useSSL=false";
    String userName = "root";
    String password = "123456789";
    DatabaseConnection() throws SQLException {
        con = DriverManager.getConnection(SQLURl, userName, password);
        if (con != null) {
            System.out.println("Our Connection is Established with database");
        }
    }

    // Select * from temporary
    public ResultSet executeQuery(String query) throws SQLException {

        ResultSet result = null;
        try {
            Statement statement = con.createStatement();
            result = statement.executeQuery(query);
            return result;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public int executeUpdate(String query) throws SQLException {

        int row = 0;
        try {
            Statement statement = con.createStatement();
            row = statement.executeUpdate(query);
            return row;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

}
