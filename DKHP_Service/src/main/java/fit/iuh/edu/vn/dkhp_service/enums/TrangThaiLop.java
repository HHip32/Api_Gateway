package fit.iuh.edu.vn.dkhp_service.enums;

public enum TrangThaiLop {
    DA_KHOA(0), CHO_SINH_VIEN_DANG_KY(1);
    private int value;

    TrangThaiLop(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static TrangThaiLop fromValue(int value) {
        for (TrangThaiLop trangThaiLop : TrangThaiLop.values()) {
            if (trangThaiLop.value == value) {
                return trangThaiLop;
            }
        }
        throw new IllegalArgumentException("Không tìm thấy trạng thái lớp tương ứng!");
    }
}
