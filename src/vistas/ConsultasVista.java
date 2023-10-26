package vistas;

import accesoDatos.CompraData;
import accesoDatos.DetalleCompraData;
import accesoDatos.ProductoData;
import accesoDatos.ProveedorData;

import entidades.Compra;
import entidades.DetalleCompra;
import entidades.Producto;
import entidades.Proveedor;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

public class ConsultasVista extends javax.swing.JInternalFrame {

    private DetalleCompraData dcd = new DetalleCompraData();
    private ProveedorData prd = new ProveedorData();
    private ProductoData pd = new ProductoData();
    private CompraData cd = new CompraData();

    public ConsultasVista() {
        initComponents();
        jtIdCompra.setVisible(false);
        jlIngreseIdCompra.setVisible(false);
        jdcFechaSelect.setVisible(false);
        jcbSelectProveedoroProducto.setVisible(false);
        String rutaImagen = "img\\fondo2.jpg";
        ImageIcon fondo = new ImageIcon(rutaImagen);
        JLabel label = new JLabel(fondo);
        label.setBounds(0, 0, fondo.getIconWidth(), fondo.getIconHeight());
        jpEscritorio.add(label, new Integer(Integer.MIN_VALUE));
        setResizable(false);
        jbCargar.setToolTipText("<html>Refresca los datos <br> cargados en la tabla<br>(Segun la eleccion busqueda)</html>");
        jbSalir.setToolTipText("Cierra la ventana consulta");

    }

    private void comboProveedor() {
        List<Proveedor> proveedor = prd.listarProveedores();

        for (Proveedor proveedores : proveedor) {
            jcbSelectProveedoroProducto.addItem(proveedores);
        }
    }


    private void listarDetallesFecha() {
        java.util.Date fechaSeleccionada = jdcFechaSelect.getDate();
        DefaultTableModel modelo = (DefaultTableModel) jtConsultas.getModel();

        if (fechaSeleccionada != null) {
            java.time.LocalDate fechaLocal = fechaSeleccionada.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            List<Compra> comprasPorFecha = cd.buscarCompraPorFecha(fechaLocal);
            List<DetalleCompra> todosLosDetalles = new ArrayList<>();
            modelo.setRowCount(0);

            for (Compra compra : comprasPorFecha) {
                int idCompra = compra.getIdCompra();
                List<DetalleCompra> detallesCompra = dcd.listarDetalleCompras(idCompra);
                todosLosDetalles.addAll(detallesCompra);
            }

            for (DetalleCompra detalle : todosLosDetalles) {
                jtConsultas.setModel(modelo);
                {
                    modelo.addRow(new Object[]{
                        fechaLocal,
                        detalle.getIdDetalle(),
                        detalle.getProducto().getNombreProducto(),
                        detalle.getCantidad(),
                        detalle.getPrecioCosto(),});

                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "LA FECHA SELECCIONADA NO TIENE COMPRAS REALIZADAS");
        }
    }

    private void comprasAunProveedor() {

        Proveedor proveedor = (Proveedor) jcbSelectProveedoroProducto.getSelectedItem();

        int proveedorSelect = proveedor.getIdProveedor();
        DefaultTableModel modelo = (DefaultTableModel) jtConsultas.getModel();
        if (proveedorSelect != -1) {

            List<Compra> comprasProveedor = cd.buscarComprasPorProveedor(proveedorSelect);
            List<DetalleCompra> todosLosDetalles = new ArrayList<>();
            modelo.setRowCount(0);

            for (Compra compra : comprasProveedor) {
                int idCompra = compra.getIdCompra();
                List<DetalleCompra> detallesCompra = dcd.listarDetalleCompras(idCompra);
                todosLosDetalles.addAll(detallesCompra);
                for (DetalleCompra detalle : todosLosDetalles) {
                    String producto = detalle.getProducto().getNombreProducto();
                    int cantidad = detalle.getCantidad();
                    double totalCosto = cantidad * detalle.getPrecioCosto();

                    modelo.addRow(new Object[]{
                        idCompra,
                        proveedor,
                        producto,
                        cantidad,
                        totalCosto
                    });

                }

            }
        } else {
            JOptionPane.showMessageDialog(this, "SELECCIONE UN PROVEEDOR CON COMPRAS");
        }

    }

    private void productosPorCompra() {

        try {

            int idCompra = Integer.parseInt(jtIdCompra.getText());
            DefaultTableModel modelo = (DefaultTableModel) jtConsultas.getModel();
            List<DetalleCompra> todosLosDetalles = dcd.listarDetalleCompras(idCompra);
            modelo.setRowCount(0);

            for (DetalleCompra detalle : todosLosDetalles) {
                String producto = detalle.getProducto().getNombreProducto();
                int cantidad = detalle.getCantidad();
                double costoUnidad = detalle.getPrecioCosto();
                double totalCosto = cantidad * detalle.getPrecioCosto();

                modelo.addRow(new Object[]{
                    idCompra,
                    producto,
                    cantidad,
                    costoUnidad,
                    totalCosto
                });
            }
        } catch (NullPointerException np) {
            JOptionPane.showMessageDialog(this, "No hay productos para el ID de compra ingresado");

        } catch (NumberFormatException nf) {
            JOptionPane.showMessageDialog(this, "Ingrese una ID de compra válido");
        }
    }

    private void productoMasComprado() {

        List<DetalleCompra> todosLosDetalles = dcd.listarDetalles();
        List<Producto> todosLosProductos = pd.listarProducto();
        DefaultTableModel modelo = (DefaultTableModel) jtConsultas.getModel();
        modelo.setRowCount(0);
        Map<Integer, Integer> mapa = new TreeMap<>();
        int cantidad;

        for (Producto producto : todosLosProductos) {
            int idProducto = producto.getIdProducto();
            cantidad = 0;

            for (DetalleCompra detalle : todosLosDetalles) {
                if (idProducto == detalle.getProducto().getIdProducto()) {

                    cantidad += detalle.getCantidad();
                    mapa.put(idProducto, cantidad);
                }
            }
        }

        Comparator<Integer> comparadorPorValor = new Comparator<Integer>() {
            @Override
            public int compare(Integer clave2, Integer clave1) {
               return mapa.get(clave1).compareTo(mapa.get(clave2));
            }
        };

        Map<Integer, Integer> mapaOrdenado = new TreeMap<>(comparadorPorValor);
        mapaOrdenado.putAll(mapa);

        for (Map.Entry<Integer, Integer> entry : mapaOrdenado.entrySet()) {

            Producto producto = pd.buscarProducto(entry.getKey());
            String Nombreproducto = producto.getNombreProducto();
            int idProducto = producto.getIdProducto();
            double precioVenta = producto.getPrecioActual();
            double precioCompra = producto.getPrecioActual() * 0.7;
            int cantidadTotal = mapaOrdenado.get(idProducto);

            modelo.addRow(new Object[]{
                idProducto,
                Nombreproducto,
                cantidadTotal,
                precioVenta,
                precioCompra
            });

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpEscritorio = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtConsultas = new javax.swing.JTable();
        jbSalir = new javax.swing.JButton();
        jlIdDetalle = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jcbConsulta = new javax.swing.JComboBox<>();
        jbCargar = new javax.swing.JButton();
        jdcFechaSelect = new com.toedter.calendar.JDateChooser();
        jcbSelectProveedoroProducto = new javax.swing.JComboBox();
        jtIdCompra = new javax.swing.JTextField();
        jlIngreseIdCompra = new javax.swing.JLabel();

        jtConsultas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID PRODUCTO", "NOMBRE", "CANTIDAD", "PRECIO VENTA", "PRECIO COMPRA"
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

        jbSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos de gui/SALIR-´PRODUCTO1.png"))); // NOI18N
        jbSalir.setText("SALIR");
        jbSalir.setMaximumSize(new java.awt.Dimension(110, 52));
        jbSalir.setMinimumSize(new java.awt.Dimension(110, 52));
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        jlIdDetalle.setForeground(new java.awt.Color(255, 255, 255));
        jlIdDetalle.setText("FORMATO DE BUSQUEDA:");

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CONSULTAS");

        jcbConsulta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Productos/Fecha", "Compras/Proveedor", "Productos/Compra", "Productos/MasComprado", " " }));
        jcbConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbConsultaActionPerformed(evt);
            }
        });

        jbCargar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos de gui/iconoa-ctualizado-32px.png"))); // NOI18N
        jbCargar.setText("CARGAR");
        jbCargar.setAlignmentY(0.0F);
        jbCargar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jbCargar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCargarActionPerformed(evt);
            }
        });

        jlIngreseIdCompra.setForeground(new java.awt.Color(255, 255, 255));
        jlIngreseIdCompra.setText("Ingrese ID de compra:");

        javax.swing.GroupLayout jpEscritorioLayout = new javax.swing.GroupLayout(jpEscritorio);
        jpEscritorio.setLayout(jpEscritorioLayout);
        jpEscritorioLayout.setHorizontalGroup(
            jpEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpEscritorioLayout.createSequentialGroup()
                .addGroup(jpEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpEscritorioLayout.createSequentialGroup()
                        .addGap(413, 413, 413)
                        .addGroup(jpEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbSelectProveedoroProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlIdDetalle)
                            .addGroup(jpEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jdcFechaSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpEscritorioLayout.createSequentialGroup()
                                    .addComponent(jcbConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(30, 30, 30)
                                    .addComponent(jbCargar)))
                            .addGroup(jpEscritorioLayout.createSequentialGroup()
                                .addComponent(jlIngreseIdCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtIdCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jpEscritorioLayout.createSequentialGroup()
                        .addGap(197, 197, 197)
                        .addGroup(jpEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 871, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );
        jpEscritorioLayout.setVerticalGroup(
            jpEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpEscritorioLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jpEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addComponent(jlIdDetalle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jcbConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbCargar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbSelectProveedoroProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jdcFechaSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(jpEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtIdCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlIngreseIdCompra))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
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

    private void jcbConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbConsultaActionPerformed
        String seleccion = (String) jcbConsulta.getSelectedItem();
        JTableHeader tableHeader = jtConsultas.getTableHeader();
        JTableHeader header = jtConsultas.getTableHeader();
        TableColumn primeraColum = header.getColumnModel().getColumn(0);
        TableColumn segundaColum = header.getColumnModel().getColumn(1);
        TableColumn terceraColum = header.getColumnModel().getColumn(2);
        TableColumn cuartaColum = header.getColumnModel().getColumn(3);
        TableColumn quintaColum = header.getColumnModel().getColumn(4);

        if (seleccion.equals("Productos/Fecha")) {
            jpEscritorio.repaint();
            jtIdCompra.setVisible(false);
            jlIngreseIdCompra.setVisible(false);
            jcbSelectProveedoroProducto.setVisible(false);
            jcbSelectProveedoroProducto.removeAllItems();
            jdcFechaSelect.setVisible(true);
            tableHeader.setVisible(false);
            primeraColum.setHeaderValue("FECHA");
            segundaColum.setHeaderValue("ID");
            terceraColum.setHeaderValue("NOMBRE");
            cuartaColum.setHeaderValue("CANTIDAD");
            quintaColum.setHeaderValue("PRECIO C/U");
            tableHeader.setVisible(true);

        } else if (seleccion.equals("Compras/Proveedor")) {
            jpEscritorio.repaint();
            jdcFechaSelect.setVisible(false);
            jtIdCompra.setVisible(false);
            jlIngreseIdCompra.setVisible(false);
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
            jpEscritorio.repaint();
            jtIdCompra.setVisible(true);
            jlIngreseIdCompra.setVisible(true);
            jdcFechaSelect.setVisible(false);
            jcbSelectProveedoroProducto.setVisible(false);
            jcbSelectProveedoroProducto.removeAllItems();
            tableHeader.setVisible(false);
            primeraColum.setHeaderValue("ID COMPRA");
            segundaColum.setHeaderValue("PRODUCTO");
            terceraColum.setHeaderValue("CANTIDAD");
            cuartaColum.setHeaderValue("PRECIO UNITARIO");
            quintaColum.setHeaderValue("PRECIO TOTAL");
            tableHeader.setVisible(true);
        } else if (seleccion.equals("Producto/MasComprado")) {
            jpEscritorio.repaint();
            jtIdCompra.setVisible(false);
            jlIngreseIdCompra.setVisible(false);
            jdcFechaSelect.setVisible(false);
            jcbSelectProveedoroProducto.setVisible(false);
            jcbSelectProveedoroProducto.removeAllItems();
            tableHeader.setVisible(false);
            primeraColum.setHeaderValue("ID PRODUCTO");
            segundaColum.setHeaderValue("PRODUCTO");
            terceraColum.setHeaderValue("CANTIDAD");
            cuartaColum.setHeaderValue("PRECIO VENTA");
            quintaColum.setHeaderValue("PRECIO COMPRA");
            tableHeader.setVisible(true);
        } else {
            jdcFechaSelect.setVisible(false);
            jcbSelectProveedoroProducto.setVisible(false);
            jtIdCompra.setVisible(false);
            jlIdDetalle.setVisible(false);
            jlIngreseIdCompra.setVisible(false);
            
        }

    }//GEN-LAST:event_jcbConsultaActionPerformed

    private void jbCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCargarActionPerformed
        String seleccion = (String) jcbConsulta.getSelectedItem();
        jbCargar.setEnabled(false);
        if ("Productos/Fecha".equals(seleccion)) {
            jbCargar.setEnabled(true);
            listarDetallesFecha();
        } else if ("Compras/Proveedor".equals(seleccion)) {
            jbCargar.setEnabled(true);
            comprasAunProveedor();

        } else if ("Productos/Compra".equals(seleccion)) {
            jbCargar.setEnabled(true);
            productosPorCompra();
            jtIdCompra.setText("");
        } else if ("Productos/MasComprado".equals(seleccion)) {
            jbCargar.setEnabled(true);
            productoMasComprado();

        }

    }//GEN-LAST:event_jbCargarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbCargar;
    private javax.swing.JButton jbSalir;
    private javax.swing.JComboBox<String> jcbConsulta;
    private javax.swing.JComboBox jcbSelectProveedoroProducto;
    private com.toedter.calendar.JDateChooser jdcFechaSelect;
    private javax.swing.JLabel jlIdDetalle;
    private javax.swing.JLabel jlIngreseIdCompra;
    private javax.swing.JPanel jpEscritorio;
    private javax.swing.JTable jtConsultas;
    private javax.swing.JTextField jtIdCompra;
    // End of variables declaration//GEN-END:variables
}
