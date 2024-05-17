package fit.iuh.edu.vn.student_service.enums;

public enum TrangThai {
    DAT(0), KHONG_DAT(1);
    private int value;

    TrangThai(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static TrangThai fromValue(int value) {
        for (TrangThai trangThai : TrangThai.values()) {
            if (trangThai.value == value) {
                return trangThai;
            }
        }
        throw new IllegalArgumentException("Không tìm thấy trạng thái tương ứng!");
    }
}
