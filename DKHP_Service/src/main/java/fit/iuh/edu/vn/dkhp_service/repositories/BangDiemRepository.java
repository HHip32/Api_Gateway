package fit.iuh.edu.vn.dkhp_service.repositories;

import fit.iuh.edu.vn.dkhp_service.entities.BangDiem;
import fit.iuh.edu.vn.dkhp_service.pks.BangDiemPKs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BangDiemRepository extends JpaRepository<BangDiem, BangDiemPKs> {
}