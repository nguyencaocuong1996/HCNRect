/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.panel.order;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import modal.MCustomer;
import restaurant.panel.customer.JPanelChooseCustomerItem;

/**
 *
 * @author WINDNCC
 */
public class JPanelChooseCustomerForOrderItem extends JPanelChooseCustomerItem{

    public JPanelChooseCustomerForOrderItem(int customerId, String customerName, String customerPhone, int customerTypeId) {
        super(customerId, customerName, customerPhone, customerTypeId);
        customInit();
    }
    public final void customInit(){
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MCustomer customer = MCustomer.getByID(customerId);
                JPanelOrder.getInstance().setCustomer(customer);
                JPanelOrder.getInstance().getjDialogChooseCustomer().setVisible(false);
            }
            
        });
    }
    
    public JPanelChooseCustomerForOrderItem() {
    }
    
}
