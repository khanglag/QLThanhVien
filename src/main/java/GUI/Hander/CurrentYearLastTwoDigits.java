/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI.Hander;

import java.time.Year;

/**
 *
 * @author khang
 */
public class CurrentYearLastTwoDigits {
    public static int getCurrentYearLastTwoDigits() {
        // Lấy số năm hiện tại
        int currentYear = Year.now().getValue();
        
        // Chỉ lấy hai chữ số cuối cùng
        int lastTwoDigits = currentYear % 100;
        
        return lastTwoDigits;
    }
}
