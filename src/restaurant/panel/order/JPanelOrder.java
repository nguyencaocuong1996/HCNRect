
package restaurant.panel.order;

import core.CDateTime;
import core.CString;
import core.ComboboxItem;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modal.MBill;
import modal.MBillDetail;
import modal.MCoupon;
import modal.MCustomer;
import modal.MCustomerType;
import modal.MStaff;
import modal.MTable;
import net.sf.jasperreports.engine.JRException;
import restaurant.MainFrame;
import restaurant.panel.PanelFactory;
import restaurant.report.ReportResources;
import view.VDishOrdering;
import view.VMenu;
public class JPanelOrder extends javax.swing.JPanel {
    public static JPanelOrder instance;
    private int tableId;
    private JPanelOrderDish jpOrderDish = new JPanelOrderDish();
    private JPanelOrderDetail jpOrderDetail;
    private MCustomer customer;
    private MCustomerType customerType;
    private MCoupon coupon;
    float discount;
    float amountPay;
    float amountHaveToPay;
    private HashMap<Integer, JPanelOrderDetail> listJPanelOrderDetail = new HashMap<>();
    public JPanelOrder() {
        initComponents();
        initCustomComponents();
        jPanelOrderDish.add(jpOrderDish);
    }
    private void initCustomComponents(){
        try {
            VMenu vMenu = VMenu.getAllMenu();
//            System.out.println(vMenu.getData());
            ComboboxItem defaultCi = new ComboboxItem("Tất cả", 0);
            jComboBoxSearchByMenu.addItem(defaultCi);
            ArrayList<ComboboxItem> ci = new ArrayList<>();
            vMenu.getData().forEach((t) -> {
                String menuName = (String) t.get("TenTD");
                int menuId = ((Long) t.get("MaTD")).intValue();
                ci.add(new ComboboxItem(menuName, menuId));
            });
            ci.forEach((t) -> {
                jComboBoxSearchByMenu.addItem(t);
            });
        } catch (SQLException e) {
            e.printStackTrace();
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
        Float percentDiscount = new Float(0);
        if(this.coupon != null){
            jLabelShowChooseCoupon.setText("Mã phiếu: " + coupon.getCouponId() + " - Giảm " + coupon.getCouponDiscount() + "%");
            percentDiscount += coupon.getCouponDiscount();
        }
        if(this.customer != null){
                jLabelChooseCustomer.setText(customer.getFullName() + " - " + customer.getPhone());
                percentDiscount += customerType.getPercent();
        }
        discount = jpOD.getTotalBill() * percentDiscount / 100;
        try{
            if (!jTextFieldAmountPay.getText().equals("")) {
                amountPay = new Float(jTextFieldAmountPay.getText());
            }
        } catch(NumberFormatException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Chỉ được phép nhập số!", "Lỗi nhập liệu!", JOptionPane.ERROR_MESSAGE);
            jTextFieldAmountPay.setText(0+"");
        }
        
        amountHaveToPay = jpOD.getTotalBill() - discount;
        jLabelAmountDiscount.setText(CString.toMoney(discount));
        jLabelTotalBill.setText(CString.toMoney(jpOD.getTotalBill()));
        jLabelAmountHaveToPay.setText(CString.toMoney(amountHaveToPay));
        jLabelCharge.setText(CString.toMoney((amountPay - amountHaveToPay)));
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

    public MCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(MCustomer customer) {
        this.customer = customer;
        try {
            this.customerType = MCustomerType.get(customer.getCustomerTypeId());
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi không lấy được thông tin loại khách hàng");
            return;
        }
        
        updateBill();
    }

    public JDialog getjDialogChooseCustomer() {
        return jDialogChooseCustomer;
    }

    public JDialog getjDialogChooseCoupon() {
        return jDialogChooseCoupon;
    }

    
    
    public static JPanelOrder getInstance() {
        if(instance == null) instance = new JPanelOrder();
        return instance;
    }

    public MCoupon getCoupon() {
        return coupon;
    }

    public void setCoupon(MCoupon coupon) {
        this.coupon = coupon;
        updateBill();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialogChooseCustomer = new javax.swing.JDialog();
        jDialogChooseCoupon = new javax.swing.JDialog();
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
        jLabelShowChooseCoupon = new javax.swing.JLabel();
        jLabelTotalBill = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabelCharge = new javax.swing.JLabel();
        jTextFieldAmountPay = new javax.swing.JTextField();
        jLabelChooseCustomer = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabelAmountDiscount = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabelAmountHaveToPay = new javax.swing.JLabel();
        jPanelOrderDish = new javax.swing.JPanel();

        jDialogChooseCustomer.setMaximumSize(new java.awt.Dimension(410, 340));
        jDialogChooseCustomer.setMinimumSize(new java.awt.Dimension(410, 340));
        jDialogChooseCustomer.setPreferredSize(new java.awt.Dimension(410, 340));
        jDialogChooseCustomer.getContentPane().setLayout(new java.awt.FlowLayout());

        jDialogChooseCoupon.setMinimumSize(new java.awt.Dimension(410, 340));
        jDialogChooseCoupon.getContentPane().setLayout(new java.awt.FlowLayout());

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
        jPanelOrderDetail.setMinimumSize(new java.awt.Dimension(290, 0));
        jPanelOrderDetail.setPreferredSize(new java.awt.Dimension(290, 0));
        jPanelOrderDetail.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));
        jScrollPane2.setViewportView(jPanelOrderDetail);

        jPanelOrderAction.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204)));

        jPanelToPayTheBill.setBackground(new java.awt.Color(147, 193, 120));
        jPanelToPayTheBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelToPayTheBillMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_payment2_white_x32.png"))); // NOI18N
        jLabel3.setText("Thanh toán");
        jPanelToPayTheBill.add(jLabel3);

        jLabelShowChooseCoupon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_discount_darkgreen _x24.png"))); // NOI18N
        jLabelShowChooseCoupon.setText("Click chọn phiếu giảm giá");
        jLabelShowChooseCoupon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelShowChooseCouponMouseClicked(evt);
            }
        });

        jLabelTotalBill.setForeground(new java.awt.Color(255, 102, 102));
        jLabelTotalBill.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelTotalBill.setText("0.0 VNĐ");

        jLabel6.setText("Tổng tiền: ");

        jLabel7.setText("Đã đưa:");

        jLabel8.setText("Tiền thừa:");

        jLabelCharge.setText("0.0 VNĐ");

        jTextFieldAmountPay.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jTextFieldAmountPay.setText("0");
        jTextFieldAmountPay.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldAmountPayFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldAmountPayFocusLost(evt);
            }
        });
        jTextFieldAmountPay.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldAmountPayKeyReleased(evt);
            }
        });

        jLabelChooseCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_user_darkgreen_x32.png"))); // NOI18N
        jLabelChooseCustomer.setText("Click để chọn khách hàng");
        jLabelChooseCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelChooseCustomerMouseClicked(evt);
            }
        });

        jLabel4.setText("Được giảm: ");

        jLabelAmountDiscount.setForeground(new java.awt.Color(0, 153, 0));
        jLabelAmountDiscount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelAmountDiscount.setText("0.0 VNĐ");

        jLabel9.setText("Số tiền phải thanh toán:");

        jLabelAmountHaveToPay.setForeground(new java.awt.Color(0, 0, 204));
        jLabelAmountHaveToPay.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelAmountHaveToPay.setText("0.0 VNĐ");

        javax.swing.GroupLayout jPanelOrderActionLayout = new javax.swing.GroupLayout(jPanelOrderAction);
        jPanelOrderAction.setLayout(jPanelOrderActionLayout);
        jPanelOrderActionLayout.setHorizontalGroup(
            jPanelOrderActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelChooseCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabelShowChooseCoupon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelOrderActionLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanelOrderActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelOrderActionLayout.createSequentialGroup()
                        .addGroup(jPanelOrderActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelOrderActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelOrderActionLayout.createSequentialGroup()
                                .addGap(0, 69, Short.MAX_VALUE)
                                .addGroup(jPanelOrderActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldAmountPay, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelCharge, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addComponent(jLabelAmountHaveToPay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanelOrderActionLayout.createSequentialGroup()
                        .addGroup(jPanelOrderActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelOrderActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelAmountDiscount, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                            .addComponent(jLabelTotalBill, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(10, 10, 10))
            .addComponent(jPanelToPayTheBill, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelOrderActionLayout.setVerticalGroup(
            jPanelOrderActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOrderActionLayout.createSequentialGroup()
                .addComponent(jLabelShowChooseCoupon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelChooseCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelOrderActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabelTotalBill))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelOrderActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabelAmountDiscount))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelOrderActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabelAmountHaveToPay))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelOrderActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldAmountPay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelOrderActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabelCharge))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelToPayTheBill, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)))
        );
        jPanelContentLayout.setVerticalGroup(
            jPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContentLayout.createSequentialGroup()
                .addGroup(jPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelContentLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelOrderAction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void jTextFieldAmountPayKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldAmountPayKeyReleased
        updateBill();
    }//GEN-LAST:event_jTextFieldAmountPayKeyReleased

    private void jPanelToPayTheBillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelToPayTheBillMouseClicked
        System.out.println("jPanelToPayTheBillMouseClicked in JPanelOrder.java: " + ReportResources.RP_BILL);
        
        
        int confirm = JOptionPane.showConfirmDialog(this, "Thực hiện thanh toán? Không thể hoàn tác.");
        if(confirm == JOptionPane.YES_OPTION){
            try { 
                MStaff staff = MainFrame.getInstance().getStaff(); //Lấy ra nhân viên đang đăng nhập
                JPanelOrderDetail jpOD = listJPanelOrderDetail.get(getTableId()); // Lấy ra PanelDetail của table hiện tại
                MBill mBill = new MBill(); // Tạo ra một instance hóa đơn mới 
                if (customer != null) { //Nếu đã chọn khách hàng
                    mBill.setCustomerId(customer.getId()); // thì gán id khách hàng cho hóa đơn
                } else {
                    mBill.setCustomerId(0); //Ngược lại hóa đơn lấy id khách hàng = 0
                }
                mBill.setStaffId(staff.getId()); // gán mã nhân viên cho hóa đơn
                mBill.setTotalBill(jpOD.getTotalBill()); //Gán giá trị (chưa tính giảm giá)
                mBill.setRealBill(jpOD.getTotalBill() - discount); //gán giá trị thực hóa đơn (sau khi giảm giá)
                mBill.setDateTimeBill(CDateTime.getInstance().toString()); // gán thời gian hiện tại cho hóa đơn
                mBill.setTableId(getTableId()); // gán mã bàn hiện tại
                if (coupon != null) mBill.setCouponCode(coupon.getCouponId()); //Gán mã giảm giá nếu có
                
                try {
                    mBill.insert(); // thêm hóa đơn vào database
                    mBill = MBill.getLastBill(); // lấy hóa đơn vừa thêm
                    for(JPanelOrderItem jpOI : jpOD.getListDishOrdering()){ // duyệt mảng chứa các món ăn đang được chọn
                        MBillDetail mBD = new MBillDetail(); // tạo ra 1 instance chi tiết hóa đơn
                        mBD.setBillId(mBill.getId()); // gán mã hóa đơn cho nó
                        mBD.setDishId(jpOI.getDishId()); // gán tên món ăn
                        mBD.setQuantity(jpOI.getQuantity()); // gán số lượng đặt
                        mBD.insert(); // thêm vào DB
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    return;
                }
                //tạo báo cáo
                Map<String, Object> params = new HashMap<>(); // Mảng tham số truyền vào báo cáo
                
                params.put("MaHD", mBill.getId());
                MTable mTable = MTable.getById(mBill.getTableId()); //Tạo ra 1 record table lấy từ database
                params.put("TenBan", mTable.getName());
                
                MCustomer mc = MCustomer.getByID(mBill.getCustomerId());
                params.put("HoTenKH", mc.getFullName());
                params.put("HoTenNV", staff.getName());
                params.put("SDTKH", mc.getPhone());
                params.put("TongTien", CString.toMoney(jpOD.getTotalBill()));
                params.put("GiamGia", CString.toMoney(discount));
                params.put("TienPhaiThanhToan", CString.toMoney(jpOD.getTotalBill() - discount));
                params.put("SoTienKhachHangDua", CString.toMoney(amountPay));
                params.put("SoTienThoiLai", CString.toMoney(amountPay - amountHaveToPay));
                params.put("MaNV", staff.getId());
                ReportResources.showReport(ReportResources.RP_BILL, params);
                VDishOrdering.deleteOrdering(getTableId()); // Xóa toàn bộ chi tiết đặt món liên quan đến bàn này trong database
                jpOD.removeAllOrderItem();//xóa toàn bộ chi tiết đặt món trên màn hình
                MainFrame.getInstance().changeContentPanel(PanelFactory.get(PanelFactory.ID.ORDER_PICK_TABLE));
                MainFrame.getInstance().changeHeaderPanel(PanelFactory.get(PanelFactory.ID.HEADER_ORDER_PICK_TABLE));
                
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (JRException ex) {
                Logger.getLogger(JPanelOrder.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            return;
        }
        
    }//GEN-LAST:event_jPanelToPayTheBillMouseClicked

    private void jTextFieldAmountPayFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldAmountPayFocusGained
        if(jTextFieldAmountPay.getText().equals("0")){
            jTextFieldAmountPay.setText("");
        }
    }//GEN-LAST:event_jTextFieldAmountPayFocusGained

    private void jTextFieldAmountPayFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldAmountPayFocusLost
        if(jTextFieldAmountPay.getText().equals("")){
            jTextFieldAmountPay.setText("0");
        }
    }//GEN-LAST:event_jTextFieldAmountPayFocusLost

    private void jLabelChooseCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelChooseCustomerMouseClicked
        jDialogChooseCustomer.setLocationRelativeTo(MainFrame.getInstance());
        jDialogChooseCustomer.add(JPanelChooseCustomerForOrder.getInstance());
        jDialogChooseCustomer.setVisible(true);
    }//GEN-LAST:event_jLabelChooseCustomerMouseClicked

    private void jLabelShowChooseCouponMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelShowChooseCouponMouseClicked
        jDialogChooseCoupon.setLocationRelativeTo(MainFrame.getInstance());
        jDialogChooseCoupon.add(JPanelChooseCouponForOrder.getInstance());
        jDialogChooseCoupon.setVisible(true);
    }//GEN-LAST:event_jLabelShowChooseCouponMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<ComboboxItem> jComboBoxSearchByMenu;
    private javax.swing.JDialog jDialogChooseCoupon;
    private javax.swing.JDialog jDialogChooseCustomer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelAmountDiscount;
    private javax.swing.JLabel jLabelAmountHaveToPay;
    private javax.swing.JLabel jLabelCharge;
    private javax.swing.JLabel jLabelChooseCustomer;
    private javax.swing.JLabel jLabelShowChooseCoupon;
    private javax.swing.JLabel jLabelTotalBill;
    private javax.swing.JPanel jPanelContent;
    private javax.swing.JPanel jPanelHeader;
    private javax.swing.JPanel jPanelOrderAction;
    private javax.swing.JPanel jPanelOrderDetail;
    private javax.swing.JPanel jPanelOrderDish;
    private javax.swing.JPanel jPanelToPayTheBill;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextFieldAmountPay;
    private javax.swing.JTextField jTextFieldSearchByName;
    // End of variables declaration//GEN-END:variables
}
