/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.panel.order;

import core.CDateTime;
import java.awt.Dimension;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JFrame;
import view.VCoupon;

/**
 *
 * @author WINDNCC
 */
public class JPanelChooseCouponForOrder extends javax.swing.JPanel {

    public static JPanelChooseCouponForOrder instance;
    public VCoupon vCoupon;
    public HashMap<String, JPanelChooseCouponForOrderItem> listJPCCFOI = new HashMap<>();
    public static JPanelChooseCouponForOrder getInstance() {
        if (instance == null) {
            instance = new JPanelChooseCouponForOrder();
        }
        return instance;
    }
    
    public JPanelChooseCouponForOrder() {
        initComponents();
        try {
            vCoupon = VCoupon.getAvailableCoupon();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        vCoupon.getData().forEach((t) -> {
            String id = (String) t.get("MaPGG");
            String startDate = (CDateTime.dateToString((Date) t.get("NgayBatDau")));;
            String endDate = (CDateTime.dateToString((Date) t.get("NgayKetThuc")));
            float discount = (Float) t.get("PhanTramGiamGia");
            JPanelChooseCouponForOrderItem newJPCCPOI = new JPanelChooseCouponForOrderItem(id, discount, startDate, endDate);
            listJPCCFOI.put(id, newJPCCPOI);
            
        });
        showView();
    }
    public final void showView(){
        jPanelContent.removeAll();
        vCoupon.getFilterData().forEach((t) -> {
            jPanelContent.add(listJPCCFOI.get((String) t.get("MaPGG")));
        });
        int height = vCoupon.getFilterData().size() * 50;
//        System.out.println(height);
        jPanelContent.setPreferredSize(new Dimension(400, height));
        jPanelContent.revalidate();
        jPanelContent.repaint();
    }
    public void filter(String kw){
        vCoupon.filter(kw);
        showView();
    }
    
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setSize(new Dimension(500,500));
        jf.add(JPanelChooseCouponForOrder.getInstance());
        jf.setVisible(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelHeader = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldFilterKeyword = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanelContent = new javax.swing.JPanel();

        setMaximumSize(new java.awt.Dimension(400, 310));
        setMinimumSize(new java.awt.Dimension(400, 310));

        jPanelHeader.setBackground(new java.awt.Color(147, 193, 120));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_management_add_x32.png"))); // NOI18N
        jLabel1.setText("Tìm:");

        jTextFieldFilterKeyword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldFilterKeywordKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanelHeaderLayout = new javax.swing.GroupLayout(jPanelHeader);
        jPanelHeader.setLayout(jPanelHeaderLayout);
        jPanelHeaderLayout.setHorizontalGroup(
            jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHeaderLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldFilterKeyword, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelHeaderLayout.setVerticalGroup(
            jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldFilterKeyword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setMaximumSize(new java.awt.Dimension(400, 250));
        jScrollPane1.setMinimumSize(new java.awt.Dimension(400, 250));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(400, 250));

        jPanelContent.setBackground(new java.awt.Color(70, 92, 139));
        jPanelContent.setMaximumSize(new java.awt.Dimension(400, 250));
        jPanelContent.setMinimumSize(new java.awt.Dimension(400, 250));
        jPanelContent.setPreferredSize(new java.awt.Dimension(400, 250));
        jScrollPane1.setViewportView(jPanelContent);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldFilterKeywordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldFilterKeywordKeyReleased
        filter(jTextFieldFilterKeyword.getText());
    }//GEN-LAST:event_jTextFieldFilterKeywordKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanelContent;
    private javax.swing.JPanel jPanelHeader;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldFilterKeyword;
    // End of variables declaration//GEN-END:variables
}
