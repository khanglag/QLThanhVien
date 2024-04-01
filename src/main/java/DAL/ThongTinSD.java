/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.time.LocalDateTime;

import javax.persistence.*;
import javax.persistence.TemporalType;

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

    @ManyToOne
    @JoinColumn(name = "MaTV")
    private ThanhVien MaTV;

    @ManyToOne
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

    public int getMaTT() {
        return this.MaTT;
    }

    public void setMaTT(int MaTT) {
        this.MaTT = MaTT;
    }

    public ThanhVien getMaTV() {
        return this.MaTV;
    }

    public void setMaTV(ThanhVien MaTV) {
        this.MaTV = MaTV;
    }

    public ThietBi getMaTB() {
        return this.MaTB;
    }

    public void setMaTB(ThietBi MaTB) {
        this.MaTB = MaTB;
    }

    public LocalDateTime getTGVao() {
        return this.TGVao;
    }

    public void setTGVao(LocalDateTime TGVao) {
        this.TGVao = TGVao;
    }

    public LocalDateTime getTGMuon() {
        return this.TGMuon;
    }

    public void setTGMuon(LocalDateTime TGMuon) {
        this.TGMuon = TGMuon;
    }

    public LocalDateTime getTGTra() {
        return this.TGTra;
    }

    public void setTGTra(LocalDateTime TGTra) {
        this.TGTra = TGTra;
    }

    public ThongTinSD MaTT(int MaTT) {
        setMaTT(MaTT);
        return this;
    }

    public ThongTinSD MaTV(ThanhVien MaTV) {
        setMaTV(MaTV);
        return this;
    }

    public ThongTinSD MaTB(ThietBi MaTB) {
        setMaTB(MaTB);
        return this;
    }

    public ThongTinSD TGVao(LocalDateTime TGVao) {
        setTGVao(TGVao);
        return this;
    }

    public ThongTinSD TGMuon(LocalDateTime TGMuon) {
        setTGMuon(TGMuon);
        return this;
    }

    public ThongTinSD TGTra(LocalDateTime TGTra) {
        setTGTra(TGTra);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
                " MaTT='" + getMaTT() + "'" +
                ", MaTV='" + getMaTV() + "'" +
                ", MaTB='" + getMaTB() + "'" +
                ", TGVao='" + getTGVao() + "'" +
                ", TGMuon='" + getTGMuon() + "'" +
                ", TGTra='" + getTGTra() + "'" +
                "}";
    }
}
