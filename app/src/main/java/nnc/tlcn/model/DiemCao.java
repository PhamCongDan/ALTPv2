package nnc.tlcn.model;

/**
 * Created by Dan Pham on 01/01/2018.
 */

public class DiemCao {
    int id;
    String ten;
    String diem;

    public DiemCao() {
    }

    public DiemCao(int id, String ten, String diem) {
        this.id = id;
        this.ten = ten;
        this.diem = diem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiem() {
        return diem;
    }

    public void setDiem(String diem) {
        this.diem = diem;
    }
}
