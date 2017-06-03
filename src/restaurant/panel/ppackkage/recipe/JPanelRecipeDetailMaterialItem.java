
package restaurant.panel.ppackkage.recipe;

import assets.images.icons.IconResources;
import java.awt.Dimension;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modal.MDishRecipe;

public class JPanelRecipeDetailMaterialItem extends javax.swing.JPanel {
    protected String materialName = "";
    protected float quantity = 0f;
    protected int materialId;

    public JPanelRecipeDetailMaterialItem(int materialId, String materialName, float quantity) {
        initComponents();
        this.materialId = materialId;
        this.materialName = materialName;
        this.quantity = quantity;
        jLabelMaterialName.setText("<html><p>"+this.materialName+"</p></html>");
        jTextFieldQty.setText(this.quantity + "");
    }
    public int getMaterialId() {
        return materialId;
    }

    public void setMaterialId(int materialId) {
        this.materialId = materialId;
    }

    public String getDishName() {
        return materialName;
    }

    public void setDishName(String dishName) {
        this.materialName = dishName;
    }

    public float getQuantity() {
        return quantity;
    }
    
    public void setQuantity(float quantity) {
        jTextFieldQty.setText(quantity+"");
        this.quantity = quantity;
    }
    
    public JPanelRecipeDetailMaterialItem() {
        initComponents();
    }
    
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setSize(new Dimension(500,500));
        jf.add(new JPanelRecipeDetailMaterialItem(1, "cuong", 11));
        jf.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelMaterialName = new javax.swing.JLabel();
        jTextFieldQty = new javax.swing.JTextField();
        jLabelClose = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 204));
        setMaximumSize(new java.awt.Dimension(370, 32));
        setMinimumSize(new java.awt.Dimension(370, 32));
        setPreferredSize(new java.awt.Dimension(370, 32));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelMaterialName.setText("<html><p>Thịt kho tô chiên nước mắm</p></html>");
        jLabelMaterialName.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabelMaterialName.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(jLabelMaterialName, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 30));

        jTextFieldQty.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldQty.setText("0.1");
        jTextFieldQty.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldQtyFocusLost(evt);
            }
        });
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
        add(jTextFieldQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, 60, 30));

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
        add(jLabelClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, 30, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCloseMouseClicked
        try {
            MDishRecipe recipe = new MDishRecipe();
            recipe.setDishId(JPanelManagementRecipe.getInstance().getDish().getId());
            recipe.setMaterialId(materialId);
            recipe.delete();
            JPanelRecipeDetailMaterialItem jpIDMI = JPanelManagementRecipe.getInstance().getListMaterialInRecipe().get(materialId);
            JPanelManagementRecipe.getInstance().getjPanelListMaterialInRecipe().remove(jpIDMI);
            JPanelManagementRecipe.getInstance().getjPanelListMaterialInRecipe().revalidate();
            JPanelManagementRecipe.getInstance().getjPanelListMaterialInRecipe().repaint();
            JPanelManagementRecipe.getInstance().getListMaterialInRecipe().remove(materialId);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Không thể xóa công thức này!");
        }
        
//        JPanelOrder.getInstance().getListJPanelOrderDetail().get(JPanelOrder.getInstance().getTableId()).removeOrderItem(this);
//        JPanelOrder.getInstance().revalidate();
//        JPanelOrder.getInstance().repaint();
//        this.dbDelete();
//        JPanelOrder.getInstance().updateBill();
    }//GEN-LAST:event_jLabelCloseMouseClicked

    private void jTextFieldQtyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldQtyKeyReleased
        
        
    }//GEN-LAST:event_jTextFieldQtyKeyReleased

    private void jLabelCloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCloseMouseEntered
        jLabelClose.setIcon(IconResources.CLOSE_FILL_X24);
    }//GEN-LAST:event_jLabelCloseMouseEntered

    private void jLabelCloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCloseMouseExited
        jLabelClose.setIcon(IconResources.CLOSE_X24);
    }//GEN-LAST:event_jLabelCloseMouseExited

    private void jTextFieldQtyInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jTextFieldQtyInputMethodTextChanged
        System.out.println("hihi");
    }//GEN-LAST:event_jTextFieldQtyInputMethodTextChanged

    private void jTextFieldQtyPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTextFieldQtyPropertyChange
      
    }//GEN-LAST:event_jTextFieldQtyPropertyChange

    private void jTextFieldQtyFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldQtyFocusLost
        try {
            if(!jTextFieldQty.getText().isEmpty()){
                setQuantity(Float.valueOf(jTextFieldQty.getText()));
            }
        } catch (NumberFormatException e) {
            jTextFieldQty.setText("1.0");
            jTextFieldQty.grabFocus();
            JOptionPane.showMessageDialog(this, "Chỉ được phép nhập số!");
        }
    }//GEN-LAST:event_jTextFieldQtyFocusLost
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelClose;
    private javax.swing.JLabel jLabelMaterialName;
    private javax.swing.JTextField jTextFieldQty;
    // End of variables declaration//GEN-END:variables
}
