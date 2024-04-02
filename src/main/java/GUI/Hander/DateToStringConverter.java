/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI.Hander;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author khang
 */
public class DateToStringConverter {
    public static String dateToString(Date date) {
        // Tạo một đối tượng SimpleDateFormat với định dạng mong muốn
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        // Sử dụng đối tượng SimpleDateFormat để chuyển đổi Date thành String
        String dateString = dateFormat.format(date);

        // Trả về chuỗi đã được chuyển đổi
        return dateString;
    }
}
