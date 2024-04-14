/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI.XuLy;

import BLL.XuLyBLL;
import DAL.ThanhVien;
import DAL.XuLy;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.JOptionPane;

public class themXL extends javax.swing.JFrame {

    private XuLyBLL xuLyBLL;

    public themXL() {
        initComponents();
        xuLyBLL = new XuLyBLL();
    }

    private void addXL() {
        if (tx_maTV.getText().isEmpty() || tx_ngayXL.getDate() == null || cb_trangThaiXL.getSelectedItem() == null || cb_hinhthucXL.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đủ thông tin.");
        }

        int maTV = Integer.parseInt(tx_maTV.getText());
        Integer soTien = null;
        if (!tx_soTien.getText().isEmpty()) {
            soTien = Integer.valueOf(tx_soTien.getText());
        }
        Date date = tx_ngayXL.getDate();
        LocalDateTime ngayXL = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

        String selectedTrangThai = (String) cb_trangThaiXL.getSelectedItem();
        String[] parts = selectedTrangThai.split(" - ");
        int trangThaiXL = Integer.parseInt(parts[0]);

        String selectedHinhThuc = (String) cb_hinhthucXL.getSelectedItem();
        String[] parts1 = selectedHinhThuc.split(" - ");
        String hinhThucXL = parts1[1].trim();

        int maXL = xuLyBLL.generateMaXL();

        XuLy xl = new XuLy();

        xl.setMaXL(maXL);
        xl.setMaTV(new ThanhVien(maTV));
        xl.setHinhThucXL(hinhThucXL);
        xl.setSoTien(soTien);
        xl.setNgayXL(ngayXL);
        xl.setTrangThaiXL(trangThaiXL);

        xuLyBLL.addXuLy(xl);
        JOptionPane.showMessageDialog(this, "Thêm thành công!");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btn_cancel = new javax.swing.JButton();
        btn_them = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tx_maTV = new javax.swing.JTextField();
        cb_hinhthucXL = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tx_soTien = new javax.swing.JTextField();
        cb_trangThaiXL = new javax.swing.JComboBox<>();
        tx_ngayXL = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btn_cancel.setText("Đóng");
        btn_cancel.setPreferredSize(new java.awt.Dimension(75, 30));
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelActionPerformed(evt);
            }
        });
        jPanel1.add(btn_cancel);

        btn_them.setText("Thêm");
        btn_them.setPreferredSize(new java.awt.Dimension(75, 30));
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });
        jPanel1.add(btn_them);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setText("Thêm xử lý");

        jLabel1.setText("Số tiền:");
        jLabel1.setPreferredSize(new java.awt.Dimension(62, 30));

        jLabel4.setText("Hình thức xử lý:");
        jLabel4.setPreferredSize(new java.awt.Dimension(62, 30));

        tx_maTV.setPreferredSize(new java.awt.Dimension(73, 30));

        cb_hinhthucXL.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Chọn hình thức xử lý--", "1 - Khóa thẻ 1 tháng", "2 - Khóa thẻ 2 tháng ", "3 - Khóa thẻ vĩnh viễn", "4 - Bồi thường", "5 - Khóa thẻ 1 tháng và bồi thường" }));
        cb_hinhthucXL.setPreferredSize(new java.awt.Dimension(72, 30));

        jLabel5.setText("Mã thành viên: ");
        jLabel5.setPreferredSize(new java.awt.Dimension(62, 30));

        jLabel6.setText("Trạng thái xử lý:");
        jLabel6.setPreferredSize(new java.awt.Dimension(62, 30));

        jLabel7.setText("Ngày xử lý: ");
        jLabel7.setPreferredSize(new java.awt.Dimension(62, 30));

        tx_soTien.setPreferredSize(new java.awt.Dimension(73, 30));

        cb_trangThaiXL.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Trạng thái xử lý--", "0 - Đang xử lý", "1 -  Đã xử lý" }));
        cb_trangThaiXL.setPreferredSize(new java.awt.Dimension(135, 30));

        tx_ngayXL.setDateFormatString("yyyy-MM-dd'T'hh:ss");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cb_hinhthucXL, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tx_maTV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tx_soTien, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                                    .addComponent(cb_trangThaiXL, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tx_ngayXL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(jLabel3)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel3)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_hinhthucXL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tx_maTV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tx_soTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tx_ngayXL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_trangThaiXL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        addXL();
        cb_hinhthucXL.setSelectedItem(null);
        cb_trangThaiXL.setSelectedItem(null);
        tx_maTV.setText("");
        tx_soTien.setText("");
        tx_ngayXL.setDate(null);
    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        dispose();
    }//GEN-LAST:event_btn_cancelActionPerformed

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
            java.util.logging.Logger.getLogger(themXL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(themXL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(themXL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(themXL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new themXL().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_them;
    private javax.swing.JComboBox<String> cb_hinhthucXL;
    private javax.swing.JComboBox<String> cb_trangThaiXL;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField tx_maTV;
    private com.toedter.calendar.JDateChooser tx_ngayXL;
    private javax.swing.JTextField tx_soTien;
    // End of variables declaration//GEN-END:variables
}
