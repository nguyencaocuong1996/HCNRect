/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.panel.ppackkage.recipe;

import assets.font.CFont;
import java.awt.Color;
import java.awt.Dimension;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import modal.MDish;
import modal.MDishRecipe;
import modal.MMaterial;
import view.VDishRecipe;
import view.VMaterial;

/**
 *
 * @author WINDNCC
 */
public class JPanelManagementRecipe extends javax.swing.JPanel {

    private static JPanelManagementRecipe instance;
    protected int providerId;
    protected MDish dish;
    protected VMaterial vMaterial;
    protected HashMap<Integer, JPanelRecipeMaterialItem> listMaterial = new HashMap<>();
    protected HashMap<Integer, JPanelRecipeDetailMaterialItem> listMaterialInRecipe = new HashMap<>();
    public static JPanelManagementRecipe getInstance() {
        if (instance == null) {
            instance = new JPanelManagementRecipe();
        }
        return instance;
    }
    
    public JPanelManagementRecipe() {
        initComponents();
        vMaterial = VMaterial.getAllMaterial();
        vMaterial.getData().forEach((t) -> {
            int materialId = ((Long) t.get("MaNL")).intValue();
            String name = (String) t.get("TenNL");
            float inStock = (Float) t.get("SoLuongTon");
            listMaterial.put(materialId, new JPanelRecipeMaterialItem(materialId, name, inStock));
        });
        showData();
    }
    public void setDish(MDish dish) {
        listMaterialInRecipe.clear();
        jPanelListMaterialInRecipe.removeAll();
        this.dish = dish;
        jLabelMaterialName.setText(this.dish.getName());
        try {
            VDishRecipe recipe = VDishRecipe.get(dish.getId());
            recipe.getData().forEach((t) -> {
                int materialId = ((Long) t.get("MaNL")).intValue();
                String materialName = "";
                try {
                    materialName = MMaterial.get(materialId).getName();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                float qty = (Float) t.get("LuongCan");
                listMaterialInRecipe.put(materialId, new JPanelRecipeDetailMaterialItem(materialId,materialName, qty));
                addRecipeMaterialItem(listMaterialInRecipe.get(materialId));
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    public void addRecipeMaterialItem(JPanelRecipeDetailMaterialItem jpIDMI){
        int height = listMaterialInRecipe.size() * 37;
        jPanelListMaterialInRecipe.setPreferredSize(new Dimension(375, height));
        jPanelListMaterialInRecipe.add(jpIDMI);
        jPanelListMaterialInRecipe.revalidate();
        jPanelListMaterialInRecipe.repaint();
    }
    public final void showData(){
        jPanelListImportMaterial.removeAll();
        int height = vMaterial.getFilterData().size() * 51;
        jPanelListImportMaterial.setPreferredSize(new Dimension(440, height));
        vMaterial.getFilterData().forEach((t) -> {
            int id = ((Long) t.get("MaNL")).intValue();
            jPanelListImportMaterial.add(listMaterial.get(id));
        });
        jPanelListImportMaterial.revalidate();
        jPanelListImportMaterial.repaint();
    }
    public void filter(String name, boolean showLowInStock){
        vMaterial.filter(name, showLowInStock);
        showData();
        
    }

    public void updateRecipe(){
        listMaterialInRecipe.forEach((t, u) -> {
            MDishRecipe recipe = new MDishRecipe();
            recipe.setDishId(this.dish.getId());
            recipe.setMaterialId(u.getMaterialId());
            recipe.setQty(u.getQuantity());
            try {
                if (recipe.isExist()) {
                    recipe.update();
                } else {
                    recipe.insert();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Có lỗi xảy ra. Không thể cập nhật công thức!");
                return;
            }
            
        });
        JOptionPane.showMessageDialog(this, "Sửa công thức thành công.");
    }
    
    public HashMap<Integer, JPanelRecipeDetailMaterialItem> getListMaterialInRecipe() {
        return listMaterialInRecipe;
    }
    
    public JPanel getjPanelListMaterialInRecipe() {
        return jPanelListMaterialInRecipe;
    }
    
    public JLabel getjLabelProviderName() {
        return jLabelMaterialName;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabelMaterialName = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldFilterMaterial = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jCheckBoxShowLowInStock = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanelListImportMaterial = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabelDoAddReceiptNote = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanelListMaterialInRecipe = new javax.swing.JPanel();

        setMaximumSize(new java.awt.Dimension(780, 540));
        setMinimumSize(new java.awt.Dimension(780, 540));
        setPreferredSize(new java.awt.Dimension(780, 540));
        setLayout(new java.awt.GridLayout(1, 0));

        jPanel3.setBackground(new java.awt.Color(70, 92, 139));

        jLabelMaterialName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelMaterialName.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMaterialName.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_coins.png"))); // NOI18N
        jLabelMaterialName.setText("Đang sửa công thức cho món nào");
        jLabelMaterialName.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelMaterialName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelMaterialNameMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabelMaterialName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelMaterialName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Mã NL");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Tên NL");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Đơn vị");

        jTextFieldFilterMaterial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldFilterMaterialKeyReleased(evt);
            }
        });

        jLabel4.setText("Tìm kiếm:");

        jCheckBoxShowLowInStock.setBackground(new java.awt.Color(204, 204, 204));
        jCheckBoxShowLowInStock.setText("Dưới mức tối thiểu");
        jCheckBoxShowLowInStock.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBoxShowLowInStockItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldFilterMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jCheckBoxShowLowInStock)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldFilterMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jCheckBoxShowLowInStock))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setOpaque(false);

        jPanelListImportMaterial.setMaximumSize(new java.awt.Dimension(440, 445));
        jPanelListImportMaterial.setMinimumSize(new java.awt.Dimension(440, 445));
        jPanelListImportMaterial.setPreferredSize(new java.awt.Dimension(440, 445));
        jPanelListImportMaterial.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEADING));
        jScrollPane1.setViewportView(jPanelListImportMaterial);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel1);

        jPanel2.setMaximumSize(new java.awt.Dimension(390, 540));
        jPanel2.setMinimumSize(new java.awt.Dimension(390, 540));

        jPanel7.setBackground(new java.awt.Color(147, 193, 120));

        jLabelDoAddReceiptNote.setBackground(new java.awt.Color(147, 193, 120));
        jLabelDoAddReceiptNote.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDoAddReceiptNote.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDoAddReceiptNote.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDoAddReceiptNote.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_payment2_white_x32.png"))); // NOI18N
        jLabelDoAddReceiptNote.setText("Lưu công thức");
        CFont.setStyleFont(jLabelDoAddReceiptNote, 18, Color.WHITE);
        jLabelDoAddReceiptNote.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelDoAddReceiptNoteMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabelDoAddReceiptNote, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelDoAddReceiptNote, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jPanelListMaterialInRecipe.setMaximumSize(new java.awt.Dimension(375, 300));
        jPanelListMaterialInRecipe.setMinimumSize(new java.awt.Dimension(375, 300));
        jPanelListMaterialInRecipe.setPreferredSize(new java.awt.Dimension(375, 300));
        jPanelListMaterialInRecipe.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        jScrollPane2.setViewportView(jPanelListMaterialInRecipe);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(9, 9, 9))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );

        add(jPanel2);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelMaterialNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMaterialNameMouseClicked
     
    }//GEN-LAST:event_jLabelMaterialNameMouseClicked

    private void jTextFieldFilterMaterialKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldFilterMaterialKeyReleased
        String name = jTextFieldFilterMaterial.getText();
        filter(name, jCheckBoxShowLowInStock.isSelected());
    }//GEN-LAST:event_jTextFieldFilterMaterialKeyReleased

    private void jLabelDoAddReceiptNoteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDoAddReceiptNoteMouseClicked
        int check = JOptionPane.showConfirmDialog(this, "Xác nhận cập nhật công thức?");
        if(check == JOptionPane.YES_OPTION){
            updateRecipe();
        }
        
    }//GEN-LAST:event_jLabelDoAddReceiptNoteMouseClicked

    private void jCheckBoxShowLowInStockItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBoxShowLowInStockItemStateChanged
        String name = jTextFieldFilterMaterial.getText();
        filter(name, jCheckBoxShowLowInStock.isSelected());
    }//GEN-LAST:event_jCheckBoxShowLowInStockItemStateChanged
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setSize(new Dimension(1024,720));
        jf.add(JPanelManagementRecipe.getInstance());
        jf.setVisible(true);
    }

    public MDish getDish() {
        return dish;
    }
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jCheckBoxShowLowInStock;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelDoAddReceiptNote;
    private javax.swing.JLabel jLabelMaterialName;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanelListImportMaterial;
    private javax.swing.JPanel jPanelListMaterialInRecipe;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextFieldFilterMaterial;
    // End of variables declaration//GEN-END:variables
}
