package fit.iuh.edu.vn.dkhp_service.enums;

public enum TenLoai {
    DA_TOT_NGHIEP(0), THOI_HOC(1), DANG_HOC(2);
    private int value;

    TenLoai(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    public static TenLoai fromValue(int value){
        for(TenLoai tenLoai:TenLoai.values()){
            if(tenLoai.value == value){
                return tenLoai;
            }
        }
        throw new IllegalArgumentException("Không tìm thấy tên loại sinh viên với giá trị tương ứng!");
    }
}
