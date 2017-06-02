/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.panel.transaction.receipt;

import core.CDateTime;
import java.awt.Dimension;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.ButtonGroup;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import modal.MProvider;
import modal.MReceiptNote;
import modal.MStaff;
import restaurant.MainFrame;
import view.VReceiptNote;

public class JPanelListReceipt extends javax.swing.JPanel {
    protected static JPanelListReceipt instance;
    protected VReceiptNote listReceipt;
    protected HashMap<Integer, JPanelReceiptRowItem> listJPRRI = new HashMap<>();
    protected String date;
    protected int month;
    protected int year;
    protected MProvider provider = new MProvider();
    protected MStaff staff;
    
    public JPanelListReceipt() {
        initComponents();
        provider.setId(0);
        date = "";
    }
    private void filter(){
        try {
            listReceipt = VReceiptNote.get(date, provider.getId());
            System.out.println(listReceipt.getData());
//            System.out.println(listBill.getData());
            int height = listReceipt.getData().size() * 58;
            jPanelTableContent.setPreferredSize(new Dimension(780, height));
            jPanelTableContent.removeAll();
            listReceipt.getData().forEach((t) -> {
                MReceiptNote receipt = new MReceiptNote();
                receipt.setId(((Long) t.get("MaPNH")).intValue());
                receipt.setTotalReceipt((Float) t.get("TriGiaPNH"));
                if (listJPRRI.get(receipt.getId()) == null){
                receipt.setDate(date);
                MProvider p;
                MStaff s;
                try {
                    p = MProvider.get(((Integer) t.get("MaNCC")));
                    s = MStaff.get(((Integer) t.get("MaNV")));
                } catch (SQLException e) {
                    e.printStackTrace();
                    return;
                }
                    listJPRRI.put(receipt.getId(), new JPanelReceiptRowItem(receipt, p, s, (receipt.getId() % 2 != 0)));
                }
                jPanelTableContent.add(listJPRRI.get(receipt.getId()));
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }
        jPanelTableContent.revalidate();
        jPanelTableContent.repaint();
       
    }

    public static JPanelListReceipt getInstance() {
        if (instance == null) {
            instance = new JPanelListReceipt();
        }
        return instance;
    }
    public JPanel getjPanelTableContent() {
        return jPanelTableContent;
    }
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        if (date != null) {
            this.jLabelChooseDate.setText(CDateTime.dateToDMY(dateChooserDialoListReceipt.getSelectedDate().getTime()));
        } else {
            this.jLabelChooseDate.setText("Click chọn ngày.");
        }
        this.date = date;
        filter();
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public MProvider getProvider() {
        return provider;
    }

    public void setProvider(MProvider provider) {
        this.provider = provider;
        jLabelChooseProvider.setText(provider.getName());
        jDialogChooseProvider.setVisible(false);
        filter();
    }

    public JDialog getjDialogChooseCustomer() {
        return jDialogChooseProvider;
    }

    public JLabel getjLabelChooseProvider() {
        return jLabelChooseProvider;
    }
    
    
    public static void main(String[] args) {
        JFrame jf = new JFrame("hoho");
        jf.setSize(new Dimension(785,600));
        JPanelListReceipt.getInstance().filter();
        jf.add(JPanelListReceipt.getInstance());
        jf.setVisible(true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialogChooseProvider = new javax.swing.JDialog();
        dateChooserDialoListReceipt = new datechooser.beans.DateChooserDialog();
        jPanel1 = new javax.swing.JPanel();
        jLabelResetSearch = new javax.swing.JLabel();
        jLabelChooseDate = new javax.swing.JLabel();
        jLabelChooseProvider = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanelTableHeader = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanelTableContent = new javax.swing.JPanel();

        jDialogChooseProvider.setMinimumSize(new java.awt.Dimension(410, 340));
        jDialogChooseProvider.getContentPane().setLayout(new java.awt.FlowLayout());

        dateChooserDialoListReceipt.setCalendarPreferredSize(new java.awt.Dimension(450, 400));
        dateChooserDialoListReceipt.addCommitListener(new datechooser.events.CommitListener() {
            public void onCommit(datechooser.events.CommitEvent evt) {
                dateChooserDialoListReceiptOnCommit(evt);
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

        jLabelChooseDate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_crossed_out_date_darkgreen_x32.png"))); // NOI18N
        jLabelChooseDate.setText("Click chọn ngày");
        jLabelChooseDate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelChooseDateMouseClicked(evt);
            }
        });

        jLabelChooseProvider.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_customer_support_darkgreen_x32.png"))); // NOI18N
        jLabelChooseProvider.setText("Click chọn NCC");
        jLabelChooseProvider.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelChooseProviderMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabelResetSearch)
                .addGap(28, 28, 28)
                .addComponent(jLabelChooseProvider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabelChooseDate, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(336, 336, 336))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelResetSearch)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelChooseDate)
                        .addComponent(jLabelChooseProvider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 14, Short.MAX_VALUE))
        );

        jPanel2.setMaximumSize(new java.awt.Dimension(780, 455));
        jPanel2.setMinimumSize(new java.awt.Dimension(780, 455));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Mã PNH");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Ngày lập");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Trị giá");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Nhà cung cấp");

        javax.swing.GroupLayout jPanelTableHeaderLayout = new javax.swing.GroupLayout(jPanelTableHeader);
        jPanelTableHeader.setLayout(jPanelTableHeaderLayout);
        jPanelTableHeaderLayout.setHorizontalGroup(
            jPanelTableHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTableHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86)
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

    private void jLabelChooseDateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelChooseDateMouseClicked
        dateChooserDialoListReceipt.showDialog(MainFrame.getInstance());
    }//GEN-LAST:event_jLabelChooseDateMouseClicked

    private void dateChooserDialoListReceiptOnCommit(datechooser.events.CommitEvent evt) {//GEN-FIRST:event_dateChooserDialoListReceiptOnCommit
        setDate(CDateTime.dateToString(dateChooserDialoListReceipt.getSelectedDate().getTime()));
    }//GEN-LAST:event_dateChooserDialoListReceiptOnCommit

    private void jLabelResetSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelResetSearchMouseClicked
        setDate(null);
    }//GEN-LAST:event_jLabelResetSearchMouseClicked

    private void jLabelChooseProviderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelChooseProviderMouseClicked
        if (!jDialogChooseProvider.isAncestorOf(JPanelChooseProviderForReviewReceipt.getInstance())) {
            jDialogChooseProvider.add(JPanelChooseProviderForReviewReceipt.getInstance());
        }
        jDialogChooseProvider.setVisible(true);
    }//GEN-LAST:event_jLabelChooseProviderMouseClicked

    public JDialog getjDialogChooseProvider() {
        return jDialogChooseProvider;
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private datechooser.beans.DateChooserDialog dateChooserDialoListReceipt;
    private javax.swing.JDialog jDialogChooseProvider;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelChooseDate;
    private javax.swing.JLabel jLabelChooseProvider;
    private javax.swing.JLabel jLabelResetSearch;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelTableContent;
    private javax.swing.JPanel jPanelTableHeader;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
