/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modal;

import core.CDateTime;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author WINDNCC
 */
public class MCoupon extends Model{
    protected String couponId;
    protected String oldId;
    protected float couponDiscount;
    protected String startDate;
    protected String endDate;
    protected String note;
    public static final String TABLE_NAME = "phieu_khuyen_mai";
    
    public MCoupon() {
    }
    
    public MCoupon(ModalData md) {
        this.couponId = (String) md.get("MaPGG");
        this.oldId = this.couponId;
        this.couponDiscount = (Float) md.get("PhanTramGiamGia");
        this.startDate = (CDateTime.dateToString((Date) md.get("NgayBatDau")));
        this.startDate = (CDateTime.dateToString((Date) md.get("NgayKetThuc")));
    }
    
    public MCoupon(String couponId, float couponDiscount, String startDate, String endDate, String note) {
        this.couponId = couponId;
        this.oldId = this.couponId;
        this.couponDiscount = couponDiscount;
        this.startDate = startDate;
        this.endDate = endDate;
        this.note = note;
    }
    
    @Override
    public void insert() throws SQLException {
        insertData = new ModalData();
        insertData.put("MaPGG", this.getCouponId());
        insertData.put("NgayBatDau", this.getStartDate());
        insertData.put("NgayKetThuc", this.getEndDate());
        insertData.put("GhiChuPGG", this.getNote());
        insertData.put("PhanTramGiamGia", this.getCouponDiscount());
//        System.out.println(updateData);
        database.Database.insert(TABLE_NAME, insertData);
    }

    @Override
    public void update() throws SQLException {
        updateData = new ModalData();
        updateData.put("MaPGG", this.getCouponId());
        updateData.put("NgayBatDau", this.getStartDate());
        updateData.put("NgayKetThuc", this.getEndDate());
        updateData.put("GhiChuPGG", this.getNote());
        updateData.put("PhanTramGiamGia", this.getCouponDiscount());
//        System.out.println(updateData);
        database.Database.update(TABLE_NAME, updateData, "MAPGG = '"  + this.getOldId() +"'" );
    }

    @Override
    public void delete() throws SQLException {
        database.Database.delete(TABLE_NAME, "MAPGG = '" + this.getCouponId() + "'");
    }

    @Override
    String getTableName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }

    public float getCouponDiscount() {
        return couponDiscount;
    }

    public void setCouponDiscount(float couponDiscount) {
        this.couponDiscount = couponDiscount;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getOldId() {
        return oldId;
    }

    public void setOldId(String oldId) {
        this.oldId = oldId;
    }
    
    
    
}
