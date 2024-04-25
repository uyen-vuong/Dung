/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Role;

/**
 *
 * @author Admin
 */
public class RoleDAO extends Connect{
    public Role getRole(int id){
        try {
            String sql = "SELECT * FROM `role` WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Role r = mapRole(rs);
                return r;
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private Role mapRole(ResultSet rs) throws SQLException{
        Role r = new Role(rs.getInt("id"), rs.getString("roleid"), rs.getString("name"));
        return r;
    }
    
    public static void main(String[] args) {
        Role r = new RoleDAO().getRole(1);
        System.out.println(r.getName());
    }
}
