
package accesoDatos;


import entidades.DetalleCompra;
import entidades.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DetalleCompraData {
    
    private Connection con = null;
    private ProductoData pd = new ProductoData();
    private CompraData cd = new CompraData();

    public DetalleCompraData() {
        
        con = Conexion.getConnection();
    }
    
    public void guardarDetalleCompra(DetalleCompra detalleCompra) {
        String sql = "INSERT INTO detallecompra (cantidad, precioCosto, idCompra, idProducto) VALUES (?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, detalleCompra.getCantidad());
            ps.setDouble(2, detalleCompra.getPrecioCosto());
            ps.setInt(3, detalleCompra.getCompra().getIdCompra());
            ps.setInt(4, detalleCompra.getProducto().getIdProducto());
            ps.executeUpdate();
            
            Producto producto = pd.buscarProducto(detalleCompra.getProducto().getIdProducto());
            int stock = producto.getStock()+ detalleCompra.getCantidad();
            producto.setStock(stock);
            pd.modificarProducto(producto);
            ResultSet rs = ps.getGeneratedKeys();
            
            if (rs.next()) {
                detalleCompra.setIdDetalle(rs.getInt(1));
              

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "NO SE PUDO ACCEDER A LA TABLA DETALLE DE COMPRAS");
        }
    }


    public List<DetalleCompra> listarDetalleCompras(int idCompra) {
        String sql = "SELECT idDetalle, cantidad, precioCosto, idProducto FROM detallecompra WHERE idCompra = ?";
        ArrayList<DetalleCompra> detalles = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idCompra);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                
                DetalleCompra detalleCompra = new DetalleCompra();
                detalleCompra.setIdDetalle(rs.getInt("idDetalle"));
                detalleCompra.setCantidad(rs.getInt("cantidad"));
                detalleCompra.setPrecioCosto(rs.getDouble("precioCosto"));
                detalleCompra.setProducto(pd.buscarProducto(rs.getInt("idProducto")));
                detalleCompra.setCompra(cd.buscarCompra(idCompra));
                detalles.add(detalleCompra);
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER A LA TABLA DETALLES DE COMPRA");
        }
        return detalles;
        
    }
    
    public List<DetalleCompra> listarDetalles() {
        String sql = "SELECT * FROM detallecompra ";
        ArrayList<DetalleCompra> detalles = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                
                DetalleCompra detalleCompra = new DetalleCompra();
                detalleCompra.setIdDetalle(rs.getInt("idDetalle"));
                detalleCompra.setCantidad(rs.getInt("cantidad"));
                detalleCompra.setPrecioCosto(rs.getDouble("precioCosto"));
                detalleCompra.setProducto(pd.buscarProducto(rs.getInt("idProducto")));
                detalles.add(detalleCompra);
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER A LA TABLA DETALLES DE COMPRA");
        }
        return detalles;
        
    }
    
   
    
}
