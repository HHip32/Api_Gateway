package fit.iuh.edu.vn.dkhp_service.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GiangVien_DTO {
    private long maGiangVien;
    private String tenGiangVien;
    private String chucVu;
    private String soDienThoai;
    private String diaChi;
    private String gioiTinh;
    private LocalDateTime ngaySinh;
}
