/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class Abook {
    private int id;
    private String abookid;
    private boolean status;
    private Book book;

    public Abook() {
    }

    public Abook(int id, String abookid, boolean status, Book book) {
        this.id = id;
        this.abookid = abookid;
        this.status = status;
        this.book = book;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAbookid() {
        return abookid;
    }

    public void setAbookid(String abookid) {
        this.abookid = abookid;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    
    
}
