package fit.iuh.edu.vn.student_service.enums;

public enum LoaiMonHoc {
    BAT_BUOC(0), TUY_CHON(1);
    private int value;

    LoaiMonHoc(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static LoaiMonHoc fromValue(int value) {
        for (LoaiMonHoc loaiMonHoc : LoaiMonHoc.values()) {
            if (loaiMonHoc.value == value) {
                return loaiMonHoc;
            }
        }
        throw new IllegalArgumentException("Không tìm thấy loại môn học tương ứng!");
    }
}
