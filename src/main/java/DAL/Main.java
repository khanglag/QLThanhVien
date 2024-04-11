package DAL;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            session.beginTransaction();
            ThongTinSdDAL thongTinSdDAL = new ThongTinSdDAL();

            // Tạo một đối tượng ThongTinSD mới
            ThongTinSD thongTinSD = new ThongTinSD();
            thongTinSD.setMaTV(new ThanhVien(2147483647));
            thongTinSD.setMaTB(new ThietBi(2000003));
            thongTinSD.setTGVao(LocalDateTime.now());
            thongTinSD.setTGMuon(LocalDateTime.now());
            thongTinSD.setTGTra(LocalDateTime.now().plusDays(7)); 

            thongTinSdDAL.addThongTin(thongTinSD);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
