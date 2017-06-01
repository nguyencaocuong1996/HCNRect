/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.panel.transaction.bill;

import java.sql.SQLException;
import restaurant.panel.customer.JPanelChooseCustomer;
import view.VCustomer;

/**
 *
 * @author WINDNCC
 */
public class JPanelChooseCustomerForTransaction extends JPanelChooseCustomer{
    public static JPanelChooseCustomerForTransaction instance;

    public static JPanelChooseCustomerForTransaction getInstance() {
        if (instance == null) {
            instance = new JPanelChooseCustomerForTransaction();
        }
        return instance;
    }

    public JPanelChooseCustomerForTransaction() {
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
            JPanelChooseCustomerForTransactionItem newJPCCPOI = new JPanelChooseCustomerForTransactionItem(id, name, phone, typeId);
            listJPCCFOI.put(id, newJPCCPOI);
            
        });
        showView();
    }
    
    
}
