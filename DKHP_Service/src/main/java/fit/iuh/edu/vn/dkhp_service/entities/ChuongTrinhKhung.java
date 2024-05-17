package fit.iuh.edu.vn.dkhp_service.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ChuongTrinhKhung")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ChuongTrinhKhung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maChuongTrinhKhung")
    private long maChuongTrinhKhung;
    private String thoiGianHoc;
    @ManyToOne
    @JoinColumn(name = "maNganhHoc")
    private NganhHoc nganhHoc;
    @ManyToOne
    @JoinColumn(name = "maKhoaHoc")
    private KhoaHoc khoaHoc;
    @OneToMany(mappedBy = "chuongTrinhKhung")
    private List<MonHocChuongTrinhKhung> monHocChuongTrinhKhungs = new ArrayList<>();

    public ChuongTrinhKhung(String thoiGianHoc, NganhHoc nganhHoc, KhoaHoc khoaHoc) {
        this.thoiGianHoc = thoiGianHoc;
        this.nganhHoc = nganhHoc;
        this.khoaHoc = khoaHoc;
    }

    @Override
    public String toString() {
        return "ChuongTrinhKhung{" +
                "maChuongTrinhKhung=" + maChuongTrinhKhung +
                ", thoiGianHoc='" + thoiGianHoc + '\'' +
                ", nganhHoc=" + nganhHoc +
                ", khoaHoc=" + khoaHoc +
                '}';
    }
}
