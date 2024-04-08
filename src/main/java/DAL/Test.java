package DAL;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;
import org.hibernate.Session;

public class Test {
    public static void main(String[] args) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            ThanhVienDAL thanhVienDAL = new ThanhVienDAL();
            session.beginTransaction();

            ThanhVien tv = new ThanhVien(1120150187,"Trần Thị ","GDTH","GDTH",null);  
            ThanhVien tv1 = new ThanhVien(1120150186,"Trần  ","GDTH","GDTH",null);

            // thanhVienDAL.addThanhVien(tv); 
            // thanhVienDAL.addThanhVien(tv1);  
            thanhVienDAL.deleteByActiveYear(20);

            session.getTransaction().commit();
        } catch (Exception e) {
            // Xử lý ngoại lệ nếu có
            e.printStackTrace();
        }
    }
}
