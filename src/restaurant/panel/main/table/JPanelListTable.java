package restaurant.panel.main.table;

import core.ComboboxItem;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import view.VTable;

public class JPanelListTable extends javax.swing.JPanel {

    public VTable listTable;
    public HashMap<Integer, JPanelTable> listJPanelTable = new HashMap<>();
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
        jPanelListTable.setPreferredSize(new Dimension(760, height));
        jPanelListTable.setLayout(mainLayout);
        jScrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    }

    @Override
    public void revalidate() {
        if(jPanelListTable != null){
            int height = (numTable / 7 + 1) * 105 ;
            jPanelListTable.setPreferredSize(new Dimension(760, height));
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

    public HashMap<Integer, JPanelTable> getListJPanelTable() {
        return listJPanelTable;
    }

    public void filter(){
        ComboboxItem ci = (ComboboxItem) jComboboxFilterByStatus.getSelectedItem();
        int statusId = (Integer) ci.getValue();
        String filterName = jTextFieldFilterByName.getText();
        listTable = VTable.getInstance().filterByStatusAndName(statusId, filterName);
        jPanelListTable.removeAll();
        listTable.getFilterData().forEach((t) -> {
            Integer id = (Integer) t.get("MaBan");
            if (listJPanelTable.size() > 0) {
                jPanelListTable.add(listJPanelTable.get(id));
            }
        });
        this.revalidate();
        this.repaint();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanelListTable = new javax.swing.JPanel();
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

        jPanelListTable.setLayout(new java.awt.GridLayout(5, 7, 15, 0));
        jScrollPane1.setViewportView(jPanelListTable);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboboxFilterByStatus.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jComboboxFilterByStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboboxFilterByStatusActionPerformed(evt);
            }
        });
        jPanel1.add(jComboboxFilterByStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 160, 29));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Trạng thái");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 94, 32));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Tìm theo tên");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 110, -1));

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
        jPanel1.add(jTextFieldFilterByName, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 160, 30));

        jLabel3.setText("Rảnh ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, -1, -1));

        jLabelNumFreeTable.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabelNumFreeTable.setText("0");
        jPanel1.add(jLabelNumFreeTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, -1, -1));

        jLabel23.setText("Đang sử dụng");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, -1, -1));

        jLabel233.setText("Đã đặt trước");
        jPanel1.add(jLabel233, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 10, -1, -1));

        jLabelNumUsingTable.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabelNumUsingTable.setText("0");
        jPanel1.add(jLabelNumUsingTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 30, -1, -1));

        jLabelNumOrderTable.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabelNumOrderTable.setText("0");
        jPanel1.add(jLabelNumOrderTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 30, -1, -1));

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldFilterByNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldFilterByNameKeyReleased
        filter();
    }//GEN-LAST:event_jTextFieldFilterByNameKeyReleased

    private void jTextFieldFilterByNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldFilterByNameActionPerformed
        filter();
    }//GEN-LAST:event_jTextFieldFilterByNameActionPerformed

    private void jComboboxFilterByStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboboxFilterByStatusActionPerformed
        filter();
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
    private javax.swing.JPanel jPanelListTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldFilterByName;
    // End of variables declaration//GEN-END:variables
}
