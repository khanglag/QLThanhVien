package GUI.Hander;



import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author khang
 */
public class StringToDateConverter {
    public static Date stringToDate(String dateString) throws ParseException {
        // Định dạng cho chuỗi thời gian
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        
            // Phân tích chuỗi thành Date
            return formatter.parse(dateString);
        
    }

}
