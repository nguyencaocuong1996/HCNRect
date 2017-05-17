package restaurant.panel.main.table;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import view.VTable;
import view.ViewData;

public class JPanelListTable extends javax.swing.JPanel {

    public ArrayList<JPanelTable> listTable = new ArrayList<>();
    
    public JPanelListTable() {
        initComponents();
        VTable vt = VTable.searchByName("k");
        vt.getData().forEach((t) -> {
            JPanelTable c = new JPanelTable((String)t.get("TenBan"), (Integer)t.get("TrangThai"));
            jTableListPanel.add(c);
        });
        
    }
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setLayout(new FlowLayout());
        jf.setSize(new Dimension(500,500));
        jf.add(new JPanelListTable());
        jf.setVisible(true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableListPanel = new javax.swing.JPanel();

        setMinimumSize(new java.awt.Dimension(800, 500));

        jScrollPane1.setViewportView(jTableListPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jTableListPanel;
    // End of variables declaration//GEN-END:variables
}
