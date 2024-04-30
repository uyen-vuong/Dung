/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class ErrorBook {
    private int id, percentage;
    private String name;

    public ErrorBook() {
    }

    public ErrorBook(int id, int percentage, String name) {
        this.id = id;
        this.percentage = percentage;
        this.name = name;
    }

    public ErrorBook(int percentage, String name) {
        this.percentage = percentage;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
