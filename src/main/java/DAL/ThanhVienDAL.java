/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;



import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

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

    public void addThanhVien(ThanhVien tv) {
        Transaction transaction = null;
        try {
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

    public List<ThanhVien> searchThanhVien(int MaTV) {
        Transaction transaction = null;
        List<ThanhVien> list = null;
        try {
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
    
}
