/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLCoffeeShop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HIEU
 */
public class QLBan {

    List<Ban> dsBan = new ArrayList<>();

    //Lấy danh sách tất cả các bàn từ CCSDL
    public static List<Ban> findALLBan() throws SQLException {
        List<Ban> dsBan = new ArrayList<>();
        Connection connection; //Kết nối đến Database
        Statement statement; //Lấy dữ liệu từ CSDL

        connection = DriverManager.getConnection("jdbc:mysql://localhost/coffeeshopdb",
                "root", "Duchieu200301");
        //query
        String sql = "SELECT * FROM ban";
        statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(sql);//Trả về câu truy vấn CSDL

        while (resultSet.next()) { //next() chuyển dữ liệu trên từ hàng và đọc ra ngoài
            Ban b = new Ban(
                    resultSet.getInt("maBan"),
                    resultSet.getInt("sucChua"),
                    resultSet.getString("tinhTrang"));
            dsBan.add(b); //Thêm dữ liệu vào List Bàn
        }
        return dsBan;
    }

    //Lấy danh sách các bán trống
    public static List<Ban> findBanTrong() throws SQLException {
        List<Ban> dsBan = new ArrayList<>();
        
        Connection connection; //Kết nối đến Database
        Statement statement;//Lấy dữ liệu từ CSDL

        connection = DriverManager.getConnection("jdbc:mysql://localhost/coffeeshopdb",
                "root", "Duchieu200301");

        //query
        String sql = "SELECT * FROM ban\n"
                + "WHERE tinhTrang = 'Trống' OR tinhtrang ='trống'";
        statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(sql);//Trả về câu truy vấn CSDL

        while (resultSet.next()) { //next() chuyển dữ liệu trên từ hàng và đọc ra ngoài
            Ban b = new Ban(
                    resultSet.getInt("maBan"),
                    resultSet.getInt("sucChua"),
                    resultSet.getString("tinhTrang"));
            dsBan.add(b); //Thêm dữ liệu vào List Bàn
        }
        return dsBan;
    }

    //Thêm bàn
    public static void themBan(Ban b) throws SQLException {
        Connection connection;
        PreparedStatement statement;

        connection = DriverManager.getConnection("jdbc:mysql://localhost/coffeeshopdb",
                "root", "Duchieu200301");

        //query
        String sql = "INSERT INTO ban(maBan, sucChua, tinhTrang) VALUES(?,?,?)";
        statement = connection.prepareCall(sql); //Truyền câu truy vấn
        statement.setInt(1, b.getMaBan());
        statement.setInt(2, b.getSucChua());
        statement.setString(3, b.getTinhTrang());

        statement.execute();//Thêm dữ liệu vào Database
    }

    //Cập nhât thông tin bàn
    public static void capnhatBan(Ban b, String row) throws SQLException {
        Connection connection;
        PreparedStatement statement;

        connection = DriverManager.getConnection("jdbc:mysql://localhost/coffeeshopdb",
                "root", "Duchieu200301");

        //query
        String sql = "UPDATE ban SET sucChua=?, tinhTrang=? WHERE maBan = " + row;
        //Cập nhật thông tin bàn theo mã bàn
        statement = connection.prepareCall(sql);
        
        statement.setInt(1, b.getSucChua());
        statement.setString(2, b.getTinhTrang());

        statement.execute();//Them dữ liệu vào Database
    }

    //Xóa thông tin bàn
    public static void xoaBan(String maBan) throws SQLException {
        Connection connection;
        PreparedStatement statement;

        connection = DriverManager.getConnection("jdbc:mysql://localhost/coffeeshopdb",
                "root", "Duchieu200301");

        //query
        String sql = "DELETE FROM ban WHERE maBan = ?";
        statement = connection.prepareCall(sql);

        statement.setString(1, maBan);

        statement.execute();//Thêm dữ liệu vào Database
    }

    //Tìm kiếm bàn
    public static List<Ban> timKiemBan(int sc) throws SQLException {
        List<Ban> dsBan = new ArrayList<>();

        Connection connection;
        PreparedStatement statement;

        connection = DriverManager.getConnection("jdbc:mysql://localhost/coffeeshopdb",
                "root", "Duchieu200301");

        //query
        String sql = "SELECT * FROM ban WHERE sucChua = ?";
        //Tìm kiếm bàn theo sức chứa
        statement = connection.prepareCall(sql);
        statement.setInt(1, sc); //SQL

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            Ban b = new Ban(
                    resultSet.getInt("maBan"),
                    resultSet.getInt("sucChua"),
                    resultSet.getString("tinhTrang"));
            dsBan.add(b);
        }
        return dsBan;
    }

    //Đặt bàn 
    public static void datBan(Ban b) throws SQLException {
        Connection connection;
        PreparedStatement statement;

        connection = DriverManager.getConnection("jdbc:mysql://localhost/coffeeshopdb",
                "root", "Duchieu200301");

        //query 
        String sql = "INSERT INTO chitiethoadon(maBan) VALUES(?)";
        statement = connection.prepareCall(sql);
        statement.setInt(1, b.getMaBan()); //SQL

        statement.execute();
    }

}
