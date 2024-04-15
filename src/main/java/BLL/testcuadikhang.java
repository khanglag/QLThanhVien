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
import GUI.MenberManager.MenberAccess;
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
        ThongTinSdDAL dAL=new ThongTinSdDAL();
        MenberAccess a=new MenberAccess();
        for (Object[] row : dAL.dataTableCheckin(a.moTable(),1120150184)) {
            // Duyệt qua từng phần tử trong hàng
            for (Object element : row) {
            
                // In ra giá trị của từng phần tử
                System.out.print(element + "\t");
            }
            // In ra dấu xuống dòng sau mỗi hàng
            System.out.println("1");
        }
        
       
    }
}
