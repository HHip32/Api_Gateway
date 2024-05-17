package fit.iuh.edu.vn.student_service.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Khoa")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Khoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maKhoa")
    private long maKhoa;
    private String tenKhoa;

    public Khoa(String tenKhoa) {
        this.tenKhoa = tenKhoa;
    }
}
