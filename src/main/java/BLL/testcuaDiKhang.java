/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package BLL;

import DAL.ThanhVien;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class testcuaDiKhang {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
          ArrayList<ThanhVien> list = new ArrayList<ThanhVien>();
    ThanhVienBLL tvBLL = new ThanhVienBLL();
          list = (ArrayList<ThanhVien>) tvBLL.loadThanhVien();
             for (ThanhVien on : list) {    
                  System.out.println(on.toString()); 
        }
    }
}
