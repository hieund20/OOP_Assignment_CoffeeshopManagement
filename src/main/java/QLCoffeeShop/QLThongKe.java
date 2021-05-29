/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLCoffeeShop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HIEU
 */
public class QLThongKe {

    List<ThongKeDT> dsThongKe = new ArrayList<>();

    //Lấy danh sách tất cả các bàn từ CCSDL
    public static List<ThongKeDT> hienThiDSThongKe() throws SQLException {
        List<ThongKeDT> dsThongKe = new ArrayList<>();
        Connection connection; //Kết nối đến Database
        Statement statement; //Lấy dữ liệu từ CSDL

        connection = DriverManager.getConnection("jdbc:mysql://localhost/coffeeshopdb",
                "root", "Duchieu200301");
        //query
        String sql = "SELECT * FROM thongke";
        statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(sql);//Trả về câu truy vấn CSDL

        while (resultSet.next()) { //next() chuyển dữ liệu trên từ hàng và đọc ra ngoài
            ThongKeDT dt = new ThongKeDT(
                    resultSet.getString("tenSP"),
                    resultSet.getInt("soLuong"),
                    resultSet.getInt("giaTien"));
            dsThongKe.add(dt); //Thêm dữ liệu vào List Bàn
        }
        return dsThongKe;
    }

    //Lấy ra tổng doanh thu cuối cùng
    public static String showTongDoanhThu(String sum) throws SQLException {
        Connection connection; //Kết nối đến Database
        Statement statement;//Lấy dữ liệu từ CSDL

        connection = DriverManager.getConnection("jdbc:mysql://localhost/coffeeshopdb",
                "root", "Duchieu200301");

        //query
        String sql = "SELECT sum(giaTien) as 'TongDoanhThu' FROM thongke";
        statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(sql);//Trả về câu truy vấn CSDL

        while (resultSet.next()) { //next() chuyển dữ liệu trên từ hàng và đọc ra ngoài
            sum = resultSet.getString("TongDoanhThu");
        }
        return sum;
    }

    //Xóa doanh thu hiện tại
    public static void xoaDoanhThu() throws SQLException {
        Connection connection; //Kết nối đến Database
        Statement statement;//Lấy dữ liệu từ CSDL

        connection = DriverManager.getConnection("jdbc:mysql://localhost/coffeeshopdb",
                "root", "Duchieu200301");

        //query
        String sql = "DELETE FROM thongke";
        statement = connection.createStatement();

        statement.execute(sql);
    }
}
