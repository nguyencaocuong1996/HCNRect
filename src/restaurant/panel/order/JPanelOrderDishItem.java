
package restaurant.panel.order;

import assets.font.CFont;
import assets.images.dishs.DishImageResources;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import restaurant.MainFrame;

public class JPanelOrderDishItem extends javax.swing.JPanel{
    String dishName;
    String urlImage;
    float dishPrice;
    int dishId;
    public JPanelOrderDishItem() {
        initComponents();
    }

    public int getDishId() {
        return dishId;
    }

    public JPanelOrderDishItem(int dishId, String urlImage, String dishName, float dishPrice) {
        initComponents();
        this.dishId = dishId;
        this.dishName = dishName;
        this.dishPrice = dishPrice;
        this.urlImage = urlImage;
        customInit();
        ImageIcon img = new ImageIcon(new ImageIcon(DishImageResources.class.getResource(urlImage)).getImage().getScaledInstance(80, 60, Image.SCALE_DEFAULT));
        jLabelDishImage.setIcon(img);
        
//        jLabelDishName.setText("<html><p>"+dishName+"</p><html>");
        jLabelDishName.setText(dishName);
        CFont.setStyleFont(jLabelDishName, 14, Color.BLACK);
        
        jLabelDishPrice.setText(dishPrice + " VNĐ");
        CFont.setStyleFont(jLabelDishPrice, 14, Color.BLACK);
    }
    private void customInit(){
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MainFrame.getInstance().changeContentPanel(JPanelOrder.getInstance());
                int tableId = JPanelOrder.getInstance().getTableId();
                System.out.println(tableId);
                JPanelOrderDetail jpOD = JPanelOrder.getInstance().getListJPanelOrderDetail().get(tableId);
                boolean checkExists = false;
                for (JPanelOrderItem item : jpOD.getListDishOrdering()) {
                    if(item.getDishId() == dishId){
                        item.setQuantity(item.getQuantity() + 1);
                        checkExists = true;
                        break;
                    }
                }
                if(checkExists == false){
                    JPanelOrder.getInstance().getJpOrderDetail().addOrderItem(new JPanelOrderItem(dishId, dishName,1,dishPrice));
                }
                JPanelOrder.getInstance().updateBill();
                JPanelOrder.getInstance().revalidate();
                JPanelOrder.getInstance().repaint();
            }
            
        });
    }
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setLayout(new FlowLayout());
        jf.setSize(new Dimension(500,500));
        JPanelOrderDishItem jt = new JPanelOrderDishItem(1,"salmon.jpeg","Salmon", 21000);

        
        jf.add(jt);
  
        jf.setVisible(true);
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelDishImage = new javax.swing.JLabel();
        jLabelDishName = new javax.swing.JLabel();
        jLabelDishPrice = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(200, 80));
        setMinimumSize(new java.awt.Dimension(200, 80));
        setPreferredSize(new java.awt.Dimension(200, 80));

        jLabelDishImage.setMaximumSize(new java.awt.Dimension(60, 60));
        jLabelDishImage.setMinimumSize(new java.awt.Dimension(60, 60));
        jLabelDishImage.setPreferredSize(new java.awt.Dimension(60, 60));

        jLabelDishName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelDishName.setText("jLabel1");

        jLabelDishPrice.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabelDishImage, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelDishName, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                    .addComponent(jLabelDishPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelDishImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelDishName, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelDishPrice)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelDishImage;
    private javax.swing.JLabel jLabelDishName;
    private javax.swing.JLabel jLabelDishPrice;
    // End of variables declaration//GEN-END:variables
}
