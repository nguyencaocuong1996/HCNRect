
package restaurant.panel.booktable;

import core.CDateTime;
import datechooser.beans.DateChooserDialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Locale;
import javax.swing.JFrame;
import javax.swing.JPanel;
import restaurant.MainFrame;
import view.VBookTable;
import view.ViewItem;

public class JPanelBookTable extends javax.swing.JPanel {
    private VBookTable viewBookTable;
    private static JPanelBookTable instance;
    public JPanelBookTable() {
        initComponents();
        jLabelDateBookTable.setText(CDateTime.getInstance().date.toDMY());
        viewBookTable = VBookTable.getByDate(CDateTime.getInstance().date.toString(), 1, 15);
        showData();
    }
    public void customInit(){
        dateChooserDialogListBookTable.setLocale(Locale.FRENCH);
    }
    public final void showData(){
        jPanelListBookTableContent.removeAll();
        int a = 0;
        Iterator i = viewBookTable.getData().iterator();
        int count = 0;
        while(i.hasNext()){
            count ++;
            ViewItem t = (ViewItem) i.next();
            Long bookTableId = (Long) t.get("MaPDB");
            String customerName = (String) t.get("HoTenKH");
            String tableName = (String) t.get("TenBan");
            String phoneNumber = (String) t.get("SDTKH");
            Integer status = new Integer(t.get("TrangThai").toString());
            Timestamp dateTime = (Timestamp) t.get("NgayGioDatBan");
            String dateTimeString = dateTime.toString();
//            Date date = new Date(dateTime.getTime());
            jPanelListBookTableContent.add(new JPanelBookTableItem(bookTableId.intValue(), customerName, phoneNumber, dateTimeString, tableName, status, (count % 2 != 0)));
        }
        viewBookTable.getData().forEach((t) ->{
            
        });
        int num = viewBookTable.getData().size();
        int height = (num * 45);
        int width = jPanelListBookTableContent.getPreferredSize().width;
        jPanelListBookTableContent.setPreferredSize(new Dimension(width, height));
        jPanelListBookTableContent.revalidate();
        jPanelListBookTableContent.repaint();
    }

    public JPanel getjPanelListBookTableContent() {
        return jPanelListBookTableContent;
    }
    
    public static void main(String[] args) {
        System.out.println(CDateTime.getInstance().getDate().toDMY());
        JFrame jf = new JFrame();
        jf.setLayout(new FlowLayout());
        jf.setSize(new Dimension(814, 500));
        jf.add(JPanelBookTable.getInstance());
        jf.setVisible(true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooserDialogListBookTable = new datechooser.beans.DateChooserDialog();
        jPanelBookTableHeader = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabelShowChooserDate = new javax.swing.JLabel();
        jLabelDateBookTable = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanelBookTableContent = new javax.swing.JPanel();
        jPanelListBookTableHeader = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanelListBookTableContent = new javax.swing.JPanel();

        dateChooserDialogListBookTable.setCalendarPreferredSize(new java.awt.Dimension(400, 350));
        dateChooserDialogListBookTable.setLocale(new java.util.Locale("vi", "", ""));
        dateChooserDialogListBookTable.addSelectionChangedListener(new datechooser.events.SelectionChangedListener() {
            public void onSelectionChange(datechooser.events.SelectionChangedEvent evt) {
                dateChooserDialogListBookTableOnSelectionChange(evt);
            }
        });

        setMaximumSize(new java.awt.Dimension(800, 520));
        setMinimumSize(new java.awt.Dimension(800, 520));
        setPreferredSize(new java.awt.Dimension(800, 520));
        setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        jPanelBookTableHeader.setPreferredSize(new java.awt.Dimension(792, 40));

        jLabel7.setText("Ngày đặt");

        jLabelShowChooserDate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_calendar_blue_x24.png"))); // NOI18N
        jLabelShowChooserDate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelShowChooserDateMouseClicked(evt);
            }
        });

        jLabelDateBookTable.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelDateBookTable.setText("1/1/2017");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Tìm kiếm :");

        jPanel1.setBackground(new java.awt.Color(247, 222, 122));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));
        jPanel1.setForeground(new java.awt.Color(153, 255, 204));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout();
        flowLayout1.setAlignOnBaseline(true);
        jPanel1.setLayout(flowLayout1);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_add_folder_black_32px.png"))); // NOI18N
        jLabel10.setText("Đặt bàn");
        jLabel10.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel1.add(jLabel10);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanelBookTableHeaderLayout = new javax.swing.GroupLayout(jPanelBookTableHeader);
        jPanelBookTableHeader.setLayout(jPanelBookTableHeaderLayout);
        jPanelBookTableHeaderLayout.setHorizontalGroup(
            jPanelBookTableHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBookTableHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelDateBookTable, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelShowChooserDate, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jLabel6)
                .addGap(14, 14, 14)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(100, Short.MAX_VALUE))
        );
        jPanelBookTableHeaderLayout.setVerticalGroup(
            jPanelBookTableHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBookTableHeaderLayout.createSequentialGroup()
                .addGroup(jPanelBookTableHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDateBookTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelShowChooserDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelBookTableHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        add(jPanelBookTableHeader);

        jPanelListBookTableHeader.setBackground(new java.awt.Color(245, 245, 245));
        jPanelListBookTableHeader.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Tên khách hàng");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Số điện thoại");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Giờ đến");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Tên bàn");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Trạng thái");

        javax.swing.GroupLayout jPanelListBookTableHeaderLayout = new javax.swing.GroupLayout(jPanelListBookTableHeader);
        jPanelListBookTableHeader.setLayout(jPanelListBookTableHeaderLayout);
        jPanelListBookTableHeaderLayout.setHorizontalGroup(
            jPanelListBookTableHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelListBookTableHeaderLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(56, 56, 56)
                .addComponent(jLabel2)
                .addGap(53, 53, 53)
                .addComponent(jLabel3)
                .addGap(61, 61, 61)
                .addComponent(jLabel4)
                .addGap(65, 65, 65)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelListBookTableHeaderLayout.setVerticalGroup(
            jPanelListBookTableHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelListBookTableHeaderLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanelListBookTableHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jPanelListBookTableContent.setBackground(java.awt.Color.lightGray);
        jPanelListBookTableContent.setMinimumSize(new java.awt.Dimension(780, 323));
        jPanelListBookTableContent.setPreferredSize(new java.awt.Dimension(780, 323));
        jPanelListBookTableContent.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 3));
        jScrollPane1.setViewportView(jPanelListBookTableContent);

        javax.swing.GroupLayout jPanelBookTableContentLayout = new javax.swing.GroupLayout(jPanelBookTableContent);
        jPanelBookTableContent.setLayout(jPanelBookTableContentLayout);
        jPanelBookTableContentLayout.setHorizontalGroup(
            jPanelBookTableContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBookTableContentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBookTableContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 765, Short.MAX_VALUE)
                    .addComponent(jPanelListBookTableHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanelBookTableContentLayout.setVerticalGroup(
            jPanelBookTableContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBookTableContentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelListBookTableHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanelBookTableContent);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelShowDateChooserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelShowDateChooserMouseClicked
        
    }//GEN-LAST:event_jLabelShowDateChooserMouseClicked

    private void dateChooserDialogListBookTableOnSelectionChange(datechooser.events.SelectionChangedEvent evt) {//GEN-FIRST:event_dateChooserDialogListBookTableOnSelectionChange
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(dateChooserDialogListBookTable.getSelectedDate().getTime());
        viewBookTable = VBookTable.getByDate(date, 1, 15);
        showData();
    }//GEN-LAST:event_dateChooserDialogListBookTableOnSelectionChange

    private void jLabelShowChooserDateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelShowChooserDateMouseClicked
        dateChooserDialogListBookTable.showDialog(MainFrame.getInstance());
    }//GEN-LAST:event_jLabelShowChooserDateMouseClicked

    public DateChooserDialog getDateChooserDialog1() {
        return dateChooserDialogListBookTable;
    }

    public static JPanelBookTable getInstance() {
        if(instance == null) instance = new JPanelBookTable();
        return instance;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private datechooser.beans.DateChooserDialog dateChooserDialogListBookTable;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelDateBookTable;
    private javax.swing.JLabel jLabelShowChooserDate;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelBookTableContent;
    private javax.swing.JPanel jPanelBookTableHeader;
    private javax.swing.JPanel jPanelListBookTableContent;
    private javax.swing.JPanel jPanelListBookTableHeader;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
