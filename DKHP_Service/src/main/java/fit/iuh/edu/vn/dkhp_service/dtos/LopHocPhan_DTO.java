package fit.iuh.edu.vn.dkhp_service.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LopHocPhan_DTO {
    private long maLopHocPhan;
    private String tenLopHocPhan;
    private int soLuongToiDa;
    private String trangThaiLop;
    private String kiHoc;
    private MonHoc_DTO monHoc;
    private double hocPhiTCTH;
    private double hocPhiTCLT;
    private int soTinhChiTH;
    private int soTinhChiLT;
    private int soLuongDaDangKy;
}
