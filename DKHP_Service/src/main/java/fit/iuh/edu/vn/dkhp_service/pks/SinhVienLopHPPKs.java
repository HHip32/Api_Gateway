package fit.iuh.edu.vn.dkhp_service.pks;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class SinhVienLopHPPKs implements Serializable {
    private long sinhVien;
    private long lopHocPhan;
}
