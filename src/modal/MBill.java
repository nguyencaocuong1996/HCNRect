/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modal;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author WINDNCC
 */
public class MBill extends Model{
    public static final String TABLE_NAME = "hoa_don";
    protected int id;
    protected int customerId;
    protected int staffId;
    protected int tableId;
    protected String dateTimeBill;
    protected float totalBill;

    public MBill() {
    }

    public MBill(ModalData md) {
        id = ((Long) md.get("MaHD")).intValue();
        customerId = ((Long) md.get("MaKH")).intValue();
        staffId = ((Long) md.get("MaNV")).intValue();
        tableId = (Integer) md.get("MaBan");
        Timestamp ts = ((Timestamp) md.get("NgayLapHD"));
        Date date = new Date(ts.getTime());
        dateTimeBill = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        totalBill = (float) md.get("TriGiaHD");
    }
    public static MBill getLastBill() throws SQLException{
        String sql = "SELECT * FROM hoa_don WHERE MaHD = (SELECT MAX(MAHD) FROM hoa_don)";
        try {
            ModalData md = database.Database.modalSelect(sql);
            return new MBill(md);
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

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getDateTimeBill() {
        return dateTimeBill;
    }

    public void setDateTimeBill(String dateTimeBill) {
        this.dateTimeBill = dateTimeBill;
    }

    public float getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(float totalBill) {
        this.totalBill = totalBill;
    }
    
    @Override
    public void insert() throws SQLException {
        insertData = new ModalData();
        insertData.put("MaKH", getCustomerId());
        insertData.put("MaNV", getStaffId());
        insertData.put("NgayLapHD", getDateTimeBill());
        insertData.put("TriGiaHD", getTotalBill());
        insertData.put("MaBan", getTableId());
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
    public static void main(String[] args) {
        try {
            MBill mbill = MBill.getLastBill();
        System.out.println(mbill.dateTimeBill);
        } catch (Exception e) {
            return;
        }
        
    }
}
