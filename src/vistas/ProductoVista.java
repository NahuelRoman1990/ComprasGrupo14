
package vistas;

import accesoDatos.ProductoData;
import entidades.Producto;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class ProductoVista extends javax.swing.JInternalFrame {

    private ProductoData pd = new ProductoData();
    private DefaultTableModel modelo = new DefaultTableModel();

    
    public ProductoVista() {
        initComponents();
        cargarCabecera();
        cargarProductos();
        setResizable(false);
        jdEscritorio();
        jbEliminar.setToolTipText("<html>Elimina el IDproducto<br>que seleccionaste en<br>ID PRODUCTO</html>");
        jbBuscar.setToolTipText("<html>Ingresa el ID del producto<br> que deseas buscar</html>");
        jbGuardar.setToolTipText("<html>Completa los campos,<br> para agregar un producto<br>(ID Dejar vacio)</html>");
        jbSalir.setToolTipText("Cierra la ventana producto");
        jbModificar.setToolTipText("<html>Busca un ID antes de modificar<br>Completa los datos,<br> presiona modificar</html>");
        jbNuevo.setToolTipText("<html>Limpia los datos,<br> para poder ingresar uno nuevo</html>");
        
        String rutaImagen = "img\\fondo.jpg";
        ImageIcon fondo = new ImageIcon(rutaImagen);
        JLabel label = new JLabel(fondo);
        label.setBounds(0, 0, fondo.getIconWidth(), fondo.getIconHeight());
        jdEscritorioProducto.add(label, new Integer(Integer.MIN_VALUE));
        
    }
    
    private void  jdEscritorio(){
        String rutaImagen = "img\\fondo2.jpg";
        jdEscritorioProducto.setOpaque(false);
        ImageIcon fondo = new ImageIcon(rutaImagen);
        JLabel label = new JLabel(fondo);
        label.setBounds(0, 0, fondo.getIconWidth(), fondo.getIconHeight());
        jdEscritorioProducto.add(label);
    }

    private void cargarCabecera() {
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Descripción");
        modelo.addColumn("Precio");
        modelo.addColumn("Stock");
        jtProducto.setModel(modelo);
        JTableHeader tableHeader = jtProducto.getTableHeader();
        tableHeader.setReorderingAllowed(false);

        jtProducto.getColumnModel().getColumn(0).setPreferredWidth(10);
        jtProducto.getColumnModel().getColumn(0).setResizable(false);
        jtProducto.getColumnModel().getColumn(1).setPreferredWidth(30);
        jtProducto.getColumnModel().getColumn(1).setResizable(false);
        jtProducto.getColumnModel().getColumn(2).setPreferredWidth(40);
        jtProducto.getColumnModel().getColumn(2).setResizable(false);
        jtProducto.getColumnModel().getColumn(3).setPreferredWidth(20);
        jtProducto.getColumnModel().getColumn(3).setResizable(false);
        jtProducto.getColumnModel().getColumn(4).setPreferredWidth(20);
        jtProducto.getColumnModel().getColumn(4).setResizable(false);
        jtProducto.setDefaultEditor(Object.class, null);

    }

    private void borrarFilas() {
        int fila = jtProducto.getRowCount() - 1;
        for (; fila >= 0; fila--) {
            modelo.removeRow(fila);
        }

    }

    private void cargarProductos() {

        borrarFilas();
        List<Producto> listaProductos = pd.listarProducto();
        DecimalFormat formatoDecimal = new DecimalFormat("0.00");
        for (Producto producto : listaProductos) {
            String precioActual = formatoDecimal.format(producto.getPrecioActual());
            modelo.addRow(new Object[]{
                producto.getIdProducto(), 
                producto.getNombreProducto(), 
                producto.getDescripcion(), 
                precioActual, 
                producto.getStock()});

        }
    }

    private void borrarCampos() {
        jtDescripcion.setText("");
        jtPrecio.setText("");
        jtNombre.setText("");
        jtStock.setText("");
        jtIDProducto.setText("");
    }

   
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdEscritorioProducto = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jtIDProducto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtProducto = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtNombre = new javax.swing.JTextField();
        jtDescripcion = new javax.swing.JTextField();
        jtPrecio = new javax.swing.JTextField();
        jtStock = new javax.swing.JTextField();
        jbGuardar = new javax.swing.JButton();
        jbNuevo = new javax.swing.JButton();
        jbBuscar = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jbModificar = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();

        jdEscritorioProducto.setBackground(new java.awt.Color(255, 110, 35));
        jdEscritorioProducto.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ID Producto");

        jtProducto.setModel(new javax.swing.table.DefaultTableModel(
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
        jtProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtProductoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtProducto);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Descripción");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Precio actual");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Stock");

        jtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtPrecioActionPerformed(evt);
            }
        });

        jbGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos de gui/GUARDAR-PRODUCTO1.png"))); // NOI18N
        jbGuardar.setText("Guardar");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        jbNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos de gui/NUEVO-PRODUCTO.png"))); // NOI18N
        jbNuevo.setText("Nuevo");
        jbNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNuevoActionPerformed(evt);
            }
        });

        jbBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos de gui/BUSCAR-PRODUCTO.png"))); // NOI18N
        jbBuscar.setText("Buscar");
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        jbEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos de gui/ELIMINAR-PRODUCTO-32.png"))); // NOI18N
        jbEliminar.setText("Eliminar");
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

        jbModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos de gui/icono-modificar-editar-32px.png"))); // NOI18N
        jbModificar.setText("Modificar");
        jbModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarActionPerformed(evt);
            }
        });

        jbSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos de gui/SALIR-´PRODUCTO1.png"))); // NOI18N
        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        jdEscritorioProducto.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdEscritorioProducto.setLayer(jtIDProducto, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdEscritorioProducto.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdEscritorioProducto.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdEscritorioProducto.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdEscritorioProducto.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdEscritorioProducto.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdEscritorioProducto.setLayer(jtNombre, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdEscritorioProducto.setLayer(jtDescripcion, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdEscritorioProducto.setLayer(jtPrecio, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdEscritorioProducto.setLayer(jtStock, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdEscritorioProducto.setLayer(jbGuardar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdEscritorioProducto.setLayer(jbNuevo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdEscritorioProducto.setLayer(jbBuscar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdEscritorioProducto.setLayer(jbEliminar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdEscritorioProducto.setLayer(jbModificar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdEscritorioProducto.setLayer(jbSalir, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jdEscritorioProductoLayout = new javax.swing.GroupLayout(jdEscritorioProducto);
        jdEscritorioProducto.setLayout(jdEscritorioProductoLayout);
        jdEscritorioProductoLayout.setHorizontalGroup(
            jdEscritorioProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdEscritorioProductoLayout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addGroup(jdEscritorioProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jdEscritorioProductoLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 983, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(jbEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jdEscritorioProductoLayout.createSequentialGroup()
                        .addGroup(jdEscritorioProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jdEscritorioProductoLayout.createSequentialGroup()
                                .addGroup(jdEscritorioProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5))
                                .addGroup(jdEscritorioProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jdEscritorioProductoLayout.createSequentialGroup()
                                        .addGap(53, 53, 53)
                                        .addComponent(jtIDProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jdEscritorioProductoLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jdEscritorioProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jtDescripcion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jtStock, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jtNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jdEscritorioProductoLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(118, 118, 118)
                        .addGroup(jdEscritorioProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jbBuscar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbNuevo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jbModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(477, 477, 477)
                        .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(66, 66, 66))
        );
        jdEscritorioProductoLayout.setVerticalGroup(
            jdEscritorioProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdEscritorioProductoLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jdEscritorioProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtIDProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscar)
                    .addComponent(jbSalir))
                .addGroup(jdEscritorioProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jdEscritorioProductoLayout.createSequentialGroup()
                        .addGroup(jdEscritorioProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jdEscritorioProductoLayout.createSequentialGroup()
                                .addGap(106, 106, 106)
                                .addComponent(jLabel2))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jdEscritorioProductoLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 22, Short.MAX_VALUE)
                        .addGroup(jdEscritorioProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jdEscritorioProductoLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(15, 15, 15))
                            .addGroup(jdEscritorioProductoLayout.createSequentialGroup()
                                .addComponent(jtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(jdEscritorioProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jdEscritorioProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(368, 368, 368))
                    .addGroup(jdEscritorioProductoLayout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(jbNuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jbModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jdEscritorioProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbEliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(129, 129, 129))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdEscritorioProducto, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdEscritorioProducto)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtPrecioActionPerformed

    }//GEN-LAST:event_jtPrecioActionPerformed

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed

        try {
            if (jtIDProducto.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Ingrese el ID del producto. ", "Error                       ", JOptionPane.ERROR_MESSAGE);
                return;
            }
            DecimalFormat formatoDecimal = new DecimalFormat("0.00");
            int id = Integer.parseInt(jtIDProducto.getText());
            Producto producto = pd.buscarProducto(id);
            borrarFilas();
            String precioActual = formatoDecimal.format(producto.getPrecioActual());
            jtDescripcion.setText(producto.getDescripcion());
            jtNombre.setText(producto.getNombreProducto());
            jtPrecio.setText(precioActual);
            jtStock.setText(producto.getStock() + "");

          
            modelo.addRow(new Object[]{
                producto.getIdProducto(), 
                producto.getNombreProducto(), 
                producto.getDescripcion(), 
                precioActual, 
                producto.getStock()
            });
            JOptionPane.showMessageDialog(null, "ID encontrado. ", "Confirmado                 ", JOptionPane.DEFAULT_OPTION);
        } catch (NumberFormatException nf) {
            JOptionPane.showMessageDialog(null, "Ingrese un ID válido. ", "Error                       ", JOptionPane.ERROR_MESSAGE);
            cargarProductos();
        } catch (NullPointerException np) {
            JOptionPane.showMessageDialog(this, "Este articulo  no existe", "Error                       ", JOptionPane.ERROR_MESSAGE);
            cargarProductos();
        }

    
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        try {
            if (jtDescripcion.getText().isEmpty() || jtNombre.getText().isEmpty() || jtPrecio.getText().isEmpty() || jtStock.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "No debe haber campos vacios", "Error                       ", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String nombre = jtNombre.getText();
            String descripcion = jtDescripcion.getText();
            double precio = Double.parseDouble(jtPrecio.getText());
            int stock = Integer.parseInt(jtStock.getText());

            Producto producto = new Producto(nombre, descripcion, precio, stock, true);
            pd.guardarProducto(producto);

            cargarProductos();
            borrarCampos();
            
        } catch (NullPointerException np) {
            JOptionPane.showMessageDialog(this, " ");
        } catch (NumberFormatException nf) {
            JOptionPane.showMessageDialog(this, "Los campos precio y stock deben ser numericos");
        }
       
    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jbNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevoActionPerformed
        borrarCampos();
     
    }//GEN-LAST:event_jbNuevoActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed

        int fila = jtProducto.getSelectedRow();
        if (fila != -1) {
            int idProdu = (Integer) jtProducto.getValueAt(fila, 0);
            pd.eliminarProducto(idProdu);
            borrarCampos();
            borrarFilas();
            cargarProductos();

        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un producto.");
        }

      
    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed
        
        try {
            if (jtIDProducto.getText().isEmpty() || jtDescripcion.getText().isEmpty() || jtNombre.getText().isEmpty() || jtPrecio.getText().isEmpty() || jtStock.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "No debe haber campos vacios", "Error                       ", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int id = Integer.parseInt(jtIDProducto.getText());
            String nombre = jtNombre.getText();
            String descripcion = jtDescripcion.getText();
            double precio = Double.parseDouble(jtPrecio.getText());
            int stock = Integer.parseInt(jtStock.getText());
            Boolean estado = (stock >0);
            Producto producto = new Producto(id, nombre, descripcion, precio, stock, estado);
            pd.modificarProducto(producto);

            cargarProductos();
            borrarCampos();
            
        } catch (NullPointerException np) {
            JOptionPane.showMessageDialog(this, " ");
        } catch (NumberFormatException nf) {
            JOptionPane.showMessageDialog(this, "Los campos precio y stock deben ser numericos");
        }
     
    }//GEN-LAST:event_jbModificarActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        dispose();
        
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jtProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtProductoMouseClicked
       int fila = jtProducto.getSelectedRow();
         if (fila != -1) {
            int idProdu = (Integer) jtProducto.getValueAt(fila, 0);
            Producto producto = pd.buscarProducto(idProdu);
            jtDescripcion.setText(producto.getDescripcion());
            jtNombre.setText(producto.getNombreProducto());
            jtIDProducto.setText(producto.getIdProducto()+"");
            jtPrecio.setText(producto.getPrecioActual()+"");
            jtStock.setText(producto.getStock()+"");
          

        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un producto.");
        }
    }//GEN-LAST:event_jtProductoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbModificar;
    private javax.swing.JButton jbNuevo;
    private javax.swing.JButton jbSalir;
    private javax.swing.JDesktopPane jdEscritorioProducto;
    private javax.swing.JTextField jtDescripcion;
    private javax.swing.JTextField jtIDProducto;
    private javax.swing.JTextField jtNombre;
    private javax.swing.JTextField jtPrecio;
    private javax.swing.JTable jtProducto;
    private javax.swing.JTextField jtStock;
    // End of variables declaration//GEN-END:variables
}
