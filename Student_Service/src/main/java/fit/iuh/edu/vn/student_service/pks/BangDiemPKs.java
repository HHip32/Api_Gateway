package fit.iuh.edu.vn.student_service.pks;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class BangDiemPKs implements Serializable {
    private long sinhVien;
    private long lopHocPhan;

}
