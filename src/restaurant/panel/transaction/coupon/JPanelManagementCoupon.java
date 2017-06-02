/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.panel.transaction.coupon;

import core.CDateTime;
import java.awt.Dimension;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import modal.MCoupon;
import modal.MCustomer;
import restaurant.MainFrame;
import view.VCoupon;

public class JPanelManagementCoupon extends javax.swing.JPanel {
    protected static JPanelManagementCoupon instance;
    protected VCoupon listCoupon;
    protected HashMap<String, JPanelCouponRowItem> listJPCRI = new HashMap<>();
    protected MCoupon currentEditCoupon;
    protected MCoupon currentAddCoupon = new MCoupon();
    public JPanelManagementCoupon() {
        initComponents();
        currentAddCoupon.setStartDate(CDateTime.getInstance().getDate().toString());
        currentAddCoupon.setEndDate(CDateTime.getInstance().getDate().toString());
        jDialogEditCoupon.setLocationRelativeTo(this);
        jDialogAddCoupon.setLocationRelativeTo(this);
        filter();
    }
    public final void filter(){
        try {
            if (jCheckBoxOnlyAvailable.isSelected()) {
                listCoupon = VCoupon.getAvailableCoupon();
            } else {
                listCoupon = VCoupon.getAllCoupon();
            }
            
//            System.out.println(listBill.getData());
            int height = listCoupon.getData().size() * 58;
            jPanelTableContent.setPreferredSize(new Dimension(780, height));
            jPanelTableContent.removeAll();
            listCoupon.getData().forEach((t) -> {
                MCoupon _coupon = new MCoupon();
                _coupon.setCouponId(((String) t.get("MaPGG")));
                _coupon.setOldId(_coupon.getCouponId());
                _coupon.setStartDate(CDateTime.dateToString((java.util.Date) t.get("NgayBatDau")));
                _coupon.setEndDate(CDateTime.dateToString((java.util.Date) t.get("NgayKetThuc")));
                _coupon.setCouponDiscount((Float) t.get("PhanTramGiamGia"));
                _coupon.setNote((String) t.get("GhiChuPGG"));
                    
                if (listJPCRI.get(_coupon.getCouponId()) == null) listJPCRI.put(_coupon.getCouponId(), new JPanelCouponRowItem(_coupon, true));
                jPanelTableContent.add(listJPCRI.get(_coupon.getCouponId()));
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }
        jPanelTableContent.revalidate();
        jPanelTableContent.repaint();
       
    }

    public static JPanelManagementCoupon getInstance() {
        if (instance == null) {
            instance = new JPanelManagementCoupon();
        }
        return instance;
    }
    public JPanel getjPanelTableContent() {
        return jPanelTableContent;
    }

    public MCoupon getCurrentEditCoupon() {
        return currentEditCoupon;
    }

    public VCoupon getListCoupon() {
        return listCoupon;
    }

    public HashMap<String, JPanelCouponRowItem> getListJPCRI() {
        return listJPCRI;
    }

    public void setCurrentEditCoupon(MCoupon currentEditCoupon) {
        jTextFieldCouponId.setText(currentEditCoupon.getCouponId());
        jTextFieldPercentDiscount.setText(currentEditCoupon.getCouponDiscount()+"");
        jLabelEditStartDate.setText(currentEditCoupon.getStartDate());
        jLabelEditEndDate.setText(currentEditCoupon.getEndDate());
        jTextAreaCouponNote.setText(currentEditCoupon.getNote());
        this.currentEditCoupon = currentEditCoupon;
    }

    public JDialog getjDialogEditCoupon() {
        return jDialogEditCoupon;
    }
    
    public static void main(String[] args) {
        JFrame jf = new JFrame("hoho");
        jf.setSize(new Dimension(785,600));
        MCustomer c = MCustomer.getByID(1);
        JPanelManagementCoupon.getInstance().filter();
        jf.add(JPanelManagementCoupon.getInstance());
        jf.setVisible(true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialogEditCoupon = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jTextFieldCouponId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabelEditStartDate = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabelEditEndDate = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldPercentDiscount = new javax.swing.JTextField();
        jLabelDoEditCoupon = new javax.swing.JLabel();
        jLabelCloseEditCoupon = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaCouponNote = new javax.swing.JTextArea();
        dateChooserDialogEditStartDate = new datechooser.beans.DateChooserDialog();
        dateChooserDialogEditEndDate = new datechooser.beans.DateChooserDialog();
        jDialogAddCoupon = new javax.swing.JDialog();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jTextFieldAddCouponId = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabelAddStartDate = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabelAddEndDate = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextFieldAddPercentDiscount = new javax.swing.JTextField();
        jLabelDoAddCoupon = new javax.swing.JLabel();
        jLabelCloseAddCoupon = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaAddCouponNote = new javax.swing.JTextArea();
        dateChooserDialogAddStartDate = new datechooser.beans.DateChooserDialog();
        dateChooserDialogAddEndDate = new datechooser.beans.DateChooserDialog();
        jPanel1 = new javax.swing.JPanel();
        jLabelResetSearch = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jCheckBoxOnlyAvailable = new javax.swing.JCheckBox();
        jLabelShowAddCoupon = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanelTableHeader = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanelTableContent = new javax.swing.JPanel();

        jDialogEditCoupon.setMinimumSize(new java.awt.Dimension(400, 415));
        jDialogEditCoupon.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(147, 193, 120));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_loyalty_card_x32.png"))); // NOI18N
        jLabel1.setText("Sửa phiếu khuyến mãi");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(126, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
        );

        jDialogEditCoupon.getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, -1));

        jPanel4.setBackground(new java.awt.Color(70, 92, 139));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Mã phiếu:");

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Ngày bắt đầu:");

        jLabelEditStartDate.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEditStartDate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_calendar_pick_white_x24.png"))); // NOI18N
        jLabelEditStartDate.setText("1/6/2017");
        jLabelEditStartDate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelEditStartDateMouseClicked(evt);
            }
        });

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Ngày kết thúc:");

        jLabelEditEndDate.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEditEndDate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_calendar_pick_white_x24.png"))); // NOI18N
        jLabelEditEndDate.setText("1/6/2017");
        jLabelEditEndDate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelEditEndDateMouseClicked(evt);
            }
        });

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Phần trăm:");

        jLabelDoEditCoupon.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDoEditCoupon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_edit_property_x32.png"))); // NOI18N
        jLabelDoEditCoupon.setText("Sửa");
        jLabelDoEditCoupon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelDoEditCouponMouseClicked(evt);
            }
        });

        jLabelCloseEditCoupon.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCloseEditCoupon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_close_white_x24.png"))); // NOI18N
        jLabelCloseEditCoupon.setText("Hủy");
        jLabelCloseEditCoupon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCloseEditCouponMouseClicked(evt);
            }
        });

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Chú thích:");

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jTextAreaCouponNote.setColumns(20);
        jTextAreaCouponNote.setRows(5);
        jTextAreaCouponNote.setMaximumSize(new java.awt.Dimension(200, 200));
        jTextAreaCouponNote.setMinimumSize(new java.awt.Dimension(200, 200));
        jTextAreaCouponNote.setPreferredSize(new java.awt.Dimension(200, 200));
        jScrollPane2.setViewportView(jTextAreaCouponNote);
        jTextAreaCouponNote.setLineWrap(true);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel11)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextFieldCouponId)
                        .addComponent(jLabelEditStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelEditEndDate, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE))
                    .addComponent(jTextFieldPercentDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabelDoEditCoupon, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelCloseEditCoupon, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldCouponId, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelEditStartDate, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelEditEndDate, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldPercentDiscount, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelCloseEditCoupon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelDoEditCoupon, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addContainerGap())
        );

        jDialogEditCoupon.getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 47, -1, 330));

        dateChooserDialogEditStartDate.setCalendarPreferredSize(new java.awt.Dimension(450, 400));
        dateChooserDialogEditStartDate.setLocale(new java.util.Locale("vi", "", ""));
        dateChooserDialogEditStartDate.addCommitListener(new datechooser.events.CommitListener() {
            public void onCommit(datechooser.events.CommitEvent evt) {
                dateChooserDialogEditStartDateOnCommit(evt);
            }
        });

        dateChooserDialogEditEndDate.setCalendarPreferredSize(new java.awt.Dimension(450, 400));
        dateChooserDialogEditEndDate.setLocale(new java.util.Locale("vi", "", ""));
        dateChooserDialogEditEndDate.addCommitListener(new datechooser.events.CommitListener() {
            public void onCommit(datechooser.events.CommitEvent evt) {
                dateChooserDialogEditEndDateOnCommit(evt);
            }
        });

        jDialogAddCoupon.setMinimumSize(new java.awt.Dimension(400, 415));
        jDialogAddCoupon.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(147, 193, 120));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_loyalty_card_x32.png"))); // NOI18N
        jLabel10.setText("Thêm phiếu khuyến mãi");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(126, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
        );

        jDialogAddCoupon.getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, -1));

        jPanel6.setBackground(new java.awt.Color(70, 92, 139));

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Mã phiếu:");

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Ngày bắt đầu:");

        jLabelAddStartDate.setForeground(new java.awt.Color(255, 255, 255));
        jLabelAddStartDate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_calendar_pick_white_x24.png"))); // NOI18N
        jLabelAddStartDate.setText("1/6/2017");
        jLabelAddStartDate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAddStartDateMouseClicked(evt);
            }
        });
        jLabelAddStartDate.setText(CDateTime.getInstance().getDate().toDMY());

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Ngày kết thúc:");

        jLabelAddEndDate.setForeground(new java.awt.Color(255, 255, 255));
        jLabelAddEndDate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_calendar_pick_white_x24.png"))); // NOI18N
        jLabelAddEndDate.setText("1/6/2017");
        jLabelAddEndDate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAddEndDateMouseClicked(evt);
            }
        });
        jLabelAddEndDate.setText(CDateTime.getInstance().getDate().toDMY());

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Phần trăm:");

        jLabelDoAddCoupon.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDoAddCoupon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_add_row_x24.png"))); // NOI18N
        jLabelDoAddCoupon.setText("Thêm");
        jLabelDoAddCoupon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelDoAddCouponMouseClicked(evt);
            }
        });

        jLabelCloseAddCoupon.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCloseAddCoupon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_close_white_x24.png"))); // NOI18N
        jLabelCloseAddCoupon.setText("Hủy");
        jLabelCloseAddCoupon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCloseAddCouponMouseClicked(evt);
            }
        });

        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Chú thích:");

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jTextAreaAddCouponNote.setColumns(20);
        jTextAreaAddCouponNote.setRows(5);
        jTextAreaAddCouponNote.setMaximumSize(new java.awt.Dimension(200, 200));
        jTextAreaAddCouponNote.setMinimumSize(new java.awt.Dimension(200, 200));
        jTextAreaAddCouponNote.setPreferredSize(new java.awt.Dimension(200, 200));
        jScrollPane3.setViewportView(jTextAreaAddCouponNote);
        jTextAreaCouponNote.setLineWrap(true);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextFieldAddCouponId)
                        .addComponent(jLabelAddStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelAddEndDate, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE))
                    .addComponent(jTextFieldAddPercentDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabelDoAddCoupon, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelCloseAddCoupon, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldAddCouponId, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelAddStartDate, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelAddEndDate, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldAddPercentDiscount, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelCloseAddCoupon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelDoAddCoupon, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addContainerGap())
        );

        jDialogAddCoupon.getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 47, -1, 330));

        dateChooserDialogAddStartDate.setCalendarPreferredSize(new java.awt.Dimension(450, 400));
        dateChooserDialogAddStartDate.setLocale(new java.util.Locale("vi", "", ""));
        dateChooserDialogAddStartDate.addCommitListener(new datechooser.events.CommitListener() {
            public void onCommit(datechooser.events.CommitEvent evt) {
                dateChooserDialogAddStartDateOnCommit(evt);
            }
        });

        dateChooserDialogAddEndDate.setCalendarPreferredSize(new java.awt.Dimension(450, 400));
        dateChooserDialogAddEndDate.setLocale(new java.util.Locale("vi", "", ""));
        dateChooserDialogAddEndDate.addCommitListener(new datechooser.events.CommitListener() {
            public void onCommit(datechooser.events.CommitEvent evt) {
                dateChooserDialogAddEndDateOnCommit(evt);
            }
        });

        setMaximumSize(new java.awt.Dimension(780, 531));
        setMinimumSize(new java.awt.Dimension(780, 531));

        jPanel1.setMaximumSize(new java.awt.Dimension(451, 42));
        jPanel1.setMinimumSize(new java.awt.Dimension(451, 42));

        jLabelResetSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_management_search_darkgreen_x32.png"))); // NOI18N
        jLabelResetSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelResetSearchMouseClicked(evt);
            }
        });

        jCheckBoxOnlyAvailable.setText("Chỉ hiển thị phiếu còn hiệu lực");
        jCheckBoxOnlyAvailable.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBoxOnlyAvailableItemStateChanged(evt);
            }
        });

        jLabelShowAddCoupon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_management_add_x32.png"))); // NOI18N
        jLabelShowAddCoupon.setText("Thêm phiếu khuyến mãi");
        jLabelShowAddCoupon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelShowAddCouponMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabelResetSearch)
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBoxOnlyAvailable)
                .addGap(37, 37, 37)
                .addComponent(jLabelShowAddCoupon, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelResetSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField1))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelShowAddCoupon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCheckBoxOnlyAvailable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2.setMaximumSize(new java.awt.Dimension(780, 455));
        jPanel2.setMinimumSize(new java.awt.Dimension(780, 455));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Mã phiếu");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Ngày kết thúc");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Phần trăm");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Ngày bắt đầu");

        javax.swing.GroupLayout jPanelTableHeaderLayout = new javax.swing.GroupLayout(jPanelTableHeader);
        jPanelTableHeader.setLayout(jPanelTableHeaderLayout);
        jPanelTableHeaderLayout.setHorizontalGroup(
            jPanelTableHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTableHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelTableHeaderLayout.setVerticalGroup(
            jPanelTableHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTableHeaderLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanelTableHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(0, 10, Short.MAX_VALUE))
        );

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setMaximumSize(new java.awt.Dimension(770, 455));
        jScrollPane1.setMinimumSize(new java.awt.Dimension(770, 455));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(770, 455));

        jPanelTableContent.setMaximumSize(new java.awt.Dimension(770, 455));
        jPanelTableContent.setMinimumSize(new java.awt.Dimension(770, 385));
        jPanelTableContent.setPreferredSize(new java.awt.Dimension(780, 385));
        jPanelTableContent.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));
        jScrollPane1.setViewportView(jPanelTableContent);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelTableHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jPanelTableHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelResetSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelResetSearchMouseClicked
       
    }//GEN-LAST:event_jLabelResetSearchMouseClicked

    private void dateChooserDialogEditStartDateOnCommit(datechooser.events.CommitEvent evt) {//GEN-FIRST:event_dateChooserDialogEditStartDateOnCommit
        this.currentEditCoupon.setStartDate(CDateTime.dateToString(dateChooserDialogEditStartDate.getSelectedDate().getTime()));
        jLabelEditStartDate.setText(CDateTime.dateToDMY(dateChooserDialogEditStartDate.getSelectedDate().getTime()));
    }//GEN-LAST:event_dateChooserDialogEditStartDateOnCommit

    private void dateChooserDialogEditEndDateOnCommit(datechooser.events.CommitEvent evt) {//GEN-FIRST:event_dateChooserDialogEditEndDateOnCommit
        this.currentEditCoupon.setEndDate(CDateTime.dateToString(dateChooserDialogEditEndDate.getSelectedDate().getTime()));
        jLabelEditEndDate.setText(CDateTime.dateToDMY(dateChooserDialogEditEndDate.getSelectedDate().getTime()));
    }//GEN-LAST:event_dateChooserDialogEditEndDateOnCommit

    private void jLabelEditStartDateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditStartDateMouseClicked
        dateChooserDialogEditStartDate.showDialog(MainFrame.getInstance());
    }//GEN-LAST:event_jLabelEditStartDateMouseClicked

    private void jLabelEditEndDateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditEndDateMouseClicked
        dateChooserDialogEditEndDate.showDialog(MainFrame.getInstance());
    }//GEN-LAST:event_jLabelEditEndDateMouseClicked

    private void jLabelDoEditCouponMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDoEditCouponMouseClicked
        int check = JOptionPane.showConfirmDialog(this, "Xác nhận sửa!");
        if (check == JOptionPane.YES_OPTION) {
            currentEditCoupon.setCouponId(jTextFieldCouponId.getText());
            try {
                float percent = Float.valueOf(jTextFieldPercentDiscount.getText());
                currentEditCoupon.setCouponDiscount(percent);
                currentEditCoupon.setNote(jTextAreaCouponNote.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Phần trăm chỉ được nhập số!");
            }
            try {
                currentEditCoupon.update();
                listJPCRI.get(currentEditCoupon.getOldId()).update(currentEditCoupon);
                jDialogEditCoupon.setVisible(false);
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Có lỗi xảy ra, không thể sửa!");
            }
        }
    }//GEN-LAST:event_jLabelDoEditCouponMouseClicked

    private void jLabelCloseEditCouponMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCloseEditCouponMouseClicked
        jDialogEditCoupon.setVisible(false);
    }//GEN-LAST:event_jLabelCloseEditCouponMouseClicked

    private void jLabelAddStartDateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAddStartDateMouseClicked
        dateChooserDialogAddStartDate.showDialog(MainFrame.getInstance());
    }//GEN-LAST:event_jLabelAddStartDateMouseClicked

    private void jLabelAddEndDateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAddEndDateMouseClicked
        dateChooserDialogAddEndDate.showDialog(MainFrame.getInstance());
    }//GEN-LAST:event_jLabelAddEndDateMouseClicked

    private void jLabelDoAddCouponMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDoAddCouponMouseClicked
        try {
            float percent = 0;
            try {
                percent = Float.valueOf(jTextFieldAddPercentDiscount.getText());
                currentAddCoupon.setCouponDiscount(percent);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Phần trăm giảm giá chỉ được nhập số!");
                return;
            }
            currentAddCoupon.setNote(jTextAreaAddCouponNote.getText());
            currentAddCoupon.setCouponId(jTextFieldAddCouponId.getText());
            currentAddCoupon.insert();
            listJPCRI.put(currentAddCoupon.getCouponId(), new JPanelCouponRowItem(currentAddCoupon, true));
            filter();
            jDialogAddCoupon.setVisible(false);
            //reset dialog ve rong
            jTextAreaAddCouponNote.setText("");
            jTextFieldAddPercentDiscount.setText("0");
            jTextFieldAddCouponId.setText("");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Có lỗi xảy ra. Không thể thêm phiếu!");
        }
    }//GEN-LAST:event_jLabelDoAddCouponMouseClicked

    private void jLabelCloseAddCouponMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCloseAddCouponMouseClicked
        jDialogAddCoupon.setVisible(false);
    }//GEN-LAST:event_jLabelCloseAddCouponMouseClicked

    private void dateChooserDialogAddStartDateOnCommit(datechooser.events.CommitEvent evt) {//GEN-FIRST:event_dateChooserDialogAddStartDateOnCommit
        currentAddCoupon.setStartDate(CDateTime.dateToString(dateChooserDialogAddStartDate.getSelectedDate().getTime()));
        jLabelAddStartDate.setText(CDateTime.dateToDMY(dateChooserDialogAddStartDate.getSelectedDate().getTime()));
    }//GEN-LAST:event_dateChooserDialogAddStartDateOnCommit

    private void dateChooserDialogAddEndDateOnCommit(datechooser.events.CommitEvent evt) {//GEN-FIRST:event_dateChooserDialogAddEndDateOnCommit
        currentAddCoupon.setEndDate(CDateTime.dateToString(dateChooserDialogAddEndDate.getSelectedDate().getTime()));
        jLabelAddEndDate.setText(CDateTime.dateToDMY(dateChooserDialogAddEndDate.getSelectedDate().getTime()));
    }//GEN-LAST:event_dateChooserDialogAddEndDateOnCommit

    private void jLabelShowAddCouponMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelShowAddCouponMouseClicked
        jDialogAddCoupon.setVisible(true);
    }//GEN-LAST:event_jLabelShowAddCouponMouseClicked

    private void jCheckBoxOnlyAvailableItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBoxOnlyAvailableItemStateChanged
       filter();
    }//GEN-LAST:event_jCheckBoxOnlyAvailableItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private datechooser.beans.DateChooserDialog dateChooserDialogAddEndDate;
    private datechooser.beans.DateChooserDialog dateChooserDialogAddStartDate;
    private datechooser.beans.DateChooserDialog dateChooserDialogEditEndDate;
    private datechooser.beans.DateChooserDialog dateChooserDialogEditStartDate;
    private javax.swing.JCheckBox jCheckBoxOnlyAvailable;
    private javax.swing.JDialog jDialogAddCoupon;
    private javax.swing.JDialog jDialogEditCoupon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelAddEndDate;
    private javax.swing.JLabel jLabelAddStartDate;
    private javax.swing.JLabel jLabelCloseAddCoupon;
    private javax.swing.JLabel jLabelCloseEditCoupon;
    private javax.swing.JLabel jLabelDoAddCoupon;
    private javax.swing.JLabel jLabelDoEditCoupon;
    private javax.swing.JLabel jLabelEditEndDate;
    private javax.swing.JLabel jLabelEditStartDate;
    private javax.swing.JLabel jLabelResetSearch;
    private javax.swing.JLabel jLabelShowAddCoupon;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanelTableContent;
    private javax.swing.JPanel jPanelTableHeader;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextAreaAddCouponNote;
    private javax.swing.JTextArea jTextAreaCouponNote;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextFieldAddCouponId;
    private javax.swing.JTextField jTextFieldAddPercentDiscount;
    private javax.swing.JTextField jTextFieldCouponId;
    private javax.swing.JTextField jTextFieldPercentDiscount;
    // End of variables declaration//GEN-END:variables
}
