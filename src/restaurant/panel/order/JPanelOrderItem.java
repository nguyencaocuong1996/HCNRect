
package restaurant.panel.order;

import assets.images.icons.IconResources;
import java.util.HashMap;
import javax.swing.JLabel;

public class JPanelOrderItem extends javax.swing.JPanel {
    protected String dishName = "";
    protected int quantity = 1;
    protected int dishId;
    protected float price;

    public JPanelOrderItem(int dishId, String dishName, int quantity, float price) {
        initComponents();
        this.dishId = dishId;
        this.dishName = dishName;
        this.quantity = quantity;
        this.price = price;
        if(quantity == 1){
            jLabelDown.setVisible(false);
        }
        jLabelDishName.setText("<html><p>"+this.dishName+"</p></html>");
        jTextFieldQty.setText(this.quantity + "");
        jLabelTotalPrice.setText(quantity * price + "");
    }
    public void dbAdd(){
        int tableId = JPanelOrder.getInstance().getTableId();
        System.out.println("add");
        HashMap ud = new HashMap();
        ud.put("MaMA", dishId);
        ud.put("MaBan", tableId);
        ud.put("SoLuong", this.quantity);
        try {
            database.Database.insert("chi_tiet_dat_mon", ud);
        } catch (Exception e) {
            throw e;
        }
    }
    public void dbUpdate(){
        System.out.println("update");
        HashMap ud = new HashMap();
        ud.put("SoLuong", this.quantity);
        try {
            int tableId = JPanelOrder.getInstance().getTableId();
            database.Database.update("chi_tiet_dat_mon", ud, "MaBan = " + tableId + " AND MaMA = " + this.dishId);
        } catch (Exception e) {
            throw e;
        }
    }
    public void dbDelete(){
        System.out.println("delete");
        try {
            int tableId = JPanelOrder.getInstance().getTableId();
            database.Database.delete("chi_tiet_dat_mon", "MaBan = " + tableId + " AND MaMA = " + this.dishId);
        } catch (Exception e) {
            throw e;
        }
    }
    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    
    
    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public int getQuantity() {
        return quantity;
    }
    
    public float getTotalPrice(){
        return price * quantity;
    }
    public void setTotalPrice(){
        jLabelTotalPrice.setText(getTotalPrice() + "");
    }
    public void setQuantity(int quantity) {
        jTextFieldQty.setText(quantity+"");
        this.quantity = quantity;
        if(this.quantity == 1){
            jLabelDown.setVisible(false);
        } else {
            jLabelDown.setVisible(true);
        }
        setTotalPrice();
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    public JPanelOrderItem() {
        initComponents();
    }
    
    public void setLblPriceFood(JLabel lblPriceFood) {
        this.jLabelTotalPrice = lblPriceFood;
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelDishName = new javax.swing.JLabel();
        jTextFieldQty = new javax.swing.JTextField();
        jLabelUp = new javax.swing.JLabel();
        jLabelDown = new javax.swing.JLabel();
        jLabelTotalPrice = new javax.swing.JLabel();
        jLabelClose = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 204));
        setPreferredSize(new java.awt.Dimension(280, 30));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelDishName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelDishName.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabelDishName.setText("<html><p>Thịt kho tô chiên nước mắm</p></html>");
        jLabelDishName.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabelDishName.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(jLabelDishName, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 30));

        jTextFieldQty.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jTextFieldQty.setText("1");
        jTextFieldQty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldQtyKeyReleased(evt);
            }
        });
        add(jTextFieldQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, 30, 30));

        jLabelUp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelUp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_arrow_up_green_x24.png"))); // NOI18N
        jLabelUp.setToolTipText("");
        jLabelUp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelUpMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelUpMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelUpMouseExited(evt);
            }
        });
        add(jLabelUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, 30, 30));

        jLabelDown.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDown.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_arrow_down_red_x24.png"))); // NOI18N
        jLabelDown.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabelDown.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelDownMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelDownMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelDownMouseExited(evt);
            }
        });
        add(jLabelDown, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 30, 30));

        jLabelTotalPrice.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabelTotalPrice.setText("1000000");
        add(jLabelTotalPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 80, 30));

        jLabelClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_close_red_x24.png"))); // NOI18N
        jLabelClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCloseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelCloseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelCloseMouseExited(evt);
            }
        });
        add(jLabelClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 30, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelUpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelUpMouseClicked
        setQuantity(getQuantity() + 1);
        dbUpdate();
    }//GEN-LAST:event_jLabelUpMouseClicked

    private void jLabelDownMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDownMouseClicked
        setQuantity(getQuantity() - 1);
        dbUpdate();
    }//GEN-LAST:event_jLabelDownMouseClicked

    private void jLabelCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCloseMouseClicked
        JPanelOrder.getInstance().getListJPanelOrderDetail().get(JPanelOrder.getInstance().getTableId()).removeOrderItem(this);
        JPanelOrder.getInstance().revalidate();
        JPanelOrder.getInstance().repaint();
        this.dbDelete();
        Thread t = new Thread(){
            @Override
            public void run() {
                super.run(); //To change body of generated methods, choose Tools | Templates.
                System.out.println("hoho");
            }
        };
        t.start();
//        JPanel jplistoi = jpOD.getjPanelListOrdering();
//        jpOD.listDishOrdering.remove(jpOI);
//        jplistoi.remove(jpOI);
//        jplistoi.revalidate();
//        jplistoi.repaint();
    }//GEN-LAST:event_jLabelCloseMouseClicked

    private void jTextFieldQtyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldQtyKeyReleased
        setQuantity(new Integer(jTextFieldQty.getText()));
        dbUpdate();
    }//GEN-LAST:event_jTextFieldQtyKeyReleased

    private void jLabelUpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelUpMouseEntered
        jLabelUp.setIcon(IconResources.ARROW_UP_FILL_X24);
    }//GEN-LAST:event_jLabelUpMouseEntered

    private void jLabelUpMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelUpMouseExited
        jLabelUp.setIcon(IconResources.ARROW_UP_X24);
    }//GEN-LAST:event_jLabelUpMouseExited

    private void jLabelDownMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDownMouseEntered
        jLabelDown.setIcon(IconResources.ARROW_DOWN_FILL_X24);
    }//GEN-LAST:event_jLabelDownMouseEntered

    private void jLabelDownMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDownMouseExited
        jLabelDown.setIcon(IconResources.ARROW_DOWN_X24);
    }//GEN-LAST:event_jLabelDownMouseExited

    private void jLabelCloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCloseMouseEntered
        jLabelClose.setIcon(IconResources.CLOSE_FILL_X24);
    }//GEN-LAST:event_jLabelCloseMouseEntered

    private void jLabelCloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCloseMouseExited
        jLabelClose.setIcon(IconResources.CLOSE_X24);
    }//GEN-LAST:event_jLabelCloseMouseExited
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelClose;
    private javax.swing.JLabel jLabelDishName;
    private javax.swing.JLabel jLabelDown;
    private javax.swing.JLabel jLabelTotalPrice;
    private javax.swing.JLabel jLabelUp;
    private javax.swing.JTextField jTextFieldQty;
    // End of variables declaration//GEN-END:variables
}
