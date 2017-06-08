/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modal;

import database.Database;
import java.sql.SQLException;
import java.util.HashMap;
import view.VCustomerType;
import view.ViewData;

/**
 *
 * @author WINDNCC
 */
public class MCustomer extends Model{
    protected static final String TABLE_NAME = "khach_hang";
    private int id;
    private String fullName;
    private String phone;
    private int customerTypeId;
    private String address;

    public MCustomer() {
    }
    
    public MCustomer(int id) {
        this.id = id;
    }
    
    
    public MCustomer(int id, String fullName, String phone, int customerTypeId, String address) {
        this.id = id;
        this.fullName = fullName;
        this.phone = phone;
        this.customerTypeId = customerTypeId;
        this.address = address;
    }
    
    public MCustomer(String fullName, String phone, int customerTypeId, String address) {
        this.fullName = fullName;
        this.phone = phone;
        this.customerTypeId = customerTypeId;
        this.address = address;
    }
    public static void main(String[] args) {
        MCustomer c = MCustomer.getByID(7);
        c.updateCustomerType(0);
    }
    public void updateCustomerType(float totalBill){
        String sql = "SELECT SUM(hd.TriGiaThuc) AS TongChi FROM hoa_don AS hd" +
                        " INNER JOIN khach_hang AS kh ON kh.MaKH = hd.MaKH" +
                        " WHERE hd.MaKH = " + this.getId() + 
                        " GROUP BY hd.MaKH";
        try {
            ModalData md = database.Database.modalSelect(sql);
            float TongChi = 0;
            if(!md.isEmpty()){
                TongChi = ((Double) md.get("TongChi")).floatValue() + totalBill;
            } else {
                TongChi = totalBill;
            }
            float TongChi2 = TongChi;
            System.out.println("updateCustomerType in MCustomer.java Tổng số tiền mà " + this.getFullName() + " đã sử dụng tại nhà hàng " +TongChi2);
            ViewData vd = VCustomerType.getAllCustomerType().getData();
            vd.forEach((t) -> {
                float min = (float) t.get("SoTienToiThieu");
                int ctypeId = ((Integer) t.get("MaLKH"));
                if(TongChi2 >= min){
                    customerTypeId = ctypeId;
                }
            });
            this.update();
        } catch (SQLException e) {
        }
    }
    public static MCustomer getByModalData(ModalData md){
            Long id = (Long) md.get("MaKH");
            String fullName = (String) md.get("HoTenKH");
            String phone = (String) md.get("SDTKH");
            Long customerTypeId = (Long) md.get("MaLKH");
            String address = (String) md.get("DiaChiKH");
            return new MCustomer(id.intValue(), fullName, phone, customerTypeId.intValue(), address);
    }
    public static MCustomer getByID(int id){
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE `MaKH` = " + id;
        try {
            ModalData md = database.Database.modalSelect(query);
            if(md.size() > 0){
                return getByModalData(md);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new MCustomer();
    }
    public static MCustomer getByPhone(String phone){
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE `SDTKH` = '" + phone + "'";
        try {
            ModalData md = database.Database.modalSelect(query);
            if(md.size() > 0){
                return getByModalData(md);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new MCustomer();
    }
    public static MCustomer getLastCustomer(){
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE MaKH = (SELECT MAX(MaKH) FROM " + TABLE_NAME + ")";
        try {
            ModalData md = database.Database.modalSelect(query);
            if(md.size() > 0){
                return getByModalData(md);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new MCustomer();
    }
    @Override
    public void insert() throws SQLException{
        insertData = new ModalData();
        insertData.put("HoTenKH", getFullName());
        insertData.put("SDTKH", getPhone());
        insertData.put("MaLKH", getCustomerTypeId());
        insertData.put("DiaChiKH", getAddress());
        System.out.println(insertData.get("SDTKH"));
        try {
            database.Database.insert(getTableName(), insertData);
        } catch (SQLException e) {
            throw e;
        }
        
    }

    @Override
    public void update()throws SQLException {
       updateData = new ModalData();
        updateData.put("HoTenKH", this.getFullName());
        updateData.put("SDTKH", this.getPhone());
        updateData.put("DiaChiKH", this.getAddress());
        updateData.put("MaLKH", this.getCustomerTypeId());
        try {
            Database.update(getTableName(), updateData, "MaKH = " + getId());
        } catch (SQLException e) {
            throw e;
        }
        
    }

    @Override
    public void delete() throws SQLException{
        try {
            Database.delete(getTableName(), "MaKH = " + getId());
        } catch (SQLException e) {
            throw e;
        }
        
    }

    @Override
    String getTableName() {
        return TABLE_NAME;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getCustomerTypeId() {
        return customerTypeId;
    }

    public void setCustomerTypeId(int customerTypeId) {
        this.customerTypeId = customerTypeId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    
    
}
