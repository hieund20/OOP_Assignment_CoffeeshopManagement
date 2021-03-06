/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLCoffeeShop;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HIEU
 */
public class QuanLyNhanVien extends javax.swing.JFrame {
    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    private DefaultTableModel tableModel;
    List<NhanVien> dsNV = new ArrayList<>();
    /**
     * Creates new form QuanLyNhanVien
     * @throws java.sql.SQLException
     * @throws java.text.ParseException
     */
    public QuanLyNhanVien() throws SQLException, ParseException {
        initComponents();

        showNhanVien(); //Gọi phương thức Show Nhân Viên
    }
    //Show dữ liệu nhân viên
    private void showNhanVien() throws SQLException, ParseException{
        tableModel = (DefaultTableModel) tbnhanvien.getModel();
        dsNV = QLNhanVien.findALL();

        tableModel.setRowCount(0);

        dsNV.forEach(nv -> {
            tableModel.addRow(new Object[]{
                nv.getMaNV(),
                nv.getHotenNV(),
                nv.getGioiTinh(),
                nv.getQueQuan(),
                df.format(nv.getNgaySinh()),
                df.format(nv.getNgayVaoLam()),
                nv.getBoPhan(),
            });
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btncapnhatnv = new javax.swing.JButton();
        btnxoanv = new javax.swing.JButton();
        btthemnv = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbnhanvien = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnCapNhatNhanVien = new javax.swing.JButton();
        btnHienThiDSNhanVien = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("QUẢN LÝ NHÂN VIÊN");
        setBackground(new java.awt.Color(255, 255, 255));
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btncapnhatnv.setBackground(new java.awt.Color(255, 255, 255));
        btncapnhatnv.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btncapnhatnv.setText("Cập Nhật Nhân Viên");
        btncapnhatnv.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnxoanv.setBackground(new java.awt.Color(255, 255, 255));
        btnxoanv.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnxoanv.setText("Xóa Nhân Viên");
        btnxoanv.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnxoanv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoanvActionPerformed(evt);
            }
        });

        btthemnv.setBackground(new java.awt.Color(255, 255, 255));
        btthemnv.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btthemnv.setText("Thêm Nhân Viên");
        btthemnv.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btthemnv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btthemnvActionPerformed(evt);
            }
        });

        tbnhanvien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Nhân Viên", "Họ Tên", "Giới Tính", "Quê Quán", "Ngày Sinh", "Ngày Vào Làm", "Bộ Phận"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbnhanvien);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("DANH SÁCH TẤT CẢ NHÂN VIÊN");

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\HIEU\\Desktop\\OOP\\THchuong2\\BTL_QLCOFFEESHOP\\src\\main\\java\\QLCoffeeShop\\images\\outline_logout_black_24.png")); // NOI18N
        jButton1.setText("Màn Hình Chính");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnCapNhatNhanVien.setBackground(new java.awt.Color(255, 255, 255));
        btnCapNhatNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCapNhatNhanVien.setText("Tìm Kiếm Nhân Viên");
        btnCapNhatNhanVien.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCapNhatNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatNhanVienActionPerformed(evt);
            }
        });

        btnHienThiDSNhanVien.setBackground(new java.awt.Color(255, 255, 255));
        btnHienThiDSNhanVien.setIcon(new javax.swing.ImageIcon("C:\\Users\\HIEU\\Desktop\\OOP\\THchuong2\\BTL_QLCOFFEESHOP\\src\\main\\java\\QLCoffeeShop\\images\\baseline_refresh_black_18.png")); // NOI18N
        btnHienThiDSNhanVien.setBorder(null);
        btnHienThiDSNhanVien.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHienThiDSNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHienThiDSNhanVienActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jTextArea2.setText("Các Chức Vụ\n1 - Quản Lý\t\n2 - Pha Chế\n3 - Tiếp Tân\t\n4 - Phục Vụ");
        jTextArea2.setBorder(null);
        jScrollPane4.setViewportView(jTextArea2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnHienThiDSNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btthemnv, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                .addGap(47, 47, 47)
                                .addComponent(btncapnhatnv, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))
                            .addComponent(jButton1))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(btnCapNhatNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                                .addGap(47, 47, 47)
                                .addComponent(btnxoanv, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(79, 79, 79))
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnHienThiDSNhanVien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btthemnv, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btncapnhatnv, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnxoanv, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCapNhatNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

//Button thêm nhân viên mới vào CSDL
    private void btthemnvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btthemnvActionPerformed
//
//        try {
//            String hotenNV = tfhoten.getText();
//            String gioiTinh = cbgioitinh.getSelectedItem().toString();
//            String queQuan = tfquequan.getText();
//            String ngaySinh = tfngaysinh.getText();
//            String ngayVaoLam = tfngayvaolam.getText();
//            int maBP = Integer.parseInt(tfbophan.getText());
//
//            //Chọn phương thức khởi tạo không ID vì ID là khóa chính của bảng
//            NhanVien nv = new NhanVien(hotenNV, gioiTinh, queQuan, ngaySinh, ngayVaoLam, maBP);
//            QLNhanVien.themNV(nv);
//            showNhanVien();
//        } catch (ParseException | SQLException ex) {
//            Logger.getLogger(QuanLyNhanVien.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_btthemnvActionPerformed

   //Button xóa nhân viên (Chạy)
    private void btnxoanvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoanvActionPerformed
        //Lấy ra vị trí index khi click chuột
        int selectedIndex = tbnhanvien.getSelectedRow();
        if (selectedIndex >= 0) { //Đúng
            NhanVien nv = dsNV.get(selectedIndex);
            //Hiển thị một Pop-up Panel xác nhận xóa, sau khi nhấn Delete
            int option = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa nhân viên này?");
            System.out.println("option: " + option);
            //Ouput => Yes: 0, No: 1, Cancel: 2
            if (option == 0) {
                try {
                    QLNhanVien.xoaNV(nv.getMaNV());//Xóa Bàn
                } catch (SQLException ex) {
                    Logger.getLogger(QuanLyBan.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    showNhanVien(); //Hiện thị danh sách nhân viên sau khi xóa
                } catch (SQLException ex) {
                    Logger.getLogger(QuanLyBan.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(QuanLyNhanVien.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_btnxoanvActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new ManHinhChinh().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed
    //Button tìm kiếm nhân viên theo tên
    private void btnCapNhatNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatNhanVienActionPerformed
        //Hiển thị một Pop-up Panel để nhập thông tin cần tìm
        String input = JOptionPane.showInputDialog(this, "Nhập họ tên cần tìm");
        if (input.length() > 0) {
            try {
                //Độ dài input>0 mới tìm kiếm
                dsNV = QLNhanVien.timKiemNV(input); //Tìm kiếm NV
                
                tableModel.setRowCount(0);
                
                dsNV.forEach(nv -> {
                    tableModel.addRow(new Object[]{
                        nv.getMaNV(),
                        nv.getHotenNV(),
                        nv.getGioiTinh(),
                        nv.getQueQuan(),
                        nv.getNgaySinh(),
                        nv.getNgayVaoLam(),
                        nv.getBoPhan()
                    });
                });
            } catch (SQLException ex) {
                Logger.getLogger(QuanLyNhanVien.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnCapNhatNhanVienActionPerformed
    //Button hiển thị lại bảng nhân viên sau khi đã thao tác các Button trước
    private void btnHienThiDSNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHienThiDSNhanVienActionPerformed
        try {
            showNhanVien();
        } catch (SQLException ex) {
            Logger.getLogger(QuanLyNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(QuanLyNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnHienThiDSNhanVienActionPerformed

   /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QuanLyNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new QuanLyNhanVien().setVisible(true);
            } catch (SQLException | ParseException ex) {
                Logger.getLogger(QuanLyNhanVien.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhatNhanVien;
    private javax.swing.JButton btnHienThiDSNhanVien;
    private javax.swing.JButton btncapnhatnv;
    private javax.swing.JButton btnxoanv;
    private javax.swing.JButton btthemnv;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTable tbnhanvien;
    // End of variables declaration//GEN-END:variables
}
