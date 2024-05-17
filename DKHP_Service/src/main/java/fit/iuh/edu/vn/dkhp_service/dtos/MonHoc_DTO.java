package fit.iuh.edu.vn.dkhp_service.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class MonHoc_DTO {
    private long maMonHoc;
    private String tenMonHoc;
    private long maKhoa;
    private long maMonTQ;

    public MonHoc_DTO(long maMonHoc, String tenMonHoc, long maKhoa) {
        this.maMonHoc = maMonHoc;
        this.tenMonHoc = tenMonHoc;
        this.maKhoa = maKhoa;
    }
}
