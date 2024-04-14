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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "MaTB", cascade = CascadeType.ALL)
    private List<ThongTinSD> thongTinSDs;

    @Column(name = "TenTB")
    private String TenTB;

    @Column(name = "MoTaTB")
    private String MoTaTB;

    public ThietBi() {
    }

    public ThietBi(int MaTB, String TenTB, String MoTaTB) {
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

    // Getters and Setters

    @Override
    public String toString() {
        return "{" +
                " MaTB='" + getMaTB() + "'" +
                ", TenTB='" + getTenTB() + "'" +
                ", MoTaTB='" + getMoTaTB() + "'" +
                "}";
    }

}
