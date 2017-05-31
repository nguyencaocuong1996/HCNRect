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
public class VCustomer extends View{

    public VCustomer(ViewData vd) {
        this.data = vd;
        this.filterData = (ViewData) data.clone();
    }
    public static VCustomer getAllCustomer() throws SQLException{
        String sql = "SELECT * FROM khach_hang";
        return new VCustomer(database.Database.viewSelect(sql));
    }
    public void filter(String kw){
        super.filter(new FilterView(){
            @Override
            public boolean filter(ViewItem o) {
                String skw = CString.removeAccent(kw).toLowerCase();
                String name = CString.removeAccent((String) o.get("HoTenKH")).toLowerCase();
                String phone = (String) o.get("SDTKH");
                int customerId = ((Long) o.get("MaKH")).intValue();
                try {
                    return (name.contains(skw) || phone.contains(skw) || customerId == Integer.valueOf(skw));
                } catch (NumberFormatException e) {
                    return (name.contains(skw) || phone.contains(skw));
                }
                
            }
            
        });
    }
}
