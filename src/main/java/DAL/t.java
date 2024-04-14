/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.time.LocalDateTime;
import org.hibernate.Session;

/**
 *
 * @author khang
 */
public class t {
    public static void main(String[] args) {

        // try (Session session = HibernateUtils.getSessionFactory().openSession()) {
        // session.beginTransaction();
        // ThanhVienDAL thanhVienDAL = new ThanhVienDAL();

        // ThanhVien newMember = new ThanhVien();
        // newMember.setHoTen("Nguyen Van A");
        // newMember.setKhoa("CNTT");
        // newMember.setNganh("Cong nghe thong tin");
        // newMember.setSDT(23456789);

        // thanhVienDAL.addThanhVien(newMember, 22, 41);

        // thanhVienDAL.deleteByActiveYear(18,41);

        // // ThanhVien newMember = new ThanhVien();
        // // newMember.setHoTen("Nguyen Van A");
        // // newMember.setKhoa("CNTT");
        // // newMember.setNganh("Cong nghe thong tin");
        // // newMember.setSDT(23456789);

        // ThongTinSdDAL dal = new ThongTinSdDAL();
        // // List<ThongTinSD> list= dal.loadThongTinSD();
        // // for(ThongTinSD sd : list)
        // // System.out.println(sd);
        // // XuLyDAL dal = new XuLyDAL();
        // // for(XuLy xl : dal.searchXuLy(1121530087))
        // // System.out.println(xl);
        // session.getTransaction().commit();
        // } catch (Exception e) {
        // // Xử lý ngoại lệ nếu có
        // e.printStackTrace();
        // }
        ThongTinSdDAL dal = new ThongTinSdDAL();
        // dal.suaThongTinSD(1000003, 1123330257);
        dal.borrowedDevice(1123330257, 1000003, LocalDateTime.now());
    }

}