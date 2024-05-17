package fit.iuh.edu.vn.dkhp_service.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NganhHoc_DTO {
    private long maNganhHoc;
    private String tenNganhHoc;
    private long maKhoaHoc;

    public NganhHoc_DTO(long maNganhHoc, String tenNganhHoc) {
        this.maNganhHoc = maNganhHoc;
        this.tenNganhHoc = tenNganhHoc;
    }
}
