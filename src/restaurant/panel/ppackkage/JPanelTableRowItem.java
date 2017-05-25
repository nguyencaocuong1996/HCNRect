/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.panel.ppackkage;
import assets.images.ImageResources;
import java.awt.Color;
import javax.swing.ImageIcon;

/**
 *
 * @author WINDNCC
 */
public class JPanelTableRowItem extends javax.swing.JPanel {
    protected String dishName;
    protected int id;
    protected String note;
    protected static Color oddBackground = new Color(224, 224, 235);
    public JPanelTableRowItem() {
        initComponents();
    }
    public JPanelTableRowItem(int dishId, String dishName, String note, boolean odd) {
        initComponents();
        this.id = dishId;
        this.dishName = dishName;
        this.note = note;
        if(odd){
            setBackground(oddBackground);
        }
        customInit();
    }
    public final void customInit(){
        jLabelDishId.setText(this.id + "");
        jLabelDishName.setText("<html><p>" + this.dishName + "</p></html>");
        if(this.note == null) this.note = " ";
        jLabelNote.setText("<html><p>" + this.note + "</p></html>");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelDishId = new javax.swing.JLabel();
        jLabelDishName = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabelNote = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(760, 57));
        setMinimumSize(new java.awt.Dimension(760, 57));
        setPreferredSize(new java.awt.Dimension(760, 57));

        jLabelDishId.setText("001");

        jLabelDishName.setText("Bàn 1");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_edit_green_x24.png"))); // NOI18N

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_dell_gray_x24.png"))); // NOI18N

        jLabelNote.setText("Chú thích");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabelDishId, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jLabelDishName, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelNote, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addContainerGap(77, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6))
                .addGap(17, 17, 17))
            .addComponent(jLabelDishId, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabelDishName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabelNote, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String name) {
        this.dishName = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelDishId;
    private javax.swing.JLabel jLabelDishName;
    private javax.swing.JLabel jLabelNote;
    // End of variables declaration//GEN-END:variables
}
