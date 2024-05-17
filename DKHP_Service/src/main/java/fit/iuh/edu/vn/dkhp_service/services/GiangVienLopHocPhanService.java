package fit.iuh.edu.vn.dkhp_service.services;

import fit.iuh.edu.vn.dkhp_service.entities.GiangVienLopHocPhan;

import java.util.Optional;

public interface GiangVienLopHocPhanService {
    Optional<GiangVienLopHocPhan> findGiangVienLopHocPhanByMaLopHP(long maLopHocPhan);
}
