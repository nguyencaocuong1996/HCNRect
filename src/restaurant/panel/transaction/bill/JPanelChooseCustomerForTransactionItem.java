/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.panel.transaction.bill;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import modal.MCustomer;
import restaurant.panel.customer.JPanelChooseCustomerItem;
import restaurant.panel.order.JPanelOrder;

/**
 *
 * @author WINDNCC
 */
public class JPanelChooseCustomerForTransactionItem extends JPanelChooseCustomerItem{

    public JPanelChooseCustomerForTransactionItem(int customerId, String customerName, String customerPhone, int customerTypeId) {
        super(customerId, customerName, customerPhone, customerTypeId);
        customInit();
    }
    
    public JPanelChooseCustomerForTransactionItem() {
    }
    
        public final void customInit(){
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MCustomer customer = new MCustomer();
                customer.setId(customerId);
                customer.setPhone(customerPhone);
                customer.setFullName(customerName);
                customer.setCustomerTypeId(customerTypeId);
                JPanelListBill.getInstance().setCustomer(customer);
                JPanelListBill.getInstance().getjDialogChooseCustomer().setVisible(false);
            }
            
        });
    }
}
