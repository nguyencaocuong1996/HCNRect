
package restaurant.panel.booktable;

import core.CDateTime;
import datechooser.beans.DateChooserDialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import javax.swing.JFrame;
import javax.swing.JPanel;
import restaurant.MainFrame;
import view.VBookTable;
import view.ViewItem;
import assets.font.CFont;
import core.RadiusBorder;
import java.awt.Color;
import java.awt.Component;
import java.sql.SQLException;
import java.util.Calendar;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import modal.MBookTable;
import modal.MCustomer;
public class JPanelBookTable extends javax.swing.JPanel {
    private VBookTable viewBookTable;
    private static JPanelBookTable instance;
    private MBookTable mBookTable;
    public JPanelBookTable() {
        initComponents();
        customInit();
        jLabelDateBookTable.setText(CDateTime.getInstance().date.toDMY());
        jLabelAddDateBookTable.setText(CDateTime.getInstance().date.toDMY());
        viewBookTable = VBookTable.getByDate(CDateTime.getInstance().date.toString(), 1, 15);
        mBookTable = new MBookTable();
        showData();
    }
    public final void customInit(){
        
        jDialogPickTable.setLocationRelativeTo(jDialogAddBookTable);
//        jDialogAddBookTable.setLocation(WIDTH, WIDTH);
        
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
            java.sql.Time time = (java.sql.Time) t.get("GioDen");
            String dateTimeString = time.toLocalTime().plusHours(1).toString();
            jPanelListBookTableContent.add(new JPanelBookTableItem(bookTableId.intValue(), customerName, phoneNumber, dateTimeString, tableName, status, (count % 2 != 0)));
        }
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

    public MBookTable getmBookTable() {
        return mBookTable;
    }

    public void setmBookTable(MBookTable mBookTable) {
        this.mBookTable = mBookTable;
    }

    public JDialog getjDialogPickTable() {
        return jDialogPickTable;
    }

    public JDialog getjDialogAddBookTable() {
        return jDialogAddBookTable;
    }

    public JLabel getjLabelPickTable() {
        return jLabelPickTable;
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
        jDialogAddBookTable = new javax.swing.JDialog();
        jPanelDialogHeader = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabelAddBookTable = new javax.swing.JLabel();
        jLabelPickTable = new javax.swing.JLabel();
        jPanelDialogContent = new javax.swing.JPanel();
        jTextFieldCustomerPhone = new javax.swing.JTextField();
        jLabelCustomerPhone = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jSpinnerTimePicker = new javax.swing.JSpinner();
        jLabelAddDateBookTable = new javax.swing.JLabel();
        jTextFieldCustomerName = new javax.swing.JTextField();
        jLabelCustomerName = new javax.swing.JLabel();
        jLabelCustomerMessage = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaCustomerMessage = new javax.swing.JTextArea();
        jLabelDateTimeBook = new javax.swing.JLabel();
        jLabelDoAddBookTable = new javax.swing.JLabel();
        jLabelCloseAddBookTable = new javax.swing.JLabel();
        dateChooserDialogAddBookTable = new datechooser.beans.DateChooserDialog();
        jDialogPickTable = new javax.swing.JDialog();
        jPanelBookTableHeader = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabelShowChooserDate = new javax.swing.JLabel();
        jLabelDateBookTable = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanelShowBookTable = new javax.swing.JPanel();
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
    dateChooserDialogListBookTable.addSelectionChangedListener(new datechooser.events.SelectionChangedListener() {
        public void onSelectionChange(datechooser.events.SelectionChangedEvent evt) {
            dateChooserDialogListBookTableOnSelectionChange(evt);
        }
    });
    dateChooserDialogListBookTable.addCommitListener(new datechooser.events.CommitListener() {
        public void onCommit(datechooser.events.CommitEvent evt) {
            dateChooserDialogListBookTableOnCommit(evt);
        }
    });

    jDialogAddBookTable.setAlwaysOnTop(true);
    jDialogAddBookTable.setBackground(new java.awt.Color(70, 92, 139));
    jDialogAddBookTable.setMinimumSize(new java.awt.Dimension(550, 400));
    jDialogAddBookTable.setResizable(false);
    jDialogAddBookTable.setSize(new java.awt.Dimension(550, 400));

    jPanelDialogHeader.setBackground(new java.awt.Color(147, 193, 120));

    jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_table_white_x50.png"))); // NOI18N

    jLabelAddBookTable.setText("Lập phiếu đặt bàn");

    jLabelPickTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_book_table_x24.png"))); // NOI18N
    jLabelPickTable.setText("Click chọn bàn đặt");
    jLabelPickTable.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jLabelPickTableMouseClicked(evt);
        }
    });

    javax.swing.GroupLayout jPanelDialogHeaderLayout = new javax.swing.GroupLayout(jPanelDialogHeader);
    jPanelDialogHeader.setLayout(jPanelDialogHeaderLayout);
    jPanelDialogHeaderLayout.setHorizontalGroup(
        jPanelDialogHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelDialogHeaderLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jLabelAddBookTable)
            .addGap(65, 65, 65)
            .addComponent(jLabelPickTable)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    jPanelDialogHeaderLayout.setVerticalGroup(
        jPanelDialogHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDialogHeaderLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addContainerGap())
        .addGroup(jPanelDialogHeaderLayout.createSequentialGroup()
            .addGap(21, 21, 21)
            .addGroup(jPanelDialogHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabelAddBookTable)
                .addComponent(jLabelPickTable, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    CFont.setStyleFont(jLabelPickTable, 14, Color.WHITE);

    jPanelDialogContent.setBackground(new java.awt.Color(70, 92, 139));
    jPanelDialogContent.setForeground(new java.awt.Color(70, 92, 139));
    jPanelDialogContent.setToolTipText("");
    jPanelDialogContent.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jTextFieldCustomerPhone.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusGained(java.awt.event.FocusEvent evt) {
            jTextFieldCustomerPhoneFocusGained(evt);
        }
        public void focusLost(java.awt.event.FocusEvent evt) {
            jTextFieldCustomerPhoneFocusLost(evt);
        }
    });
    jTextFieldCustomerPhone.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jTextFieldCustomerPhoneActionPerformed(evt);
        }
    });
    jTextFieldCustomerPhone.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            jTextFieldCustomerPhoneKeyReleased(evt);
        }
    });
    jPanelDialogContent.add(jTextFieldCustomerPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 150, -1));

    jLabelCustomerPhone.setText("Số điện thoại khách hàng: *");
    jPanelDialogContent.add(jLabelCustomerPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

    jPanel1.setBackground(new java.awt.Color(70, 92, 139));
    jPanel1.setPreferredSize(new java.awt.Dimension(200, 29));

    jSpinnerTimePicker.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
        public void propertyChange(java.beans.PropertyChangeEvent evt) {
            jSpinnerTimePickerPropertyChange(evt);
        }
    });

    jLabelAddDateBookTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_calendar_pick_white_x24.png"))); // NOI18N
    jLabelAddDateBookTable.setText("dd/mm/YYYY");
    jLabelAddDateBookTable.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jLabelAddDateBookTableMouseClicked(evt);
        }
    });

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabelAddDateBookTable)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jSpinnerTimePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabelAddDateBookTable)
                .addComponent(jSpinnerTimePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(0, 6, Short.MAX_VALUE))
    );

    Calendar calendar = Calendar.getInstance();
    calendar.setTime(new Date(0));
    Date earliestDate = calendar.getTime();
    calendar.add(Calendar.MINUTE, 1439); // number of minutes in a day - 1
    Date latestDate = calendar.getTime();
    SpinnerDateModel model = new SpinnerDateModel(earliestDate,earliestDate,latestDate,Calendar.MINUTE);
    jSpinnerTimePicker.setModel(model);
    jSpinnerTimePicker.setEditor(new JSpinner.DateEditor(jSpinnerTimePicker, "HH:mm"));

    jPanelDialogContent.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, -1, 30));
    jPanelDialogContent.add(jTextFieldCustomerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, 200, -1));

    jLabelCustomerName.setText("Tên khách hàng:");
    jPanelDialogContent.add(jLabelCustomerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

    jLabelCustomerMessage.setText("Lời nhắn của khách hàng:");
    jPanelDialogContent.add(jLabelCustomerMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

    jTextAreaCustomerMessage.setColumns(20);
    jTextAreaCustomerMessage.setRows(5);
    jScrollPane2.setViewportView(jTextAreaCustomerMessage);

    jPanelDialogContent.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 290, 110));

    jLabelDateTimeBook.setText("Chọn ngày giờ đặt: ");
    jPanelDialogContent.add(jLabelDateTimeBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

    jLabelDoAddBookTable.setBackground(new java.awt.Color(147, 193, 120));
    jLabelDoAddBookTable.setForeground(new java.awt.Color(255, 255, 255));
    jLabelDoAddBookTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/book_table_white_24px.png"))); // NOI18N
    jLabelDoAddBookTable.setText("Lập phiếu");
    jLabelDoAddBookTable.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jLabelDoAddBookTableMouseClicked(evt);
        }
    });
    jPanelDialogContent.add(jLabelDoAddBookTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 260, 120, 30));
    jLabelDoAddBookTable.setBorder(new RadiusBorder(Color.WHITE,1,15,0,true));
    jLabelDoAddBookTable.setOpaque(true);

    jLabelCloseAddBookTable.setBackground(new java.awt.Color(255, 102, 0));
    jLabelCloseAddBookTable.setForeground(new java.awt.Color(255, 255, 255));
    jLabelCloseAddBookTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_close_white_x24.png"))); // NOI18N
    jLabelCloseAddBookTable.setText("Hủy");
    jLabelCloseAddBookTable.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jLabelCloseAddBookTableMouseClicked(evt);
        }
    });
    jPanelDialogContent.add(jLabelCloseAddBookTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 260, 80, 30));
    jLabelCloseAddBookTable.setBorder(new RadiusBorder(Color.WHITE,1,15,0,true));
    jLabelCloseAddBookTable.setOpaque(true);

    javax.swing.GroupLayout jDialogAddBookTableLayout = new javax.swing.GroupLayout(jDialogAddBookTable.getContentPane());
    jDialogAddBookTable.getContentPane().setLayout(jDialogAddBookTableLayout);
    jDialogAddBookTableLayout.setHorizontalGroup(
        jDialogAddBookTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanelDialogHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanelDialogContent, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
    );
    jDialogAddBookTableLayout.setVerticalGroup(
        jDialogAddBookTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jDialogAddBookTableLayout.createSequentialGroup()
            .addComponent(jPanelDialogHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addGroup(jDialogAddBookTableLayout.createSequentialGroup()
            .addGap(70, 70, 70)
            .addComponent(jPanelDialogContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    CFont.setStyleFont(jLabelAddBookTable, 20, Color.WHITE);
    CFont.setStyleFont(jLabelCustomerName, 13, Color.WHITE);
    CFont.setStyleFont(jLabelCustomerPhone, 13, Color.WHITE);
    CFont.setStyleFont(jLabelDateTimeBook, 13, Color.WHITE);
    CFont.setStyleFont(jLabelCustomerMessage, 13, Color.WHITE);
    CFont.setStyleFont(jLabelAddDateBookTable, 11, Color.WHITE);
    CFont.setStyleFont(jTextAreaCustomerMessage, 13, Color.BLACK);

    jLabelDoAddBookTable.setOpaque(true);

    dateChooserDialogAddBookTable.setCalendarPreferredSize(new java.awt.Dimension(400, 350));
    dateChooserDialogAddBookTable.setLocale(new java.util.Locale("vi", "VN", ""));
    dateChooserDialogAddBookTable.setBehavior(datechooser.model.multiple.MultyModelBehavior.SELECT_SINGLE);
    dateChooserDialogAddBookTable.addCommitListener(new datechooser.events.CommitListener() {
        public void onCommit(datechooser.events.CommitEvent evt) {
            dateChooserDialogAddBookTableOnCommit(evt);
        }
    });

    jDialogPickTable.setTitle("Chọn bàn để đặt");
    jDialogPickTable.setAlwaysOnTop(true);
    jDialogPickTable.setMaximumSize(new java.awt.Dimension(800, 550));
    jDialogPickTable.setMinimumSize(new java.awt.Dimension(800, 550));
    jDialogPickTable.setPreferredSize(new java.awt.Dimension(800, 550));
    jDialogPickTable.setResizable(false);
    jDialogPickTable.getContentPane().setLayout(new java.awt.FlowLayout());

    setMaximumSize(new java.awt.Dimension(800, 520));
    setMinimumSize(new java.awt.Dimension(800, 520));
    setPreferredSize(new java.awt.Dimension(800, 520));
    setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 5));

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

    jPanelShowBookTable.setBackground(new java.awt.Color(247, 222, 122));
    jPanelShowBookTable.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));
    jPanelShowBookTable.setForeground(new java.awt.Color(153, 255, 204));
    jPanelShowBookTable.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jPanelShowBookTableMouseClicked(evt);
        }
    });
    jPanelShowBookTable.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/icon_add_folder_black_32px.png"))); // NOI18N
    jLabel10.setText("Đặt bàn");
    jLabel10.setVerticalAlignment(javax.swing.SwingConstants.TOP);
    jPanelShowBookTable.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 100, 40));

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
            .addComponent(jPanelShowBookTable, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(100, Short.MAX_VALUE))
    );
    jPanelBookTableHeaderLayout.setVerticalGroup(
        jPanelBookTableHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanelBookTableHeaderLayout.createSequentialGroup()
            .addGroup(jPanelBookTableHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(jPanelShowBookTable, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        
    }//GEN-LAST:event_dateChooserDialogListBookTableOnSelectionChange

    private void jLabelShowChooserDateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelShowChooserDateMouseClicked
        dateChooserDialogListBookTable.showDialog(MainFrame.getInstance());
        
    }//GEN-LAST:event_jLabelShowChooserDateMouseClicked

    private void jPanelShowBookTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelShowBookTableMouseClicked
        // TODO add your handling code here:
        System.out.println("do order");
//        JFrameAddBookTable.getInstance().setUndecorated(true);
//        JFrameAddBookTable.getInstance().setVisible(true);
//        jFrame1.setVisible(true);
//        jDialogAddBookTable.setLocationRelativeTo(this);
//        jDialogAddBookTable.setVisible(true);
//            jDialogPickTable.getContentPane().add(JPanelBookTablePickTable.getInstance());
            jDialogAddBookTable.setLocationRelativeTo(MainFrame.getInstance());
            jDialogAddBookTable.setAlwaysOnTop(true);
            jDialogAddBookTable.setVisible(true);
    }//GEN-LAST:event_jPanelShowBookTableMouseClicked

    private void jLabelCloseAddBookTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCloseAddBookTableMouseClicked
        // TODO add your handling code here:
        jDialogAddBookTable.setVisible(false);
    }//GEN-LAST:event_jLabelCloseAddBookTableMouseClicked

    private void jSpinnerTimePickerPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jSpinnerTimePickerPropertyChange
        // TODO add your handling code here:
        Date d = (Date)jSpinnerTimePicker.getValue();
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        c.get(Calendar.HOUR);
        c.get(Calendar.MINUTE);
    }//GEN-LAST:event_jSpinnerTimePickerPropertyChange

    private void jLabelAddDateBookTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAddDateBookTableMouseClicked
        jDialogAddBookTable.setAlwaysOnTop(false);
        dateChooserDialogAddBookTable.showDialog(MainFrame.getInstance());
    }//GEN-LAST:event_jLabelAddDateBookTableMouseClicked

    private void dateChooserDialogAddBookTableOnCommit(datechooser.events.CommitEvent evt) {//GEN-FIRST:event_dateChooserDialogAddBookTableOnCommit
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String date = sdf.format(dateChooserDialogAddBookTable.getSelectedDate().getTime());
        jLabelAddDateBookTable.setText(date);
        jDialogAddBookTable.setAlwaysOnTop(true);
    }//GEN-LAST:event_dateChooserDialogAddBookTableOnCommit

    private void dateChooserDialogListBookTableOnCommit(datechooser.events.CommitEvent evt) {//GEN-FIRST:event_dateChooserDialogListBookTableOnCommit
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdfSql = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(dateChooserDialogListBookTable.getSelectedDate().getTime());
        String dateSql = sdfSql.format(dateChooserDialogListBookTable.getSelectedDate().getTime());
        viewBookTable = VBookTable.getByDate(dateSql, 1, 15);
        jLabelDateBookTable.setText(date);
        showData();
    }//GEN-LAST:event_dateChooserDialogListBookTableOnCommit

    private void jLabelDoAddBookTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDoAddBookTableMouseClicked
        System.out.println("jLabelDoAddBookTableMouseClicked in JPanelBookTable.java: thực hiện lập phiếu");
        mBookTable.setStatus(0);
        //get date and time
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdfSql = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(dateChooserDialogAddBookTable.getSelectedDate().getTime());
        String dateSql = sdfSql.format(dateChooserDialogAddBookTable.getSelectedDate().getTime());
        Date d = (Date)jSpinnerTimePicker.getValue();
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        mBookTable.setDateTimeBook(dateSql+" "+c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE)+":00");
        //#get time
        mBookTable.setMessage(jTextAreaCustomerMessage.getText());
        if (mBookTable.getTableId() == 0) {
            JOptionPane.showMessageDialog(jDialogAddBookTable,  "Chưa chọn bàn!");
            return;
        }
        if(mBookTable.getCustomerId() == 0){
            MCustomer mc = new MCustomer();
            mc.setFullName(jTextFieldCustomerName.getText());
            mc.setPhone(jTextFieldCustomerPhone.getText());
            mc.setCustomerTypeId(1);
            try {
                mc.insert();
                mBookTable.setCustomerId(MCustomer.getLastCustomer().getId());
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(jDialogAddBookTable,  "Không thể thêm khách hàng mới!");
                e.printStackTrace();
                return;
            }
        }
        try {
            mBookTable.insert();
            JOptionPane.showMessageDialog(jDialogAddBookTable,  "Lập phiếu thành công!");
            //set all textfield to empty
            jTextFieldCustomerName.setText("");
            jTextFieldCustomerPhone.setText("");
            jTextAreaCustomerMessage.setText("");
            mBookTable.reset();
            jLabelPickTable.setText("Click chọn bàn");
            //end set textfield
            jDialogAddBookTable.setVisible(false);
            //cap nhat lai list, chuyen list sang ngay vua dat
            viewBookTable = VBookTable.getByDate(dateSql, 1, 15);
            jLabelDateBookTable.setText(date);
            showData();
            //end cap nhat lai list
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(jDialogAddBookTable,  "Lập phiếu thất bại!");
            e.printStackTrace();
            return;
        }
    }//GEN-LAST:event_jLabelDoAddBookTableMouseClicked

    private void jTextFieldCustomerPhoneFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldCustomerPhoneFocusLost
        MCustomer customer = MCustomer.getByPhone(jTextFieldCustomerPhone.getText());
        if (customer.getId() != 0) {
            jTextFieldCustomerName.setText(customer.getFullName());
            jTextFieldCustomerName.setEnabled(false);
            mBookTable.setCustomerId(customer.getId());
        }
    }//GEN-LAST:event_jTextFieldCustomerPhoneFocusLost

    private void jTextFieldCustomerPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCustomerPhoneActionPerformed
        
    }//GEN-LAST:event_jTextFieldCustomerPhoneActionPerformed

    private void jTextFieldCustomerPhoneKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCustomerPhoneKeyReleased
        
    }//GEN-LAST:event_jTextFieldCustomerPhoneKeyReleased

    private void jTextFieldCustomerPhoneFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldCustomerPhoneFocusGained
        if(!jTextFieldCustomerName.isEnabled()){
            jTextFieldCustomerName.setText("");
            jTextFieldCustomerName.setEnabled(true);
        }
    }//GEN-LAST:event_jTextFieldCustomerPhoneFocusGained

    private void jLabelPickTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelPickTableMouseClicked
        jDialogPickTable.setLocationRelativeTo(jDialogAddBookTable);
        jDialogAddBookTable.setAlwaysOnTop(false);
        jDialogPickTable.getContentPane().add(JPanelBookTablePickTable.getInstance());
        jDialogPickTable.setVisible(true);
    }//GEN-LAST:event_jLabelPickTableMouseClicked

    public DateChooserDialog getDateChooserDialog1() {
        return dateChooserDialogListBookTable;
    }

    public static JPanelBookTable getInstance() {
        if(instance == null) instance = new JPanelBookTable();
        return instance;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private datechooser.beans.DateChooserDialog dateChooserDialogAddBookTable;
    private datechooser.beans.DateChooserDialog dateChooserDialogListBookTable;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JDialog jDialogAddBookTable;
    private javax.swing.JDialog jDialogPickTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelAddBookTable;
    private javax.swing.JLabel jLabelAddDateBookTable;
    private javax.swing.JLabel jLabelCloseAddBookTable;
    private javax.swing.JLabel jLabelCustomerMessage;
    private javax.swing.JLabel jLabelCustomerName;
    private javax.swing.JLabel jLabelCustomerPhone;
    private javax.swing.JLabel jLabelDateBookTable;
    private javax.swing.JLabel jLabelDateTimeBook;
    private javax.swing.JLabel jLabelDoAddBookTable;
    private javax.swing.JLabel jLabelPickTable;
    private javax.swing.JLabel jLabelShowChooserDate;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelBookTableContent;
    private javax.swing.JPanel jPanelBookTableHeader;
    private javax.swing.JPanel jPanelDialogContent;
    private javax.swing.JPanel jPanelDialogHeader;
    private javax.swing.JPanel jPanelListBookTableContent;
    private javax.swing.JPanel jPanelListBookTableHeader;
    private javax.swing.JPanel jPanelShowBookTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinnerTimePicker;
    private javax.swing.JTextArea jTextAreaCustomerMessage;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextFieldCustomerName;
    private javax.swing.JTextField jTextFieldCustomerPhone;
    // End of variables declaration//GEN-END:variables
}
