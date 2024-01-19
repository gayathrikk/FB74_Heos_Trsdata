package com.Reg.TRS_Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class Testing {

    @Test
    public void testDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");

            String url = "jdbc:mysql://private.colab.humanbrain.in:3306/HBA_V2";
            String username = "root";
            String password = "Health#123";
            
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                System.out.println("MYSQL database connected");

                // Call the method to execute and print the query
                executeAndPrintQuery(connection);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void executeAndPrintQuery(Connection connection) {
        try (Statement statement = connection.createStatement()) {
            String query = "SELECT * FROM `section` WHERE name LIKE '%Fetal brain 40%' AND jp2Path LIKE '%NISL%' and doNotPublish=1";

            try (ResultSet resultSet = statement.executeQuery(query)) {
                while (resultSet.next()) {
                    String TRSdata = resultSet.getString("trsdata");
                    String name = resultSet.getString("name");

                    System.out.println("name " + name + "-----TRS data:" + TRSdata);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
