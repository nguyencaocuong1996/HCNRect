
package restaurant.panel.order;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import restaurant.panel.main.table.JPanelTable;
import view.ViewData;

public class JPanelOrderDish extends javax.swing.JPanel {
    
    protected JPanelOrderDishItem[] listOrderDishItem;
    
    
    public JPanelOrderDish() {
        initComponents();
        
        jPanelListOrderDish.setPreferredSize(new Dimension(520,600));
        
        listOrderDishItem = new JPanelOrderDishItem[10];
        listOrderDishItem[0] = new JPanelOrderDishItem("salmon.jpeg", "ten mon", 103230);
        listOrderDishItem[1] = new JPanelOrderDishItem("Pasta.jpeg", "ten mon", 103230);
        listOrderDishItem[2] = new JPanelOrderDishItem("Pho.jpeg", "ten mon", 103230);
        listOrderDishItem[3] = new JPanelOrderDishItem("hamani.jpeg", "ten mon", 103230);
        listOrderDishItem[4] = new JPanelOrderDishItem("lemon-rice.jpg", "ten mon", 103230);
        listOrderDishItem[5] = new JPanelOrderDishItem("pasta-spaghetti.jpg", "ten mon", 103230);
        listOrderDishItem[6] = new JPanelOrderDishItem("sala-spinach.jpg", "ten mon", 103230);
        listOrderDishItem[7] = new JPanelOrderDishItem("salmon-teriyaki.jpg", "ten mon", 103230);
        listOrderDishItem[8] = new JPanelOrderDishItem("liquid-orange.jpeg", "ten mon", 103230);
        listOrderDishItem[9] = new JPanelOrderDishItem("tranmautritam.jpeg", "ten mon", 103230);
        //jPanelListOrderDish.add(listOrderDishItem[0]);
        for (JPanelOrderDishItem jPanelOrderDishItem : listOrderDishItem) {
            
            jPanelListOrderDish.add(jPanelOrderDishItem);
            
        }
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanelListOrderDish = new javax.swing.JPanel();

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanelListOrderDish.setMinimumSize(new java.awt.Dimension(518, 518));
        jPanelListOrderDish.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        jScrollPane1.setViewportView(jPanelListOrderDish);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setLayout(new FlowLayout());
        jf.setSize(new Dimension(1000,600));
        jf.add(new JPanelOrderDish());
        jf.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanelListOrderDish;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
