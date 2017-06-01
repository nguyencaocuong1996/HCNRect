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
    protected float couponDiscount;
    protected String startDate;
    protected String endDate;
    protected String note;

    public MCoupon() {
    }
    
    public MCoupon(ModalData md) {
        this.couponId = (String) md.get("MaPGG");
        this.couponDiscount = (Float) md.get("PhanTramGiamGia");
        this.startDate = (CDateTime.dateToString((Date) md.get("NgayBatDau")));
        this.startDate = (CDateTime.dateToString((Date) md.get("NgayKetThuc")));
    }
    
    public MCoupon(String couponId, float couponDiscount, String startDate, String endDate, String note) {
        this.couponId = couponId;
        this.couponDiscount = couponDiscount;
        this.startDate = startDate;
        this.endDate = endDate;
        this.note = note;
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
    
    
    
}
