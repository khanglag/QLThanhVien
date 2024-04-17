/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package BLL;

import DAL.ThanhVien;
import DAL.ThanhVienDAL;
import DAL.ThongTinSD;
import DAL.ThongTinSdDAL;
import DAL.XuLy;
import DAL.XuLyDAL;
import GUI.Hander.chooseExcelFile;
import GUI.Home.MenberAccess;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author pc
 */
public class testcuadikhang {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws IOException {
       ThanhVienBLL bLL=new ThanhVienBLL();
       for(ThanhVien tv: bLL.readDataFromExcel()){
           System.out.println(tv.toString());
       };
    }
}
