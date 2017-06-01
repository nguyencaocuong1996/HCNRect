/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.panel.transaction.bill;

import core.CDateTime;
import restaurant.panel.ppackkage.*;
import java.awt.Dimension;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import modal.MCustomer;
import restaurant.MainFrame;
import view.VBill;

public class JPanelListBill extends javax.swing.JPanel {
    protected static JPanelListBill instance;
    protected VBill listBill;
    protected HashMap<Integer, JPanelBillRowItem> listJPBRI = new HashMap<>();
    protected JPanelMaterialRowItem currentJPMRI;
    protected MCustomer customer;
    protected String date;
    
    public JPanelListBill() {
        initComponents();
        filter();
    }
    private void filter(){
        try {
            if(customer != null && date != null){
                listBill = VBill.getByCustomerAndDate(customer.getId(), date);
            } else {
                if (customer != null) {
                    listBill = VBill.getByCustomer(customer.getId());
                } else {
                    if (date != null) {
                        listBill = VBill.getByDate(date);
                    } else {
                        listBill = VBill.getByDate(CDateTime.getInstance().getDate().toString());
                    }
                }
            }
//            System.out.println(listBill.getData());
            int height = listBill.getData().size() * 58;
            jPanelTableContent.setPreferredSize(new Dimension(780, height));
            jPanelTableContent.removeAll();
            listBill.getData().forEach((t) -> {
                int id = ((Long) t.get("MaHD")).intValue();
                String ldate = CDateTime.dateToDMY((java.util.Date) t.get("NgayLapHD"));
                float totalBill = (Float) t.get("TriGiaHD");
                float realBill = (Float) t.get("TriGiaThuc");
                if (listJPBRI.get(id) == null) listJPBRI.put(id, new JPanelBillRowItem(id,ldate, totalBill, realBill, (id % 2 != 0)));
                jPanelTableContent.add(listJPBRI.get(id));
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }
        jPanelTableContent.revalidate();
        jPanelTableContent.repaint();
       
    }

    public static JPanelListBill getInstance() {
        if (instance == null) {
            instance = new JPanelListBill();
        }
        return instance;
    }
    public JPanel getjPanelTableContent() {
        return jPanelTableContent;
    }

    public MCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(MCustomer customer) {
        if (customer != null) {
            jLabelChooseCustomer.setText(customer.getFullName() + " - " + customer.getPhone());
        } else {
            jLabelChooseCustomer.setText("Click để chọn khách hàng.");
        }
        this.customer = customer;
        filter();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        if (date != null) {
            this.jLabelChooseDate.setText(CDateTime.dateToDMY(dateChooserDialogListBill.getSelectedDate().getTime()));
        } else {
            this.jLabelChooseDate.setText("Click chọn ngày.");
        }
        this.date = date;
        filter();
    }

    public JDialog getjDialogChooseCustomer() {
        return jDialogChooseCustomer;
    }
    
    public static void main(String[] args) {
        JFrame jf = new JFrame("hoho");
        jf.setSize(new Dimension(785,600));
        MCustomer c = MCustomer.getByID(1);
        JPanelListBill.getInstance().setCustomer(c);
        JPanelListBill.getInstance().filter();
        jf.add(JPanelListBill.getInstance());
        jf.setVisible(true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialogChooseCustomer = new javax.swing.JDialog();
        dateChooserDialogListBill = new datechooser.beans.DateChooserDialog();
        jPanel1 = new javax.swing.JPanel();
        jLabelResetSearch = new javax.swing.JLabel();
        jLabelChooseCustomer = new javax.swing.JLabel();
        jLabelChooseDate = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanelTableHeader = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanelTableContent = new javax.swing.JPanel();

        jDialogChooseCustomer.setMinimumSize(new java.awt.Dimension(410, 340));
        jDialogChooseCustomer.getContentPane().setLayout(new java.awt.FlowLayout());

        dateChooserDialogListBill.setCalendarPreferredSize(new java.awt.Dimension(450, 400));
        dateChooserDialogListBill.addCommitListener(new datechooser.events.CommitListener() {
            public void onCommit(datechooser.events.CommitEvent evt) {
                dateChooserDialogListBillOnCommit(evt);
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

        jLabelChooseCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_user_darkgreen_x32.png"))); // NOI18N
        jLabelChooseCustomer.setText("Click chọn khách hàng");
        jLabelChooseCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelChooseCustomerMouseClicked(evt);
            }
        });

        jLabelChooseDate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_crossed_out_date_darkgreen_x32.png"))); // NOI18N
        jLabelChooseDate.setText("Click chọn ngày");
        jLabelChooseDate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelChooseDateMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabelResetSearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelChooseCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelChooseDate, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelResetSearch)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelChooseCustomer)
                        .addComponent(jLabelChooseDate)))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        jPanel2.setMaximumSize(new java.awt.Dimension(780, 455));
        jPanel2.setMinimumSize(new java.awt.Dimension(780, 455));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Mã HD");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Ngày lập");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Trị giá");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Thu về");

        javax.swing.GroupLayout jPanelTableHeaderLayout = new javax.swing.GroupLayout(jPanelTableHeader);
        jPanelTableHeader.setLayout(jPanelTableHeaderLayout);
        jPanelTableHeaderLayout.setHorizontalGroup(
            jPanelTableHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTableHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel5)
                .addGap(94, 94, 94)
                .addComponent(jLabel7)
                .addContainerGap(319, Short.MAX_VALUE))
        );
        jPanelTableHeaderLayout.setVerticalGroup(
            jPanelTableHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTableHeaderLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanelTableHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addGap(0, 0, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void jLabelChooseCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelChooseCustomerMouseClicked
        jDialogChooseCustomer.add(JPanelChooseCustomerForTransaction.getInstance());
        jDialogChooseCustomer.setVisible(true);
    }//GEN-LAST:event_jLabelChooseCustomerMouseClicked

    private void jLabelChooseDateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelChooseDateMouseClicked
        dateChooserDialogListBill.showDialog(MainFrame.getInstance());
    }//GEN-LAST:event_jLabelChooseDateMouseClicked

    private void dateChooserDialogListBillOnCommit(datechooser.events.CommitEvent evt) {//GEN-FIRST:event_dateChooserDialogListBillOnCommit
        setDate(CDateTime.dateToString(dateChooserDialogListBill.getSelectedDate().getTime()));
    }//GEN-LAST:event_dateChooserDialogListBillOnCommit

    private void jLabelResetSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelResetSearchMouseClicked
        setCustomer(null);
        setDate(null);
    }//GEN-LAST:event_jLabelResetSearchMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private datechooser.beans.DateChooserDialog dateChooserDialogListBill;
    private javax.swing.JDialog jDialogChooseCustomer;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelChooseCustomer;
    private javax.swing.JLabel jLabelChooseDate;
    private javax.swing.JLabel jLabelResetSearch;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelTableContent;
    private javax.swing.JPanel jPanelTableHeader;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
