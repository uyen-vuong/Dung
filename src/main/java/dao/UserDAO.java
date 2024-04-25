/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.User;

/**
 *
 * @author Admin
 */
public class UserDAO extends Connect{
    public User getUser(String username, String password){
        String sql = "SELECT * FROM `user` WHERE username = ? AND password = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                User l = mapUser(rs);
                return l;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private User mapUser(ResultSet rs) throws SQLException {
        User u = new User(rs.getInt("id"), rs.getString("userid"), rs.getString("fullname"), rs.getString("email"), rs.getString("phone"), rs.getString("address"), rs.getString("username"), rs.getString("password"), new RoleDAO().getRole(rs.getInt("roleid")));
        return u;
    }
    
    public static void main(String[] args) {
        User u = new UserDAO().getUser("user1", "111");
        System.out.println(u.getRole().getName());
    }
}
