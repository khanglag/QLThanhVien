/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import javax.persistence.*;
import lombok.Data;
import java.util.List;

/**
 *
 * @author MSII
 */

@Data
@Entity
@Table(name = "thanhvien")
public class ThanhVien {
    @Id
    @Column(name = "MaTV")
    private int MaTV;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "MaTV", cascade = CascadeType.ALL)
    private List<ThongTinSD> thongTinSDs;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "MaTV", cascade = CascadeType.ALL)
    private List<XuLy> xulies;

    @Column(name = "HoTen")
    private String HoTen;

    @Column(name = "Khoa")
    private String Khoa;

    @Column(name = "Nganh")
    private String Nganh;

    @Column(name = "SDT")
    private Integer SDT;

    public ThanhVien() {
    }

    public ThanhVien(int MaTV) {
        this.MaTV = MaTV;
    }

    public ThanhVien(int MaTV, String HoTen, String Khoa, String Nganh, Integer SDT) {
        this.MaTV = MaTV;
        this.HoTen = HoTen;
        this.Khoa = Khoa;
        this.Nganh = Nganh;
        this.SDT = SDT;
    }

    public ThanhVien(int MaTV, List<ThongTinSD> thongTinSDs, List<XuLy> xulies, String HoTen, String Khoa, String Nganh, Integer SDT) {
        this.MaTV = MaTV;
        this.thongTinSDs = thongTinSDs;
        this.xulies = xulies;
        this.HoTen = HoTen;
        this.Khoa = Khoa;
        this.Nganh = Nganh;
        this.SDT = SDT;
    }
    @Override
    public String toString() {
        return "{" +
            " MaTV='" + getMaTV() + "'" +
            ", HoTen='" + getHoTen() + "'" +
            ", Khoa='" + getKhoa() + "'" +
            ", Nganh='" + getNganh() + "'" +
            ", SDT='" + getSDT() + "'" +
            "}";
    }
    

}
