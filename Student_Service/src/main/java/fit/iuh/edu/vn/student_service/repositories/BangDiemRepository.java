package fit.iuh.edu.vn.student_service.repositories;

import fit.iuh.edu.vn.student_service.entities.BangDiem;
import fit.iuh.edu.vn.student_service.pks.BangDiemPKs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BangDiemRepository extends JpaRepository<BangDiem, BangDiemPKs> {
}