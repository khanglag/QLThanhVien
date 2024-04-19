/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import java.util.List;

import DAL.ThietBi;
import DAL.ThietBiDAL;
import DAL.ThongTinSD;
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
public class ThietBiBLL {
    private ThietBiDAL thietBiDAL;

    public ThietBiBLL() {
        thietBiDAL = new ThietBiDAL();
    }
    
    public Object[][]  convertList ( List<ThietBi> list) {
        int rows = list.size();
        int cols = 3;
        Object[][] data = new Object[rows][cols];
        for (int i = 0; i < rows; i++) {
            data[i][0] = list.get(i).getMaTB();
            data[i][1] = list.get(i).getTenTB();
            data[i][2] = list.get(i).getMoTaTB();
        }
        return data;
    }
    public List<ThietBi> loadThietbi() {
        return thietBiDAL.loadThietBi();
    }

    public ThietBi getThietBi(int MaTB) {
        return thietBiDAL.getThietBi(MaTB);
    }
    
    public int generateMaTB(int loaiTB) {
        return thietBiDAL.generateMaTB(loaiTB);
    }

    public void addThietBi(ThietBi tb) {
        thietBiDAL.addThietBi(tb);
    }
    //Thêm thiết bị với mã theo quy định
    public void addThietBi(ThietBi tb, int loaiTB) {
        thietBiDAL.addThietBi(tb, loaiTB);
    }

    public void updateThietBi(ThietBi tb) {
        thietBiDAL.updateThietBi(tb);
    }

    public void deleteThietBi(int MaTB) {
        thietBiDAL.deleteThietBi(MaTB);
    }

    //Xóa nhiều thiết bị theo mã quy định
    public void deleteByRegula(int MaQD) {
        thietBiDAL.deleteByRegula(MaQD);
    }

    public List<ThietBi> search(int MaTB) {
        return thietBiDAL.searchThietBi(MaTB);

    }

    public List<ThietBi> search(String TenTB) {
        return thietBiDAL.searchThietBi(TenTB);
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
    public List<ThietBi> readDataFromExcel() throws IOException {
        List<ThietBi> thietBiList = new ArrayList<>();
        FileInputStream inputStream = new FileInputStream(new File(chooseExcelFile()));

        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(1);
        Iterator<Row> iterator = sheet.iterator();

        // Skip header row
        iterator.next();

        while (iterator.hasNext()) {
            Row currentRow = iterator.next();
            Iterator<Cell> cellIterator = currentRow.iterator();
            int maTB = (int) cellIterator.next().getNumericCellValue();
            if (maTB==0) {
                break;
            }
            String tenTB = cellIterator.next().getStringCellValue();
            String moTaTB = cellIterator.next().getStringCellValue();
            ThietBi thietBi = new ThietBi(maTB, tenTB, moTaTB);
            thietBiList.add(thietBi);
            
        }

        workbook.close();
        inputStream.close();

        return thietBiList;
    }

    private static List<String> readThongTinSDsFromCell(Cell cell) {
        List<String> thongTinSDs = new ArrayList<>();
        String thongTinStr = cell.getStringCellValue();
        String[] thongTinArray = thongTinStr.split(";");

        for (String thongTin : thongTinArray) {
            // Thêm thông tin sử dụng vào danh sách
            thongTinSDs.add(thongTin);
        }

        return thongTinSDs;
    }
}