/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modal;

import database.Database;
import java.sql.SQLException;

/**
 *
 * @author WINDNCC
 */
public class MProvider extends Model{
    protected static final String TABLE_NAME = "nha_cung_cap";
    protected int id;
    protected String name;
    protected String phone;
    protected String address;
    protected String description;

    public MProvider() {
    }

    public MProvider(ModalData md) {
        this.id = ((Long) md.get("MaNCC")).intValue();
        this.name = (String) md.get("TenNCC");
        this.phone = (String) md.get("SDTNCC");
        this.address = (String) md.get("DiaChiNCC");
        this.description = (String) md.get("MoTaNCC");
    }

     public MProvider(int id) {
        this.id = id;
    }
    
    public MProvider(int id, String name, String phone, String address, String description) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.description = description;
    }

    public MProvider(String name, String phone, String address, String description) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.description = description;
    }
    public static MProvider get(int id) throws SQLException{
        String sql = "SELECT * FROM nha_cung_cap WHERE MaNCC = " + id;
        ModalData md = database.Database.modalSelect(sql);
        return new MProvider(md);
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
     @Override
    public void insert() throws SQLException {
        insertData = new ModalData();
        insertData.put("TenNCC", this.getName());
        insertData.put("SDTNCC", this.getPhone());
        insertData.put("DiaChiNCC", this.getAddress());
        insertData.put("MoTaNCC", this.getDescription());
        try {
            Database.insert(getTableName(), insertData);
        } catch (SQLException e) {
            throw e;
        }
        
    }

    @Override
    public void update() throws SQLException {
        updateData = new ModalData();
        updateData.put("TenNCC", this.getName());
        updateData.put("SDTNCC", this.getPhone());
        updateData.put("DiaChiNCC", this.getAddress());
        updateData.put("MoTaNCC", this.getDescription());
        try {
            Database.update(getTableName(), updateData, "MaNCC = " + getId());
        } catch (SQLException e) {
            throw e;
        }
        
    }
    
    @Override
    public void delete() throws SQLException{
        try {
            Database.delete(getTableName(), "MaNCC = " + getId());
        } catch (SQLException e) {
            throw e;
        }
        
    }
    
    @Override
    String getTableName() {
        return TABLE_NAME;
    }
}
