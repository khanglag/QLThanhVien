package DAL;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;

import BLL.ThanhVienBLL;
import org.hibernate.Session;

public class Test {
    public static void main(String[] args) {
        ThanhVienBLL bll = new ThanhVienBLL();
        for(ThanhVien thanhVien: bll.loadThanhVien()){
            System.out.println(thanhVien.toString());
        }
    }
}
