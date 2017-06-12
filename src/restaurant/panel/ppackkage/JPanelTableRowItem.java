/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.panel.ppackkage;
import assets.images.ImageResources;
import java.awt.Color;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import modal.MTable;
import view.VTable;

/**
 *
 * @author WINDNCC
 */
public class JPanelTableRowItem extends javax.swing.JPanel {
    protected String tableName;
    protected int id;
    protected String note;
    protected static Color oddBackground = new Color(224, 224, 235);
    public JPanelTableRowItem() {
        initComponents();
    }
    public JPanelTableRowItem(int tableId, String tableName, String note, boolean odd) {
        initComponents();
        this.id = tableId;
        this.tableName = tableName;
        this.note = note;
        if(odd){
            setBackground(oddBackground);
        }
        customInit();
    }
    public final void customInit(){
        jLabelTableId.setText(this.id + "");
        jLabelTableName.setText("<html><p>" + this.tableName + "</p></html>");
        if(this.note == null) this.note = " ";
        jLabelTableNote.setText("<html><p>" + this.note + "</p></html>");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTableId = new javax.swing.JLabel();
        jLabelTableName = new javax.swing.JLabel();
        jLabelEditTable = new javax.swing.JLabel();
        jLabelDelete = new javax.swing.JLabel();
        jLabelTableNote = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(760, 57));
        setMinimumSize(new java.awt.Dimension(760, 57));
        setPreferredSize(new java.awt.Dimension(760, 57));

        jLabelTableId.setText("001");

        jLabelTableName.setText("Bàn 1");

        jLabelEditTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_edit_darkgreen_x24.png"))); // NOI18N
        jLabelEditTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelEditTableMouseClicked(evt);
            }
        });

        jLabelDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_delete_dimgray_x32.png"))); // NOI18N
        jLabelDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelDeleteMouseClicked(evt);
            }
        });

        jLabelTableNote.setText("Chú thích");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabelTableId, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jLabelTableName, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelTableNote, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelEditTable, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelDelete)
                .addContainerGap(69, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelTableId, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabelTableName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabelTableNote, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabelEditTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(17, 17, 17))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteMouseClicked
        MTable mTable = new MTable(this.id);
        int check = JOptionPane.showConfirmDialog(JPanelManagementTable.getInstance(), "Bạn có chắc muốn xóa!");
        if(check == JOptionPane.YES_OPTION){
            try {
                mTable.delete();
                JOptionPane.showMessageDialog(this, "Xóa bàn thành công!");
                JPanelManagementTable.getInstance().listTable = VTable.getAllTable();
                JPanelManagementTable.getInstance().listJPTRI.remove(this.id);
                JPanelManagementTable.getInstance().filter();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Xóa bàn thất bại!");
            }
        }

    }//GEN-LAST:event_jLabelDeleteMouseClicked

    private void jLabelEditTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelEditTableMouseClicked

    public JLabel getjLabelEditTable() {
        return jLabelEditTable;
    }
    
    public String getTableName() {
        return tableName;
    }

    public void setTableName(String name) {
        jLabelTableName.setText(name);
        this.tableName = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        jLabelTableNote.setText(note);
        this.note = note;
    }

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelDelete;
    private javax.swing.JLabel jLabelEditTable;
    private javax.swing.JLabel jLabelTableId;
    private javax.swing.JLabel jLabelTableName;
    private javax.swing.JLabel jLabelTableNote;
    // End of variables declaration//GEN-END:variables
}
