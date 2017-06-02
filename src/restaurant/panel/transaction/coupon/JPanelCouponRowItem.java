/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.panel.transaction.coupon;
import java.awt.Color;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import modal.MCoupon;

/**
 *
 * @author WINDNCC
 */
public class JPanelCouponRowItem extends javax.swing.JPanel {
    protected MCoupon coupon;
    protected static Color oddBackground = new Color(224, 224, 235);
    public JPanelCouponRowItem() {
        initComponents();
        customInit();
    }
    public JPanelCouponRowItem(MCoupon coupon, boolean odd) {
        initComponents();
        this.coupon = coupon;
        if(odd){
            setBackground(oddBackground);
        }
        customInit();
    }
    public void update(MCoupon c){
        jLabelCouponId.setText(c.getCouponId());
        jLabelEndDate.setText(c.getEndDate());
        jLabelStartDate.setText(c.getStartDate());
        jLabelPercentDiscount.setText(c.getCouponDiscount()+"");
    }
    public final void customInit(){
        jLabelCouponId.setText(coupon.getCouponId());
        jLabelEndDate.setText(coupon.getEndDate());
        jLabelStartDate.setText(coupon.getStartDate());
        jLabelPercentDiscount.setText(coupon.getCouponDiscount()+"%");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelCouponId = new javax.swing.JLabel();
        jLabelEndDate = new javax.swing.JLabel();
        jLabelPercentDiscount = new javax.swing.JLabel();
        jLabelEditCoupon = new javax.swing.JLabel();
        jLabelStartDate = new javax.swing.JLabel();
        jLabelDeleteCoupon = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(760, 57));
        setMinimumSize(new java.awt.Dimension(760, 57));
        setPreferredSize(new java.awt.Dimension(760, 57));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelCouponId.setText("HCNXXX");
        add(jLabelCouponId, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 180, 50));

        jLabelEndDate.setText("Ngày kết thúc");
        add(jLabelEndDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 110, 50));

        jLabelPercentDiscount.setText("Phần trăm giảm giá");
        add(jLabelPercentDiscount, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 0, -1, 50));

        jLabelEditCoupon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_edit_darkgreen_x24.png"))); // NOI18N
        jLabelEditCoupon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelEditCouponMouseClicked(evt);
            }
        });
        add(jLabelEditCoupon, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 10, 30, 30));

        jLabelStartDate.setText("ngày bắt đầu");
        add(jLabelStartDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 110, 50));

        jLabelDeleteCoupon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_delete_dimgray_x32.png"))); // NOI18N
        jLabelDeleteCoupon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelDeleteCouponMouseClicked(evt);
            }
        });
        add(jLabelDeleteCoupon, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 10, 30, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelEditCouponMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditCouponMouseClicked
        JPanelManagementCoupon.getInstance().setCurrentEditCoupon(this.coupon);
        JPanelManagementCoupon.getInstance().getjDialogEditCoupon().setVisible(true);
    }//GEN-LAST:event_jLabelEditCouponMouseClicked

    private void jLabelDeleteCouponMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDeleteCouponMouseClicked
        int check = JOptionPane.showConfirmDialog(this, "Xác nhận xóa?");
        if(check == JOptionPane.YES_OPTION){
            try {
                coupon.delete();
                JPanelManagementCoupon.getInstance().getListJPCRI().remove(coupon.getCouponId());
                JPanelManagementCoupon.getInstance().filter();
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Có lỗi xảy ra, không thể xóa!");
            }
              
        }
    }//GEN-LAST:event_jLabelDeleteCouponMouseClicked

    public JLabel getjLabelEdit() {
        return jLabelEditCoupon;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelCouponId;
    private javax.swing.JLabel jLabelDeleteCoupon;
    private javax.swing.JLabel jLabelEditCoupon;
    private javax.swing.JLabel jLabelEndDate;
    private javax.swing.JLabel jLabelPercentDiscount;
    private javax.swing.JLabel jLabelStartDate;
    // End of variables declaration//GEN-END:variables
}
