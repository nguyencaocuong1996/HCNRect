/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modal;

import core.CDateTime;
import java.sql.SQLException;

/**
 *
 * @author WINDNCC
 */
public class MReceiptVoucherProvider extends Model{
    protected int id;
    protected int providerId;
    protected String date;
    protected float money;
    protected String note;
    protected int staffId;
    public static final String TABLE_NAME = "phieu_chi_ncc";

    public MReceiptVoucherProvider() {
    }
    
    public MReceiptVoucherProvider(ModalData md) {
        this.id = ((Long) md.get("MaPCNCC")).intValue();
        this.providerId = ((Long) md.get("MaNCC")).intValue();
        this.date = CDateTime.dateToString(((java.util.Date) md.get("NgayChi")));
        this.money = (Float) md.get("SoTienChi");
        this.note = (String) md.get("GhiChuPC");
        this.staffId = ((Long) md.get("MaNV")).intValue();
    }
    
    @Override
    public void insert() throws SQLException {
        insertData = new ModalData();
        insertData.put("MaNCC", getProviderId());
        insertData.put("NgayChi", getDate());
        insertData.put("SoTienChi", getMoney());
        insertData.put("GhiChuPC", getNote());
        insertData.put("MaNV", getStaffId());
        database.Database.insert(TABLE_NAME, insertData);
    }

    @Override
    public void update() throws SQLException {
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

    public int getProviderId() {
        return providerId;
    }

    public void setProviderId(int providerId) {
        this.providerId = providerId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }
    
}
