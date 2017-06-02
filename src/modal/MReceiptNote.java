/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modal;

import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author khanhnguyen
 */
public class MReceiptNote extends Model{
    protected int id;
    protected int providerId;
    protected String date;
    protected float totalReceipt;
    protected int staffId;
    public static final String TABLE_NAME = "phieu_nhap_hang";
    public MReceiptNote() {
    }

    public MReceiptNote(int providerId, String date, float totalReceipt, int staffId) {
        this.providerId = providerId;
        this.date = date;
        this.totalReceipt = totalReceipt;
        this.staffId = staffId;
    }

    public MReceiptNote(int id, int providerId, String date, float totalReceipt, int staffId) {
        this.id = id;
        this.providerId = providerId;
        this.date = date;
        this.totalReceipt = totalReceipt;
        this.staffId = staffId;
        
    }
    public MReceiptNote(ModalData md) {
        this.id = ((Long) md.get("MaPNH")).intValue();
        providerId = ((Integer) md.get("MaNCC"));
        Date dat = (Date) md.get("NgayNhapHang");
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        date = df.format(dat);
        this.totalReceipt = (Float) md.get("TriGiaPNH");
        this.staffId = ((Integer) md.get("MaNV"));
    }

    public static MReceiptNote getLastReceiptNote() throws SQLException{
        String sql = "SELECT MaPNH, MaNCC, DATE(NgayNhapHang) as NgayNhapHang, TriGiaPNH, MaNV FROM phieu_nhap_hang WHERE MaPNH = (SELECT MAX(MaPNH) FROM phieu_nhap_hang)";
        try {
            return new MReceiptNote(database.Database.modalSelect(sql));
        } catch (SQLException e) {
            throw e;
        }
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

    public float getTotalReceipt() {
        return totalReceipt;
    }

    public void setTotalReceipt(float totalReceipt) {
        this.totalReceipt = totalReceipt;
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

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }
    
    
    @Override
    public void insert() throws SQLException {
        insertData = new ModalData();
        insertData.put("MaNCC", getProviderId());
        insertData.put("NgayNhapHang", getDate());
        insertData.put("TriGiaPNH", getTotalReceipt());
        insertData.put("MaNV", getStaffId());
        database.Database.insert(TABLE_NAME, insertData);
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
    
}
