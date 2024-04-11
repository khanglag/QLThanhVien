package BLL;

import java.time.LocalDateTime;
import java.util.List;

import DAL.ThanhVien;
import DAL.ThietBi;
import DAL.ThongTinSD;
import DAL.XuLy;

public class test {
    public static void main(String[] args) {
        // ThietBiBLL bll = new ThietBiBLL();
        // ThietBi tb = new ThietBi(1000009, "Máy tính bảng", "Đây là máy tính bảng");
        // bll.addThietBi(tb);
        // List<ThietBi> list= bll.search("micro");
        // for( ThietBi b : list)
        //     System.out.println(b.toString());

        // List<ThietBi> thietBiList = bll.loadThietbi();
        // Object[][] convertedData = bll.convertList(thietBiList);
        // for (Object[] row : convertedData) {
        //     for (Object cell : row) {
        //         System.out.print(cell + "\t");
        //     }
        //     System.out.println();
        // }
        // ThanhVienBLL bll= new ThanhVienBLL();
        // ThanhVien newMember = new ThanhVien();
        // newMember.setHoTen("Nguyen Van A");
        // newMember.setKhoa("CNTT");
        // newMember.setNganh("Cong nghe thong tin");
        // newMember.setSDT(23456789);
       
        // bll.addThanhVien(newMember, 22,41);
        // ThanhVienBLL a =new ThanhVienBLL();
        // ThanhVien b = new ThanhVien();
        // b.setMaTV(1120410002);
        // b.setHoTen("A");
        // b.setKhoa("QTKD");
        // b.setNganh("CNTT");
        // b.setSDT(85233);
        // a.updateThanhVien(b);
            
            // int maTV = thanhVienDAL.getMaTV(2147483647);
            
            // Khởi tạo đối tượng XuLyDAL
//            XuLyBLL bll = new XuLyBLL();
//            
//            // Tạo một đối tượng XuLy mới
//            XuLy xuLy = new XuLy();
//            xuLy.setMaTV(new ThanhVien(2147483647)); 
//            xuLy.setHinhThucXL("Bồi thường mất tài sản");
//            xuLy.setSoTien(500000);
//            xuLy.setNgayXL(LocalDateTime.now());
//            xuLy.setTrangThaiXL(0); 
//
//            // Thêm đối tượng XuLy vào cơ sở dữ liệu
//            bll.addXuLy(xuLy);
            ThongTinSDBLL ttBLL = new ThongTinSDBLL();
            
        System.out.println(ttBLL.geThongTinSD(2)  );
        System.out.println("BLL.test.main()");
        
    }
}
