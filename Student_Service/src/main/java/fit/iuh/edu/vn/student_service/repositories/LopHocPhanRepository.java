package fit.iuh.edu.vn.student_service.repositories;

import fit.iuh.edu.vn.student_service.entities.LopHocPhan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface LopHocPhanRepository extends JpaRepository<LopHocPhan, Long> {
    @Query("select lhp from LopHocPhan lhp \n" +
            " where lhp.monHoc.maMonHoc = ?1 and lhp.kiHoc = ?2")
    Optional<LopHocPhan> findByMonHoc_MaMonHocAndKiHoc(long maMonHoc, String kiHoc);

    @Query("select lhp from SinhVien  sv \n" +
            " join BangDiem bd on bd.sinhVien.mssv = sv.mssv \n" +
            " join LopHocPhan lhp on lhp.maLopHocPhan = bd.lopHocPhan.maLopHocPhan \n" +
            " where sv.mssv = ?1 and lhp.kiHoc = ?2")
    Optional<LopHocPhan> findLopHocPhanByMsssAndKihoc(long mssv, String kiHoc);
}