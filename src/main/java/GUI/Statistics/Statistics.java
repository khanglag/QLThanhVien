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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    List<Object[]> thongTinSDList = ttsdBLL.getThongTinSDWithDetails(); // Gọi hàm từ BLL để lấy dữ liệu
    List<Object[]> thongTinSDListMember = ttsdBLL.getThongTinSDWithDetailsMember(); // Gọi hàm từ BLL để lấy dữ liệu
    ArrayList<String> listKhoa = new ArrayList<>();
    ArrayList<String> listNganh = new ArrayList<>();

    public Statistics() {
        initComponents();
        LoadDataThanhVien();
        LoadDataXyLy();
        LoadDataThietBi();
    }

    public void LoadDataThanhVien() {
        int sumOfPeople = 0;
        model = (DefaultTableModel) tbMembers.getModel();
        model.setRowCount(0);
        TimeZone databaseTimeZone = TimeZone.getTimeZone("GMT");
        SimpleDateFormat sdfDisplay = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdfDisplay.setTimeZone(databaseTimeZone);
        for (Object[] thongTinSD : thongTinSDListMember) {
            sumOfPeople++;
            int maTT = (int) thongTinSD[0];
            int maTV = (int) thongTinSD[1];
            String hoTenThanhVien = (String) thongTinSD[2];
            String khoa = (String) thongTinSD[3];
            String nganh = (String) thongTinSD[4];
            int sdt = (int) thongTinSD[5];
            LocalDateTime tgVao = (LocalDateTime) thongTinSD[6];
            String formattedTGVao = (thongTinSD[6] != null) ? sdfDisplay.format(Date.from(tgVao.atZone(ZoneId.systemDefault()).toInstant())) : "Không có dữ liệu";
            model.addRow(new Object[]{
                maTT, maTV, hoTenThanhVien, khoa, nganh, sdt, formattedTGVao});
            tbMembers.setModel(model);
        }
        txtTotalMembers.setText(String.valueOf(sumOfPeople));
        for (ThanhVien on : listTv) {
            String khoa = on.getKhoa();
            String nganh = on.getNganh();
            if (!listKhoa.contains(khoa)) {
                cbbKhoa.addItem(khoa);
                listKhoa.add(khoa);
            }
            if (!listNganh.contains(nganh)) {
                cbbNganh.addItem(nganh);
                listNganh.add(nganh);
            }

        }
    }

    public void LoadDataXyLy() {
        model = (DefaultTableModel) tbXyly.getModel();
        model.setRowCount(0);
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
            txtTongSoTienBoiThuong.setText(String.valueOf(formattedNum) + " VNĐ");
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
        for (Object[] thongTinSD : thongTinSDList) {
            int maTT = (int) thongTinSD[0];
            int maTV = (int) thongTinSD[1];
            String hoTenThanhVien = (String) thongTinSD[2];
            int maTB = thongTinSD[3] != null ? (int) thongTinSD[3] : 0;
            String tenThietBi = thongTinSD[4] != null ? (String) thongTinSD[4] : "Không có dữ liệu";

            LocalDateTime tgVao = (LocalDateTime) thongTinSD[5];
            LocalDateTime tgMuon = (LocalDateTime) thongTinSD[6];
            LocalDateTime tgTra = (LocalDateTime) thongTinSD[7];

            String formattedTGVao = (thongTinSD[5] != null) ? sdfDisplay.format(Date.from(tgVao.atZone(ZoneId.systemDefault()).toInstant())) : "Không có dữ liệu";
            String formattedTGMuon = (thongTinSD[6] != null) ? sdfDisplay.format(Date.from(tgMuon.atZone(ZoneId.systemDefault()).toInstant())) : "Không có dữ liệu";
            String formattedTGTra = (thongTinSD[7] != null) ? sdfDisplay.format(Date.from(tgTra.atZone(ZoneId.systemDefault()).toInstant())) : "Không có dữ liệu";
            //System.out.println("MaTT: " + maTT + ", HoTenThanhVien: " + hoTenThanhVien + ", TenThietBi: " + tenThietBi + ", TGVao: " + tgVao + ", TGMuon: " + tgMuon + ", TGTra: " + tgTra);
            model.addRow(new Object[]{
                maTT, maTV, hoTenThanhVien, maTB, tenThietBi, formattedTGVao, formattedTGMuon, formattedTGTra
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
        btnfind1 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        timeTB = new com.toedter.calendar.JDateChooser();
        btnGetTimeTB = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        txtTenThietBi = new javax.swing.JTextField();
        btnfind = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbThietBi = new javax.swing.JTable();
        jPanel17 = new javax.swing.JPanel();
        txtTitleTienBoiThuong2 = new javax.swing.JLabel();
        txtTongLuotMuon = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        txtTitleTienBoiThuong = new javax.swing.JLabel();
        txtTongSoTienBoiThuong = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbXyly = new javax.swing.JTable();
        jPanel13 = new javax.swing.JPanel();
        cbbXyLyViPham = new javax.swing.JComboBox<>();
        btnXuLy = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        dateNext = new com.toedter.calendar.JDateChooser();
        datePrev = new com.toedter.calendar.JDateChooser();
        btnChonTime = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        cbbKhoa = new javax.swing.JComboBox<>();
        btnChonKhoa = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        cbbNganh = new javax.swing.JComboBox<>();
        btnChonNganh = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtTotalMembers = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbMembers = new javax.swing.JTable();
        btnChonNganh1 = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        btnfind1.setBackground(new java.awt.Color(0, 204, 51));
        btnfind1.setText("Refresh");
        btnfind1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnfind1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfind1ActionPerformed(evt);
            }
        });

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)), "Thống kê theo ngày"));

        timeTB.setBorder(javax.swing.BorderFactory.createTitledBorder("Chọn ngày thống kê"));
        timeTB.setDateFormatString("dd-MM-yyyy");

        btnGetTimeTB.setBackground(new java.awt.Color(0, 204, 51));
        btnGetTimeTB.setText("OK");
        btnGetTimeTB.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnGetTimeTB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetTimeTBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(timeTB, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGetTimeTB, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(timeTB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGetTimeTB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)), "Thống kê theo tên thiết bị"));

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

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTenThietBi, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnfind, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addComponent(txtTenThietBi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(btnfind, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)), "Thông tin chi tiết"));

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

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)), "Lượt mượn"));

        txtTitleTienBoiThuong2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTitleTienBoiThuong2.setText("Tổng lượt mượn");

        txtTongLuotMuon.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTongLuotMuon.setText("3");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTitleTienBoiThuong2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTongLuotMuon)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTitleTienBoiThuong2)
                    .addComponent(txtTongLuotMuon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jToggleButton1.setText("Chuyển");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 661, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jToggleButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(34, 34, 34)
                        .addComponent(btnfind1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnfind1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(jToggleButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Thiết bị", jPanel2);

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)), "Tiền bồi thường"));

        txtTitleTienBoiThuong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTitleTienBoiThuong.setText("Tổng tiền bồi thường:");

        txtTongSoTienBoiThuong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTongSoTienBoiThuong.setText("jLabel2");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTitleTienBoiThuong)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTongSoTienBoiThuong)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTitleTienBoiThuong)
                    .addComponent(txtTongSoTienBoiThuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)), "Thông tin chi tiết"));

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

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)), "Thống kê tình trạng xử lý"));

        cbbXyLyViPham.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đã được xử lý", "Chưa xử lý" }));
        cbbXyLyViPham.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnXuLy.setBackground(new java.awt.Color(0, 204, 51));
        btnXuLy.setText("OK");
        btnXuLy.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnXuLy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuLyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cbbXyLyViPham, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnXuLy, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(140, 140, 140))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbXyLyViPham, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXuLy, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 969, Short.MAX_VALUE)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Xử lý vi phạm", jPanel3);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)), "Thống kê theo ngày"));

        dateNext.setBorder(javax.swing.BorderFactory.createTitledBorder("Ngày sau"));
        dateNext.setDateFormatString("dd-MM-yyyy");

        datePrev.setBorder(javax.swing.BorderFactory.createTitledBorder("Ngày trước"));
        datePrev.setDateFormatString("dd-MM-yyyy");

        btnChonTime.setBackground(new java.awt.Color(0, 204, 51));
        btnChonTime.setText("OK");
        btnChonTime.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnChonTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonTimeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(datePrev, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(dateNext, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnChonTime, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnChonTime, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(datePrev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(dateNext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)), "Thống kê theo khoa"));

        cbbKhoa.setBorder(javax.swing.BorderFactory.createTitledBorder("Khoa"));

        btnChonKhoa.setBackground(new java.awt.Color(0, 204, 51));
        btnChonKhoa.setText("OK");
        btnChonKhoa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnChonKhoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonKhoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cbbKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnChonKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnChonKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)), "Thống kê theo ngành"));

        cbbNganh.setBorder(javax.swing.BorderFactory.createTitledBorder("Ngành"));

        btnChonNganh.setBackground(new java.awt.Color(0, 204, 51));
        btnChonNganh.setText("OK");
        btnChonNganh.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnChonNganh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonNganhActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbbNganh, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnChonNganh, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbbNganh)
                    .addComponent(btnChonNganh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 6, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true), "Tổng số lượng thành viên vào khu học tập"));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Tổng số thành viên:");

        txtTotalMembers.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTotalMembers.setText("0");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTotalMembers)
                .addGap(0, 74, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTotalMembers, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin chi tiết"));

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

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE))
        );

        btnChonNganh1.setBackground(new java.awt.Color(0, 204, 51));
        btnChonNganh1.setText("Refresh");
        btnChonNganh1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnChonNganh1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonNganh1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 368, Short.MAX_VALUE)
                        .addComponent(btnChonNganh1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnChonNganh1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Thành viên", jPanel1);

        jPanel15.setBackground(new java.awt.Color(36, 140, 190));

        jLabel4.setBackground(new java.awt.Color(36, 140, 190));
        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Statistics.png"))); // NOI18N
        jLabel4.setText("Thống kê");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 592, Short.MAX_VALUE))
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
            JOptionPane.showMessageDialog(null, "Bạn chưa điền tên thiết bị", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String getTenTB = "";
        ArrayList<ThietBi> tb = (ArrayList<ThietBi>) tbBLL.search(tentb);
        for (ThietBi on : tb) {
            getTenTB = on.getTenTB();

        }
        model = (DefaultTableModel) tbThietBi.getModel();
        model.setRowCount(0);

        TimeZone databaseTimeZone = TimeZone.getTimeZone("GMT");

        SimpleDateFormat sdfDisplay = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdfDisplay.setTimeZone(databaseTimeZone);

        for (ThongTinSD on : listTTSD) {
            List<ThietBi> getttb = tbBLL.search(on.getMaTB());
            String nametb = "";
            for (ThietBi gttb : getttb) {
                nametb = gttb.getTenTB();
            }
            String formattedTGVao = (on.getTGVao() != null) ? sdfDisplay.format(Date.from(on.getTGVao().atZone(ZoneId.systemDefault()).toInstant())) : "Không có dữ liệu";
            String formattedTGMuon = (on.getTGMuon() != null) ? sdfDisplay.format(Date.from(on.getTGMuon().atZone(ZoneId.systemDefault()).toInstant())) : "Không có dữ liệu";
            String formattedTGTra = (on.getTGTra() != null) ? sdfDisplay.format(Date.from(on.getTGTra().atZone(ZoneId.systemDefault()).toInstant())) : "Không có dữ liệu";

            if (nametb.equals(getTenTB)) {
                model.addRow(new Object[]{
                    on.getMaTT(), on.getMaTV(), "abc", on.getMaTB(), getTenTB, formattedTGVao, formattedTGMuon, formattedTGTra
                });
            }
        }
        tbThietBi.setModel(model);
    }//GEN-LAST:event_btnfindActionPerformed

    private void btnChonNganhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonNganhActionPerformed
        // TODO add your handling code here:
        String getNganh = (String) cbbNganh.getSelectedItem();
        model = (DefaultTableModel) tbMembers.getModel();
        model.setRowCount(0);
        TimeZone databaseTimeZone = TimeZone.getTimeZone("GMT");
        SimpleDateFormat sdfDisplay = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdfDisplay.setTimeZone(databaseTimeZone);
        for (Object[] thongTinSD : thongTinSDListMember) {
            int maTT = (int) thongTinSD[0];
            int maTV = (int) thongTinSD[1];
            String hoTenThanhVien = (String) thongTinSD[2];
            String khoa = (String) thongTinSD[3];
            String nganh = (String) thongTinSD[4];
            int sdt = (int) thongTinSD[5];
            LocalDateTime tgVao = (LocalDateTime) thongTinSD[6];
            String formattedTGVao = (thongTinSD[6] != null) ? sdfDisplay.format(Date.from(tgVao.atZone(ZoneId.systemDefault()).toInstant())) : "Không có dữ liệu";
            if (getNganh.equals(nganh)) {
                model.addRow(new Object[]{
                    maTT, maTV, hoTenThanhVien, khoa, nganh, sdt, formattedTGVao});
                tbMembers.setModel(model);
            }
        }
    }//GEN-LAST:event_btnChonNganhActionPerformed

    private void btnChonKhoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonKhoaActionPerformed
        // TODO add your handling code here:
        String getKhoa = (String) cbbKhoa.getSelectedItem();
        model = (DefaultTableModel) tbMembers.getModel();
        model.setRowCount(0);
        TimeZone databaseTimeZone = TimeZone.getTimeZone("GMT");
        SimpleDateFormat sdfDisplay = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdfDisplay.setTimeZone(databaseTimeZone);
        for (Object[] thongTinSD : thongTinSDListMember) {
            int maTT = (int) thongTinSD[0];
            int maTV = (int) thongTinSD[1];
            String hoTenThanhVien = (String) thongTinSD[2];
            String khoa = (String) thongTinSD[3];
            String nganh = (String) thongTinSD[4];
            int sdt = (int) thongTinSD[5];
            LocalDateTime tgVao = (LocalDateTime) thongTinSD[6];
            String formattedTGVao = (thongTinSD[6] != null) ? sdfDisplay.format(Date.from(tgVao.atZone(ZoneId.systemDefault()).toInstant())) : "Không có dữ liệu";
            if (getKhoa.equals(khoa)) {
                model.addRow(new Object[]{
                    maTT, maTV, hoTenThanhVien, khoa, nganh, sdt, formattedTGVao});
                tbMembers.setModel(model);
            }
        }
    }//GEN-LAST:event_btnChonKhoaActionPerformed

    private void btnfind1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfind1ActionPerformed
        // TODO add your handling code here:
        LoadDataThietBi();
    }//GEN-LAST:event_btnfind1ActionPerformed

    private void btnGetTimeTBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetTimeTBActionPerformed
        // TODO add your handling code here:
        java.util.Date getDate = timeTB.getDate();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = sdf.format(getDate);

        TimeZone databaseTimeZone = TimeZone.getTimeZone("GMT");
        SimpleDateFormat sdfDisplay = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdfDisplay.setTimeZone(databaseTimeZone);

        // Tạo một đối tượng SimpleDateFormat mới với mẫu định dạng "yyyy-MM-dd"
        SimpleDateFormat sdfOutput = new SimpleDateFormat("yyyy-MM-dd");
        if (getDate == null) {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn ngày sử dụng thiết bị", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        model = (DefaultTableModel) tbThietBi.getModel();
        model.setRowCount(0);
        for (ThongTinSD on : listTTSD) {
            List<ThietBi> listtenTB = tbBLL.search(on.getMaTB());
            String tentb = "";
            for (ThietBi tb : listtenTB) {
                tentb = tb.getTenTB();
            }
            String formattedTGVao = (on.getTGVao() != null) ? sdfDisplay.format(Date.from(on.getTGVao().atZone(ZoneId.systemDefault()).toInstant())) : "Không có dữ liệu";
            String formattedTGMuon = (on.getTGMuon() != null) ? sdfDisplay.format(Date.from(on.getTGMuon().atZone(ZoneId.systemDefault()).toInstant())) : "Không có dữ liệu";
            String formattedTGTra = (on.getTGTra() != null) ? sdfDisplay.format(Date.from(on.getTGTra().atZone(ZoneId.systemDefault()).toInstant())) : "Không có dữ liệu";
            if (formattedTGMuon != null) {
                try {
                    Date x = sdfDisplay.parse(formattedTGMuon);
                    String a = sdfOutput.format(x);
                    if (formattedDate.equals(a)) {
                        model.addRow(new Object[]{
                            on.getMaTT(), on.getMaTV(), "abc", on.getMaTB(), tentb, formattedTGVao, formattedTGMuon, formattedTGTra
                        });
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        tbThietBi.setModel(model);
    }//GEN-LAST:event_btnGetTimeTBActionPerformed

    private void btnChonTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonTimeActionPerformed
        // TODO add your handling code here:
        model = (DefaultTableModel) tbMembers.getModel();
        model.setRowCount(0);
        TimeZone databaseTimeZone = TimeZone.getTimeZone("GMT");
        SimpleDateFormat sdfDisplay = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdfDisplay.setTimeZone(databaseTimeZone);

        SimpleDateFormat sdfOutput = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date dayPrev = datePrev.getDate();
        java.util.Date dayNext = dateNext.getDate();
        if (dayPrev == null || dayNext == null) {
            JOptionPane.showMessageDialog(null,
                    "Vui lòng chọn đầy đủ ngày trước và ngày sau");
            return;
        }
        Instant instant1 = dayPrev.toInstant();
        LocalDate localDate1 = instant1.atZone(ZoneId.systemDefault()).toLocalDate();
        Instant instant2 = dayNext.toInstant();
        LocalDate localDate2 = instant2.atZone(ZoneId.systemDefault()).toLocalDate();
        if (localDate1.equals(localDate2)) {
            int sumOfPeople = 0;
            for (Object[] thongTinSD : thongTinSDListMember) {
                int maTT = (int) thongTinSD[0];
                int maTV = (int) thongTinSD[1];
                String hoTenThanhVien = (String) thongTinSD[2];
                String khoa = (String) thongTinSD[3];
                String nganh = (String) thongTinSD[4];
                int sdt = (int) thongTinSD[5];
                LocalDateTime tgVao = (LocalDateTime) thongTinSD[6];
                String formattedTGVao = (thongTinSD[6] != null) ? sdfDisplay.format(Date.from(tgVao.atZone(ZoneId.systemDefault()).toInstant())) : "Không có dữ liệu";

                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                String dateLocaltime1 = localDate1.format(formatter);

                Date date;
                String dateString = "";

                try {
                    date = dateFormat.parse(formattedTGVao);
                    SimpleDateFormat outputDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    dateString = outputDateFormat.format(date);
                } catch (ParseException ex) {
                    Logger.getLogger(Statistics.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (dateLocaltime1.equals(dateString)) {
                    sumOfPeople++;
                    model.addRow(new Object[]{
                        maTT, maTV, hoTenThanhVien, khoa, nganh, sdt, formattedTGVao});
                    tbMembers.setModel(model);
                }
            }
            txtTotalMembers.setText(String.valueOf(sumOfPeople));
            return;
        }
        if (localDate1.isBefore(localDate2)) {
            int sumOfPeople = 0;
            for (Object[] thongTinSD : thongTinSDListMember) {

                int maTT = (int) thongTinSD[0];
                int maTV = (int) thongTinSD[1];
                String hoTenThanhVien = (String) thongTinSD[2];
                String khoa = (String) thongTinSD[3];
                String nganh = (String) thongTinSD[4];
                int sdt = (int) thongTinSD[5];
                LocalDateTime tgVao = (LocalDateTime) thongTinSD[6];
                String formattedTGVao = (thongTinSD[6] != null) ? sdfDisplay.format(Date.from(tgVao.atZone(ZoneId.systemDefault()).toInstant())) : "Không có dữ liệu";

                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

                String dateLocaltime1 = localDate1.format(formatter);
                String dateLocaltime2 = localDate2.format(formatter);
                Date date;
                String dateString = "";

                try {
                    date = dateFormat.parse(formattedTGVao);
                    SimpleDateFormat outputDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    dateString = outputDateFormat.format(date);

                } catch (ParseException ex) {
                    Logger.getLogger(Statistics.class.getName()).log(Level.SEVERE, null, ex);
                }
                LocalDate tgVaoLocalDate = LocalDate.parse(dateString, formatter);
                if ((localDate1.isBefore(tgVaoLocalDate) || dateString.equals(dateLocaltime1)) && (dateString.equals(dateLocaltime2) || tgVaoLocalDate.isBefore(localDate2))) {
                    sumOfPeople++;
                    model.addRow(new Object[]{
                        maTT, maTV, hoTenThanhVien, khoa, nganh, sdt, formattedTGVao});
                    tbMembers.setModel(model);
                }
            }
            txtTotalMembers.setText(String.valueOf(sumOfPeople));
            return;
        } else {
            JOptionPane.showMessageDialog(null,
                    "Chọn ngày không hợp lệ ngày trước phải nhỏ hơn ngày sau");
            return;
        }
    }//GEN-LAST:event_btnChonTimeActionPerformed

    private void btnChonNganh1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonNganh1ActionPerformed
        // TODO add your handling code here:
        LoadDataThanhVien();
    }//GEN-LAST:event_btnChonNganh1ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        ThongTinSDBLL bLL=new ThongTinSDBLL();
        if (!jToggleButton1.isSelected()) {
        txtTitleTienBoiThuong2.setText("Tổng lượt mượn:");
        txtTongLuotMuon.setText(bLL.demSoLanMuonThietBi()+"");
    } else {
        txtTitleTienBoiThuong2.setText("Tổng lượt đang mượn:");
        txtTongLuotMuon.setText(bLL.demThietBiDangMuon()+"");
    }
    }//GEN-LAST:event_jToggleButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChonKhoa;
    private javax.swing.JButton btnChonNganh;
    private javax.swing.JButton btnChonNganh1;
    private javax.swing.JButton btnChonTime;
    private javax.swing.JButton btnGetTimeTB;
    private javax.swing.JButton btnXuLy;
    private javax.swing.JButton btnfind;
    private javax.swing.JButton btnfind1;
    private javax.swing.JComboBox<String> cbbKhoa;
    private javax.swing.JComboBox<String> cbbNganh;
    private javax.swing.JComboBox<String> cbbXyLyViPham;
    private com.toedter.calendar.JDateChooser dateNext;
    private com.toedter.calendar.JDateChooser datePrev;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTable tbMembers;
    private javax.swing.JTable tbThietBi;
    private javax.swing.JTable tbXyly;
    private com.toedter.calendar.JDateChooser timeTB;
    private javax.swing.JTextField txtTenThietBi;
    private javax.swing.JLabel txtTitleTienBoiThuong;
    private javax.swing.JLabel txtTitleTienBoiThuong1;
    private javax.swing.JLabel txtTitleTienBoiThuong2;
    private javax.swing.JLabel txtTongLuotMuon;
    private javax.swing.JLabel txtTongSoTienBoiThuong;
    private javax.swing.JLabel txtTongSoTienBoiThuong1;
    private javax.swing.JLabel txtTotalMembers;
    // End of variables declaration//GEN-END:variables
}
