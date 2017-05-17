package restaurant.panel.main.table;

import assets.font.CFont;
import assets.images.icons.IconResources;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

public class JPanelTable extends javax.swing.JPanel {
    
    protected int id;
    protected int status;
    
    public JPanelTable(String tableName, int status) {
        initComponents();
        jLabelName.setText(tableName);
        CFont.setStyleFont(jLabelName, 20, Color.black);
        jLabelIcon.setIcon(IconResources.TABLE_BLACK_X50);
        
        switch (status){
            case 0: this.setBackground(Color.yellow); break;// bàn rãnh
            case 1: this.setBackground(Color.red); break;//bàn bận
            case 2: this.setBackground(Color.gray); break;//bàn đã đặt
        }
        addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
                    System.out.println(tableName);
                }
            });
    }
    public JPanelTable() {
        initComponents();
        jLabelIcon.setIcon(IconResources.TABLE_BLACK_X50);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setLayout(new FlowLayout());
        jf.setSize(new Dimension(500,500));
        JPanelTable jt = new JPanelTable("Bàn 1",0);
        JPanelTable jt1 = new JPanelTable("Bàn 2",1);
        JPanelTable jt2 = new JPanelTable("Bàn 3",2);
        
        jf.add(jt);
        jf.add(jt1);
        jf.add(jt2);
        jf.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelIcon = new javax.swing.JLabel();
        jLabelName = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(100, 100));
        setPreferredSize(new java.awt.Dimension(100, 100));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(jLabelIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 66, 56));
        add(jLabelName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 70, 20));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelIcon;
    private javax.swing.JLabel jLabelName;
    // End of variables declaration//GEN-END:variables
}
