package fit.iuh.edu.vn.dkhp_service.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChuongTrinhKhung_DTO {
    private long maChuongTrinhKhung;
    private NganhHoc_DTO nganhHoc;
    private KhoaHoc_DTO khoaHoc;
    private String thoiGianHoc;
}
