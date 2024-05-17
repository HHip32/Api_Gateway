package fit.iuh.edu.vn.dkhp_service.repositories;

import fit.iuh.edu.vn.dkhp_service.entities.LopHocPhan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface LopHocPhanRepository extends JpaRepository<LopHocPhan, Long> {
    @Query("select lhp from LopHocPhan lhp \n" +
            " where lhp.monHoc.maMonHoc = ?1 and lhp.kiHoc = ?2")
    Optional<LopHocPhan> findByMonHoc_MaMonHocAndKiHoc(long maMonHoc, String kiHoc);
}