/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.MenberManager;

import BLL.ThanhVienBLL;
import BLL.ThietBiBLL;
import BLL.ThongTinSDBLL;
import BLL.XuLyBLL;
import DAL.ThongTinSD;
import java.awt.BorderLayout;
import java.time.LocalDateTime;
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
        jPanel3 = new javax.swing.JPanel();
        btnCheckIn = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jTfMaTV = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTfHoTen = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTfTT = new javax.swing.JTextField();
        btnCheckIn4 = new javax.swing.JButton();
        btnCheckIn5 = new javax.swing.JButton();
        jTfTTTB = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jTfMaTB = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTfMaTb = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        setTTinhTrang1 = new javax.swing.JTextField();
        jPanelResuil = new javax.swing.JPanel();
        jPanelGanDay = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableGanDay = new javax.swing.JTable();

        setBackground(new java.awt.Color(223, 223, 223));
        setPreferredSize(new java.awt.Dimension(703, 700));

        jPanel1.setBackground(new java.awt.Color(36, 140, 190));

        jLabel4.setBackground(new java.awt.Color(36, 140, 190));
        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Checkin.png"))); // NOI18N
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
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 35, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Helvetica Neue", 0, 14), new java.awt.Color(51, 51, 51))); // NOI18N

        btnCheckIn.setBackground(new java.awt.Color(255, 255, 255));
        btnCheckIn.setForeground(new java.awt.Color(51, 51, 51));
        btnCheckIn.setText("Check in");
        btnCheckIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckInActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setForeground(new java.awt.Color(102, 102, 102));
        jButton3.setText("Quét QR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Mã thành viên");

        jTfMaTV.setBackground(new java.awt.Color(255, 255, 255));
        jTfMaTV.setForeground(new java.awt.Color(51, 51, 51));
        jTfMaTV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTfMaTVActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTfTT)
                    .addComponent(jLabel7)
                    .addComponent(jTfMaTV)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jTfHoTen)
                        .addGap(1, 1, 1))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTfMaTV, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTfHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTfTT, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jTfHoTen, jTfMaTV, jTfTT});

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

        jTfTTTB.setBackground(new java.awt.Color(255, 255, 255));
        jTfTTTB.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Mã thiết bị");

        jTfMaTB.setBackground(new java.awt.Color(255, 255, 255));
        jTfMaTB.setForeground(new java.awt.Color(51, 51, 51));
        jTfMaTB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTfMaTBActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Tên thiết bị");

        jTfMaTb.setEditable(false);
        jTfMaTb.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Tình trạng thiết bị");

        setTTinhTrang1.setEditable(false);
        setTTinhTrang1.setBackground(new java.awt.Color(255, 255, 255));
        setTTinhTrang1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setTTinhTrang1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jTfTTTBLayout = new javax.swing.GroupLayout(jTfTTTB);
        jTfTTTB.setLayout(jTfTTTBLayout);
        jTfTTTBLayout.setHorizontalGroup(
            jTfTTTBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jTfTTTBLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jTfTTTBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(setTTinhTrang1)
                    .addComponent(jLabel8)
                    .addComponent(jTfMaTB)
                    .addGroup(jTfTTTBLayout.createSequentialGroup()
                        .addComponent(jTfMaTb)
                        .addGap(1, 1, 1))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );
        jTfTTTBLayout.setVerticalGroup(
            jTfTTTBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jTfTTTBLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTfMaTB, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTfMaTb, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(setTTinhTrang1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnCheckIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(45, 45, 45)
                        .addComponent(btnCheckIn4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(45, 45, 45)
                        .addComponent(btnCheckIn5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(45, 45, 45)
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(50, 50, 50)
                        .addComponent(jTfTTTB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(50, 50, 50))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTfTTTB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCheckIn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCheckIn4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCheckIn5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28))
        );

        jPanelResuil.setBackground(new java.awt.Color(255, 255, 255));

        jPanelGanDay.setBackground(new java.awt.Color(255, 255, 255));
        jPanelGanDay.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gần đây", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Helvetica Neue", 0, 14), new java.awt.Color(51, 51, 51))); // NOI18N

        jTableGanDay.setBackground(new java.awt.Color(255, 255, 255));
        jTableGanDay.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
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
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanelGanDayLayout.setVerticalGroup(
            jPanelGanDayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGanDayLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
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
            .addGroup(jPanelResuilLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelGanDay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelResuil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(6, 6, 6)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public TableModel moTable(){
        return jTableGanDay.getModel();
    }
    private void jTfMaTVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTfMaTVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTfMaTVActionPerformed

    private void btnCheckInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckInActionPerformed
        int maTV=Integer.parseInt(jTfMaTV.getText());
        XuLyBLL xlbll =new XuLyBLL();
        ThongTinSDBLL ttsdbll=new ThongTinSDBLL();
        if(!bLL.isCheckIn(maTV)){
            JPanel nmJPanel=new NotMenber();
            jPanelResuil.removeAll();
            jPanelResuil.setLayout(new BorderLayout());
            jPanelResuil.add(nmJPanel);
            jPanelResuil.revalidate();
            jPanelResuil.repaint();
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
            ThongTinSD tt=new ThongTinSD();
            tt.setMaTV(bLL.getThanhVien(maTV));
            tt.setTGVao(LocalDateTime.now());
            ttsdbll.addThongTin(tt);      
        }
    }//GEN-LAST:event_btnCheckInActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTfTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTfTTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTfTTActionPerformed

    private void btnCheckIn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckIn4ActionPerformed
        ThietBiBLL tbbll=new ThietBiBLL();
        ThongTinSDBLL ttsdbll=new ThongTinSDBLL();
        ThanhVienBLL tvbll=new ThanhVienBLL();
        //Kiểm tra thông tin thành viên
        int maTV=Integer.parseInt(jTfMaTV.getText());
        XuLyBLL xlbll =new XuLyBLL();
        if(!bLL.isCheckIn(maTV)){
            JPanel nmJPanel=new NotMenber();
            jPanelResuil.removeAll();
            jPanelResuil.setLayout(new BorderLayout());
            jPanelResuil.add(nmJPanel);
            jPanelResuil.revalidate();
            jPanelResuil.repaint();
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
            ThongTinSD tt=new ThongTinSD();
            tt.setMaTV(bLL.getThanhVien(maTV));
            tt.setTGVao(LocalDateTime.now());
            //kiểm tra thiết bị còn không
            
            ttsdbll.addThongTin(tt);
        }
    }//GEN-LAST:event_btnCheckIn4ActionPerformed

    private void btnCheckIn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckIn5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCheckIn5ActionPerformed

    private void jTfMaTBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTfMaTBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTfMaTBActionPerformed

    private void setTTinhTrang1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setTTinhTrang1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_setTTinhTrang1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCheckIn;
    private javax.swing.JButton btnCheckIn4;
    private javax.swing.JButton btnCheckIn5;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanelGanDay;
    private javax.swing.JPanel jPanelResuil;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableGanDay;
    private javax.swing.JTextField jTfHoTen;
    private javax.swing.JTextField jTfMaTB;
    private javax.swing.JTextField jTfMaTV;
    private javax.swing.JTextField jTfMaTb;
    private javax.swing.JTextField jTfTT;
    private javax.swing.JPanel jTfTTTB;
    private javax.swing.JTextField setTTinhTrang1;
    // End of variables declaration//GEN-END:variables
}
