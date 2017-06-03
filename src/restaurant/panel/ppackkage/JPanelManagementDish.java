/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.panel.ppackkage;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import modal.MDish;
import view.VDish;
import view.ViewItem;

public class JPanelManagementDish extends javax.swing.JPanel {
    protected static JPanelManagementDish instance;
    protected VDish listDish;
    protected HashMap<Integer, JPanelDishRowItem> listJPDRI = new HashMap<>();
    public JPanelDishRowItem currentJPDRI;
    public JPanelManagementDish() {
        initComponents();
        jDialogEditDish.setLocationRelativeTo(this);
        listDish = VDish.getAllDish();
        Iterator i = listDish.getData().iterator();
        int count = 0;
        while(i.hasNext()){
            ViewItem t = (ViewItem) i.next();
            Long id = (Long) t.get("MaMA");
            String name = (String) t.get("TenMA");
            Float price = (Float) t.get("GiaMA");
            String image = (String) t.get("DiaChiAnhMA");
            Long menuId = (Long) t.get("MaTD");
            JPanelDishRowItem jpDRI = new JPanelDishRowItem(id.intValue(), name, price, image, menuId.intValue(), (count % 2 != 0));
            jpDRI.getjLabelEdit().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    Component jl = (Component) e.getSource();
                    currentJPDRI = (JPanelDishRowItem) jl.getParent();
                    jTextFieldDishNameEdit.setText(""+name);
                    jTextFieldDishPriceEdit.setText(""+price);
                    jDialogEditDish.setVisible(true);
                    
                }
                
            });
            listJPDRI.put(id.intValue(), jpDRI);
            jPanelTableContent.add(jpDRI);
            count++;
        };
        int height = listDish.getData().size() * 58;
        jPanelTableContent.setPreferredSize(new Dimension(780, height));
        
    }
    private void filter(){
        jPanelTableContent.removeAll();
        listDish.filter(0, jTextFieldFilterName.getText());
        Iterator i = listDish.getFilterData().iterator();
        int count = 0;
        while(i.hasNext()){
            ViewItem t = (ViewItem) i.next();
            Long id = (Long) t.get("MaMA");
            jPanelTableContent.add(listJPDRI.get(id.intValue()));
        };
        int height = listDish.getFilterData().size() * 58;
        jPanelTableContent.setPreferredSize(new Dimension(780, height));
        this.revalidate();
        this.repaint();
    }

    public static JPanelManagementDish getInstance() {
        if (instance == null) {
            instance = new JPanelManagementDish();
        }
        return instance;
    }
    
    public JPanel getjPanelTableContent() {
        return jPanelTableContent;
    }

    public HashMap<Integer, JPanelDishRowItem> getListJPDRI() {
        return listJPDRI;
    }
    
    public static void main(String[] args) {
        JFrame jf = new JFrame("hoho");
        jf.setSize(new Dimension(785,600));
        jf.add(JPanelManagementDish.getInstance());
        jf.setVisible(true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialogEditDish = new javax.swing.JDialog();
        jPanel5 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabelCancel = new javax.swing.JLabel();
        jLabelEdit = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextFieldDishNameEdit = new javax.swing.JTextField();
        jTextFieldDishPriceEdit = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldFilterName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanelTableHeader = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanelTableContent = new javax.swing.JPanel();

        jDialogEditDish.setMinimumSize(new java.awt.Dimension(477, 300));

        jPanel5.setBackground(new java.awt.Color(147, 193, 120));
        jPanel5.setPreferredSize(new java.awt.Dimension(400, 60));

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_add_folder_white_32px.png"))); // NOI18N
        jLabel14.setText("Sửa món ăn");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel14)
                .addContainerGap(342, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(70, 92, 139));
        jPanel6.setMaximumSize(new java.awt.Dimension(477, 234));
        jPanel6.setMinimumSize(new java.awt.Dimension(477, 234));

        jLabelCancel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCancel.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_close_white_x24.png"))); // NOI18N
        jLabelCancel.setText("Hủy");

        jLabelEdit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelEdit.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_add_row_x24.png"))); // NOI18N
        jLabelEdit.setText("Sửa");
        jLabelEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelEditMouseClicked(evt);
            }
        });

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Tên Món Ăn: ");

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Giá: ");

        jTextFieldDishNameEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDishNameEditActionPerformed(evt);
            }
        });

        jTextFieldDishPriceEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDishPriceEditActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldDishNameEdit)
                            .addComponent(jTextFieldDishPriceEdit, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(jLabelEdit)
                        .addGap(72, 72, 72)
                        .addComponent(jLabelCancel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextFieldDishNameEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jTextFieldDishPriceEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEdit)
                    .addComponent(jLabelCancel))
                .addContainerGap(93, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jDialogEditDishLayout = new javax.swing.GroupLayout(jDialogEditDish.getContentPane());
        jDialogEditDish.getContentPane().setLayout(jDialogEditDishLayout);
        jDialogEditDishLayout.setHorizontalGroup(
            jDialogEditDishLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialogEditDishLayout.setVerticalGroup(
            jDialogEditDishLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogEditDishLayout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setMaximumSize(new java.awt.Dimension(780, 531));
        setMinimumSize(new java.awt.Dimension(780, 531));

        jPanel1.setMaximumSize(new java.awt.Dimension(451, 42));
        jPanel1.setMinimumSize(new java.awt.Dimension(451, 42));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_management_search_darkgreen_x32.png"))); // NOI18N

        jTextFieldFilterName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldFilterNameKeyReleased(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_management_add_x32.png"))); // NOI18N
        jLabel2.setText("Thêm món ăn");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jTextFieldFilterName, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldFilterName, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.setMaximumSize(new java.awt.Dimension(780, 455));
        jPanel2.setMinimumSize(new java.awt.Dimension(780, 455));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Mã");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Tên");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Giá");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Hình ảnh");

        javax.swing.GroupLayout jPanelTableHeaderLayout = new javax.swing.GroupLayout(jPanelTableHeader);
        jPanelTableHeader.setLayout(jPanelTableHeaderLayout);
        jPanelTableHeaderLayout.setHorizontalGroup(
            jPanelTableHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTableHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(83, 83, 83)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addComponent(jLabel5)
                .addGap(116, 116, 116)
                .addComponent(jLabel6)
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
                .addGap(0, 0, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldFilterNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldFilterNameKeyReleased
        filter();
    }//GEN-LAST:event_jTextFieldFilterNameKeyReleased

    private void jLabelEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditMouseClicked
        // TODO add your handling code here:
        try {
            MDish mDish= MDish.get(currentJPDRI.getId());
            mDish.setName(jTextFieldDishNameEdit.getText());
            mDish.setPrice(Float.parseFloat(jTextFieldDishPriceEdit.getText()));
            mDish.update();
            currentJPDRI.setDishName(jTextFieldDishNameEdit.getText());
            currentJPDRI.setPrice(Float.parseFloat(jTextFieldDishPriceEdit.getText()));
            currentJPDRI.customInit();
            jDialogEditDish.setVisible(false);
            JOptionPane.showMessageDialog(this, "Sửa bàn thành công!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Có lỗi xảy ra, không thể sửa!");
            ex.printStackTrace();
        }

        this.revalidate();
        this.repaint();
    }//GEN-LAST:event_jLabelEditMouseClicked

    private void jTextFieldDishNameEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDishNameEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDishNameEditActionPerformed

    private void jTextFieldDishPriceEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDishPriceEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDishPriceEditActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog jDialogEditDish;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelCancel;
    private javax.swing.JLabel jLabelEdit;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanelTableContent;
    private javax.swing.JPanel jPanelTableHeader;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldDishNameEdit;
    private javax.swing.JTextField jTextFieldDishPriceEdit;
    private javax.swing.JTextField jTextFieldFilterName;
    // End of variables declaration//GEN-END:variables
}
