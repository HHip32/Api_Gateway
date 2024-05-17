package fit.iuh.edu.vn.dkhp_service.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MonHocCTK_DTO {
    private MonHoc_DTO monHoc;
    private ChuongTrinhKhung_DTO chuongTrinhKhung;
//    private List<MonHoc_DTO> monHocs;
//    private List<ChuongTrinhKhung_DTO> chuongTrinhKhungs;
    private int hocKy;
    private String loaiMonHoc;
    private int soTinChiLyThuyet;
    private int soTinChiThucHanh;
}
