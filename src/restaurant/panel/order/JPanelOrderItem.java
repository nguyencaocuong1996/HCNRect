
package restaurant.panel.order;

import javax.swing.JLabel;
import javax.swing.SwingConstants;




public class JPanelOrderItem extends javax.swing.JPanel {
    private int totalPrice = 0;
    public JPanelOrderItem() {
        initComponents();
    }

    public void setLblPriceFood(JLabel lblPriceFood) {
        this.lblPriceFood = lblPriceFood;
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNameFood = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        lblUp = new javax.swing.JLabel();
        lblDown = new javax.swing.JLabel();
        lblPriceFood = new javax.swing.JLabel();
        lblClose = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 204));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNameFood.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblNameFood.setText("jLabel1");
        add(lblNameFood, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 130, 30));

        txtQuantity.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtQuantity.setText("1");
        add(txtQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 60, 30));

        lblUp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_arrow_up_green_x32.png"))); // NOI18N
        lblUp.setToolTipText("");
        lblUp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblUpMouseClicked(evt);
            }
        });
        add(lblUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, -1, 30));

        lblDown.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_arrow_down_red_x32.png"))); // NOI18N
        lblDown.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDownMouseClicked(evt);
            }
        });
        add(lblDown, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, -1, 30));

        lblPriceFood.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblPriceFood.setText("jLabel4");
        add(lblPriceFood, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 110, 30));

        lblClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_close_red_x32.png"))); // NOI18N
        lblClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCloseMouseClicked(evt);
            }
        });
        add(lblClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void lblUpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUpMouseClicked

    }//GEN-LAST:event_lblUpMouseClicked

    private void lblDownMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDownMouseClicked
        
       
    }//GEN-LAST:event_lblDownMouseClicked

    private void lblCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseClicked
        
       //this.setVisible(false);
       
       
    }//GEN-LAST:event_lblCloseMouseClicked
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblClose;
    private javax.swing.JLabel lblDown;
    private javax.swing.JLabel lblNameFood;
    private javax.swing.JLabel lblPriceFood;
    private javax.swing.JLabel lblUp;
    private javax.swing.JTextField txtQuantity;
    // End of variables declaration//GEN-END:variables
}
