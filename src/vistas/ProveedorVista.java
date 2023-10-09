/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import accesoDatos.ProveedorData;
import entidades.Producto;
import entidades.Proveedor;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author roman
 */
public class ProveedorVista extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo = new DefaultTableModel();
    private ProveedorData pd = new ProveedorData();

    public ProveedorVista() {
        initComponents();
        cargarCabecera();
        cargarProveedor();
        String rutaImagen = "img\\fondo.jpg";
        ImageIcon fondo = new ImageIcon(rutaImagen);
        JLabel label = new JLabel(fondo);
        label.setBounds(0, 0, fondo.getIconWidth(), fondo.getIconHeight());
        jpProveedores.add(label, new Integer(Integer.MIN_VALUE));
    }

    private void cargarCabecera() {
        modelo.addColumn("ID Proveedor");
        modelo.addColumn("Razon Social");
        modelo.addColumn("Domicilio");
        modelo.addColumn("Telefono");
        modelo.addColumn("Estado");
        jtProveedor.setModel(modelo);
        JTableHeader tableHeader = jtProveedor.getTableHeader();
        tableHeader.setReorderingAllowed(false);

        jtProveedor.getColumnModel().getColumn(0).setPreferredWidth(10);
        jtProveedor.getColumnModel().getColumn(0).setResizable(false);
        jtProveedor.getColumnModel().getColumn(1).setPreferredWidth(30);
        jtProveedor.getColumnModel().getColumn(1).setResizable(false);
        jtProveedor.getColumnModel().getColumn(2).setPreferredWidth(40);
        jtProveedor.getColumnModel().getColumn(2).setResizable(false);
        jtProveedor.getColumnModel().getColumn(3).setPreferredWidth(20);
        jtProveedor.getColumnModel().getColumn(3).setResizable(false);
        jtProveedor.getColumnModel().getColumn(4).setPreferredWidth(20);
        jtProveedor.getColumnModel().getColumn(4).setResizable(false);
        jtProveedor.setDefaultEditor(Object.class, null);

    }

    private void borrarFilas() {
        int fila = jtProveedor.getRowCount() - 1;
        for (; fila >= 0; fila--) {
            modelo.removeRow(fila);
        }

    }

    private void cargarProveedor() {

        borrarFilas();
        List<Proveedor> listaProveedores = pd.listarProveedores();
        for (Proveedor proveedor : listaProveedores) {
            modelo.addRow(new Object[]{proveedor.getIdProveedor(), proveedor.getRazonSocial(), proveedor.getDomicilio(), proveedor.getTelefono(), proveedor.isEstado()});

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jpProveedores = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtProveedor = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jrbActivo = new javax.swing.JRadioButton();
        jrbInActivo = new javax.swing.JRadioButton();
        jtIdProveedor = new javax.swing.JTextField();
        jtRazonSocial = new javax.swing.JTextField();
        jtDomicilio = new javax.swing.JTextField();
        jtTelefono = new javax.swing.JTextField();
        jbGuardar = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jbNuevo = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jbModificar = new javax.swing.JButton();

        jLabel2.setFont(new java.awt.Font("Arial Black", 2, 48)); // NOI18N
        jLabel2.setText("PROVEEDORES");

        jtProveedor.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtProveedor);

        jLabel1.setText("ID Proveedor");

        jLabel3.setText("Razon Social");

        jLabel4.setText("Domicilio");

        jLabel5.setText("Telefono");

        jrbActivo.setText("Activo");
        jrbActivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbActivoActionPerformed(evt);
            }
        });

        jrbInActivo.setText("Inactivo");
        jrbInActivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbInActivoActionPerformed(evt);
            }
        });

        jbGuardar.setText("Guardar");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        jbEliminar.setText("Eliminar");

        jbNuevo.setText("Nuevo");

        jButton4.setText("Buscar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jbModificar.setText("Modificar");

        javax.swing.GroupLayout jpProveedoresLayout = new javax.swing.GroupLayout(jpProveedores);
        jpProveedores.setLayout(jpProveedoresLayout);
        jpProveedoresLayout.setHorizontalGroup(
            jpProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpProveedoresLayout.createSequentialGroup()
                .addGroup(jpProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpProveedoresLayout.createSequentialGroup()
                        .addGroup(jpProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpProveedoresLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(jpProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jpProveedoresLayout.createSequentialGroup()
                                        .addGroup(jpProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addGap(41, 41, 41)
                                        .addGroup(jpProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jpProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jtIdProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                                .addComponent(jtDomicilio)
                                                .addComponent(jtTelefono))
                                            .addComponent(jtRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jpProveedoresLayout.createSequentialGroup()
                                        .addComponent(jbGuardar)
                                        .addGap(30, 30, 30)
                                        .addComponent(jbEliminar)
                                        .addGap(30, 30, 30)
                                        .addComponent(jbNuevo)
                                        .addGap(25, 25, 25))))
                            .addGroup(jpProveedoresLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(jpProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jrbInActivo)
                                    .addComponent(jrbActivo))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 272, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 653, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpProveedoresLayout.createSequentialGroup()
                        .addGroup(jpProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpProveedoresLayout.createSequentialGroup()
                                .addGap(431, 431, 431)
                                .addComponent(jLabel2))
                            .addGroup(jpProveedoresLayout.createSequentialGroup()
                                .addGap(173, 173, 173)
                                .addComponent(jButton4)
                                .addGap(18, 18, 18)
                                .addComponent(jbModificar)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jpProveedoresLayout.setVerticalGroup(
            jpProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpProveedoresLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addGroup(jpProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpProveedoresLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpProveedoresLayout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addGroup(jpProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4)
                            .addComponent(jbModificar))
                        .addGap(38, 38, 38)
                        .addGroup(jpProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jpProveedoresLayout.createSequentialGroup()
                                .addGroup(jpProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(jtIdProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)
                                .addGroup(jpProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(jtRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)
                                .addGroup(jpProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jtDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)
                                .addComponent(jLabel5))
                            .addComponent(jtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addComponent(jrbActivo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jrbInActivo)
                        .addGap(26, 26, 26)
                        .addGroup(jpProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbGuardar)
                            .addComponent(jbEliminar)
                            .addComponent(jbNuevo))
                        .addGap(0, 24, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpProveedores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpProveedores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jrbActivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbActivoActionPerformed
        jrbInActivo.setSelected(false);
        jrbActivo.setSelected(true);
    }//GEN-LAST:event_jrbActivoActionPerformed

    private void jrbInActivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbInActivoActionPerformed
        jrbActivo.setSelected(false);
        jrbInActivo.setSelected(true);
    }//GEN-LAST:event_jrbInActivoActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        try {
            if (jtIdProveedor.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Ingrese el ID del proveedor. ", "Error                       ", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int id = Integer.parseInt(jtIdProveedor.getText());
            Proveedor proveedor = pd.buscarProveedores(id);
            borrarFilas();
            jtRazonSocial.setText(proveedor.getRazonSocial());
            jtDomicilio.setText(proveedor.getDomicilio());
            jtTelefono.setText(proveedor.getTelefono() + "");
            modelo.addRow(new Object[]{proveedor.getIdProveedor(), proveedor.getRazonSocial(), proveedor.getDomicilio(), proveedor.getTelefono(), proveedor.isEstado()});
            JOptionPane.showMessageDialog(null, "ID encontrado. ", "Confirmado                 ", JOptionPane.DEFAULT_OPTION);
        } catch (NumberFormatException nf) {
            JOptionPane.showMessageDialog(null, "Ingrese un ID válido. ", "Error                       ", JOptionPane.ERROR_MESSAGE);
            cargarProveedor();
        } catch (NullPointerException np) {
            JOptionPane.showMessageDialog(this, "Este articulo  no existe", "Error                       ", JOptionPane.ERROR_MESSAGE);
            cargarProveedor();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
          try {
            if (jtRazonSocial.getText().isEmpty() || jtDomicilio.getText().isEmpty() || jtTelefono.getText().isEmpty() || jtStock.getText().isEmpty()) {
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
            ///editableOno();

        } catch (NullPointerException np) {
            JOptionPane.showMessageDialog(this, " ");
        } catch (NumberFormatException nf) {
            JOptionPane.showMessageDialog(this, "Los campos precio y stock deben ser numericos");
        }
       
    }//GEN-LAST:event_jbGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbModificar;
    private javax.swing.JButton jbNuevo;
    private javax.swing.JPanel jpProveedores;
    private javax.swing.JRadioButton jrbActivo;
    private javax.swing.JRadioButton jrbInActivo;
    private javax.swing.JTextField jtDomicilio;
    private javax.swing.JTextField jtIdProveedor;
    private javax.swing.JTable jtProveedor;
    private javax.swing.JTextField jtRazonSocial;
    private javax.swing.JTextField jtTelefono;
    // End of variables declaration//GEN-END:variables
}
