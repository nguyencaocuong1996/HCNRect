/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.panel.ppackkage;
import assets.images.ImageResources;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import modal.MMaterial;

/**
 *
 * @author WINDNCC
 */
public class JPanelMaterialRowItem extends javax.swing.JPanel {
    protected String materialName;
    protected int id;
    protected float qty;
    protected String unit;
    protected float limit;
    protected static Color oddBackground = new Color(224, 224, 235);
    public JPanelMaterialRowItem() {
        initComponents();
    }
    public JPanelMaterialRowItem(int dishId, String dishName, float qty, String unit, float limit, boolean odd) {
        initComponents();
        this.id = dishId;
        this.materialName = dishName;
        this.qty = qty;
        this.limit = limit;
        this.unit = unit;
        if(odd){
            setBackground(oddBackground);
        }
        customInit();
    }
    public final void customInit(){
        jLabelMaterialId.setText(this.id + "");
        jLabelMaterialName.setText("<html><p>" + this.materialName + "</p></html>");
        jLabelMaterialQty.setText(this.qty + " " + this.unit);
        jLabelMaterialLimit.setText(this.limit + " " + this.unit);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelMaterialId = new javax.swing.JLabel();
        jLabelMaterialName = new javax.swing.JLabel();
        jLabelMaterialQty = new javax.swing.JLabel();
        jLabelEdit = new javax.swing.JLabel();
        jLabelDelete = new javax.swing.JLabel();
        jLabelMaterialLimit = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(760, 57));
        setMinimumSize(new java.awt.Dimension(760, 57));
        setPreferredSize(new java.awt.Dimension(760, 57));

        jLabelMaterialId.setText("001");

        jLabelMaterialName.setText("tên nguyên liệu");

        jLabelMaterialQty.setText("120000000");

        jLabelEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_edit_darkgreen_x24.png"))); // NOI18N
        jLabelEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelEditMouseClicked(evt);
            }
        });

        jLabelDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_delete_dimgray_x32.png"))); // NOI18N
        jLabelDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelDeleteMouseClicked(evt);
            }
        });

        jLabelMaterialLimit.setText("limit");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelMaterialId, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jLabelMaterialName, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelMaterialQty, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jLabelMaterialLimit, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelDelete)
                .addContainerGap(84, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelMaterialName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabelMaterialId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabelEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(17, 17, 17))
            .addComponent(jLabelMaterialLimit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabelMaterialQty, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteMouseClicked
        // TODO add your handling code here:
        try {
            MMaterial mMaterial = new MMaterial(id);
            mMaterial.delete();
            JPanelManagementMaterial.getInstance().getjPanelTableContent().remove(this);
            JPanelManagementMaterial.getInstance().getjPanelTableContent().revalidate();
            JPanelManagementMaterial.getInstance().getjPanelTableContent().repaint();
        } catch (Exception e) {
        }
        
    }//GEN-LAST:event_jLabelDeleteMouseClicked

    private void jLabelEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelEditMouseClicked

    public String getDishName() {
        return materialName;
    }

    public void setDishName(String name) {
        this.materialName = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrice() {
        return qty;
    }

    public void setPrice(float price) {
        this.qty = price;
    }

    public String getImage() {
        return unit;
    }

    public void setImage(String image) {
        this.unit = image;
    }

    public void setLimit(Float limit){
        this.limit = limit;
    }
    public JLabel getjLabelDelete() {
        return jLabelDelete;
    }

    public JLabel getjLabelEdit() {
        return jLabelEdit;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelDelete;
    private javax.swing.JLabel jLabelEdit;
    private javax.swing.JLabel jLabelMaterialId;
    private javax.swing.JLabel jLabelMaterialLimit;
    private javax.swing.JLabel jLabelMaterialName;
    private javax.swing.JLabel jLabelMaterialQty;
    // End of variables declaration//GEN-END:variables
}
