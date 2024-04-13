/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import org.hibernate.Session;
import java.util.*;
/**
 *
 * @author khang
 */
public class t {
    public static void main(String[] args) {
            
       try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            session.beginTransaction();
            // ThanhVienDAL thanhVienDAL = new ThanhVienDAL();
            
            // ThanhVien newMember = new ThanhVien();
            // newMember.setHoTen("Nguyen Van A");
            // newMember.setKhoa("CNTT");
            // newMember.setNganh("Cong nghe thong tin");
            // newMember.setSDT(23456789);
           
            // thanhVienDAL.addThanhVien(newMember, 22,41);
           
            // thanhVienDAL.deleteByActiveYear(18,41);

            // XuLyDAL dal = new XuLyDAL();
            // List<XuLy> list= dal.loadXuLy();
            // for(XuLy xuLy : list)
            // System.out.println(xuLy);

            // ThongTinSdDAL dal = new ThongTinSdDAL();
            // List<ThongTinSD> list= dal.loadThongTinSD();
            // for(ThongTinSD sd : list) 
            //     System.out.println(sd);
            XuLyDAL dal = new XuLyDAL();
            for(XuLy xl : dal.searchXuLy(1121530087))
                System.out.println(xl);
            session.getTransaction().commit();
        } catch (Exception e) {
            // Xử lý ngoại lệ nếu có
            e.printStackTrace();
        }
}
}