/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.panel.staff;

import core.ComboboxItem;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import modal.MStaff;
import modal.MUser;
import view.VDepartment;
import view.VStaff;
import view.ViewItem;

/**
 *
 * @author khanhnguyen
 */
public class JPanelManagementStaff extends javax.swing.JPanel {
    protected static JPanelManagementStaff instance;
    public VStaff listStaff;
    public VDepartment  listDepartment;
    protected HashMap<Integer, JPanelStaffRowItem> listJPSRI = new HashMap<>();
    protected HashMap<Integer, ComboboxItem> listPB = new HashMap<>();
    protected JPanelStaffRowItem currentJPSRI;
    public JPanelManagementStaff() {
        initComponents();
        customInit();
     
    }
    
    private void customInit(){
        jDialogAddStaff.setLocationRelativeTo(this);
        jDialogEditStaff.setLocationRelativeTo(this);
        jDialogAddUser.setLocationRelativeTo(this);
        listStaff = VStaff.getAllStaff();
        Iterator i = listStaff.getData().iterator();        
        int count = 0;
        while(i.hasNext()){
            ViewItem t = (ViewItem) i.next();
            Long id = (Long) t.get("MaNV");
            String name = (String) t.get("HoTenNV");
            String sodienthoai = (String) t.get("SDTNV");
            String diachi = (String) t.get("DiaChiNV");
            int maPB = ((Integer)t.get("MaPB"));
            JPanelStaffRowItem jpSRI = new JPanelStaffRowItem(id.intValue(), name, sodienthoai, diachi,(count % 2 != 0));
            jpSRI.getjLabelEdit().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    Component jl = (Component) e.getSource();
                    currentJPSRI = (JPanelStaffRowItem) jl.getParent();
                    jLabelStaffIdEdit.setText(""+id);
                    jTextFieldStaffNameEdit.setText(name);
                    jTextFieldPhoneEdit.setText(sodienthoai);
                    jTextFieldAddressEdit.setText(diachi);
                    jDialogEditStaff.setVisible(true);
                    jComboBoxDepartmentEdit.setSelectedItem(listPB.get(maPB));
                }                
            });
            
            jpSRI.getjLabelAddUserStaff().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    Component jl = (Component) e.getSource();
                    currentJPSRI = (JPanelStaffRowItem) jl.getParent();
                    jLabelStaffIdAddUser.setText(""+id);
                    jLabelStaffNameAddUser.setText(name);                    
                    jDialogAddUser.setVisible(true);
                }                
            });
            
            listJPSRI.put(id.intValue(), jpSRI);
            jPanelTableContent.add(jpSRI);
            count++;
        };
        int height = listStaff.getData().size() * 62;
        jPanelTableContent.setPreferredSize(new Dimension(780, height));
        
        ArrayList<ComboboxItem> listCI = new ArrayList<>();
        try {
            listDepartment = VDepartment.getAllDepartment();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        listDepartment.getData().forEach((t) -> {
            String name = (String)t.get("TenPB");
            int id = ((Long)t.get("MaPB")).intValue();
            listPB.put(id, new ComboboxItem(name, id));
            jComboBoxDepartment.addItem(listPB.get(id)); 
            jComboBoxDepartmentEdit.addItem(listPB.get(id));
        });
    }
    
    public static JPanelManagementStaff getInstance() {
        if (instance == null) {
            instance = new JPanelManagementStaff();
        }
        return instance;
    }

    public JPanel getjPanelTableContent() {
        return jPanelTableContent;
    }
    
    private void filter(){
        jPanelTableContent.removeAll();
        listStaff.filter(jTextFieldFilterName.getText());
        Iterator i = listStaff.getFilterData().iterator();
        int count = 0;
        while(i.hasNext()){
            ViewItem t = (ViewItem) i.next();
            Long id = (Long) t.get("MaNV");
            jPanelTableContent.add(listJPSRI.get(id.intValue()));
        }
        int height = listStaff.getFilterData().size() * 62;
        jPanelTableContent.setPreferredSize(new Dimension(780, height));
        this.revalidate();
        this.repaint();
    }
    
     
     
     
     public static void main(String[] args) {
        JFrame jf = new JFrame("hoho");
        jf.setSize(new Dimension(785,600));
        jf.add(JPanelManagementStaff.getInstance());
        jf.setVisible(true);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialogAddStaff = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldName = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldPhone = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldAddress = new javax.swing.JTextField();
        jLabelCloseAdd = new javax.swing.JLabel();
        jLabelDoAddStaff = new javax.swing.JLabel();
        jComboBoxDepartment = new javax.swing.JComboBox<>();
        jDialogEditStaff = new javax.swing.JDialog();
        jPanel5 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabelStaffIdEdit = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jTextFieldStaffNameEdit = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabelDoEditTable = new javax.swing.JLabel();
        jLabelCloseDialogEdit = new javax.swing.JLabel();
        jComboBoxDepartmentEdit = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldPhoneEdit = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldAddressEdit = new javax.swing.JTextField();
        jDialogAddUser = new javax.swing.JDialog();
        jPanel7 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabelStaffIdAddUser = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabelDoAddUser = new javax.swing.JLabel();
        jLabelCloseDialogEdit1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldUser = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabelStaffNameAddUser = new javax.swing.JLabel();
        jPasswordFieldPassWord = new javax.swing.JPasswordField();
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

        jDialogAddStaff.setMinimumSize(new java.awt.Dimension(500, 300));

        jPanel3.setBackground(new java.awt.Color(147, 193, 120));
        jPanel3.setPreferredSize(new java.awt.Dimension(400, 60));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_add_folder_white_32px.png"))); // NOI18N
        jLabel6.setText("Thêm Nhân Viên");

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
        jLabel8.setText("Tên NV:");

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Số điện thoại:");

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Địa chỉ:");

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Phòng ban:");

        jLabelCloseAdd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCloseAdd.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCloseAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_close_white_x24.png"))); // NOI18N
        jLabelCloseAdd.setText("Hủy");
        jLabelCloseAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCloseAddMouseClicked(evt);
            }
        });

        jLabelDoAddStaff.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelDoAddStaff.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDoAddStaff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_add_row_x24.png"))); // NOI18N
        jLabelDoAddStaff.setText("Thêm");
        jLabelDoAddStaff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelDoAddStaffMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(89, 89, 89))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabelDoAddStaff))
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextFieldName)
                        .addComponent(jComboBoxDepartment, 0, 173, Short.MAX_VALUE)
                        .addComponent(jTextFieldPhone)
                        .addComponent(jTextFieldAddress))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(jLabelCloseAdd)))
                .addContainerGap(274, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addComponent(jComboBoxDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextFieldPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextFieldAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDoAddStaff)
                    .addComponent(jLabelCloseAdd))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        jLabel11.getAccessibleContext().setAccessibleName("Phòng Ban:");

        javax.swing.GroupLayout jDialogAddStaffLayout = new javax.swing.GroupLayout(jDialogAddStaff.getContentPane());
        jDialogAddStaff.getContentPane().setLayout(jDialogAddStaffLayout);
        jDialogAddStaffLayout.setHorizontalGroup(
            jDialogAddStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialogAddStaffLayout.setVerticalGroup(
            jDialogAddStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogAddStaffLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jDialogEditStaff.setMinimumSize(new java.awt.Dimension(500, 300));

        jPanel5.setBackground(new java.awt.Color(147, 193, 120));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_book_table_x24.png"))); // NOI18N
        jLabel14.setText("Sửa nhân viên");

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Mã nhân viên: ");

        jLabelStaffIdEdit.setForeground(new java.awt.Color(255, 255, 255));
        jLabelStaffIdEdit.setText("1");

        jPanel6.setBackground(new java.awt.Color(70, 92, 139));

        jLabel12.setText("Tên nhân viên:");

        jLabel13.setText("Phòng ban:");

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

        jLabel2.setText("Số điện thoại:");

        jLabel3.setText("Địa chỉ:");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(jTextFieldStaffNameEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelDoEditTable, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelCloseDialogEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldPhoneEdit, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                                    .addComponent(jTextFieldAddressEdit, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                                    .addComponent(jComboBoxDepartmentEdit, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap(131, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldStaffNameEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jComboBoxDepartmentEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldPhoneEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldAddressEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDoEditTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelCloseDialogEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(51, 51, 51))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelStaffIdEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15)
                    .addComponent(jLabelStaffIdEdit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jDialogEditStaffLayout = new javax.swing.GroupLayout(jDialogEditStaff.getContentPane());
        jDialogEditStaff.getContentPane().setLayout(jDialogEditStaffLayout);
        jDialogEditStaffLayout.setHorizontalGroup(
            jDialogEditStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialogEditStaffLayout.setVerticalGroup(
            jDialogEditStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogEditStaffLayout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        jDialogAddUser.setMaximumSize(new java.awt.Dimension(400, 300));
        jDialogAddUser.setMinimumSize(new java.awt.Dimension(400, 300));

        jPanel7.setBackground(new java.awt.Color(147, 193, 120));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_book_table_x24.png"))); // NOI18N
        jLabel16.setText("Tạo tài khoản");

        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Mã nhân viên: ");

        jLabelStaffIdAddUser.setForeground(new java.awt.Color(255, 255, 255));
        jLabelStaffIdAddUser.setText("1");

        jPanel8.setBackground(new java.awt.Color(70, 92, 139));

        jLabel18.setText("Tên nhân viên:");

        jLabelDoAddUser.setBackground(new java.awt.Color(51, 153, 0));
        jLabelDoAddUser.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDoAddUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_plus_border_white_x24.png"))); // NOI18N
        jLabelDoAddUser.setText("Thêm");
        jLabelDoAddUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelDoAddUserMouseClicked(evt);
            }
        });

        jLabelCloseDialogEdit1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCloseDialogEdit1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_close_white_x24.png"))); // NOI18N
        jLabelCloseDialogEdit1.setText("Hủy");
        jLabelCloseDialogEdit1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCloseDialogEdit1MouseClicked(evt);
            }
        });

        jLabel4.setText("Tên đăng nhập:");

        jLabel5.setText("Mật khẩu:");

        jLabelStaffNameAddUser.setForeground(new java.awt.Color(255, 255, 255));
        jLabelStaffNameAddUser.setText("1");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabelDoAddUser, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelCloseDialogEdit1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabelStaffNameAddUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextFieldUser, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                                    .addComponent(jPasswordFieldPassWord)))))
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelStaffNameAddUser))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jPasswordFieldPassWord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDoAddUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelCloseDialogEdit1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(51, 51, 51))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelStaffIdAddUser, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
            .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel17)
                    .addComponent(jLabelStaffIdAddUser))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jDialogAddUserLayout = new javax.swing.GroupLayout(jDialogAddUser.getContentPane());
        jDialogAddUser.getContentPane().setLayout(jDialogAddUserLayout);
        jDialogAddUserLayout.setHorizontalGroup(
            jDialogAddUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialogAddUserLayout.setVerticalGroup(
            jDialogAddUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogAddUserLayout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
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
        jLabelAddStaff.setText("Thêm Nhân Viên");
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
                .addGap(49, 49, 49)
                .addComponent(jLabelAddStaff, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
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
        jPanel2.setPreferredSize(new java.awt.Dimension(780, 480));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel23.setText("Mã");

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel24.setText("Tên NV");

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
                .addGap(18, 18, 18)
                .addComponent(jLabel23)
                .addGap(85, 85, 85)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel27)
                .addGap(46, 46, 46)
                .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void jTextFieldFilterNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldFilterNameKeyReleased
        // TODO add your handling code here:
        filter();
    }//GEN-LAST:event_jTextFieldFilterNameKeyReleased

    private void jLabelAddStaffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAddStaffMouseClicked
        // TODO add your handling code here:
      jDialogAddStaff.setVisible(true);
    }//GEN-LAST:event_jLabelAddStaffMouseClicked

    private void jLabelCloseAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCloseAddMouseClicked
        jDialogAddStaff.setVisible(false);
    }//GEN-LAST:event_jLabelCloseAddMouseClicked
   
    private void jLabelDoAddStaffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDoAddStaffMouseClicked
        try {
            String name = jTextFieldName.getText();
            int departmentID = (int)((ComboboxItem)(jComboBoxDepartment.getSelectedItem())).getValue();
            String phone = jTextFieldPhone.getText();
            String address = jTextFieldAddress.getText();
            MStaff mStaff = new MStaff(name, phone , address, departmentID);
            mStaff.insert();
            jDialogAddStaff.setVisible(false);

        } catch (NumberFormatException e) {
           // JOptionPane.showMessageDialog(this, "Có lỗi xảy ra! Vui lòng kiểm tra lại kiểu dữ liệu!");
            e.printStackTrace();
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(this, "Có lỗi xảy ra! Lỗi database!");
            ex.printStackTrace();
        }

        jPanelTableContent.removeAll();
        customInit();
        int height = listStaff.getFilterData().size() * 58 + 58;
        jPanelTableContent.setPreferredSize(new Dimension(780, height));
        this.revalidate();
        this.repaint();
    }//GEN-LAST:event_jLabelDoAddStaffMouseClicked

    private void jLabelDoEditTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDoEditTableMouseClicked
        MStaff mStaff = new MStaff();
        mStaff.setId(Integer.parseInt(jLabelStaffIdEdit.getText()));
        mStaff.setName(jTextFieldStaffNameEdit.getText());
        mStaff.setPhone(jTextFieldPhoneEdit.getText());
        mStaff.setAddress(jTextFieldAddressEdit.getText());
        mStaff.setDepartmentId((int)((ComboboxItem)(jComboBoxDepartmentEdit.getSelectedItem())).getValue());
        try {
            mStaff.update();
            currentJPSRI.setTenNV(jTextFieldStaffNameEdit.getText());
            currentJPSRI.setSoDienThoai(jTextFieldPhoneEdit.getText());
            currentJPSRI.setDiaChi(jTextFieldAddressEdit.getText());
            currentJPSRI.customInit();
            jDialogEditStaff.setVisible(false);
            JOptionPane.showMessageDialog(this, "Sửa bàn thành công!");
           
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Có lỗi xảy ra, không thể sửa!");
            e.printStackTrace();
        }

         this.revalidate();
            this.repaint();
    }//GEN-LAST:event_jLabelDoEditTableMouseClicked

    private void jLabelCloseDialogEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCloseDialogEditMouseClicked
        jDialogEditStaff.setVisible(false);
    }//GEN-LAST:event_jLabelCloseDialogEditMouseClicked

    private void jLabelCloseDialogEdit1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCloseDialogEdit1MouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jLabelCloseDialogEdit1MouseClicked

    private void jLabelDoAddUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDoAddUserMouseClicked
        // TODO add your handling code here:
        try {
            String userName = jTextFieldUser.getText();
            int StaffID = Integer.parseInt(jLabelStaffIdAddUser.getText());
            String password = String.valueOf(jPasswordFieldPassWord.getPassword());
            MUser mUser = new MUser(StaffID, userName , password);
            mUser.insert();
            jDialogAddUser.setVisible(false);
            JOptionPane.showMessageDialog(this, "Thêm thành công!");
        } catch (NumberFormatException e) {
           // JOptionPane.showMessageDialog(this, "Có lỗi xảy ra! Vui lòng kiểm tra lại kiểu dữ liệu!");
            e.printStackTrace();
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(this, "Có lỗi xảy ra! Lỗi database!");
            JOptionPane.showMessageDialog(this, "Có lỗi xảy ra, không thể thêm!");
            ex.printStackTrace();
        }

        jPanelTableContent.removeAll();
        customInit();
        int height = listStaff.getFilterData().size() * 58 + 58;
        jPanelTableContent.setPreferredSize(new Dimension(780, height));
        this.revalidate();
        this.repaint();
    }//GEN-LAST:event_jLabelDoAddUserMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<ComboboxItem> jComboBoxDepartment;
    private javax.swing.JComboBox<ComboboxItem> jComboBoxDepartmentEdit;
    private javax.swing.JDialog jDialogAddStaff;
    private javax.swing.JDialog jDialogAddUser;
    private javax.swing.JDialog jDialogEditStaff;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelAddStaff;
    private javax.swing.JLabel jLabelCloseAdd;
    private javax.swing.JLabel jLabelCloseDialogEdit;
    private javax.swing.JLabel jLabelCloseDialogEdit1;
    private javax.swing.JLabel jLabelDoAddStaff;
    private javax.swing.JLabel jLabelDoAddUser;
    private javax.swing.JLabel jLabelDoEditTable;
    private javax.swing.JLabel jLabelStaffIdAddUser;
    private javax.swing.JLabel jLabelStaffIdEdit;
    private javax.swing.JLabel jLabelStaffNameAddUser;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanelTableContent;
    private javax.swing.JPanel jPanelTableHeader4;
    private javax.swing.JPasswordField jPasswordFieldPassWord;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldAddress;
    private javax.swing.JTextField jTextFieldAddressEdit;
    private javax.swing.JTextField jTextFieldFilterName;
    private javax.swing.JTextField jTextFieldName;
    private javax.swing.JTextField jTextFieldPhone;
    private javax.swing.JTextField jTextFieldPhoneEdit;
    private javax.swing.JTextField jTextFieldStaffNameEdit;
    private javax.swing.JTextField jTextFieldUser;
    // End of variables declaration//GEN-END:variables
}
