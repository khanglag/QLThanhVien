package DAL;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;
import org.hibernate.Session;

public class Test {
    public static void main(String[] args) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            session.beginTransaction();
            ThongTinSdDAL dal = new ThongTinSdDAL();
            int MaTT = 1;
            int MaTV =1120150184;
            int MaTB =2000005;

            dal.borrowedDevice(MaTT, MaTV, MaTB);

            session.getTransaction().commit();
        } catch (Exception e) {
            // Xử lý ngoại lệ nếu có
            e.printStackTrace();
        }
    }
}
