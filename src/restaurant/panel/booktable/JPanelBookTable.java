
package restaurant.panel.booktable;

import datechooser.beans.DateChooserDialog;
import datechooser.model.multiple.MultyDateChooseModel;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import javax.swing.JFrame;
import restaurant.MainFrame;

public class JPanelBookTable extends javax.swing.JPanel {
    private static JPanelBookTable instance;
    public JPanelBookTable() {
        initComponents();
        jPanelListBookTable.add(new JPanelBookTableItem("Nguyễn Cao Cường", "01293921939", "11:30","Vip 2","Chưa nhận bàn"));
        jPanelListBookTable.add(new JPanelBookTableItem("Trần Khánh Nguyên", "01293921939", "5:30","Vip 3","Đã nhận bàn"));
    }
    public void customInit(){
        dateChooserDialogListBookTable.setLocale(Locale.FRENCH);
    }
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setLayout(new FlowLayout());
        jf.setSize(new Dimension(814, 500));
        jf.add(new JPanelBookTable());
        jf.setVisible(true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooserDialogListBookTable = new datechooser.beans.DateChooserDialog();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanelListBookTable = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabelShowDateChooser = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();

        dateChooserDialogListBookTable.setCurrentView(new datechooser.view.appearance.AppearancesList("Swing",
            new datechooser.view.appearance.ViewAppearance("custom",
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    true,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 255),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(128, 128, 128),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.LabelPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.LabelPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(255, 0, 0),
                    false,
                    false,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                (datechooser.view.BackRenderer)null,
                false,
                true)));
    dateChooserDialogListBookTable.setCalendarPreferredSize(new java.awt.Dimension(400, 350));
    dateChooserDialogListBookTable.setLocale(new java.util.Locale("vi", "", ""));
    dateChooserDialogListBookTable.setBehavior(datechooser.model.multiple.MultyModelBehavior.SELECT_SINGLE);
    dateChooserDialogListBookTable.addSelectionChangedListener(new datechooser.events.SelectionChangedListener() {
        public void onSelectionChange(datechooser.events.SelectionChangedEvent evt) {
            dateChooserDialogListBookTableOnSelectionChange(evt);
        }
    });

    jPanel2.setBackground(new java.awt.Color(245, 245, 245));
    jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));

    jLabel1.setFont(new java.awt.Font("Tahoma", 1, 19)); // NOI18N
    jLabel1.setText("Tên khách hàng");

    jLabel2.setFont(new java.awt.Font("Tahoma", 1, 19)); // NOI18N
    jLabel2.setText("Số điện thoại");

    jLabel3.setFont(new java.awt.Font("Tahoma", 1, 19)); // NOI18N
    jLabel3.setText("Giờ đến");

    jLabel4.setFont(new java.awt.Font("Tahoma", 1, 19)); // NOI18N
    jLabel4.setText("Số bàn");

    jLabel5.setFont(new java.awt.Font("Tahoma", 1, 19)); // NOI18N
    jLabel5.setText("Trạng thái");

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel2Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel1)
            .addGap(32, 32, 32)
            .addComponent(jLabel2)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel3)
            .addGap(53, 53, 53)
            .addComponent(jLabel4)
            .addGap(41, 41, 41)
            .addComponent(jLabel5)
            .addGap(100, 100, 100))
    );
    jPanel2Layout.setVerticalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel2Layout.createSequentialGroup()
            .addGap(10, 10, 10)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1)
                .addComponent(jLabel2)
                .addComponent(jLabel3)
                .addComponent(jLabel4)
                .addComponent(jLabel5))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    jPanelListBookTable.setBackground(java.awt.Color.lightGray);
    jPanelListBookTable.setMinimumSize(new java.awt.Dimension(780, 323));
    jPanelListBookTable.setPreferredSize(new java.awt.Dimension(780, 323));
    jScrollPane1.setViewportView(jPanelListBookTable);

    jLabel6.setText("Tìm kiếm :");

    jLabel7.setText("Ngày đặt");

    jLabel8.setText("1/1/2017");

    jLabelShowDateChooser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_calendar_blue_x24.png"))); // NOI18N
    jLabelShowDateChooser.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jLabelShowDateChooserMouseClicked(evt);
        }
    });

    jPanel1.setBackground(new java.awt.Color(153, 255, 204));
    jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));
    jPanel1.setForeground(new java.awt.Color(153, 255, 204));

    jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_add_folder_black_32px.png"))); // NOI18N
    jLabel10.setText("Đặt bàn");
    jPanel1.add(jLabel10);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createSequentialGroup()
                    .addGap(17, 17, 17)
                    .addComponent(jLabel6)
                    .addGap(7, 7, 7)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(98, 98, 98)
                    .addComponent(jLabel7)
                    .addGap(14, 14, 14)
                    .addComponent(jLabel8)
                    .addGap(6, 6, 6)
                    .addComponent(jLabelShowDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(40, 40, 40)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addContainerGap())
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGap(20, 20, 20)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(15, 15, 15)
                    .addComponent(jLabel6))
                .addGroup(layout.createSequentialGroup()
                    .addGap(12, 12, 12)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabelShowDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(30, 30, 30)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
    );
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelShowDateChooserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelShowDateChooserMouseClicked
        dateChooserDialogListBookTable.showDialog(MainFrame.getInstance());
    }//GEN-LAST:event_jLabelShowDateChooserMouseClicked

    private void dateChooserDialogListBookTableOnSelectionChange(datechooser.events.SelectionChangedEvent evt) {//GEN-FIRST:event_dateChooserDialogListBookTableOnSelectionChange
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(dateChooserDialogListBookTable.getSelectedDate().getTime());
//        Calendar d = dateChooserDialogListBookTable.getS();
//        java.util.Date date = d.getTime();
//        String strDate = DateFormat.getDateInstance().format(date);
        System.out.println(date);
    }//GEN-LAST:event_dateChooserDialogListBookTableOnSelectionChange

    public DateChooserDialog getDateChooserDialog1() {
        return dateChooserDialogListBookTable;
    }

    public static JPanelBookTable getInstance() {
        if(instance == null) instance = new JPanelBookTable();
        return instance;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private datechooser.beans.DateChooserDialog dateChooserDialogListBookTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelShowDateChooser;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelListBookTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
