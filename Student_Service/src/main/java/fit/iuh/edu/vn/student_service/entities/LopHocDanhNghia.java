package fit.iuh.edu.vn.student_service.entities;

import fit.iuh.edu.vn.student_service.enums.BacDaoTao;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;

import java.util.List;

@Entity
@Table(name = "LopHocDanhNghia")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LopHocDanhNghia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maLopHocDanhNghia")
    private long maLopHocDanhNghia;
    private String tenLopHocDanhNghia;
    @Enumerated(EnumType.ORDINAL)
    private BacDaoTao bacDaoTao;
    private String loaiHinhDaoTao;

    @ManyToOne
    @JoinColumn(name = "maGV")
    private GiangVien giangVien;
    @ManyToOne
    @JoinColumn(name = "maNganhHoc")
    private NganhHoc nganhHoc;
    @ManyToOne
    @JoinColumn(name = "maKhoaHoc")
    private KhoaHoc khoaHoc;
    @OneToMany(mappedBy = "lopHocDanhNghia")
    private List<SinhVien> sinhViens;
    public LopHocDanhNghia(String tenLopHocDanhNghia, BacDaoTao bacDaoTao, String loaiHinhDaoTao, GiangVien giangVien, NganhHoc nganhHoc, KhoaHoc khoaHoc) {
        this.tenLopHocDanhNghia = tenLopHocDanhNghia;
        this.bacDaoTao = bacDaoTao;
        this.loaiHinhDaoTao = loaiHinhDaoTao;
        this.giangVien = giangVien;
        this.nganhHoc = nganhHoc;
        this.khoaHoc = khoaHoc;
    }

    @Override
    public String toString() {
        return "LopHocDanhNghia{" +
                "maLopHocDanhNghia=" + maLopHocDanhNghia +
                ", tenLopHocDanhNghia='" + tenLopHocDanhNghia + '\'' +
                ", bacDaoTao=" + bacDaoTao +
                ", loaiHinhDaoTao='" + loaiHinhDaoTao + '\'' +
                ", giangVien=" + giangVien +
                ", nganhHoc=" + nganhHoc +
                ", khoaHoc=" + khoaHoc +
                '}';
    }
}
