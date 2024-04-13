/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package BLL;

import DAL.ThanhVien;
import DAL.XuLy;
import DAL.XuLyDAL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pc
 */
public class testcuaDiKhang {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        XuLyDAL dAL=new XuLyDAL();
        dAL.searchXuLy(	2147483647);
//        int maMax=list.get(0).getMaXL();
//        LocalDateTime ngayMax=list.get(0).getNgayXL();
//        for(XuLy temp: list){
//            if(temp.getNgayXL().compareTo(ngayMax)<1)
//                maMax=temp.getMaXL();
//        }
//        XuLy temp =dAL.getXuLy(maMax);
//        int index=10;
//        String newStr = temp.getHinhThucXL().substring(0, index) + temp.getHinhThucXL().substring(index + 1);
//        if (newStr.equals("Khóa thẻ tháng")) {
//            System.out.println(newStr);
//        }
}
}
