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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author HIEU
 */
public class QLNhanVien {

    //Lấy ra danh sách tất cả sinh viên từ CSDL
    public static List<NhanVien> findALL() throws SQLException, ParseException {
        List<NhanVien> dsNV = new ArrayList<>();

        Connection connection; //Kết nối đến Database
        Statement statement; //Lấy dữ liệu từ CSDL

        connection = DriverManager.getConnection("jdbc:mysql://localhost/coffeeshopdb",
                "root", "Duchieu200301");

        //query
        String sql = "SELECT * FROM nhanvien";
        statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(sql);//Trả về câu truy vấn CSDL

        while (resultSet.next()) { //next() chuyển dữ liệu trên từ hàng và đọc ra ngoài
            NhanVien nv = new NhanVien(
                    resultSet.getInt("maNV"),
                    resultSet.getString("hotenNV"),
                    resultSet.getString("gioiTinh"),
                    resultSet.getString("queQuan"),
                    resultSet.getDate("ngaySinh"),
                    resultSet.getDate("ngayVaoLam"),
                    resultSet.getInt("maBP"));
            dsNV.add(nv);
        }
        return dsNV;
    }

    //Thêm nhân viên
    public static void themNV(NhanVien nv) throws SQLException {
        Connection connection;
        PreparedStatement statement;

        connection = DriverManager.getConnection("jdbc:mysql://localhost/coffeeshopdb",
                "root", "Duchieu200301");

        //query
        String sql = "INSERT INTO nhanvien(maNV, hotenNV, gioiTinh, queQuan, "
                + "ngaySinh, ngayVaoLam, maBP) "
                + "VALUES(?,?,?,?,?,?,?)";
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        statement = connection.prepareCall(sql); //Truyền câu truy vấn
        statement.setString(1, nv.getHotenNV());
        statement.setString(2, nv.getGioiTinh());
        statement.setString(3, nv.getQueQuan());
        statement.setString(4, df.format(nv.getNgaySinh()));
        statement.setString(5, df.format(nv.getNgayVaoLam()));
        statement.setInt(6, nv.getBoPhan());

        statement.execute();//Thêm dữ liệu vào Database
    }

    //Cập nhật thông tin nhân viên
    public static void capNhatNV(NhanVien nv) throws SQLException {
        Connection connection;
        PreparedStatement statement;

        connection = DriverManager.getConnection("jdbc:mysql://localhost/coffeeshopdb",
                "root", "Duchieu200301");

        //query
        String sql = "UPADATE nhanvien SET hotenNV=?, gioiTinh=?, queQuan=?,"
                + "ngaySinh=?,ngayVaoLam=?,maBP=? WHERE maNV = ?";
        //Cập nhật ngày sinh với điều kiện Where ID

        statement = connection.prepareCall(sql); //Truyền câu truy vấn

        statement.setString(1, nv.getHotenNV());
        statement.setString(2, nv.getGioiTinh());
        statement.setString(3, nv.getQueQuan());
        statement.setDate(4, nv.getNgaySinh());
        statement.setDate(5, nv.getNgayVaoLam());
        statement.setInt(6, nv.getBoPhan());
        statement.setInt(7, nv.getMaNV()); //Lấy mã Nhân Viên được cập nhật

        statement.execute(); //Thêm dữ liệu vào Database
    }

    //Xóa thông tin nhân viên
    public static void xoaNV(int maNV) throws SQLException { //Xóa qua ID
        Connection connection;
        PreparedStatement statement;

        connection = DriverManager.getConnection("jdbc:mysql://localhost/coffeeshopdb",
                "root", "Duchieu200301");

        //query
        String sql = "DELETE FROM nhanvien WHERE maNV = ?";

        statement = connection.prepareCall(sql); //Truyền câu truy vấn

        statement.setInt(1, maNV);

        statement.execute(); //Cập nhật dữ liệu vào Database
    }

    //Tìm kiếm nhân viên
    public static List<NhanVien> timKiemNV(String hotenNV) throws SQLException {
        List<NhanVien> dsNV = new ArrayList<>();

        Connection connection;
        PreparedStatement statement;

        connection = DriverManager.getConnection("jdbc:mysql://localhost/coffeeshopdb",
                "root", "Duchieu200301");

        //query
        String sql = "SELECT * FROM nhanvien WHERE hotenNV LIKE ? ";
        //LIKE tìm nhân viên chứa họ tên trong LIKE
        //Tìm kiếm nhân viên theo họ tên
        statement = connection.prepareCall(sql);
        statement.setString(1, "%" + hotenNV + "%"); //SQL

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            NhanVien nv = new NhanVien(
                    resultSet.getInt("maNV"),
                    resultSet.getString("hotenNV"),
                    resultSet.getString("gioiTinh"),
                    resultSet.getString("queQuan"),
                    resultSet.getDate("ngaySinh"),
                    resultSet.getDate("ngayVaoLam"),
                    resultSet.getInt("maBP"));
            dsNV.add(nv);
        }
        return dsNV;
    }
    
}
