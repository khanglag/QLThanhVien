/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package GUI.QLTV;

import BLL.ThanhVienBLL;
import DAL.ThanhVien;
import GUI.Hander.CurrentYearLastTwoDigits;
import GUI.Hander.IntToStringConverter;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author khang
 */
public class Edit extends javax.swing.JDialog {

    /**
     * Creates new form AddTV
     */

    int khoa;
    int id;
    ThanhVienBLL tvBLL = new ThanhVienBLL();
    ThanhVien tv = new ThanhVien();

    public Edit(java.awt.Frame parent, ThanhVien tv) {
        super(parent, true);
        initComponents();
        id = tv.getMaTV();
        jtfName.setText(tv.getHoTen());
        jtfSDT.setText(tv.getSDT().toString());
        jcbbKhoa.setSelectedItem(tv.getKhoa());
        jcbbNganh.setSelectedItem(tv.getNganh());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtfName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jcbbKhoa = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jcbbNganh = new javax.swing.JComboBox<>();
        btnClose = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        SDT = new javax.swing.JLabel();
        jtfSDT = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Sửa thành viên");
        jPanel3.add(jLabel1);

        jPanel2.add(jPanel3);

        jLabel2.setText("Họ tên");

        jLabel3.setText("Khoa");

        jcbbKhoa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vui lòng chọn", "SP KHXH", "Toán UD", "QLGD", "SPKHTN", "CNTT" }));
        jcbbKhoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbbKhoaActionPerformed(evt);
            }
        });

        jLabel4.setText("Ngành");

        jcbbNganh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vui lòng chọn", "Địa", "Anh", "Sử", "NNA", "TLH", "Toán", "QTKD", "Lí", "Văn", "GDTH", "QLGD", "HTTT" }));
        jcbbNganh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbbNganhActionPerformed(evt);
            }
        });

        btnClose.setText("Đóng");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        btnEdit.setText("Sửa");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        SDT.setText("SĐT");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnClose)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEdit))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(SDT, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfName)
                            .addComponent(jcbbKhoa, 0, 156, Short.MAX_VALUE)
                            .addComponent(jcbbNganh, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtfSDT, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcbbKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcbbNganh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SDT)
                    .addComponent(jtfSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEdit)
                    .addComponent(btnClose))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbbKhoaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jcbbKhoaActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jcbbKhoaActionPerformed

    private void jcbbNganhActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jcbbNganhActionPerformed
        // TODO add your handling code here:

        int i = jcbbNganh.getSelectedIndex();
        switch (i) {
            case 1 -> khoa = 11;
            case 2 -> khoa = 30;
            case 3 -> khoa = 10;
            case 4 -> khoa = 38;
            case 5 -> khoa = 53;
            case 6 -> khoa = 01;
            case 7 -> khoa = 55;
            case 8 -> khoa = 02;
            case 9 -> khoa = 9;
            case 10 -> khoa = 15;
            case 11 -> khoa = 53;
            case 12 -> khoa = 48;
            default -> throw new AssertionError();
        }
    }// GEN-LAST:event_jcbbNganhActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }// GEN-LAST:event_btnCloseActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        ThanhVien tv = new ThanhVien();
        tv.setMaTV(id);
        tv.setHoTen(jtfName.getText());
        tv.setKhoa(jcbbKhoa.getSelectedItem().toString());
        tv.setNganh(jcbbNganh.getSelectedItem().toString());
        tv.setSDT(Integer.parseInt(jtfSDT.getText()));
        System.out.println(tv);
        tvBLL.updateThanhVien(tv);
                
        this.dispose();
        
    }// GEN-LAST:event_btnAddActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel SDT;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnEdit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JComboBox<String> jcbbKhoa;
    private javax.swing.JComboBox<String> jcbbNganh;
    private javax.swing.JTextField jtfName;
    private javax.swing.JTextField jtfSDT;
    // End of variables declaration//GEN-END:variables
}
