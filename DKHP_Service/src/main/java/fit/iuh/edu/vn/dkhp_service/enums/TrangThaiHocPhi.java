package fit.iuh.edu.vn.dkhp_service.enums;

public enum TrangThaiHocPhi {
    DA_DONG(0), CHUA_DONG(1);
    private int value;

    TrangThaiHocPhi(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static TrangThaiHocPhi fromValue(int value) {
        for (TrangThaiHocPhi trangThaiHocPhi : TrangThaiHocPhi.values()) {
            if (trangThaiHocPhi.value == value) {
                return trangThaiHocPhi;
            }
        }
        throw new IllegalArgumentException("Không tim thấy trạng thái học phí tương ứng");
    }
}
