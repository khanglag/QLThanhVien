/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.ThanhVien;
import DAL.ThongTinSD;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author acer
 */
public class testcuaXH {

    public static void main(String[] args) {
    //    ArrayList<ThanhVien> listtv = new ArrayList<ThanhVien>();
    //    ThanhVienBLL tvBLL = new ThanhVienBLL();
    //    listtv = (ArrayList<ThanhVien>) tvBLL.loadThanhVien();
    //    for (ThanhVien on : listtv) {
    //        System.out.println(on.getMaTV() + on.getHoTen() + on.getKhoa() + on.getNganh() + on.getSDT());
    //    }
        ArrayList<ThongTinSD> listtt = new ArrayList<ThongTinSD>();
        ThongTinSDBLL ttBll = new ThongTinSDBLL();
        listtt = (ArrayList<ThongTinSD>) ttBll.loadThongTinSD();

        for (ThongTinSD on : listtt) {
            System.out.println(on);
        }
    }
}
