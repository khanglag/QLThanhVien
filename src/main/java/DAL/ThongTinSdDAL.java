/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

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
    //Tạo mã thông tin tự động
    public int generateMaTT() {
        int newMaXL = 0;
        Integer maXL = (Integer) session.createQuery("SELECT MAX(MaTT) FROM ThongTinSD").uniqueResult();
        if(maXL == null)
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

    private void openSession() {
        if (!session.isOpen())
            session = HibernateUtils.getSessionFactory().openSession();
    }

}
