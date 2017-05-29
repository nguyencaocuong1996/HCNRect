
package restaurant.panel.ppackkage.material;

import restaurant.panel.order.*;
import assets.images.icons.IconResources;
import java.awt.Dimension;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class JPanelImportDetailMaterialItem extends javax.swing.JPanel {
    protected String materialName = "";
    protected int quantity = 1;
    protected int materialId;
    protected float materialPrice = 0;

    public JPanelImportDetailMaterialItem(int materialId, String materialName, int quantity) {
        initComponents();
        this.materialId = materialId;
        this.materialName = materialName;
        this.quantity = quantity;
        if(quantity == 1){
            jLabelDown.setVisible(false);
        }
        jLabelMaterialName.setText("<html><p>"+this.materialName+"</p></html>");
        jTextFieldQty.setText(this.quantity + "");
        jLabelTotalPrice.setText(quantity * materialPrice + "");
    }
    public void dbAdd(){
        int tableId = JPanelOrder.getInstance().getTableId();
        System.out.println("dbAdd in JPanelOrderItem.java: thêm món vừa được chọn vào database");
        HashMap ud = new HashMap();
        ud.put("MaMA", materialId);
        ud.put("MaBan", tableId);
        ud.put("SoLuong", this.quantity);
        try {
            database.Database.insert("chi_tiet_dat_mon", ud);
            System.out.println("----Thêm món thành công!");
        } catch (Exception e) {
            System.out.println("----Thêm món thất bại!");
        }
    }
    public void dbUpdate(){
        System.out.println("dbUpdate in JPanelOrderItem.java: cập nhật món đã chọn vào database");
        HashMap ud = new HashMap();
        ud.put("SoLuong", this.quantity);
        try {
            int tableId = JPanelOrder.getInstance().getTableId();
            database.Database.update("chi_tiet_dat_mon", ud, "MaBan = " + tableId + " AND MaMA = " + this.materialId);
            System.out.println("----Sửa món thành công!");
        } catch (Exception e) {
            System.out.println("----Sửa món thất bại!");
        }
    }
    public void dbDelete(){
        System.out.println("dbDelete in JPanelOrderItem.java: Xóa món đã chọn");
        try {
            int tableId = JPanelOrder.getInstance().getTableId();
            database.Database.delete("chi_tiet_dat_mon", "MaBan = " + tableId + " AND MaMA = " + this.materialId);
            System.out.println("----Xóa món thành công!");
        } catch (Exception e) {
            System.out.println("----Xóa món thất bại!");
        }
    }
    public int getDishId() {
        return materialId;
    }

    public void setDishId(int dishId) {
        this.materialId = dishId;
    }

    
    
    public String getDishName() {
        return materialName;
    }

    public void setDishName(String dishName) {
        this.materialName = dishName;
    }

    public int getQuantity() {
        return quantity;
    }
    
    public float getTotalPrice(){
        return materialPrice * quantity;
    }
    public void setTotalPrice(){
        System.out.println("sôso" + getTotalPrice());
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
        return materialPrice;
    }

    public void setPrice(float price) {
        this.materialPrice = price;
    }
    
    public JPanelImportDetailMaterialItem() {
        initComponents();
    }
    
    public void setLblPriceFood(JLabel lblPriceFood) {
        this.jLabelTotalPrice = lblPriceFood;
    }
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setSize(new Dimension(500,500));
        jf.add(new JPanelImportDetailMaterialItem(1, "cuong", 11));
        jf.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelMaterialName = new javax.swing.JLabel();
        jTextFieldQty = new javax.swing.JTextField();
        jLabelUp = new javax.swing.JLabel();
        jLabelDown = new javax.swing.JLabel();
        jLabelClose = new javax.swing.JLabel();
        jTextFieldPrice = new javax.swing.JTextField();
        jLabelTotalPrice = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 204));
        setMaximumSize(new java.awt.Dimension(417, 32));
        setMinimumSize(new java.awt.Dimension(417, 32));
        setPreferredSize(new java.awt.Dimension(417, 32));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelMaterialName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelMaterialName.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabelMaterialName.setText("<html><p>Thịt kho tô chiên nước mắm</p></html>");
        jLabelMaterialName.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabelMaterialName.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(jLabelMaterialName, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 30));

        jTextFieldQty.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jTextFieldQty.setText("1");
        jTextFieldQty.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jTextFieldQtyInputMethodTextChanged(evt);
            }
        });
        jTextFieldQty.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTextFieldQtyPropertyChange(evt);
            }
        });
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
        add(jLabelClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 30, 30));

        jTextFieldPrice.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldPriceFocusLost(evt);
            }
        });
        jTextFieldPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldPriceKeyReleased(evt);
            }
        });
        add(jTextFieldPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 90, 30));

        jLabelTotalPrice.setText("jLabel1");
        add(jLabelTotalPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 110, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelUpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelUpMouseClicked
        setQuantity(getQuantity() + 1);
//        dbUpdate();
//        JPanelOrder.getInstance().updateBill();
    }//GEN-LAST:event_jLabelUpMouseClicked

    private void jLabelDownMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDownMouseClicked
        setQuantity(getQuantity() - 1);
//        dbUpdate();
//        JPanelOrder.getInstance().updateBill();
    }//GEN-LAST:event_jLabelDownMouseClicked

    private void jLabelCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCloseMouseClicked
//        JPanelOrder.getInstance().getListJPanelOrderDetail().get(JPanelOrder.getInstance().getTableId()).removeOrderItem(this);
//        JPanelOrder.getInstance().revalidate();
//        JPanelOrder.getInstance().repaint();
//        this.dbDelete();
//        JPanelOrder.getInstance().updateBill();
    }//GEN-LAST:event_jLabelCloseMouseClicked

    private void jTextFieldQtyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldQtyKeyReleased
        setQuantity(new Integer(jTextFieldQty.getText()));
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

    private void jTextFieldPriceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPriceKeyReleased
        try {
            setPrice(new Float(jTextFieldPrice.getText()));
            setTotalPrice();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Chỉ được nhập số!");
            jTextFieldPrice.setText(getPrice()+"");
        }
        
    }//GEN-LAST:event_jTextFieldPriceKeyReleased

    private void jTextFieldPriceFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldPriceFocusLost
        
    }//GEN-LAST:event_jTextFieldPriceFocusLost

    private void jTextFieldQtyInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jTextFieldQtyInputMethodTextChanged
        System.out.println("hihi");
    }//GEN-LAST:event_jTextFieldQtyInputMethodTextChanged

    private void jTextFieldQtyPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTextFieldQtyPropertyChange
      
    }//GEN-LAST:event_jTextFieldQtyPropertyChange
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelClose;
    private javax.swing.JLabel jLabelDown;
    private javax.swing.JLabel jLabelMaterialName;
    private javax.swing.JLabel jLabelTotalPrice;
    private javax.swing.JLabel jLabelUp;
    private javax.swing.JTextField jTextFieldPrice;
    private javax.swing.JTextField jTextFieldQty;
    // End of variables declaration//GEN-END:variables
}
