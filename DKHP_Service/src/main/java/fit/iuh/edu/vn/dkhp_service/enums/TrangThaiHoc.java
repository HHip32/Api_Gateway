package fit.iuh.edu.vn.dkhp_service.enums;

public enum TrangThaiHoc {
    HOC_LAI(0), HOC_MOI(1), HOC_CAI_THIEN(2);
    private int value;

    TrangThaiHoc(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static TrangThaiHoc fromValue(int value) {
        for (TrangThaiHoc trangThaiHoc : TrangThaiHoc.values()) {
            if (trangThaiHoc.value == value) {
                return trangThaiHoc;
            }
        }
        throw new IllegalArgumentException("Không tìm thấy trạng thái học tương ứng");
    }
}
