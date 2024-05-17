package fit.iuh.edu.vn.dkhp_service.entities;


import fit.iuh.edu.vn.dkhp_service.enums.TrangThai;
import fit.iuh.edu.vn.dkhp_service.enums.TrangThaiHocPhi;
import fit.iuh.edu.vn.dkhp_service.pks.BangDiemPKs;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "BangDiem")
@IdClass(BangDiemPKs.class)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BangDiem {
    private double diemGK;
    private double diemChuyenCan;
    private double diemTK;
    private double diemTH;
    private double diemCK;
    private double diemTongKet;
    private double diemThang4;
    private String diemChu;
    private String xepLoai;
    private String ghiChu;
    @Enumerated(EnumType.ORDINAL)
    private TrangThai trangThai;
    private LocalDateTime ngayDangKy;
    @Enumerated(EnumType.ORDINAL)
    private TrangThaiHocPhi trangThaiHocPhi;
    @Id
    @ManyToOne
    @JoinColumn(name = "mssv")
    private SinhVien sinhVien;

    @Id
    @ManyToOne
    @JoinColumn(name = "maLopHocPhan")
    private LopHocPhan lopHocPhan;

    public BangDiem(double diemGK, double diemChuyenCan, double diemTK, double diemTH, double diemCK, TrangThai trangThai, LocalDateTime ngayDangKy, TrangThaiHocPhi trangThaiHocPhi, SinhVien sinhVien, LopHocPhan lopHocPhan) {
        this.diemGK = diemGK;
        this.diemChuyenCan = diemChuyenCan;
        this.diemTK = diemTK;
        this.diemTH = diemTH;
        this.diemCK = diemCK;
        this.trangThai = trangThai;
        this.ngayDangKy = ngayDangKy;
        this.trangThaiHocPhi = trangThaiHocPhi;
        this.sinhVien = sinhVien;
        this.lopHocPhan = lopHocPhan;
    }
}
