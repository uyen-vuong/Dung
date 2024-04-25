/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class Book {
    private int id, price, numberpage;
    private String name, author;
    private String description;
    private Genre genre;

    public Book() {
    }

    public Book(int id, int price, int numberpage, String name, String author, String description, Genre genre) {
        this.id = id;
        this.price = price;
        this.numberpage = numberpage;
        this.name = name;
        this.author = author;
        this.description = description;
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumberpage() {
        return numberpage;
    }

    public void setNumberpage(int numberpage) {
        this.numberpage = numberpage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    
    
}
