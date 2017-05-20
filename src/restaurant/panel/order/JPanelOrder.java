
package restaurant.panel.order;

import core.ComboboxItem;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.HashMap;
import javax.swing.JFrame;

public class JPanelOrder extends javax.swing.JPanel {
    public static JPanelOrder instance;
    private int tableId;
    private JPanelOrderDish jpOrderDish = new JPanelOrderDish();;
    private JPanelOrderDetail jpOrderDetail;
    private HashMap<Integer, JPanelOrderDetail> listJPanelOrderDetail = new HashMap<>();
    public JPanelOrder() {
        initComponents();
        initCustomComponents();
        jPanelOrderDish.add(jpOrderDish);
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

    public JPanelOrderDish getJpOrderDish() {
        return jpOrderDish;
    }

    public JPanelOrderDetail getJpOrderDetail() {
        return jpOrderDetail;
    }

    
    public HashMap<Integer, JPanelOrderDetail> getListJPanelOrderDetail() {
        return listJPanelOrderDetail;
    }
    

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        if(JPanelOrder.getInstance().getListJPanelOrderDetail().get(tableId) == null){
            jpOrderDetail = new JPanelOrderDetail(tableId, jPanelOrderDetail);
            JPanelOrder.getInstance().getListJPanelOrderDetail().put(tableId, jpOrderDetail);
        } else {
            jpOrderDetail = JPanelOrder.getInstance().getListJPanelOrderDetail().get(tableId);
        }
        jPanelOrderDetail.removeAll();
        jPanelOrderDetail.add(jpOrderDetail);
        this.tableId = tableId;
    }

    
    
    public static JPanelOrder getInstance() {
        if(instance == null) instance = new JPanelOrder();
        return instance;
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
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
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

        jPanelContent.setMinimumSize(new java.awt.Dimension(752, 463));

        jScrollPane2.setBorder(null);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setToolTipText("");
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jPanelOrderDetail.setForeground(java.awt.Color.yellow);
        jPanelOrderDetail.setMinimumSize(new java.awt.Dimension(290, 1000));
        jPanelOrderDetail.setPreferredSize(new java.awt.Dimension(290, 1000));
        jPanelOrderDetail.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));
        jScrollPane2.setViewportView(jPanelOrderDetail);

        jPanelOrderAction.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204)));

        jLabel3.setText("Thanh toan");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel3)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel3)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelOrderActionLayout = new javax.swing.GroupLayout(jPanelOrderAction);
        jPanelOrderAction.setLayout(jPanelOrderActionLayout);
        jPanelOrderActionLayout.setHorizontalGroup(
            jPanelOrderActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOrderActionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelOrderActionLayout.setVerticalGroup(
            jPanelOrderActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOrderActionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(111, Short.MAX_VALUE))
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
                    .addComponent(jPanelOrderAction, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)))
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
            .addComponent(jPanelHeader, javax.swing.GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE)
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelContent;
    private javax.swing.JPanel jPanelHeader;
    private javax.swing.JPanel jPanelOrderAction;
    private javax.swing.JPanel jPanelOrderDetail;
    private javax.swing.JPanel jPanelOrderDish;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextFieldSearchByName;
    // End of variables declaration//GEN-END:variables
}
