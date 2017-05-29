/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import core.CString;
import java.sql.SQLException;

/**
 *
 * @author WINDNCC
 */
public class VProvider extends View{

    public VProvider(ViewData vd) {
        this.data = vd;
        filterData = (ViewData) data.clone();
    }
    public static VProvider getAllProvider() throws SQLException{
        String sql = "SELECT * FROM nha_cung_cap";
        try {
            return new VProvider(database.Database.viewSelect(sql));
        } catch (SQLException e) {
            throw e;
        }
    }
    public VProvider filterByName(String name){
        filter(new FilterView(){
            @Override
            public boolean filter(ViewItem o) {
                String formatName = CString.removeAccent(name).toLowerCase();
                String viName = CString.removeAccent((String) o.get("TenNCC")).toLowerCase();
                return viName.contains(formatName);
            }
            
        });
        return this;
    }
    
}
