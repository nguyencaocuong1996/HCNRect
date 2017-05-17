
package restaurant.panel.order;

import javax.swing.JLabel;
import javax.swing.SwingConstants;




public class JPanelOrderItem extends javax.swing.JPanel {
    private String nameFood;
    private int priceFood;
    
    private int price;
    private int count;
    
    private int totalPrice = 0;
    public JPanelOrderItem() {
        initComponents();
    }

    public JPanelOrderItem(String nameFood, int priceFood) {
        initComponents();
        jLabelIconDown.setVisible(false);
        jTextFieldQuantity.setHorizontalAlignment(SwingConstants.CENTER);
        
        this.nameFood = nameFood;
        this.priceFood = priceFood;
        
        
        jLabelNameFood.setText(nameFood);
        jLabelPriceFood.setText(priceFood + " VNĐ");
        
        setStyleFont(jLabelNameFood, 24);
        setStyleFont(jLabelPriceFood, 24);
        
        
        
        total += priceFood;
        mustPay = total - sale;
        lblTotal.setText(total + " VNĐ");
        lblMustPay.setText(mustPay + " VNĐ");
        System.out.println("total :" +total);

    }

    public String getNameFood() {
        return nameFood;
    }

    public void setNameFood(String nameFood) {
        this.nameFood = nameFood;
    }

    public int getPriceFood() {
        return priceFood;
    }

    public void setPriceFood(int priceFood) {
        this.priceFood = priceFood;
    }

    public JLabel getLblPriceFood() {
        return jLabelPriceFood;
    }

    public void setLblPriceFood(JLabel lblPriceFood) {
        this.jLabelPriceFood = lblPriceFood;
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelNameFood = new javax.swing.JLabel();
        jTextFieldQuantity = new javax.swing.JTextField();
        jLabelIconUp = new javax.swing.JLabel();
        jLabelIconDown = new javax.swing.JLabel();
        jLabelPriceFood = new javax.swing.JLabel();
        jLabelIconClose = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 204));
        setMinimumSize(new java.awt.Dimension(200, 50));
        setPreferredSize(new java.awt.Dimension(200, 50));

        jLabelNameFood.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelNameFood.setText("jLabel1");

        jTextFieldQuantity.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldQuantity.setText("1");

        jLabelIconUp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_arrow_up_green_x32.png"))); // NOI18N
        jLabelIconUp.setToolTipText("");
        jLabelIconUp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelIconUpMouseClicked(evt);
            }
        });

        jLabelIconDown.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_arrow_down_red_x32.png"))); // NOI18N
        jLabelIconDown.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelIconDownMouseClicked(evt);
            }
        });

        jLabelPriceFood.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelPriceFood.setText("jLabel4");

        jLabelIconClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_close_red_x32.png"))); // NOI18N
        jLabelIconClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelIconCloseMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabelNameFood, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelIconDown)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelIconUp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelPriceFood, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelIconClose)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabelNameFood)
                                .addComponent(jLabelPriceFood))
                            .addGap(17, 17, 17))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabelIconDown)
                            .addGap(8, 8, 8)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelIconClose)
                            .addComponent(jTextFieldQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelIconUp))
                        .addContainerGap())))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelIconUpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelIconUpMouseClicked
        jLabelIconDown.setVisible(true);
  
        count = Integer.parseInt(jTextFieldQuantity.getText()) + 1;
        price = getPriceFood() * count ;
        
        jTextFieldQuantity.setText(count + "");
        
        
        jLabelPriceFood.setText(price + " VNĐ");
        

        total += getPriceFood();
        mustPay = total - sale;
        lblTotal.setText(total + " VNĐ");
        lblMustPay.setText(mustPay + " VNĐ");
        System.out.println("total: " + total);
        
    }//GEN-LAST:event_jLabelIconUpMouseClicked

    private void jLabelIconDownMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelIconDownMouseClicked
        
        count = Integer.parseInt(jTextFieldQuantity.getText()) - 1;
        price = getPriceFood() * count ;
        if( count == 1 )
        {
            jLabelIconDown.setVisible(false);
        }
        
        
        jTextFieldQuantity.setText(count + "");
        
        jLabelPriceFood.setText(price + " VNĐ");
        

        total -= getPriceFood();
        mustPay = total - sale;
        
        lblTotal.setText(total + " VNĐ");
        lblMustPay.setText(mustPay + " VNĐ");
        
        System.out.println("total: " + tjLabelNameFood        System.out.println("total: " + tjLabelNameFood}//GEN-LAST:event_jLabelIconDownMouseClicked

    private void jLabelIconCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelIconCloseMouseClicked
        
       //this.setVisible(false);
       
       
    }//GEN-LAST:event_jLabelIconCloseMouseClicked
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelIconClose;
    private javax.swing.JLabel jLabelIconDown;
    private javax.swing.JLabel jLabelIconUp;
    private javax.swing.JLabel jLabelNameFood;
    private javax.swing.JLabel jLabelPriceFood;
    private javax.swing.JTextField jTextFieldQuantity;
    // End of variables declaration//GEN-END:variables
}
