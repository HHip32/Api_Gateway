package fit.iuh.edu.vn.student_service.entities;

import fit.iuh.edu.vn.student_service.pks.MonHocTienQuyetPKs;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "MonHocTienQuyet")
@IdClass(MonHocTienQuyetPKs.class)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MonHocTienQuyet {

    @Id
    @ManyToOne
    @JoinColumn(name = "maMonHocTienQuyet")
    private MonHoc maMonHocTienQuyet;

    @Id
    @ManyToOne
    @JoinColumn(name = "maMonHoc")
    private MonHoc monHoc;

}
