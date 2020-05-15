package com;
import java.sql.*;

public class DBUtils {

    private static Connection connection = null;
    public static Connection getConnection()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/test?serverTimezone=UTC&characterEncoding=utf-8";
            String usename = "root";
            String password = "root";
            connection = DriverManager.getConnection(url,usename,password);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return connection;
    }

    public static void closeConnection()
    {
        if(connection != null)
        {
            try {
                connection.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }
}
