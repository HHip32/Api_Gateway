package fit.iuh.edu.vn.dkhp_service.services.serviceImpl;

import fit.iuh.edu.vn.dkhp_service.entities.LopHocPhan;
import fit.iuh.edu.vn.dkhp_service.repositories.LopHocPhanRepository;
import fit.iuh.edu.vn.dkhp_service.services.LopHocPhanService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LopHocPhanServiceImpl implements LopHocPhanService {

    private final LopHocPhanRepository lopHocPhanRepository;

    @Override
    public Optional<LopHocPhan> findLopHocPhanByMaMHAndKiHoc(long maMonHoc, String kiHoc) {
        return lopHocPhanRepository.findByMonHoc_MaMonHocAndKiHoc(maMonHoc, kiHoc);
    }
}
