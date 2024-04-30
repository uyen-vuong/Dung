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
import model.BorrowReturn;
import model.Violation;

/**
 *
 * @author Admin
 */
public class ViolationDAO extends Connect{

    private Violation getViolationByReaderid(int readerid) throws SQLException {
        String sql = "SELECT * FROM `violation` WHERE readerid = ? ORDER BY id DESC LIMIT 1";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, readerid);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapViolation(rs);
                }
            }
        }
        return null;
    }

    public List<Violation> getAllViolation() throws SQLException {
        List<Violation> list = new ArrayList<>();
        String sql = "SELECT * FROM `violation`";
        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Violation v = mapViolation(rs);
                list.add(v);
            }
        }
        return list;
    }

    public List<Violation> getViolationByDate(Date dateStart, Date dateEnd) throws SQLException {
        List<Violation> list = new ArrayList<>();
        String sql = "SELECT * FROM `violation` WHERE date >= ? AND date <= ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setDate(1, dateStart);
            ps.setDate(2, dateEnd);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Violation v = mapViolation(rs);
                    list.add(v);
                }
            }
        }
        return list;
    }

    public List<Violation> getViolationByKey(String keyString) throws SQLException {
        List<Violation> list = new ArrayList<>();
        String sql = "SELECT violation.`id`, violation.`readerid`, violation.`userid`, violation.`date`, violation.`note` FROM `violation`, reader WHERE violation.readerid = reader.id AND reader.fullname LIKE '%" + keyString + "%'";
        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Violation v = mapViolation(rs);
                list.add(v);
            }
        }
        return list;
    }

    public void addViolation(Violation v) throws SQLException {
        this.insertViolation(v);
        Violation v_new = this.getViolationByReaderid(v.getReader().getId());
        int violationid = v_new.getId();
        for(BorrowReturn br : v.getBorrowReturn()){
            new BorrowReturnDAO().updateErrorBook(br);
            this.insertViolationReturn(violationid, br.getId());
        }
    }

    private void insertViolation(Violation v) throws SQLException {
        String sql = "INSERT INTO `violation`(`readerid`, `userid`, `date`, `note`) VALUES (?,?,?,?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, v.getReader().getId());
            ps.setInt(2, v.getUser().getId());
            ps.setDate(3, v.getDate());
            ps.setString(4, v.getNote());
            ps.executeUpdate();
        }
    }
    
    
    private void insertViolationReturn(int violationid, int borrowreturnid) throws SQLException {
        String sql = "INSERT INTO `violationreturn`(`violationid`, `borrowreturnid`) VALUES (?,?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, violationid);
            ps.setInt(2, borrowreturnid);
            ps.executeUpdate();
        }
    }
    
    
    private Violation mapViolation(ResultSet rs) throws SQLException {
        return new Violation(rs.getInt("id"), rs.getDate("date"), rs.getString("note"), new ReaderDAO().getReaderById(rs.getInt("readerid")), new UserDAO().getUserById(rs.getInt("userid")), new BorrowReturnDAO().getBorrowReturnByViolationId(rs.getInt("id")));
    }
    
}
