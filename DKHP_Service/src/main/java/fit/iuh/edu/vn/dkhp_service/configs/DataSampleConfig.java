package fit.iuh.edu.vn.dkhp_service.configs;


import fit.iuh.edu.vn.dkhp_service.entities.*;
import fit.iuh.edu.vn.dkhp_service.enums.*;
import fit.iuh.edu.vn.dkhp_service.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class DataSampleConfig {
    private final BangDiemRepository bangDiemRepository;
    private final ChuongTrinhKhungRepository chuongTrinhKhungRepository;
    private final GiangVienLopHocPhanRepository giangVienLopHocPhanRepository;
    private final GiangVienRepository giangVienRepository;
    private final KhoaHocRepository khoaHocRepository;
    private final KhoaRepository khoaRepository;
    private final LoaiSinhVienRepository loaiSinhVienRepository;
    private final LopHocDanhNghiaRepository lopHocDanhNghiaRepository;
    private final LopHocPhanRepository lopHocPhanRepository;
    private final MonHocChuongTrinhKhungRepository monHocChuongTrinhKhungRepository;
    private final MonHocRepository monHocRepository;
    private final MonHocTienQuyetRepository monHocTienQuyetRepository;
    private final NganhHocRepository nganhHocRepository;
    private final SinhVienRepository sinhVienRepository;

    //    @Bean
    CommandLineRunner test() {
        return args -> {
            List<MonHocChuongTrinhKhung> monHocChuongTrinhKhungs = monHocChuongTrinhKhungRepository.findMonHocChuongTrinhKhungByMssv(20111601);
            for (MonHocChuongTrinhKhung monHocChuongTrinhKhung : monHocChuongTrinhKhungs) {
                System.out.println("Môn học chương trình khung:" + monHocChuongTrinhKhung);
            }
        };
    }

    @Bean
    CommandLineRunner initDatabase() {
        return args -> {
            // insert Khoa
            Khoa khoaCNTT = new Khoa("Công nghệ thông tin");
            Khoa khoaKT = new Khoa("Tài chính");
            Khoa khoaLuat = new Khoa("Luật");
            khoaRepository.save(khoaCNTT);
            khoaRepository.save(khoaKT);
            khoaRepository.save(khoaLuat);
            // insert Nganh hoc
            NganhHoc nganhKTPM = new NganhHoc("Kỹ thuật phần mềm", khoaCNTT);
            NganhHoc nganhHTTT = new NganhHoc("Hệ thống thông tin", khoaCNTT);
            NganhHoc nganhATTT = new NganhHoc("An toàn thông tin", khoaCNTT);
            NganhHoc nganhKHDL = new NganhHoc("Khoa học dữ liệu", khoaCNTT);
            NganhHoc nganhHocKT = new NganhHoc("Tài chính ngân hàng", khoaKT);
            nganhHocRepository.save(nganhKTPM);
            nganhHocRepository.save(nganhHTTT);
            nganhHocRepository.save(nganhATTT);
            nganhHocRepository.save(nganhKHDL);
            nganhHocRepository.save(nganhHocKT);
            // insert Giang vien
            GiangVien gv1 = new GiangVien(
                    "Võ Văn Hải",
                    "TS",
                    "0339717894",
                    "666 Quang Trung, Gò vấp", "Nam",
                    LocalDateTime.of(1986, 6, 13, 0, 0),
                    khoaCNTT
            );
            GiangVien gv2 = new GiangVien(
                    "Nguyễn Tuấn Hiệp",
                    "Ths",
                    "0339717894",
                    "111 Quang Trung, Gò vấp", "Nam",
                    LocalDateTime.of(2002, 9, 18, 0, 0),
                    khoaKT
            );
            GiangVien gv3 = new GiangVien(
                    "Tôn Long Phước",
                    "TS",
                    "0339717899",
                    "111 Quang Trung, Gò vấp", "Nam",
                    LocalDateTime.of(1983, 2, 2, 0, 0),
                    khoaCNTT
            );
            GiangVien gv4 = new GiangVien(
                    "Nguyễn Thị Hoàng Khánh",
                    "TS",
                    "0339717891",
                    "222 Quang Trung, Gò vấp", "Nam",
                    LocalDateTime.of(1988, 6, 13, 0, 0),
                    khoaCNTT
            );
            giangVienRepository.save(gv1);
            giangVienRepository.save(gv2);
            giangVienRepository.save(gv3);
            giangVienRepository.save(gv4);
            // insert Khoa hoc
            KhoaHoc khoa16 = new KhoaHoc("K16", 2020);
            KhoaHoc khoa17 = new KhoaHoc("K17", 2021);
            KhoaHoc khoa18 = new KhoaHoc("K18", 2022);
            khoaHocRepository.save(khoa16);
            khoaHocRepository.save(khoa17);
            khoaHocRepository.save(khoa18);
            // insert Chuong trinh khung
            ChuongTrinhKhung chuongTrinhKhung1 = new ChuongTrinhKhung("9", nganhKTPM, khoa16);
            ChuongTrinhKhung chuongTrinhKhung2 = new ChuongTrinhKhung("9", nganhKTPM, khoa17);
            ChuongTrinhKhung chuongTrinhKhung3 = new ChuongTrinhKhung("9", nganhHocKT, khoa18);
            chuongTrinhKhungRepository.save(chuongTrinhKhung1);
            chuongTrinhKhungRepository.save(chuongTrinhKhung2);
            chuongTrinhKhungRepository.save(chuongTrinhKhung3);
            // insert Loai sinh vien
            LoaiSinhVien loaiSinhVien1 = new LoaiSinhVien(TenLoai.DANG_HOC);
            LoaiSinhVien loaiSinhVien2 = new LoaiSinhVien(TenLoai.THOI_HOC);
            LoaiSinhVien loaiSinhVien3 = new LoaiSinhVien(TenLoai.DA_TOT_NGHIEP);
            loaiSinhVienRepository.save(loaiSinhVien1);
            loaiSinhVienRepository.save(loaiSinhVien2);
            loaiSinhVienRepository.save(loaiSinhVien3);
            // insert Lop hoc danh nghia
            LopHocDanhNghia lopHocDanhNghia1 = new LopHocDanhNghia("DHKTPM16A",
                    BacDaoTao.DAI_HOC,
                    "Chính quy",
                    gv1,
                    nganhKTPM,
                    khoa16
            );
            LopHocDanhNghia lopHocDanhNghia2 = new LopHocDanhNghia("DKKTTC17B",
                    BacDaoTao.THAC_SI,
                    "Chính quy",
                    gv2,
                    nganhHocKT,
                    khoa17
            );
            LopHocDanhNghia lopHocDanhNghia3 = new LopHocDanhNghia("DKTPM17A",
                    BacDaoTao.DAI_HOC,
                    "Chính quy",
                    gv1,
                    nganhKTPM,
                    khoa17
            );
            lopHocDanhNghiaRepository.save(lopHocDanhNghia1);
            lopHocDanhNghiaRepository.save(lopHocDanhNghia2);
            lopHocDanhNghiaRepository.save(lopHocDanhNghia3);
            // insert Mon hoc
            MonHoc monHocLTHDT = new MonHoc("Lập trình hướng đối tượng", khoaCNTT);
            MonHoc monHocCTDLvaGT = new MonHoc("Cấu trúc dữ liệu và giải thuật", khoaCNTT);
            MonHoc monhocPTvaTKHT = new MonHoc("Phân tích và thiết kế hệ thống", khoaCNTT);
            MonHoc monhocCNM = new MonHoc("Công nghệ mới", khoaCNTT);
            MonHoc monHocWWW = new MonHoc("Lập trình WWW", khoaCNTT);

            MonHoc monHoc2 = new MonHoc("Luật kinh tế", khoaKT);
            monHocRepository.save(monHocLTHDT);
            monHocRepository.save(monHocCTDLvaGT);
            monHocRepository.save(monhocPTvaTKHT);
            monHocRepository.save(monhocCNM);
            monHocRepository.save(monHocWWW);
            monHocRepository.save(monHoc2);
            // insert Sinh vien
            SinhVien sv1 = new SinhVien(20111311,
                    "123456",
                    "Nguyễn Tuấn Hiệp",
                    LocalDateTime.of(2002, 9, 14, 0, 0),
                    "121 Quang Trung, Gò vấp ",
                    "Hải Phòng",
                    "0339717894",
                    "Nam",
                    "https://th.bing.com/th/id/R.e089a43cd9546701b048d2ab47bd45a9?rik=YUUjgVi2gtRQQw&pid=ImgRaw&r=0",
                    "bohiepdzai@gmail.com",
                    loaiSinhVien1,
                    lopHocDanhNghia1
            );
            SinhVien sv2 = new SinhVien(20111601,
                    "123456",
                    "Phan Nguyễn Hoài Hiệp",
                    LocalDateTime.of(2002, 6, 13, 0, 0),
                    "121 Lê Đức Thọ, Gò Vấp",
                    "Tây Ninh",
                    "0974067552",
                    "Nam",
                    "https://th.bing.com/th/id/OIP.mIf9ZAHku6YCPc4qT14avgHaK0?rs=1&pid=ImgDetMain",
                    "phhiep999@gmail.com",
                    loaiSinhVien1,
                    lopHocDanhNghia1
            );
            SinhVien sv3 = new SinhVien(20111999,
                    "123456",
                    "Phan Xích Long",
                    LocalDateTime.of(2002, 1, 1, 0, 0),
                    "121 Lê Đức Thọ, Gò Vấp",
                    "Tây Nguyên",
                    "0974067555",
                    "Nam",
                    "https://th.bing.com/th/id/R.06dfda1237b260bd72aa998b6679d0eb?rik=N0Phchug7q3nTg&pid=ImgRaw&r=0",
                    "phlong999@gmail.com",
                    loaiSinhVien1,
                    lopHocDanhNghia1
            );
            sinhVienRepository.save(sv1);
            sinhVienRepository.save(sv2);
            sinhVienRepository.save(sv3);
            // insert Lop hoc phan
            LopHocPhan lopHocPhan1 = new LopHocPhan("DHKTPM16C",
                    80,
                    TrangThaiLop.CHO_SINH_VIEN_DANG_KY,
                    "ki 1",
                    1200000,
                    900000,
                    1,
                    3,
                    18,
                    monHocLTHDT
            );
            LopHocPhan lopHocPhan2 = new LopHocPhan("DHKT17A",
                    80,
                    TrangThaiLop.CHO_SINH_VIEN_DANG_KY,
                    "ki 2",
                    800000,
                    900000,
                    1,
                    3,
                    18,
                    monHoc2
            );
            LopHocPhan lopHocPhan3 = new LopHocPhan("DHKTPM16D",
                    60,
                    TrangThaiLop.CHO_SINH_VIEN_DANG_KY,
                    "ki 1",
                    1200000,
                    300000,
                    1,
                    3,
                    50,
                    monHocCTDLvaGT
            );
            LopHocPhan lopHocPhan4 = new LopHocPhan("DHKTPM16E",
                    80,
                    TrangThaiLop.CHO_SINH_VIEN_DANG_KY,
                    "ki 1",
                    1500000,
                    500000,
                    1,
                    3,
                    20,
                    monHocWWW
            );
            LopHocPhan lopHocPhan5 = new LopHocPhan("DHKTPM16F",
                    80,
                    TrangThaiLop.CHO_SINH_VIEN_DANG_KY,
                    "ki 1",
                    900000,
                    500000,
                    1,
                    3,
                    50,
                    monhocCNM
            );
            lopHocPhanRepository.save(lopHocPhan1);
            lopHocPhanRepository.save(lopHocPhan2);
            lopHocPhanRepository.save(lopHocPhan3);
            lopHocPhanRepository.save(lopHocPhan4);
            lopHocPhanRepository.save(lopHocPhan5);
            // insert Bang diem
            BangDiem bangDiem1 = new BangDiem(7, 5, 4, 6, 7, TrangThai.DAT,
                    LocalDateTime.of(2023, 5, 14, 0, 0),
                    TrangThaiHocPhi.DA_DONG,
                    sv1,
                    lopHocPhan1
            );
            BangDiem bangDiem2 = new BangDiem(10, 9, 9, 9, 9, TrangThai.DAT,
                    LocalDateTime.of(2022, 7, 14, 0, 0),
                    TrangThaiHocPhi.DA_DONG,
                    sv2,
                    lopHocPhan1
            );
            bangDiemRepository.save(bangDiem1);
            bangDiemRepository.save(bangDiem2);
            // insert Mon hoc-Chuong trinh khung
            MonHocChuongTrinhKhung monHocChuongTrinhKhung1 = new MonHocChuongTrinhKhung(1,
                    LoaiMonHoc.BAT_BUOC,
                    1,
                    3,
                    monHocLTHDT,
                    chuongTrinhKhung1
            );
            MonHocChuongTrinhKhung monHocChuongTrinhKhung2 = new MonHocChuongTrinhKhung(1,
                    LoaiMonHoc.BAT_BUOC,
                    1,
                    3,
                    monHoc2,
                    chuongTrinhKhung2
            );
            MonHocChuongTrinhKhung monHocChuongTrinhKhung3 = new MonHocChuongTrinhKhung(1,
                    LoaiMonHoc.BAT_BUOC,
                    1,
                    3,
                    monHocCTDLvaGT,
                    chuongTrinhKhung1
            );
            MonHocChuongTrinhKhung monHocChuongTrinhKhung4 = new MonHocChuongTrinhKhung(1,
                    LoaiMonHoc.BAT_BUOC,
                    1,
                    3,
                    monhocPTvaTKHT,
                    chuongTrinhKhung1
            );
            MonHocChuongTrinhKhung monHocChuongTrinhKhung5 = new MonHocChuongTrinhKhung(1,
                    LoaiMonHoc.BAT_BUOC,
                    1,
                    3,
                    monHocWWW,
                    chuongTrinhKhung1
            );
            monHocChuongTrinhKhungRepository.save(monHocChuongTrinhKhung1);
            monHocChuongTrinhKhungRepository.save(monHocChuongTrinhKhung2);
            monHocChuongTrinhKhungRepository.save(monHocChuongTrinhKhung3);
            monHocChuongTrinhKhungRepository.save(monHocChuongTrinhKhung4);
            monHocChuongTrinhKhungRepository.save(monHocChuongTrinhKhung5);
            // insert Mon hoc tien quyet
            MonHocTienQuyet monHocTienQuyet1 = new MonHocTienQuyet(monHocLTHDT, monHocWWW);
            MonHocTienQuyet monHocTienQuyet2 = new MonHocTienQuyet(monHocLTHDT, monHocCTDLvaGT);
            monHocTienQuyetRepository.save(monHocTienQuyet1);
            monHocTienQuyetRepository.save(monHocTienQuyet2);
            // insert Giang Vien-Lop Hoc Phan
            GiangVienLopHocPhan giangVienLopHocPhan1 = new GiangVienLopHocPhan(
                    LoaiLichHoc.TH,
                    "Tructiep_X_2.02",
                    "Thứ 3(T7-9)",
                    LocalDateTime.of(2024, 6, 13, 2, 1),
                    1,
                    gv1,
                    lopHocPhan1
            );
            GiangVienLopHocPhan giangVienLopHocPhan2 = new GiangVienLopHocPhan(
                    LoaiLichHoc.LT,
                    "Tructuyen_Zoom_2888888_8888",
                    "Thứ 2(T1-3)",
                    LocalDateTime.of(2024, 6, 14, 2, 1),
                    2,
                    gv3,
                    lopHocPhan2
            );
            giangVienLopHocPhanRepository.save(giangVienLopHocPhan1);
            giangVienLopHocPhanRepository.save(giangVienLopHocPhan2);
//            "Tructuyen_Zoom_2888888_8888"
        };
    }
}