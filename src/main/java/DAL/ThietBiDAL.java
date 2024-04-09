/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author MSII
 */
public class ThietBiDAL {
    private Session session;

    public ThietBiDAL() {
        session = HibernateUtils.getSessionFactory().openSession();
    }

    public List<ThietBi> loadThietBi() {
        List<ThietBi> thietBiList = null;
        Transaction transaction = null;
        try {
            openSession();
            transaction = session.beginTransaction();
            thietBiList = session.createQuery("FROM ThietBi", ThietBi.class).list();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return thietBiList;
    }

    public ThietBi getThietBi(int MaTB) {
        Transaction transaction = null;
        ThietBi tb = null;
        try {
            openSession();
            transaction = session.beginTransaction();
            tb = session.get(ThietBi.class, MaTB);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return tb;
    }

    public void addThietBi(ThietBi tb) {
        Transaction transaction = null;
        try {
            openSession();
            transaction = session.beginTransaction();
            session.save(tb);
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

    public void updateThietBi(ThietBi tb) {
        Transaction transaction = null;
        try {
            openSession();
            transaction = session.beginTransaction();
            session.update(tb);
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

    public void deleteThietBi(int MaTB) {
        Transaction transaction = null;
        ThietBi del = session.get(ThietBi.class, MaTB);
        try {
            openSession();
            transaction = session.beginTransaction();
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

    public List<ThietBi> searchThietBi(int MaTB) {
        Transaction transaction = null;
        List<ThietBi> list = null;
        try {
            openSession();
            transaction = session.beginTransaction();
            String hql = "FROM ThietBi WHERE MaTB = :MaTB";
            list = session.createQuery(hql, ThietBi.class)
                    .setParameter("MaTB", MaTB)
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

    public List<ThietBi> searchThietBi(String TenTB) {
        Transaction transaction = null;
        List<ThietBi> list = null;
        try {
            openSession();
            transaction = session.beginTransaction();
            String hql = "FROM ThietBi WHERE TenTB LIKE :TenTB";
            list = session.createQuery(hql, ThietBi.class)
                    .setParameter("TenTB", "%" + TenTB + "%")
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
