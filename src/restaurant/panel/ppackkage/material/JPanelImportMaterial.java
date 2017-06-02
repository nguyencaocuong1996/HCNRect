/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.panel.ppackkage.material;

import assets.font.CFont;
import core.CDateTime;
import core.CString;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import modal.MReceiptNote;
import modal.MReceiptNoteDetail;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import restaurant.panel.provider.JPanelChooseProvider;
import restaurant.report.ReportResources;
import view.VMaterial;

/**
 *
 * @author WINDNCC
 */
public class JPanelImportMaterial extends javax.swing.JPanel {

    private static JPanelImportMaterial instance;
    protected int providerId;
    protected String providerName;
    protected VMaterial vMaterial;
    protected HashMap<Integer, JPanelImportMaterialItem> listMaterial = new HashMap<>();
    protected HashMap<Integer, JPanelImportDetailMaterialItem> listImportingMaterial = new HashMap<>();
    protected float totalPriceImport;
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
        int height = vMaterial.getFilterData().size() * 51;
        jPanelListImportMaterial.setPreferredSize(new Dimension(440, height));
        vMaterial.getFilterData().forEach((t) -> {
            int id = ((Long) t.get("MaNL")).intValue();
            jPanelListImportMaterial.add(listMaterial.get(id));
        });
        jPanelListImportMaterial.revalidate();
        jPanelListImportMaterial.repaint();
    }
    public void filter(String name, boolean showLowInStock){
        vMaterial.filter(name, showLowInStock);
        showData();
        
    }

    public HashMap<Integer, JPanelImportDetailMaterialItem> getListImportingMaterial() {
        return listImportingMaterial;
    }

    public JLabel getjLabelTotalPriceImport() {
        return jLabelTotalPriceImport;
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
        jCheckBoxShowLowInStock = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanelListImportMaterial = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabelDoAddReceiptNote = new javax.swing.JLabel();
        jLabelTotalPriceImport = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldPayAmout = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabelDoubt = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanelListImportingMaterial = new javax.swing.JPanel();

        jDialogChooseProvider.setTitle("Chọn  nhà cung cấp");
        jDialogChooseProvider.setMinimumSize(new java.awt.Dimension(420, 340));
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

        jCheckBoxShowLowInStock.setBackground(new java.awt.Color(204, 204, 204));
        jCheckBoxShowLowInStock.setText("Dưới mức tối thiểu");
        jCheckBoxShowLowInStock.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBoxShowLowInStockItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldFilterMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jCheckBoxShowLowInStock)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldFilterMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jCheckBoxShowLowInStock))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setOpaque(false);

        jPanelListImportMaterial.setMaximumSize(new java.awt.Dimension(440, 445));
        jPanelListImportMaterial.setMinimumSize(new java.awt.Dimension(440, 445));
        jPanelListImportMaterial.setPreferredSize(new java.awt.Dimension(440, 445));
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

        jLabelDoAddReceiptNote.setBackground(new java.awt.Color(147, 193, 120));
        jLabelDoAddReceiptNote.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDoAddReceiptNote.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDoAddReceiptNote.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDoAddReceiptNote.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_payment2_white_x32.png"))); // NOI18N
        jLabelDoAddReceiptNote.setText("Lập phiếu nhập hàng");
        CFont.setStyleFont(jLabelDoAddReceiptNote, 18, Color.WHITE);
        jLabelDoAddReceiptNote.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelDoAddReceiptNoteMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabelDoAddReceiptNote, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelDoAddReceiptNote, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jLabelTotalPriceImport.setForeground(new java.awt.Color(255, 51, 51));
        jLabelTotalPriceImport.setText("0");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Tổng giá trị: ");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Số tiền đã trả: ");

        jTextFieldPayAmout.setForeground(new java.awt.Color(0, 102, 0));
        jTextFieldPayAmout.setText("0");
        jTextFieldPayAmout.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldPayAmoutKeyReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Số tiền còn nợ: ");

        jLabelDoubt.setForeground(new java.awt.Color(204, 102, 0));
        jLabelDoubt.setText("0");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelTotalPriceImport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldPayAmout, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                    .addComponent(jLabelDoubt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(14, 14, 14))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelTotalPriceImport, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldPayAmout, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelDoubt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(jPanel2);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelProviderNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelProviderNameMouseClicked
        if (!jDialogChooseProvider.isAncestorOf(JPanelChooseProviderForImportMaterial.getInstance())) {
            jDialogChooseProvider.add(JPanelChooseProviderForImportMaterial.getInstance());
        }
        
        jDialogChooseProvider.setVisible(true);
    }//GEN-LAST:event_jLabelProviderNameMouseClicked

    private void jTextFieldFilterMaterialKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldFilterMaterialKeyReleased
        String name = jTextFieldFilterMaterial.getText();
        filter(name, jCheckBoxShowLowInStock.isSelected());
    }//GEN-LAST:event_jTextFieldFilterMaterialKeyReleased

    private void jTextFieldPayAmoutKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPayAmoutKeyReleased
        setJLabelTotalPriceImport();
    }//GEN-LAST:event_jTextFieldPayAmoutKeyReleased

    private void jLabelDoAddReceiptNoteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDoAddReceiptNoteMouseClicked
        if (getProviderId() == 0) {
            JOptionPane.showMessageDialog(this, "Chưa chọn nhà cung cấp!");
            return;
        }
        if(listImportingMaterial.isEmpty()){
            JOptionPane.showMessageDialog(this, "Chưa chọn mặt hàng nhập nào!");
            return;
        }
        int check = JOptionPane.showConfirmDialog(this, "Hãy kiểm tra lại thông tin trước khi lập phiếu!");
        if (check == JOptionPane.YES_OPTION) {
            String date = CDateTime.getInstance().getDate().toString();
            MReceiptNote mReceiptNote = new MReceiptNote(this.getProviderId(), date, getTotalPriceImport(), new Float(jTextFieldPayAmout.getText()));
            try {
                mReceiptNote.insert();
                mReceiptNote = MReceiptNote.getLastReceiptNote();
                for (Map.Entry<Integer, JPanelImportDetailMaterialItem> entry : listImportingMaterial.entrySet()) {
                    Integer key = entry.getKey();
                    JPanelImportDetailMaterialItem value = entry.getValue();
                    MReceiptNoteDetail mRND = new MReceiptNoteDetail(mReceiptNote.getId(), value.getMaterialId(), value.getQuantity(), value.getPrice());
                    mRND.insert();
                }
                Map<String, Object> params = new HashMap<>();
                params.put("receiptNoteId", mReceiptNote.getId());
                params.put("providerName", getProviderName());
                params.put("staffName", "Nguyễn Cao Cường");
                params.put("totalMoney", new Float(jLabelTotalPriceImport.getText()));
                params.put("payAmount", new Float(jTextFieldPayAmout.getText()));
                ReportResources.showReport(ReportResources.RECEIPT_NOTE, params);
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Có lỗi xảy ra vui lòng thử lại!");
            } catch (JRException ex) {
                Logger.getLogger(JPanelImportMaterial.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jLabelDoAddReceiptNoteMouseClicked

    private void jCheckBoxShowLowInStockItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBoxShowLowInStockItemStateChanged
        String name = jTextFieldFilterMaterial.getText();
        filter(name, jCheckBoxShowLowInStock.isSelected());
    }//GEN-LAST:event_jCheckBoxShowLowInStockItemStateChanged
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setSize(new Dimension(1024,720));
        jf.add(JPanelImportMaterial.getInstance());
        jf.setVisible(true);
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getProviderName() {
        return providerName;
    }

    public int getProviderId() {
        return providerId;
    }

    public void setProviderId(int providerId) {
        this.providerId = providerId;
    }

    public float getTotalPriceImport() {
        totalPriceImport = 0;
        listImportingMaterial.forEach((k, v) -> {
            totalPriceImport += v.getTotalPrice();
            
        });
        return totalPriceImport;
    }
    public void setJLabelTotalPriceImport(){
        if(jTextFieldPayAmout.getText().isEmpty()) return;
        jLabelTotalPriceImport.setText(CString.floatToString(getTotalPriceImport()));
        try {
            jLabelDoubt.setText(CString.floatToString(getTotalPriceImport() - new Float(jTextFieldPayAmout.getText())));
        } catch (NumberFormatException e) {
            jTextFieldPayAmout.setText("0");
            JOptionPane.showMessageDialog(this, "Chỉ được phép nhập số!");
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jCheckBoxShowLowInStock;
    private javax.swing.JDialog jDialogChooseProvider;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelDoAddReceiptNote;
    private javax.swing.JLabel jLabelDoubt;
    private javax.swing.JLabel jLabelProviderName;
    private javax.swing.JLabel jLabelTotalPriceImport;
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
    private javax.swing.JTextField jTextFieldPayAmout;
    // End of variables declaration//GEN-END:variables
}
