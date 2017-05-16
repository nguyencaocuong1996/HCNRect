/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modal;

import database.Database;
import java.util.HashMap;
import modal.Dish;
import modal.Material;
import modal.Provider;

/**
 *
 * @author WINDNCC
 */
public class InsertData {
    protected HashMap data = new HashMap();
    protected String tableName;

    public InsertData(Dish dish) {
        tableName = "mon_an";
        this.data.put("TenMA", dish.getName());
        this.data.put("GiaMA", dish.getPrice());
        this.data.put("DiaChiAnhMA", dish.getImageUrl());
    }
    public InsertData(Material material) {
        tableName = "nguyen_lieu";
        this.data.put("TenNL", material.getName());
        this.data.put("SoLuongTon", material.getInStock());
        this.data.put("DonVi", material.getUnit());
        this.data.put("MucToiThieu", material.getMinInStock());
    }
    public InsertData(Provider provider) {
        tableName = "nha_cung_cap";
        this.data.put("TenNCC", provider.getName());
        this.data.put("SDTNCC", provider.getPhone());
        this.data.put("DiaChiNCC", provider.getAddress());
        this.data.put("MoTaNCC", provider.getDescription());
    }
    
    
    public HashMap getData() {
        return data;
    }
    public String getTableName() {
        return tableName;
    }
    public void execute()
    {
//        Database.insert(this);
    }
}
