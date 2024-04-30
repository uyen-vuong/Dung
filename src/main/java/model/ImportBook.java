/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;

/**
 *
 * @author Admin
 */
public class ImportBook {
    private int id, quantity, price;
    private String namebook;
    private List<Abook> abook;

    public ImportBook() {
    }

    public ImportBook(int id, int quantity, int price, String namebook, List<Abook> abook) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.namebook = namebook;
        this.abook = abook;
    }

    public ImportBook(int quantity, int price, String namebook) {
        this.quantity = quantity;
        this.price = price;
        this.namebook = namebook;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getNamebook() {
        return namebook;
    }

    public void setNamebook(String namebook) {
        this.namebook = namebook;
    }

    public List<Abook> getAbook() {
        return abook;
    }

    public void setAbook(List<Abook> abook) {
        this.abook = abook;
    }
    
}
