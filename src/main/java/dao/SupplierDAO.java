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
    public List<Supplier> getAllSupplier(){
        List<Supplier> list = new ArrayList<>();
        String sql = "SELECT * FROM `supplier`";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Supplier s = mapSupplier(rs);
                list.add(s);
            }
        } catch (SQLException e) {
        }
        return list;
    }
    
    public Integer getCountAllSupplier(){
        String sql = "SELECT COUNT(*) FROM `supplier`";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return rs.getInt("COUNT(*)");
            }
        } catch (SQLException e) {
        }
        return 0;
    }
    
    public void addSupplier(Supplier s){
        try {
            String sql = "INSERT INTO `supplier`(`fullname`, `email`, `phone`, `address`) VALUES (?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, s.getFullname());
            ps.setString(2, s.getEmail());
            ps.setString(3, s.getPhone());
            ps.setString(4, s.getAddress());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SupplierDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private Supplier mapSupplier(ResultSet rs) throws SQLException{
        Supplier s = new Supplier(rs.getInt("id"), rs.getString("fullname"), rs.getString("email"), rs.getString("phone"), rs.getString("address"));
        return s;
    }
    
    public static void main(String[] args) {
        System.out.println(new SupplierDAO().getCountAllSupplier());
    }
    
}
