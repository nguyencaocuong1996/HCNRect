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
import modal.MMaterial;
import restaurant.MainFrame;
import restaurant.panel.PanelFactory;
import restaurant.panel.ppackkage.material.JPanelImportMaterial;
import restaurant.panel.staff.JPanelStaffRowItem;
import view.VMaterial;
import view.ViewItem;

public class JPanelManagementMaterial extends javax.swing.JPanel {
    protected static JPanelManagementMaterial instance;
    protected VMaterial listMaterial;
    protected HashMap<Integer, JPanelMaterialRowItem> listJPMRI = new HashMap<>();
    protected JPanelMaterialRowItem currentJPMRI;
    
    
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
                    Component jl = (Component) e.getSource();
                    currentJPMRI = (JPanelMaterialRowItem) jl.getParent();
                    jTextFieldMaterialNameEdit.setText(""+name);
                    jTextFieldMinUnitEdit.setText(""+limit);
                    jDialogEditMaterial.setVisible(true);
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
    public JPanel getjPanelTableContent() {
        return jPanelTableContent;
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
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldUnit = new javax.swing.JTextField();
        jTextFieldLimit = new javax.swing.JTextField();
        jLabelCloseAdd = new javax.swing.JLabel();
        jLabelDoAddMaterial = new javax.swing.JLabel();
        jDialogEditMaterial = new javax.swing.JDialog();
        jPanel5 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabelCancel = new javax.swing.JLabel();
        jLabelEdit = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextFieldMaterialNameEdit = new javax.swing.JTextField();
        jTextFieldMinUnitEdit = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldFilterName = new javax.swing.JTextField();
        jLabelAddMaterial = new javax.swing.JLabel();
        jLabelImportMaterial = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanelTableHeader = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanelTableContent = new javax.swing.JPanel();

        jDialogAddMaterial.setMinimumSize(new java.awt.Dimension(500, 300));

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
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                .addGap(20, 20, 20)
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

        jDialogEditMaterial.setMinimumSize(new java.awt.Dimension(500, 450));

        jPanel5.setBackground(new java.awt.Color(147, 193, 120));
        jPanel5.setPreferredSize(new java.awt.Dimension(400, 60));

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_add_folder_white_32px.png"))); // NOI18N
        jLabel14.setText("Sửa nguyên liệu");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel14)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(70, 92, 139));

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

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Tên Nguyên Liệu: ");

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Mức tối thiểu: ");

        jTextFieldMaterialNameEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMaterialNameEditActionPerformed(evt);
            }
        });

        jTextFieldMinUnitEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMinUnitEditActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(jLabelEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                        .addComponent(jLabelCancel))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldMaterialNameEdit)
                            .addComponent(jTextFieldMinUnitEdit, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(151, 151, 151))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldMaterialNameEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jTextFieldMinUnitEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(106, 106, 106)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEdit)
                    .addComponent(jLabelCancel))
                .addContainerGap(183, Short.MAX_VALUE))
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

        jLabelImportMaterial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_import_darkgreen_x32.png"))); // NOI18N
        jLabelImportMaterial.setText("Nhập nguyên liệu");
        jLabelImportMaterial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelImportMaterialMouseClicked(evt);
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelImportMaterial)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldFilterName, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelAddMaterial)
                        .addComponent(jLabelImportMaterial)))
                .addGap(0, 9, Short.MAX_VALUE))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGap(0, 0, 0)
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
            Float qty = 0f;
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

    private void jLabelImportMaterialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelImportMaterialMouseClicked
        MainFrame.getInstance().changeHeaderPanel(PanelFactory.get(PanelFactory.ID.HEADER_PACKAGE_IMPORT_MATERIAL));
        MainFrame.getInstance().changeContentPanel(JPanelImportMaterial.getInstance());
    }//GEN-LAST:event_jLabelImportMaterialMouseClicked

    private void jTextFieldMaterialNameEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMaterialNameEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMaterialNameEditActionPerformed

    private void jTextFieldMinUnitEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMinUnitEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMinUnitEditActionPerformed

    private void jLabelEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditMouseClicked
        // TODO add your handling code here:
        try {
           MMaterial mMaterial= MMaterial.get(currentJPMRI.getId()); 
           mMaterial.setName(jTextFieldMaterialNameEdit.getText());
           mMaterial.setMinInStock(Float.parseFloat(jTextFieldMinUnitEdit.getText()));
           mMaterial.update();
           currentJPMRI.setDishName(jTextFieldMaterialNameEdit.getText());
           currentJPMRI.setLimit(Float.parseFloat(jTextFieldMinUnitEdit.getText()));
           currentJPMRI.customInit();
           jDialogEditMaterial.setVisible(false);
            JOptionPane.showMessageDialog(this, "Sửa bàn thành công!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Có lỗi xảy ra, không thể sửa!");
            ex.printStackTrace();
        }

       
         this.revalidate();
         this.repaint();
    }//GEN-LAST:event_jLabelEditMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog jDialogAddMaterial;
    private javax.swing.JDialog jDialogEditMaterial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelAddMaterial;
    private javax.swing.JLabel jLabelCancel;
    private javax.swing.JLabel jLabelCloseAdd;
    private javax.swing.JLabel jLabelDoAddMaterial;
    private javax.swing.JLabel jLabelEdit;
    private javax.swing.JLabel jLabelImportMaterial;
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
    private javax.swing.JTextField jTextFieldMaterialNameEdit;
    private javax.swing.JTextField jTextFieldMinUnitEdit;
    private javax.swing.JTextField jTextFieldName;
    private javax.swing.JTextField jTextFieldUnit;
    // End of variables declaration//GEN-END:variables
}
