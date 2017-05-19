
package restaurant.panel.booktable;



public class JPanelBookTableItem extends javax.swing.JPanel {
    
    protected String nameCustomer;
    protected String phoneNumber;
    protected String timeOrder;
    protected String tableBook;
    protected String statusTableBook;
    
    public JPanelBookTableItem() {
        initComponents();
    }

    public JPanelBookTableItem(String nameCustomer, String phoneNumber, String timeOrder, String tableBook, String statusTableBook) {
        initComponents();
        this.nameCustomer = nameCustomer;
        this.phoneNumber = phoneNumber;
        this.timeOrder = timeOrder;
        this.tableBook = tableBook;
        this.statusTableBook = statusTableBook;
        
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
        jPanelDell = new javax.swing.JLabel();
        jPanelUpdate = new javax.swing.JLabel();

        setBackground(new java.awt.Color(245, 245, 245));
        setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));
        setMinimumSize(new java.awt.Dimension(755, 80));

        jPanelNameCustomer.setText("Nguyễn Cao Cường");

        jPanelPhoneNumber.setText("0122123932");

        jPanelTimeBook.setText("11:30");

        jPanelTableBook.setText("VIP 2");

        jPanelStatusBook.setText("Đã nhận");

        jPanelDell.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_dell_gray_x24.png"))); // NOI18N

        jPanelUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_edit_green_x24.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelNameCustomer)
                .addGap(32, 32, 32)
                .addComponent(jPanelPhoneNumber)
                .addGap(41, 41, 41)
                .addComponent(jPanelTimeBook)
                .addGap(48, 48, 48)
                .addComponent(jPanelTableBook)
                .addGap(57, 57, 57)
                .addComponent(jPanelStatusBook)
                .addGap(56, 56, 56)
                .addComponent(jPanelUpdate)
                .addGap(31, 31, 31)
                .addComponent(jPanelDell)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPanelNameCustomer)
                    .addComponent(jPanelPhoneNumber)
                    .addComponent(jPanelTimeBook)
                    .addComponent(jPanelTableBook)
                    .addComponent(jPanelStatusBook)
                    .addComponent(jPanelDell)
                    .addComponent(jPanelUpdate))
                .addContainerGap(22, Short.MAX_VALUE))
        );
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
