/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.time.LocalDateTime;

import javax.persistence.*;

import lombok.Data;

/**
 *
 * @author MSII
 */

@Data
@Entity
@Table(name = "xuly")
public class XuLy {

    @Id
    @Column(name = "MaXL")
    private int MaXL;

    @ManyToOne
    @JoinColumn(name = "MaTV")
    private ThanhVien MaTV;

    @Column(name = "HinhThucXL")
    private String hinhThucXL;

    @Column(name = "SoTien")
    private Integer soTien;

    @Column(name = "NgayXL")
    private LocalDateTime ngayXL;

    @Column(name = "TrangThaiXL")
    private Integer trangThaiXL;

    public XuLy() {
    }

    public XuLy(int MaXL, ThanhVien MaTV, String hinhThucXL, Integer soTien, LocalDateTime ngayXL,
            Integer trangThaiXL) {
        this.MaXL = MaXL;
        this.MaTV = MaTV;
        this.hinhThucXL = hinhThucXL;
        this.soTien = soTien;
        this.ngayXL = ngayXL;
        this.trangThaiXL = trangThaiXL;
    }

    public int getMaXL() {
        return this.MaXL;
    }

    public void setMaXL(int MaXL) {
        this.MaXL = MaXL;
    }

    public ThanhVien getMaTV() {
        return this.MaTV;
    }

    public void setMaTV(ThanhVien MaTV) {
        this.MaTV = MaTV;
    }

    public String getHinhThucXL() {
        return this.hinhThucXL;
    }

    public void setHinhThucXL(String hinhThucXL) {
        this.hinhThucXL = hinhThucXL;
    }

    public Integer getSoTien() {
        return this.soTien;
    }

    public void setSoTien(Integer soTien) {
        this.soTien = soTien;
    }

    public LocalDateTime getNgayXL() {
        return this.ngayXL;
    }

    public void setNgayXL(LocalDateTime ngayXL) {
        this.ngayXL = ngayXL;
    }

    public Integer getTrangThaiXL() {
        return this.trangThaiXL;
    }

    public void setTrangThaiXL(Integer trangThaiXL) {
        this.trangThaiXL = trangThaiXL;
    }

    public XuLy MaXL(int MaXL) {
        setMaXL(MaXL);
        return this;
    }

    public XuLy thanhVien(ThanhVien MaTV) {
        setMaTV(MaTV);
        return this;
    }

    public XuLy hinhThucXL(String hinhThucXL) {
        setHinhThucXL(hinhThucXL);
        return this;
    }

    public XuLy soTien(Integer soTien) {
        setSoTien(soTien);
        return this;
    }

    public XuLy ngayXL(LocalDateTime ngayXL) {
        setNgayXL(ngayXL);
        return this;
    }

    public XuLy trangThaiXL(Integer trangThaiXL) {
        setTrangThaiXL(trangThaiXL);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
                " MaXL='" + getMaXL() + "'" +
                ", thanhVien='" + getMaTV() + "'" +
                ", hinhThucXL='" + getHinhThucXL() + "'" +
                ", soTien='" + getSoTien() + "'" +
                ", ngayXL='" + getNgayXL() + "'" +
                ", trangThaiXL='" + getTrangThaiXL() + "'" +
                "}";
    }
}
