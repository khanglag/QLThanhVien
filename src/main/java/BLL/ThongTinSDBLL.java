package BLL;

import DAL.ThongTinSD;
import DAL.ThongTinSdDAL;
import java.util.List;
import javax.swing.table.TableModel;

/**
 *
 * @author MSII
 */
public class ThongTinSDBLL {
    private ThongTinSdDAL dal;

    public ThongTinSDBLL() {
        dal = new ThongTinSdDAL();
    }

    public List<ThongTinSD> loadThongTinSD() {
        return dal.loadThongTinSD();
    }

    public ThongTinSD getThongTinSD(int MaTT) {
        return dal.getThongTinSD(MaTT);
    }

    public static Object[][] convertList(List<ThongTinSD> list) {
        int rows = list.size();
        int cols = 6;
        Object[][] data = new Object[rows][cols];
        for (int i = 0; i < rows; i++) {
            data[i][0] = list.get(i).getMaTT();
            data[i][1] = list.get(i).getMaTV();
            data[i][2] = list.get(i).getMaTB();
            data[i][3] = list.get(i).getTGVao();
            data[i][4] = list.get(i).getTGMuon();
            data[i][5] = list.get(i).getTGTra();
        }
        return data;
    }

    public void addThongTin(ThongTinSD tt) {
        dal.addThongTin(tt);
    }

    public void updateThongTin(ThongTinSD tt) {
        dal.updateThongTin(tt);
    }

    public void deleteThongTIn(int MaTT) {
        dal.deleteThongTIn(MaTT);
    }
    public Object[][] getObjectses(TableModel model,int maTV){
        return dal.dataTableCheckin(model, maTV);
    }
    
    public void borrowedDevice(int maTV, int maTB){
        dal.borrowedDevice(maTV, maTB);
    }
    public void retủnDevice(int maTB){
        dal.returnDevice(maTB);
    }
}
