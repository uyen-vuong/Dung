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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.BorrowReturn;
import model.ErrorBook;

/**
 *
 * @author Admin
 */
public class BorrowReturnDAO extends Connect {

    private BorrowReturn mapBorrowReturn(ResultSet rs) throws SQLException {
        return new BorrowReturn(rs.getInt("id"), rs.getDate("duedate"), rs.getDate("borrowdate"), rs.getDate("returndate"), new AbookDAO().getAbookById(rs.getInt("abookid")), new ReaderDAO().getReaderById(rs.getInt("readerid")), new ErrorBookDAO().getErrorBookByBorrowReturnId(rs.getInt("id")));
    }

    public List<BorrowReturn> getBorrowReturnNotReturnByReaderId(int readerid) throws SQLException {
        List<BorrowReturn> list = new ArrayList<>();
        String sql = "SELECT * FROM `borrowreturn` WHERE readerid = ? AND returndate IS NULL";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, readerid);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    BorrowReturn br = mapBorrowReturn(rs);
                    list.add(br);
                }
            }
        }
        return list;
    }

    public BorrowReturn getBorrowReturnById(int id) throws SQLException {
        String sql = "SELECT * FROM `borrowreturn` WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapBorrowReturn(rs);
                }
            }
        }
        return null;
    }

    public List<BorrowReturn> getBorrowReturnByDateReturnNull() throws SQLException {
        List<BorrowReturn> list = new ArrayList<>();
        String sql = "SELECT * FROM `borrowreturn` WHERE returndate IS NULL";
        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                BorrowReturn br = mapBorrowReturn(rs);
                list.add(br);
            }
        }
        return list;
    }

    public List<BorrowReturn> getBorrowReturnByDateReturnNotNull() throws SQLException {
        List<BorrowReturn> list = new ArrayList<>();
        String sql = "SELECT * FROM `borrowreturn` WHERE returndate IS NOT NULL";
        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                BorrowReturn br = mapBorrowReturn(rs);
                list.add(br);
            }
        }
        return list;
    }

    public List<BorrowReturn> getBorrowReturnByDateReturnNullAndDateBorrow(Date dateStartSql, Date dateEndSql) throws SQLException {
        List<BorrowReturn> list = new ArrayList<>();
        String sql = "SELECT * FROM `borrowreturn` WHERE returndate IS NULL AND borrowdate >= ? AND borrowdate <= ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setDate(1, dateStartSql);
            ps.setDate(2, dateEndSql);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    BorrowReturn br = mapBorrowReturn(rs);
                    list.add(br);
                }
            }
        }
        return list;
    }

    public List<BorrowReturn> getBorrowReturnByDateReturnNullAndDateDue(Date currentDate) throws SQLException {
        List<BorrowReturn> list = new ArrayList<>();
        String sql = "SELECT * FROM `borrowreturn` WHERE returndate IS NULL AND duedate < ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setDate(1, currentDate);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    BorrowReturn br = mapBorrowReturn(rs);
                    list.add(br);
                }
            }
        }
        return list;
    }

    List<BorrowReturn> getBorrowReturnByViolationId(int violationid) throws SQLException {
        List<BorrowReturn> list = new ArrayList<>();
        String sql = "SELECT * FROM `violationreturn` WHERE violationid = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, violationid);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    BorrowReturn br = this.getBorrowReturnById(rs.getInt("borrowreturnid"));
                    list.add(br);
                }
            }
        }
        return list;
    }

    public List<BorrowReturn> getBorrowReturnByDateReturnNullAndDateReturn(Date dateStart, Date dateEnd) throws SQLException {
        List<BorrowReturn> list = new ArrayList<>();
        String sql = "SELECT * FROM `borrowreturn` WHERE returndate IS NOT NULL AND returndate >= ? AND returndate <= ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setDate(1, dateStart);
            ps.setDate(2, dateEnd);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    BorrowReturn br = mapBorrowReturn(rs);
                    list.add(br);
                }
            }
        }
        return list;
    }

    public List<BorrowReturn> getBorrowReturnByDateReturnNotNullAndErrorBook() throws SQLException {
        List<BorrowReturn> list = new ArrayList<>();
        String sql = "SELECT DISTINCT borrowreturnid FROM errorbookreturn;";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    BorrowReturn br = this.getBorrowReturnById(rs.getInt("borrowreturnid"));
                    list.add(br);
                }
            }
        }
        return list;
    }

    public void addBorrowReturn(BorrowReturn br) throws SQLException {
        new AbookDAO().updateAbookStatusFalse(br.getAbook().getId());
        String sql = "INSERT INTO `borrowreturn`(`readerid`, `abookid`, `borrowdate`, `duedate`) VALUES (?,?,?,?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, br.getReader().getId());
            ps.setInt(2, br.getAbook().getId());
            ps.setDate(3, br.getBorrowdate());
            ps.setDate(4, br.getDuedate());
            ps.executeUpdate();
        }
    }

    public void updateBorrowReturnDueDate(Date dueDateSql, int id) throws SQLException {
        String sql = "UPDATE `borrowreturn` SET `duedate`= ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setDate(1, dueDateSql);
            ps.setInt(2, id);
            ps.executeUpdate();
        }
    }

    public void updateBorrowReturnDateReturn(Date returnDate, int id) throws SQLException {
        BorrowReturn br = this.getBorrowReturnById(id);
        int abookid = br.getAbook().getId();
        new AbookDAO().updateAbookStatusTrue(abookid);
        String sql = "UPDATE `borrowreturn` SET `returndate`= ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setDate(1, returnDate);
            ps.setInt(2, id);
            ps.executeUpdate();
        }
    }

    public void updateErrorBook(BorrowReturn br) throws SQLException {
        for (ErrorBook eb : br.getErrorBook()) {
            this.insertErrorBookReturn(br.getId(), eb.getId());
        }
    }

    private void insertErrorBookReturn(int borrowreturnid, int errorbookid) throws SQLException {
        String sql = "INSERT INTO `errorbookreturn`(`borrowreturnid`, `errorbookid`) VALUES (?,?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, borrowreturnid);
            ps.setInt(2, errorbookid);
            ps.executeUpdate();
        }
    }
}
