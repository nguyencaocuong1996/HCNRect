/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.panel.report;

import core.CDateTime;
import java.awt.Component;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.ButtonModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import restaurant.MainFrame;
import restaurant.report.ReportResources;

/**
 *
 * @author User
 */
public class JPanelReportDetails extends javax.swing.JPanel {
    public static final int RP_MONTH = 11;
    public static final int RP_YEAR = 12;
    public static final int CUS_MOST_PAYMENT = 21;
    public static final int CUS_USUALLY = 22;
    private String dateSql;
    private String date;
    private String dateSqlTo;
    private String dateTo;
    private int about;
    private int type;
    public JPanelReportDetails() {
        initComponents();
        customInit();
    }
    public final void customInit(){
        date = CDateTime.getInstance().getDate().toDMY();
        dateSql = CDateTime.getInstance().getDate().toString();
        jLabelPickDate.setText(date);
        jRadioButtonRP.setSelected(true);
        //Add Action command JRadioButton ChooseType
        jRadioButtonReceive.setActionCommand("receive");
        jRadioButtonPayment.setActionCommand("payment");
        jRadioButtonByMoth.setActionCommand("month");
        jRadioButtonByYear.setActionCommand("year");
        jRadioButtonByDateRange.setActionCommand("range");
        //end ADD Action command
        //ADD JRadioButton to buttonGroup
        ArrayList<JRadioButton> listJRBChooseAbout = new ArrayList<>();
        for(Component c : jPanelBtnChooseAbout.getComponents()){
            if(c instanceof JRadioButton){
                listJRBChooseAbout.add((JRadioButton) c);
            }
        }
        
        listJRBChooseAbout.forEach((t) -> {
            buttonGroupReportAbout.add(t);
        });
        
        ArrayList<JRadioButton> listJRBChooseType = new ArrayList<>();
        for(Component jp : jPanelChooseTypeContent.getComponents()){
            if(jp instanceof JPanel){
                for(Component jRB : ((JPanel) jp).getComponents()){
                    if(jRB instanceof JRadioButton){
                        listJRBChooseType.add((JRadioButton) jRB);
                    }
                }
            }
        }
        listJRBChooseType.forEach((t) -> {
            buttonGroupReportType.add(t);
        });
        buttonGroupReportDate.add(jRadioButtonByMoth);
        buttonGroupReportDate.add(jRadioButtonByYear);
        buttonGroupReportDate.add(jRadioButtonByDateRange);
        //END ADD JRadioButton to buttonGroup
        jPanelChooseTypeContent.removeAll();
        jPanelChooseTypeContent.add(jPanelTypeRP);
    }
    public static final String getReportUrl(String type, String dateType){
        String url = "";
        switch(type){
            case "receive":
                switch(dateType){
                    case "month":
                        url = ReportResources.RECEIVE_MOTH;
                        break;
                    case "year":
                        url = ReportResources.RECEIVE_YEAR;
                        break;
                    case "range":
                        url = ReportResources.RECEIVE_RANGE;
                        break;
                }
                break;
            case "payment": 
                switch(dateType){
                    case "moth":
                        
                        break;
                    case "year":
                        
                        break;
                    case "range":
                        
                        break;
                }
                break;
        }
        return url;
    }
    public static final HashMap<String, Object> getReportParams(){
        return new HashMap<>();
    }
    public static void main(String[] args) {
        JFrame jf = new JFrame("hoho");
        jf.setSize(new Dimension(785,600));
        jf.add(new JPanelReportDetails());
        jf.setVisible(true);
    }
    public void changeTypeContent(JPanel type){
        jPanelChooseTypeContent.removeAll();
        jPanelChooseTypeContent.add(type);
        jPanelChooseTypeContent.revalidate();
        jPanelChooseTypeContent.repaint();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooserDialogReport = new datechooser.beans.DateChooserDialog();
        buttonGroupReportAbout = new javax.swing.ButtonGroup();
        buttonGroupReportType = new javax.swing.ButtonGroup();
        buttonGroupReportDate = new javax.swing.ButtonGroup();
        dateChooserDialogTo = new datechooser.beans.DateChooserDialog();
        jPanel8 = new javax.swing.JPanel();
        jPanelChooseAbout = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanelBtnChooseAbout = new javax.swing.JPanel();
        jRadioButtonRP = new javax.swing.JRadioButton();
        jRadioButtonDish = new javax.swing.JRadioButton();
        jRadioButtonStock = new javax.swing.JRadioButton();
        jRadioButtonStaff = new javax.swing.JRadioButton();
        jRadioButtonCustomer = new javax.swing.JRadioButton();
        jRadioButtonLiabilities = new javax.swing.JRadioButton();
        jPanelChooseType = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanelChooseTypeContent = new javax.swing.JPanel();
        jPanelTypeStaff = new javax.swing.JPanel();
        jPanelTypeLiabilities = new javax.swing.JPanel();
        jPanelTypeRP = new javax.swing.JPanel();
        jRadioButtonReceive = new javax.swing.JRadioButton();
        jRadioButtonPayment = new javax.swing.JRadioButton();
        jPanelTypeCustomer = new javax.swing.JPanel();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jPanelTypeDish = new javax.swing.JPanel();
        jPanelChooseDate = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabelPickDate = new javax.swing.JLabel();
        jRadioButtonByMoth = new javax.swing.JRadioButton();
        jRadioButtonByYear = new javax.swing.JRadioButton();
        jRadioButtonByDateRange = new javax.swing.JRadioButton();
        jLabelPickDateTo = new javax.swing.JLabel();
        jPanelOpenReport = new javax.swing.JPanel();
        jLabelOpenReport = new javax.swing.JLabel();

        dateChooserDialogReport.setCalendarPreferredSize(new java.awt.Dimension(450, 400));
        dateChooserDialogReport.addCommitListener(new datechooser.events.CommitListener() {
            public void onCommit(datechooser.events.CommitEvent evt) {
                dateChooserDialogReportOnCommit(evt);
            }
        });

        dateChooserDialogTo.setCalendarPreferredSize(new java.awt.Dimension(450, 400));
        dateChooserDialogTo.addCommitListener(new datechooser.events.CommitListener() {
            public void onCommit(datechooser.events.CommitEvent evt) {
                dateChooserDialogToOnCommit(evt);
            }
        });

        setMaximumSize(new java.awt.Dimension(780, 531));
        setMinimumSize(new java.awt.Dimension(780, 531));

        jPanel1.setBackground(new java.awt.Color(56, 184, 230));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Báo cáo về");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(333, 333, 333)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jRadioButtonRP.setText("Thu chi");
        jRadioButtonRP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jRadioButtonRPMousePressed(evt);
            }
        });

        jRadioButtonDish.setText("Món ăn");
        jRadioButtonDish.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jRadioButtonDishMouseReleased(evt);
            }
        });

        jRadioButtonStock.setText("Kho");

        jRadioButtonStaff.setText("Nhân viên");

        jRadioButtonCustomer.setText("Khách hàng");
        jRadioButtonCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jRadioButtonCustomerMouseReleased(evt);
            }
        });

        jRadioButtonLiabilities.setText("Công nợ");

        javax.swing.GroupLayout jPanelBtnChooseAboutLayout = new javax.swing.GroupLayout(jPanelBtnChooseAbout);
        jPanelBtnChooseAbout.setLayout(jPanelBtnChooseAboutLayout);
        jPanelBtnChooseAboutLayout.setHorizontalGroup(
            jPanelBtnChooseAboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBtnChooseAboutLayout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(jRadioButtonRP)
                .addGap(58, 58, 58)
                .addComponent(jRadioButtonCustomer)
                .addGap(29, 29, 29)
                .addComponent(jRadioButtonLiabilities)
                .addGap(35, 35, 35)
                .addComponent(jRadioButtonDish)
                .addGap(34, 34, 34)
                .addComponent(jRadioButtonStock)
                .addGap(39, 39, 39)
                .addComponent(jRadioButtonStaff)
                .addGap(0, 118, Short.MAX_VALUE))
        );
        jPanelBtnChooseAboutLayout.setVerticalGroup(
            jPanelBtnChooseAboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBtnChooseAboutLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBtnChooseAboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonRP)
                    .addComponent(jRadioButtonDish)
                    .addComponent(jRadioButtonStock)
                    .addComponent(jRadioButtonStaff)
                    .addComponent(jRadioButtonCustomer)
                    .addComponent(jRadioButtonLiabilities))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelChooseAboutLayout = new javax.swing.GroupLayout(jPanelChooseAbout);
        jPanelChooseAbout.setLayout(jPanelChooseAboutLayout);
        jPanelChooseAboutLayout.setHorizontalGroup(
            jPanelChooseAboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelChooseAboutLayout.createSequentialGroup()
                .addComponent(jPanelBtnChooseAbout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelChooseAboutLayout.setVerticalGroup(
            jPanelChooseAboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelChooseAboutLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jPanelBtnChooseAbout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanelChooseType.setMaximumSize(new java.awt.Dimension(800, 220));
        jPanelChooseType.setMinimumSize(new java.awt.Dimension(800, 220));
        jPanelChooseType.setPreferredSize(new java.awt.Dimension(800, 220));

        jPanel6.setBackground(new java.awt.Color(56, 184, 230));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Loại báo cáo");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(340, 340, 340)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        jPanelChooseTypeContent.setLayout(new javax.swing.OverlayLayout(jPanelChooseTypeContent));

        javax.swing.GroupLayout jPanelTypeStaffLayout = new javax.swing.GroupLayout(jPanelTypeStaff);
        jPanelTypeStaff.setLayout(jPanelTypeStaffLayout);
        jPanelTypeStaffLayout.setHorizontalGroup(
            jPanelTypeStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        jPanelTypeStaffLayout.setVerticalGroup(
            jPanelTypeStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        jPanelChooseTypeContent.add(jPanelTypeStaff);

        javax.swing.GroupLayout jPanelTypeLiabilitiesLayout = new javax.swing.GroupLayout(jPanelTypeLiabilities);
        jPanelTypeLiabilities.setLayout(jPanelTypeLiabilitiesLayout);
        jPanelTypeLiabilitiesLayout.setHorizontalGroup(
            jPanelTypeLiabilitiesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        jPanelTypeLiabilitiesLayout.setVerticalGroup(
            jPanelTypeLiabilitiesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        jPanelChooseTypeContent.add(jPanelTypeLiabilities);

        jRadioButtonReceive.setText("Thu");

        jRadioButtonPayment.setText("Chi");

        javax.swing.GroupLayout jPanelTypeRPLayout = new javax.swing.GroupLayout(jPanelTypeRP);
        jPanelTypeRP.setLayout(jPanelTypeRPLayout);
        jPanelTypeRPLayout.setHorizontalGroup(
            jPanelTypeRPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTypeRPLayout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addComponent(jRadioButtonReceive)
                .addGap(49, 49, 49)
                .addComponent(jRadioButtonPayment)
                .addContainerGap(367, Short.MAX_VALUE))
        );
        jPanelTypeRPLayout.setVerticalGroup(
            jPanelTypeRPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTypeRPLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanelTypeRPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonReceive)
                    .addComponent(jRadioButtonPayment))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanelChooseTypeContent.add(jPanelTypeRP);

        jRadioButton4.setText("Khách hàng chi tiêu nhiều nhất");

        jRadioButton5.setText("Khách hàng thường xuyên");

        javax.swing.GroupLayout jPanelTypeCustomerLayout = new javax.swing.GroupLayout(jPanelTypeCustomer);
        jPanelTypeCustomer.setLayout(jPanelTypeCustomerLayout);
        jPanelTypeCustomerLayout.setHorizontalGroup(
            jPanelTypeCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTypeCustomerLayout.createSequentialGroup()
                .addGap(177, 177, 177)
                .addComponent(jRadioButton4)
                .addGap(82, 82, 82)
                .addComponent(jRadioButton5)
                .addContainerGap(215, Short.MAX_VALUE))
        );
        jPanelTypeCustomerLayout.setVerticalGroup(
            jPanelTypeCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTypeCustomerLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanelTypeCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton4)
                    .addComponent(jRadioButton5))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPanelChooseTypeContent.add(jPanelTypeCustomer);

        javax.swing.GroupLayout jPanelTypeDishLayout = new javax.swing.GroupLayout(jPanelTypeDish);
        jPanelTypeDish.setLayout(jPanelTypeDishLayout);
        jPanelTypeDishLayout.setHorizontalGroup(
            jPanelTypeDishLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        jPanelTypeDishLayout.setVerticalGroup(
            jPanelTypeDishLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        jPanelChooseTypeContent.add(jPanelTypeDish);

        javax.swing.GroupLayout jPanelChooseTypeLayout = new javax.swing.GroupLayout(jPanelChooseType);
        jPanelChooseType.setLayout(jPanelChooseTypeLayout);
        jPanelChooseTypeLayout.setHorizontalGroup(
            jPanelChooseTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelChooseTypeContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelChooseTypeLayout.setVerticalGroup(
            jPanelChooseTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelChooseTypeLayout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelChooseTypeContent, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(118, 118, 118))
        );

        jPanel3.setBackground(new java.awt.Color(56, 184, 230));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Chọn thời gian");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(314, 314, 314)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        jLabelPickDate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelPickDate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_calendar_blue_x24.png"))); // NOI18N
        jLabelPickDate.setText("29/6/2017");
        jLabelPickDate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelPickDateMouseClicked(evt);
            }
        });

        jRadioButtonByMoth.setText("Theo tháng");

        jRadioButtonByYear.setText("Theo năm");

        jRadioButtonByDateRange.setText("Khoảng thời gian xác định");
        jRadioButtonByDateRange.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButtonByDateRangeStateChanged(evt);
            }
        });
        jRadioButtonByDateRange.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jRadioButtonByDateRangeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jRadioButtonByDateRangeFocusLost(evt);
            }
        });

        jLabelPickDateTo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelPickDateTo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_calendar_blue_x24.png"))); // NOI18N
        jLabelPickDateTo.setText("29/6/2017");
        jLabelPickDateTo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelPickDateToMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(211, 211, 211)
                        .addComponent(jRadioButtonByMoth)
                        .addGap(49, 49, 49)
                        .addComponent(jRadioButtonByYear)
                        .addGap(33, 33, 33)
                        .addComponent(jRadioButtonByDateRange))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(331, 331, 331)
                        .addComponent(jLabelPickDate, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelPickDateTo, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(204, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonByMoth)
                    .addComponent(jRadioButtonByYear)
                    .addComponent(jRadioButtonByDateRange))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPickDate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPickDateTo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jLabelPickDateTo.setVisible(false);

        javax.swing.GroupLayout jPanelChooseDateLayout = new javax.swing.GroupLayout(jPanelChooseDate);
        jPanelChooseDate.setLayout(jPanelChooseDateLayout);
        jPanelChooseDateLayout.setHorizontalGroup(
            jPanelChooseDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelChooseDateLayout.setVerticalGroup(
            jPanelChooseDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelChooseDateLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelChooseAbout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelChooseType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelChooseDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jPanelChooseAbout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanelChooseType, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelChooseDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanelOpenReport.setBackground(new java.awt.Color(230, 126, 34));
        jPanelOpenReport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelOpenReportMouseClicked(evt);
            }
        });

        jLabelOpenReport.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabelOpenReport.setForeground(new java.awt.Color(255, 255, 255));
        jLabelOpenReport.setText("Mở báo cáo");
        jLabelOpenReport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelOpenReportMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelOpenReportLayout = new javax.swing.GroupLayout(jPanelOpenReport);
        jPanelOpenReport.setLayout(jPanelOpenReportLayout);
        jPanelOpenReportLayout.setHorizontalGroup(
            jPanelOpenReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOpenReportLayout.createSequentialGroup()
                .addGap(327, 327, 327)
                .addComponent(jLabelOpenReport, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelOpenReportLayout.setVerticalGroup(
            jPanelOpenReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelOpenReport, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelOpenReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelOpenReport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(91, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jPanelOpenReportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelOpenReportMouseClicked

    }//GEN-LAST:event_jPanelOpenReportMouseClicked

    private void jLabelPickDateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelPickDateMouseClicked
        dateChooserDialogReport.showDialog(MainFrame.getInstance());
    }//GEN-LAST:event_jLabelPickDateMouseClicked

    private void dateChooserDialogReportOnCommit(datechooser.events.CommitEvent evt) {//GEN-FIRST:event_dateChooserDialogReportOnCommit
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdfSql = new SimpleDateFormat("yyyy-MM-dd");
        this.date = sdf.format(dateChooserDialogReport.getSelectedDate().getTime());
        this.dateSql = sdfSql.format(dateChooserDialogReport.getSelectedDate().getTime());
        jLabelPickDate.setText(date);
    }//GEN-LAST:event_dateChooserDialogReportOnCommit

    private void jRadioButtonRPMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonRPMousePressed
        changeTypeContent(jPanelTypeRP);
    }//GEN-LAST:event_jRadioButtonRPMousePressed

    private void jRadioButtonDishMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonDishMouseReleased
        this.type = JPanelReportDetails.CUS_MOST_PAYMENT;
    }//GEN-LAST:event_jRadioButtonDishMouseReleased

    private void jRadioButtonCustomerMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonCustomerMouseReleased
        changeTypeContent(jPanelTypeCustomer);
        System.out.println("do it");
    }//GEN-LAST:event_jRadioButtonCustomerMouseReleased

    private void jLabelOpenReportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelOpenReportMouseClicked
        HashMap<String, Object> params = new HashMap<>();
        params.put("sqlDate", this.dateSql);
        params.put("viDate", date);
        try {
            String rpType = buttonGroupReportType.getSelection().getActionCommand();
            String dateType = buttonGroupReportDate.getSelection().getActionCommand();
            if("range".equals(dateType)){
                params.put("sqlDateTo", this.dateSqlTo);
                params.put("viDateTo", this.dateTo);
            }
            String rpUrl = getReportUrl(rpType, dateType);
            try {
                JasperReport jR = JasperCompileManager.compileReport(rpUrl);
                JasperPrint jP = JasperFillManager.fillReport(jR, params, database.Database.getConnection());
                JasperViewer.viewReport(jP,false);
            } catch (JRException e) {
                JOptionPane.showMessageDialog(this, "Có lỗi xảy ra! không thể tạo report.");
                e.printStackTrace();
            }
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Chưa chọn đầy đủ thông tin để hiển thị báo cáo!");
        }
        
    }//GEN-LAST:event_jLabelOpenReportMouseClicked

    private void jLabelPickDateToMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelPickDateToMouseClicked
        dateChooserDialogTo.showDialog(MainFrame.getInstance());
    }//GEN-LAST:event_jLabelPickDateToMouseClicked

    private void jRadioButtonByDateRangeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButtonByDateRangeStateChanged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jRadioButtonByDateRangeStateChanged

    private void jRadioButtonByDateRangeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jRadioButtonByDateRangeFocusGained
        // TODO add your handling code here:
        jLabelPickDateTo.setVisible(true);
    }//GEN-LAST:event_jRadioButtonByDateRangeFocusGained

    private void jRadioButtonByDateRangeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jRadioButtonByDateRangeFocusLost

    }//GEN-LAST:event_jRadioButtonByDateRangeFocusLost

    private void dateChooserDialogToOnCommit(datechooser.events.CommitEvent evt) {//GEN-FIRST:event_dateChooserDialogToOnCommit
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdfSql = new SimpleDateFormat("yyyy-MM-dd");
        this.dateTo = sdf.format(dateChooserDialogTo.getSelectedDate().getTime());
        this.dateSqlTo = sdfSql.format(dateChooserDialogTo.getSelectedDate().getTime());
        jLabelPickDateTo.setText(date);
    }//GEN-LAST:event_dateChooserDialogToOnCommit


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupReportAbout;
    private javax.swing.ButtonGroup buttonGroupReportDate;
    private javax.swing.ButtonGroup buttonGroupReportType;
    private datechooser.beans.DateChooserDialog dateChooserDialogReport;
    private datechooser.beans.DateChooserDialog dateChooserDialogTo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelOpenReport;
    private javax.swing.JLabel jLabelPickDate;
    private javax.swing.JLabel jLabelPickDateTo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanelBtnChooseAbout;
    private javax.swing.JPanel jPanelChooseAbout;
    private javax.swing.JPanel jPanelChooseDate;
    private javax.swing.JPanel jPanelChooseType;
    private javax.swing.JPanel jPanelChooseTypeContent;
    private javax.swing.JPanel jPanelOpenReport;
    private javax.swing.JPanel jPanelTypeCustomer;
    private javax.swing.JPanel jPanelTypeDish;
    private javax.swing.JPanel jPanelTypeLiabilities;
    private javax.swing.JPanel jPanelTypeRP;
    private javax.swing.JPanel jPanelTypeStaff;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButtonByDateRange;
    private javax.swing.JRadioButton jRadioButtonByMoth;
    private javax.swing.JRadioButton jRadioButtonByYear;
    private javax.swing.JRadioButton jRadioButtonCustomer;
    private javax.swing.JRadioButton jRadioButtonDish;
    private javax.swing.JRadioButton jRadioButtonLiabilities;
    private javax.swing.JRadioButton jRadioButtonPayment;
    private javax.swing.JRadioButton jRadioButtonRP;
    private javax.swing.JRadioButton jRadioButtonReceive;
    private javax.swing.JRadioButton jRadioButtonStaff;
    private javax.swing.JRadioButton jRadioButtonStock;
    // End of variables declaration//GEN-END:variables
}
