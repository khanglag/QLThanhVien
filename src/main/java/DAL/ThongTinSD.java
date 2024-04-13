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
@Table(name = "thongtinsd")
public class ThongTinSD {

    @Id
    @Column(name = "MaTT")
    private int MaTT;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaTV")
    private ThanhVien MaTV;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaTB")
    private ThietBi MaTB;

    @Column(name = "TGVao")
    private LocalDateTime TGVao;

    @Column(name = "TGMuon")
    private LocalDateTime TGMuon;

    @Column(name = "TGTra")
    private LocalDateTime TGTra;

    public ThongTinSD() {
    }

    public ThongTinSD(int MaTT, ThanhVien MaTV, ThietBi MaTB, LocalDateTime TGVao, LocalDateTime TGMuon,
            LocalDateTime TGTra) {
        this.MaTT = MaTT;
        this.MaTV = MaTV;
        this.MaTB = MaTB;
        this.TGVao = TGVao;
        this.TGMuon = TGMuon;
        this.TGTra = TGTra;
    }

    @Override
    public String toString() {
        return "{" +
                " MaTT='" + getMaTT() + "'" +
                ", MaTV='" + (getMaTV() != null ? getMaTV().getMaTV() : null) + "'" +
                ", MaTB='" + (getMaTB() != null ? getMaTB().getMaTB() : null) + "'" +
                ", TGVao='" + getTGVao() + "'" +
                ", TGMuon='" + getTGMuon() + "'" +
                ", TGTra='" + getTGTra() + "'" +
                "}";
    }
}