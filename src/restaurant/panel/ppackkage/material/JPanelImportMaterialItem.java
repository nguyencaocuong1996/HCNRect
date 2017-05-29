
package restaurant.panel.ppackkage.material;

/**
 *
 * @author WINDNCC
 */
public class JPanelImportMaterialItem extends javax.swing.JPanel {
    protected int materialId;
    protected String name;
    protected float inStock;

    public JPanelImportMaterialItem(int materialId, String name, float inStock) {
        initComponents();
        this.materialId = materialId;
        this.name = name;
        this.inStock = inStock;
        jLabelMaterialId.setText(materialId + "");
        jLabelMaterialName.setText(name);
        jLabelMaterialInStock.setText(inStock+"");
        
    }
    
    public JPanelImportMaterialItem() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelMaterialId = new javax.swing.JLabel();
        jLabelMaterialName = new javax.swing.JLabel();
        jLabelMaterialInStock = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(400, 50));
        setMinimumSize(new java.awt.Dimension(400, 50));
        setPreferredSize(new java.awt.Dimension(400, 50));

        jLabelMaterialId.setText("Mã");

        jLabelMaterialName.setText("Tên");

        jLabelMaterialInStock.setText("Lượng tồn");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabelMaterialId, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelMaterialName, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelMaterialInStock, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabelMaterialId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelMaterialName, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabelMaterialInStock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelMaterialId;
    private javax.swing.JLabel jLabelMaterialInStock;
    private javax.swing.JLabel jLabelMaterialName;
    // End of variables declaration//GEN-END:variables
}
