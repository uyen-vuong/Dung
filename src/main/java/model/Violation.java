/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;
import java.util.List;

/**
 *
 * @author Admin
 */
public class Violation {
    private int id;
    private Date date;
    private String note;
    private Reader reader;
    private User user;
    private List<BorrowReturn> borrowReturn;
    public Violation() {
    }

    public Violation(int id, Date date, String note, Reader reader, User user, List<BorrowReturn> borrowReturn) {
        this.id = id;
        this.date = date;
        this.note = note;
        this.reader = reader;
        this.user = user;
        this.borrowReturn = borrowReturn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<BorrowReturn> getBorrowReturn() {
        return borrowReturn;
    }

    public void setBorrowReturn(List<BorrowReturn> borrowReturn) {
        this.borrowReturn = borrowReturn;
    }

    

    
}
