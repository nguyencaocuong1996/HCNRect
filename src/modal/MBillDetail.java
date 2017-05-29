/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modal;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.VDishRecipe;

/**
 *
 * @author WINDNCC
 */
public class MBillDetail extends Model{
    protected static final String TABLE_NAME = "chi_tiet_hoa_don";
    protected int billId;
    protected int dishId;
    protected int quantity;
    
    @Override
    public void insert() throws SQLException {
        try {
            insertData = new ModalData();
            insertData.put("MaHD", getBillId());
            insertData.put("MaMA", getDishId());
            insertData.put("SoLuong", getQuantity());
            database.Database.insert(TABLE_NAME, insertData);
            VDishRecipe vDishRecipe = VDishRecipe.get(getDishId());
            vDishRecipe.getData().forEach((t) -> {
                int materialId = ((Long) t.get("MaNL")).intValue();
                float qty = ((Float) t.get("LuongCan")) * getQuantity();
                try {
                    MMaterial material =  MMaterial.get(materialId);
                    material.setInStock(material.getInStock() - qty);
                    material.update();
                } catch (SQLException e) {
                    try {
                        throw e;
                    } catch (SQLException ex) {
                        Logger.getLogger(MBillDetail.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
            });
        } catch (SQLException e) {
            throw e;
        }
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

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }



    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
