
package restaurant.panel.booktable;

import java.awt.Color;



public class JPanelBookTableItem extends javax.swing.JPanel {
    
    protected String nameCustomer;
    protected String phoneNumber;
    protected String timeOrder;
    protected String tableBook;
    protected String statusTableBook;
    
    public JPanelBookTableItem() {
        initComponents();
    }

    public JPanelBookTableItem(String nameCustomer, String phoneNumber, String timeOrder, String tableBook, String statusTableBook, boolean odd) {
        initComponents();
        this.nameCustomer = nameCustomer;
        this.phoneNumber = phoneNumber;
        this.timeOrder = timeOrder;
        this.tableBook = tableBook;
        this.statusTableBook = statusTableBook;
        if(odd) this.setBackground(new Color(224, 224, 235));
        jPanelNameCustomer.setText(nameCustomer);
        jPanelPhoneNumber.setText(phoneNumber);
        jPanelTimeBook.setText(timeOrder);
        jPanelTableBook.setText(tableBook);
        jPanelStatusBook.setText(statusTableBook);
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
    
    
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelNameCustomer = new javax.swing.JLabel();
        jPanelPhoneNumber = new javax.swing.JLabel();
        jPanelTimeBook = new javax.swing.JLabel();
        jPanelTableBook = new javax.swing.JLabel();
        jPanelStatusBook = new javax.swing.JLabel();
        jPanelUpdate = new javax.swing.JLabel();
        jPanelDell = new javax.swing.JLabel();

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

        jPanelUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_edit_green_x24.png"))); // NOI18N
        jPanelUpdate.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanelUpdate.setPreferredSize(new java.awt.Dimension(40, 24));
        add(jPanelUpdate);

        jPanelDell.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_dell_gray_x24.png"))); // NOI18N
        add(jPanelDell);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jPanelDell;
    private javax.swing.JLabel jPanelNameCustomer;
    private javax.swing.JLabel jPanelPhoneNumber;
    private javax.swing.JLabel jPanelStatusBook;
    private javax.swing.JLabel jPanelTableBook;
    private javax.swing.JLabel jPanelTimeBook;
    private javax.swing.JLabel jPanelUpdate;
    // End of variables declaration//GEN-END:variables
}
