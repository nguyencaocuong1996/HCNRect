/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.panel.order;

import java.sql.SQLException;
import restaurant.panel.customer.JPanelChooseCustomer;
import view.VCustomer;

/**
 *
 * @author WINDNCC
 */
public class JPanelChooseCustomerForOrder extends JPanelChooseCustomer{
    private static JPanelChooseCustomerForOrder instance;

    public static JPanelChooseCustomerForOrder getInstance() {
        if (instance == null) {
            instance = new JPanelChooseCustomerForOrder();
        }
        return instance;
    }
    
    public JPanelChooseCustomerForOrder() {
        try {
            vCustomer = VCustomer.getAllCustomer();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        vCustomer.getData().forEach((t) -> {
            int id = ((Long) t.get("MaKH")).intValue();
            String name = (String) t.get("HoTenKH");
            String phone = (String) t.get("SDTKH");
            String address = (String) t.get("DiaChiKH");
            int typeId = ((Long) t.get("MaLKH")).intValue();
            JPanelChooseCustomerForOrderItem newJPCCPOI = new JPanelChooseCustomerForOrderItem(id, name, phone, typeId);
            listJPCCFOI.put(id, newJPCCPOI);
            
        });
        showView();
    }
    
}
