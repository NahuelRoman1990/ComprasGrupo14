/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoDatos;

import entidades.Compra;
import entidades.Producto;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author roman
 */
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
        String sql = "SELECT idCompra, idProveedor FROM compra "
                + "WHERE fecha = ? ";
        Compra compra = null;
//        try {
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setInt(1, idCompra);
//            ResultSet rs = ps.executeQuery();
//            if (rs.next()) {
//                compra = new Compra();
//                compra.setFecha(rs.getDate("fecha").toLocalDate());
//                compra.setProveedor(pvd.buscarProveedorActivo(rs.getInt("idProveedor")));
//            }
//            ps.close();
//
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER LA TABLA COMPRAS");
//        }
        return null;
    }
   public int buscarUltimoId() {
       String sql = "SELECT LAST_INSERT_ID()";
       
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int ultimoId = rs.getInt(1);
                return ultimoId;
            }
                
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "NO SE PUDO CONECTAR CON LA TABLA COMPRAS");
        }
        return 0;
       
       
   }
}

