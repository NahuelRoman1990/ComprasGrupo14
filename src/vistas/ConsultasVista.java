/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import accesoDatos.CompraData;
import accesoDatos.ProductoData;
import accesoDatos.ProveedorData;
import com.sun.xml.internal.messaging.saaj.packaging.mime.Header;
import entidades.Producto;
import entidades.Proveedor;
import java.sql.Connection;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.plaf.TableHeaderUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

/**
 *
 * @author roman
 */
public class ConsultasVista extends javax.swing.JInternalFrame {

    private Connection con = null;
    private ProveedorData prd = new ProveedorData();
    private ProductoData pd = new ProductoData();
    private CompraData cd = new CompraData();
    private DefaultTableModel modelo = new DefaultTableModel();
    private DefaultTableModel modelo1 = new DefaultTableModel();
    private conboBoxMix<String> comboBox;

    public ConsultasVista() {
        initComponents();
        jtConsultas.setVisible(false);
        jdcDesde.setVisible(false);
        jdcHasta.setVisible(false);
        jcbSelectProveedoroProducto.setVisible(false);
        String rutaImagen = "img\\fondo.jpg";
        ImageIcon fondo = new ImageIcon(rutaImagen);
        JLabel label = new JLabel(fondo);
        label.setBounds(0, 0, fondo.getIconWidth(), fondo.getIconHeight());
        jpEscritorio.add(label, new Integer(Integer.MIN_VALUE));
    }

    private void comboProveedor() {
        List<Proveedor> proveedor = prd.listarProveedores();

        for (Proveedor proveedores : proveedor) {
            jcbSelectProveedoroProducto.addItem(proveedores.getRazonSocial());
        }
    }

    private void comboProducto() {
        List<Producto> producto = pd.listarProducto();

        for (Producto productos : producto) {
            jcbSelectProveedoroProducto.addItem(productos.getNombreProducto());

        }
    }
//    private void cargarCabeceraCompraProveedor() {
//        modelo1.addColumn("ID Compra");
//        modelo1.addColumn("Proveedor");
//        modelo1.addColumn("Producto");
//        modelo1.addColumn("Cantidad");
//        modelo1.addColumn("Costo Total");
//        jtConsultas.setModel(modelo1);
//        JTableHeader tableHeader = jtConsultas.getTableHeader();
//        tableHeader.setReorderingAllowed(false);
//
//        jtConsultas.getColumnModel().getColumn(0).setPreferredWidth(20);
//        jtConsultas.getColumnModel().getColumn(0).setResizable(false);
//        jtConsultas.getColumnModel().getColumn(1).setPreferredWidth(20);
//        jtConsultas.getColumnModel().getColumn(1).setResizable(false);
//        jtConsultas.getColumnModel().getColumn(2).setPreferredWidth(20);
//        jtConsultas.getColumnModel().getColumn(2).setResizable(false);
//        jtConsultas.getColumnModel().getColumn(3).setPreferredWidth(20);
//        jtConsultas.getColumnModel().getColumn(3).setResizable(false);
//        jtConsultas.getColumnModel().getColumn(4).setPreferredWidth(20);
//        jtConsultas.getColumnModel().getColumn(4).setResizable(false);
//        jtConsultas.setDefaultEditor(Object.class, null);
//
//    }
//    private void cargarCabeceraProducto() {
//        modelo.addColumn("ID");
//        modelo.addColumn("Nombre");
//        modelo.addColumn("Descripción");
//        modelo.addColumn("Precio");
//        modelo.addColumn("Stock");
//        jtConsultas.setModel(modelo);
//        JTableHeader tableHeader = jtConsultas.getTableHeader();
//        tableHeader.setReorderingAllowed(false);
//
//        jtConsultas.getColumnModel().getColumn(0).setPreferredWidth(10);
//        jtConsultas.getColumnModel().getColumn(0).setResizable(false);
//        jtConsultas.getColumnModel().getColumn(1).setPreferredWidth(30);
//        jtConsultas.getColumnModel().getColumn(1).setResizable(false);
//        jtConsultas.getColumnModel().getColumn(2).setPreferredWidth(40);
//        jtConsultas.getColumnModel().getColumn(2).setResizable(false);
//        jtConsultas.getColumnModel().getColumn(3).setPreferredWidth(20);
//        jtConsultas.getColumnModel().getColumn(3).setResizable(false);
//        jtConsultas.getColumnModel().getColumn(4).setPreferredWidth(20);
//        jtConsultas.getColumnModel().getColumn(4).setResizable(false);
//        jtConsultas.setDefaultEditor(Object.class, null);
//
//    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpEscritorio = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtConsultas = new javax.swing.JTable();
        jbSalir = new javax.swing.JButton();
        jlIdDetalle = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jbBuscar = new javax.swing.JButton();
        jcbConsulta = new javax.swing.JComboBox<>();
        jbCargar = new javax.swing.JButton();
        jdcDesde = new com.toedter.calendar.JDateChooser();
        jdcHasta = new com.toedter.calendar.JDateChooser();
        jcbSelectProveedoroProducto = new javax.swing.JComboBox<>();

        jtConsultas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "CONSULTA", "CONSULTA", "CONSULTA", "CONSULTA", "CONSULTA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtConsultas);

        jbSalir.setText("SALIR");
        jbSalir.setMaximumSize(new java.awt.Dimension(74, 36));
        jbSalir.setMinimumSize(new java.awt.Dimension(74, 36));
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        jlIdDetalle.setText("FORMATO DE BUSQUEDA:");

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        jLabel1.setText("CONSULTAS");

        jbBuscar.setText("BUSCAR");
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        jcbConsulta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Productos/Fecha", "Compras/Proveedor", "Productos/Compra", "Productos/MasComprado", " " }));
        jcbConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbConsultaActionPerformed(evt);
            }
        });

        jbCargar.setText("CARGAR");
        jbCargar.setMaximumSize(new java.awt.Dimension(74, 36));
        jbCargar.setMinimumSize(new java.awt.Dimension(74, 36));

        javax.swing.GroupLayout jpEscritorioLayout = new javax.swing.GroupLayout(jpEscritorio);
        jpEscritorio.setLayout(jpEscritorioLayout);
        jpEscritorioLayout.setHorizontalGroup(
            jpEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpEscritorioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(519, 519, 519))
            .addGroup(jpEscritorioLayout.createSequentialGroup()
                .addGap(197, 197, 197)
                .addGroup(jpEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpEscritorioLayout.createSequentialGroup()
                        .addComponent(jlIdDetalle)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jpEscritorioLayout.createSequentialGroup()
                        .addGroup(jpEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jpEscritorioLayout.createSequentialGroup()
                                .addGroup(jpEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jcbConsulta, 0, 217, Short.MAX_VALUE)
                                    .addComponent(jdcDesde, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jdcHasta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jcbSelectProveedoroProducto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jpEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jbCargar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jbBuscar)
                                    .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 871, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(197, Short.MAX_VALUE))))
        );
        jpEscritorioLayout.setVerticalGroup(
            jpEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpEscritorioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(jlIdDetalle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbBuscar)
                    .addComponent(jcbConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpEscritorioLayout.createSequentialGroup()
                        .addComponent(jbCargar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpEscritorioLayout.createSequentialGroup()
                        .addComponent(jcbSelectProveedoroProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jdcDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jdcHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpEscritorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpEscritorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jcbConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbConsultaActionPerformed
        String seleccion = (String) jcbConsulta.getSelectedItem();
        DefaultTableModel emptyModel = new DefaultTableModel();
        JTableHeader tableHeader = jtConsultas.getTableHeader();
        JTableHeader header = jtConsultas.getTableHeader();
        TableColumn primeraColum = header.getColumnModel().getColumn(0);
        TableColumn segundaColum = header.getColumnModel().getColumn(1);
        TableColumn terceraColum = header.getColumnModel().getColumn(2);
        TableColumn cuartaColum = header.getColumnModel().getColumn(3);
        TableColumn quintaColum = header.getColumnModel().getColumn(4);

        if (seleccion.equals("Productos/Fecha")) {
            jcbSelectProveedoroProducto.setVisible(false);
            jdcDesde.setVisible(true);
            jdcHasta.setVisible(true);
            tableHeader.setVisible(false);
            primeraColum.setHeaderValue("FECHA");
            segundaColum.setHeaderValue("ID");
            terceraColum.setHeaderValue("NOMBRE");
            cuartaColum.setHeaderValue("CANTIDAD");
            quintaColum.setHeaderValue("PRECIO C/U");
            tableHeader.setVisible(true);

        } else if (seleccion.equals("Compras/Proveedor")) {
            jdcDesde.setVisible(false);
            jdcHasta.setVisible(false);
            jcbSelectProveedoroProducto.setVisible(true);
            jcbSelectProveedoroProducto.removeAllItems();
            comboProveedor();
            tableHeader.setVisible(false);
            primeraColum.setHeaderValue("ID COMPRA");
            segundaColum.setHeaderValue("PROVEEDOR");
            terceraColum.setHeaderValue("PRODUCTO");
            cuartaColum.setHeaderValue("CANTIDAD");
            quintaColum.setHeaderValue("TOTAL COSTO");

            tableHeader.setVisible(true);
        } else if (seleccion.equals("Productos/Compra")) {
            jdcDesde.setVisible(false);
            jdcHasta.setVisible(false);
            jcbSelectProveedoroProducto.setVisible(true);
            jcbSelectProveedoroProducto.removeAllItems();
            comboProducto();
            tableHeader.setVisible(false);
            primeraColum.setHeaderValue("ID COMPRA");
            segundaColum.setHeaderValue("PRODUCTO");
            terceraColum.setHeaderValue("CANTIDAD");
            cuartaColum.setHeaderValue("PRECIO UNITARIO");
            quintaColum.setHeaderValue("PRECIO TOTAL");
            tableHeader.setVisible(true);

        } else {
            // Si no es ninguna de las opciones anteriores, oculta los componentes
            jdcDesde.setVisible(false);
            jdcHasta.setVisible(false);
            jcbSelectProveedoroProducto.setVisible(false);
            // Limpia la tabla y la cabecera

        }

    }//GEN-LAST:event_jcbConsultaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbCargar;
    private javax.swing.JButton jbSalir;
    private javax.swing.JComboBox<String> jcbConsulta;
    private javax.swing.JComboBox<String> jcbSelectProveedoroProducto;
    private com.toedter.calendar.JDateChooser jdcDesde;
    private com.toedter.calendar.JDateChooser jdcHasta;
    private javax.swing.JLabel jlIdDetalle;
    private javax.swing.JPanel jpEscritorio;
    private javax.swing.JTable jtConsultas;
    // End of variables declaration//GEN-END:variables
}
