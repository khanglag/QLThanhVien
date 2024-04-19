/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.ThanhVien;
import DAL.ThongTinSD;
import DAL.XuLy;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author acer
 */
public class testcuaXH {

    public static void main(String[] args) {
        ThongTinSDBLL thongTinSDBLL = new ThongTinSDBLL();
        List<Object[]> thongTinSDList = thongTinSDBLL.getThongTinSDWithDetailsMember(); // Gọi hàm từ BLL để lấy dữ liệu

// In ra dữ liệu
        for (Object[] thongTinSD : thongTinSDList) {
            int maTT = (int) thongTinSD[0];
            int maTV = (int) thongTinSD[1];
             
            String hoTenThanhVien = (String) thongTinSD[2];
           String khoa = (String) thongTinSD[3];
           String nganh = (String) thongTinSD[4];
            int sdt = (int) thongTinSD[5];
            LocalDateTime tgVao = thongTinSD[6] != null ? (LocalDateTime) thongTinSD[6] : null;
           System.out.println("MaTT: " + maTT + ", MaTV: " + maTV + " HoTen: " + hoTenThanhVien +
            ", Khoa: " + khoa + ", Nganh: " + nganh + ", SDT: " + sdt + ", TGVao: " + tgVao);

        }

    }
}
