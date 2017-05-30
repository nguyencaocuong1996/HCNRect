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
public class VDepartment extends View {

    public VDepartment(ViewData vd) {
        data = vd;
        filterData = (ViewData)data.clone();
    }
    
    public static VDepartment getAllDepartment() throws SQLException{
        String sql = "SELECT * FROM phong_ban";
        try {           
            return new VDepartment(database.Database.viewSelect(sql));
        } catch (SQLException e) {
            throw e;
        }
    }
}
