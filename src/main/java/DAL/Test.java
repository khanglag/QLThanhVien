package DAL;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;
import org.hibernate.Session;

public class Test {
    public static void main(String[] args) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            // ThietBiDAL thietBiDAL = new ThietBiDAL();
            // session.beginTransaction();

            // // Tìm kiếm và hiển thị danh sách các thiết bị có tên chứa từ khóa "Micro"
            // List<ThietBi> list = thietBiDAL.searchThietBi("micro");
            // for(ThietBi tb : list)
            //     System.out.println(tb);
            
            // // Tạo một đối tượng mới và thêm vào cơ sở dữ liệu
            // ThietBi newThietBi = new ThietBi();
            // newThietBi.setMaTB(1000004); 
            // newThietBi.setTenTB("Máy"); 
            // newThietBi.setMoTaTB("Loa âm thanh chất lượng cao");
            // thietBiDAL.addThietBi(newThietBi);

            // ThanhVienDAL dal = new ThanhVienDAL();
            // session.beginTransaction();
            // List<ThanhVien> list = dal.searchByKhoa("TLH");

            // for(ThanhVien tv : list)
            //     System.out.println(tv.toString());
            // XuLyDAL dal = new XuLyDAL();
            // ThanhVienDAL thanhVienDAL = new ThanhVienDAL();
            // ThanhVien thanhVien = thanhVienDAL.getThanhVien(1123330257);
            // // XuLy xuLy = new XuLy(4,thanhVien,"Khóa thẻ 2 tháng",null,LocalDateTime.now(),1);
            // // dal.updateXuLy(xuLy);

            // // List<XuLy> l = dal.searchXuLy("khóa thẻ");
            // // for(XuLy x : l)
            // //     System.out.println(x.toString());

            // int maTVToSearch = 1123330257;
            // List<XuLy> xuLyByMaTV = dal.searchXuLy("2023-09-12");
            // System.out.println("XuLy with MaTV " + maTVToSearch + ":");
            // for (XuLy xuLy : xuLyByMaTV) {
            //     System.out.println(xuLy);
            // }

            ThongTinSdDAL dal = new ThongTinSdDAL();

            ThanhVienDAL daltv = new ThanhVienDAL();
            ThanhVien tv =  daltv.getThanhVien(1123330257);

            ThietBiDAL tbdal = new ThietBiDAL();
            ThietBi tb = tbdal.getThietBi(1000001);

            ThongTinSD thongTinSD = new ThongTinSD(3,tv,tb,LocalDateTime.now(),LocalDateTime.now(),LocalDateTime.now());
            dal.updateThongTin(thongTinSD);
            session.getTransaction().commit();
        } catch (Exception e) {
            // Xử lý ngoại lệ nếu có
            e.printStackTrace();
        }
    }
}
