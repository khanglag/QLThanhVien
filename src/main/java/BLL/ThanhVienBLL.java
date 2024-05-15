/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import java.util.List;

import DAL.ThanhVien;
import DAL.ThanhVienDAL;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author MSII
 */
public class ThanhVienBLL {
    private ThanhVienDAL tvDAL;

    public ThanhVienBLL() {
        tvDAL = new ThanhVienDAL();
    }

    public static Object[][] convertList(List<ThanhVien> list) {
        int rows = list.size();
        int cols = 7; // Updated to include email and password
        Object[][] data = new Object[rows][cols];
        for (int i = 0; i < rows; i++) {
            data[i][0] = list.get(i).getMaTV();
            data[i][1] = list.get(i).getHoTen();
            data[i][2] = list.get(i).getNganh();
            data[i][3] = list.get(i).getKhoa();
            data[i][4] = list.get(i).getSDT();
            data[i][5] = list.get(i).getEmail(); // Adding email
            data[i][6] = list.get(i).getPassword(); // Adding password
        }
        return data;
    }


    public List<ThanhVien> loadThanhVien() {
        return tvDAL.loadThanhVien();
    }

    public ThanhVien getThanhVien(int MaTV) {
        return tvDAL.getThanhVien(MaTV);
    }

//    public void addThanhVien(ThanhVien tv) {
//        tvDAL.addThanhVien(tv);
//    }

    //Thêm thành viên theo năm và khóa
    public void addThanhVien(ThanhVien tv, int nam, int khoa) {
        tvDAL.addThanhVien(tv, nam, khoa);
    }
    public void updateThanhVien(ThanhVien tv) {
        tvDAL.updateThanhVien(tv);
    }

    public void deleteThanhVien(int MaTV) {
        tvDAL.deleteThanhVien(MaTV);
    }

    //Xóa thành viên theo điều kiện
    public void deleteByActiveYear(int Year) {
        tvDAL.deleteByActiveYear(Year);
    }

    public List<ThanhVien> searchThanhVien(int MaTV) {
        return tvDAL.searchThanhVien(MaTV);
    }

    public List<ThanhVien> searchByHoTen(String hoTen) {
        return tvDAL.searchByHoTen(hoTen);
    }

    public List<ThanhVien> searchByKhoa(String khoa) {
        return tvDAL.searchByKhoa(khoa);
    }

    public List<ThanhVien> searchByNganh(String nganh) {
        return tvDAL.searchByNganh(nganh);
    }
    
    @SuppressWarnings("unlikely-arg-type")
    public boolean kiemTraTVCheckin(String maTV){
        return tvDAL.equals(maTV);
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
    public List<ThanhVien> readDataFromExcel(String filePath) throws IOException {
        List<ThanhVien> thanhVienList = new ArrayList<>();
        FileInputStream inputStream = new FileInputStream(new File(filePath));

        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = sheet.iterator();

        // Bỏ qua hàng tiêu đề
        iterator.next();

        while (iterator.hasNext()) {
            Row currentRow = iterator.next();
            Iterator<Cell> cellIterator = currentRow.iterator();

            int maTV = (int) cellIterator.next().getNumericCellValue();
            String hoTen = cellIterator.next().getStringCellValue();
            String khoa = cellIterator.next().getStringCellValue();
            String nganh = cellIterator.next().getStringCellValue();
            int sdt = (int) cellIterator.next().getNumericCellValue();
            String email = cellIterator.next().getStringCellValue();
            String password = cellIterator.next().getStringCellValue();

            ThanhVien thanhVien = new ThanhVien(maTV, hoTen, khoa, nganh, sdt, email, password);
            thanhVienList.add(thanhVien);
        }

        workbook.close();
        inputStream.close();

        return thanhVienList;
    }
}
