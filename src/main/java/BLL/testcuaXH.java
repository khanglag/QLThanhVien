/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.ThanhVien;
import DAL.ThietBi;
import DAL.ThongTinSD;
import DAL.XuLy;
import java.util.ArrayList;
import java.util.List;
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
        // ArrayList<ThongTinSD> listtt = new ArrayList<ThongTinSD>();
        // ThongTinSDBLL ttBll = new ThongTinSDBLL();
        // listtt = (ArrayList<ThongTinSD>) ttBll.loadThongTinSD();

        // for (ThongTinSD on : listtt) {
        //     System.out.println(on.getMaTT() +"  "+ on.getMaTV() + " " + on.getMaTB());
        // }
//        System.out.println("-------------------------------");
//          ArrayList<XuLy> listXL = new ArrayList<XuLy>();
//          XuLyBLL xlBLL = new XuLyBLL();
//           listXL = (ArrayList<XuLy>) xlBLL.loadXuLy();
//           for(XuLy on : listXL){
//                System.out.println(on.getMaTV());
//           }
//           ThietBiBLL tbBLL = new ThietBiBLL();
//           
//            List<ThietBi> listTB = new ArrayList<>(); 
//            listTB =tbBLL.search(1000001);
//              for(ThietBi on : listTB){
//                System.out.println(on.getTenTB());
//           }
  ThanhVienBLL tvBLL = new ThanhVienBLL();
             ArrayList<ThanhVien> listKhoa = new ArrayList<ThanhVien>();
        listKhoa = (ArrayList<ThanhVien>) tvBLL.loadThanhVien();  
        ArrayList<String> itemsAdded = new ArrayList<>();
        for (ThanhVien on : listKhoa) {
            String item = on.getKhoa();
            System.out.println(item);
            if (!itemsAdded.contains(item)) {
                itemsAdded.add(item); 
                
            }
        }
    
            
    }
}
