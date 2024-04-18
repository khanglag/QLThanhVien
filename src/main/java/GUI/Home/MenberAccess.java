/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.Home;

import BLL.ThanhVienBLL;
import BLL.ThietBiBLL;
import BLL.ThongTinSDBLL;
import BLL.XuLyBLL;
import DAL.ThongTinSD;
import java.awt.BorderLayout;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author pc
 */
public class MenberAccess extends javax.swing.JPanel {
    ThanhVienBLL bLL =new ThanhVienBLL();
    /**
     * Creates new form MenberAccess
     */
    public MenberAccess() {
        initComponents();
        LoadDataMenber();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanelResuil = new javax.swing.JPanel();
        jPanelGanDay = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableGanDay = new javax.swing.JTable();
        jTabbedPane = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jTfKhoa = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTfHoTen = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTfTT = new javax.swing.JTextField();
        jTfMaTV1 = new javax.swing.JTextField();
        jTfNganh = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnCheckIn = new javax.swing.JButton();
        btnCheckIn1 = new javax.swing.JButton();
        Hehe = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jTfMaTB = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTfTenTb = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTfTTTB = new javax.swing.JTextField();
        btnCheckIn4 = new javax.swing.JButton();
        btnCheckIn5 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jTfMaTV = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTfHoTen1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTfTT1 = new javax.swing.JTextField();

        setBackground(new java.awt.Color(223, 223, 223));
        setPreferredSize(new java.awt.Dimension(703, 700));

        jPanel1.setBackground(new java.awt.Color(36, 140, 190));

        jLabel4.setBackground(new java.awt.Color(36, 140, 190));
        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/house-24.png"))); // NOI18N
        jLabel4.setText("Check-in");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanelResuil.setBackground(new java.awt.Color(255, 255, 255));

        jPanelGanDay.setBackground(new java.awt.Color(255, 255, 255));
        jPanelGanDay.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gần đây", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Helvetica Neue", 0, 14), new java.awt.Color(51, 51, 51))); // NOI18N

        jTableGanDay.setBackground(new java.awt.Color(255, 255, 255));
        jTableGanDay.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã thành viên", "Tên thành viên", "Thời gian vào", "Thiết bị mượn", "Thời gian mượn", "Thời gian trả"
            }
        ));
        jTableGanDay.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(jTableGanDay);

        javax.swing.GroupLayout jPanelGanDayLayout = new javax.swing.GroupLayout(jPanelGanDay);
        jPanelGanDay.setLayout(jPanelGanDayLayout);
        jPanelGanDayLayout.setHorizontalGroup(
            jPanelGanDayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGanDayLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelGanDayLayout.setVerticalGroup(
            jPanelGanDayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGanDayLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelResuilLayout = new javax.swing.GroupLayout(jPanelResuil);
        jPanelResuil.setLayout(jPanelResuilLayout);
        jPanelResuilLayout.setHorizontalGroup(
            jPanelResuilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelResuilLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelGanDay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelResuilLayout.setVerticalGroup(
            jPanelResuilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelResuilLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanelGanDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jTabbedPane.setForeground(new java.awt.Color(51, 51, 51));
        jTabbedPane.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Mã thành viên");

        jTfKhoa.setBackground(new java.awt.Color(255, 255, 255));
        jTfKhoa.setForeground(new java.awt.Color(51, 51, 51));
        jTfKhoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTfKhoaActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Họ và tên");

        jTfHoTen.setEditable(false);
        jTfHoTen.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Tình trạng thành viên");

        jTfTT.setEditable(false);
        jTfTT.setBackground(new java.awt.Color(255, 255, 255));
        jTfTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTfTTActionPerformed(evt);
            }
        });

        jTfMaTV1.setBackground(new java.awt.Color(255, 255, 255));
        jTfMaTV1.setForeground(new java.awt.Color(51, 51, 51));
        jTfMaTV1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTfMaTV1ActionPerformed(evt);
            }
        });

        jTfNganh.setBackground(new java.awt.Color(255, 255, 255));
        jTfNganh.setForeground(new java.awt.Color(51, 51, 51));
        jTfNganh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTfNganhActionPerformed(evt);
            }
        });

        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Khoa");

        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Ngành");

        btnCheckIn.setBackground(new java.awt.Color(255, 255, 255));
        btnCheckIn.setForeground(new java.awt.Color(51, 51, 51));
        btnCheckIn.setText("Check in");
        btnCheckIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckInActionPerformed(evt);
            }
        });

        btnCheckIn1.setBackground(new java.awt.Color(255, 255, 255));
        btnCheckIn1.setForeground(new java.awt.Color(51, 51, 51));
        btnCheckIn1.setText("Quét QR");
        btnCheckIn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckIn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(btnCheckIn, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                        .addGap(32, 32, 32))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTfTT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                            .addComponent(jTfHoTen, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTfMaTV1, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE))))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(btnCheckIn1, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                        .addGap(182, 182, 182))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTfKhoa, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                            .addComponent(jTfNganh, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(88, 88, 88))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(12, 12, 12)
                        .addComponent(jTfMaTV1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTfHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTfKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTfNganh, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTfTT, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCheckIn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCheckIn1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jTfHoTen, jTfKhoa, jTfMaTV1, jTfNganh, jTfTT});

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 739, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 311, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane.addTab("Checkin", jPanel4);

        Hehe.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Mã thiết bị");

        jTfMaTB.setBackground(new java.awt.Color(255, 255, 255));
        jTfMaTB.setForeground(new java.awt.Color(51, 51, 51));
        jTfMaTB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTfMaTBActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Tên thiết bị");

        jTfTenTb.setEditable(false);
        jTfTenTb.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Tình trạng thiết bị");

        jTfTTTB.setEditable(false);
        jTfTTTB.setBackground(new java.awt.Color(255, 255, 255));
        jTfTTTB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTfTTTBActionPerformed(evt);
            }
        });

        btnCheckIn4.setBackground(new java.awt.Color(255, 255, 255));
        btnCheckIn4.setForeground(new java.awt.Color(51, 51, 51));
        btnCheckIn4.setText("Mượn");
        btnCheckIn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckIn4ActionPerformed(evt);
            }
        });

        btnCheckIn5.setBackground(new java.awt.Color(255, 255, 255));
        btnCheckIn5.setForeground(new java.awt.Color(51, 51, 51));
        btnCheckIn5.setText("Trả");
        btnCheckIn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckIn5ActionPerformed(evt);
            }
        });

        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Mã thành viên");

        jTfMaTV.setBackground(new java.awt.Color(255, 255, 255));
        jTfMaTV.setForeground(new java.awt.Color(51, 51, 51));
        jTfMaTV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTfMaTVActionPerformed(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Họ và tên");

        jTfHoTen1.setEditable(false);
        jTfHoTen1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Tình trạng thành viên");

        jTfTT1.setEditable(false);
        jTfTT1.setBackground(new java.awt.Color(255, 255, 255));
        jTfTT1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTfTT1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout HeheLayout = new javax.swing.GroupLayout(Hehe);
        Hehe.setLayout(HeheLayout);
        HeheLayout.setHorizontalGroup(
            HeheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeheLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(HeheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTfTT1)
                    .addComponent(jTfHoTen1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTfMaTV, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, HeheLayout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(btnCheckIn4, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                        .addGap(79, 79, 79)))
                .addGap(51, 51, 51)
                .addGroup(HeheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTfTTTB)
                    .addComponent(jTfTenTb)
                    .addComponent(jLabel10)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTfMaTB)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HeheLayout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(btnCheckIn5, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                        .addGap(79, 79, 79)))
                .addGap(31, 31, 31))
        );
        HeheLayout.setVerticalGroup(
            HeheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeheLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(HeheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(HeheLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTfMaTB, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTfTenTb, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTfTTTB, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(HeheLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTfMaTV, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTfHoTen1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTfTT1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(HeheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(HeheLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnCheckIn4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(HeheLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnCheckIn5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jTabbedPane.addTab("Mượn trả", Hehe);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanelResuil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(15, 15, 15))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelResuil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTfTT1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTfTT1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTfTT1ActionPerformed

    private void jTfMaTVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTfMaTVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTfMaTVActionPerformed

    private void btnCheckIn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckIn5ActionPerformed
        ThongTinSDBLL bLL=new ThongTinSDBLL();
        bLL.returnnDevice(Integer.parseInt(jTfMaTB.getText()));
    }//GEN-LAST:event_btnCheckIn5ActionPerformed

    private void btnCheckIn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckIn4ActionPerformed
        ThietBiBLL tbbll=new ThietBiBLL();
        ThongTinSDBLL ttsdbll=new ThongTinSDBLL();
        ThanhVienBLL tvbll=new ThanhVienBLL();
        //Kiểm tra thông tin thành viên
        int maTV=Integer.parseInt(jTfMaTV.getText());
        XuLyBLL xlbll =new XuLyBLL();
        if(!bLL.isCheckIn(maTV)){
            if(bLL.isMenber(maTV)){
                jTfMaTV.setText(bLL.getThanhVien(maTV).getMaTV()+"");
                jTfHoTen.setText(bLL.getThanhVien(maTV).getHoTen());
                jTfTT.setText(xlbll.getXuLyLasted(maTV).getHinhThucXL());
            }
        }
        else{
            jTfMaTV.setText(bLL.getThanhVien(maTV).getMaTV()+"");
            jTfHoTen.setText(bLL.getThanhVien(maTV).getHoTen());
            jTfTT.setText("Hoạt động");
            jTfMaTB.getText();
            jTfTenTb.setText(tbbll.getThietBi(Integer.parseInt(jTfMaTB.getText())).getTenTB());
            //kiểm tra thiết bị còn không
            if (ttsdbll.borrowedDevice(maTV, Integer.parseInt(jTfMaTB.getText()))) {
                jTfTTTB.setText("Còn");
                LoadDataBorrow();
            }else{
                jTfTTTB.setText("Hết");
            }

        }
    }//GEN-LAST:event_btnCheckIn4ActionPerformed

    private void jTfTTTBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTfTTTBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTfTTTBActionPerformed

    private void jTfMaTBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTfMaTBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTfMaTBActionPerformed

    private void btnCheckIn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckIn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCheckIn1ActionPerformed

    private void btnCheckInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckInActionPerformed
        int maTV=Integer.parseInt(jTfMaTV1.getText());
        XuLyBLL xlbll =new XuLyBLL();
        NotMenber temp=new NotMenber();
        ThongTinSDBLL ttsdbll=new ThongTinSDBLL();
        if(!bLL.isMenber(maTV)){
            temp.setVisible(true);
        }else if(!bLL.isCheckIn(maTV)){
                jTfMaTV1.setText(bLL.getThanhVien(maTV).getMaTV()+"");
                jTfHoTen.setText(bLL.getThanhVien(maTV).getHoTen());
                jTfKhoa.setText(bLL.getThanhVien(maTV).getKhoa());
                jTfNganh.setText(bLL.getThanhVien(maTV).getNganh());
                jTfTT.setText(xlbll.getXuLyLasted(maTV).getHinhThucXL());
                temp.setVisible(true);
        }
        else{
            jTfMaTV1.setText(bLL.getThanhVien(maTV).getMaTV()+"");
            jTfHoTen.setText(bLL.getThanhVien(maTV).getHoTen());
            jTfKhoa.setText(bLL.getThanhVien(maTV).getKhoa());
            jTfNganh.setText(bLL.getThanhVien(maTV).getNganh());
            jTfTT.setText("Hoạt động");
            ThongTinSD tt=new ThongTinSD();
            tt.setMaTV(bLL.getThanhVien(maTV));
            tt.setTGVao(LocalDateTime.now());
            ttsdbll.addThongTin(tt);      
        }
    }//GEN-LAST:event_btnCheckInActionPerformed

    private void jTfNganhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTfNganhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTfNganhActionPerformed

    private void jTfMaTV1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTfMaTV1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTfMaTV1ActionPerformed

    private void jTfTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTfTTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTfTTActionPerformed

    private void jTfKhoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTfKhoaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTfKhoaActionPerformed

    public TableModel moTable(){
        return jTableGanDay.getModel();
    }
    public void LoadDataBorrow() {
        DefaultTableModel model;
        ThongTinSDBLL thongTinSDBLL=new ThongTinSDBLL();
        ThanhVienBLL thanhVienBLL=new ThanhVienBLL();
        model = (DefaultTableModel) jTableGanDay.getModel();
        model.setRowCount(0);
        ArrayList<ThongTinSD> listBorrow = (ArrayList<ThongTinSD>) thongTinSDBLL.getThongTinSDbyID(Integer.parseInt(jTfMaTV.getText()));
        for (ThongTinSD on : listBorrow) {
                model.addRow(new Object[]{
                    jTfMaTV.getText(), thanhVienBLL.getThanhVien(Integer.parseInt(jTfMaTV.getText())).getHoTen(), on.getTGVao(), on.getMaTB(), on.getTGMuon(), on.getTGTra()
                });
           

            jTableGanDay.setModel(model);
        }
    }
    public void LoadDataMenber() {
        DefaultTableModel model;
        ThongTinSDBLL thongTinSDBLL=new ThongTinSDBLL();
        model = (DefaultTableModel) jTableGanDay.getModel();
        model.setRowCount(0);
        ThanhVienBLL thanhVienBLL=new ThanhVienBLL();
        ArrayList<ThongTinSD> listBorrow = (ArrayList<ThongTinSD>) thongTinSDBLL.loadThongTinSD();
        for (ThongTinSD on : listBorrow) {
                model.addRow(new Object[]{
                    on.getMaTV(),thanhVienBLL.getThanhVien(on.getMaTV()).getHoTen(), on.getTGVao(), on.getMaTB(), on.getTGMuon(), on.getTGTra()
                });
           

            jTableGanDay.setModel(model);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Hehe;
    private javax.swing.JButton btnCheckIn;
    private javax.swing.JButton btnCheckIn1;
    private javax.swing.JButton btnCheckIn4;
    private javax.swing.JButton btnCheckIn5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanelGanDay;
    private javax.swing.JPanel jPanelResuil;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JTable jTableGanDay;
    private javax.swing.JTextField jTfHoTen;
    private javax.swing.JTextField jTfHoTen1;
    private javax.swing.JTextField jTfKhoa;
    private javax.swing.JTextField jTfMaTB;
    private javax.swing.JTextField jTfMaTV;
    private javax.swing.JTextField jTfMaTV1;
    private javax.swing.JTextField jTfNganh;
    private javax.swing.JTextField jTfTT;
    private javax.swing.JTextField jTfTT1;
    private javax.swing.JTextField jTfTTTB;
    private javax.swing.JTextField jTfTenTb;
    // End of variables declaration//GEN-END:variables
}
