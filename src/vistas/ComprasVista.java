/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import accesoDatos.CompraData;
import accesoDatos.DetalleCompraData;
import accesoDatos.ProductoData;
import accesoDatos.ProveedorData;
import entidades.Compra;
import entidades.DetalleCompra;
import entidades.Producto;
import entidades.Proveedor;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.BasicListUI;
import javax.swing.plaf.basic.BasicListUI.ListSelectionHandler;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Erni
 */
public class ComprasVista extends javax.swing.JInternalFrame {
    
    DetalleCompraData dcd = new DetalleCompraData();
    CompraData cd = new CompraData();
    ProveedorData pd = new ProveedorData();
    ProductoData prd = new ProductoData();
    private DefaultTableModel modelo = new DefaultTableModel() {
        public boolean isCellEditable(int f, int c) {
            if (c == 4) {
                return true;
            } else {
                return false;
            }
        }
    };
    
    public ComprasVista() {
        initComponents();
        cargarComboProducto();
        cargarComboProveedor();
        cargarCabecera();
        sumaTotal();
        setResizable(false);
        jcCalendario.setWeekOfYearVisible(false);
        jcbProductos.setEnabled(false);
        String rutaImagen = "img\\Fondo1.jpg";
        ImageIcon fondo = new ImageIcon(rutaImagen);
        JLabel label = new JLabel(fondo);
        label.setBounds(0, 0, fondo.getIconWidth(), fondo.getIconHeight());
        jdEscritorioCompras.add(label, new Integer(Integer.MIN_VALUE));
        jcCalendario.setEnabled(true);
    }
    
    private void cargarCabecera() {
        modelo.addColumn("ID Producto");
        modelo.addColumn("Nombre");
        modelo.addColumn("Descripción");
        modelo.addColumn("Precio Costo");
        modelo.addColumn("Cantidad");
        jtCompras.setModel(modelo);
        JTableHeader tableHeader = jtCompras.getTableHeader();
        tableHeader.setReorderingAllowed(false);
        jtCompras.getColumnModel().getColumn(0).setPreferredWidth(10);
        jtCompras.getColumnModel().getColumn(0).setResizable(false);
        jtCompras.getColumnModel().getColumn(1).setPreferredWidth(30);
        jtCompras.getColumnModel().getColumn(1).setResizable(false);
        jtCompras.getColumnModel().getColumn(2).setPreferredWidth(40);
        jtCompras.getColumnModel().getColumn(2).setResizable(false);
        jtCompras.getColumnModel().getColumn(3).setPreferredWidth(20);
        jtCompras.getColumnModel().getColumn(3).setResizable(false);
        jtCompras.getColumnModel().getColumn(4).setPreferredWidth(20);
        jtCompras.getColumnModel().getColumn(4).setResizable(false);
        //jtCompras.setDefaultEditor(Object.class, null);

    }
    
    private void borrarFilas() {
        int fila = jtCompras.getRowCount() - 1;
        for (; fila >= 0; fila--) {
            modelo.removeRow(fila);
        }
        
    }
    
    private void cargarComboProveedor() {
        for (Proveedor proveedor : pd.listarProveedoresActivo()) {
            
            jcbProveedor.addItem(proveedor);
        }
    }
    
    private void cargarComboProducto() {
        for (Producto producto : prd.listarProducto()) {
            
            jcbProductos.addItem(producto);
        }
    }
    
    private void agregarCompra() {
        try {
            Producto producto = (Producto) jcbProductos.getSelectedItem();
            int cantidad = Integer.parseInt(jtCantidad.getText());
            if (cantidad == 0) {
                JOptionPane.showMessageDialog(this, "CANTIDAD NO PUEDE SER '0' ", "Erorr", JOptionPane.ERROR_MESSAGE);
            }
//            for (int i=0; i <= cantidadFilas-1;i++) {
//             int idTable = Integer.parseInt(jtCompras.getValueAt(i, 0).toString());
//            }
            double precioCosto = producto.getPrecioActual() * 0.7;
            modelo.addRow(new Object[]{producto.getIdProducto(), producto.getNombreProducto(), producto.getDescripcion(), precioCosto, cantidad});
            jcbProductos.removeItem(producto);
        } catch (NumberFormatException np) {
            JOptionPane.showMessageDialog(this, "INGRESE NUMEROS ENTEROS", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (NullPointerException nop) {
            JOptionPane.showMessageDialog(this, "CANTIDAD NO PUEDE SER UN CAMPO VACIO", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    private void descartarCompra() {
        int filaSeleccionada = jtCompras.getSelectedRow();
        if (filaSeleccionada != -1) {
            Producto producto = prd.buscarProducto(Integer.parseInt(jtCompras.getValueAt(filaSeleccionada, 0).toString()));
            modelo.removeRow(filaSeleccionada);
            
            jcbProductos.addItem(producto);
            
        } else if (jtCompras.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "TU LISTA ESTA VACIA", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "SELECCIONE EL PRODUCTO QUE DESEA DESCARTAR", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void modificarCompra() {
        int filaSeleccionada = jtCompras.getSelectedRow();
        if (filaSeleccionada != -1) {
            // Producto producto = (Producto) jtCompras.getValueAt(filaSeleccionada,1);
            // jcbProductos.setSelectedItem(producto);
        }

//         int filaSeleccionada = jtCompras.getSelectedRow();
//         int productoTocado = Integer.parseInt(jtCompras.getValueAt(filaSeleccionada, 0).toString());
//         jcbProductos.setSelectedItem(prd.buscarProducto(productoTocado));
    }
    
    private void sumaTotal() {
        int cantidadFilas = jtCompras.getRowCount();
        try {
            if (cantidadFilas > 0) {
                
                for (int fila = 0; fila <= cantidadFilas - 1; fila++) {
                    double precioCosto = Double.parseDouble(jtCompras.getValueAt(fila, 3).toString());
                    int cantidad = Integer.parseInt(jtCompras.getValueAt(fila, 4).toString());
                    double total = +(precioCosto * cantidad);
                    jtTotal.setText(total + "");
                    
                }
            } else {
                jtTotal.setText(0 + "");
            }
        } catch (NumberFormatException nf) {
            JOptionPane.showMessageDialog(this, "La cantidad debe ser un numero entero");
        }
        
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
        jtfCompra = new javax.swing.JTextField();
        jcCalendario = new com.toedter.calendar.JCalendar();
        jLabel2 = new javax.swing.JLabel();
        jcbProveedor = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jcbProductos = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jtTotal = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtCompras = new javax.swing.JTable();
        jbAgregar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jtCantidad = new javax.swing.JTextField();
        jbComprar = new javax.swing.JButton();
        jbConfirmarCompra = new javax.swing.JButton();
        jbDescartar = new javax.swing.JButton();
        jbCancelarCompra = new javax.swing.JButton();
        jbModificar = new javax.swing.JButton();

        jdEscritorioCompras.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ID Compra");

        jtfCompra.setEditable(false);
        jtfCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfCompraActionPerformed(evt);
            }
        });

        jcCalendario.setBackground(new java.awt.Color(102, 102, 102));
        jcCalendario.setDecorationBackgroundColor(new java.awt.Color(153, 153, 153));
        jcCalendario.setFont(new java.awt.Font("Arial Black", 1, 10)); // NOI18N
        jcCalendario.setTodayButtonVisible(true);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Proveedor");

        jcbProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbProveedorActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos de gui/carrito de compras para vista-png-0.7.png"))); // NOI18N
        jLabel3.setText("COMPRAS");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Productos");

        jcbProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbProductosActionPerformed(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("TOTAL:");

        jtTotal.setEditable(false);
        jtTotal.setText("0");
        jtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtTotalActionPerformed(evt);
            }
        });

        jtCompras.setModel(new javax.swing.table.DefaultTableModel(
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
        jtCompras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtComprasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtCompras);

        jbAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos de gui/anadir-producto-64-bit.png"))); // NOI18N
        jbAgregar.setText("Agregar");
        jbAgregar.setMaximumSize(new java.awt.Dimension(128, 71));
        jbAgregar.setMinimumSize(new java.awt.Dimension(128, 71));
        jbAgregar.setPreferredSize(new java.awt.Dimension(128, 71));
        jbAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarActionPerformed(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Cantidad");

        jbComprar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos de gui/comprar_1.png"))); // NOI18N
        jbComprar.setText("Comprar");
        jbComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbComprarActionPerformed(evt);
            }
        });

        jbConfirmarCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos de gui/confirmar orden.png"))); // NOI18N
        jbConfirmarCompra.setText("Confirmar orden");
        jbConfirmarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbConfirmarCompraActionPerformed(evt);
            }
        });

        jbDescartar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos delete/Size=28, Theme=Filled-1.png"))); // NOI18N
        jbDescartar.setText("Descartar");
        jbDescartar.setMaximumSize(new java.awt.Dimension(128, 71));
        jbDescartar.setMinimumSize(new java.awt.Dimension(128, 71));
        jbDescartar.setPreferredSize(new java.awt.Dimension(128, 71));
        jbDescartar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDescartarActionPerformed(evt);
            }
        });

        jbCancelarCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos de gui/cancelar compras-negro-png.png"))); // NOI18N
        jbCancelarCompra.setText("Salir");
        jbCancelarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarCompraActionPerformed(evt);
            }
        });

        jbModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos de gui/actualizar-png64.png"))); // NOI18N
        jbModificar.setText("Actualizar");
        jbModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarActionPerformed(evt);
            }
        });

        jdEscritorioCompras.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdEscritorioCompras.setLayer(jtfCompra, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jdEscritorioCompras.setLayer(jcCalendario, javax.swing.JLayeredPane.PALETTE_LAYER);
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jdEscritorioComprasLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jdEscritorioComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jdEscritorioComprasLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbCancelarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jdEscritorioComprasLayout.createSequentialGroup()
                        .addGroup(jdEscritorioComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jdEscritorioComprasLayout.createSequentialGroup()
                                .addComponent(jbDescartar, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(156, 156, 156)
                                .addComponent(jbAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jdEscritorioComprasLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(jtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jdEscritorioComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jdEscritorioComprasLayout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jcbProductos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jdEscritorioComprasLayout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jtfCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jdEscritorioComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jdEscritorioComprasLayout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(28, 28, 28)
                                    .addComponent(jcbProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(103, 103, 103)
                                    .addComponent(jbComprar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(jcCalendario, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jdEscritorioComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jdEscritorioComprasLayout.createSequentialGroup()
                                .addGroup(jdEscritorioComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jdEscritorioComprasLayout.createSequentialGroup()
                                        .addGap(447, 447, 447)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jdEscritorioComprasLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jbModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(37, 37, 37)))
                                .addGroup(jdEscritorioComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jbConfirmarCompra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jtTotal)))
                            .addGroup(jdEscritorioComprasLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 628, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(47, 47, 47))
        );
        jdEscritorioComprasLayout.setVerticalGroup(
            jdEscritorioComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdEscritorioComprasLayout.createSequentialGroup()
                .addGroup(jdEscritorioComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jdEscritorioComprasLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jbCancelarCompra)))
                .addGap(93, 93, 93)
                .addGroup(jdEscritorioComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jdEscritorioComprasLayout.createSequentialGroup()
                        .addGroup(jdEscritorioComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jbComprar)
                            .addGroup(jdEscritorioComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(jcbProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jcCalendario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jdEscritorioComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jtfCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jdEscritorioComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jcbProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jdEscritorioComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jdEscritorioComprasLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jdEscritorioComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18))
                    .addGroup(jdEscritorioComprasLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jdEscritorioComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jdEscritorioComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbConfirmarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbDescartar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdEscritorioCompras)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jdEscritorioCompras)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfCompraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfCompraActionPerformed

    private void jtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtTotalActionPerformed

    private void jcbProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbProveedorActionPerformed

    }//GEN-LAST:event_jcbProveedorActionPerformed

    private void jcbProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbProductosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbProductosActionPerformed

    private void jbCancelarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarCompraActionPerformed
        dispose();
    }//GEN-LAST:event_jbCancelarCompraActionPerformed

    private void jbDescartarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDescartarActionPerformed
        descartarCompra();
        sumaTotal();
        if (jtCompras.getRowCount() == 0) {
            jcbProveedor.setEnabled(true);
        }

    }//GEN-LAST:event_jbDescartarActionPerformed

    private void jbComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbComprarActionPerformed
        int ultimoId = cd.buscarUltimoId();
        
        jtfCompra.setText(ultimoId + 1 + "");
        jtfCompra.setHorizontalAlignment(SwingConstants.CENTER);
        jcbProductos.setEnabled(true);
        jcbProveedor.setEnabled(false);
    }//GEN-LAST:event_jbComprarActionPerformed

    private void jbAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarActionPerformed
        agregarCompra();
        jcbProveedor.setEnabled(false);
        jtCantidad.setText("");
        sumaTotal();
    }//GEN-LAST:event_jbAgregarActionPerformed

    private void jtComprasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtComprasMouseClicked
        modificarCompra();
    }//GEN-LAST:event_jtComprasMouseClicked

    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed
        // TODO add your handling code here:
        sumaTotal();
    }//GEN-LAST:event_jbModificarActionPerformed

    private void jbConfirmarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbConfirmarCompraActionPerformed
        jcbProveedor.setEnabled(true);
        
        Compra compra = generarCompra();
        
        int filaTotales = jtCompras.getRowCount();
        for (int i = 0; i <= filaTotales - 1; i++) {
            int cantidad = Integer.parseInt(jtCompras.getValueAt(i, 4).toString());
            double precioCosto = Double.parseDouble(jtCompras.getValueAt(i, 3).toString());
            int idProducto = Integer.parseInt(jtCompras.getValueAt(i, 0).toString());
            Producto producto = prd.buscarProducto(idProducto);
            
            DetalleCompra detalleCompra = new DetalleCompra(cantidad, precioCosto, compra, producto);
            dcd.guardarDetalleCompra(detalleCompra);
        }
        
        jtfCompra.setText(" ");
        jtfCompra.setEnabled(false);
        borrarFilas();
        jcbProductos.removeAllItems();
        cargarComboProducto();
        
        String mensajeCompra = "COMPRA REALIZADA CON EXITO:\n"
                + "FECHA: " + compra.getFecha() + "\n"
                + "ID COMPRA: " + cd.buscarUltimoId() + "\n"
                + "TOTAL: $" + jtTotal.getText();
        javax.swing.JOptionPane.showMessageDialog(this, mensajeCompra, "DETALLE COMPRA", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jbConfirmarCompraActionPerformed
    
    private Compra generarCompra() {
        Proveedor proveedor = (Proveedor) jcbProveedor.getSelectedItem();
        LocalDate fechaCompra = jcCalendario.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Compra compra = new Compra(proveedor, fechaCompra);
        Compra compraRealizada = cd.guardarCompra(compra);
        return compraRealizada;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAgregar;
    private javax.swing.JButton jbCancelarCompra;
    private javax.swing.JButton jbComprar;
    private javax.swing.JButton jbConfirmarCompra;
    private javax.swing.JButton jbDescartar;
    private javax.swing.JButton jbModificar;
    private static com.toedter.calendar.JCalendar jcCalendario;
    private javax.swing.JComboBox<Producto> jcbProductos;
    private javax.swing.JComboBox<Proveedor> jcbProveedor;
    private javax.swing.JDesktopPane jdEscritorioCompras;
    private javax.swing.JTextField jtCantidad;
    private javax.swing.JTable jtCompras;
    private javax.swing.JTextField jtTotal;
    private javax.swing.JTextField jtfCompra;
    // End of variables declaration//GEN-END:variables
}
