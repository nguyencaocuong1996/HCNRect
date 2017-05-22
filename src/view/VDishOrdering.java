/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.SQLException;

/**
 *
 * @author WINDNCC
 */
public class VDishOrdering extends View{
    public int tableId;

    public VDishOrdering(ViewData viewData) {
        this.data = viewData;
    }

    public VDishOrdering() {
    }
    
    public static VDishOrdering getByTableId(int tableId){
        String query = "SELECT ma.MaMA, ma.TenMA, ctdm.SoLuong, ma.GiaMA" +
                        " FROM mon_an as ma" +
                        " LEFT JOIN chi_tiet_dat_mon as ctdm ON ctdm.MaMA = ma.MaMA" +
                        " WHERE ctdm.MaBan = "+tableId;
        try{
            return new VDishOrdering(database.Database.viewSelect(query));
        } catch(SQLException e){
            e.printStackTrace();
        }
        return new VDishOrdering();
    }
    public static void deleteOrdering(int tableId) throws SQLException{
        try {
            database.Database.delete("chi_tiet_dat_mon", "MaBan = "+tableId);
        } catch (SQLException e) {
            throw e;
        }
        
    }
}
