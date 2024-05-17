package fit.iuh.edu.vn.student_service.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "SinhVien")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SinhVien {
    @Id
    @Column(name = "mssv")
    private long mssv;
    @Column(name = "matKhau", length = 32)
    private String matKhau;
    @Column(name = "hoTen", length = 100)
    private String hoTen;
    @Column(name = "ngaySinh")
    private LocalDateTime ngaySinh;
    @Column(name = "diaChi")
    private String diaChi;
    @Column(name = "queQuan")
    private String queQuan;
    @Column(name = "soDienThoai")
    private String soDienThoai;
    @Column(name = "gioiTinh")
    private String gioiTinh;
    private String anhDaiDien;
    private String email;

    @ManyToOne
    @JoinColumn(name = "maLoaiSV")
    private LoaiSinhVien loaiSinhVien;
    @ManyToOne
    @JoinColumn(name = "maLopHocDanhNghia")
    private LopHocDanhNghia lopHocDanhNghia;
    @OneToMany(mappedBy = "sinhVien", fetch = FetchType.LAZY)
    private List<BangDiem> bangDiems = new ArrayList<>();
    public SinhVien(long mssv, String matKhau, String hoTen, LocalDateTime ngaySinh, String diaChi, String queQuan, String soDienThoai, String gioiTinh, String anhDaiDien, String email, LoaiSinhVien loaiSinhVien, LopHocDanhNghia lopHocDanhNghia) {
        this.mssv = mssv;
        this.matKhau = matKhau;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.queQuan = queQuan;
        this.soDienThoai = soDienThoai;
        this.gioiTinh = gioiTinh;
        this.anhDaiDien = anhDaiDien;
        this.email = email;
        this.loaiSinhVien = loaiSinhVien;
        this.lopHocDanhNghia = lopHocDanhNghia;
    }
}
