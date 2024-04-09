/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import java.util.List;

import DAL.ThanhVien;
import DAL.ThanhVienDAL;

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
        int cols = 5;
        Object[][] data = new Object[rows][cols];
        for (int i = 0; i < rows; i++) {
            data[i][0] = list.get(i).getMaTV();
            data[i][1] = list.get(i).getHoTen();
            data[i][2] = list.get(i).getNganh();
            data[i][3] = list.get(i).getKhoa();
            data[i][4] = list.get(i).getSDT();
        }
        return data;
    }

    public List<ThanhVien> loadThanhVien() {
        return tvDAL.loadThanhVien();
    }

    public ThanhVien getThanhVien(int MaTV) {
        return tvDAL.getThanhVien(MaTV);
    }

    public void addThanhVien(ThanhVien tv) {
        tvDAL.addThanhVien(tv);
    }

    public void updateThanhVien(ThanhVien tv) {
        tvDAL.updateThanhVien(tv);
    }

    public void deleteThanhVien(int MaTV) {
        tvDAL.deleteThanhVien(MaTV);
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
}
