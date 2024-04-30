/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Role;

/**
 *
 * @author Admin
 */
public class RoleDAO extends Connect{
    public Role getRole(int id){
        try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM `role` WHERE id = ?")) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapRole(rs);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private Role mapRole(ResultSet rs) throws SQLException{
        return new Role(rs.getInt("id"), rs.getString("roleid"), rs.getString("name"));
    }
    
//    public static void main(String[] args) {
//        Role r = new RoleDAO().getRole(1);
//        System.out.println(r.getName());
//    }
}
