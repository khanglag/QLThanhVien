/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.Statistics;

import BLL.ThanhVienBLL;
import BLL.ThietBiBLL;
import BLL.ThongTinSDBLL;
import BLL.XuLyBLL;
import DAL.ThanhVien;
import DAL.ThietBi;
import DAL.ThongTinSD;
import DAL.XuLy;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author acer
 */
public class Statistics extends javax.swing.JPanel {

    DefaultTableModel model;

    ThanhVienBLL tvBLL = new ThanhVienBLL();
    XuLyBLL xlBLL = new XuLyBLL();
    ThongTinSDBLL ttsdBLL = new ThongTinSDBLL();
    ThietBiBLL tbBLL = new ThietBiBLL();

    ArrayList<ThanhVien> listTv = (ArrayList<ThanhVien>) tvBLL.loadThanhVien();
    ArrayList<XuLy> listXl = (ArrayList<XuLy>) xlBLL.loadXuLy();
    ArrayList<ThongTinSD> listTTSD = (ArrayList<ThongTinSD>) ttsdBLL.loadThongTinSD();

    ArrayList<String> listKhoa = new ArrayList<>();
    ArrayList<String> listNganh = new ArrayList<>();

    public Statistics() {
        initComponents();
        LoadDataThanhVien();
        LoadDataXyLy();
        LoadDataThietBi();
    }

    public void LoadDataThanhVien() {
        model = (DefaultTableModel) tbMembers.getModel();
        model.setRowCount(0);
//      listTv = (ArrayList<ThanhVien>) tvBLL.loadThanhVien();
        for (ThanhVien on : listTv) {
            String khoa = on.getKhoa();
            String nganh = on.getNganh();
            if (!listKhoa.contains(khoa)) {
                cbbKhoa.addItem(khoa);
                listKhoa.add(khoa);
            }
            if (!listNganh.contains(nganh)) {
                cbbNganh.addItem(nganh);
                listKhoa.add(nganh);
            }
            model.addRow(new Object[]{
                on.getMaTV(), on.getHoTen(), on.getKhoa(), on.getNganh(), on.getSDT()
            });
            tbMembers.setModel(model);
        }
    }

    public void LoadDataXyLy() {
        model = (DefaultTableModel) tbXyly.getModel();
        model.setRowCount(0);
        //   listXl = (ArrayList<XuLy>) xlBLL.loadXuLy();
        int total = 0;
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        String ttXLDaXL = "Đã xử lý";
        String ttXLChuaXL = "Đang xử lý";
        if (cbbXyLyViPham.getSelectedIndex() == 0) {
            for (XuLy on : listXl) {
                if (on.getTrangThaiXL().equals(1)) {
                    model.addRow(new Object[]{
                        on.getMaXL(), on.getMaTV(), on.getHinhThucXL(), on.getSoTien(), on.getNgayXL(), ttXLDaXL
                    });
                }
                if (on.getSoTien() != null) {
                    total += on.getSoTien();
                }
                tbXyly.setModel(model);
            }
            String formattedNum = decimalFormat.format(total);
            txtTitleTienBoiThuong.setVisible(true);
            txtTongSoTienBoiThuong.setVisible(true);
            txtTongSoTienBoiThuong.setText(String.valueOf(formattedNum));
        } else {
            for (XuLy on : listXl) {
                if (on.getTrangThaiXL().equals(0)) {
                    model.addRow(new Object[]{
                        on.getMaXL(), on.getMaTV(), on.getHinhThucXL(), on.getSoTien(), on.getNgayXL(), ttXLChuaXL
                    });
                }
                txtTitleTienBoiThuong.setVisible(false);
                txtTongSoTienBoiThuong.setVisible(false);
                tbXyly.setModel(model);
            }
        }
    }

    public void LoadDataThietBi() {
        model = (DefaultTableModel) tbThietBi.getModel();
        model.setRowCount(0);

        TimeZone databaseTimeZone = TimeZone.getTimeZone("GMT");

        SimpleDateFormat sdfDisplay = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdfDisplay.setTimeZone(databaseTimeZone);

        for (ThongTinSD on : listTTSD) {
            List<ThietBi> listtenTB = tbBLL.search(on.getMaTB());
            String tentb = "";
            for (ThietBi tb : listtenTB) {
                tentb = tb.getTenTB();
            }
            String formattedTGVao = (on.getTGVao() != null) ? sdfDisplay.format(Date.from(on.getTGVao().atZone(ZoneId.systemDefault()).toInstant())) : "Không có dữ liệu";
            String formattedTGMuon = (on.getTGMuon() != null) ? sdfDisplay.format(Date.from(on.getTGMuon().atZone(ZoneId.systemDefault()).toInstant())) : "Không có dữ liệu";
            String formattedTGTra = (on.getTGTra() != null) ? sdfDisplay.format(Date.from(on.getTGTra().atZone(ZoneId.systemDefault()).toInstant())) : "Không có dữ liệu";

            model.addRow(new Object[]{
                on.getMaTT(), on.getMaTV(), "abc", on.getMaTB(), tentb, formattedTGVao, formattedTGMuon, formattedTGTra
            });
        }

        tbThietBi.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jdcTime1 = new com.toedter.calendar.JDateChooser();
        btnOK1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbThietBi = new javax.swing.JTable();
        txtTenThietBi = new javax.swing.JTextField();
        btnfind = new javax.swing.JButton();
        btnfind1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        cbbXyLyViPham = new javax.swing.JComboBox<>();
        btnXuLy = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbXyly = new javax.swing.JTable();
        txtTitleTienBoiThuong = new javax.swing.JLabel();
        txtTongSoTienBoiThuong = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jdcTime = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbMembers = new javax.swing.JTable();
        btnChonTime = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtTotalMembers = new javax.swing.JLabel();
        cbbKhoa = new javax.swing.JComboBox<>();
        cbbNganh = new javax.swing.JComboBox<>();
        btnChonNganh = new javax.swing.JButton();
        btnChonKhoa = new javax.swing.JButton();

        jdcTime1.setDateFormatString("dd-MM-yyyy");

        btnOK1.setBackground(new java.awt.Color(0, 204, 51));
        btnOK1.setText("OK");
        btnOK1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tbThietBi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã thông tin", "Mã thành viên", "Họ tên", "Mã thiết bị", "Tên thiết bị", "Thời gian vào", "Thời gian mượn", "Thời gian trả"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbThietBi);

        txtTenThietBi.setBorder(javax.swing.BorderFactory.createTitledBorder("Nhập tên thiết bị"));
        txtTenThietBi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenThietBiActionPerformed(evt);
            }
        });

        btnfind.setBackground(new java.awt.Color(0, 204, 51));
        btnfind.setText("Tìm kiếm");
        btnfind.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnfind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfindActionPerformed(evt);
            }
        });

        btnfind1.setBackground(new java.awt.Color(0, 204, 51));
        btnfind1.setText("Refresh");
        btnfind1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnfind1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfind1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jdcTime1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnOK1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addComponent(txtTenThietBi, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnfind, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnfind1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 975, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jdcTime1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnOK1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtTenThietBi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnfind, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(btnfind1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Thiết bị", jPanel2);

        cbbXyLyViPham.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đã được xử lý", "Đang xử lý" }));
        cbbXyLyViPham.setBorder(javax.swing.BorderFactory.createTitledBorder("Xử lý vi phạm theo:"));

        btnXuLy.setBackground(new java.awt.Color(0, 204, 51));
        btnXuLy.setText("OK");
        btnXuLy.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnXuLy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuLyActionPerformed(evt);
            }
        });

        tbXyly.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã xử lý", "Mã thành viên", "Hình thức xử lý", "Số tiền ", "Ngày xử lý", "Trạng thái xử lý"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Float.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tbXyly);

        txtTitleTienBoiThuong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTitleTienBoiThuong.setText("Tổng tiền bồi thường:");

        txtTongSoTienBoiThuong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTongSoTienBoiThuong.setText("jLabel2");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(cbbXyLyViPham, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXuLy, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 975, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtTitleTienBoiThuong)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTongSoTienBoiThuong)
                .addGap(127, 127, 127))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbXyLyViPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXuLy, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTitleTienBoiThuong)
                    .addComponent(txtTongSoTienBoiThuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Xử lý vi phạm", jPanel3);

        jdcTime.setDateFormatString("dd-MM-yyyy");

        tbMembers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã thông tin", "Mã thành viên", "Họ tên", "Khoa", "Ngành", "SĐT", "Thời gian vào"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbMembers);

        btnChonTime.setBackground(new java.awt.Color(0, 204, 51));
        btnChonTime.setText("OK");
        btnChonTime.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Tổng số thành viên:");

        txtTotalMembers.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTotalMembers.setText("jLabel2");

        cbbKhoa.setBorder(javax.swing.BorderFactory.createTitledBorder("Khoa"));

        cbbNganh.setBorder(javax.swing.BorderFactory.createTitledBorder("Ngành"));

        btnChonNganh.setBackground(new java.awt.Color(0, 204, 51));
        btnChonNganh.setText("OK");
        btnChonNganh.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnChonNganh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonNganhActionPerformed(evt);
            }
        });

        btnChonKhoa.setBackground(new java.awt.Color(0, 204, 51));
        btnChonKhoa.setText("OK");
        btnChonKhoa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnChonKhoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonKhoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jdcTime, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnChonTime, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(cbbKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnChonKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(cbbNganh, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnChonNganh, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 975, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTotalMembers)
                .addGap(95, 95, 95))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jdcTime, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnChonTime, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnChonKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbNganh, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnChonNganh, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTotalMembers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Thành viên", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnXuLyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuLyActionPerformed
        // TODO add your handling code here:
        LoadDataXyLy();
    }//GEN-LAST:event_btnXuLyActionPerformed

    private void txtTenThietBiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenThietBiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenThietBiActionPerformed

    private void btnfindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfindActionPerformed
        // TODO add your handling code here:
        String tentb = txtTenThietBi.getText().strip();
        if (txtTenThietBi.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Text field is empty!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

      ArrayList<ThietBi> tb = (ArrayList<ThietBi>)  tbBLL.search(tentb);
        for(ThietBi on: tb){
           int matb = on.getMaTB();
            System.out.println(matb);
        }
//          model = (DefaultTableModel) tbThietBi.getModel();
//        model.setRowCount(0);
//        
//        TimeZone databaseTimeZone = TimeZone.getTimeZone("GMT");
//       
//        SimpleDateFormat sdfDisplay = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        sdfDisplay.setTimeZone(databaseTimeZone);
//        
//        for (ThongTinSD on : listTTSD) {
//            List<ThietBi> listtenTB = tbBLL.search(on.getMaTB());
//            String tentb = "";
//            for (ThietBi tb : listtenTB) {
//                tentb = tb.getTenTB();
//            }
//            String formattedTGVao = (on.getTGVao() != null) ? sdfDisplay.format(Date.from(on.getTGVao().atZone(ZoneId.systemDefault()).toInstant())) : "Không có dữ liệu";
//            String formattedTGMuon = (on.getTGMuon() != null) ? sdfDisplay.format(Date.from(on.getTGMuon().atZone(ZoneId.systemDefault()).toInstant())) : "Không có dữ liệu";
//            String formattedTGTra = (on.getTGTra() != null) ? sdfDisplay.format(Date.from(on.getTGTra().atZone(ZoneId.systemDefault()).toInstant())) : "Không có dữ liệu";
//
//            model.addRow(new Object[]{
//                on.getMaTT(), on.getMaTV(), "abc", on.getMaTB(), tentb, formattedTGVao, formattedTGMuon, formattedTGTra
//            });
//        }
//        
//        tbThietBi.setModel(model);

    }//GEN-LAST:event_btnfindActionPerformed

    private void btnChonNganhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonNganhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnChonNganhActionPerformed

    private void btnChonKhoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonKhoaActionPerformed
        // TODO add your handling code here:
        String getKhoa = (String) cbbKhoa.getSelectedItem();
        model = (DefaultTableModel) tbMembers.getModel();
        model.setRowCount(0);
        for (ThanhVien on : listTv) {
            if (getKhoa.equals(on.getKhoa())) {
                model.addRow(new Object[]{
                    on.getMaTV(), on.getHoTen(), on.getKhoa(), on.getNganh(), on.getSDT()
                });
                tbMembers.setModel(model);
            }
        }
    }//GEN-LAST:event_btnChonKhoaActionPerformed

    private void btnfind1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfind1ActionPerformed
        // TODO add your handling code here:
        LoadDataThietBi();
    }//GEN-LAST:event_btnfind1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChonKhoa;
    private javax.swing.JButton btnChonNganh;
    private javax.swing.JButton btnChonTime;
    private javax.swing.JButton btnOK1;
    private javax.swing.JButton btnXuLy;
    private javax.swing.JButton btnfind;
    private javax.swing.JButton btnfind1;
    private javax.swing.JComboBox<String> cbbKhoa;
    private javax.swing.JComboBox<String> cbbNganh;
    private javax.swing.JComboBox<String> cbbXyLyViPham;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private com.toedter.calendar.JDateChooser jdcTime;
    private com.toedter.calendar.JDateChooser jdcTime1;
    private javax.swing.JTable tbMembers;
    private javax.swing.JTable tbThietBi;
    private javax.swing.JTable tbXyly;
    private javax.swing.JTextField txtTenThietBi;
    private javax.swing.JLabel txtTitleTienBoiThuong;
    private javax.swing.JLabel txtTongSoTienBoiThuong;
    private javax.swing.JLabel txtTotalMembers;
    // End of variables declaration//GEN-END:variables
}
