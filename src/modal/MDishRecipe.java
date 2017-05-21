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
public class MDishRecipe extends Model{
    protected static final String TABLE_NAME = "cong_thuc";
    protected String dishId;
    protected String materialId;
    protected String qty;
    protected String note;

    public MDishRecipe(String dishId, String materialId, String qty, String note) {
        this.dishId = dishId;
        this.materialId = materialId;
        this.qty = qty;
        this.note = note;
    }

    public String getDishId() {
        return dishId;
    }

    public void setDishId(String dishId) {
        this.dishId = dishId;
    }

    public String getMaterialId() {
        return materialId;
    }

    public void setMaterialId(String materialId) {
        this.materialId = materialId;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    void insert() throws SQLException{
        insertData = new ModalData();
        insertData.put("MaMA", this.getDishId());
        insertData.put("MaNL", this.getMaterialId());
        insertData.put("LuongCan", this.getQty());
        insertData.put("GhiChu", this.getNote());
        Database.insert(getTableName(), insertData);
    }

    @Override
    void update(){
        updateData = new ModalData();
        updateData.put("LuongCan", this.getQty());
        updateData.put("GhiChu", this.getNote());
        Database.update(getTableName(), updateData, "MaNL = " + this.getMaterialId() + " AND MaMA = " + this.getDishId());
    }
    @Override
    public void delete(){
        Database.delete(getTableName(), "MaMA = " + getDishId() + " AND MaNL = " + getMaterialId());
    }
    @Override
    String getTableName() {
        return TABLE_NAME;
    }
    
}
