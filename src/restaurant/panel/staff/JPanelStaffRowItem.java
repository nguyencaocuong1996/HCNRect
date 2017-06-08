/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.panel.staff;
import restaurant.panel.ppackkage.*;
import assets.images.ImageResources;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import modal.MStaff;
import restaurant.panel.partner.JPanelManagementSupplier;

/**
 *
 * @author WINDNCC
 */
public class JPanelStaffRowItem extends javax.swing.JPanel {
    //protected String materialName;
    protected int maNV;
    protected String tenNV;
    protected String soDienThoai;
    protected String diaChi;
    protected static Color oddBackground = new Color(224, 224, 235);
    public JPanelStaffRowItem() {
        initComponents();
    }
    public JPanelStaffRowItem(int staffID, String staffName, String phonenumber, String address, boolean odd) {
        initComponents();
        this.maNV = staffID;
        this.tenNV = staffName;
        this.soDienThoai = phonenumber;
        this.diaChi = address;
        
        if(odd){
            setBackground(oddBackground);
        }
        customInit();
    }
    public void customInit(){
        jLabelStaffId.setText(this.maNV + "");
        jLabelStaffName.setText("<html><p>" + this.tenNV + "</p></html>");
        jLabelStaffPhoneNumber.setText(this.soDienThoai + " ");
        jLabelStaffAddress.setText(this.diaChi + " ");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelStaffId = new javax.swing.JLabel();
        jLabelStaffName = new javax.swing.JLabel();
        jLabelStaffPhoneNumber = new javax.swing.JLabel();
        jLabelEdit = new javax.swing.JLabel();
        jLabelDelete = new javax.swing.JLabel();
        jLabelStaffAddress = new javax.swing.JLabel();
        jLabelAddUser = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(760, 57));
        setMinimumSize(new java.awt.Dimension(760, 57));
        setPreferredSize(new java.awt.Dimension(760, 57));

        jLabelStaffId.setText("001");

        jLabelStaffName.setText("Thịt xông khói");

        jLabelStaffPhoneNumber.setText("120000000");

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

        jLabelStaffAddress.setText("limit");

        jLabelAddUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_user_darkgreen_x32.png"))); // NOI18N
        jLabelAddUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAddUserMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelStaffId, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabelStaffName, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(jLabelStaffPhoneNumber)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                .addComponent(jLabelStaffAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelEdit)
                .addGap(18, 18, 18)
                .addComponent(jLabelDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelAddUser)
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelStaffAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabelStaffPhoneNumber, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabelStaffName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabelStaffId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelAddUser)
                    .addComponent(jLabelDelete)
                    .addComponent(jLabelEdit))
                .addGap(17, 17, 17))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteMouseClicked
        int check = JOptionPane.showConfirmDialog(JPanelManagementSupplier.getInstance(), "Xác nhận xóa?");
        if (check == JOptionPane.YES_OPTION) {
            try {
            MStaff mStaff = new MStaff(maNV);
            mStaff.delete();
            JPanelManagementStaff.getInstance().getjPanelTableContent().remove(this);
            JPanelManagementStaff.getInstance().getjPanelTableContent().revalidate();
            JPanelManagementStaff.getInstance().getjPanelTableContent().repaint();
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_jLabelDeleteMouseClicked

    public JLabel getjLabelEditStaff() {
        return jLabelEdit;
    }
    public JLabel getjLabelAddUserStaff(){
        return jLabelAddUser;
    }
    private void jLabelEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelEditMouseClicked

    private void jLabelAddUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAddUserMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jLabelAddUserMouseClicked

    

    

    public JLabel getjLabelDelete() {
        return jLabelDelete;
    }

    public JLabel getjLabelEdit() {
        return jLabelEdit;
    }

    
    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }
    
    public void setDiaChi(String diaChi){
        this.diaChi = diaChi;
    }

    public static Color getOddBackground() {
        return oddBackground;
    }

    public static void setOddBackground(Color oddBackground) {
        JPanelStaffRowItem.oddBackground = oddBackground;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelAddUser;
    private javax.swing.JLabel jLabelDelete;
    private javax.swing.JLabel jLabelEdit;
    private javax.swing.JLabel jLabelStaffAddress;
    private javax.swing.JLabel jLabelStaffId;
    private javax.swing.JLabel jLabelStaffName;
    private javax.swing.JLabel jLabelStaffPhoneNumber;
    // End of variables declaration//GEN-END:variables
}
