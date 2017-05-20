/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import database.Database;
import java.sql.SQLException;

/**
 *
 * @author WINDNCC
 */
public class VDish extends View{
    
    public VDish(ViewData viewData) {
        data = viewData;
        filterData = (ViewData) data.clone();
    }
    public VDish() {
    }
    public static VDish getAllDish(){
        String sqlQuery = "SELECT ma.MaMA, ma.TenMA, ma.DiaChiAnhMA, ma.GiaMA, ma.MaTD FROM mon_an as ma";
//        System.out.println(sqlQuery);
        try{
            return new VDish(Database.viewSelect(sqlQuery));
        } catch(SQLException e){
            e.printStackTrace();
        }
        return new VDish();
    }
    public VDish filter(int menuId, String dishName){
        filter(new FilterView(){
            @Override
            public boolean filter(ViewItem o) {
                Long viMenuId = (Long) o.get("MaTD");
                String viDishName = (String) o.get("TenMA");
                if("".equals(viDishName)) return viMenuId == menuId;
                if(menuId == 0) return viDishName.contains(dishName);
                return viMenuId == menuId && viDishName.contains(dishName);
            }
            
        });
        return this;
    }
}
