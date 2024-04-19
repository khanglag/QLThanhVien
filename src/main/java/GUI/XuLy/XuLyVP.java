/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.XuLy;

import BLL.XuLyBLL;
import DAL.XuLy;
import GUI.QLTB.suaThongtin;
import java.awt.event.KeyEvent;
import java.time.LocalDateTime;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Huy Tin
 */
public class XuLyVP extends javax.swing.JPanel {

    private XuLyBLL xuLyBLL;

    public XuLyVP() {
        initComponents();
        xuLyBLL = new XuLyBLL();
        LoadData();

    }

    private void LoadData() {
        List<XuLy> xuLyList = xuLyBLL.loadXuLy();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

        for (XuLy xuLy : xuLyList) {
            model.addRow(new Object[]{xuLy.getMaXL(), xuLy.getMaTV(), xuLy.getHinhThucXL(),
                xuLy.getSoTien(), xuLy.getNgayXL(), xuLy.getTrangThaiXL()});
        }
    }

    private void timKiem() {
        String keyword = tx_timKiem.getText().trim();

        if (!keyword.isEmpty()) {
            try {
                int maTV = Integer.parseInt(keyword);
                List<XuLy> xuLyList = xuLyBLL.searchXuLy(maTV);
                if (xuLyList.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Không tìm thấy xử lý cho thành viên: " + maTV, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                model.setRowCount(0);
                for (XuLy xuLy : xuLyList) {
                    model.addRow(new Object[]{xuLy.getMaXL(), xuLy.getMaTV(), xuLy.getHinhThucXL(),
                        xuLy.getSoTien(), xuLy.getNgayXL(), xuLy.getTrangThaiXL()});
                }
            } catch (NumberFormatException e) {
                // Nếu không thể chuyển đổi keyword thành số nguyên, thì tìm kiếm theo từ khóa
                List<XuLy> xuLyList = xuLyBLL.searchXuLy(keyword);
                if (xuLyList.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Không tìm thấy xử lý: " + keyword, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                model.setRowCount(0);
                for (XuLy xuLy : xuLyList) {
                    model.addRow(new Object[]{xuLy.getMaXL(), xuLy.getMaTV(), xuLy.getHinhThucXL(),
                        xuLy.getSoTien(), xuLy.getNgayXL(), xuLy.getTrangThaiXL()});
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập từ khóa tìm kiếm.");
        }
    }

    private void XoaXuLy() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow != -1) {
            int dialogResult = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa dòng này?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
            if (dialogResult == JOptionPane.YES_OPTION) {
                int maXL = (int) model.getValueAt(selectedRow, 0);
                xuLyBLL.deleteXuLy(maXL);
                JOptionPane.showMessageDialog(this, "Xóa thành công.");
                LoadData();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng để xóa.");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        tx_timKiem = new javax.swing.JTextField();
        btn_reload = new javax.swing.JButton();
        btn_them = new javax.swing.JButton();
        btn_xoa = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "MaXL", "MaTV", "HinhThucXuLy", "SoTien", "NgayXL", "TrangThaiXL"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        tx_timKiem.setPreferredSize(new java.awt.Dimension(300, 30));
        tx_timKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tx_timKiemKeyPressed(evt);
            }
        });
        jPanel1.add(tx_timKiem);

        btn_reload.setText("Làm mới");
        btn_reload.setPreferredSize(new java.awt.Dimension(85, 30));
        btn_reload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reloadActionPerformed(evt);
            }
        });
        jPanel1.add(btn_reload);

        btn_them.setText("Thêm");
        btn_them.setPreferredSize(new java.awt.Dimension(75, 30));
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });
        jPanel1.add(btn_them);

        btn_xoa.setText("Xóa");
        btn_xoa.setPreferredSize(new java.awt.Dimension(75, 30));
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });
        jPanel1.add(btn_xoa);

        btn_sua.setText("Sửa");
        btn_sua.setPreferredSize(new java.awt.Dimension(75, 30));
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });
        jPanel1.add(btn_sua);

        jPanel2.setBackground(new java.awt.Color(36, 140, 190));

        jLabel4.setBackground(new java.awt.Color(36, 140, 190));
        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Triangle.png"))); // NOI18N
        jLabel4.setText("Quản lý thiết bị");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_reloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reloadActionPerformed
        LoadData();
    }//GEN-LAST:event_btn_reloadActionPerformed

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        themXL a = new themXL();
        a.setVisible(true);
    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        XoaXuLy();
    }//GEN-LAST:event_btn_xoaActionPerformed

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow != -1) {
            int maXL = Integer.parseInt(jTable1.getValueAt(selectedRow, 0).toString());
            int maTV = Integer.parseInt(jTable1.getValueAt(selectedRow, 1).toString());
            String hinhThucXL = jTable1.getValueAt(selectedRow, 2).toString();
            int soTien;
            if (jTable1.getValueAt(selectedRow, 3) == null || jTable1.getValueAt(selectedRow, 3).toString().isEmpty()) {
                soTien = 0;
            } else {
                soTien = Integer.parseInt(jTable1.getValueAt(selectedRow, 3).toString());
            }
            LocalDateTime ngayXL = (LocalDateTime) jTable1.getValueAt(selectedRow, 4);
            String trangThaiXL = jTable1.getValueAt(selectedRow, 5).toString();

            suaXL a = new suaXL(maXL, maTV, hinhThucXL, soTien, ngayXL, trangThaiXL);
            a.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn thiết bị để sửa thông tin", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btn_suaActionPerformed

    private void tx_timKiemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tx_timKiemKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            timKiem();
        }
    }//GEN-LAST:event_tx_timKiemKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_reload;
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField tx_timKiem;
    // End of variables declaration//GEN-END:variables
}
