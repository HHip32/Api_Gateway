package fit.iuh.edu.vn.dkhp_service.controllers;

import fit.iuh.edu.vn.dkhp_service.dtos.*;
import fit.iuh.edu.vn.dkhp_service.entities.*;
import fit.iuh.edu.vn.dkhp_service.services.GiangVienLopHocPhanService;
import fit.iuh.edu.vn.dkhp_service.services.LopHocPhanService;
import fit.iuh.edu.vn.dkhp_service.services.MonHocCTKService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class DangKyHocPhanController {

    private final MonHocCTKService monHocCTKService;
    private final LopHocPhanService lopHocPhanService;
    private final GiangVienLopHocPhanService giangVienLopHocPhanService;

    @GetMapping("/getMonHocCTK")
    private ResponseEntity<List<MonHocCTK_DTO>> getMonHocCTK(@RequestParam long mssv) {
        List<MonHocChuongTrinhKhung> monHocChuongTrinhKhungList = monHocCTKService.getMonHocCTKByMssv(mssv);
        if (!monHocChuongTrinhKhungList.isEmpty()) {
            List<MonHocCTK_DTO> monHocCTK_dtos = new ArrayList<>();
            for (MonHocChuongTrinhKhung monHocChuongTrinhKhung : monHocChuongTrinhKhungList) {
                String loaiMonHoc = "";
                switch (monHocChuongTrinhKhung.getLoaiMonHoc().getValue()) {
                    case 0 -> loaiMonHoc += "Bắt buộc";
                    case 1 -> loaiMonHoc += "Tùy chọn";
                }
                MonHoc_DTO monHocDto;
                if (!monHocChuongTrinhKhung.getMonHoc().getMonHocTienQuyets().isEmpty()) {
                    monHocDto = new MonHoc_DTO(monHocChuongTrinhKhung.getMonHoc().getMaMonHoc(),
                            monHocChuongTrinhKhung.getMonHoc().getTenMonHoc(),
                            monHocChuongTrinhKhung.getChuongTrinhKhung().getKhoaHoc().getMaKhoaHoc(),
                            monHocChuongTrinhKhung.getMonHoc().getMonHocTienQuyets().get(0).getMaMonHocTienQuyet().getMaMonHoc()
                    );
                } else {
                    monHocDto = new MonHoc_DTO(monHocChuongTrinhKhung.getMonHoc().getMaMonHoc(),
                            monHocChuongTrinhKhung.getMonHoc().getTenMonHoc(),
                            monHocChuongTrinhKhung.getChuongTrinhKhung().getKhoaHoc().getMaKhoaHoc());
                }
                NganhHoc_DTO nganhHoc_dto = new NganhHoc_DTO(
                        monHocChuongTrinhKhung.getChuongTrinhKhung().getNganhHoc().getMaNganhHoc(),
                        monHocChuongTrinhKhung.getChuongTrinhKhung().getNganhHoc().getTenNganhHoc()
                );
                KhoaHoc_DTO khoaHoc_dto = new KhoaHoc_DTO(monHocChuongTrinhKhung.getChuongTrinhKhung().getKhoaHoc().getMaKhoaHoc(),
                        monHocChuongTrinhKhung.getChuongTrinhKhung().getKhoaHoc().getTenKhoaHoc(),
                        monHocChuongTrinhKhung.getChuongTrinhKhung().getKhoaHoc().getNamBatDauHoc()
                );
                ChuongTrinhKhung_DTO chuongTrinhKhung_dto = new ChuongTrinhKhung_DTO(monHocChuongTrinhKhung.getChuongTrinhKhung().getMaChuongTrinhKhung(),
                        nganhHoc_dto,
                        khoaHoc_dto,
                        monHocChuongTrinhKhung.getChuongTrinhKhung().getThoiGianHoc()
                );
                MonHocCTK_DTO monHocCTK_dto = new MonHocCTK_DTO(monHocDto,
                        chuongTrinhKhung_dto,
                        monHocChuongTrinhKhung.getHocKy(),
                        loaiMonHoc,
                        monHocChuongTrinhKhung.getSoTinChiLyThuyet(),
                        monHocChuongTrinhKhung.getSoTinChiThucHanh()
                );
                monHocCTK_dtos.add(monHocCTK_dto);
            }
            return ResponseEntity.ok(monHocCTK_dtos);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/getLopHocPhan")
    private ResponseEntity<LopHocPhan_DTO> getLopHocPhan(@RequestParam long maMonHoc, @RequestParam String kiHoc) {
        Optional<LopHocPhan> optionalLopHocPhan = lopHocPhanService.findLopHocPhanByMaMHAndKiHoc(maMonHoc, kiHoc);
        if (optionalLopHocPhan.isPresent()) {
            LopHocPhan lopHocPhan = optionalLopHocPhan.get();
            String trangThaiLop = "";
            switch (lopHocPhan.getTrangThaiLop().getValue()) {
                case 0 -> trangThaiLop += "Đã khóa";
                case 1 -> trangThaiLop += "Chờ sinh viên đăng ký";
            }
            MonHoc_DTO monHoc_dto = new MonHoc_DTO(lopHocPhan.getMonHoc().getMaMonHoc(),
                    lopHocPhan.getMonHoc().getTenMonHoc(),
                    lopHocPhan.getMonHoc().getKhoa().getMaKhoa()
            );
            LopHocPhan_DTO lopHocPhan_dto = new LopHocPhan_DTO(
                    lopHocPhan.getMaLopHocPhan(),
                    lopHocPhan.getTenLopHocPhan(),
                    lopHocPhan.getSoLuongToiDa(),
                    trangThaiLop,
                    lopHocPhan.getKiHoc(),
                    monHoc_dto,
                    lopHocPhan.getHocPhiTCTH(),
                    lopHocPhan.getHocPhiTCLT(),
                    lopHocPhan.getSoTinChiTH(),
                    lopHocPhan.getSoTinChiLT(),
                    lopHocPhan.getSoLuongDaDangKy()
            );
            return ResponseEntity.ok(lopHocPhan_dto);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/getGiangVienLopHP")
    private ResponseEntity<GiangVienLopHocPhan_DTO> getGiangVienLopHocPhan(long maLopHocPhan) {
        Optional<GiangVienLopHocPhan> optionalGiangVienLopHocPhan = giangVienLopHocPhanService.findGiangVienLopHocPhanByMaLopHP(maLopHocPhan);
        if (optionalGiangVienLopHocPhan.isPresent()) {
            GiangVienLopHocPhan giangVienLopHocPhan = optionalGiangVienLopHocPhan.get();
            GiangVien_DTO giangVien_dto = new GiangVien_DTO(giangVienLopHocPhan.getGiangVien().getMaGiangVien(),
                    giangVienLopHocPhan.getGiangVien().getTenGiangVien(),
                    giangVienLopHocPhan.getGiangVien().getChucVu(),
                    giangVienLopHocPhan.getGiangVien().getSoDienThoai(),
                    giangVienLopHocPhan.getGiangVien().getDiaChi(),
                    giangVienLopHocPhan.getGiangVien().getGioiTinh(),
                    giangVienLopHocPhan.getGiangVien().getNgaySinh()
            );
            String loaiLichHoc = "";
            switch (giangVienLopHocPhan.getLoaiLichHoc().getValue()) {
                case 0 -> loaiLichHoc += "LT";
                case 1 -> loaiLichHoc += "TH";
            }

            GiangVienLopHocPhan_DTO giangVienLopHocPhan_dto = new GiangVienLopHocPhan_DTO(
                    giangVien_dto,
                    giangVienLopHocPhan.getLopHocPhan().getMaLopHocPhan(),
                    loaiLichHoc,
                    giangVienLopHocPhan.getViTri(),
                    giangVienLopHocPhan.getLichHoc(),
                    giangVienLopHocPhan.getThoiGian(),
                    giangVienLopHocPhan.getNhomTH()
            );
            return ResponseEntity.ok(giangVienLopHocPhan_dto);
        }
        return ResponseEntity.notFound().build();
    }
}
