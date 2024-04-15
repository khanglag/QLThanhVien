/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.time.LocalDateTime;
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
        }
        return xuLy;
    }

    // Tạo mã tự động
    public int generateMaXXL() {
        int newMaXL = 0;
        Integer maXL = (Integer) session.createQuery("SELECT MAX(MaXL) FROM XuLy").uniqueResult();
        if (maXL == null)
            newMaXL = 1;
        else
            newMaXL = maXL + 1;
        return newMaXL;
    }

    public void addXuLy(XuLy xuLy) {
        Transaction transaction = null;
        try {
            openSession();
            transaction = session.beginTransaction();
            xuLy.setMaXL(generateMaXXL());
            session.save(xuLy);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
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
        }
    }

    public List<XuLy> searchXuLy(int MaTV) {
        Transaction transaction = null;
        List<XuLy> list = null;
        try {
            openSession();
            transaction = session.beginTransaction();
            String hql = "FROM XuLy xl WHERE xl.MaTV.MaTV = :MaTV";
            list = session.createQuery(hql, XuLy.class)
                    .setParameter("MaTV", MaTV)
                    .list();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
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
        }
        return list;
    }
    public int getHTXuLyLasted(int maTV){
        XuLyDAL dal =new XuLyDAL();
        List<XuLy> list=dal.searchXuLy(maTV);
        if (list.size()==0) return 0;
        int maMax=list.get(0).getMaXL();
        LocalDateTime ngayMax=list.get(0).getNgayXL();
        for(XuLy temp: list){
            if(temp.getNgayXL().isAfter(ngayMax))
            {
                ngayMax=temp.getNgayXL();
                maMax=temp.getMaXL();
            }
        }
        return maMax;
    }
    public boolean isProcessingDeadline(int maTV){
        XuLyDAL dal =new XuLyDAL();
        XuLy temp =dal.getXuLy(getHTXuLyLasted(maTV));
        if (getHTXuLyLasted(maTV)==0) {
           return false;
        }
        int index=9;
        String newStr = temp.getHinhThucXL().substring(0, index) + temp.getHinhThucXL().substring(index + 2);
        if (newStr.equals("Khóa thẻ tháng")) {
            int thang = (int) temp.getHinhThucXL().charAt(index) - '0';
            int ngay=thang*30;
            if (temp.getNgayXL().plusDays(30).isAfter(LocalDateTime.now())) {
                return true;
            }
        }
        return false;
    }

    private void openSession() {
        if (!session.isOpen())
            session = HibernateUtils.getSessionFactory().openSession();
    }
    public static void main(String[] args) {
        int maTV = 2147483647; 
        XuLyDAL dal = new XuLyDAL();
        int maHTXuLyLasted = dal.getHTXuLyLasted(maTV);
        System.out.println("Mã hoạt động xử lý cuối cùng của thành viên có mã " + maTV + " là: " + maHTXuLyLasted);
    }

}
