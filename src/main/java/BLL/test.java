package BLL;

import java.util.List;

import DAL.ThietBi;

public class test {
    public static void main(String[] args) {
        ThietBiBLL bll = new ThietBiBLL();
        ThietBi tb = new ThietBi(1000008, "Máy tính bảng", "Đây là máy tính bảng");
        // bll.addThietBi(tb);
        // List<ThietBi> list= bll.search("micro");
        // for( ThietBi b : list)
        //     System.out.println(b.toString());

        List<ThietBi> thietBiList = bll.loadThietbi();
        Object[][] convertedData = bll.convertList(thietBiList);
        for (Object[] row : convertedData) {
            for (Object cell : row) {
                System.out.print(cell + "\t");
            }
            System.out.println();
        }
    }
}
