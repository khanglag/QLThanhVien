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
        }
        return tb;
    }

    // Tạo mã thiết bị theo mã quy định
    public int generateMaTB(int loaiTB) {
        String tbString = String.valueOf(loaiTB);
        List<Integer> existTB = session
                .createQuery("SELECT MaTB FROM ThietBi WHERE SUBSTRING(MaTB,1,1)= : loaiTB", Integer.class)
                .setParameter("loaiTB", tbString)
                .list();
        if (existTB.isEmpty())
            return Integer.parseInt(tbString + "000001");
        else {
            int lastMaTB = existTB.get(existTB.size() - 1);
            int lastNumber = lastMaTB % 1000000;
            int newLastNumber = lastNumber + 1;
            String newMaTB = String.format("%06d", newLastNumber);
            return Integer.parseInt(tbString + newMaTB);
        }
    }

    // Thêm thiết bị theo mã quy định
    public void addThietBi(ThietBi tb, int loaiTB) {
        Transaction transaction = null;
        try {
            openSession();
            int maTB = generateMaTB(loaiTB);
            tb.setMaTB(maTB);

            transaction = session.beginTransaction();
            session.save(tb);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
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
        }
    }

    // Xóa nhiều thiết bị theo mã quy định
    @SuppressWarnings("unchecked")
    public void deleteByRegula(int MaQD) {
        Transaction transaction = null;
        try {
            openSession();
            transaction = session.beginTransaction();
            List<ThietBi> thietBis = session.createQuery("FROM ThietBi WHERE SUBSTRING(MaTB,1,1)= : MaQD")
                    .setParameter("MaQD", String.valueOf(MaQD))
                    .list();
            for (ThietBi tb : thietBis) {
                session.delete(tb);
            }
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();

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
        }
        return list;
    }

    private void openSession() {
        if (!session.isOpen())
            session = HibernateUtils.getSessionFactory().openSession();
    }
}
