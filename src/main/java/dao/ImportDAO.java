/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Import;
import model.ImportBook;

/**
 *
 * @author Admin
 */
public class ImportDAO extends Connect{
    
    public Import getImportLimit1(int userid, int supplierid) throws SQLException{
        String sql = "SELECT * FROM `import` WHERE userid = ? AND supplierid = ? ORDER BY id DESC LIMIT 1";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, userid);
            ps.setInt(2, supplierid);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapImport(rs);
                }
            }
        }
        return null;
    }
    
    public List<Import> getAllImportDeliveryDateNull() throws SQLException{
        List<Import> list = new ArrayList<>();
        String sql = "SELECT * FROM `import` WHERE deliverydate IS NULL ORDER BY id DESC";
        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Import i = mapImport(rs);
                list.add(i);
            }
        }
        return list;
    }
    
    public List<Import> getAllImportDeliveryDateNotNull() throws SQLException{
        List<Import> list = new ArrayList<>();
        String sql = "SELECT * FROM `import` WHERE deliverydate IS NOT NULL ORDER BY id DESC";
        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Import i = mapImport(rs);
                list.add(i);
            }
        }
        return list;
    }
    
    public Import getImportById(int id) throws SQLException{
        String sql = "SELECT * FROM `import` WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapImport(rs);
                }
            }
        }
        return null;
    }
    
    public List<Import> getImportBySupplierId(int supplierid) throws SQLException{
        List<Import> list = new ArrayList<>();
        String sql = "SELECT * FROM `import` WHERE supplierid = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, supplierid);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Import i = mapImport(rs);
                    list.add(i);
                }
            }
        }
        return list;
    }

    public List<Import> getImportDeliveryNotNullBySupplierId(int supplierid) throws SQLException {
        List<Import> list = new ArrayList<>();
        String sql = "SELECT * FROM `import` WHERE supplierid = ? AND deliverydate IS NOT NULL";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, supplierid);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Import i = mapImport(rs);
                    list.add(i);
                }
            }
        }
        return list;
    }

    public List<Import> getImportDeliveryNullBySupplierId(int supplierid) throws SQLException {
        List<Import> list = new ArrayList<>();
        String sql = "SELECT * FROM `import` WHERE supplierid = ? AND deliverydate IS NULL";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, supplierid);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Import i = mapImport(rs);
                    list.add(i);
                }
            }
        }
        return list;
    }

    public List<Import> getImportByDateDelivery(Date dateStartSql, Date dateEndSql) throws SQLException {
        List<Import> list = new ArrayList<>();
        String sql = "SELECT * FROM `import` WHERE deliverydate >= ? AND deliverydate <= ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setDate(1, dateStartSql);
            ps.setDate(2, dateEndSql);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Import i = mapImport(rs);
                    list.add(i);
                }
            }
        }
        return list;
    }
    
    public void addImport(Import i) throws SQLException{
        this.insertImport(i);
        Import i_new = this.getImportLimit1(i.getUser().getId(), i.getSupplier().getId());
        for(ImportBook ib : i.getImportbook()){
            new ImportBookDAO().insertImportBook(i_new.getId(), ib);
        }
    }
    
    public void insertImport(Import i) throws SQLException{
        String sql = "INSERT INTO `import`(`userid`, `supplierid`, `importdate`) VALUES (?,?,?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, i.getUser().getId());
            ps.setInt(2, i.getSupplier().getId());
            ps.setDate(3, i.getImportdate());
            ps.executeUpdate();
        }
    }
    
    public void updateImport(Date dateDelivery, int id) throws SQLException{
        String sql = "UPDATE `import` SET `deliverydate`= ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setDate(1, dateDelivery);
            ps.setInt(2, id);
            ps.executeUpdate();
        }
    }
    
    public void deleteImport(int id) throws SQLException{
        new ImportBookDAO().deleteImportBookByImportid(id);
        String sql = "DELETE FROM `import` WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    private Import mapImport(ResultSet rs) throws SQLException {
        return new Import(rs.getInt("id"), rs.getDate("importdate"), rs.getDate("deliverydate"), 
                new UserDAO().getUserById(rs.getInt("userid")), 
                new SupplierDAO().getSupplierById(rs.getInt("supplierid")), 
                new ImportBookDAO().getImportBookByImportId(rs.getInt("id")));
    }

}
