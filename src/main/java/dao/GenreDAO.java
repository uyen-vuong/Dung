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
import model.Genre;

/**
 *
 * @author Admin
 */
public class GenreDAO extends Connect{
    public Genre getGenreById(int id) throws SQLException{
        String sql = "SELECT * FROM `genre` WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapGenre(rs);
                }
            }
        }
        return null;
    }
    
    public List<Genre> getAllGenre() throws SQLException{
        List<Genre> list = new ArrayList<>();
        String sql = "SELECT * FROM `genre`";
        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Genre g = mapGenre(rs);
                list.add(g);
            }
        }
        return list;
    }
    
    public void addGenre(String nameGenre) throws SQLException{
        String sql = "INSERT INTO `genre`(`name`) VALUES (?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, nameGenre);
            ps.executeUpdate();
        }
    }

    private Genre mapGenre(ResultSet rs) throws SQLException {
        return new Genre(rs.getInt("id"), rs.getString("name"));
    }
}
