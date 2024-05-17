package fit.iuh.edu.vn.student_service.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SinhVien_DTO {
    private long mssv;
    private String matKhau;
    private String hoTen;
    private LocalDateTime ngaySinh;
    private String diaChi;
    private String queQuan;
    private String soDienThoai;
    private String gioiTinh;
    private String anhDaiDien;
    private String email;
    private long maLoaiSinhVien;
    private long maLopHocDanhNghia;
    private String tenLopHocDanhNghia;
    private String bacDaoTao;
    private String loaiHinhDaoTao;
    private long maKhoaHoc;
    private String tenKhoaHoc;
    private int namBatDauHoc;
    private long maNganhHoc;
    private String tenNganhHoc;
    private long maKhoa;
    private String tenKhoa;
}
