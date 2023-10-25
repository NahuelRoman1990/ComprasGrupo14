package vistas;


import javax.swing.ImageIcon;

import javax.swing.JLabel;



public class MenuPrincipal extends javax.swing.JFrame {


    public MenuPrincipal() {
        initComponents();
        jdEscritorio();
        
        
  
    }
      
 
    private void  jdEscritorio(){
        String rutaImagen = "img\\fondo.jpg";
        jdEscritorio.setOpaque(false);
        ImageIcon fondo = new ImageIcon(rutaImagen);
        JLabel label = new JLabel(fondo);
        label.setBounds(0, 0, fondo.getIconWidth(), fondo.getIconHeight());
        jdEscritorio.add(label);
    }
    
 

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jToolBar1 = new javax.swing.JToolBar();
        jbCompras = new javax.swing.JButton();
        jbProveedores = new javax.swing.JButton();
        jbProducto = new javax.swing.JButton();
        jbDetalle = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jdEscritorio = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setBackground(new java.awt.Color(255, 113, 43));
        jToolBar1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jToolBar1.setForeground(new java.awt.Color(255, 255, 255));
        jToolBar1.setRollover(true);

        jbCompras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pequeño carrito png.png"))); // NOI18N
        jbCompras.setText("Compras");
        jbCompras.setFocusable(false);
        jbCompras.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbCompras.setMaximumSize(new java.awt.Dimension(82, 82));
        jbCompras.setMinimumSize(new java.awt.Dimension(82, 82));
        jbCompras.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbComprasActionPerformed(evt);
            }
        });
        jToolBar1.add(jbCompras);

        jbProveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Delivery0.5-100x100.png"))); // NOI18N
        jbProveedores.setText("Proveedores");
        jbProveedores.setFocusable(false);
        jbProveedores.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbProveedores.setMaximumSize(new java.awt.Dimension(82, 82));
        jbProveedores.setMinimumSize(new java.awt.Dimension(82, 82));
        jbProveedores.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbProveedoresActionPerformed(evt);
            }
        });
        jToolBar1.add(jbProveedores);

        jbProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/producto0.5-100x100.png"))); // NOI18N
        jbProducto.setText("Producto");
        jbProducto.setFocusable(false);
        jbProducto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbProducto.setMaximumSize(new java.awt.Dimension(82, 82));
        jbProducto.setMinimumSize(new java.awt.Dimension(82, 82));
        jbProducto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbProductoActionPerformed(evt);
            }
        });
        jToolBar1.add(jbProducto);

        jbDetalle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/detalles de compras0.5-100x100.png"))); // NOI18N
        jbDetalle.setText("Consultas");
        jbDetalle.setFocusable(false);
        jbDetalle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbDetalle.setMaximumSize(new java.awt.Dimension(82, 82));
        jbDetalle.setMinimumSize(new java.awt.Dimension(82, 82));
        jbDetalle.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDetalleActionPerformed(evt);
            }
        });
        jToolBar1.add(jbDetalle);

        jbSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/salir0.5-100x100.png"))); // NOI18N
        jbSalir.setText("Salir");
        jbSalir.setFocusable(false);
        jbSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbSalir.setMaximumSize(new java.awt.Dimension(82, 82));
        jbSalir.setMinimumSize(new java.awt.Dimension(82, 82));
        jbSalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbSalirMouseClicked(evt);
            }
        });
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });
        jToolBar1.add(jbSalir);

        javax.swing.GroupLayout jdEscritorioLayout = new javax.swing.GroupLayout(jdEscritorio);
        jdEscritorio.setLayout(jdEscritorioLayout);
        jdEscritorioLayout.setHorizontalGroup(
            jdEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jdEscritorioLayout.setVerticalGroup(
            jdEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 757, Short.MAX_VALUE)
        );

        jMenuBar1.add(jMenu1);
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 1287, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jdEscritorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jdEscritorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbComprasActionPerformed
        jdEscritorio.removeAll();
        jdEscritorio.repaint();
        ComprasVista cv = new ComprasVista();
        cv.setVisible(true);
        jdEscritorio.add(cv);
    }//GEN-LAST:event_jbComprasActionPerformed

    private void jbProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbProductoActionPerformed

jdEscritorio.removeAll();
jdEscritorio.repaint();
ProductoVista pv = new ProductoVista();
pv.setVisible(true);
jdEscritorio.add(pv);



    }//GEN-LAST:event_jbProductoActionPerformed

    private void jbSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbSalirMouseClicked
        dispose();
    }//GEN-LAST:event_jbSalirMouseClicked

    private void jbDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDetalleActionPerformed
        jdEscritorio.removeAll();
        jdEscritorio.repaint();
        ConsultasVista dc = new ConsultasVista();
        dc.setVisible(true);
        jdEscritorio.add(dc);
    }//GEN-LAST:event_jbDetalleActionPerformed

    private void jbProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbProveedoresActionPerformed
        jdEscritorio.removeAll();
        jdEscritorio.repaint();
        ProveedorVista pv = new ProveedorVista();
        pv.setVisible(true);
        jdEscritorio.add(pv);
    }//GEN-LAST:event_jbProveedoresActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbSalirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            MenuPrincipal frame = new MenuPrincipal();
            frame.setLocationRelativeTo(null); // Centrar la ventana en la pantalla
            frame.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton jbCompras;
    private javax.swing.JButton jbDetalle;
    private javax.swing.JButton jbProducto;
    private javax.swing.JButton jbProveedores;
    private javax.swing.JButton jbSalir;
    private javax.swing.JPanel jdEscritorio;
    // End of variables declaration//GEN-END:variables
}
