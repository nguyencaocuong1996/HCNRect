/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.panel.transaction.bill;
import restaurant.panel.ppackkage.*;
import java.awt.Color;
import javax.swing.JLabel;
import modal.MMaterial;

/**
 *
 * @author WINDNCC
 */
public class JPanelBillRowItem extends javax.swing.JPanel {
    protected String date;
    protected int billId;
    protected float totalBill;
    protected float realBill;
    protected static Color oddBackground = new Color(224, 224, 235);
    public JPanelBillRowItem() {
        initComponents();
        customInit();
    }
    public JPanelBillRowItem(int billId, String date, float totalBill, float realBill, boolean odd) {
        initComponents();
        this.billId = billId;
        this.date = date;
        this.totalBill = totalBill;
        this.realBill = realBill;
        if(odd){
            setBackground(oddBackground);
        }
        customInit();
    }
    public final void customInit(){
        jLabelBillId.setText(this.billId + "");
        jLabelDate.setText(this.date);
        jLabelTotalBill.setText(this.totalBill + "");
        jLabelRealBill.setText(this.realBill + "");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelBillId = new javax.swing.JLabel();
        jLabelDate = new javax.swing.JLabel();
        jLabelTotalBill = new javax.swing.JLabel();
        jLabelEdit = new javax.swing.JLabel();
        jLabelDelete = new javax.swing.JLabel();
        jLabelRealBill = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(760, 57));
        setMinimumSize(new java.awt.Dimension(760, 57));
        setPreferredSize(new java.awt.Dimension(760, 57));

        jLabelBillId.setText("001");

        jLabelDate.setText("Thịt xông khói");

        jLabelTotalBill.setText("120000000");

        jLabelEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_edit_green_x24.png"))); // NOI18N
        jLabelEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelEditMouseClicked(evt);
            }
        });

        jLabelDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_dell_gray_x24.png"))); // NOI18N
        jLabelDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelDeleteMouseClicked(evt);
            }
        });

        jLabelRealBill.setText("limit");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelBillId, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelDate, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelTotalBill, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelRealBill, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(jLabelEdit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelDelete)
                .addContainerGap(141, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelTotalBill, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelDelete)
                    .addComponent(jLabelEdit))
                .addGap(17, 17, 17))
            .addComponent(jLabelDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabelBillId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabelRealBill, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteMouseClicked
        // TODO add your handling code here:
        try {
            MMaterial mMaterial = new MMaterial(billId);
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
        return date;
    }

    public void setDishName(String name) {
        this.date = name;
    }

    public int getId() {
        return billId;
    }

    public void setId(int id) {
        this.billId = id;
    }

    public float getPrice() {
        return totalBill;
    }

    public void setPrice(float price) {
        this.totalBill = price;
    }

    public void setLimit(Float limit){
        this.realBill = limit;
    }
    public JLabel getjLabelDelete() {
        return jLabelDelete;
    }

    public JLabel getjLabelEdit() {
        return jLabelEdit;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelBillId;
    private javax.swing.JLabel jLabelDate;
    private javax.swing.JLabel jLabelDelete;
    private javax.swing.JLabel jLabelEdit;
    private javax.swing.JLabel jLabelRealBill;
    private javax.swing.JLabel jLabelTotalBill;
    // End of variables declaration//GEN-END:variables
}
