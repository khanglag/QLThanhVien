package DAL;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;
import org.hibernate.Session;

public class Test {
    public static void main(String[] args) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            session.beginTransaction();
            ThanhVienDAL thanhVienDAL = new ThanhVienDAL();
            ThanhVien newMember = new ThanhVien();
            newMember.setHoTen("Nguyen Van A");
            newMember.setKhoa("CNTT");
            newMember.setNganh("Cong nghe thong tin");
            newMember.setSDT(23456789);
    
           
    
           
            thanhVienDAL.addThanhVien(newMember, 22,41);
           
            // thanhVienDAL.deleteByActiveYear(18,41);


            session.getTransaction().commit();
        } catch (Exception e) {
            // Xử lý ngoại lệ nếu có
            e.printStackTrace();
        }
    }
}
