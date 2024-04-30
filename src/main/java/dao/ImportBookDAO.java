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
import model.Abook;
import model.ImportBook;

/**
 *
 * @author Admin
 */
public class ImportBookDAO extends Connect{
    public List<ImportBook> getImportBookByImportId(int importid) throws SQLException{
        List<ImportBook> list = new ArrayList<>();
        String sql = "SELECT * FROM `importbook` WHERE importid = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, importid);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    ImportBook ib = mapImportBook(rs);
                    list.add(ib);
                }
            }
        }
        return list;
    }
    
    public ImportBook getImportBookById(int id) throws SQLException{
        String sql = "SELECT * FROM `importbook` WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapImportBook(rs);
                }
            }
        }
        return null;
    }

    public List<ImportBook> getAllImportBook() throws SQLException {
        List<ImportBook> list = new ArrayList<>();
        String sql = "SELECT * FROM `importbook` ORDER BY importid DESC";
        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while(rs.next()) {
                ImportBook ib = mapImportBook(rs);
                list.add(ib);
            }
        }
        return list;
    }

    public int getSupplierId(int id) throws SQLException {
        String sql = "SELECT importid FROM `importbook` WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("importid");
                }
            }
        }
        return 0;
    }
    
    public void insertImportBook(int importid, ImportBook ib) throws SQLException{
        String sql = "INSERT INTO `importbook`(`importid`, `namebook`, `quantity`, `price`) VALUES(?,?,?,?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, importid);
            ps.setString(2, ib.getNamebook());
            ps.setInt(3, ib.getQuantity());
            ps.setInt(4, ib.getPrice());
            ps.executeUpdate();
        }
    }
    
    public void deleteImportBookByImportid(int importid) throws SQLException{
        String sql = "DELETE FROM `importbook` WHERE importid = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, importid);
            ps.executeUpdate();
        }
    }

    private ImportBook mapImportBook(ResultSet rs) throws SQLException {
        return new ImportBook(rs.getInt("id"), rs.getInt("quantity"), rs.getInt("price"), rs.getString("namebook"), new AbookDAO().getAbookByImportBookId(rs.getInt("id")));
    }
    
//    public static void main(String[] args) {
//        List<Abook> list;
//        try {
//            list = new ImportBookDAO().getImportBookById(2).getAbook();
//            for(Abook a : list){
//                System.out.println(a.getAbookid());
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(ImportBookDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}
