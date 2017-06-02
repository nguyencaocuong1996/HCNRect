/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.panel.transaction.receipt;
import core.CString;
import java.awt.Color;
import java.util.HashMap;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import modal.MProvider;
import modal.MReceiptNote;
import modal.MStaff;
import net.sf.jasperreports.engine.JRException;
import restaurant.report.ReportResources;

/**
 *
 * @author WINDNCC
 */
public class JPanelReceiptRowItem extends javax.swing.JPanel {
    protected MReceiptNote receipt;
    protected MProvider provider;
    protected MStaff staff;
    protected static Color oddBackground = new Color(224, 224, 235);
    public JPanelReceiptRowItem() {
        initComponents();
        customInit();
    }
    public JPanelReceiptRowItem(MReceiptNote receiptNote, MProvider provider, MStaff staff, boolean odd) {
        initComponents();
        this.receipt = receiptNote;
        this.provider = provider;
        this.staff = staff;
        if(odd){
            setBackground(oddBackground);
        }
        customInit();
    }
    public final void customInit(){
        jLabelReceiptId.setText(receipt.getId() + "");
        jLabelDate.setText(receipt.getDate());
        jLabelTotalReceipt.setText(CString.toMoney(receipt.getTotalReceipt()));
        jLabelProviderName.setText(provider.getName());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelReceiptId = new javax.swing.JLabel();
        jLabelDate = new javax.swing.JLabel();
        jLabelTotalReceipt = new javax.swing.JLabel();
        jLabelShowDetail = new javax.swing.JLabel();
        jLabelProviderName = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(760, 53));
        setMinimumSize(new java.awt.Dimension(760, 53));
        setPreferredSize(new java.awt.Dimension(760, 53));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelReceiptId.setText("001");
        add(jLabelReceiptId, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 76, 50));

        jLabelDate.setText("Ngày nhập");
        add(jLabelDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, 129, 50));

        jLabelTotalReceipt.setText("Giá trị");
        add(jLabelTotalReceipt, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 0, 140, 50));

        jLabelShowDetail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_bill_darkgreen_x32.png"))); // NOI18N
        jLabelShowDetail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelShowDetailMouseClicked(evt);
            }
        });
        add(jLabelShowDetail, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 10, -1, -1));

        jLabelProviderName.setText("Tên NCC");
        add(jLabelProviderName, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 0, 220, 50));
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelShowDetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelShowDetailMouseClicked
        HashMap<String, Object> params = new HashMap<>();
        params.put("receiptNoteId", receipt.getId());
        params.put("providerName", provider.getName());
        params.put("staffName", staff.getName());
        params.put("dateImport", receipt.getDate());
        params.put("totalMoney", receipt.getTotalReceipt());
        try {
            ReportResources.showReport(ReportResources.RECEIPT_NOTE, params);
        } catch (JRException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Có lỗi xảy ra không thể mở hóa đơn!", "Lỗi!", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_jLabelShowDetailMouseClicked

    public JLabel getjLabelShowDetail() {
        return jLabelShowDetail;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelDate;
    private javax.swing.JLabel jLabelProviderName;
    private javax.swing.JLabel jLabelReceiptId;
    private javax.swing.JLabel jLabelShowDetail;
    private javax.swing.JLabel jLabelTotalReceipt;
    // End of variables declaration//GEN-END:variables
}
