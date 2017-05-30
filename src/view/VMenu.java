/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.SQLException;

/**
 *
 * @author phung trong huy
 */
public class VMenu extends View{
    
    public VMenu(ViewData vd) {
        this.data = vd;
        this.filterData = (ViewData)data.clone();
    }

    public VMenu() {
    }
    
    public static VMenu getAllMenu() throws SQLException{
        String sql = "SELECT * FROM thuc_don";
        try {
            return new VMenu(database.Database.viewSelect(sql));
        } catch (SQLException e) {
            throw e;
        }
    }
}
