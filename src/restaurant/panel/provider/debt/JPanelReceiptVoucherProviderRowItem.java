/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.panel.provider.debt;
import restaurant.panel.ppackkage.*;
import assets.images.ImageResources;
import core.CString;
import java.awt.Color;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import modal.MMaterial;
import modal.MProvider;
import net.sf.jasperreports.engine.JRException;
import restaurant.MainFrame;
import restaurant.report.ReportResources;

/**
 *
 * @author WINDNCC
 */
public class JPanelReceiptVoucherProviderRowItem extends javax.swing.JPanel {
    protected int RVPId;
    protected int providerId;
    protected String date;
    protected float money;
    protected String note;
    protected static Color oddBackground = new Color(224, 224, 235);
    protected MProvider provider;
    public JPanelReceiptVoucherProviderRowItem() {
        initComponents();
    }
    public JPanelReceiptVoucherProviderRowItem(int RVPId, int providerId, String date, float money, String note, boolean odd) {
        initComponents();
        this.RVPId = RVPId;
        this.providerId = providerId;
        this.date = date;
        this.money = money;
        this.note = note;
        if(odd){
            setBackground(oddBackground);
        }
        customInit();
    }
    public final void customInit(){
        jLabelRVPId.setText(this.RVPId + "");
        try {
            provider = MProvider.get(providerId);
        } catch (SQLException e) {
            e.printStackTrace();
            provider.setName("Không xác định!");
        }
        
        jLabelProviderName.setText("<html><p>" + provider.getName() + "</p></html>");
        jLabelDate.setText(this.date);
        jLabelAmount.setText(CString.toMoney(this.money));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelRVPId = new javax.swing.JLabel();
        jLabelProviderName = new javax.swing.JLabel();
        jLabelDate = new javax.swing.JLabel();
        jLabelShowDetail = new javax.swing.JLabel();
        jLabelAmount = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(760, 57));
        setMinimumSize(new java.awt.Dimension(760, 57));
        setPreferredSize(new java.awt.Dimension(760, 57));

        jLabelRVPId.setText("001");

        jLabelProviderName.setText("Tên NCC");

        jLabelDate.setText("Ngày chi");

        jLabelShowDetail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_bill_darkgreen_x32.png"))); // NOI18N
        jLabelShowDetail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelShowDetailMouseClicked(evt);
            }
        });

        jLabelAmount.setText("Số tiền chi");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelRVPId, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelProviderName, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                .addComponent(jLabelDate, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(jLabelAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90)
                .addComponent(jLabelShowDetail)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelShowDetail)
                .addGap(17, 17, 17))
            .addComponent(jLabelProviderName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabelRVPId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabelDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabelAmount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelShowDetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelShowDetailMouseClicked
        HashMap<String, Object> params = new HashMap<>();
        params.put("MaPCNCC", getRVPId());
        try {
            ReportResources.showReport(ReportResources.PAY_FOR_PROVIDER_NOTE, params);
        } catch (JRException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Có lỗi xảy ra không thể mở hóa đơn!", "Lỗi!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jLabelShowDetailMouseClicked

    public int getRVPId() {
        return RVPId;
    }

    public void setRVPId(int RVPId) {
        this.RVPId = RVPId;
    }

    public int getProviderId() {
        return providerId;
    }

    public void setProviderId(int providerId) {
        this.providerId = providerId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public static Color getOddBackground() {
        return oddBackground;
    }

    public static void setOddBackground(Color oddBackground) {
        JPanelReceiptVoucherProviderRowItem.oddBackground = oddBackground;
    }

    public JLabel getjLabelShowDetail() {
        return jLabelShowDetail;
    }

    public void setjLabelShowDetail(JLabel jLabelShowDetail) {
        this.jLabelShowDetail = jLabelShowDetail;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelAmount;
    private javax.swing.JLabel jLabelDate;
    private javax.swing.JLabel jLabelProviderName;
    private javax.swing.JLabel jLabelRVPId;
    private javax.swing.JLabel jLabelShowDetail;
    // End of variables declaration//GEN-END:variables
}
