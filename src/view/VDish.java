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
    }
    public VDish() {
    }
    public static VDish getAllDish(){
        return searchByName("");
        
    }
    public static VDish searchByName(String keyWord){
        java.sql.Date curDate =  new java.sql.Date(System.currentTimeMillis());
        String curDateString = curDate.toString();
        System.out.println(curDateString);
        String sqlQuery = "SELECT ma.TenMA, ma.DiaChiAnhMA, ma.GiaMA FROM windncc_restaurant.mon_an as ma";
        if(!"".equals(keyWord)) sqlQuery += " WHERE ma.TenMA LIKE '%" + keyWord + "%'";
//        System.out.println(sqlQuery);
        try{
            ViewData aa = Database.viewSelect(sqlQuery);
        return new VDish(aa);
        } catch(SQLException e){
            e.printStackTrace();
        }
        return new VDish();
    }
}
