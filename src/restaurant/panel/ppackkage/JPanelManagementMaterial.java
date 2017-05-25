/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.panel.ppackkage;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modal.MMaterial;
import view.VMaterial;
import view.ViewItem;

public class JPanelManagementMaterial extends javax.swing.JPanel {
    protected static JPanelManagementMaterial instance;
    protected VMaterial listMaterial;
    protected HashMap<Integer, JPanelMaterialRowItem> listJPMRI = new HashMap<>();
    public JPanelManagementMaterial() {
        initComponents();
        jDialogAddMaterial.setLocationRelativeTo(this);
        jDialogEditMaterial.setLocationRelativeTo(this);
        listMaterial = VMaterial.getAllMaterial();
        Iterator i = listMaterial.getData().iterator();
        int count = 0;
        while(i.hasNext()){
            ViewItem t = (ViewItem) i.next();
            Long id = (Long) t.get("MaNL");
            String name = (String) t.get("TenNL");
            Float qty = (Float) t.get("SoLuongTon");
            Float limit = (Float) t.get("MucToiThieu");
            String unit = (String) t.get("DonVi");
            JPanelMaterialRowItem jpMRI = new JPanelMaterialRowItem(id.intValue(), name, qty, unit, limit, (count % 2 != 0));
            jpMRI.getjLabelEdit().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    
                }
                
            });
            listJPMRI.put(id.intValue(), jpMRI);
            jPanelTableContent.add(jpMRI);
            count++;
        };
        int height = listMaterial.getData().size() * 58;
        jPanelTableContent.setPreferredSize(new Dimension(780, height));
        
    }
    private void filter(){
        jPanelTableContent.removeAll();
        listMaterial.filter(jTextFieldFilterName.getText());
        Iterator i = listMaterial.getFilterData().iterator();
        int count = 0;
        while(i.hasNext()){
            ViewItem t = (ViewItem) i.next();
            Long id = (Long) t.get("MaNL");
            jPanelTableContent.add(listJPMRI.get(id.intValue()));
        }
        int height = listMaterial.getFilterData().size() * 58;
        jPanelTableContent.setPreferredSize(new Dimension(780, height));
        this.revalidate();
        this.repaint();
    }

    public static JPanelManagementMaterial getInstance() {
        if (instance == null) {
            instance = new JPanelManagementMaterial();
        }
        return instance;
    }
    
    public static void main(String[] args) {
        JFrame jf = new JFrame("hoho");
        jf.setSize(new Dimension(785,600));
        jf.add(JPanelManagementMaterial.getInstance());
        jf.setVisible(true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialogAddMaterial = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldName = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldQty = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldUnit = new javax.swing.JTextField();
        jTextFieldLimit = new javax.swing.JTextField();
        jLabelCloseAdd = new javax.swing.JLabel();
        jLabelDoAddMaterial = new javax.swing.JLabel();
        jDialogEditMaterial = new javax.swing.JDialog();
        jPanel5 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabelIdEdit = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jTextFieldMNameEdit = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jTextFieldMQtyEdit = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jTextFieldUnitEdit = new javax.swing.JTextField();
        jTextFieldMLimitEdit = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldFilterName = new javax.swing.JTextField();
        jLabelAddMaterial = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanelTableHeader = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanelTableContent = new javax.swing.JPanel();

        jDialogAddMaterial.setMaximumSize(new java.awt.Dimension(500, 300));
        jDialogAddMaterial.setMinimumSize(new java.awt.Dimension(500, 300));
        jDialogAddMaterial.setPreferredSize(new java.awt.Dimension(500, 300));

        jPanel3.setBackground(new java.awt.Color(147, 193, 120));
        jPanel3.setPreferredSize(new java.awt.Dimension(400, 60));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_add_folder_white_32px.png"))); // NOI18N
        jLabel6.setText("Thêm nguyên liệu");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(70, 92, 139));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Tên:");

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Số lượng trong kho:");

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Mức tối thiểu trong kho:");

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Đơn vị:");

        jLabelCloseAdd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCloseAdd.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCloseAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_close_white_x24.png"))); // NOI18N
        jLabelCloseAdd.setText("Hủy");
        jLabelCloseAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCloseAddMouseClicked(evt);
            }
        });

        jLabelDoAddMaterial.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelDoAddMaterial.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDoAddMaterial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_add_row_x24.png"))); // NOI18N
        jLabelDoAddMaterial.setText("Thêm");
        jLabelDoAddMaterial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelDoAddMaterialMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldQty, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldLimit, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelDoAddMaterial)
                .addGap(18, 18, 18)
                .addComponent(jLabelCloseAdd)
                .addGap(219, 219, 219))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jTextFieldUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(jTextFieldQty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldLimit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCloseAdd)
                    .addComponent(jLabelDoAddMaterial))
                .addGap(145, 145, 145))
        );

        javax.swing.GroupLayout jDialogAddMaterialLayout = new javax.swing.GroupLayout(jDialogAddMaterial.getContentPane());
        jDialogAddMaterial.getContentPane().setLayout(jDialogAddMaterialLayout);
        jDialogAddMaterialLayout.setHorizontalGroup(
            jDialogAddMaterialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialogAddMaterialLayout.setVerticalGroup(
            jDialogAddMaterialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogAddMaterialLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jDialogEditMaterial.setMaximumSize(new java.awt.Dimension(500, 450));
        jDialogEditMaterial.setMinimumSize(new java.awt.Dimension(500, 450));
        jDialogEditMaterial.setPreferredSize(new java.awt.Dimension(500, 450));

        jPanel5.setBackground(new java.awt.Color(147, 193, 120));
        jPanel5.setPreferredSize(new java.awt.Dimension(400, 60));

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_add_folder_white_32px.png"))); // NOI18N
        jLabel14.setText("Sửa nguyên liệu");

        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Mã: ");

        jLabelIdEdit.setForeground(new java.awt.Color(255, 255, 255));
        jLabelIdEdit.setText("1");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel14)
                .addGap(51, 51, 51)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelIdEdit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(jLabelIdEdit))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(70, 92, 139));

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Tên:");

        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Số lượng trong kho:");

        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Mức tối thiểu trong kho:");

        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Đơn vị:");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_close_white_x24.png"))); // NOI18N
        jLabel19.setText("Hủy");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_add_row_x24.png"))); // NOI18N
        jLabel20.setText("Sửa");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(jTextFieldMNameEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel18))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldMQtyEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldMLimitEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addGap(24, 24, 24)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                        .addComponent(jLabel19)))
                .addGap(18, 18, 18)
                .addComponent(jTextFieldUnitEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jTextFieldMNameEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(jTextFieldUnitEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel16)
                    .addComponent(jTextFieldMQtyEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jTextFieldMLimitEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel19))
                .addContainerGap(186, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jDialogEditMaterialLayout = new javax.swing.GroupLayout(jDialogEditMaterial.getContentPane());
        jDialogEditMaterial.getContentPane().setLayout(jDialogEditMaterialLayout);
        jDialogEditMaterialLayout.setHorizontalGroup(
            jDialogEditMaterialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialogEditMaterialLayout.setVerticalGroup(
            jDialogEditMaterialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogEditMaterialLayout.createSequentialGroup()
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

        jLabelAddMaterial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_management_add_x32.png"))); // NOI18N
        jLabelAddMaterial.setText("Thêm nguyên liệu");
        jLabelAddMaterial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAddMaterialMouseClicked(evt);
            }
        });

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
                .addComponent(jLabelAddMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldFilterName, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabelAddMaterial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel2.setMaximumSize(new java.awt.Dimension(780, 455));
        jPanel2.setMinimumSize(new java.awt.Dimension(780, 455));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Mã");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Tên");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Lượng tồn");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Mức tối thiểu");

        javax.swing.GroupLayout jPanelTableHeaderLayout = new javax.swing.GroupLayout(jPanelTableHeader);
        jPanelTableHeader.setLayout(jPanelTableHeaderLayout);
        jPanelTableHeaderLayout.setHorizontalGroup(
            jPanelTableHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTableHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(83, 83, 83)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel5)
                .addGap(94, 94, 94)
                .addComponent(jLabel7)
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
                    .addComponent(jLabel7))
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

    private void jLabelAddMaterialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAddMaterialMouseClicked
        jDialogAddMaterial.setVisible(true);
    }//GEN-LAST:event_jLabelAddMaterialMouseClicked

    private void jLabelCloseAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCloseAddMouseClicked
        jDialogAddMaterial.setVisible(false);
    }//GEN-LAST:event_jLabelCloseAddMouseClicked

    private void jLabelDoAddMaterialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDoAddMaterialMouseClicked
        try {
            String name = jTextFieldName.getText();
            Float qty = new Float(jTextFieldQty.getText());
            Float limit = new Float(jTextFieldLimit.getText());
            String unit = jTextFieldUnit.getText();
            MMaterial mMaterial = new MMaterial(name, qty , unit, limit);
            mMaterial.insert();
            jDialogAddMaterial.setVisible(false);
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Có lỗi xảy ra! Vui lòng kiểm tra lại kiểu dữ liệu!");
            e.printStackTrace();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Có lỗi xảy ra! Lỗi database!");
            ex.printStackTrace();
        }
        
    }//GEN-LAST:event_jLabelDoAddMaterialMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog jDialogAddMaterial;
    private javax.swing.JDialog jDialogEditMaterial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelAddMaterial;
    private javax.swing.JLabel jLabelCloseAdd;
    private javax.swing.JLabel jLabelDoAddMaterial;
    private javax.swing.JLabel jLabelIdEdit;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanelTableContent;
    private javax.swing.JPanel jPanelTableHeader;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldFilterName;
    private javax.swing.JTextField jTextFieldLimit;
    private javax.swing.JTextField jTextFieldMLimitEdit;
    private javax.swing.JTextField jTextFieldMNameEdit;
    private javax.swing.JTextField jTextFieldMQtyEdit;
    private javax.swing.JTextField jTextFieldName;
    private javax.swing.JTextField jTextFieldQty;
    private javax.swing.JTextField jTextFieldUnit;
    private javax.swing.JTextField jTextFieldUnitEdit;
    // End of variables declaration//GEN-END:variables
}
