package fit.iuh.edu.vn.student_service.repositories;

import fit.iuh.edu.vn.student_service.entities.MonHocChuongTrinhKhung;
import fit.iuh.edu.vn.student_service.pks.MonHocChuongTrinhKhungPKs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MonHocChuongTrinhKhungRepository extends JpaRepository<MonHocChuongTrinhKhung, MonHocChuongTrinhKhungPKs> {
    @Query("select distinct mhctk from SinhVien sv \n" +
            " join LopHocDanhNghia lhdn on sv.lopHocDanhNghia.maLopHocDanhNghia = lhdn.maLopHocDanhNghia \n " +
            " join KhoaHoc kh on kh.maKhoaHoc = lhdn.khoaHoc.maKhoaHoc \n" +
            " join ChuongTrinhKhung ctk on ctk.khoaHoc.maKhoaHoc = kh.maKhoaHoc \n" +
            " join NganhHoc nh on nh.maNganhHoc = lhdn.nganhHoc.maNganhHoc \n" +
            " join MonHocChuongTrinhKhung mhctk on mhctk.chuongTrinhKhung.maChuongTrinhKhung = ctk.maChuongTrinhKhung \n" +
            " join MonHoc mh on mh.maMonHoc = mhctk.monHoc.maMonHoc \n" +
            " where ctk.maChuongTrinhKhung = mhctk.chuongTrinhKhung.maChuongTrinhKhung and \n" +
            "           mh.maMonHoc not in (select lhp.monHoc.maMonHoc from LopHocPhan lhp\n" +
            "                   join BangDiem bd on bd.lopHocPhan.maLopHocPhan = lhp.maLopHocPhan \n" +
            "                       where bd.sinhVien.mssv = ?1)\n "
    )
    List<MonHocChuongTrinhKhung> findMonHocChuongTrinhKhungByMssv(long mssv);
}