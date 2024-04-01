/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import javax.persistence.*;
import lombok.Data;

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

    @Column(name = "HoTen")
    private String HoTen;

    @Column(name = " Khoa")
    private String Khoa;

    @Column(name = "Nganh")
    private String Nganh;

    @Column(name = "SDT")
    private Integer SDT;

    public ThanhVien() {
    }

    public ThanhVien(int MaTV, String HoTen, String Khoa, String Nganh, Integer SDT) {
        this.MaTV = MaTV;
        this.HoTen = HoTen;
        this.Khoa = Khoa;
        this.Nganh = Nganh;
        this.SDT = SDT;
    }

    public int getMaTV() {
        return this.MaTV;
    }

    public void setMaTV(int MaTV) {
        this.MaTV = MaTV;
    }

    public String getHoTen() {
        return this.HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getKhoa() {
        return this.Khoa;
    }

    public void setKhoa(String Khoa) {
        this.Khoa = Khoa;
    }

    public String getNganh() {
        return this.Nganh;
    }

    public void setNganh(String Nganh) {
        this.Nganh = Nganh;
    }

    public Integer getSDT() {
        return this.SDT;
    }

    public void setSDT(Integer SDT) {
        this.SDT = SDT;
    }

    public ThanhVien MaTV(int MaTV) {
        setMaTV(MaTV);
        return this;
    }

    public ThanhVien HoTen(String HoTen) {
        setHoTen(HoTen);
        return this;
    }

    public ThanhVien Khoa(String Khoa) {
        setKhoa(Khoa);
        return this;
    }

    public ThanhVien Nganh(String Nganh) {
        setNganh(Nganh);
        return this;
    }

    public ThanhVien SDT(Integer SDT) {
        setSDT(SDT);
        return this;
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
