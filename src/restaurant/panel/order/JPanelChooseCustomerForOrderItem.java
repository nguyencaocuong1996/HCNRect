/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.panel.order;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import modal.MCustomer;
import restaurant.panel.ppackkage.material.JPanelImportMaterial;

/**
 *
 * @author WINDNCC
 */
public class JPanelChooseCustomerForOrderItem extends javax.swing.JPanel {

    protected int customerId;
    protected String customerName;
    protected String customerAdress;
    protected String customerPhone;
    protected int customerTypeId;
    public JPanelChooseCustomerForOrderItem(int customerId, String customerName, String customerPhone, int customerTypeId) {
        initComponents();
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.customerTypeId = customerTypeId;
        this.jLabelCustomerId.setText(customerId+"");
        this.jLabelCustomerName.setText(customerName);
        this.jLabelCustomerPhone.setText(customerPhone);
        customInit();
    }
    private void customInit(){
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MCustomer customer = new MCustomer();
                customer.setId(customerId);
                customer.setPhone(customerPhone);
                customer.setFullName(customerName);
                customer.setCustomerTypeId(customerTypeId);
                JPanelOrder.getInstance().setCustomer(customer);
                JPanelOrder.getInstance().getjDialogChooseCustomer().setVisible(false);
            }
            
        });
    }
    public JPanelChooseCustomerForOrderItem() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelCustomerName = new javax.swing.JLabel();
        jLabelCustomerId = new javax.swing.JLabel();
        jLabelCustomerPhone = new javax.swing.JLabel();

        setBackground(new java.awt.Color(70, 92, 139));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setMaximumSize(new java.awt.Dimension(400, 40));
        setMinimumSize(new java.awt.Dimension(400, 40));
        setPreferredSize(new java.awt.Dimension(400, 40));

        jLabelCustomerName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelCustomerName.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCustomerName.setText("Tên");

        jLabelCustomerId.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCustomerId.setText("Mã");

        jLabelCustomerPhone.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCustomerPhone.setText("Số điện thoại");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabelCustomerId, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelCustomerName, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelCustomerPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabelCustomerName, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addComponent(jLabelCustomerId, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabelCustomerPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelCustomerId;
    private javax.swing.JLabel jLabelCustomerName;
    private javax.swing.JLabel jLabelCustomerPhone;
    // End of variables declaration//GEN-END:variables
}
