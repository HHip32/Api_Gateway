package fit.iuh.edu.vn.dkhp_service.repositories;

import fit.iuh.edu.vn.dkhp_service.entities.LopHocDanhNghia;
import fit.iuh.edu.vn.dkhp_service.entities.SinhVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface SinhVienRepository extends JpaRepository<SinhVien, Long> {
    @Query("select  lhdn " +
            "from SinhVien sv \n " +
            "join LopHocDanhNghia lhdn on lhdn.maLopHocDanhNghia = sv.lopHocDanhNghia.maLopHocDanhNghia \n" +
            " join  KhoaHoc kh on kh.maKhoaHoc = lhdn.khoaHoc.maKhoaHoc \n" +
            " join NganhHoc nh on nh.maNganhHoc = lhdn.nganhHoc.maNganhHoc \n" +
            " join Khoa k on k.maKhoa = nh.khoa.maKhoa \n" +
            " where sv.mssv = ?1 and sv.matKhau = ?2")
    Optional<LopHocDanhNghia> findByMssvAndMatKhau(long mssv, String matKhau);
}