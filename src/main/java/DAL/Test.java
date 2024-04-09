package DAL;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;
import org.hibernate.Session;

public class Test {
    public static void main(String[] args) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            session.beginTransaction();
            XuLy xuLy = new XuLy();
        
            // Thiết lập thông tin cho đối tượng XuLy
            ThanhVienDAL thanhVienDAL = new ThanhVienDAL();
            ThanhVien thanhVien = thanhVienDAL.getThanhVien(1121530087); // Giả sử có một thành viên có mã là 1 trong cơ sở dữ liệu
            xuLy.setMaTV(thanhVien);
            xuLy.setHinhThucXL("Xử lý hình thức 1");
            xuLy.setSoTien(1000);
            xuLy.setNgayXL(LocalDateTime.now());
            xuLy.setTrangThaiXL(1);
    
            // Tạo một đối tượng XuLyDAL
            XuLyDAL xuLyDAL = new XuLyDAL();
    
            // Thêm đối tượng XuLy vào cơ sở dữ liệu
            xuLyDAL.addXuLy(xuLy);
    


            session.getTransaction().commit();
        } catch (Exception e) {
            // Xử lý ngoại lệ nếu có
            e.printStackTrace();
        }
    }
}
