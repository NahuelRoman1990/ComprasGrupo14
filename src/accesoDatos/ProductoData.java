package accesoDatos;

import entidades.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class ProductoData {

    private Connection con = null;

    public ProductoData() {

        con = Conexion.getConnection();
    }

    public void guardarProducto(Producto producto) {
        String sql = "INSERT INTO producto(nombreProducto, descripcion, precioActual, stock, estado) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, producto.getNombreProducto());
            ps.setString(2, producto.getDescripcion());
            ps.setDouble(3, producto.getPrecioActual());
            ps.setInt(4, producto.getStock());
            ps.setBoolean(5, producto.isEstado());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                producto.setIdProducto(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "PRODUCTO GUARDADO CON EXITO");

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "NO SE PUDO ACCEDER A LA TABLA PRODUCTO");
        }catch(NullPointerException np){
            
        }
    }

    public void modificarProducto(Producto producto) {

        String sql = "UPDATE producto SET nombreProducto=?, descripcion=?, precioActual=?, stock=?, estado=?"
                + " WHERE idProducto=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, producto.getNombreProducto());
            ps.setString(2, producto.getDescripcion());
            ps.setDouble(3, producto.getPrecioActual());
            ps.setInt(4, producto.getStock());
            ps.setBoolean(5, producto.isEstado());
            ps.setInt(6, producto.getIdProducto());
            int exito = ps.executeUpdate();
            if (exito == 1) {
                
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER A LA TABLA PRODUCTO");
        }
    }

    public void eliminarProducto(int idProducto) {
        String sql = "UPDATE producto SET estado = 0 WHERE idProducto= ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idProducto);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "PRODUCTO ELIMINADO");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER A LA TABLA PRODUCTO");
        }
    }

    public Producto buscarProducto(int idProducto) {
        String sql = "SELECT idProducto, nombreProducto, descripcion, precioActual, stock FROM producto "
                + "WHERE idProducto = ?";
        Producto producto = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idProducto);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                producto = new Producto();
                producto.setIdProducto(rs.getInt("idProducto"));
                producto.setNombreProducto(rs.getString("nombreProducto"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecioActual(rs.getDouble("precioActual"));
                producto.setStock(rs.getInt("stock"));
                producto.setEstado(true);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER LA TABLA PRODUCTO");
        }
        return producto;
    }

    public List<Producto> listarProducto() {
        String sql = "SELECT idProducto, nombreProducto, descripcion, precioActual, stock, estado FROM producto WHERE estado=1";
        ArrayList<Producto> productos = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Producto producto = new Producto();
                producto.setIdProducto(rs.getInt("idProducto"));
                producto.setNombreProducto(rs.getString("nombreProducto"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecioActual(rs.getDouble("precioActual"));
                producto.setStock(rs.getInt("stock"));
                producto.setEstado(rs.getBoolean("estado"));

                productos.add(producto);
            }

            ps.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER A LA TABLA PRODUCTOS");
        }catch(NullPointerException np){
            np.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER A LA TABLA PRODUCTOS");
        }
        return productos;

    }
    
    public List<Producto> buscarProductosBajoStock(){
        String sql = "SELECT idProducto, nombreProducto, descripcion, precioActual, stock "
                + "FROM producto WHERE stock <5";
        ArrayList<Producto> productos = new ArrayList<>();
       
        try {
            PreparedStatement ps =con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               Producto producto = new Producto();
                producto.setIdProducto(rs.getInt("idProducto"));
                producto.setNombreProducto(rs.getString("nombreProducto"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecioActual(rs.getDouble("precioActual"));
                producto.setStock(rs.getInt("stock"));
                producto.setEstado(rs.getBoolean("estado"));

                productos.add(producto);
                
            }
        } catch (SQLException ex) {
             ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER A LA TABLA PRODUCTOS");
        }catch(NullPointerException np){
            np.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER A LA TABLA PRODUCTOS");
        }
        return productos;
    }
    
    public int buscarUltimoId() {
        String sql = "SELECT MAX(`idProducto`) FROM producto";
        int ultimoId;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                ultimoId = rs.getInt(1);
                return ultimoId;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "NO SE PUDO CONECTAR CON LA TABLA COMPRAS");
        }
        return 0;

    }
}
