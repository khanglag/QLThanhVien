/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.QLTB;

import BLL.ThietBiBLL;
import DAL.ThietBi;
import DAL.ThietBiDAL;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Huy Tin
 */
public class QLTB extends javax.swing.JPanel {

    private ThietBiBLL thietBiBLL;

    public QLTB() {
        initComponents();
        thietBiBLL = new ThietBiBLL();
        LoadData();
    }

    private void LoadData() {
        List<ThietBi> thietBiList = thietBiBLL.loadThietbi();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        Object[] row = new Object[3];

        for (ThietBi tb : thietBiList) {
            row[0] = tb.getMaTB();
            row[1] = tb.getTenTB();
            row[2] = tb.getMoTaTB();
            model.addRow(row);
        }
    }

    private void timKiem() {
        String keyword = tx_timKiem.getText().trim();

        if (!keyword.isEmpty()) {
            List<ThietBi> thietBiList = thietBiBLL.search(keyword);
            if (thietBiList.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Không tìm thấy thiết bị: " + keyword, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            Object[] row = new Object[3];
            for (ThietBi tb : thietBiList) {
                row[0] = tb.getMaTB();
                row[1] = tb.getTenTB();
                row[2] = tb.getMoTaTB();
                model.addRow(row);
            }
        } else {
            LoadData();
        }
    }

    private void xoaThietBi() {
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow == -1) {
            //JOptionPane.showMessageDialog(this, "Vui lòng chọn một thiết bị để xóa.");
            xoaTB_DieuKien a = new xoaTB_DieuKien();
            a.setVisible(true);
            return;
        }

        int option = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa thiết bị này?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            int maTB = (int) jTable1.getValueAt(selectedRow, 0);
            thietBiBLL.deleteThietBi(maTB);
            JOptionPane.showMessageDialog(this, "Xóa thiết bị " + maTB + " thành công.");
        }
        LoadData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        tx_timKiem = new javax.swing.JTextField();
        reloadTable = new javax.swing.JButton();
        btn_them = new javax.swing.JButton();
        btn_xoa = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "MaTB", "TenTB", "MoTaTB"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        tx_timKiem.setPreferredSize(new java.awt.Dimension(250, 30));
        tx_timKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tx_timKiemKeyPressed(evt);
            }
        });
        jPanel1.add(tx_timKiem);

        reloadTable.setText("Làm mới");
        reloadTable.setPreferredSize(new java.awt.Dimension(85, 30));
        reloadTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reloadTableActionPerformed(evt);
            }
        });
        jPanel1.add(reloadTable);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void reloadTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reloadTableActionPerformed
        LoadData();
    }//GEN-LAST:event_reloadTableActionPerformed

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        ThemTB a = new ThemTB();
        a.setVisible(true);
    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        xoaThietBi();
    }//GEN-LAST:event_btn_xoaActionPerformed

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow != -1) {
            int maTB = Integer.parseInt(jTable1.getValueAt(selectedRow, 0).toString());
            String tenTB = jTable1.getValueAt(selectedRow, 1).toString();
            String moTaTB = jTable1.getValueAt(selectedRow, 2).toString();
            
            suaThongtin a = new suaThongtin(maTB, tenTB, moTaTB);
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
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton reloadTable;
    private javax.swing.JTextField tx_timKiem;
    // End of variables declaration//GEN-END:variables
}
