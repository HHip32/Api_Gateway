package fit.iuh.edu.vn.dkhp_service.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KhoaHoc_DTO {
    private long maKhoaHoc;
    private String tenKhoaHoc;
    private int namBatDauHoc;
}
