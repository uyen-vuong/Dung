/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Supplier;

/**
 *
 * @author Admin
 */
public class SupplierDAO extends Connect{
    
    public Integer getCountAllSupplier() {
        String sql = "SELECT COUNT(*) FROM `supplier`";
        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            if(rs.next()){
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            Logger.getLogger(SupplierDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return 0;
    }
    
    public List<Supplier> getAllSupplier() {
        List<Supplier> list = new ArrayList<>();
        String sql = "SELECT * FROM `supplier`";
        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Supplier s = mapSupplier(rs);
                list.add(s);
            }
        } catch (SQLException e) {
            Logger.getLogger(SupplierDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }
    
    public Supplier getSupplierById(int id) throws SQLException{
        String sql = "SELECT * FROM `supplier` WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapSupplier(rs);
                }
            }
        }
        return null;
    }

    public List<Supplier> getSupplierByKey(String key) throws SQLException {
        List<Supplier> list = new ArrayList<>();
        String sql = "SELECT * FROM `supplier` WHERE fullname LIKE ? OR phone LIKE ? OR address LIKE ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, "%" + key + "%");
            ps.setString(2, "%" + key + "%");
            ps.setString(3, "%" + key + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Supplier s = mapSupplier(rs);
                    list.add(s);
                }
            }
        }
        return list;
    }
    
    public void addSupplier(Supplier s) {
        String sql = "INSERT INTO `supplier`(`fullname`, `email`, `phone`, `address`) VALUES (?,?,?,?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, s.getFullname());
            ps.setString(2, s.getEmail());
            ps.setString(3, s.getPhone());
            ps.setString(4, s.getAddress());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SupplierDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public void updateSupplier(int id, Supplier s) throws SQLException {
        String sql = "UPDATE `supplier` SET `fullname`=?,`email`=?,`phone`=?,`address`=? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, s.getFullname());
            ps.setString(2, s.getEmail());
            ps.setString(3, s.getPhone());
            ps.setString(4, s.getAddress());
            ps.setInt(5, id);
            ps.executeUpdate();
        }
    }

    private Supplier mapSupplier(ResultSet rs) throws SQLException {
        return new Supplier(rs.getInt("id"), rs.getString("fullname"), rs.getString("email"), rs.getString("phone"), rs.getString("address"));
    }
    
//    public static void main(String[] args) {
//        System.out.println(new SupplierDAO().getCountAllSupplier());
//    }
    
}
