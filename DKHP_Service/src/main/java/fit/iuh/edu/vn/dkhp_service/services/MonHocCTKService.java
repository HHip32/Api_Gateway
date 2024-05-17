package fit.iuh.edu.vn.dkhp_service.services;

import fit.iuh.edu.vn.dkhp_service.entities.MonHocChuongTrinhKhung;

import java.util.List;

public interface MonHocCTKService {
    List<MonHocChuongTrinhKhung> getMonHocCTKByMssv(long mssv);
}
