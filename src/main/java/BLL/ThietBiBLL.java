/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import java.util.List;

import DAL.ThietBi;
import DAL.ThietBiDAL;

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
}
