package fit.iuh.edu.vn.dkhp_service.repositories;

import fit.iuh.edu.vn.dkhp_service.entities.GiangVienLopHocPhan;
import fit.iuh.edu.vn.dkhp_service.pks.GiangVienLopHocPhanPKs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GiangVienLopHocPhanRepository extends JpaRepository<GiangVienLopHocPhan, GiangVienLopHocPhanPKs> {
    Optional<GiangVienLopHocPhan> findByLopHocPhan_MaLopHocPhan(long maLopHocPhan);
}