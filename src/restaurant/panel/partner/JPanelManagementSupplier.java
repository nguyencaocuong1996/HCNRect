/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.panel.partner;

import core.ComboboxItem;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import modal.MProvider;
import modal.MStaff;
import restaurant.panel.staff.JPanelManagementStaff;
import restaurant.panel.staff.JPanelStaffRowItem;
import view.VDepartment;
import view.VProvider;
import view.VStaff;
import view.ViewItem;

/**
 *
 * @author khanhnguyen
 */
public class JPanelManagementSupplier extends javax.swing.JPanel {

    /**
     * Creates new form JPanelManagementSupplier
     */
    protected static JPanelManagementSupplier instance;
    public VProvider listSupplier;
    protected HashMap<Integer, JPanelSupplierRowItem> listJPSRI = new HashMap<>();
    protected JPanelSupplierRowItem currentJPSRI;
    
    public JPanelManagementSupplier(){
        initComponents();
        customInit();
     
    }
    
    private void customInit(){
        jDialogAddSupplier.setLocationRelativeTo(this);
        jDialogEditSupplier.setLocationRelativeTo(this);
        try {
            listSupplier = VProvider.getAllProvider();
        } catch (SQLException e) {
        }
        
        Iterator i = listSupplier.getData().iterator();        
        int count = 0;
        while(i.hasNext()){
            ViewItem t = (ViewItem) i.next();
            Long id = (Long) t.get("MaNCC");
            String name = (String) t.get("TenNCC");
            String sodienthoai = (String) t.get("SDTNCC");
            String diachi = (String) t.get("DiaChiNCC");
            String motaNCC = ((String)t.get("MoTaNCC"));
            JPanelSupplierRowItem jpSRI = new JPanelSupplierRowItem(id.intValue(), name, sodienthoai, diachi,(count % 2 != 0));
            jpSRI.getjLabelEdit().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    Component jl = (Component) e.getSource();
                    currentJPSRI = (JPanelSupplierRowItem) jl.getParent();
                    jLabelSupplierIdEdit.setText(""+id);
                    jTextFieldSupplierNameEdit.setText(name);
                    jTextFieldPhoneEdit.setText(sodienthoai);
                    jTextFieldAddressEdit.setText(diachi);
                    jTextAreaDescriptionEdit.setText(motaNCC);
                    jDialogEditSupplier.setVisible(true);
                    
                }                
            });
            listJPSRI.put(id.intValue(), jpSRI);
            jPanelTableContent.add(jpSRI);
            count++;
        };
        int height = listSupplier.getData().size() * 62;
        jPanelTableContent.setPreferredSize(new Dimension(780, height));
        
        
   
    }
    
    public static JPanelManagementSupplier getInstance() {
        if (instance == null) {
            instance = new JPanelManagementSupplier();
        }
        return instance;
    }

    public JPanel getjPanelTableContent() {
        return jPanelTableContent;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialogAddSupplier = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldNameAdd = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldPhoneAdd = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldAddressAdd = new javax.swing.JTextField();
        jLabelCloseAdd = new javax.swing.JLabel();
        jLabelDoAddSupplier = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaDescriptionAdd = new javax.swing.JTextArea();
        jDialogEditSupplier = new javax.swing.JDialog();
        jPanel5 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabelSupplierIdEdit = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jTextFieldSupplierNameEdit = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabelDoEditTable = new javax.swing.JLabel();
        jLabelCloseDialogEdit = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldPhoneEdit = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldAddressEdit = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaDescriptionEdit = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabelAddStaff = new javax.swing.JLabel();
        jTextFieldFilterName = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanelTableHeader4 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanelTableContent = new javax.swing.JPanel();

        jDialogAddSupplier.setMinimumSize(new java.awt.Dimension(450, 396));

        jPanel3.setBackground(new java.awt.Color(147, 193, 120));
        jPanel3.setPreferredSize(new java.awt.Dimension(400, 60));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_add_folder_white_32px.png"))); // NOI18N
        jLabel6.setText("Thêm Nhà Cung Cấp");

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
        jLabel8.setText("Tên NCC:");

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Số điện thoại:");

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Mô tả:");

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Địa chỉ:");

        jLabelCloseAdd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCloseAdd.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCloseAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_close_white_x24.png"))); // NOI18N
        jLabelCloseAdd.setText("Hủy");
        jLabelCloseAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCloseAddMouseClicked(evt);
            }
        });

        jLabelDoAddSupplier.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelDoAddSupplier.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDoAddSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_add_row_x24.png"))); // NOI18N
        jLabelDoAddSupplier.setText("Thêm");
        jLabelDoAddSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelDoAddSupplierMouseClicked(evt);
            }
        });

        jTextAreaDescriptionAdd.setColumns(20);
        jTextAreaDescriptionAdd.setRows(5);
        jScrollPane2.setViewportView(jTextAreaDescriptionAdd);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabelDoAddSupplier))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                        .addGap(83, 83, 83))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextFieldNameAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                        .addComponent(jTextFieldPhoneAdd)
                        .addComponent(jTextFieldAddressAdd)
                        .addComponent(jScrollPane2))
                    .addComponent(jLabelCloseAdd))
                .addContainerGap(97, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextFieldNameAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextFieldPhoneAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jTextFieldAddressAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDoAddSupplier)
                    .addComponent(jLabelCloseAdd))
                .addContainerGap(101, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jDialogAddSupplierLayout = new javax.swing.GroupLayout(jDialogAddSupplier.getContentPane());
        jDialogAddSupplier.getContentPane().setLayout(jDialogAddSupplierLayout);
        jDialogAddSupplierLayout.setHorizontalGroup(
            jDialogAddSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialogAddSupplierLayout.setVerticalGroup(
            jDialogAddSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogAddSupplierLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jDialogEditSupplier.setLocationByPlatform(true);
        jDialogEditSupplier.setMinimumSize(new java.awt.Dimension(447, 406));

        jPanel5.setBackground(new java.awt.Color(147, 193, 120));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_book_table_x24.png"))); // NOI18N
        jLabel14.setText("Sửa nhà cung cấp");

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Mã NCC: ");

        jLabelSupplierIdEdit.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSupplierIdEdit.setText("1");

        jPanel6.setBackground(new java.awt.Color(70, 92, 139));

        jLabel12.setText("Tên NCC:");

        jLabel13.setText("Số Điện Thoại:");

        jLabelDoEditTable.setBackground(new java.awt.Color(51, 153, 0));
        jLabelDoEditTable.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDoEditTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_plus_border_white_x24.png"))); // NOI18N
        jLabelDoEditTable.setText("Sửa");
        jLabelDoEditTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelDoEditTableMouseClicked(evt);
            }
        });

        jLabelCloseDialogEdit.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCloseDialogEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_close_white_x24.png"))); // NOI18N
        jLabelCloseDialogEdit.setText("Hủy");
        jLabelCloseDialogEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCloseDialogEditMouseClicked(evt);
            }
        });

        jLabel2.setText("Địa chỉ:");

        jLabel3.setText("Mô tả:");

        jTextAreaDescriptionEdit.setColumns(20);
        jTextAreaDescriptionEdit.setRows(5);
        jScrollPane3.setViewportView(jTextAreaDescriptionEdit);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(jLabelDoEditTable, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelCloseDialogEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(58, 58, 58))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(52, 52, 52)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                            .addComponent(jTextFieldAddressEdit)
                            .addComponent(jTextFieldPhoneEdit)
                            .addComponent(jTextFieldSupplierNameEdit))
                        .addContainerGap())))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldSupplierNameEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldPhoneEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(9, 9, 9)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldAddressEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDoEditTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelCloseDialogEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelSupplierIdEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(130, Short.MAX_VALUE))
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15)
                    .addComponent(jLabelSupplierIdEdit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jDialogEditSupplierLayout = new javax.swing.GroupLayout(jDialogEditSupplier.getContentPane());
        jDialogEditSupplier.getContentPane().setLayout(jDialogEditSupplierLayout);
        jDialogEditSupplierLayout.setHorizontalGroup(
            jDialogEditSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialogEditSupplierLayout.setVerticalGroup(
            jDialogEditSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogEditSupplierLayout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setMaximumSize(new java.awt.Dimension(778, 520));
        setMinimumSize(new java.awt.Dimension(778, 520));
        setPreferredSize(new java.awt.Dimension(778, 520));

        jPanel1.setPreferredSize(new java.awt.Dimension(425, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_management_search_darkgreen_x32.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setMaximumSize(new java.awt.Dimension(32, 32));
        jLabel1.setMinimumSize(new java.awt.Dimension(32, 32));
        jLabel1.setPreferredSize(new java.awt.Dimension(32, 32));

        jLabelAddStaff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_management_add_x32.png"))); // NOI18N
        jLabelAddStaff.setText("Thêm Nhà Cung Cấp");
        jLabelAddStaff.setPreferredSize(new java.awt.Dimension(100, 32));
        jLabelAddStaff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAddStaffMouseClicked(evt);
            }
        });

        jTextFieldFilterName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldFilterNameKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextFieldFilterName, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jLabelAddStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelAddStaff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldFilterName, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8))
        );

        jPanel2.setMaximumSize(new java.awt.Dimension(780, 480));
        jPanel2.setMinimumSize(new java.awt.Dimension(780, 480));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel23.setText("Mã");

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel24.setText("Tên NCC");

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel25.setText("SĐT");

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel26.setText("Địa Chỉ");

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setMaximumSize(new java.awt.Dimension(770, 0));
        jScrollPane1.setMinimumSize(new java.awt.Dimension(770, 0));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(770, 0));
        jScrollPane1.setViewportView(jPanelTableContent);

        javax.swing.GroupLayout jPanelTableHeader4Layout = new javax.swing.GroupLayout(jPanelTableHeader4);
        jPanelTableHeader4.setLayout(jPanelTableHeader4Layout);
        jPanelTableHeader4Layout.setHorizontalGroup(
            jPanelTableHeader4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTableHeader4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23)
                .addGap(64, 64, 64)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel27)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
        );
        jPanelTableHeader4Layout.setVerticalGroup(
            jPanelTableHeader4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTableHeader4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanelTableHeader4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25)
                    .addComponent(jLabel26)
                    .addComponent(jLabel27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelTableHeader4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanelTableHeader4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelAddStaffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAddStaffMouseClicked
        // TODO add your handling code here:
        jDialogAddSupplier.setVisible(true);
    }//GEN-LAST:event_jLabelAddStaffMouseClicked

    private void jTextFieldFilterNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldFilterNameKeyReleased
        // TODO add your handling code here:
        //filter();
    }//GEN-LAST:event_jTextFieldFilterNameKeyReleased

    private void jLabelCloseAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCloseAddMouseClicked
        jDialogAddSupplier.setVisible(false);
    }//GEN-LAST:event_jLabelCloseAddMouseClicked

    private void jLabelDoAddSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDoAddSupplierMouseClicked
        try {
            String name = jTextFieldNameAdd.getText();
            String description = jTextAreaDescriptionAdd.getText();
            String phone = jTextFieldPhoneAdd.getText();
            String address = jTextFieldAddressAdd.getText();
            MProvider mProvider = new MProvider(name, phone , address, description);
            mProvider.insert();
            jDialogAddSupplier.setVisible(false);

        } catch (NumberFormatException e) {
            // JOptionPane.showMessageDialog(this, "Có lỗi xảy ra! Vui lòng kiểm tra lại kiểu dữ liệu!");
            e.printStackTrace();
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(this, "Có lỗi xảy ra! Lỗi database!");
            ex.printStackTrace();
        }

        jPanelTableContent.removeAll();
        customInit();
        int height = listSupplier.getFilterData().size() * 58 + 58;
        jPanelTableContent.setPreferredSize(new Dimension(780, height));
        this.revalidate();
        this.repaint();
    }//GEN-LAST:event_jLabelDoAddSupplierMouseClicked

    private void jLabelDoEditTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDoEditTableMouseClicked
        MProvider mProvider = new MProvider();
        mProvider.setId(Integer.parseInt(jLabelSupplierIdEdit.getText()));
        mProvider.setName(jTextFieldSupplierNameEdit.getText());
        mProvider.setPhone(jTextFieldPhoneEdit.getText());
        mProvider.setAddress(jTextFieldAddressEdit.getText());
        mProvider.setDescription(jTextAreaDescriptionEdit.getText());
        try {
            mProvider.update();
            currentJPSRI.setTenNCC(jTextFieldSupplierNameEdit.getText());
            currentJPSRI.setSoDienThoai(jTextFieldPhoneEdit.getText());
            currentJPSRI.setDiaChi(jTextFieldAddressEdit.getText());
            currentJPSRI.customInit();
            jDialogEditSupplier.setVisible(false);
            JOptionPane.showMessageDialog(this, "Sửa nhà cung cấp thành công!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Có lỗi xảy ra, không thể sửa!");
            e.printStackTrace();
        }

        this.revalidate();
        this.repaint();
    }//GEN-LAST:event_jLabelDoEditTableMouseClicked

    private void jLabelCloseDialogEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCloseDialogEditMouseClicked
        jDialogEditSupplier.setVisible(false);
    }//GEN-LAST:event_jLabelCloseDialogEditMouseClicked

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog jDialogAddSupplier;
    private javax.swing.JDialog jDialogEditSupplier;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelAddStaff;
    private javax.swing.JLabel jLabelCloseAdd;
    private javax.swing.JLabel jLabelCloseDialogEdit;
    private javax.swing.JLabel jLabelDoAddSupplier;
    private javax.swing.JLabel jLabelDoEditTable;
    private javax.swing.JLabel jLabelSupplierIdEdit;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanelTableContent;
    private javax.swing.JPanel jPanelTableHeader4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextAreaDescriptionAdd;
    private javax.swing.JTextArea jTextAreaDescriptionEdit;
    private javax.swing.JTextField jTextFieldAddressAdd;
    private javax.swing.JTextField jTextFieldAddressEdit;
    private javax.swing.JTextField jTextFieldFilterName;
    private javax.swing.JTextField jTextFieldNameAdd;
    private javax.swing.JTextField jTextFieldPhoneAdd;
    private javax.swing.JTextField jTextFieldPhoneEdit;
    private javax.swing.JTextField jTextFieldSupplierNameEdit;
    // End of variables declaration//GEN-END:variables
}
