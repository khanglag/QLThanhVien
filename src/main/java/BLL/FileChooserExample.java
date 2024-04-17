/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

/**
 *
 * @author pc
 */
import org.apache.poi.ss.usermodel.*;

import javax.swing.JFileChooser;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileChooserExample {

    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();

            try (FileInputStream fis = new FileInputStream(selectedFile);
                 Workbook workbook = new XSSFWorkbook(fis)) {

                // Lấy ra tệp Excel
                Sheet sheet = workbook.getSheetAt(0); // Lấy sheet đầu tiên

                // Duyệt qua từng dòng trong tệp Excel
                for (Row row : sheet) {
                    // Duyệt qua từng ô trong mỗi dòng
                    for (Cell cell : row) {
                        // Kiểm tra kiểu dữ liệu của ô
                        switch (cell.getCellType()) {
                            case STRING:
                                System.out.print(cell.getStringCellValue() + "\t");
                                break;
                            case NUMERIC:
                                System.out.print(cell.getNumericCellValue() + "\t");
                                break;
                            // Xử lý các kiểu dữ liệu khác tùy theo nhu cầu
                        }
                    }
                    System.out.println(); // Xuống dòng sau mỗi dòng
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

