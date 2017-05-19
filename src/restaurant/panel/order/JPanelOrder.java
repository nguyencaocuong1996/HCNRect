
package restaurant.panel.order;

import core.ComboboxItem;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JFrame;

public class JPanelOrder extends javax.swing.JPanel {
    JPanelOrderDish jpOrderDish;
    public JPanelOrder() {
        initComponents();
        initCustomComponents();
        jpOrderDish = new JPanelOrderDish();
        jPanelOrderDish.add(jpOrderDish);
        jPanelOrderDetail.add(new JPanelOrderDetail());
        
    }
    private void initCustomComponents(){
        ComboboxItem[] ci = new ComboboxItem[6];
        ci[0] = new ComboboxItem("Tất cả", 0);
        ci[1] = new ComboboxItem("Món chính", 2);
        ci[2] = new ComboboxItem("Khai vị", 1);
        ci[3] = new ComboboxItem("Tráng miệng", 3);
        ci[4] = new ComboboxItem("Đồ uống", 4);
        ci[5] = new ComboboxItem("Chưa phân loại", 5);
        for (ComboboxItem comboboxItem : ci) {
            jComboBoxSearchByMenu.addItem(comboboxItem);
        }
    }
    public void filter(){
        ComboboxItem ci = (ComboboxItem) jComboBoxSearchByMenu.getSelectedItem();
        int filterMenuId = (Integer) ci.getValue();
        String filterDishName = jTextFieldSearchByName.getText();
        if (jpOrderDish != null) {
            jpOrderDish.filter(filterMenuId, filterDishName);
        }
        this.revalidate();
        this.repaint();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelHeader = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldSearchByName = new javax.swing.JTextField();
        jComboBoxSearchByMenu = new javax.swing.JComboBox<>();
        jPanelContent = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanelOrderDetail = new javax.swing.JPanel();
        jPanelOrderAction = new javax.swing.JPanel();
        jPanelOrderDish = new javax.swing.JPanel();

        jPanelHeader.setPreferredSize(new java.awt.Dimension(752, 80));

        jLabel1.setText("Thực đơn");

        jLabel2.setText("Tìm theo tên");

        jTextFieldSearchByName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldSearchByNameKeyReleased(evt);
            }
        });

        jComboBoxSearchByMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSearchByMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelHeaderLayout = new javax.swing.GroupLayout(jPanelHeader);
        jPanelHeader.setLayout(jPanelHeaderLayout);
        jPanelHeaderLayout.setHorizontalGroup(
            jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addComponent(jComboBoxSearchByMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(38, 38, 38)
                .addComponent(jTextFieldSearchByName, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(177, 177, 177))
        );
        jPanelHeaderLayout.setVerticalGroup(
            jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHeaderLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBoxSearchByMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldSearchByName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanelOrderDetail);

        jPanelOrderAction.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout jPanelOrderActionLayout = new javax.swing.GroupLayout(jPanelOrderAction);
        jPanelOrderAction.setLayout(jPanelOrderActionLayout);
        jPanelOrderActionLayout.setHorizontalGroup(
            jPanelOrderActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelOrderActionLayout.setVerticalGroup(
            jPanelOrderActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 195, Short.MAX_VALUE)
        );

        jPanelOrderDish.setPreferredSize(new java.awt.Dimension(100, 100));

        javax.swing.GroupLayout jPanelContentLayout = new javax.swing.GroupLayout(jPanelContent);
        jPanelContent.setLayout(jPanelContentLayout);
        jPanelContentLayout.setHorizontalGroup(
            jPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContentLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jPanelOrderDish, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                    .addComponent(jPanelOrderAction, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanelContentLayout.setVerticalGroup(
            jPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContentLayout.createSequentialGroup()
                .addGroup(jPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelContentLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelOrderAction, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanelOrderDish, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanelContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setLayout(new FlowLayout());
        jf.setSize(new Dimension(1000,700));
        jf.add(new JPanelOrder());
        jf.setVisible(true);
    }
    private void jTextFieldSearchByNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSearchByNameKeyReleased
        filter();
    }//GEN-LAST:event_jTextFieldSearchByNameKeyReleased

    private void jComboBoxSearchByMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSearchByMenuActionPerformed
        filter();
    }//GEN-LAST:event_jComboBoxSearchByMenuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<ComboboxItem> jComboBoxSearchByMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanelContent;
    private javax.swing.JPanel jPanelHeader;
    private javax.swing.JPanel jPanelOrderAction;
    private javax.swing.JPanel jPanelOrderDetail;
    private javax.swing.JPanel jPanelOrderDish;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextFieldSearchByName;
    // End of variables declaration//GEN-END:variables
}
