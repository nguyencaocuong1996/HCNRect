/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import core.CString;
import database.Database;
import java.sql.SQLException;

/**
 *
 * @author WINDNCC
 */
public class VMaterial extends View{

    public VMaterial() {
    }
    
    public VMaterial(ViewData viewData) {
        data = viewData;
        filterData = (ViewData) data.clone();
    }
    
    public static VMaterial getAllMaterial(){
        String sqlQuery = "SELECT nl.MaNL, nl.TenNL, nl.SoLuongTon, nl.DonVi, nl.MucToiThieu FROM nguyen_lieu as nl;";
//        System.out.println(sqlQuery);
        try{
            return new VMaterial(Database.viewSelect(sqlQuery));
        } catch(SQLException e){
            e.printStackTrace();
        }
        return new VMaterial();
    }
    public void filter(String name){
        super.filter(new FilterView(){
            @Override
            public boolean filter(ViewItem o) {
                String viName = (String) o.get("TenNL");
                viName = CString.removeAccent(viName).toLowerCase();
                return viName.contains(CString.removeAccent(name).toLowerCase());
            }
            
        });
    }
}
