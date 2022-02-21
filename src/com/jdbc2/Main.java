package com.jdbc2;
import java.sql.*;
public class Main {
    static Connection con = null;
    static PreparedStatement stmt = null;
    static ResultSet rs;

    public void dbCon() throws Exception{
        con = DataBaseConnection.getDbConnection();
    }

    //1st question
    public void putDataToProductTable(int pid, double price, String name) throws Exception{
        String query = "INSERT INTO product VALUES (?,?,?)";
        stmt = con.prepareStatement(query);
        stmt.setInt(1,pid);
        stmt.setDouble(2,price);
        stmt.setString(3,name);
        int count = stmt.executeUpdate();
        System.out.println(count + " rows Effected");

    }
    public void putDataToCartTable(int pid, int qty) throws Exception{
        String query = "INSERT INTO cart VALUES (?,?)";
        stmt =con.prepareStatement(query);
        stmt.setInt(1,pid);
        stmt.setInt(2,qty);

        int count = stmt.executeUpdate();
        System.out.println(count + " rows Effected");
    }


    //2nd Question
    public void printData(int pid) throws Exception{
        String query = "SELECT * FROM product WHERE product.pid =" +pid;
        stmt = con.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();
        if(rs.next()){
            System.out.println(rs.getDouble(2) + " " + rs.getString(3));
        }
        else{
            System.out.println("Empty");
        }

    }

    //3rd Question
    public void findAveragePrice() throws Exception{
        String query = "SELECT pid ,AVG(price) AS 'Avg Price' FROM product GROUP BY pid";
        stmt = con.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            System.out.println(rs.getInt(1) + "  " + rs.getDouble(2));
        }
    }


    public static void main(String[] args) throws Exception{
        Main mainObj = new Main();
        mainObj.dbCon();
        mainObj.putDataToProductTable(14,65,"Mukhija_Lakshay");
        mainObj.putDataToCartTable(4,5);
        mainObj.printData(10);
        mainObj.findAveragePrice();
        stmt.close();
        con.close();
    }
}
