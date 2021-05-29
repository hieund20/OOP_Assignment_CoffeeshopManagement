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
public class QLHoaDon {

    //Lấy danh sách các món ăn đã đặt
    public static List<ChiTietHoaDon> findDatMonAn() throws SQLException {
        List<ChiTietHoaDon> dsHoaDon = new ArrayList<>();
        Connection connection; //Kết nối đến Database
        Statement statement;//Lấy dữ liệu từ CSDL

        connection = DriverManager.getConnection("jdbc:mysql://localhost/coffeeshopdb",
                "root", "Duchieu200301");

        //query
        String sql = "select t.tenTA, count(t.tenTA) as 'Soluong', t.giaBan * count(t.tenTA) as 'giaTien'\n"
                + "from chitiethoadon c, thucan t\n"
                + "where c.maTA = t.maTA\n"
                + "group by tenTA";
        statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(sql);//Trả về câu truy vấn CSDL

        while (resultSet.next()) { //next() chuyển dữ liệu trên từ hàng và đọc ra ngoài
            ChiTietHoaDon hd = new ChiTietHoaDon(
                    resultSet.getString("tenTA"),
                    resultSet.getInt("Soluong"),
                    resultSet.getInt("giaTien"));
            dsHoaDon.add(hd);
        }
        return dsHoaDon;
    }

    //Lấy danh sách các nước uống đã đặt
    public static List<ChiTietHoaDon> findDatNuocUong() throws SQLException {
        List<ChiTietHoaDon> dsHoaDon = new ArrayList<>();
        Connection connection; //Kết nối đến Database
        Statement statement;//Lấy dữ liệu từ CSDL

        connection = DriverManager.getConnection("jdbc:mysql://localhost/coffeeshopdb",
                "root", "Duchieu200301");

        //query
        String sql = "select n.tenNU, count(n.tenNU) as 'Soluong', n.giaBan * count(n.tenNU) as 'giaTien'\n"
                + "from nuocuong n, chitiethoadon c\n"
                + "where c.maNU = n.maNU\n"
                + "group by n.tenNU";
        statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(sql);//Trả về câu truy vấn CSDL

        while (resultSet.next()) { //next() chuyển dữ liệu trên từ hàng và đọc ra ngoài
            ChiTietHoaDon hd = new ChiTietHoaDon(
                    resultSet.getString("tenNU"),
                    resultSet.getInt("Soluong"),
                    resultSet.getInt("giaTien"));
            dsHoaDon.add(hd);
        }
        return dsHoaDon;
    }

    //Lấy danh sách các bàn đã đặt
    public static List<ChiTietHoaDon> findDatBan() throws SQLException {
        List<ChiTietHoaDon> dsHoaDon = new ArrayList<>();
        Connection connection; //Kết nối đến Database
        Statement statement;//Lấy dữ liệu từ CSDL

        connection = DriverManager.getConnection("jdbc:mysql://localhost/coffeeshopdb",
                "root", "Duchieu200301");

        //query
        String sql = "select b.maBan, b.sucChua\n"
                + "from ban b, chitiethoadon c\n"
                + "where b.maBan = c.maBan\n"
                + "group by b.maBan, b.sucChua";
        statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(sql);//Trả về câu truy vấn CSDL

        while (resultSet.next()) { //next() chuyển dữ liệu trên từ hàng và đọc ra ngoài
            ChiTietHoaDon hd = new ChiTietHoaDon(
                    resultSet.getInt("maBan"),
                    resultSet.getInt("sucChua"));
            dsHoaDon.add(hd);
        }
        return dsHoaDon;
    }

    //Than toán Hóa Đơn
    public static void thanhToan() throws SQLException {
        Connection connection;
        PreparedStatement statement;

        connection = DriverManager.getConnection("jdbc:mysql://localhost/coffeeshopdb",
                "root", "Duchieu200301");

        //query
        String sql = "insert into thanhtoan\n"
                + "select t.tenTA, count(t.tenTA) as 'Soluong', t.giaBan * count(t.tenTA) as 'GiaTien'\n"
                + "from chitiethoadon c, thucan t\n"
                + "where c.maTA = t.maTA\n"
                + "group by t.tenTA\n"
                + "union\n"
                + "select n.tenNU, count(n.tenNU) as 'Soluong', n.giaBan * count(n.tenNU) as 'GiaTien' \n"
                + "from nuocuong n, chitiethoadon c\n"
                + "where c.maNU = n.maNU\n"
                + "group by n.tenNU";
        statement = connection.prepareCall(sql); //Truyền câu truy vấn
        statement.execute();//Thêm dữ liệu vào Database
    }

    //Lấy ra tổng tiền cuối cùng
    public static String showTongTien(String sum) throws SQLException {
        Connection connection; //Kết nối đến Database
        Statement statement;//Lấy dữ liệu từ CSDL

        connection = DriverManager.getConnection("jdbc:mysql://localhost/coffeeshopdb",
                "root", "Duchieu200301");

        //query
        String sql = "select sum(GiaTien) as 'TongTien'\n"
                + "from thanhtoan;";
        statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(sql);//Trả về câu truy vấn CSDL

        while (resultSet.next()) { //next() chuyển dữ liệu trên từ hàng và đọc ra ngoài
            sum = resultSet.getString("TongTien");
        }
        return sum;
    }

    //Xóa thông tin hóa đơn
    public static void xoaHD() throws SQLException {
        Connection connection;
        PreparedStatement statement;

        connection = DriverManager.getConnection("jdbc:mysql://localhost/coffeeshopdb",
                "root", "Duchieu200301");

        //query
        String sql = "DELETE FROM chitiethoadon";
        statement = connection.prepareCall(sql);

        statement.execute();//Thêm dữ liệu vào Database
    }

    //Xóa dữ liệu trong bảng thanh toán (SQL) -  Tránh chồng dữ liệu -> Độn Giá Hóa Đơn
    public static void xoaTT() throws SQLException {
        Connection connection;
        PreparedStatement statement;

        connection = DriverManager.getConnection("jdbc:mysql://localhost/coffeeshopdb",
                "root", "Duchieu200301");

        //query
        String sql = "DELETE FROM thanhtoan";
        statement = connection.prepareCall(sql);

        statement.execute();//Thêm dữ liệu vào Database
    }

    //Chuyển danh sách các hóa đơn sang bảng Thống Kê
    public static void chuyenHoaDonSangThongKe() throws SQLException {
        Connection connection;
        PreparedStatement statement;

        connection = DriverManager.getConnection("jdbc:mysql://localhost/coffeeshopdb",
                "root", "Duchieu200301");

        //query
        String sql = "INSERT INTO thongke SELECT * FROM thanhtoan";
        statement = connection.prepareCall(sql);

        statement.execute();//Thêm dữ liệu vào Database
    }
}
