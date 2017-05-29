/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.panel.ppackkage;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import restaurant.panel.ppackkage.material.JPanelImportMaterial;

/**
 *
 * @author WINDNCC
 */
public class JPanelChooseProviderItem extends javax.swing.JPanel {

    protected int providerId;

    public JPanelChooseProviderItem(int providerId, String providerName, String providerPhone) {
        initComponents();
        this.providerId = providerId;
        this.jLabelProviderId.setText(providerId+"");
        this.jLabelProviderName.setText(providerName);
        this.jLabelProviderPhone.setText(providerPhone);
        customInit();
    }
    private void customInit(){
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JPanelImportMaterial.getInstance().getjLabelProviderName().setText(jLabelProviderName.getText());
                JPanelImportMaterial.getInstance().getjDialogChooseProvider().setVisible(false);
                JPanelImportMaterial.getInstance().setProviderId(providerId);
            }
            
        });
    }
    public JPanelChooseProviderItem() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelProviderName = new javax.swing.JLabel();
        jLabelProviderId = new javax.swing.JLabel();
        jLabelProviderPhone = new javax.swing.JLabel();

        setBackground(new java.awt.Color(70, 92, 139));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setMaximumSize(new java.awt.Dimension(400, 40));
        setMinimumSize(new java.awt.Dimension(400, 40));
        setPreferredSize(new java.awt.Dimension(400, 40));

        jLabelProviderName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelProviderName.setForeground(new java.awt.Color(255, 255, 255));
        jLabelProviderName.setText("Tên");

        jLabelProviderId.setForeground(new java.awt.Color(255, 255, 255));
        jLabelProviderId.setText("Mã");

        jLabelProviderPhone.setForeground(new java.awt.Color(255, 255, 255));
        jLabelProviderPhone.setText("Số điện thoại");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabelProviderId, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelProviderName, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelProviderPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabelProviderName, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addComponent(jLabelProviderId, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabelProviderPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelProviderId;
    private javax.swing.JLabel jLabelProviderName;
    private javax.swing.JLabel jLabelProviderPhone;
    // End of variables declaration//GEN-END:variables
}
