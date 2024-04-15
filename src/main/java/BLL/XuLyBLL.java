/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import java.util.List;

import DAL.ThanhVien;
import DAL.XuLy;
import DAL.XuLyDAL;

/**
 *
 * @author MSII
 */
public class XuLyBLL {
    private XuLyDAL dal;

    public XuLyBLL() {
        dal = new XuLyDAL();
    }

    public List<XuLy> loadXuLy() {
        return dal.loadXuLy();
    }

    public XuLy getXuLy(int MaXL) {
        return dal.getXuLy(MaXL);
    }

    public Object[][] convertList(List<XuLy> list) {
        int rows = list.size();
        int cols = 6;
        Object[][] data = new Object[rows][cols];
        for (int i = 0; i < rows; i++) {
            data[i][0] = list.get(i).getMaXL();
            data[i][1] = list.get(i).getMaTV();
            data[i][2] = list.get(i).getHinhThucXL();
            data[i][3] = list.get(i).getSoTien();
            data[i][4] = list.get(i).getNgayXL();
            data[i][5] = list.get(i).getTrangThaiXL();
        }
        return data;
    }

    public void addXuLy(XuLy xl) {
        dal.addXuLy(xl);
    }

    public void updateXuLy(XuLy xl) {
        dal.updateXuLy(xl);
    }

    public void deleteXuLy(int MaXL) {
        dal.deleteXuLy(MaXL);
    }

    public List<XuLy> searchXuLy(int MaTV) {
        return dal.searchXuLy(MaTV);
    }

    public List<XuLy> searchXuLy(String HinhThucXL) {
        return dal.searchXuLy(HinhThucXL);
    }
    public XuLy getXuLyLasted(int maTV){
        return dal.getXuLy(dal.getHTXuLyLasted(maTV));
    }
}
