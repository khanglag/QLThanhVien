/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import javax.persistence.*;
import lombok.Data;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author MSII
 */

@Data
@Entity
@Table(name = "thietbi")
public class ThietBi {

    @Id
    @Column(name = "MaTB")
    private int MaTB;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "MaTB", cascade = CascadeType.ALL)
    private List<ThongTinSD> thongTinSDs;

    @Column(name = "TenTB")
    private String TenTB;

    @Column(name = "MoTaTB")
    private String MoTaTB;

    public ThietBi() {
    }
    public ThietBi(int MaTB) {
        this.MaTB = MaTB;
    }

    public ThietBi(int MaTB,String TenTB, String MoTaTB) {
        this.MaTB = MaTB;
        this.TenTB = TenTB;
        this.MoTaTB = MoTaTB;
    }
    public ThietBi(int MaTB, List<ThongTinSD> thongTinSDs, String TenTB, String MoTaTB) {
        this.MaTB = MaTB;
        this.thongTinSDs = thongTinSDs;
        this.TenTB = TenTB;
        this.MoTaTB = MoTaTB;
    }

    public int getMaTB() {
        return this.MaTB;
    }

    public void setMaTB(int MaTB) {
        this.MaTB = MaTB;
    }

    public List<ThongTinSD> getThongTinSDs() {
        return this.thongTinSDs;
    }

    public void setThongTinSDs(List<ThongTinSD> thongTinSDs) {
        this.thongTinSDs = thongTinSDs;
    }

    public String getTenTB() {
        return this.TenTB;
    }

    public void setTenTB(String TenTB) {
        this.TenTB = TenTB;
    }

    public String getMoTaTB() {
        return this.MoTaTB;
    }

    public void setMoTaTB(String MoTaTB) {
        this.MoTaTB = MoTaTB;
    }

    public ThietBi MaTB(int MaTB) {
        setMaTB(MaTB);
        return this;
    }

    public ThietBi thongTinSDs(List<ThongTinSD> thongTinSDs) {
        setThongTinSDs(thongTinSDs);
        return this;
    }

    public ThietBi TenTB(String TenTB) {
        setTenTB(TenTB);
        return this;
    }

    public ThietBi MoTaTB(String MoTaTB) {
        setMoTaTB(MoTaTB);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " MaTB='" + getMaTB() + "'" +
            ", TenTB='" + getTenTB() + "'" +
            ", MoTaTB='" + getMoTaTB() + "'" +
            "}";
    }

    
}
