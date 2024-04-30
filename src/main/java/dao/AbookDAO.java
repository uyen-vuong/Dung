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
import model.Abook;

/**
 *
 * @author Admin
 */
public class AbookDAO extends Connect {
    public List<Abook> getAbookByImportBookId(int importbookid) throws SQLException {
        List<Abook> list = new ArrayList<>();
        String sql = "SELECT * FROM `abook` WHERE importbookid = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, importbookid);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Abook abook = mapAbook(rs);
                    list.add(abook);
                }
            }
        }
        return list;
    }
    
    public Integer getAcountAbookByImportBookId(int importbookid) throws SQLException {
        String sql = "SELECT COUNT(*) FROM `abook` WHERE importbookid = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, importbookid);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        }
        return 0;
    }
    
    public Abook getAbookById(int id) throws SQLException {
        String sql = "SELECT * FROM `abook` WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapAbook(rs);
                }
            }
        }
        return null;
    }

    public Abook getAbookByAbookId(String abookid) throws SQLException {
        String sql = "SELECT * FROM `abook` WHERE abookid = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, abookid);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapAbook(rs);
                }
            }
        }
        return null;
    }

    public void addAbook(int bookid, int importbookid, String abookid) throws SQLException {
        String sql = "INSERT INTO `abook`(`bookid`, `abookid`, `importbookid`, `status`) VALUES (?,?,?,?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, bookid);
            ps.setString(2, abookid);
            ps.setInt(3, importbookid);
            ps.setInt(4, 1);
            ps.executeUpdate();
        }
    }

    void updateAbookStatusFalse(int id) throws SQLException {
        String sql = "UPDATE `abook` SET `status`= 0 WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    void updateAbookStatusTrue(int id) throws SQLException {
        String sql = "UPDATE `abook` SET `status`= 1 WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    private Abook mapAbook(ResultSet rs) throws SQLException {
        return new Abook(rs.getInt("id"), rs.getString("abookid"), rs.getBoolean("status"), new BookDAO().getBookById(rs.getInt("bookid")));
    }
}
