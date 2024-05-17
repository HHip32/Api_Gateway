package fit.iuh.edu.vn.student_service.controllers;

import fit.iuh.edu.vn.student_service.dtos.*;
import fit.iuh.edu.vn.student_service.entities.*;
import fit.iuh.edu.vn.student_service.services.SinhVienService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class SinhVienController {

    private final SinhVienService sinhVienService;

    @GetMapping("/getStudent")
    private ResponseEntity<SinhVien_DTO> getStudentById(@RequestParam Long mssv, @RequestParam String matKhau) {
        Optional<LopHocDanhNghia> lopHocDanhNghiaOptional = sinhVienService.findSinhVienByMssvAndMatkhau(mssv, matKhau);
        if (lopHocDanhNghiaOptional.isPresent()) {
            LopHocDanhNghia lopHocDanhNghia = lopHocDanhNghiaOptional.get();
            SinhVien_DTO sinhVien_dto = new SinhVien_DTO();
            int thuTuSinhVien = 0;
            if (!lopHocDanhNghia.getSinhViens().isEmpty()) {
                for (int i = 0; i < lopHocDanhNghia.getSinhViens().size(); i++) {
                    if (lopHocDanhNghia.getSinhViens().get(i).getMssv() == mssv) {
                        thuTuSinhVien = i;
                    }
                }
                String bacDaoTao = "";
                switch (lopHocDanhNghia.getBacDaoTao().getValue()) {
                    case 0 -> bacDaoTao += "Cao Đẳng";
                    case 1 -> bacDaoTao += "Đại Học";
                    case 2 -> bacDaoTao += "Thạc Sỹ";
                    case 3 -> bacDaoTao += "Liên Thông";
                }
                sinhVien_dto = new SinhVien_DTO(
                        lopHocDanhNghia.getSinhViens().get(thuTuSinhVien).getMssv(),
                        lopHocDanhNghia.getSinhViens().get(thuTuSinhVien).getMatKhau(),
                        lopHocDanhNghia.getSinhViens().get(thuTuSinhVien).getHoTen(),
                        lopHocDanhNghia.getSinhViens().get(thuTuSinhVien).getNgaySinh(),
                        lopHocDanhNghia.getSinhViens().get(thuTuSinhVien).getDiaChi(),
                        lopHocDanhNghia.getSinhViens().get(thuTuSinhVien).getQueQuan(),
                        lopHocDanhNghia.getSinhViens().get(thuTuSinhVien).getSoDienThoai(),
                        lopHocDanhNghia.getSinhViens().get(thuTuSinhVien).getGioiTinh(),
                        lopHocDanhNghia.getSinhViens().get(thuTuSinhVien).getAnhDaiDien(),
                        lopHocDanhNghia.getSinhViens().get(thuTuSinhVien).getEmail(),
                        lopHocDanhNghia.getSinhViens().get(thuTuSinhVien).getLoaiSinhVien().getMaLoaiSV(),
                        lopHocDanhNghia.getMaLopHocDanhNghia(),
                        lopHocDanhNghia.getTenLopHocDanhNghia(),
                        bacDaoTao,
                        lopHocDanhNghia.getLoaiHinhDaoTao(),
                        lopHocDanhNghia.getKhoaHoc().getMaKhoaHoc(),
                        lopHocDanhNghia.getKhoaHoc().getTenKhoaHoc(),
                        lopHocDanhNghia.getKhoaHoc().getNamBatDauHoc(),
                        lopHocDanhNghia.getNganhHoc().getMaNganhHoc(),
                        lopHocDanhNghia.getNganhHoc().getTenNganhHoc(),
                        lopHocDanhNghia.getNganhHoc().getKhoa().getMaKhoa(),
                        lopHocDanhNghia.getNganhHoc().getKhoa().getTenKhoa()
                );
            }
            return ResponseEntity.ok(sinhVien_dto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
