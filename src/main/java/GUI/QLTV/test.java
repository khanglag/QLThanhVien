package GUI.QLTV;

import BLL.ThanhVienBLL;
import DAL.ThanhVien;
import GUI.MainFrame;
import javax.swing.*;

public class test {
    public static void main(String[] argv) {
        JFrame a = new JFrame();
        a.add(new QLThanhVien());
        a.setSize(200, 500);
        a.setVisible(true);
        // ThanhVienBLL a =new ThanhVienBLL();
        // ThanhVien b = new ThanhVien();
        // b.setHoTen("A");
        // b.setKhoa("CNTT");
        // b.setNganh("CNTT");
        // b.setSDT(85233);
        // a.addThanhVien(b, 20, 41);
        // ThanhVienBLL tvBLL = new ThanhVienBLL();
        // int choice = JOptionPane.showConfirmDialog(new MainFrame(), "Bạn có chắc chắn
        // muốn xoá?", "Xác nhận",
        // JOptionPane.YES_NO_OPTION);
        // if (choice == JOptionPane.YES_OPTION) {
        // // Perform delete operation
        // tvBLL.deleteThanhVien(1122410001);
        // }
    }
}
