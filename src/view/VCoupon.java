/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import core.CDateTime;
import core.CString;
import java.sql.SQLException;

/**
 *
 * @author WINDNCC
 */
public class VCoupon extends View{
    public VCoupon(ViewData vd) {
        this.data = vd;
        this.filterData = (ViewData) data.clone();
    }
    public static VCoupon getAllCoupon() throws SQLException{
        String sql = "SELECT * FROM phieu_khuyen_mai";
        return new VCoupon(database.Database.viewSelect(sql));
    }
    public static VCoupon getAvailableCoupon() throws SQLException{
        String date = CDateTime.getInstance().getDate().toString();
        String sql = "SELECT * FROM phieu_khuyen_mai WHERE NgayBatDau <= '" +date+ "' AND NgayKetThuc >='" + date +"'";
        return new VCoupon(database.Database.viewSelect(sql));
    }
    public void filter(String kw){
        super.filter(new FilterView(){
            @Override
            public boolean filter(ViewItem o) {
                String skw = CString.removeAccent(kw).toLowerCase();
                String id = CString.removeAccent((String) o.get("MaPGG")).toLowerCase();
                return id.contains(skw);
            }
            
        });
    }
}
