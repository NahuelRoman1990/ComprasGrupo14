/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

/**
 *
 * @author Erni
 */
public class ComprasVista extends javax.swing.JInternalFrame {

    /**
     * Creates new form ComprasVista
     */
    public ComprasVista() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdEscritorioCompras = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jtIdCompra = new javax.swing.JTextField();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        jLabel2 = new javax.swing.JLabel();
        jcbProveedor = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jcbProductos = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jtTotal = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jbAgregar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jtCantidad = new javax.swing.JTextField();
        jbComprar = new javax.swing.JButton();
        jbConfirmarCompra = new javax.swing.JButton();
        jbDescartar = new javax.swing.JButton();
        jbCancelarCompra = new javax.swing.JButton();
        jbModificar = new javax.swing.JButton();

        jdEscritorioCompras.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setText("ID Compra");

        jtIdCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtIdCompraActionPerformed(evt);
            }
        });

        jLabel2.setText("Proveedor");

        jcbProveedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        jLabel3.setText("COMPRAS");

        jLabel4.setText("Productos");

        jcbProductos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("Total");

        jtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtTotalActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jbAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos de gui/Vector-10.png"))); // NOI18N
        jbAgregar.setText("Agregar");

        jLabel6.setText("Cantidad");

        jbComprar.setText("Comprar");

        jbConfirmarCompra.setText("Confirmar Compra");

        jbDescartar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos delete/Size=28, Theme=Filled-1.png"))); // NOI18N
        jbDescartar.setText("Descartar");

        jbCancelarCompra.setText("Cancelar Compra");

        jbModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos de gui/editar-modificar.png"))); // NOI18N
        jbModificar.setText("Modificar");

        jdEscritorioCompras.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdEscritorioCompras.setLayer(jtIdCompra, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdEscritorioCompras.setLayer(jCalendar1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdEscritorioCompras.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdEscritorioCompras.setLayer(jcbProveedor, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdEscritorioCompras.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdEscritorioCompras.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdEscritorioCompras.setLayer(jcbProductos, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdEscritorioCompras.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdEscritorioCompras.setLayer(jtTotal, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdEscritorioCompras.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdEscritorioCompras.setLayer(jbAgregar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdEscritorioCompras.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdEscritorioCompras.setLayer(jtCantidad, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdEscritorioCompras.setLayer(jbComprar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdEscritorioCompras.setLayer(jbConfirmarCompra, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdEscritorioCompras.setLayer(jbDescartar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdEscritorioCompras.setLayer(jbCancelarCompra, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdEscritorioCompras.setLayer(jbModificar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jdEscritorioComprasLayout = new javax.swing.GroupLayout(jdEscritorioCompras);
        jdEscritorioCompras.setLayout(jdEscritorioComprasLayout);
        jdEscritorioComprasLayout.setHorizontalGroup(
            jdEscritorioComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdEscritorioComprasLayout.createSequentialGroup()
                .addGroup(jdEscritorioComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jdEscritorioComprasLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbConfirmarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jdEscritorioComprasLayout.createSequentialGroup()
                        .addGroup(jdEscritorioComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jdEscritorioComprasLayout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jcbProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jdEscritorioComprasLayout.createSequentialGroup()
                                .addGroup(jdEscritorioComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jdEscritorioComprasLayout.createSequentialGroup()
                                        .addGap(40, 40, 40)
                                        .addGroup(jdEscritorioComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jdEscritorioComprasLayout.createSequentialGroup()
                                                .addGroup(jdEscritorioComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel4)
                                                    .addGroup(jdEscritorioComprasLayout.createSequentialGroup()
                                                        .addGap(150, 150, 150)
                                                        .addComponent(jLabel6))
                                                    .addGroup(jdEscritorioComprasLayout.createSequentialGroup()
                                                        .addComponent(jbModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(75, 75, 75)
                                                        .addComponent(jbDescartar, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(jLabel1))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                                                .addGroup(jdEscritorioComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jtIdCompra, javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jcbProductos, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addGroup(jdEscritorioComprasLayout.createSequentialGroup()
                                                        .addGap(6, 6, 6)
                                                        .addComponent(jtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(28, 28, 28)
                                                        .addComponent(jbAgregar))))))
                                    .addGroup(jdEscritorioComprasLayout.createSequentialGroup()
                                        .addGap(50, 50, 50)
                                        .addComponent(jbComprar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(38, 38, 38)
                                        .addComponent(jbCancelarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(112, 112, 112)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 764, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jdEscritorioComprasLayout.createSequentialGroup()
                        .addGap(500, 500, 500)
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jdEscritorioComprasLayout.setVerticalGroup(
            jdEscritorioComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdEscritorioComprasLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jdEscritorioComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcbProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jdEscritorioComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jdEscritorioComprasLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jdEscritorioComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbComprar)
                            .addComponent(jbCancelarCompra))
                        .addGap(18, 18, 18)
                        .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addGroup(jdEscritorioComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtIdCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jdEscritorioComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jcbProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jdEscritorioComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jdEscritorioComprasLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jdEscritorioComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(jtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jbConfirmarCompra))
                                .addContainerGap(200, Short.MAX_VALUE))
                            .addGroup(jdEscritorioComprasLayout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(jdEscritorioComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(jtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jdEscritorioComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jdEscritorioComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jbDescartar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jbModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                    .addComponent(jbAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jdEscritorioComprasLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdEscritorioCompras)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdEscritorioCompras)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtIdCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtIdCompraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtIdCompraActionPerformed

    private void jtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtTotalActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbAgregar;
    private javax.swing.JButton jbCancelarCompra;
    private javax.swing.JButton jbComprar;
    private javax.swing.JButton jbConfirmarCompra;
    private javax.swing.JButton jbDescartar;
    private javax.swing.JButton jbModificar;
    private javax.swing.JComboBox<String> jcbProductos;
    private javax.swing.JComboBox<String> jcbProveedor;
    private javax.swing.JDesktopPane jdEscritorioCompras;
    private javax.swing.JTextField jtCantidad;
    private javax.swing.JTextField jtIdCompra;
    private javax.swing.JTextField jtTotal;
    // End of variables declaration//GEN-END:variables
}
