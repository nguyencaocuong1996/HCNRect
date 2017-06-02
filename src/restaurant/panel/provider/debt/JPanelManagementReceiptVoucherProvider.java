/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.panel.provider.debt;

import core.CDateTime;
import restaurant.panel.ppackkage.*;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import modal.MMaterial;
import modal.MProvider;
import modal.MReceiptVoucherProvider;
import restaurant.MainFrame;
import restaurant.panel.PanelFactory;
import restaurant.panel.ppackkage.material.JPanelImportMaterial;
import restaurant.panel.staff.JPanelStaffRowItem;
import view.VMaterial;
import view.VReceiptVoucherProvider;
import view.ViewItem;

public class JPanelManagementReceiptVoucherProvider extends javax.swing.JPanel {
    protected static JPanelManagementReceiptVoucherProvider instance;
    protected VReceiptVoucherProvider listReceiptVoucherProvider;
    protected HashMap<Integer, JPanelReceiptVoucherProviderRowItem> listJPRVPRI = new HashMap<>();
    protected JPanelMaterialRowItem currentJPMRI;
    protected MProvider provider;
    
    public JPanelManagementReceiptVoucherProvider() {
        initComponents();
        jDialogAddRVP.setLocationRelativeTo(this);
        jDialogEditMaterial.setLocationRelativeTo(this);
        jDialogChooseProvider.setLocationRelativeTo(this);
    }
    private void filter(){
        jPanelTableContent.removeAll();
        try {
            listReceiptVoucherProvider = VReceiptVoucherProvider.getByProvider(provider.getId());
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Có lỗi xảy ra, không thể lấy thông tin phiếu chi!");
            return;
        }
        
        Iterator i = listReceiptVoucherProvider.getFilterData().iterator();
        int count = 0;
        while(i.hasNext()){
            ViewItem t = (ViewItem) i.next();
            int id = ((Integer) t.get("MaPCNCC"));
            int pId = ((Integer) t.get("MaNCC"));
            String date = CDateTime.dateToDMY((java.util.Date) t.get("NgayChi"));
            float amount = (Float) t.get("SoTienChi");
            String note = (String) t.get("GhiChuPC");
            if (listJPRVPRI.get(id) == null) {
                listJPRVPRI.put(id, new JPanelReceiptVoucherProviderRowItem(id, pId, date, amount, note, (count % 2) != 0));
            }
            jPanelTableContent.add(listJPRVPRI.get(id));
            count++;
        }
        int height = listReceiptVoucherProvider.getFilterData().size() * 58;
        jPanelTableContent.setPreferredSize(new Dimension(780, height));
        this.revalidate();
        this.repaint();
    }

    public static JPanelManagementReceiptVoucherProvider getInstance() {
        if (instance == null) {
            instance = new JPanelManagementReceiptVoucherProvider();
        }
        return instance;
    }
    public JPanel getjPanelTableContent() {
        return jPanelTableContent;
    }

    public MProvider getProvider() {
        return provider;
    }

    public void setProvider(MProvider provider) {
        this.provider = provider;
        jLabelChooseProvider.setText(provider.getName());
        filter();
    }

    public JDialog getjDialogChooseProvider() {
        return jDialogChooseProvider;
    }
    
    public static void main(String[] args) {
        JFrame jf = new JFrame("hoho");
        jf.setSize(new Dimension(785,600));
        jf.add(JPanelManagementReceiptVoucherProvider.getInstance());
        jf.setVisible(true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialogAddRVP = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabelAddRVPProviderName = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldAmount = new javax.swing.JTextField();
        jLabelCloseAddRVP = new javax.swing.JLabel();
        jLabelDoAddRVP = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaNote = new javax.swing.JTextArea();
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
        jDialogChooseProvider = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabelChooseProvider = new javax.swing.JLabel();
        jLabelAddRVP = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanelTableHeader = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanelTableContent = new javax.swing.JPanel();

        jDialogAddRVP.setMaximumSize(new java.awt.Dimension(400, 270));
        jDialogAddRVP.setMinimumSize(new java.awt.Dimension(400, 270));
        jDialogAddRVP.setPreferredSize(new java.awt.Dimension(400, 270));

        jPanel3.setBackground(new java.awt.Color(147, 193, 120));
        jPanel3.setPreferredSize(new java.awt.Dimension(400, 60));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_add_folder_white_32px.png"))); // NOI18N
        jLabel6.setText("Lập phiếu chi cho: ");

        jLabelAddRVPProviderName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelAddRVPProviderName.setForeground(new java.awt.Color(255, 255, 255));
        jLabelAddRVPProviderName.setText("Tên nhà cung cấp");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelAddRVPProviderName, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAddRVPProviderName))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(70, 92, 139));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Số tiền chi:");

        jLabelCloseAddRVP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCloseAddRVP.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCloseAddRVP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_close_white_x24.png"))); // NOI18N
        jLabelCloseAddRVP.setText("Hủy");
        jLabelCloseAddRVP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCloseAddRVPMouseClicked(evt);
            }
        });

        jLabelDoAddRVP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelDoAddRVP.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDoAddRVP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_add_row_x24.png"))); // NOI18N
        jLabelDoAddRVP.setText("Lập phiếu");
        jLabelDoAddRVP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelDoAddRVPMouseClicked(evt);
            }
        });

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Lý do chi:");

        jTextAreaNote.setColumns(20);
        jTextAreaNote.setRows(5);
        jScrollPane2.setViewportView(jTextAreaNote);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabelDoAddRVP)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelCloseAddRVP))
                    .addComponent(jTextFieldAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(90, 90, 90))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextFieldAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(77, 77, 77))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDoAddRVP)
                    .addComponent(jLabelCloseAddRVP))
                .addContainerGap())
        );

        javax.swing.GroupLayout jDialogAddRVPLayout = new javax.swing.GroupLayout(jDialogAddRVP.getContentPane());
        jDialogAddRVP.getContentPane().setLayout(jDialogAddRVPLayout);
        jDialogAddRVPLayout.setHorizontalGroup(
            jDialogAddRVPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialogAddRVPLayout.setVerticalGroup(
            jDialogAddRVPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogAddRVPLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        jDialogChooseProvider.setMinimumSize(new java.awt.Dimension(425, 360));
        jDialogChooseProvider.getContentPane().setLayout(new java.awt.FlowLayout());

        setMaximumSize(new java.awt.Dimension(780, 531));
        setMinimumSize(new java.awt.Dimension(780, 531));

        jPanel1.setMaximumSize(new java.awt.Dimension(451, 42));
        jPanel1.setMinimumSize(new java.awt.Dimension(451, 42));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_management_search_darkgreen_x32.png"))); // NOI18N

        jLabelChooseProvider.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_customer_support_darkgreen_x32.png"))); // NOI18N
        jLabelChooseProvider.setText("Click chọn nhà cung cấp");
        jLabelChooseProvider.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelChooseProviderMouseClicked(evt);
            }
        });

        jLabelAddRVP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_management_add_x32.png"))); // NOI18N
        jLabelAddRVP.setText("Lập phiếu chi");
        jLabelAddRVP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAddRVPMouseClicked(evt);
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
                .addComponent(jLabelChooseProvider, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelAddRVP, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelChooseProvider)
                        .addComponent(jLabelAddRVP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 14, Short.MAX_VALUE))
        );

        jPanel2.setMaximumSize(new java.awt.Dimension(780, 455));
        jPanel2.setMinimumSize(new java.awt.Dimension(780, 455));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Mã PC");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Tên NCC");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Số tiền chi");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Ngày chi");

        javax.swing.GroupLayout jPanelTableHeaderLayout = new javax.swing.GroupLayout(jPanelTableHeader);
        jPanelTableHeader.setLayout(jPanelTableHeaderLayout);
        jPanelTableHeaderLayout.setHorizontalGroup(
            jPanelTableHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTableHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(54, 54, 54)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(94, 94, 94)
                .addComponent(jLabel7)
                .addGap(60, 60, 60))
        );
        jPanelTableHeaderLayout.setVerticalGroup(
            jPanelTableHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTableHeaderLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanelTableHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5))
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
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanelTableHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(82, 82, 82))
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

    private void jLabelCloseAddRVPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCloseAddRVPMouseClicked
        jDialogAddRVP.setVisible(false);
    }//GEN-LAST:event_jLabelCloseAddRVPMouseClicked

    private void jLabelDoAddRVPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDoAddRVPMouseClicked
        if (provider != null) {
            MReceiptVoucherProvider rvp = new MReceiptVoucherProvider();
            rvp.setProviderId(provider.getId());
            float amount = 0;
            try {
                amount = Float.valueOf(jTextFieldAmount.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Số tiền chi chỉ được nhập số!");
            }
            rvp.setMoney(amount);
            rvp.setDate(CDateTime.getInstance().getDate().toString());
            rvp.setNote(jTextAreaNote.getText());
            rvp.setStaffId(MainFrame.getInstance().getStaff().getId());
            try {
                rvp.insert();
                jTextFieldAmount.setText("");
                jTextAreaNote.setText("");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Có lỗi xảy ra không thể lập phiếu chi!");
            }
            
        }
        
        
    }//GEN-LAST:event_jLabelDoAddRVPMouseClicked

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

    private void jLabelChooseProviderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelChooseProviderMouseClicked
        if (!jDialogChooseProvider.isAncestorOf(JPanelChooseProviderForRVP.getInstance())) {
            jDialogChooseProvider.add(JPanelChooseProviderForRVP.getInstance());
        }
        jDialogChooseProvider.setVisible(true);
    }//GEN-LAST:event_jLabelChooseProviderMouseClicked

    private void jLabelAddRVPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAddRVPMouseClicked
        if(provider != null){
            jLabelAddRVPProviderName.setText(provider.getName());
            jDialogAddRVP.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn NCC trước khi lập phiếu!");
        }
    }//GEN-LAST:event_jLabelAddRVPMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog jDialogAddRVP;
    private javax.swing.JDialog jDialogChooseProvider;
    private javax.swing.JDialog jDialogEditMaterial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelAddRVP;
    private javax.swing.JLabel jLabelAddRVPProviderName;
    private javax.swing.JLabel jLabelCancel;
    private javax.swing.JLabel jLabelChooseProvider;
    private javax.swing.JLabel jLabelCloseAddRVP;
    private javax.swing.JLabel jLabelDoAddRVP;
    private javax.swing.JLabel jLabelEdit;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanelTableContent;
    private javax.swing.JPanel jPanelTableHeader;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextAreaNote;
    private javax.swing.JTextField jTextFieldAmount;
    private javax.swing.JTextField jTextFieldMaterialNameEdit;
    private javax.swing.JTextField jTextFieldMinUnitEdit;
    // End of variables declaration//GEN-END:variables
}
