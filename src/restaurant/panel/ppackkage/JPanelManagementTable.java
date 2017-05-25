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
import modal.MTable;
import view.VTable;
import view.ViewItem;

public class JPanelManagementTable extends javax.swing.JPanel {
    protected static JPanelManagementTable instance;
    protected VTable listTable;
    protected HashMap<Integer, JPanelTableRowItem> listJPTRI = new HashMap<>();
    protected JPanelTableRowItem currentJPTRI;
    public JPanelManagementTable() {
        initComponents();
        jDialogAddTable.setLocationRelativeTo(this);
        jDialogEditTable.setLocationRelativeTo(this);
        listTable = VTable.getAllTable();
        Iterator i = listTable.getData().iterator();
        int count = 0;
        while(i.hasNext()){
            ViewItem t = (ViewItem) i.next();
            Integer id = (Integer) t.get("MaBan");
            String name = (String) t.get("TenBan");
            String note = (String) t.get("GhiChu");
            JPanelTableRowItem jpTRI = new JPanelTableRowItem(id, name, note, (count % 2 != 0));
            jpTRI.getjLabelEditTable().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    Component jl = (Component) e.getSource();
                    currentJPTRI = (JPanelTableRowItem) jl.getParent();
                    jTextFieldTableNameEdit.setText(name);
                    jTextAreaNoteEdit.setText(note);
                    jLabelTableIdEdit.setText(id + "");
                    jDialogEditTable.setVisible(true);
                }
                
            });
            listJPTRI.put(id, jpTRI);
            jPanelTableContent.add(jpTRI);
            count++;
        };
        int height = listTable.getData().size() * 58;
        jPanelTableContent.setPreferredSize(new Dimension(780, height));
        
    }
    public void filter(){
        jPanelTableContent.removeAll();
        listTable.filterByName(jTextFieldFilterName.getText());
        Iterator i = listTable.getFilterData().iterator();
        int count = 0;
        while(i.hasNext()){
            ViewItem t = (ViewItem) i.next();
            Integer id = (Integer) t.get("MaBan");
            jPanelTableContent.add(listJPTRI.get(id));
        };
        int height = listTable.getFilterData().size() * 58;
        jPanelTableContent.setPreferredSize(new Dimension(780, height));
        this.revalidate();
        this.repaint();
    }

    public static JPanelManagementTable getInstance() {
        if (instance == null) {
            instance = new JPanelManagementTable();
        }
        return instance;
    }
    
    public static void main(String[] args) {
        JFrame jf = new JFrame("hoho");
        jf.setSize(new Dimension(785,600));
        jf.add(JPanelManagementTable.getInstance());
        jf.setVisible(true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialogAddTable = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldTableName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaNote = new javax.swing.JTextArea();
        jLabelDoAddTable = new javax.swing.JLabel();
        jLabelCloseDialog = new javax.swing.JLabel();
        jDialogEditTable = new javax.swing.JDialog();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabelTableIdEdit = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldTableNameEdit = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaNoteEdit = new javax.swing.JTextArea();
        jLabelDoEditTable = new javax.swing.JLabel();
        jLabelCloseDialogEdit = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldFilterName = new javax.swing.JTextField();
        jLabelAddTable = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanelTableHeader = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanelTableContent = new javax.swing.JPanel();

        jDialogAddTable.setMaximumSize(new java.awt.Dimension(400, 350));
        jDialogAddTable.setMinimumSize(new java.awt.Dimension(400, 350));

        jPanel3.setBackground(new java.awt.Color(147, 193, 120));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_book_table_x24.png"))); // NOI18N
        jLabel2.setText("Thêm bàn");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(70, 92, 139));

        jLabel6.setText("Tên bàn:");

        jLabel7.setText("Ghi chú:");

        jTextAreaNote.setColumns(20);
        jTextAreaNote.setRows(5);
        jScrollPane2.setViewportView(jTextAreaNote);

        jLabelDoAddTable.setBackground(new java.awt.Color(51, 153, 0));
        jLabelDoAddTable.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDoAddTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_plus_border_white_x24.png"))); // NOI18N
        jLabelDoAddTable.setText("Thêm");
        jLabelDoAddTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelDoAddTableMouseClicked(evt);
            }
        });

        jLabelCloseDialog.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCloseDialog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_close_white_x24.png"))); // NOI18N
        jLabelCloseDialog.setText("Hủy");
        jLabelCloseDialog.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCloseDialogMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldTableName, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabelDoAddTable, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelCloseDialog, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldTableName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelDoAddTable, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .addComponent(jLabelCloseDialog, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout jDialogAddTableLayout = new javax.swing.GroupLayout(jDialogAddTable.getContentPane());
        jDialogAddTable.getContentPane().setLayout(jDialogAddTableLayout);
        jDialogAddTableLayout.setHorizontalGroup(
            jDialogAddTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialogAddTableLayout.setVerticalGroup(
            jDialogAddTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogAddTableLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jDialogEditTable.setMinimumSize(new java.awt.Dimension(400, 350));

        jPanel5.setBackground(new java.awt.Color(147, 193, 120));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_book_table_x24.png"))); // NOI18N
        jLabel8.setText("Sửa bài");

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Mã bàn: ");

        jLabelTableIdEdit.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTableIdEdit.setText("1");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelTableIdEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addComponent(jLabelTableIdEdit))
        );

        jPanel6.setBackground(new java.awt.Color(70, 92, 139));

        jLabel9.setText("Tên bàn:");

        jLabel10.setText("Ghi chú:");

        jTextAreaNoteEdit.setColumns(20);
        jTextAreaNoteEdit.setRows(5);
        jScrollPane3.setViewportView(jTextAreaNoteEdit);

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

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldTableNameEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabelDoEditTable, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelCloseDialogEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldTableNameEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelDoEditTable, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .addComponent(jLabelCloseDialogEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout jDialogEditTableLayout = new javax.swing.GroupLayout(jDialogEditTable.getContentPane());
        jDialogEditTable.getContentPane().setLayout(jDialogEditTableLayout);
        jDialogEditTableLayout.setHorizontalGroup(
            jDialogEditTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialogEditTableLayout.setVerticalGroup(
            jDialogEditTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogEditTableLayout.createSequentialGroup()
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

        jLabelAddTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_management_add_x32.png"))); // NOI18N
        jLabelAddTable.setText("Thêm bàn");
        jLabelAddTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAddTableMouseClicked(evt);
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
                .addGap(44, 44, 44)
                .addComponent(jLabelAddTable, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 8, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldFilterName, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelAddTable, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel2.setMaximumSize(new java.awt.Dimension(780, 455));
        jPanel2.setMinimumSize(new java.awt.Dimension(780, 455));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Mã bàn");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Tên bàn");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Ghi chú");

        javax.swing.GroupLayout jPanelTableHeaderLayout = new javax.swing.GroupLayout(jPanelTableHeader);
        jPanelTableHeader.setLayout(jPanelTableHeaderLayout);
        jPanelTableHeaderLayout.setHorizontalGroup(
            jPanelTableHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTableHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(83, 83, 83)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelTableHeaderLayout.setVerticalGroup(
            jPanelTableHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTableHeaderLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanelTableHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
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

    private void jLabelAddTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAddTableMouseClicked
        jDialogAddTable.setVisible(true);
    }//GEN-LAST:event_jLabelAddTableMouseClicked

    private void jLabelCloseDialogMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCloseDialogMouseClicked
        jDialogAddTable.setVisible(false);
    }//GEN-LAST:event_jLabelCloseDialogMouseClicked

    private void jLabelCloseDialogEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCloseDialogEditMouseClicked
        jDialogEditTable.setVisible(false);
    }//GEN-LAST:event_jLabelCloseDialogEditMouseClicked

    private void jLabelDoEditTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDoEditTableMouseClicked
        MTable mTable = new MTable();
        mTable.setId(new Integer(jLabelTableIdEdit.getText()));
        mTable.setName(jTextFieldTableNameEdit.getText());
        mTable.setNote(jTextAreaNoteEdit.getText());
        try {
            mTable.update();
            currentJPTRI.setTableName(jTextFieldTableNameEdit.getText());
            currentJPTRI.setNote(jTextAreaNoteEdit.getText());
            jDialogEditTable.setVisible(false);
            JOptionPane.showMessageDialog(this, "Sửa bàn thành công!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Có lỗi xảy ra, không thể sửa!");
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_jLabelDoEditTableMouseClicked

    private void jLabelDoAddTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDoAddTableMouseClicked
        MTable mTable = new MTable(jTextFieldTableName.getText(), jTextAreaNote.getText());
        try {
            mTable.insert();
            JOptionPane.showMessageDialog(this, "Thêm bàn thành công!");
            mTable = MTable.getLast();
            JPanelTableRowItem jpTRI = new JPanelTableRowItem(mTable.getId(), mTable.getName(), mTable.getNote(), (mTable.getId() % 2 != 0));
            HashMap newListJPTRI = (HashMap) listJPTRI.clone();
            listJPTRI.clear();
            listJPTRI.put(mTable.getId(), jpTRI);
            listJPTRI.putAll(newListJPTRI);
            listTable = VTable.getAllTable();
            filter();
            jDialogAddTable.setVisible(false);
            jTextFieldTableName.setText("");
            jTextAreaNote.setText("");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Có lỗi xảy ra, không thể thêm bàn!");
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_jLabelDoAddTableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog jDialogAddTable;
    private javax.swing.JDialog jDialogEditTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelAddTable;
    private javax.swing.JLabel jLabelCloseDialog;
    private javax.swing.JLabel jLabelCloseDialogEdit;
    private javax.swing.JLabel jLabelDoAddTable;
    private javax.swing.JLabel jLabelDoEditTable;
    private javax.swing.JLabel jLabelTableIdEdit;
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
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextAreaNote;
    private javax.swing.JTextArea jTextAreaNoteEdit;
    private javax.swing.JTextField jTextFieldFilterName;
    private javax.swing.JTextField jTextFieldTableName;
    private javax.swing.JTextField jTextFieldTableNameEdit;
    // End of variables declaration//GEN-END:variables
}
