/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.SQLException;

/**
 *
 * @author khanhnguyen
 */
public class VCustomerType extends View {
     public VCustomerType(ViewData vd) {
        data = vd;
        filterData = (ViewData)data.clone();
    }
    
    public static VCustomerType getAllCustomerType() throws SQLException{
        String sql = "SELECT * FROM loai_khach_hang";
        try {           
            return new VCustomerType(database.Database.viewSelect(sql));
        } catch (SQLException e) {
            throw e;
        }
    }
}
