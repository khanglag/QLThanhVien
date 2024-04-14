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
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
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
        } finally {
            session.close();
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
            tt.MaTT(generateMaTT());
            session.save(tt);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
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
        } finally {
            session.close();
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
        } finally {
            session.close();
        }
    }

    // Muợn thiết bị
    public void borrowedDevice(int MaTT, int MaTV, int MaTB) {
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
            
            //Thiết bị chưa cho mượn
            thongTinSD = (ThongTinSD) session.createQuery("FROM ThongTinSD WHERE MaTB.id = :MaTB AND TGTra IS NULL")
                .setParameter("MaTV", MaTV)
                .setParameter("MaTB", MaTB)
                .uniqueResult();
            if (thongTinSD != null) {
                thongTinSD.setTGMuon(LocalDateTime.now());
                session.update(thongTinSD);
                transaction.commit();
                return;
            }
            
            //Nếu thiết bị chưa có trong bảng ThongTinSD
            ThietBi thietBi = session.get(ThietBi.class, MaTB);
            ThongTinSD thongTinMuon = new ThongTinSD();
            thongTinMuon.setMaTT(generateMaTT());
            thongTinMuon.setMaTV(thanhVien);
            thongTinMuon.setMaTB(thietBi);
            thongTinMuon.setTGVao(LocalDateTime.now());
            session.save(thongTinMuon);
            transaction.commit();
            
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    
    private void openSession() {
        if (!session.isOpen())
            session = HibernateUtils.getSessionFactory().openSession();
    }
    public Object[][] dataTableCheckin(TableModel model,int maTV){
        Transaction transaction = null;
        int rowCount = model.getRowCount();
        int columnCount = model.getColumnCount();
        Object[][] data = new Object[rowCount][columnCount];
        try {
            openSession();
            transaction = session.beginTransaction();
            String hql = "SELECT tv.MaTV, tv.HoTen, tsd.TGVao, tsd.MaTB " +
             "FROM ThanhVien tv " +
             "JOIN ThongTinSD tsd ON tv.MaTV = tsd.MaTV " +
             "WHERE tv.MaTV = :maTV";
            Query query = session.createQuery(hql);
            query.setParameter("maTV", maTV); 
            data=convertListToObjectArray(query.list());
        } catch (HibernateException e) {
//            if (transaction != null)
//                transaction.rollback();
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
        
        // Lặp qua danh sách và chuyển đổi từng phần tử thành hàng của mảng hai chiều mới
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
}
