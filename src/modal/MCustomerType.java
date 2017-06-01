/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modal;

import java.sql.SQLException;

/**
 *
 * @author WINDNCC
 */
public class MCustomerType extends Model{
    int id;
    String name;
    String note;
    float minMoney;
    float percent;
    
    public MCustomerType(ModalData md) {
        this.id = ((Integer) md.get("MaLKH"));
        this.name = (String) md.get("TenLKH");
        this.note = (String) md.get("GhiChuLKH");
        this.minMoney = (Float) md.get("SoTienToiThieu");
        this.percent = (Float) md.get("PhanTramGiamGia");
    }

    public MCustomerType(int id, String name, String note, float minMoney, float percent) {
        this.id = id;
        this.name = name;
        this.note = note;
        this.minMoney = minMoney;
        this.percent = percent;
    }
    
    public static MCustomerType get(int id) throws SQLException{
        String sql = "SELECT * FROM loai_khach_hang WHERE MaLKH = " + id;
        System.out.println(sql);
        return new MCustomerType(database.Database.modalSelect(sql));
    }
    
    @Override
    void insert() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void update() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void delete() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    String getTableName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public float getMinMoney() {
        return minMoney;
    }

    public void setMinMoney(float minMoney) {
        this.minMoney = minMoney;
    }

    public float getPercent() {
        return percent;
    }

    public void setPercent(float percent) {
        this.percent = percent;
    }
    
}
