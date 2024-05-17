package fit.iuh.edu.vn.student_service.services;

import fit.iuh.edu.vn.student_service.dtos.SinhVien_DTO;
import fit.iuh.edu.vn.student_service.entities.LopHocDanhNghia;
import fit.iuh.edu.vn.student_service.entities.NganhHoc;

import java.util.Optional;

public interface SinhVienService {
    Optional<LopHocDanhNghia> findSinhVienByMssvAndMatkhau(long mssv, String matkhau);

}
