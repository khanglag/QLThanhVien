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

public class suaXL extends javax.swing.JFrame {

    private XuLyBLL xuLyBLL;

    public suaXL(int maTB, int maTV, String hinhThucXL, int soTien, LocalDateTime ngayXL, String trangThaiXL) {
        initComponents();
        xuLyBLL = new XuLyBLL();

        tx_maXL.setText(String.valueOf(maTB));
        tx_maTV.setText(String.valueOf(maTV));
        cb_hinhthucXL.setSelectedItem(hinhThucXL);
        tx_soTien.setText(String.valueOf(soTien));
        cb_trangThaiXL.setSelectedItem(trangThaiXL);
    }

    private void suaXL() {
        int maXL = Integer.parseInt(tx_maXL.getText());
        int maTV = Integer.parseInt(tx_maTV.getText());

        String hinhThucXL = cb_hinhthucXL.getSelectedItem().toString();

        Integer soTien = null;
        if (!tx_soTien.getText().isEmpty()) {
            soTien = Integer.valueOf(tx_soTien.getText());
        }

        Date date = tx_ngayXL.getDate();
        LocalDateTime ngayXL = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

        int trangThaiXL = Integer.parseInt(cb_trangThaiXL.getSelectedItem().toString());

        XuLy xl = xuLyBLL.getXuLy(maXL);

        if (xl != null) {
            xl.setMaTV(new ThanhVien(maTV));
            xl.setHinhThucXL(hinhThucXL);
            xl.setSoTien(soTien);
            xl.setNgayXL(ngayXL);
            xl.setTrangThaiXL(trangThaiXL);
            xuLyBLL.updateXuLy(xl);
            JOptionPane.showMessageDialog(null, "Cập nhật thông tin thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cb_hinhthucXL = new javax.swing.JComboBox<>();
        tx_ngayXL = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        cb_trangThaiXL = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tx_soTien = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btn_cancel = new javax.swing.JButton();
        btn_save = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tx_maTV = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tx_maXL = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        cb_hinhthucXL.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Chọn hình thức xử lý--", "Khóa thẻ 1 tháng", "Khóa thẻ 2 tháng ", "Khóa thẻ vĩnh viễn", "Bồi thường", "Khóa thẻ 1 tháng và bồi thường" }));
        cb_hinhthucXL.setPreferredSize(new java.awt.Dimension(72, 30));

        tx_ngayXL.setDateFormatString("yyyy-MM-dd'T'hh:ss");

        jLabel5.setText("Hình thức xử lý:");
        jLabel5.setPreferredSize(new java.awt.Dimension(62, 30));

        cb_trangThaiXL.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Trạng thái xử lý--", "0", "1" }));
        cb_trangThaiXL.setPreferredSize(new java.awt.Dimension(135, 30));

        jLabel6.setText("Trạng thái xử lý:");
        jLabel6.setPreferredSize(new java.awt.Dimension(62, 30));

        jLabel7.setText("Ngày xử lý: ");
        jLabel7.setPreferredSize(new java.awt.Dimension(62, 30));

        tx_soTien.setPreferredSize(new java.awt.Dimension(73, 30));

        btn_cancel.setText("Đóng");
        btn_cancel.setPreferredSize(new java.awt.Dimension(75, 30));
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelActionPerformed(evt);
            }
        });
        jPanel1.add(btn_cancel);

        btn_save.setText("Lưu");
        btn_save.setPreferredSize(new java.awt.Dimension(75, 30));
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });
        jPanel1.add(btn_save);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setText("Cập nhật xử lý vi phạm");

        jLabel1.setText("Số tiền:");
        jLabel1.setPreferredSize(new java.awt.Dimension(62, 30));

        jLabel4.setText("Mã thành viên:");
        jLabel4.setPreferredSize(new java.awt.Dimension(62, 30));

        tx_maTV.setEditable(false);
        tx_maTV.setPreferredSize(new java.awt.Dimension(73, 30));

        jLabel8.setText("Mã xử lý: ");
        jLabel8.setPreferredSize(new java.awt.Dimension(62, 30));

        tx_maXL.setEditable(false);
        tx_maXL.setPreferredSize(new java.awt.Dimension(73, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cb_hinhthucXL, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tx_maTV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tx_soTien, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                            .addComponent(cb_trangThaiXL, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tx_ngayXL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tx_maXL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(64, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(144, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(120, 120, 120))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel3)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tx_maXL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tx_maTV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_hinhthucXL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tx_soTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tx_ngayXL, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_trangThaiXL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        dispose();
    }//GEN-LAST:event_btn_cancelActionPerformed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        suaXL();
    }//GEN-LAST:event_btn_saveActionPerformed

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
            java.util.logging.Logger.getLogger(suaXL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(suaXL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(suaXL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(suaXL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_save;
    private javax.swing.JComboBox<String> cb_hinhthucXL;
    private javax.swing.JComboBox<String> cb_trangThaiXL;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField tx_maTV;
    private javax.swing.JTextField tx_maXL;
    private com.toedter.calendar.JDateChooser tx_ngayXL;
    private javax.swing.JTextField tx_soTien;
    // End of variables declaration//GEN-END:variables
}
