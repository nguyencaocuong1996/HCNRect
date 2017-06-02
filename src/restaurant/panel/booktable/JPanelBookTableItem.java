
package restaurant.panel.booktable;

import java.awt.Color;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.JOptionPane;



public class JPanelBookTableItem extends javax.swing.JPanel {
    protected int bookTableId;
    protected int statusId;
    protected String nameCustomer;
    protected String phoneNumber;
    protected String timeOrder;
    protected String tableBook;
    protected String statusTableBook;
    protected static HashMap<Integer, String> status = new HashMap<>();
    public JPanelBookTableItem() {
        initComponents();
        customInit();
    }
    public JPanelBookTableItem(String nameCustomer, String phoneNumber, String timeOrder, String tableBook, int status, boolean odd) {
        initComponents();
        if(odd) this.setBackground(new Color(224, 224, 235));
        this.statusId = status;
        this.nameCustomer = nameCustomer;
        this.phoneNumber = phoneNumber;
        this.timeOrder = timeOrder;
        this.tableBook = tableBook;
        customInit();
    }
    public JPanelBookTableItem(int bookTableId, String nameCustomer, String phoneNumber, String timeOrder, String tableBook, int status, boolean odd) {
        initComponents();
        this.bookTableId = bookTableId;
        this.statusId = status;
        if(odd) this.setBackground(new Color(224, 224, 235));
        this.nameCustomer = nameCustomer;
        this.phoneNumber = phoneNumber;
        this.timeOrder = timeOrder;
        this.tableBook = tableBook;
        customInit();
    }
    public final void customInit(){
        if (status.isEmpty()) {
            status.put(0, "Chưa tới");
            status.put(1, "Đã nhận bàn");
            status.put(2, "Đã hủy");
        }
        jPanelNameCustomer.setText(nameCustomer);
        jPanelPhoneNumber.setText(phoneNumber);
        jPanelTimeBook.setText(timeOrder);
        jPanelTableBook.setText(tableBook);
        jPanelStatusBook.setText(status.get(this.statusId));
    }
    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getTimeOrder() {
        return timeOrder;
    }

    public void setTimeOrder(String timeOrder) {
        this.timeOrder = timeOrder;
    }

    public String getTableBook() {
        return tableBook;
    }

    public void setTableBook(String tableBook) {
        this.tableBook = tableBook;
    }

    public String getStatusTableBook() {
        return statusTableBook;
    }

    public void setStatusTableBook(String statusTableBook) {
        this.statusTableBook = statusTableBook;
    }
    public void dbDelete(){
        System.out.println("dbDelete in JPanelBookTableItem.java: Xóa phiếu đã chọn!");
        try {
            database.Database.delete("phieu_dat_ban", "MaPDB = " + this.bookTableId);
            System.out.println("----Xóa phiếu thành công!");
        } catch (SQLException e) {
            System.out.println("----Xóa phiếu thất bại!");
        }
    }
    public void dbUpdate(){
        System.out.println("dbUpdate in JPanelBookTableItem.java: Cập nhật phiếu đã chọn!");
        HashMap ud = new HashMap();
        ud.put("TrangThai", this.statusId);
        try {
            database.Database.update("phieu_dat_ban", ud, "MaPDB = " + this.bookTableId);
            System.out.println("----Cập nhật phiếu thành công!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("----Cập nhật phiếu thất bại!");
        }
    }
    public void dbAdd(){
        
    }
    
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelNameCustomer = new javax.swing.JLabel();
        jPanelPhoneNumber = new javax.swing.JLabel();
        jPanelTimeBook = new javax.swing.JLabel();
        jPanelTableBook = new javax.swing.JLabel();
        jPanelStatusBook = new javax.swing.JLabel();
        jPanelUpdate = new javax.swing.JLabel();
        jPanelDelete = new javax.swing.JLabel();

        setBackground(new java.awt.Color(245, 245, 245));
        setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));
        setMinimumSize(new java.awt.Dimension(755, 60));
        setPreferredSize(new java.awt.Dimension(775, 40));
        setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jPanelNameCustomer.setText("Nguyễn Cao Cường");
        jPanelNameCustomer.setPreferredSize(new java.awt.Dimension(170, 14));
        add(jPanelNameCustomer);

        jPanelPhoneNumber.setText("0122123932");
        jPanelPhoneNumber.setPreferredSize(new java.awt.Dimension(125, 14));
        add(jPanelPhoneNumber);

        jPanelTimeBook.setText("11:30");
        jPanelTimeBook.setPreferredSize(new java.awt.Dimension(110, 14));
        add(jPanelTimeBook);

        jPanelTableBook.setText("VIP 2");
        jPanelTableBook.setPreferredSize(new java.awt.Dimension(110, 14));
        add(jPanelTableBook);

        jPanelStatusBook.setText("Đã nhận");
        jPanelStatusBook.setPreferredSize(new java.awt.Dimension(120, 14));
        add(jPanelStatusBook);

        jPanelUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_edit_darkgreen_x24.png"))); // NOI18N
        jPanelUpdate.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanelUpdate.setPreferredSize(new java.awt.Dimension(40, 24));
        jPanelUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelUpdateMouseClicked(evt);
            }
        });
        add(jPanelUpdate);

        jPanelDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_delete_dimgray_x32.png"))); // NOI18N
        jPanelDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelDeleteMouseClicked(evt);
            }
        });
        add(jPanelDelete);
    }// </editor-fold>//GEN-END:initComponents

    private void jPanelDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelDeleteMouseClicked
        int check = JOptionPane.showConfirmDialog(this, "Xác nhận xóa phiếu đặt bàn?");
        if(check == JOptionPane.YES_OPTION){
            dbDelete();
            JPanelBookTable.getInstance().getjPanelListBookTableContent().remove(this);
            JPanelBookTable.getInstance().getjPanelListBookTableContent().revalidate();
            JPanelBookTable.getInstance().getjPanelListBookTableContent().repaint();
        }
    }//GEN-LAST:event_jPanelDeleteMouseClicked

    private void jPanelUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelUpdateMouseClicked
        int check = JOptionPane.showConfirmDialog(this, "Xác nhận khách đã tới?");
        if(check == JOptionPane.YES_OPTION){
            this.statusId = 1;
            dbUpdate();
            jPanelStatusBook.setText(status.get(1));
        }
    }//GEN-LAST:event_jPanelUpdateMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jPanelDelete;
    private javax.swing.JLabel jPanelNameCustomer;
    private javax.swing.JLabel jPanelPhoneNumber;
    private javax.swing.JLabel jPanelStatusBook;
    private javax.swing.JLabel jPanelTableBook;
    private javax.swing.JLabel jPanelTimeBook;
    private javax.swing.JLabel jPanelUpdate;
    // End of variables declaration//GEN-END:variables
}
