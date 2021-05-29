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
public class QLThucAn {

    //Lấy danh sách các món ăn từ CSDL
    public static List<ThucAn> findALLTA() throws SQLException {
        List<ThucAn> dsta = new ArrayList<>();
        Connection connection; //Kết nối đến Database
        Statement statement; //Lấy dữ liệu từ CSDL

        connection = DriverManager.getConnection("jdbc:mysql://localhost/coffeeshopdb",
                "root", "Duchieu200301");
        //query
        String sql = "SELECT * FROM thucan ORDER BY tenTA DESC";
        statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(sql);//Trả về câu truy vấn CSDL

        while (resultSet.next()) { //next() chuyển dữ liệu trên từ hàng và đọc ra ngoài
            ThucAn ta = new ThucAn(
                    resultSet.getInt("maTA"),
                    resultSet.getString("tenTA"),
                    resultSet.getDouble("giaBan"),
                    resultSet.getString("tinhTrang"),
                    resultSet.getString("thoidiemBan"),
                    resultSet.getString("danhMuc"),
                    resultSet.getString("loaiTA"));
            dsta.add(ta);
        }
        return dsta;
    }

    //Xóa thức ăn
    public static void xoaTA(String tenTA) throws SQLException {
        Connection connection;
        PreparedStatement statement;

        connection = DriverManager.getConnection("jdbc:mysql://localhost/coffeeshopdb",
                "root", "Duchieu200301");

        //query
        String sql = "DELETE FROM thucan WHERE tenTA = ?";
        statement = connection.prepareCall(sql);

        statement.setString(1, tenTA);

        statement.execute();//Thêm dữ liệu vào Database
    }

    //Thêm thức ăn
    public static void themTA(ThucAn ta) throws SQLException {
        Connection connection;
        PreparedStatement statement;

        connection = DriverManager.getConnection("jdbc:mysql://localhost/coffeeshopdb",
                "root", "Duchieu200301");

        //query
        String sql = "INSERT INTO thucan(maTA, tenTA, giaBan, tinhTrang, "
                + "thoidiemBan, danhMuc, loaiTA) VALUES(?,?,?,?,?,?,?)";
        statement = connection.prepareCall(sql); //Truyền câu truy vấn
        statement.setInt(1, ta.getMaSP());
        statement.setString(2, ta.getTenSP());
        statement.setDouble(3, ta.getGiaBan());
        statement.setString(4, ta.getTinhTrang());
        statement.setString(5, ta.getThoiDiemBan());
        statement.setString(6, ta.getDanhMuc());
        statement.setString(7, ta.getLoaiTA());

        statement.execute();//Thêm dữ liệu vào Database
    }

    //Tìm kiếm thức ăn theo tên
    public static List<ThucAn> timKiemTA(String tenTA) throws SQLException {
        List<ThucAn> dsta = new ArrayList<>();

        Connection connection;
        PreparedStatement statement;

        connection = DriverManager.getConnection("jdbc:mysql://localhost/coffeeshopdb",
                "root", "Duchieu200301");

        //query
        String sql = "SELECT * FROM thucan WHERE tenTA LIKE ?";
        //Tìm kiếm bàn theo sức chứa
        statement = connection.prepareCall(sql);
        statement.setString(1, "%" + tenTA + "%"); //SQL

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            ThucAn ta = new ThucAn(
                    resultSet.getInt("maTA"),
                    resultSet.getString("tenTA"),
                    resultSet.getDouble("giaBan"),
                    resultSet.getString("tinhTrang"),
                    resultSet.getString("thoidiemBan"),
                    resultSet.getString("danhMuc"),
                    resultSet.getString("loaiTA"));
            dsta.add(ta);
        }
        return dsta;
    }

    //Tìm kiếm thức ăn theo khoảng giá
    public static List<ThucAn> timKiemTA(double tuGia, double denGia) throws SQLException {
        List<ThucAn> dsta = new ArrayList<>();

        Connection connection;
        PreparedStatement statement;

        connection = DriverManager.getConnection("jdbc:mysql://localhost/coffeeshopdb",
                "root", "Duchieu200301");

        //query
        String sql = "SELECT * FROM thucan WHERE (giaBan >= ?) and (giaBan <= ?)";
        //Tìm kiếm thức ăn theo khoảng giá
        statement = connection.prepareCall(sql);
        statement.setDouble(1, tuGia); //SQL
        statement.setDouble(2, denGia); //SQL

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            ThucAn ta = new ThucAn(
                    resultSet.getInt("maTA"),
                    resultSet.getString("tenTA"),
                    resultSet.getDouble("giaBan"),
                    resultSet.getString("tinhTrang"),
                    resultSet.getString("thoidiemBan"),
                    resultSet.getString("danhMuc"),
                    resultSet.getString("loaiTA"));
            dsta.add(ta);
        }
        return dsta;
    }

    //Sắp xếp thức ăn theo giá
    public static List<ThucAn> sapXepThucAnTheoGia() throws SQLException {
        List<ThucAn> dsta = new ArrayList<>();

        Connection connection;
        PreparedStatement statement;

        connection = DriverManager.getConnection("jdbc:mysql://localhost/coffeeshopdb",
                "root", "Duchieu200301");

        //query
        String sql = "SELECT * FROM thucan ORDER BY giaBan DESC";
        //Sắp xếp danh sách các thức uống giảm dần theo giá bán
        statement = connection.prepareCall(sql);

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            ThucAn ta = new ThucAn(
                    resultSet.getInt("maTA"),
                    resultSet.getString("tenTA"),
                    resultSet.getInt("giaBan"),
                    resultSet.getString("tinhTrang"),
                    resultSet.getString("thoidiemBan"),
                    resultSet.getString("danhMuc"),
                    resultSet.getString("loaiTA"));
            dsta.add(ta);
        }
        return dsta;
    }

    //Chọn thức ăn 
    public static void chonTA(ThucAn ta) throws SQLException {
        Connection connection;
        PreparedStatement statement;

        connection = DriverManager.getConnection("jdbc:mysql://localhost/coffeeshopdb",
                "root", "Duchieu200301");

        //query 
        String sql = "INSERT INTO chitiethoadon(maTA) VALUES(?)";
        statement = connection.prepareCall(sql);
        statement.setInt(1, ta.getMaSP()); //SQL

        statement.execute();
    }

}
