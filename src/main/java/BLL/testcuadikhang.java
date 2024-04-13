/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package BLL;

import DAL.XuLyDAL;

/**
 *
 * @author pc
 */
public class testcuadikhang {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        XuLyDAL dal =new XuLyDAL();
        dal.searchXuLy(2147483647);
    }
}
