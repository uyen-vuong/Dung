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
public class Import {
    private int id;
    private Date importdate, deliverydate;
    private User user;
    private Supplier supplier;
    private List<ImportBook> importbook;

    public Import() {
    }

    public Import(int id, Date importdate, Date deliverydate, User user, Supplier supplier, List<ImportBook> importbook) {
        this.id = id;
        this.importdate = importdate;
        this.deliverydate = deliverydate;
        this.user = user;
        this.supplier = supplier;
        this.importbook = importbook;
    }

    public Import(Date importdate, User user, Supplier supplier, List<ImportBook> importbook) {
        this.importdate = importdate;
        this.user = user;
        this.supplier = supplier;
        this.importbook = importbook;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getImportdate() {
        return importdate;
    }

    public void setImportdate(Date importdate) {
        this.importdate = importdate;
    }

    public Date getDeliverydate() {
        return deliverydate;
    }

    public void setDeliverydate(Date deliverydate) {
        this.deliverydate = deliverydate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public List<ImportBook> getImportbook() {
        return importbook;
    }

    public void setImportbook(List<ImportBook> importbook) {
        this.importbook = importbook;
    }

    
    
}
