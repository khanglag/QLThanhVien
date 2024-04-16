/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package BLL;

import DAL.ThanhVien;
import DAL.ThanhVienDAL;
import DAL.ThongTinSdDAL;
import DAL.XuLy;
import DAL.XuLyDAL;
import GUI.Home.MenberAccess;
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
    public static void main(String args[]) {
        ThanhVienDAL dAL=new ThanhVienDAL();
        for (Object[] row : dAL.getDataForMaTV(312141025)) {
        // Duyệt qua từng phần tử của hàng
        for (Object value : row) {
            System.out.print(value + "\t"); // In ra giá trị của từng phần tử
        }
        System.out.println(); // Xuống dòng sau khi in xong một hàng
    }  
    }
}
