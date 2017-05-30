/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.panel.ppackkage.material;

import assets.font.CFont;
import java.awt.Color;
import java.awt.Dimension;
import java.util.HashMap;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import restaurant.panel.ppackkage.JPanelChooseProvider;
import view.VMaterial;

/**
 *
 * @author WINDNCC
 */
public class JPanelImportMaterial extends javax.swing.JPanel {

    private static JPanelImportMaterial instance;
    protected int providerId;
    protected VMaterial vMaterial;
    protected HashMap<Integer, JPanelImportMaterialItem> listMaterial = new HashMap<>();
    protected HashMap<Integer, JPanelImportDetailMaterialItem> listImportingMaterial = new HashMap<>();
    public static JPanelImportMaterial getInstance() {
        if (instance == null) {
            instance = new JPanelImportMaterial();
        }
        return instance;
    }
    
    public JPanelImportMaterial() {
        initComponents();
        jDialogChooseProvider.setLocationRelativeTo(this);
        vMaterial = VMaterial.getAllMaterial();
        vMaterial.getData().forEach((t) -> {
            int materialId = ((Long) t.get("MaNL")).intValue();
            String name = (String) t.get("TenNL");
            float inStock = (Float) t.get("SoLuongTon");
            listMaterial.put(materialId, new JPanelImportMaterialItem(materialId, name, inStock));
        });
        showData();
    }
    public void addImportingMaterialItem(JPanelImportDetailMaterialItem jpIDMI){
        int height = listImportingMaterial.size() * 37;
        jPanelListImportingMaterial.setPreferredSize(new Dimension(375, height));
        jPanelListImportingMaterial.add(jpIDMI);
        jPanelListImportingMaterial.revalidate();
        jPanelListImportingMaterial.repaint();
    }
    public final void showData(){
        jPanelListImportMaterial.removeAll();
        int height = vMaterial.getData().size() * 51;
        jPanelListImportMaterial.setPreferredSize(new Dimension(500, height));
        vMaterial.getFilterData().forEach((t) -> {
            int id = ((Long) t.get("MaNL")).intValue();
            jPanelListImportMaterial.add(listMaterial.get(id));
        });
        jPanelListImportMaterial.revalidate();
        jPanelListImportMaterial.repaint();
    }
    public void filter(String name){
        vMaterial.filter(name);
        showData();
        
    }

    public HashMap<Integer, JPanelImportDetailMaterialItem> getListImportingMaterial() {
        return listImportingMaterial;
    }
    
    public JPanel getjPanelListImportingMaterial() {
        return jPanelListImportingMaterial;
    }
    
    public JLabel getjLabelProviderName() {
        return jLabelProviderName;
    }

    public JDialog getjDialogChooseProvider() {
        return jDialogChooseProvider;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialogChooseProvider = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabelProviderName = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldFilterMaterial = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanelListImportMaterial = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanelListImportingMaterial = new javax.swing.JPanel();

        jDialogChooseProvider.setTitle("Chọn  nhà cung cấp");
        jDialogChooseProvider.setMinimumSize(new java.awt.Dimension(420, 320));
        jDialogChooseProvider.getContentPane().setLayout(new java.awt.FlowLayout());

        setMaximumSize(new java.awt.Dimension(780, 540));
        setMinimumSize(new java.awt.Dimension(780, 540));
        setPreferredSize(new java.awt.Dimension(780, 540));
        setLayout(new java.awt.GridLayout(1, 0));

        jPanel3.setBackground(new java.awt.Color(70, 92, 139));

        jLabelProviderName.setForeground(new java.awt.Color(255, 255, 255));
        jLabelProviderName.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_coins.png"))); // NOI18N
        jLabelProviderName.setText("Click để chọn nhà cung cấp");
        jLabelProviderName.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelProviderName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelProviderNameMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabelProviderName, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelProviderName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Mã NL");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Tên NL");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Số lượng còn");

        jTextFieldFilterMaterial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldFilterMaterialKeyReleased(evt);
            }
        });

        jLabel4.setText("Tìm kiếm:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldFilterMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldFilterMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanelListImportMaterial.setMaximumSize(new java.awt.Dimension(454, 445));
        jPanelListImportMaterial.setMinimumSize(new java.awt.Dimension(454, 445));
        jPanelListImportMaterial.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEADING));
        jScrollPane1.setViewportView(jPanelListImportMaterial);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel1);

        jPanel2.setMaximumSize(new java.awt.Dimension(390, 540));
        jPanel2.setMinimumSize(new java.awt.Dimension(390, 540));

        jPanel7.setBackground(new java.awt.Color(147, 193, 120));

        jLabel5.setBackground(new java.awt.Color(147, 193, 120));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_payment2_white_x32.png"))); // NOI18N
        jLabel5.setText("Lập phiếu nhập hàng");
        CFont.setStyleFont(jLabel5, 18, Color.WHITE);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 119, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jPanelListImportingMaterial.setMaximumSize(new java.awt.Dimension(375, 300));
        jPanelListImportingMaterial.setMinimumSize(new java.awt.Dimension(375, 300));
        jPanelListImportingMaterial.setPreferredSize(new java.awt.Dimension(375, 300));
        jPanelListImportingMaterial.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        jScrollPane2.setViewportView(jPanelListImportingMaterial);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(jPanel2);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelProviderNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelProviderNameMouseClicked
        if (!jDialogChooseProvider.isAncestorOf(JPanelChooseProvider.getInstance())) {
            jDialogChooseProvider.add(JPanelChooseProvider.getInstance());
        }
        
        jDialogChooseProvider.setVisible(true);
    }//GEN-LAST:event_jLabelProviderNameMouseClicked

    private void jTextFieldFilterMaterialKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldFilterMaterialKeyReleased
        String name = jTextFieldFilterMaterial.getText();
        filter(name);
    }//GEN-LAST:event_jTextFieldFilterMaterialKeyReleased
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setSize(new Dimension(1024,720));
        jf.add(JPanelImportMaterial.getInstance());
        jf.setVisible(true);
    }

    public int getProviderId() {
        return providerId;
    }

    public void setProviderId(int providerId) {
        this.providerId = providerId;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog jDialogChooseProvider;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelProviderName;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanelListImportMaterial;
    private javax.swing.JPanel jPanelListImportingMaterial;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextFieldFilterMaterial;
    // End of variables declaration//GEN-END:variables
}
