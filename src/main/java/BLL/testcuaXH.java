/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.ThanhVien;
import DAL.ThongTinSD;
import DAL.XuLy;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author acer
 */
public class testcuaXH {

    public static void main(String[] args) {
//       ArrayList<ThanhVien> listtv = new ArrayList<ThanhVien>();
//       ThanhVienBLL tvBLL = new ThanhVienBLL();
//       listtv = (ArrayList<ThanhVien>) tvBLL.loadThanhVien();
//       for (ThanhVien on : listtv) {
//           System.out.println(on.getMaTV() + on.getHoTen() + on.getKhoa() + on.getNganh() + on.getSDT());
//       }
//        ArrayList<ThongTinSD> listtt = new ArrayList<ThongTinSD>();
//        ThongTinSDBLL ttBll = new ThongTinSDBLL();
//        listtt = (ArrayList<ThongTinSD>) ttBll.loadThongTin();
//
//        for (ThongTinSD on : listtt) {
//            System.out.println(on.getMaTT() +""+ on.getMaTV());
//        }
        System.out.println("-------------------------------");
          ArrayList<XuLy> listXL = new ArrayList<XuLy>();
          XuLyBLL xlBLL = new XuLyBLL();
           listXL = (ArrayList<XuLy>) xlBLL.loadXuLy();
           for(XuLy on : listXL){
                System.out.println(on.getMaTV());
           }
           

    }
}
