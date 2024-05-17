package fit.iuh.edu.vn.dkhp_service.entities;

import fit.iuh.edu.vn.dkhp_service.enums.LoaiLichHoc;
import fit.iuh.edu.vn.dkhp_service.pks.GiangVienLopHocPhanPKs;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@Table(name = "GiangVienLopHocPhan")
@IdClass(GiangVienLopHocPhanPKs.class)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class GiangVienLopHocPhan {
    @Enumerated(EnumType.ORDINAL)
    private LoaiLichHoc loaiLichHoc;
    private String viTri;
    private String lichHoc;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDateTime thoiGian;
    private int nhomTH;
    @Id
    @ManyToOne
    @JoinColumn(name = "maGiangVien")
    private GiangVien giangVien;
    @Id
    @ManyToOne
    @JoinColumn(name = "maLopHocPhan")
    private LopHocPhan lopHocPhan;
}
