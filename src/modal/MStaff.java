/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modal;

import database.Database;
import java.sql.SQLException;
import java.util.HashMap;

/**
 *
 * @author WINDNCC
 */
public class MStaff extends Model{
    protected static final String TABLE_NAME = "nhan_vien";
    protected int id;
    protected String name;
    protected String phone;
    protected String address;
    protected int departmentId;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    void insert() throws SQLException {
        insertData = new ModalData();
        insertData.put("HoTenNV", this.getName());
        insertData.put("SDTNV", this.getPhone());
        insertData.put("DiaChiNV", this.getAddress());
        insertData.put("MaPB", this.getDepartmentId());
        try {
            Database.insert(getTableName(), insertData);
        } catch (SQLException e) {
            throw e;
        }
        
    }

    @Override
    void update() {
        updateData = new ModalData();
        updateData.put("HoTenNV", this.getName());
        updateData.put("SDTNV", this.getPhone());
        updateData.put("DiaChiNV", this.getAddress());
        updateData.put("MaPB", this.getDepartmentId());
        Database.update(getTableName(), updateData, "MaNV = " + getId());
    }
    
    @Override
    void delete() throws SQLException{
        try {
            Database.delete(getTableName(), "MaNV = " + getId());
        } catch (SQLException e) {
            throw e;
        }
        
    }
    
    @Override
    String getTableName() {
        return TABLE_NAME;
    }
    
}
