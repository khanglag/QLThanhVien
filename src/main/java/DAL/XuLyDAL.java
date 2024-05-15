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
    public static int findNumberInString(String input) {
        // Duyệt qua từng ký tự trong chuỗi
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            // Kiểm tra xem ký tự có phải là số không
            if (Character.isDigit(c)) {
                return Character.getNumericValue(c); // Trả về số nếu tìm thấy ký tự số đầu tiên trong chuỗi
            }
        }
        return -1; // Trả về -1 nếu không tìm thấy ký tự số trong chuỗi
    }

    public static int tinhSoNgay(int soThang) {
        return soThang * 30;
    }
    public void kiemTraVaCapNhatHinhThucXuLy() {
        List<XuLy> danhSachXuLy = loadXuLy();
        LocalDateTime ngayHomNay = LocalDateTime.now();
        for (XuLy xuLy : danhSachXuLy) {
            int ngay = tinhSoNgay(findNumberInString(xuLy.getHinhThucXL()));
            LocalDateTime ngayXuLy = xuLy.getNgayXL().plusDays(ngay);
            if (xuLy.getHinhThucXL().equals("Khóa thẻ vĩnh viễn")){
                xuLy.setTrangThaiXL(1);}
            // Nếu ngày xử lý đã qua ngày hôm nay, đặt hình thức xử lý là 0 (hết hạn)
            else if (ngayXuLy != null && ngayXuLy.toLocalDate().isBefore(ngayHomNay.toLocalDate())) {
                xuLy.setTrangThaiXL(0);
            } else {
                // Nếu ngày xử lý vẫn còn từ hôm nay trở đi, đặt hình thức xử lý là 1 (chưa hết hạn)
                xuLy.setTrangThaiXL(1);
            }
            updateXuLy(xuLy);
        }

    }


}
