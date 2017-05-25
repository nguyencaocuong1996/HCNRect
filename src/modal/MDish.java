/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modal;

import java.util.HashMap;
import database.Database;
import java.sql.SQLException;
/**
 *
 * @author WINDNCC
 */
public class MDish extends Model{
    protected static final String TABLE_NAME = "mon_an";
    private int id;
    private String name;
    private Float price;
    private String imageUrl;

    public MDish(int id, String name, Float price, String imageUrl) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
    }
    
    public MDish(String name, Float price, String imageUrl) {
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
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

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    void insert() throws SQLException{
        insertData = new ModalData();
        insertData.put("TenMA", this.getName());
        insertData.put("GiaMA", this.getPrice());
        insertData.put("DiaChiAnhMA", this.getImageUrl());
        Database.insert(getTableName(), insertData);
    }

    @Override
    public void update() throws SQLException{
        updateData = new ModalData();
        updateData.put("TenMA", this.getName());
        updateData.put("GiaMA", this.getPrice());
        updateData.put("DiaChiAnhMA", this.getImageUrl());
        try {
            Database.update(getTableName(), updateData, "MaMA = " + getId());
        } catch (SQLException e) {
            throw e;
        }
        
    }

    @Override
    public void delete() throws SQLException{
        try {
            Database.delete(getTableName(), "MaMA = " + getId());
        } catch (SQLException e) {
            throw e;
        }
        
    }
    @Override
    String getTableName() {
        return TABLE_NAME;
    }
    
    
}
