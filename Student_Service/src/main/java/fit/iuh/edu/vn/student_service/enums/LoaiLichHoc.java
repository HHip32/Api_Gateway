package fit.iuh.edu.vn.student_service.enums;

public enum LoaiLichHoc {
    LT(0), TH(1);
    private int value;

    LoaiLichHoc(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static LoaiLichHoc fromValue(int value) {
        for (LoaiLichHoc loaiLichHoc : LoaiLichHoc.values()) {
            if (loaiLichHoc.value == value) {
                return loaiLichHoc;
            }
        }
        throw new IllegalArgumentException("Không tìm thấy loại lịch học tương ứng");
    }
}
