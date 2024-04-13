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

    @ManyToOne(fetch = FetchType.LAZY)
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

    @Override
    public String toString() {
        return "{" +
                " MaXL='" + getMaXL() + "'" +
                ", MaTV='" + (getMaTV() != null ? getMaTV().getMaTV() : null) + "'" +
                ", HinhThucXL='" + getHinhThucXL() + "'" +
                ", SoTien='" + getSoTien() + "'" +
                ", NgayXL='" + getNgayXL() + "'" +
                ", TrangThaiXL='" + getTrangThaiXL() + "'" +
                "}";
    }
}
