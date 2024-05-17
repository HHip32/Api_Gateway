package fit.iuh.edu.vn.dkhp_service.services.serviceImpl;

import fit.iuh.edu.vn.dkhp_service.entities.MonHocChuongTrinhKhung;
import fit.iuh.edu.vn.dkhp_service.repositories.MonHocChuongTrinhKhungRepository;
import fit.iuh.edu.vn.dkhp_service.services.MonHocCTKService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MonHocCTKServiceImpl implements MonHocCTKService {
    private final MonHocChuongTrinhKhungRepository monHocChuongTrinhKhungRepository;

    @Override
    public List<MonHocChuongTrinhKhung> getMonHocCTKByMssv(long mssv) {
        return monHocChuongTrinhKhungRepository.findMonHocChuongTrinhKhungByMssv(mssv);
    }
}
