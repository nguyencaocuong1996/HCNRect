
package restaurant.panel.order;

import assets.font.CFont;
import assets.images.dishs.DishImageResources;
import assets.images.icons.IconResources;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import restaurant.panel.main.table.JPanelTable;

public class JPanelOrderDishItem extends javax.swing.JPanel {

    public JPanelOrderDishItem() {
        initComponents();
    }
    
    public JPanelOrderDishItem(String urlImage, String dishName, float dishPrice) {
        initComponents();
        jLabelDishImage.setIcon(new ImageIcon(DishImageResources.class.getResource(urlImage)));
        
        jLabelDishName.setText(dishName);
        CFont.setStyleFont(jLabelDishName, 14, Color.BLACK);
        
        jLabelDishPrice.setText(dishPrice + " VNĐ");
        CFont.setStyleFont(jLabelDishPrice, 14, Color.BLACK);
    }
    
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setLayout(new FlowLayout());
        jf.setSize(new Dimension(500,500));
        JPanelOrderDishItem jt = new JPanelOrderDishItem("salmon.jpeg","Salmon", 21000);

        
        jf.add(jt);
  
        jf.setVisible(true);
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelDishImage = new javax.swing.JLabel();
        jLabelDishName = new javax.swing.JLabel();
        jLabelDishPrice = new javax.swing.JLabel();

        jLabelDishName.setText("jLabel1");

        jLabelDishPrice.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabelDishImage, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelDishName, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelDishPrice)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelDishImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabelDishName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jLabelDishPrice)
                .addGap(19, 19, 19))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelDishImage;
    private javax.swing.JLabel jLabelDishName;
    private javax.swing.JLabel jLabelDishPrice;
    // End of variables declaration//GEN-END:variables
}
