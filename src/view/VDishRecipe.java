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
public class VDishRecipe extends View{

    public VDishRecipe(ViewData vd) {
        this.data = vd;
    }

    public VDishRecipe() {
    }
    public static VDishRecipe get(int dishId) throws SQLException{
        String sql = "SELECT * FROM cong_thuc WHERE MaMA = " + dishId;
        try {
            return new VDishRecipe(database.Database.viewSelect(sql));
        } catch (SQLException e) {
            throw e;
        }
    }
}
