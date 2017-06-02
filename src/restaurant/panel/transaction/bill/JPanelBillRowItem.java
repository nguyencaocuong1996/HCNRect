/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.panel.transaction.bill;
import core.CString;
import java.awt.Color;
import java.util.HashMap;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import modal.MBill;
import modal.MCustomer;
import modal.MStaff;
import modal.MTable;
import net.sf.jasperreports.engine.JRException;
import restaurant.report.ReportResources;

/**
 *
 * @author WINDNCC
 */
public class JPanelBillRowItem extends javax.swing.JPanel {
    protected MBill bill;
    protected MCustomer customer;
    protected MStaff staff;
    protected MTable table;
    protected static Color oddBackground = new Color(224, 224, 235);
    public JPanelBillRowItem() {
        initComponents();
        customInit();
    }
    public JPanelBillRowItem(MBill bill, MCustomer customer, MStaff staff, MTable table, boolean odd) {
        initComponents();
        this.bill = bill;
        this.customer = customer;
        this.staff = staff;
        this.table = table;
        if(odd){
            setBackground(oddBackground);
        }
        customInit();
    }
    public final void customInit(){
        jLabelBillId.setText(bill.getId() + "");
        jLabelDate.setText(bill.getDateTimeBill());
        jLabelTotalBill.setText(CString.toMoney(bill.getTotalBill()));
        jLabelRealBill.setText(CString.toMoney(bill.getRealBill()));
        jLabelCustomerName.setText(customer.getFullName());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelBillId = new javax.swing.JLabel();
        jLabelDate = new javax.swing.JLabel();
        jLabelTotalBill = new javax.swing.JLabel();
        jLabelShowDetail = new javax.swing.JLabel();
        jLabelRealBill = new javax.swing.JLabel();
        jLabelCustomerName = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(760, 57));
        setMinimumSize(new java.awt.Dimension(760, 57));
        setPreferredSize(new java.awt.Dimension(760, 57));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelBillId.setText("001");
        add(jLabelBillId, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 76, 60));

        jLabelDate.setText("Ngày lập");
        add(jLabelDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(268, 0, 129, 60));

        jLabelTotalBill.setText("Giá trị");
        add(jLabelTotalBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(437, 0, 125, 60));

        jLabelShowDetail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_bill_darkgreen_x32.png"))); // NOI18N
        jLabelShowDetail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelShowDetailMouseClicked(evt);
            }
        });
        add(jLabelShowDetail, new org.netbeans.lib.awtextra.AbsoluteConstraints(702, 11, -1, -1));

        jLabelRealBill.setText("Giá trị thực");
        add(jLabelRealBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 104, 60));

        jLabelCustomerName.setText("Tên khách hàng");
        add(jLabelCustomerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 0, 166, 60));
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelShowDetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelShowDetailMouseClicked
        HashMap<String, Object> params = new HashMap<>();
        params.put("HoTenKH", customer.getFullName());
        params.put("SDTKH", customer.getPhone());
        params.put("TenBan", table.getName());
        params.put("MaHD", bill.getId());
        params.put("HoTenNV", staff.getName());
        params.put("MaNV", staff.getId());
        params.put("TongTien", CString.toMoney(bill.getTotalBill()));
        params.put("TienPhaiThanhToan",CString.toMoney(bill.getRealBill()));
        params.put("GiamGia", CString.toMoney(bill.getTotalBill() - bill.getRealBill()));
        params.put("NgayLapHD", bill.getDateTimeBill());
        try {
            ReportResources.showReport(ReportResources.RP_REVIEW_BILL, params);
        } catch (JRException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Có lỗi xảy ra không thể mở hóa đơn!", "Lỗi!", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_jLabelShowDetailMouseClicked

    public JLabel getjLabelEdit() {
        return jLabelShowDetail;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelBillId;
    private javax.swing.JLabel jLabelCustomerName;
    private javax.swing.JLabel jLabelDate;
    private javax.swing.JLabel jLabelRealBill;
    private javax.swing.JLabel jLabelShowDetail;
    private javax.swing.JLabel jLabelTotalBill;
    // End of variables declaration//GEN-END:variables
}
