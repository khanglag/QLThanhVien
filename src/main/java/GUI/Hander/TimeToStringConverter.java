/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI.Hander;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author khang
 */
public class TimeToStringConverter {
    public static String timeToString(LocalTime time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String timeString = time.format((formatter));

        return timeString;
    }

}
