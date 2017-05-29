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
public class MMaterial extends Model{
    protected static final String TABLE_NAME = "nguyen_lieu";
    protected int id;
    protected String Name;
    protected float inStock;
    protected String unit;
    protected float minInStock;

    public MMaterial() {
    }
    
    
    
    public MMaterial(int id, String Name, float inStock, String unit, float minInStock) {
        this.id = id;
        this.Name = Name;
        this.inStock = inStock;
        this.unit = unit;
        this.minInStock = minInStock;
    }

    public MMaterial(String Name, float inStock, String unit, float minInStock) {
        this.Name = Name;
        this.inStock = inStock;
        this.unit = unit;
        this.minInStock = minInStock;
    }
    public MMaterial(ModalData md){
        this.id = ((Long) md.get("MaNL")).intValue();
        this.Name = (String) md.get("TenNL");
        this.inStock = (Float) md.get("SoLuongTon");
        this.unit = (String) md.get("DonVi");
        this.minInStock = (Float) md.get("MucToiThieu");
    }
    
    public static MMaterial get(int id) throws SQLException{
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE MaNL = " + id;
        try {
            return new MMaterial(database.Database.modalSelect(sql));
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

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public float getInStock() {
        return inStock;
    }

    public void setInStock(float inStock) {
        this.inStock = inStock;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public float getMinInStock() {
        return minInStock;
    }

    public void setMinInStock(float minInStock) {
        this.minInStock = minInStock;
    }

    @Override
    public void insert() throws SQLException{
        insertData = new ModalData();
        insertData.put("TenNL", this.getName());
        insertData.put("SoLuongTon", this.getInStock());
        insertData.put("MucToiThieu", this.getMinInStock());
        insertData.put("DonVi", this.getUnit());
        try {
            Database.insert(getTableName(), insertData);
        } catch (SQLException e) {
            throw e;
        }
        
    }

    @Override
    public void update() throws SQLException {
        updateData = new ModalData();
        updateData.put("TenNL", this.getName());
        updateData.put("SoLuongTon", this.getInStock());
        updateData.put("MucToiThieu", this.getMinInStock());
        updateData.put("DonVi", this.getUnit());
        try {
            Database.update(getTableName(), updateData, "MaNL = " + this.getId());
        } catch (SQLException e) {
            throw e;
        }
        
    }
    
    @Override
    public void delete() throws SQLException{
        try {
            Database.delete(getTableName(), "MaNL = " + getId());
        } catch (SQLException e) {
            throw e;
        }
        
    }
    
    @Override
    String getTableName() {
        return TABLE_NAME;
    }
    
    
}
