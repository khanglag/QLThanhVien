/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
    private static String chooseExcelFile() {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel files", "xlsx");
        fileChooser.setFileFilter(filter);

        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile().getPath();
        }
        return null;
    }
    public List<ThanhVien> readDataFromExcel(String filePath)throws IOException {
        List<ThanhVien> thanhVienList = new ArrayList<>();
        FileInputStream inputStream = new FileInputStream(new File(filePath));

        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = sheet.iterator();

        // Skip header row
        iterator.next();

        while (iterator.hasNext()) {
            Row currentRow = iterator.next();
            Iterator<Cell> cellIterator = currentRow.iterator();

            int maTV = (int) cellIterator.next().getNumericCellValue();
            String hoTen = cellIterator.next().getStringCellValue();
            String khoa = cellIterator.next().getStringCellValue();
            String nganh = cellIterator.next().getStringCellValue();
            int sdt = (int) cellIterator.next().getNumericCellValue();

            ThanhVien thanhVien = new ThanhVien(maTV, hoTen, khoa, nganh, sdt);
            thanhVienList.add(thanhVien);
        }

        workbook.close();
        inputStream.close();

        return thanhVienList;
    }
}
