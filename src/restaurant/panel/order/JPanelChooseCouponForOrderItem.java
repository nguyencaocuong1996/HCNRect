/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.panel.order;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import modal.MCoupon;
import modal.MCustomer;

/**
 *
 * @author WINDNCC
 */
public class JPanelChooseCouponForOrderItem extends javax.swing.JPanel {

    protected String couponId;
    protected float couponDiscount;
    protected String startDate;
    protected String endDate;

    public JPanelChooseCouponForOrderItem(String couponId, float couponDiscount, String endDate, String startDate) {
        initComponents();
        this.couponId = couponId;
        this.couponDiscount = couponDiscount;
        this.endDate = endDate;
        this.startDate = startDate;
        customInit();
    }
    
    private void customInit(){
        this.jLabelCouponId.setText(this.couponId);
        this.jLabelStartDate.setText(this.startDate);
        this.jLabelEndDate.setText(this.endDate);
        this.jLabelDiscount.setText(this.couponDiscount+"%");
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MCoupon coupon = new MCoupon();
                coupon.setCouponId(couponId);
                coupon.setCouponDiscount(couponDiscount);
                coupon.setStartDate(startDate);
                coupon.setEndDate(endDate);
                JPanelOrder.getInstance().setCoupon(coupon);
                JPanelOrder.getInstance().getjDialogChooseCoupon().setVisible(false);
            }
            
        });
    }
    public JPanelChooseCouponForOrderItem() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelStartDate = new javax.swing.JLabel();
        jLabelCouponId = new javax.swing.JLabel();
        jLabelEndDate = new javax.swing.JLabel();
        jLabelDiscount = new javax.swing.JLabel();

        setBackground(new java.awt.Color(70, 92, 139));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setMaximumSize(new java.awt.Dimension(400, 40));
        setMinimumSize(new java.awt.Dimension(400, 40));
        setPreferredSize(new java.awt.Dimension(400, 40));

        jLabelStartDate.setForeground(new java.awt.Color(255, 255, 255));
        jLabelStartDate.setText("Ngày bắt đầu");

        jLabelCouponId.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCouponId.setText("Mã giảm giá");

        jLabelEndDate.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEndDate.setText("Ngày kết thúc");

        jLabelDiscount.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDiscount.setText("Phần trăm");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabelCouponId, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabelStartDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelCouponId, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabelEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabelDiscount))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelCouponId;
    private javax.swing.JLabel jLabelDiscount;
    private javax.swing.JLabel jLabelEndDate;
    private javax.swing.JLabel jLabelStartDate;
    // End of variables declaration//GEN-END:variables
}
