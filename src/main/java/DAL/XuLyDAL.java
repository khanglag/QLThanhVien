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
public class XuLyDAL {
    private Session session;

    public XuLyDAL() {
        session = HibernateUtils.getSessionFactory().openSession();
    }

    public List<XuLy> loadXuLy() {
        List<XuLy> xuLyList = null;
        Transaction transaction = null;
        try {
            openSession();
            transaction = session.beginTransaction();
            xuLyList = session.createQuery("FROM XuLy", XuLy.class).list();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return xuLyList;
    }

    public XuLy getXuLy(int MaXL) {
        Transaction transaction = null;
        XuLy xuLy = null;
        try {
            openSession();
            transaction = session.beginTransaction();
            xuLy = session.get(XuLy.class, MaXL);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return xuLy;
    }

    public void addXuLy(XuLy xuLy) {
        Transaction transaction = null;
        try {
            openSession();
            transaction = session.beginTransaction();
            session.save(xuLy);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void updateXuLy(XuLy xuLy) {
        Transaction transaction = null;
        try {
            openSession();
            transaction = session.beginTransaction();
            session.update(xuLy);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void deleteXuLy(int MaXL) {
        Transaction transaction = null;
        try {
            openSession();
            transaction = session.beginTransaction();
            XuLy del = session.get(XuLy.class, MaXL);
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

    public List<XuLy> searchXuLy(ThanhVien MaTV) {
        Transaction transaction = null;
        List<XuLy> list = null;
        try {
            openSession();
            transaction = session.beginTransaction();
            String hql = "FROM XuLy WHERE MaTV = :MaTV";
            list = session.createQuery(hql, XuLy.class)
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

    public List<XuLy> searchXuLy(String HinhThucXL) {
        Transaction transaction = null;
        List<XuLy> list = null;
        try {
            openSession();
            transaction = session.beginTransaction();
            String hql = "FROM XuLy WHERE HinhThucXL LIKE :HinhThucXL";
            list = session.createQuery(hql, XuLy.class)
                    .setParameter("HinhThucXL", "%" + HinhThucXL + "%")
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

    // public List<XuLy> searchXuLy(LocalDateTime ngayXL) {
    // Transaction transaction = null;
    // List<XuLy> list = null;
    // try {
    // transaction = session.beginTransaction();
    // String hql = "FROM XuLy WHERE NgayXL LIKE :ngayXL";
    // list = session.createQuery(hql, XuLy.class)
    // .setParameter("ngayXL", "%" + ngayXL + "%")
    // .list();
    // transaction.commit();
    // } catch (HibernateException e) {
    // if (transaction != null)
    // transaction.rollback();
    // e.printStackTrace();
    // } finally {
    // session.close();
    // }
    // return list;
    // }

}
