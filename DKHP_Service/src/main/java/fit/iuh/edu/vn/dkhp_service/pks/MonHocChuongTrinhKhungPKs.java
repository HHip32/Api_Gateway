package fit.iuh.edu.vn.dkhp_service.pks;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class MonHocChuongTrinhKhungPKs implements Serializable {
    private long monHoc;
    private long chuongTrinhKhung;
}
