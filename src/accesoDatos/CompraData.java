
package accesoDatos;

import entidades.Compra;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;


public class CompraData {

    private Connection con = null;
    private ProveedorData pvd = new ProveedorData();

    public CompraData() {

        con = Conexion.getConnection();
    }

    public Compra guardarCompra(Compra compra) {
        String sql = "INSERT INTO compra (idProveedor, fecha) VALUES (?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, compra.getProveedor().getIdProveedor());
            ps.setDate(2, Date.valueOf(compra.getFecha()));
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {

                compra.setIdCompra(rs.getInt(1));

                JOptionPane.showMessageDialog(null, "COMPRA EXITOSA");
                return compra;

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "NO SE PUDO ACCEDER A LA TABLA COMPRAS");
        }
        return null;

    }

    public List<Compra> buscarComprasPorProveedor(int idProveedor) {
        String sql = "SELECT idCompra, fecha FROM compra WHERE idProveedor = ?";
        List<Compra> compras = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idProveedor);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Compra compra = new Compra();
                compra.setIdCompra(rs.getInt("idCompra"));
                compra.setFecha(rs.getDate("fecha").toLocalDate());
                compra.setProveedor(pvd.buscarProveedorActivo(idProveedor));
                compras.add(compra);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla de compras por proveedor");
        }

        return compras;
    }

    public Compra buscarCompra(int idCompra) {
        String sql = "SELECT idProveedor, fecha FROM compra "
                + "WHERE idCompra = ? ";
        Compra compra = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idCompra);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                compra = new Compra();
                compra.setFecha(rs.getDate("fecha").toLocalDate());
                compra.setProveedor(pvd.buscarProveedorActivo(rs.getInt("idProveedor")));
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER LA TABLA COMPRAS");
        }
        return compra;
    }

    public List<Compra> buscarCompraPorFecha(LocalDate fecha) {
        String sql = "SELECT idCompra, idProveedor FROM compra WHERE fecha = ?";
        List<Compra> compras = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(fecha));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Compra compra = new Compra();
                compra.setIdCompra(rs.getInt("idCompra"));
                compra.setFecha(fecha);
                compra.setProveedor(pvd.buscarProveedorActivo(rs.getInt("idProveedor")));
                compras.add(compra);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER LA TABLA COMPRAS POR FECHA");
        }

        return compras;
    }

    public int buscarUltimoId() {
        String sql = "SELECT MAX(`idCompra`) FROM compra";
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
