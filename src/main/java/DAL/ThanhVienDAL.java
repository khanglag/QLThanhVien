/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

/**
 *
 * @author MSII
 */
public class ThanhVienDAL {
    private Session session;

    public ThanhVienDAL() {
        session = HibernateUtils.getSessionFactory().openSession();
    }

    public List<ThanhVien> loadThanhVien() {
        List<ThanhVien> l = null;
        Transaction transaction = null;
        try {
            openSession();
            transaction = session.beginTransaction();
            l = session.createQuery("FROM ThanhVien", ThanhVien.class).list();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();

        } finally {
            session.close();
        }
        return l;
    }

    public ThanhVien getThanhVien(int MaTV) {
        Transaction transaction = null;
        ThanhVien tv = null;
        try {
            openSession();
            transaction = session.beginTransaction();
            tv = session.get(ThanhVien.class, MaTV);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return tv;
    }

    // Mã thành viên theo năm và khoa
    public int generateMaTV(int nam, int khoa) {
        String getYear = String.valueOf(nam);
        String khoaString = String.valueOf(khoa);

        List<Integer> existMaTV = session.createQuery(
                "SELECT MaTV FROM ThanhVien WHERE SUBSTRING(MaTV, 3, 2) = :Year AND SUBSTRING(MaTV, 5, 2) = :Khoa",
                Integer.class)
                .setParameter("Year", getYear)
                .setParameter("Khoa", khoaString)
                .list();

        if (existMaTV.isEmpty())
            return Integer.parseInt("11" + getYear + khoaString + "0001");
        else {
            int lastMaTV = existMaTV.get(existMaTV.size() - 1);
            int lastNumber = lastMaTV % 10000;
            int newLastNumber = lastNumber + 1;
            String newMaTV = String.format("%04d", newLastNumber);
            return Integer.parseInt("11" + getYear + khoaString + newMaTV);
        }
    }

    public void addThanhVien(ThanhVien tv) {
        Transaction transaction = null;
        try {
            openSession();
            transaction = session.beginTransaction();
            session.save(tv);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();

        } finally {
            session.close();
        }
    }

    // Thêm thành viên với theo Khoa
    public void addThanhVien(ThanhVien tv, int nam, int khoa) {
        Transaction transaction = null;
        try {
            openSession();
            int maTV = generateMaTV(nam, khoa);
            tv.setMaTV(maTV);

            transaction = session.beginTransaction();
            session.save(tv);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void updateThanhVien(ThanhVien tv) {
        Transaction transaction = null;
        try {
            openSession();
            transaction = session.beginTransaction();
            session.update(tv);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();

            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void deleteThanhVien(int MaTV) {
        Transaction transaction = null;
        try {
            openSession();
            transaction = session.beginTransaction();
            ThanhVien del = session.get(ThanhVien.class, MaTV);
            session.delete(del);
            transaction.commit();

        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    // Xóa thành viên theo điều kiện năm kích hoạt thành viên
    public void deleteByActiveYear(int Year) {
        Transaction transaction = null;
        try {
            openSession();
            transaction = session.beginTransaction();
            @SuppressWarnings("unchecked")
            List<ThanhVien> thanhViens = session.createQuery("FROM ThanhVien WHERE SUBSTRING(MaTV, 3, 2) = :Year")
                    .setParameter("Year", String.valueOf(Year))
                    .list();
            for (ThanhVien tv : thanhViens)
                session.delete(tv);
            transaction.commit();

        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public List<ThanhVien> searchThanhVien(int MaTV) {
        Transaction transaction = null;
        List<ThanhVien> list = null;
        try {
            openSession();
            transaction = session.beginTransaction();
            String hql = "FROM ThanhVien WHERE MaTV = :MaTV";
            list = session.createQuery(hql, ThanhVien.class)
                    .setParameter("MaTV", MaTV)
                    .list();
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

    public List<ThanhVien> searchByHoTen(String hoTen) {
        Transaction transaction = null;
        List<ThanhVien> list = null;
        try {
            openSession();
            transaction = session.beginTransaction();
            String hql = "FROM ThanhVien WHERE HoTen LIKE:hoTen ";
            list = session.createQuery(hql, ThanhVien.class)
                    .setParameter("hoTen", "%" + hoTen + "%")
                    .list();
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

    public List<ThanhVien> searchByKhoa(String khoa) {
        Transaction transaction = null;
        List<ThanhVien> list = null;
        try {
            openSession();
            transaction = session.beginTransaction();
            String hql = "FROM ThanhVien WHERE Khoa LIKE:khoa ";
            list = session.createQuery(hql, ThanhVien.class)
                    .setParameter("khoa", "%" + khoa + "%")
                    .list();
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

    public List<ThanhVien> searchByNganh(String nganh) {
        Transaction transaction = null;
        List<ThanhVien> list = null;
        try {
            openSession();
            transaction = session.beginTransaction();
            String hql = "FROM ThanhVien WHERE Nganh LIKE:nganh ";
            list = session.createQuery(hql, ThanhVien.class)
                    .setParameter("nganh", "%" + nganh + "%")
                    .list();
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

    
    private void openSession() {
        if (!session.isOpen())
            session = HibernateUtils.getSessionFactory().openSession();
    }
}
