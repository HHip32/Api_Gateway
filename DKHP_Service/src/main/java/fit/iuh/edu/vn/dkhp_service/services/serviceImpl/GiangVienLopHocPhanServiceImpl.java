package fit.iuh.edu.vn.dkhp_service.services.serviceImpl;

import fit.iuh.edu.vn.dkhp_service.entities.GiangVienLopHocPhan;
import fit.iuh.edu.vn.dkhp_service.repositories.GiangVienLopHocPhanRepository;
import fit.iuh.edu.vn.dkhp_service.services.GiangVienLopHocPhanService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GiangVienLopHocPhanServiceImpl implements GiangVienLopHocPhanService {
    private final GiangVienLopHocPhanRepository giangVienLopHocPhanRepository;


    @Override
    public Optional<GiangVienLopHocPhan> findGiangVienLopHocPhanByMaLopHP(long maLopHocPhan) {
        return giangVienLopHocPhanRepository.findByLopHocPhan_MaLopHocPhan(maLopHocPhan);
    }
}
