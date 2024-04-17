/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.ThanhVien;
import java.io.IOException;

/**
 *
 * @author pc
 */
public class Testbeo {
    public static void main(String[] args) throws IOException {
       ThanhVienBLL bLL=new ThanhVienBLL();
       for(ThanhVien tv: bLL.readDataFromExcel()){
           System.out.println(tv.toString());
       };
    }
}
