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
public class BorrowReturn {
    private int id;
    private Date duedate;
    private Date borrowdate, returndate;
    private Abook abook;
    private Reader reader;
    private List<ErrorBook> errorBook;

    public BorrowReturn() {
    }

    public BorrowReturn(int id, Date duedate, Date borrowdate, Date returndate, Abook abook, Reader reader, List<ErrorBook> errorBook) {
        this.id = id;
        this.duedate = duedate;
        this.borrowdate = borrowdate;
        this.returndate = returndate;
        this.abook = abook;
        this.reader = reader;
        this.errorBook = errorBook;
    }

    public BorrowReturn(Date duedate, Date borrowdate, Abook abook, Reader reader) {
        this.duedate = duedate;
        this.borrowdate = borrowdate;
        this.abook = abook;
        this.reader = reader;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDuedate() {
        return duedate;
    }

    public void setDuedate(Date duedate) {
        this.duedate = duedate;
    }

    public Date getBorrowdate() {
        return borrowdate;
    }

    public void setBorrowdate(Date borrowdate) {
        this.borrowdate = borrowdate;
    }

    public Date getReturndate() {
        return returndate;
    }

    public void setReturndate(Date returndate) {
        this.returndate = returndate;
    }

    public Abook getAbook() {
        return abook;
    }

    public void setAbook(Abook abook) {
        this.abook = abook;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public List<ErrorBook> getErrorBook() {
        return errorBook;
    }

    public void setErrorBook(List<ErrorBook> errorBook) {
        this.errorBook = errorBook;
    }

    
    
    
}
