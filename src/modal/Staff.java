/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modal;

import database.Database;
import java.util.HashMap;

/**
 *
 * @author WINDNCC
 */
public class Staff extends Model{
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
    void insert() {
        insertData = new HashMap();
        insertData.put("HoTenNV", this.getName());
        insertData.put("SDTNV", this.getPhone());
        insertData.put("DiaChiNV", this.getAddress());
        insertData.put("MaPB", this.getDepartmentId());
        Database.insert(getTableName(), insertData);
    }

    @Override
    void update() {
        updateData = new HashMap();
        updateData.put("HoTenNV", this.getName());
        updateData.put("SDTNV", this.getPhone());
        updateData.put("DiaChiNV", this.getAddress());
        updateData.put("MaPB", this.getDepartmentId());
        Database.update(getTableName(), updateData, "MaNV = " + getId());
    }
    
    @Override
    void delete(){
        Database.delete(getTableName(), "MaNV = " + getId());
    }
    
    @Override
    String getTableName() {
        return TABLE_NAME;
    }
    
}
