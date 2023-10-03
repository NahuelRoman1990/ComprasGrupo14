
package accesoDatos;

import entidades.Producto;
import entidades.Proveedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.swing.JOptionPane;


public class ProveedorData {
       private Connection con = null;

    public ProveedorData() {

        con = Conexion.getConnection();
    }
    
    public void guardarProveedor(Proveedor proveedor) {
        String sql = "INSERT INTO proveedor (razonSocial, domicilio ,telefono  VALUES (?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, proveedor.getRazonSocial());
            ps.setString(2, proveedor.getDomicilio());
            ps.setString(3, proveedor.getTelefono());
            
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                proveedor.setIdProveedor(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "PROVEEDOR GUARDADO CON EXITO");

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "NO SE PUDO ACCEDER A LA TABLA PROVEEDOR");
        }
    }
    
  public void eliminarProveedor(int idProveedor) {
        String sql = "UPDATE proveedor SET estado = 0 WHERE idProveedor= ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idProveedor);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "PROVEEDOR ELIMINADO");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER A LA TABLA PROVEEDOR");
        }
    } 
  
  public void modificarProveedor(Proveedor proveedor) {

        String sql = "UPDATE proveedor SET razonSocial=?, domicilio =?, telefono=?, estado=?"
                + "WHERE idProveedor =?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, proveedor.getRazonSocial());
            ps.setString(2, proveedor.getDomicilio());
            ps.setString(3, proveedor.getTelefono());
            ps.setBoolean(4, proveedor.isEstado());
            ps.setInt(5, proveedor.getIdProveedor());
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "PROVEEDOR MODIFICADO");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER A LA TABLA PROVEEDOR");
        }
    }
  
  public Proveedor buscarProveedorActivo(int idProveedor) {
        String sql = "SELECT idProveedor, razonSocial, domicilio, telefono FROM proveedor "
                + "WHERE idProveedor = ? AND estado = 1";
        Proveedor proveedor = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idProveedor);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                proveedor = new Proveedor();
                proveedor.setIdProveedor(rs.getInt("idProveedor"));
                proveedor.setRazonSocial(rs.getString("razonSocial"));
                proveedor.setDomicilio(rs.getString("domicilio"));
                proveedor.setTelefono(rs.getString("telefono"));
                proveedor.setEstado(true);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER LA TABLA PROVEEDOR");
        }
        return proveedor;
    }
  
  public Proveedor buscarProveedorInactivo(int idProveedor) {
        String sql = "SELECT idProveedor, razonSocial, domicilio, telefono FROM proveedor "
                + "WHERE idProveedor = ? AND estado = 0";
        Proveedor proveedor = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idProveedor);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                proveedor = new Proveedor();
                proveedor.setIdProveedor(rs.getInt("idProveedor"));
                proveedor.setRazonSocial(rs.getString("razonSocial"));
                proveedor.setDomicilio(rs.getString("domicilio"));
                proveedor.setTelefono(rs.getString("telefono"));
                proveedor.setEstado(rs.getBoolean("estado"));
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER LA TABLA PROVEEDOR");
        }
        return proveedor;
    }
  
  
   public List<Proveedor> listarProveedores() {
        String sql = "SELECT idProveedor, razonSocial, domicilio, telefono FROM proveedor WHERE estado = 1";
        ArrayList<Proveedor> proveedores = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Proveedor proveedor = new Proveedor();
                proveedor.setIdProveedor(rs.getInt("idProveedor"));
                proveedor.setRazonSocial(rs.getString("razonSocial"));
                proveedor.setDomicilio(rs.getString("domicilio"));
                proveedor.setTelefono(rs.getString("telefono"));
                
                proveedor.setEstado(true);

                proveedores.add(proveedor);
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER A LA TABLA PROVEEDOR");
        }
        return proveedores;

    }
}
