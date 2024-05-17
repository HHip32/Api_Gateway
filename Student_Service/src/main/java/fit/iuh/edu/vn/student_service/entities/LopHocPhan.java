package fit.iuh.edu.vn.student_service.entities;

import fit.iuh.edu.vn.student_service.enums.TrangThaiHoc;
import fit.iuh.edu.vn.student_service.enums.TrangThaiLop;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "LopHocPhan")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LopHocPhan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maLopHocPhan")
    private long maLopHocPhan;
    private String tenLopHocPhan;
    private int soLuongToiDa;
    @Enumerated(EnumType.ORDINAL)
    private TrangThaiLop trangThaiLop;
    private String kiHoc;
    private double hocPhiTCTH;
    private double hocPhiTCLT;
    private int soTinChiTH;
    private int soTinChiLT;
    private int soLuongDaDangKy;
    @ManyToOne
    @JoinColumn(name = "maMonHoc")
    private MonHoc monHoc;
    @OneToMany(mappedBy = "lopHocPhan")
    private List<GiangVienLopHocPhan> giangVienLopHocPhans = new ArrayList<>();
    @OneToMany(mappedBy = "lopHocPhan")
    private List<BangDiem> bangDiems = new ArrayList<>();

    public LopHocPhan(String tenLopHocPhan, int soLuongToiDa, TrangThaiLop trangThaiLop, String kiHoc, double hocPhiTCTH, double hocPhiTCLT, int soTinChiTH, int soTinChiLT, int soLuongDaDangKy, MonHoc monHoc) {
        this.tenLopHocPhan = tenLopHocPhan;
        this.soLuongToiDa = soLuongToiDa;
        this.trangThaiLop = trangThaiLop;
        this.kiHoc = kiHoc;
        this.hocPhiTCTH = hocPhiTCTH;
        this.hocPhiTCLT = hocPhiTCLT;
        this.soTinChiTH = soTinChiTH;
        this.soTinChiLT = soTinChiLT;
        this.soLuongDaDangKy = soLuongDaDangKy;
        this.monHoc = monHoc;
    }

    @Override
    public String toString() {
        return "LopHocPhan{" +
                "maLopHocPhan=" + maLopHocPhan +
                ", tenLopHocPhan='" + tenLopHocPhan + '\'' +
                ", soLuongToiDa=" + soLuongToiDa +
                ", trangThaiLop=" + trangThaiLop +
                ", kiHoc='" + kiHoc + '\'' +
                ", hocPhiTCTH=" + hocPhiTCTH +
                ", hocPhiTCLT=" + hocPhiTCLT +
                ", soTinChiTH=" + soTinChiTH +
                ", soTinChiLT=" + soTinChiLT +
                ", soLuongDaDangKy=" + soLuongDaDangKy +
                ", monHoc=" + monHoc +
                '}';
    }
}
