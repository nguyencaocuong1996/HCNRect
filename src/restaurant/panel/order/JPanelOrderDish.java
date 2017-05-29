
package restaurant.panel.order;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import javax.swing.JFrame;
import view.VDish;
import view.ViewItem;

public class JPanelOrderDish extends javax.swing.JPanel {
    protected VDish listDish;
    protected HashMap<Integer, JPanelOrderDishItem>  listOrderDishItem = new HashMap<>();
    protected int numDish;
    public JPanelOrderDish(VDish vDish) {
        this.listDish = vDish;
    }

    public HashMap<Integer, JPanelOrderDishItem> getListOrderDishItem() {
        return listOrderDishItem;
    }
    
    
    public JPanelOrderDish() {
        initComponents();
        listDish = VDish.getAllDish();
        numDish = listDish.getData().size();
        jPanelListOrderDish.setPreferredSize(new Dimension(430, 85 * (numDish / 2+1)));
        listDish.getData().forEach((ViewItem t) -> {
            Long dishIdL = (Long) t.get("MaMA");
            JPanelOrderDishItem newJPODI = new JPanelOrderDishItem(dishIdL.intValue() , (String) t.get("DiaChiAnhMA"), (String) t.get("TenMA"), (float) t.get("GiaMA"));
            listOrderDishItem.put(dishIdL.intValue(), newJPODI);
            jPanelListOrderDish.add(newJPODI);
        });
    }
    public void filter(int menuId, String dishName){
        if(listDish != null ) {
            jPanelListOrderDish.removeAll();
            listDish.filter(menuId, dishName);
            listDish.getFilterData().forEach((t) -> {
                Long dishIdL = (Long) t.get("MaMA");
                jPanelListOrderDish.add(listOrderDishItem.get(dishIdL.intValue()));
            });
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanelListOrderDish = new javax.swing.JPanel();

        setMinimumSize(new java.awt.Dimension(450, 443));
        setPreferredSize(new java.awt.Dimension(450, 443));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(432, 434));

        jPanelListOrderDish.setMinimumSize(new java.awt.Dimension(430, 500));
        jPanelListOrderDish.setPreferredSize(new java.awt.Dimension(430, 443));
        jPanelListOrderDish.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        jScrollPane1.setViewportView(jPanelListOrderDish);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
