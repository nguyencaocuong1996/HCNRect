package restaurant.panel.main.table;

import core.ComboboxItem;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import view.VTable;

public class JPanelListTable extends javax.swing.JPanel {

    public VTable listTable;
    public FlowLayout mainLayout = new FlowLayout(FlowLayout.LEFT);
    public int numUsingTable = 0;
    public int numOrderTable = 0;
    public int numTable;
    public JPanelListTable() {
        initComponents();
        initCustomComponents();
        listTable  = VTable.getInstance();
        numTable = listTable.getData().size();
        listTable.getData().forEach((t) -> {
            switch((int)t.get("TrangThai")){
                case 1 :
                    numUsingTable++;
                    break;
                case 2:
                    numOrderTable++;
                    break;
                default:
                    break;
            }
            
        });
        jLabelNumFreeTable.setText((numTable - numUsingTable - numOrderTable)+"");
        jLabelNumUsingTable.setText((numUsingTable)+"");
        jLabelNumOrderTable.setText((numOrderTable)+"");
        int height = (numTable / 7 + 1) * 105 ;
        jTableListPanel.setPreferredSize(new Dimension(760, height));
        jTableListPanel.setLayout(mainLayout);
        jScrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    }

    @Override
    public void revalidate() {
        if(jTableListPanel != null){
            int height = (numTable / 7 + 1) * 105 ;
            jTableListPanel.setPreferredSize(new Dimension(760, height));
        }
        super.revalidate(); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setLayout(new FlowLayout());
        jf.setSize(new Dimension(500,500));
        jf.add(new JPanelListTable());
        jf.setVisible(true);
    }
    private void initCustomComponents(){
        ComboboxItem[] ci = new ComboboxItem[4];
        ci[0] = new ComboboxItem("Tất cả", 3);
        ci[1] = new ComboboxItem("Rảnh", 0);
        ci[2] = new ComboboxItem("Đang sử dụng", 1);
        ci[3] = new ComboboxItem("Đã đặt trước", 2);
        for (ComboboxItem comboboxItem : ci) {
            jComboboxFilterByStatus.addItem(comboboxItem);
        }
    }
    private void filterByStatus(int statusId){
        listTable = VTable.getInstance().filterByStatus(statusId);
        jTableListPanel.removeAll();
        listTable.getFilterData().forEach((t) -> {
            JPanelTable c = new JPanelTable((String)t.get("TenBan"), (Integer)t.get("TrangThai"));
            jTableListPanel.add(c);
        });
        this.revalidate();
        this.repaint();
    }
    private void filterByName(String name){
        listTable = VTable.getInstance().filterByName(name);
        jTableListPanel.removeAll();
        listTable.getFilterData().forEach((t) -> {
            JPanelTable c = new JPanelTable((String)t.get("TenBan"), (Integer)t.get("TrangThai"));
            jTableListPanel.add(c);
        });
        this.revalidate();
        this.repaint();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableListPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jComboboxFilterByStatus = new javax.swing.JComboBox<ComboboxItem>();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldFilterByName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabelNumFreeTable = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel233 = new javax.swing.JLabel();
        jLabelNumUsingTable = new javax.swing.JLabel();
        jLabelNumOrderTable = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(800, 500));

        jTableListPanel.setLayout(new java.awt.GridLayout(5, 7, 15, 0));
        jScrollPane1.setViewportView(jTableListPanel);

        jComboboxFilterByStatus.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jComboboxFilterByStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboboxFilterByStatusActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Trạng thái");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Tìm theo tên");

        jTextFieldFilterByName.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTextFieldFilterByName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldFilterByNameActionPerformed(evt);
            }
        });
        jTextFieldFilterByName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldFilterByNameKeyReleased(evt);
            }
        });

        jLabel3.setText("Rảnh: ");

        jLabelNumFreeTable.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabelNumFreeTable.setText("0");

        jLabel23.setText("Đang sử dụng: ");

        jLabel233.setText("Đã đặt trước: ");

        jLabelNumUsingTable.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabelNumUsingTable.setText("0");

        jLabelNumOrderTable.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabelNumOrderTable.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboboxFilterByStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldFilterByName, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelNumFreeTable)
                        .addGap(58, 58, 58)
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelNumUsingTable)
                        .addGap(76, 76, 76)
                        .addComponent(jLabel233)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelNumOrderTable)))
                .addContainerGap(229, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboboxFilterByStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldFilterByName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelNumFreeTable)
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelNumUsingTable)
                    .addComponent(jLabel233, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelNumOrderTable)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldFilterByNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldFilterByNameKeyReleased
        ComboboxItem ci = (ComboboxItem) jComboboxFilterByStatus.getSelectedItem();
        int val = (Integer) ci.getValue();
        filterByStatus(val);
        String filterName = jTextFieldFilterByName.getText();
        System.out.println(filterName);
        filterByName(filterName);
    }//GEN-LAST:event_jTextFieldFilterByNameKeyReleased

    private void jTextFieldFilterByNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldFilterByNameActionPerformed

    }//GEN-LAST:event_jTextFieldFilterByNameActionPerformed

    private void jComboboxFilterByStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboboxFilterByStatusActionPerformed
        // TODO add your handling code here:
        ComboboxItem ci = (ComboboxItem) jComboboxFilterByStatus.getSelectedItem();
        int val = (Integer) ci.getValue();
        filterByStatus(val);
        String filterName = jTextFieldFilterByName.getText();
        System.out.println(filterName);
        filterByName(filterName);
    }//GEN-LAST:event_jComboboxFilterByStatusActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<ComboboxItem> jComboboxFilterByStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel233;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelNumFreeTable;
    private javax.swing.JLabel jLabelNumOrderTable;
    private javax.swing.JLabel jLabelNumUsingTable;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jTableListPanel;
    private javax.swing.JTextField jTextFieldFilterByName;
    // End of variables declaration//GEN-END:variables
}
