package com.jdbc2;
import java.sql.*;
public class DataBaseConnection {
    final static String className = "com.mysql.cj.jdbc.Driver";
    final static String url = "jdbc:mysql://localhost:3306/PRODUCT";
    final static String uname = "root";
    final static String pass= "";

    public static Connection getDbConnection() throws Exception{
        PreparedStatement stmt = null;
        Class.forName(className);
        Connection con = DriverManager.getConnection(url,uname,pass);
        return con;
    }
}
