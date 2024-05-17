package fit.iuh.edu.vn.dkhp_service.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GiangVienLopHocPhan_DTO {
    private GiangVien_DTO giangVien;
    private long maLopHocPhan;
    private String loaiLichHoc;
    private String viTri;
    private String lichHoc;
    private LocalDateTime thoiGian;
    private int nhomTH;
}
