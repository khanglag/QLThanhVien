/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.time.LocalDateTime;
import java.util.List;
import javax.swing.table.TableModel;
import javax.transaction.Transactional;

import org.hibernate.Transaction;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

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
            if (transaction != null) {
                transaction.rollback();
            }
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
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return tt;
    }

    // Tạo mã thông tin tự động
    public int generateMaTT() {
        int newMaXL = 0;
        Integer maXL = (Integer) session.createQuery("SELECT MAX(MaTT) FROM ThongTinSD").uniqueResult();
        if (maXL == null) {
            newMaXL = 1;
        } else {
            newMaXL = maXL + 1;
        }
        return newMaXL;
    }
    public long demThietBiDangMuon() {
        return (long) session.createQuery("SELECT COUNT(*) FROM ThongTinSD WHERE TGTra IS NULL").uniqueResult();
    }
    public long demSoLanMuonThietBi() {
        return (long) session.createQuery("SELECT COUNT(*) FROM ThongTinSD").uniqueResult();
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
            if (transaction != null) {
                transaction.rollback();
            }
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
            if (transaction != null) {
                transaction.rollback();
            }
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
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Object[]> getThongTinSDWithDetails() {
        Transaction transaction = null;
        List<Object[]> list = null;
        try {
            transaction = session.beginTransaction();
            String hql = "SELECT tsd.MaTT, tv.MaTV, tv.HoTen,tb.MaTB, tb.TenTB, tsd.TGVao, tsd.TGMuon, tsd.TGTra "
                    + "FROM ThongTinSD tsd "
                    + "LEFT JOIN ThanhVien tv ON tsd.MaTV = tv.MaTV "
                    + "LEFT JOIN ThietBi tb ON tsd.MaTB = tb.MaTB";
            list = session.createQuery(hql).list();
            transaction.commit(); // Commit transaction after query execution
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } 
        return list;
    }
    public List<Object[]> getThongTinSDWithDetailsMember() {
        Transaction transaction = null;
        List<Object[]> list = null;
        try {
            transaction = session.beginTransaction();
           String hql = "SELECT tsd.MaTT, tv.MaTV,  tv.HoTen, tv.Khoa, tv.Nganh, tv.SDT, tsd.TGVao "
                    + "FROM ThongTinSD tsd "
                    + "LEFT JOIN ThanhVien tv ON tsd.MaTV = tv.MaTV ";       
            list = session.createQuery(hql).list();
            transaction.commit(); // Commit transaction after query execution
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } 
        return list;
    }

    public boolean borrowedDevice(int MaTV, int MaTB) {
        Transaction transaction = null;
        try {
            openSession();
            transaction = session.beginTransaction();

            // Kiểm tra xem MaTV có trong bảng ThanhVien không
            ThanhVien thanhVien = session.get(ThanhVien.class, MaTV);
            if (thanhVien == null) {
                throw new RuntimeException("Thành viên không tồn tại");
            }

            // Kiểm tra xem thiết bị đã được mượn hay chưa
            ThongTinSD thongTinSD = (ThongTinSD) session.createQuery(
                            "FROM ThongTinSD WHERE MaTB.id = :MaTB AND TGMuon IS NOT NULL AND TGTra IS NULL")
                    .setParameter("MaTB", MaTB)
                    .uniqueResult();
            if (thongTinSD != null) {
                throw new RuntimeException("Thiết bị đã được mượn");
            }

            // Lấy thông tin sử dụng của thiết bị chưa được mượn
            thongTinSD = (ThongTinSD) session.createQuery(
                            "FROM ThongTinSD WHERE MaTB.id = :MaTB AND TGTra IS NULL")
                    .setParameter("MaTB", MaTB)
                    .uniqueResult();

            // Nếu thiết bị chưa được mượn, cập nhật thông tin mượn
            if (thongTinSD != null) {
                thongTinSD.setTGMuon(LocalDateTime.now());
                thongTinSD.setMaTV(thanhVien); // Cập nhật mã thành viên
                session.update(thongTinSD);
                transaction.commit();
                return true;
            }

            // Nếu thiết bị chưa có trong bảng ThongTinSD
            ThietBi thietBi = session.get(ThietBi.class, MaTB);
            thongTinSD = new ThongTinSD();
            thongTinSD.setMaTV(thanhVien);
            thongTinSD.setMaTB(thietBi);
            thongTinSD.setTGVao(LocalDateTime.now());
            thongTinSD.setTGMuon(LocalDateTime.now());
            session.save(thongTinSD);
            transaction.commit();
            return true;

        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }


    public void returnDevice(int MaTB) {
        // Mở session và bắt đầu transaction
        Transaction transaction = null;

        try {
            openSession();
            transaction = session.beginTransaction();

            ThongTinSD thongTinSD = (ThongTinSD) session
                    // .createQuery("FROM ThongTinSD WHERE MaTB = :MaTB AND TGTra IS NULL")
                    .createQuery("FROM ThongTinSD WHERE MaTB.id = :MaTB AND TGTra IS NULL")
                    .setParameter("MaTB", MaTB)
                    .uniqueResult();
            System.out.println(thongTinSD);
            if (thongTinSD != null) {
                thongTinSD.setTGTra(LocalDateTime.now());
                session.update(thongTinSD);
                transaction.commit();
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
        if (!session.isOpen()) {
            session = HibernateUtils.getSessionFactory().openSession();
        }
    }

    public Object[][] dataTableCheckin(TableModel model, int maTV) {
        Transaction transaction = null;
        int rowCount = model.getRowCount();
        int columnCount = model.getColumnCount();
        Object[][] data = new Object[rowCount][columnCount];
        try {
            openSession();
            transaction = session.beginTransaction();
            String hql = "SELECT tv.MaTV, tv.HoTen, tsd.TGVao, tsd.MaTB "
                    + "FROM ThanhVien tv "
                    + "JOIN ThongTinSD tsd ON tv.MaTV = tsd.MaTV "
                    + "WHERE tv.MaTV = :maTV";
            Query query = session.createQuery(hql);
            query.setParameter("maTV", maTV);
            data = convertListToObjectArray(query.list());
        } catch (HibernateException e) {
            // if (transaction != null)
            // transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return data;
    }

    public static Object[][] convertListToObjectArray(List<Object> list) {
        int rowCount = list.size();
        int columnCount = 0;

        // Xác định số lượng cột bằng cách tìm cột lớn nhất trong danh sách
        for (Object obj : list) {
            if (obj instanceof Object[]) {
                int currentRowColumnCount = ((Object[]) obj).length;
                if (currentRowColumnCount > columnCount) {
                    columnCount = currentRowColumnCount;
                }
            }
        }

        // Tạo mảng hai chiều mới
        Object[][] array2D = new Object[rowCount][columnCount];

        // Lặp qua danh sách và chuyển đổi từng phần tử thành hàng của mảng hai chiều
        // mới
        for (int i = 0; i < rowCount; i++) {
            Object obj = list.get(i);
            if (obj instanceof Object[]) {
                Object[] row = (Object[]) obj;
                for (int j = 0; j < row.length; j++) {
                    array2D[i][j] = row[j];
                }
            } else {
                array2D[i][0] = obj;
            }
        }

        return array2D;
    }

    public List<ThongTinSD> loadThongTinSDByMaTV(int maTV) {
        Transaction transaction = null;
        List<ThongTinSD> thongTinSDList = null;
        try {
            openSession();
            transaction = session.beginTransaction();
            String hql = "FROM ThongTinSD WHERE MaTV.MaTV = :maTV";
            Query<ThongTinSD> query = session.createQuery(hql, ThongTinSD.class);
            query.setParameter("maTV", maTV);
            thongTinSDList = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return thongTinSDList;
    }

}
