package fit.iuh.edu.vn.dkhp_service.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "MonHoc")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MonHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maMonHoc")
    private long maMonHoc;
    private String tenMonHoc;
    @ManyToOne
    @JoinColumn(name = "maKhoa")
    private Khoa khoa;
    @OneToMany(mappedBy = "monHoc")
    private List<MonHocChuongTrinhKhung> monHocChuongTrinhKhungs = new ArrayList<>();
    @OneToMany(mappedBy = "monHoc")
    private List<MonHocTienQuyet> monHocTienQuyets;

    public MonHoc(String tenMonHoc, Khoa khoa) {
        this.tenMonHoc = tenMonHoc;
        this.khoa = khoa;
    }


    @Override
    public String toString() {
        return "MonHoc{" +
                "maMonHoc=" + maMonHoc +
                ", tenMonHoc='" + tenMonHoc + '\'' +
                ", khoa=" + khoa +
                '}';
    }
}
