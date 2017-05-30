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
    protected float payAmount;
    public MReceiptNote() {
    }

    public MReceiptNote(int providerId, String date, float totalReceipt, float payAmount) {
        this.providerId = providerId;
        this.date = date;
        this.totalReceipt = totalReceipt;
        this.payAmount = payAmount;
    }

    public MReceiptNote(int id, int providerId, String date, float totalReceipt) {
        this.id = id;
        this.providerId = providerId;
        this.date = date;
        this.totalReceipt = totalReceipt;
        
    }
    public MReceiptNote(ModalData md) {
        this.id = ((Long) md.get("MaPNH")).intValue();
        providerId = ((Integer) md.get("MaNCC"));
        Date dat = (Date) md.get("NgayNhapHang");
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        date = df.format(dat);
        this.totalReceipt = (Float) md.get("TriGiaPNH");
    }

    public static MReceiptNote getLastReceiptNote() throws SQLException{
        String sql = "SELECT MaPNH, MaNCC, DATE(NgayNhapHang) as NgayNhapHang, TriGiaPNH, SoTienDaTra FROM phieu_nhap_hang WHERE MaPNH = (SELECT MAX(MaPNH) FROM phieu_nhap_hang)";
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

    public float getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(float payAmount) {
        this.payAmount = payAmount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    
    @Override
    public void insert() throws SQLException {
        InsertData insertD = new InsertData(this);
        insertD.execute();
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
