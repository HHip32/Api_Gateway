package fit.iuh.edu.vn.student_service.enums;

public enum BacDaoTao {
    CAO_DANG(0), DAI_HOC(1), THAC_SI(2), LIEN_THONG(3);
    private int value;

    BacDaoTao(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static BacDaoTao fromValue(int value) {
        for (BacDaoTao bacDaoTao : BacDaoTao.values()) {
            if (bacDaoTao.value == value) {
                return bacDaoTao;
            }
        }
        throw new IllegalArgumentException("Không tìm thấy bậc đào tạo tương ứng!");
    }
}
