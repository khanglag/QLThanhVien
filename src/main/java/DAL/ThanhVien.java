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

    @Column(name = "Email", length = 250)
    private String email;

    @Column(name = "Password", length = 20)
    private String password;

    public ThanhVien() {
    }

    public ThanhVien(int MaTV) {
        this.MaTV = MaTV;
    }

    public ThanhVien(int maTV, String hoTen, String khoa, String nganh, Integer SDT, String email, String password) {
        MaTV = maTV;
        HoTen = hoTen;
        Khoa = khoa;
        Nganh = nganh;
        this.SDT = SDT;
        this.email = email;
        this.password = password;
    }

    public ThanhVien(int MaTV, String HoTen, String Khoa, String Nganh, Integer SDT) {
        this.MaTV = MaTV;
        this.HoTen = HoTen;
        this.Khoa = Khoa;
        this.Nganh = Nganh;
        this.SDT = SDT;
    }

    public ThanhVien(int MaTV, List<ThongTinSD> thongTinSDs, List<XuLy> xulies, String HoTen, String Khoa, String Nganh, Integer SDT, String email, String password) {
        this.MaTV = MaTV;
        this.thongTinSDs = thongTinSDs;
        this.xulies = xulies;
        this.HoTen = HoTen;
        this.Khoa = Khoa;
        this.Nganh = Nganh;
        this.SDT = SDT;
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "{" +
                " MaTV='" + getMaTV() + "'" +
                ", HoTen='" + getHoTen() + "'" +
                ", Khoa='" + getKhoa() + "'" +
                ", Nganh='" + getNganh() + "'" +
                ", SDT='" + getSDT() + "'" +
                ", Email='" + getEmail() + "'" +
                ", Password='" + getPassword() + "'" +
                "}";
    }
}
