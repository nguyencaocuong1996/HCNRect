
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
    public void updateBill(){
        JPanelOrderDetail jpOD = listJPanelOrderDetail.get(getTableId());
        Float discount = new Float(0);
        Float amountPay = new Float(0);
        try{
            discount = new Float(jTextFieldDiscount.getText());
        } catch(NumberFormatException e) {
            jTextFieldDiscount.setText(0+"");
        }
        try{
            amountPay = new Float(jTextFieldAmountPay.getText());
        } catch(NumberFormatException e) {
            jTextFieldAmountPay.setText(0+"");
        }
        
        float total = jpOD.getTotalBill() - discount;
        jLabelTotalBill.setText(total+" VNĐ");
        jLabelCharge.setText((amountPay - total) + " VNĐ");
    }
    public void setTableId(int tableId) {
        if(JPanelOrder.getInstance().getListJPanelOrderDetail().get(tableId) == null){
            System.out.println("setTableID in JPanelOrder.java : Bàn chưa tồn tại instance, tạo bàn mới!");
            jpOrderDetail = new JPanelOrderDetail(tableId, jPanelOrderDetail);
            JPanelOrder.getInstance().getListJPanelOrderDetail().put(tableId, jpOrderDetail);
        } else {
            System.out.println("setTableID in JPanelOrder.java : Bàn đã tồn tại instance, không cần tạo!");
            jpOrderDetail = JPanelOrder.getInstance().getListJPanelOrderDetail().get(tableId);
        }
        jPanelOrderDetail.removeAll();
        jPanelOrderDetail.add(jpOrderDetail);
        this.tableId = tableId;
        updateBill();
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
        jPanelToPayTheBill = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabelTotalBill = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabelCharge = new javax.swing.JLabel();
        jTextFieldAmountPay = new javax.swing.JTextField();
        jTextFieldDiscount = new javax.swing.JTextField();
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxSearchByMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldSearchByName, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        jPanelToPayTheBill.setBackground(new java.awt.Color(147, 193, 120));
        jPanelToPayTheBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelToPayTheBillMouseClicked(evt);
            }
        });
        jPanelToPayTheBill.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 10));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_payment2_white_x32.png"))); // NOI18N
        jLabel3.setText("Thanh toán");
        jPanelToPayTheBill.add(jLabel3);

        jLabel4.setText("Giảm giá");

        jLabelTotalBill.setForeground(new java.awt.Color(255, 102, 102));
        jLabelTotalBill.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabelTotalBill.setText("0.0 VNĐ");

        jLabel6.setText("Tổng tiền");

        jLabel7.setText("Đã đưa");

        jLabel8.setText("Tiền thừa");

        jLabelCharge.setText("0.0 VNĐ");

        jTextFieldAmountPay.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jTextFieldAmountPay.setText("0");
        jTextFieldAmountPay.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldAmountPayKeyReleased(evt);
            }
        });

        jTextFieldDiscount.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jTextFieldDiscount.setText("0");
        jTextFieldDiscount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldDiscountKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanelOrderActionLayout = new javax.swing.GroupLayout(jPanelOrderAction);
        jPanelOrderAction.setLayout(jPanelOrderActionLayout);
        jPanelOrderActionLayout.setHorizontalGroup(
            jPanelOrderActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOrderActionLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanelOrderActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelOrderActionLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelCharge))
                    .addComponent(jPanelToPayTheBill, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelOrderActionLayout.createSequentialGroup()
                        .addGroup(jPanelOrderActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelOrderActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldAmountPay, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                            .addComponent(jLabelTotalBill, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldDiscount))))
                .addContainerGap())
        );
        jPanelOrderActionLayout.setVerticalGroup(
            jPanelOrderActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOrderActionLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanelOrderActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelOrderActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabelTotalBill))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelOrderActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextFieldAmountPay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelOrderActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabelCharge))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelToPayTheBill, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9))
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
            .addComponent(jPanelHeader, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
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

    private void jTextFieldDiscountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDiscountKeyReleased
        updateBill();
    }//GEN-LAST:event_jTextFieldDiscountKeyReleased

    private void jTextFieldAmountPayKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldAmountPayKeyReleased
        updateBill();
    }//GEN-LAST:event_jTextFieldAmountPayKeyReleased

    private void jPanelToPayTheBillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelToPayTheBillMouseClicked
        System.out.println("thuc dien thanh toan");
    }//GEN-LAST:event_jPanelToPayTheBillMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<ComboboxItem> jComboBoxSearchByMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelCharge;
    private javax.swing.JLabel jLabelTotalBill;
    private javax.swing.JPanel jPanelContent;
    private javax.swing.JPanel jPanelHeader;
    private javax.swing.JPanel jPanelOrderAction;
    private javax.swing.JPanel jPanelOrderDetail;
    private javax.swing.JPanel jPanelOrderDish;
    private javax.swing.JPanel jPanelToPayTheBill;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextFieldAmountPay;
    private javax.swing.JTextField jTextFieldDiscount;
    private javax.swing.JTextField jTextFieldSearchByName;
    // End of variables declaration//GEN-END:variables
}
