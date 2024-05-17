package fit.iuh.edu.vn.student_service.pks;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class GiangVienLopHocPhanPKs implements Serializable {
    private long giangVien;
    private long lopHocPhan;
}
