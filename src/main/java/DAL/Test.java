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
            
            // int maTV = thanhVienDAL.getMaTV(2147483647);
            
            // Khởi tạo đối tượng XuLyDAL
            XuLyDAL xuLyDAL = new XuLyDAL();
            
            // Tạo một đối tượng XuLy mới
            XuLy xuLy = new XuLy();
            xuLy.setMaTV(new ThanhVien(2147483647)); 
            xuLy.setHinhThucXL("Bồi thường mất tài sản");
            xuLy.setSoTien(500000);
            xuLy.setNgayXL(LocalDateTime.now());
            xuLy.setTrangThaiXL(0); 

            // Thêm đối tượng XuLy vào cơ sở dữ liệu
            xuLyDAL.addXuLy(xuLy);



            session.getTransaction().commit();
        } catch (Exception e) {
            // Xử lý ngoại lệ nếu có
            e.printStackTrace();
        }
    }
}
