package fit.iuh.edu.vn.dkhp_service.services;

import fit.iuh.edu.vn.dkhp_service.entities.LopHocPhan;

import java.util.Optional;

public interface LopHocPhanService {
    Optional<LopHocPhan> findLopHocPhanByMaMHAndKiHoc(long maMonHoc, String kiHoc);
}
