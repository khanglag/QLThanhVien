/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.time.LocalDateTime;
import java.util.List;
import javax.transaction.Transactional;

import org.hibernate.Transaction;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author MSII
 */
@Transactional
public class ThongTinSdDAL {
    private Session session;

    public ThongTinSdDAL() {
        session = HibernateUtils.getSessionFactory().openSession();
    }

    public List<ThongTinSD> loadThongTinSD() {
        List<ThongTinSD> list = null;
        Transaction transaction = null;
        try {
            openSession();
            transaction = session.beginTransaction();
            list = session.createQuery("FROM ThongTinSD", ThongTinSD.class).list();
            transaction.commit();

        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
        }
        return list;
    }

    public ThongTinSD getThongTinSD(int MaTT) {
        Transaction transaction = null;
        ThongTinSD tt = null;
        try {
            openSession();
            transaction = session.beginTransaction();
            tt = session.get(ThongTinSD.class, MaTT);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
        }
        return tt;
    }

    // Tạo mã thông tin tự động
    public int generateMaTT() {
        int newMaXL = 0;
        Integer maXL = (Integer) session.createQuery("SELECT MAX(MaTT) FROM ThongTinSD").uniqueResult();
        if (maXL == null)
            newMaXL = 1;
        else
            newMaXL = maXL + 1;
        return newMaXL;
    }

    public void addThongTin(ThongTinSD tt) {
        Transaction transaction = null;
        try {
            openSession();
            transaction = session.beginTransaction();
            tt.setMaTT(generateMaTT());
            session.save(tt);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
        }
    }

    public void updateThongTin(ThongTinSD tt) {
        Transaction transaction = null;
        try {
            openSession();
            transaction = session.beginTransaction();
            session.update(tt);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
        }
    }

    public void deleteThongTIn(int MaTT) {
        Transaction transaction = null;
        try {
            openSession();
            transaction = session.beginTransaction();
            ThongTinSD del = session.get(ThongTinSD.class, MaTT);
            session.delete(del);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
        }
    }

    // Muợn thiết bị
    public void borrowedDevice(int MaTV, int MaTB) {
        int maTV = MaTV;
        Transaction transaction = null;
        try {
            openSession();
            transaction = session.beginTransaction();

            // Kiểm tra MaTV có trong bảng ThanhVien
            ThanhVien thanhVien = session.get(ThanhVien.class, MaTV);
            if (thanhVien == null)
                throw new RuntimeException("Member does not exist");

            // Kiểm tra thiết bị đã được cho mượn hay chưa
            ThongTinSD thongTinSD = (ThongTinSD) session
                    .createQuery("FROM ThongTinSD WHERE MaTB.id = :MaTB AND TGMuon IS NOT NULL AND TGTra IS NULL")
                    .setParameter("MaTB", MaTB)
                    .uniqueResult();
            if (thongTinSD != null)
                throw new RuntimeException("The device has been borrowed");

            // Thiết bị chưa cho mượn
            thongTinSD = (ThongTinSD) session.createQuery("FROM ThongTinSD WHERE MaTB.id = :MaTB AND TGTra IS NULL")
                    .setParameter("MaTB", MaTB)
                    .uniqueResult();
            if (thongTinSD != null) {
                thongTinSD.setTGMuon(LocalDateTime.now());
                session.update(thongTinSD);
                transaction.commit();
                return;
            }

            // Nếu thiết bị chưa có trong bảng ThongTinSD
            ThietBi thietBi = session.get(ThietBi.class, MaTB);
            // ThongTinSD thongTinMuon = new ThongTinSD();
            // thongTinMuon.setMaTT(generateMaTT());
            // thongTinMuon.setMaTV(thanhVien);
            // thongTinMuon.setMaTB(thietBi);
            // thongTinMuon.setTGVao(LocalDateTime.now());
            // thongTinMuon.setTGMuon(LocalDateTime.now());
            // session.save(thongTinMuon);
            // transaction.commit();
            thongTinSD = (ThongTinSD) session
                    .createQuery("FROM ThongTinSD WHERE maTV = :maTV ORDER BY MaTT DESC")
                    .setParameter("maTV", maTV)
                    .setMaxResults(1) // Chỉ lấy 1 kết quả (nếu có)
                    .uniqueResult();

            System.out.println(thongTinSD);
            if (thongTinSD != null) {
                // Cập nhật mã thiết bị
                thongTinSD.setMaTB(thietBi);
                // Sửa thời gian mượn
                thongTinSD.setTGMuon(LocalDateTime.now());

                // Lưu thay đổi vào cơ sở dữ liệu
                session.update(thongTinSD);
                transaction.commit();
                System.out.println("Đã sửa thông tin sử dụng thành công.");
            } else {
                System.out.println("Không tìm thấy thông tin sử dụng để sửa.");
            }

        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
        }
    }

    public void suaThongTinSD(int maTB, int maTV) {
        // Bắt đầu một transaction
        Transaction transaction = null;
        try {
            openSession();
            transaction = session.beginTransaction();

            // Lấy thông tin của Thiết bị từ cơ sở dữ liệu
            ThietBi thietBi = session.get(ThietBi.class, maTB);

            // Tìm Thông tin sử dụng cần sửa dựa trên maTV và maTB
            ThongTinSD thongTinSD = (ThongTinSD) session
                    .createQuery("FROM ThongTinSD WHERE maTV = :maTV ORDER BY maTT DESC")
                    .setParameter("maTV", maTV)
                    .setMaxResults(1) // Chỉ lấy 1 kết quả (nếu có)
                    .uniqueResult();

            System.out.println(thongTinSD);
            if (thongTinSD != null) {
                // Cập nhật mã thiết bị
                thongTinSD.setMaTB(thietBi);
                // Sửa thời gian mượn
                thongTinSD.setTGMuon(LocalDateTime.now());

                // Lưu thay đổi vào cơ sở dữ liệu
                session.update(thongTinSD);
                transaction.commit();
                System.out.println("Đã sửa thông tin sử dụng thành công.");
            } else {
                System.out.println("Không tìm thấy thông tin sử dụng để sửa.");
            }
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    private void openSession() {
        if (!session.isOpen())
            session = HibernateUtils.getSessionFactory().openSession();
    }

}
