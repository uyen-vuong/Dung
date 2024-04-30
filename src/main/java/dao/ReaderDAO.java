/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Reader;

/**
 *
 * @author Admin
 */
public class ReaderDAO extends Connect{
    public Reader getReaderByReaderId(String readerid) throws SQLException{
        String sql = "SELECT * FROM `reader` WHERE readerid = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, readerid);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapReader(rs);
                }
            }
        }
        return null;
    }
    
    public Reader getReaderById(int id) throws SQLException{
        String sql = "SELECT * FROM `reader` WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapReader(rs);
                }
            }
        }
        return null;
    }

    private Reader mapReader(ResultSet rs) throws SQLException {
        return new Reader(rs.getInt("id"), rs.getString("readerid"), rs.getString("fullname"), rs.getString("email"), rs.getString("phone"), rs.getString("address"), rs.getDate("date"));
    }
}
