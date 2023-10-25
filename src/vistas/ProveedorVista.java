/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import accesoDatos.ProveedorData;
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
        cargarCombo();
        setResizable(false);
        String rutaImagen = "img\\fondo2.jpg";
        ImageIcon fondo = new ImageIcon(rutaImagen);
        JLabel label = new JLabel(fondo);
        label.setBounds(0, 0, fondo.getIconWidth(), fondo.getIconHeight());
        jpProveedores.add(label, new Integer(Integer.MIN_VALUE));
    }

    private void cargarCombo(){
        jcActivoInActivo.addItem("Activo");
        jcActivoInActivo.addItem("Inactivo");
        jcActivoInActivo.addItem("Todos");
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

    private void borrarCampos() {
        jtDomicilio.setText("");
        jtIdProveedor.setText("");
        jtRazonSocial.setText("");
        jtTelefono.setText("");
        jrbActivo.setSelected(false);
        jrbInActivo.setSelected(false);
    }

    private void cargarProveedor() {

        borrarFilas();
        List<Proveedor> listaProveedores = pd.listarProveedores();
        String estado = null;
        for (Proveedor proveedor : listaProveedores) {
            if (proveedor.isEstado()) {
                estado = "Activo";
            }else {
                estado = "Inactivo";
            }
            modelo.addRow(new Object[]{proveedor.getIdProveedor(), proveedor.getRazonSocial(), proveedor.getDomicilio(), proveedor.getTelefono(), estado});

        }
    }
    
    private void cargarProveedorActivo() {

        borrarFilas();
        List<Proveedor> listaProveedores = pd.listarProveedoresActivo();
        String estado = null;
        for (Proveedor proveedor : listaProveedores) {
            if (proveedor.isEstado()) {
                estado = "Activo";
            }else {
                estado = "Inactivo";
            }
            modelo.addRow(new Object[]{proveedor.getIdProveedor(), proveedor.getRazonSocial(), proveedor.getDomicilio(), proveedor.getTelefono(), estado});

        }
    }

    private void cargarProveedorInactivo() {

        borrarFilas();
        List<Proveedor> listaProveedores = pd.listarProveedoresInactivo();
        String estado = null;
        for (Proveedor proveedor : listaProveedores) {
            if (proveedor.isEstado()) {
                estado = "Activo";
            }else {
                estado = "Inactivo";
            }
            modelo.addRow(new Object[]{proveedor.getIdProveedor(), proveedor.getRazonSocial(), proveedor.getDomicilio(), proveedor.getTelefono(), estado});

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
        jbBuscar = new javax.swing.JButton();
        jbModificar = new javax.swing.JButton();
        jcActivoInActivo = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
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
        jtProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtProveedorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtProveedor);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ID Proveedor");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Razon Social");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Domicilio");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
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
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

        jbNuevo.setText("Nuevo");
        jbNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNuevoActionPerformed(evt);
            }
        });

        jbBuscar.setText("Buscar");
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        jbModificar.setText("Modificar");
        jbModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarActionPerformed(evt);
            }
        });

        jcActivoInActivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcActivoInActivoActionPerformed(evt);
            }
        });

        jLabel6.setText("Seleccione Lista");

        javax.swing.GroupLayout jpProveedoresLayout = new javax.swing.GroupLayout(jpProveedores);
        jpProveedores.setLayout(jpProveedoresLayout);
        jpProveedoresLayout.setHorizontalGroup(
            jpProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpProveedoresLayout.createSequentialGroup()
                .addContainerGap(111, Short.MAX_VALUE)
                .addGroup(jpProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(jpProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jrbActivo, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)))
                .addGap(42, 42, 42)
                .addGroup(jpProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpProveedoresLayout.createSequentialGroup()
                        .addGroup(jpProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jtDomicilio)
                                .addComponent(jtTelefono, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jtRazonSocial, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jrbInActivo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpProveedoresLayout.createSequentialGroup()
                        .addComponent(jtIdProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 653, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcActivoInActivo, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
            .addGroup(jpProveedoresLayout.createSequentialGroup()
                .addGroup(jpProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpProveedoresLayout.createSequentialGroup()
                        .addGap(431, 431, 431)
                        .addComponent(jLabel2))
                    .addGroup(jpProveedoresLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jbGuardar)
                        .addGap(18, 18, 18)
                        .addComponent(jbEliminar)
                        .addGap(18, 18, 18)
                        .addComponent(jbNuevo)
                        .addGap(18, 18, 18)
                        .addComponent(jbModificar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpProveedoresLayout.setVerticalGroup(
            jpProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpProveedoresLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addGap(104, 104, 104)
                .addGroup(jpProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpProveedoresLayout.createSequentialGroup()
                        .addGroup(jpProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jtIdProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbBuscar))
                        .addGap(60, 60, 60)
                        .addGroup(jpProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jtRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jpProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jtDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jpProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(68, 68, 68)
                        .addGroup(jpProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jrbInActivo)
                            .addComponent(jrbActivo))
                        .addGap(52, 52, 52)
                        .addGroup(jpProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbGuardar)
                            .addComponent(jbEliminar)
                            .addComponent(jbNuevo)
                            .addComponent(jbModificar))
                        .addGap(44, 69, Short.MAX_VALUE))
                    .addGroup(jpProveedoresLayout.createSequentialGroup()
                        .addGroup(jpProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpProveedoresLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcActivoInActivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed

        try {
            if (jtIdProveedor.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Ingrese el ID del proveedor. ", "Error                       ", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int id = Integer.parseInt(jtIdProveedor.getText());
            Proveedor proveedor = pd.buscarProveedores(id);

            jtRazonSocial.setText(proveedor.getRazonSocial());
            jtDomicilio.setText(proveedor.getDomicilio());
            jtTelefono.setText(proveedor.getTelefono() + "");
            jrbActivo.setSelected(proveedor.isEstado());
            jrbInActivo.setSelected(!proveedor.isEstado());

            borrarFilas();
            modelo.addRow(new Object[]{proveedor.getIdProveedor(), proveedor.getRazonSocial(), proveedor.getDomicilio(), proveedor.getTelefono(), proveedor.isEstado()});
            JOptionPane.showMessageDialog(null, "ID encontrado. ", "Confirmado                 ", JOptionPane.DEFAULT_OPTION);

        } catch (NumberFormatException nf) {
            JOptionPane.showMessageDialog(null, "Ingrese un ID válido. ", "Error                       ", JOptionPane.ERROR_MESSAGE);
            cargarProveedor();
        } catch (NullPointerException np) {
            JOptionPane.showMessageDialog(this, "Este proveedor no existe", "Error                       ", JOptionPane.ERROR_MESSAGE);
            cargarProveedor();
        }
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        try {
            if (jtRazonSocial.getText().isEmpty() || jtDomicilio.getText().isEmpty() || jtTelefono.getText().isEmpty() || (!jrbActivo.isSelected() && !jrbInActivo.isSelected())) {
                JOptionPane.showMessageDialog(null, "No debe haber campos vacios", "Error                       ", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String razonSocial = jtRazonSocial.getText();
            String domicilio = jtDomicilio.getText();
            String telefono = jtTelefono.getText();
            boolean estado = jrbActivo.isSelected();

            Proveedor proveedor = new Proveedor(razonSocial, domicilio, telefono, estado);
            pd.guardarProveedor(proveedor);

            cargarProveedor();
            borrarCampos();
            ///editableOno();

        } catch (NullPointerException np) {
            JOptionPane.showMessageDialog(this, " ");
        } catch (NumberFormatException nf) {
            JOptionPane.showMessageDialog(this, " ");
        }

    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jbNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevoActionPerformed
        borrarCampos();        // TODO add your handling code here:
        cargarProveedor();
    }//GEN-LAST:event_jbNuevoActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        // TODO add your handling code here:
          int fila = jtProveedor.getSelectedRow();
        if (fila != -1) {
            int idProveedor = (Integer) jtProveedor.getValueAt(fila, 0);
            pd.eliminarProveedor(idProveedor);
            borrarCampos();
            borrarFilas();
            cargarProveedor();

        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un proveedor en la tabla.");
        }
    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed
        // TODO add your handling code here:
        try {
            if (jtIdProveedor.getText().isEmpty() || jtDomicilio.getText().isEmpty() || jtRazonSocial.getText().isEmpty() || jtTelefono.getText().isEmpty()|| (!jrbActivo.isSelected() && !jrbInActivo.isSelected())) {
                JOptionPane.showMessageDialog(null, "No debe haber campos vacios", "Error                       ", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int id = Integer.parseInt(jtIdProveedor.getText());
            String razonSocial = jtRazonSocial.getText();
            String telefono = jtTelefono.getText();
            String domicilio = jtDomicilio.getText();
            boolean estado =jrbActivo.isSelected();
            
            
                 Proveedor proveedor = new Proveedor(id,razonSocial, domicilio, telefono, estado);
            pd.modificarProveedor(proveedor);

            cargarProveedor();
            borrarCampos();
            
        } catch (NullPointerException np) {
            JOptionPane.showMessageDialog(this, " ");
        }
    }//GEN-LAST:event_jbModificarActionPerformed

    private void jtProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtProveedorMouseClicked
        // TODO add your handling code here:
        int fila = jtProveedor.getSelectedRow();
         if (fila != -1) {
            int idProveedor = (Integer) jtProveedor.getValueAt(fila, 0);
            Proveedor proveedor = pd.buscarProveedores(idProveedor);
            jtIdProveedor.setText(proveedor.getIdProveedor()+"");
            jtRazonSocial.setText(proveedor.getRazonSocial());
            jtDomicilio.setText(proveedor.getDomicilio());
            jtTelefono.setText(proveedor.getTelefono());
            jrbActivo.setSelected(proveedor.isEstado());
            jrbInActivo.setSelected(!proveedor.isEstado());

        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un proveedor en la tabla.");
        }
     
    }//GEN-LAST:event_jtProveedorMouseClicked

    private void jcActivoInActivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcActivoInActivoActionPerformed
        jcActivoInActivo.getSelectedItem();
        if (jcActivoInActivo.getSelectedItem()=="Activo") {
            pd.listarProveedoresActivo();
            cargarProveedorActivo();
            
        }else if (jcActivoInActivo.getSelectedItem()=="Inactivo") {
            pd.listarProveedoresInactivo();
            cargarProveedorInactivo();
        }else if (jcActivoInActivo.getSelectedItem()=="Todos") {
            pd.listarProveedores();
            cargarProveedor();
        }
{
            
        }
    }//GEN-LAST:event_jcActivoInActivoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbModificar;
    private javax.swing.JButton jbNuevo;
    private javax.swing.JComboBox<String> jcActivoInActivo;
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
