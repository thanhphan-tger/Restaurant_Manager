package GUI;

import DAO.NhaHang_DAO;
import DTO.dtoStatic;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Admin
 */
public class HoaDon_GUI extends javax.swing.JFrame {

    /**
     * Creates new form HoaDon_GUI
     */
    
    NhaHang_DAO dao = new NhaHang_DAO();
    DefaultTableModel dfTableModel = new DefaultTableModel();
    
    public HoaDon_GUI() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        lblMaHD.setText(dtoStatic.billKey);
        showNameOfEmp();
        showTable();
        showDate();
        initTable();
        showCTHD_MH();
    }
    
    private void showNameOfEmp()
    {
        try {
            ResultSet rs = dao.selectData("SELECT TENNV FROM NHANVIEN WHERE MANV = '" + dtoStatic.empKey + "'");
            if(rs.next())
                lblName.setText(rs.getString("TENNV"));
        } catch (SQLException ex) {
            Logger.getLogger(HoaDon_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void showTable()
    {
        String result = "";
        int count = 0;
        try {
            ResultSet rs = dao.selectData("SELECT TENBAN FROM BAN, CTHD_BAN " +
                                          "WHERE BAN.MABAN = CTHD_BAN.MABAN AND MAHD = '" + dtoStatic.billKey + "'");
            while(rs.next())
            {
                if(count != 0)
                    result += ", ";
                result += rs.getString("TENBAN");
                count++;
            }
            lblTable.setText(result);
        } catch (SQLException ex) {
            Logger.getLogger(HoaDon_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void showDate()
    {
        try {
            ResultSet rs = dao.selectData("SELECT CONVERT(VARCHAR, NGAYLAP, 103) AS DATE FROM HOADON WHERE MAHD = '" + dtoStatic.billKey + "'");
            if(rs.next())
                lblDate.setText(rs.getString("DATE"));
        } catch (SQLException ex) {
            Logger.getLogger(HoaDon_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void initTable()
    {
        String[] colTitle = {"Tên mặt hàng", "Số lượng", "Giá", "Thành tiền"};
        
        dfTableModel.setColumnIdentifiers(colTitle);
        tblHangDung.setModel(dfTableModel);
    }
    
    private void showCTHD_MH()
    {
        dfTableModel.setRowCount(0);
        float total = 0;
        try {
            ResultSet rs = dao.selectData("SELECT TENMH, CT.SLUONG, GIAMH, TTIEN " +
                                          "FROM MATHANG MH, CTHD_MH CT " +
                                          "WHERE MH.MAMH = CT.MAMH AND MAHD = '" + dtoStatic.billKey + "'");
            while (rs.next())
            {
                String nameMH = rs.getString("TENMH");
                int quantity = rs.getInt("SLUONG");
                float price = rs.getFloat("GIAMH");
                float sumMoney = rs.getFloat("TTIEN");
                total += sumMoney;
                dfTableModel.addRow(new String[]{nameMH, String.valueOf(quantity), String.format("%,.0f", price), String.format("%,.0f", sumMoney)});
            }
            
            lblTotal.setText(String.format("%,.0f", total) + " VND");
        } catch (SQLException ex) {
            Logger.getLogger(Main_QL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTenNhaHang = new javax.swing.JPanel();
        lblTenNhaHang = new javax.swing.JLabel();
        lblSoHD = new javax.swing.JLabel();
        lblSHD = new javax.swing.JLabel();
        lblMaHD = new javax.swing.JLabel();
        pnlChiTietHD = new javax.swing.JPanel();
        lblTenNhanVien = new javax.swing.JLabel();
        lblBan = new javax.swing.JLabel();
        lblNgayLap = new javax.swing.JLabel();
        lblTenKH = new javax.swing.JLabel();
        lblTenNV = new javax.swing.JLabel();
        lblMB = new javax.swing.JLabel();
        lblNL = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblTable = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHangDung = new javax.swing.JTable();
        lblTongTien = new javax.swing.JLabel();
        lblThankYou = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Hóa đơn");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        pnlTenNhaHang.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblTenNhaHang.setFont(new java.awt.Font("Times New Roman", 1, 28)); // NOI18N
        lblTenNhaHang.setText("Nhà Hàng CBR");

        lblSoHD.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblSoHD.setText("Số hóa đơn:");

        lblSHD.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblSHD.setText(" ");

        lblMaHD.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblMaHD.setText("jLabel1");

        javax.swing.GroupLayout pnlTenNhaHangLayout = new javax.swing.GroupLayout(pnlTenNhaHang);
        pnlTenNhaHang.setLayout(pnlTenNhaHangLayout);
        pnlTenNhaHangLayout.setHorizontalGroup(
            pnlTenNhaHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTenNhaHangLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(pnlTenNhaHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTenNhaHangLayout.createSequentialGroup()
                        .addComponent(lblSoHD)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblMaHD)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSHD, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblTenNhaHang))
                .addContainerGap(101, Short.MAX_VALUE))
        );
        pnlTenNhaHangLayout.setVerticalGroup(
            pnlTenNhaHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTenNhaHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTenNhaHang)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlTenNhaHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSoHD)
                    .addComponent(lblSHD)
                    .addComponent(lblMaHD))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlChiTietHD.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblTenNhanVien.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblTenNhanVien.setText("Nhân viên:");

        lblBan.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblBan.setText("Bàn:");

        lblNgayLap.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblNgayLap.setText("Ngày lập:");

        lblTenKH.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblTenKH.setText(" ");
        lblTenKH.setToolTipText("");

        lblTenNV.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblTenNV.setText(" ");

        lblMB.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblMB.setText(" ");

        lblNL.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblNL.setText(" ");

        lblName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblName.setText("jLabel1");

        lblTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTable.setText("jLabel1");

        lblDate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblDate.setText("jLabel1");

        javax.swing.GroupLayout pnlChiTietHDLayout = new javax.swing.GroupLayout(pnlChiTietHD);
        pnlChiTietHD.setLayout(pnlChiTietHDLayout);
        pnlChiTietHDLayout.setHorizontalGroup(
            pnlChiTietHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlChiTietHDLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnlChiTietHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBan, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNgayLap, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlChiTietHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTable)
                    .addComponent(lblName)
                    .addComponent(lblDate))
                .addGap(84, 84, 84)
                .addGroup(pnlChiTietHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMB, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNL, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(97, Short.MAX_VALUE))
        );
        pnlChiTietHDLayout.setVerticalGroup(
            pnlChiTietHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlChiTietHDLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlChiTietHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTenKH)
                    .addComponent(lblTenNhanVien)
                    .addComponent(lblName))
                .addGap(35, 35, 35)
                .addComponent(lblMB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenNV)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNL)
                .addGap(33, 33, 33))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlChiTietHDLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(pnlChiTietHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBan)
                    .addComponent(lblTable))
                .addGap(18, 18, 18)
                .addGroup(pnlChiTietHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNgayLap)
                    .addComponent(lblDate))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblHangDung.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Tên mặt hàng", "Số lượng", "Giá", "Thành tiền"
            }
        ));
        jScrollPane1.setViewportView(tblHangDung);

        lblTongTien.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblTongTien.setText("Tổng tiền:");

        lblThankYou.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        lblThankYou.setText("Thank You");

        lblTotal.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTotal.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlTenNhaHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlChiTietHD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblTongTien)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTotal)
                        .addGap(6, 6, 6)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(lblThankYou)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlTenNhaHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlChiTietHD, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTongTien)
                    .addComponent(lblTotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblThankYou)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Main_QL frm = new Main_QL();
        frm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(HoaDon_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HoaDon_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HoaDon_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HoaDon_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HoaDon_GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBan;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblMB;
    private javax.swing.JLabel lblMaHD;
    private javax.swing.JLabel lblNL;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNgayLap;
    private javax.swing.JLabel lblSHD;
    private javax.swing.JLabel lblSoHD;
    private javax.swing.JLabel lblTable;
    private javax.swing.JLabel lblTenKH;
    private javax.swing.JLabel lblTenNV;
    private javax.swing.JLabel lblTenNhaHang;
    private javax.swing.JLabel lblTenNhanVien;
    private javax.swing.JLabel lblThankYou;
    private javax.swing.JLabel lblTongTien;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JPanel pnlChiTietHD;
    private javax.swing.JPanel pnlTenNhaHang;
    private javax.swing.JTable tblHangDung;
    // End of variables declaration//GEN-END:variables
}
