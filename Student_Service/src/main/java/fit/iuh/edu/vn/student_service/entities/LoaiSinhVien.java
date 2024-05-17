package fit.iuh.edu.vn.student_service.entities;

import fit.iuh.edu.vn.student_service.enums.TenLoai;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "LoaiSinhVien")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class LoaiSinhVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maLoaiSV")
    private long maLoaiSV;
    @Enumerated(EnumType.ORDINAL)
    private TenLoai tenLoai;

    public LoaiSinhVien(TenLoai tenLoai) {
        this.tenLoai = tenLoai;
    }
}
