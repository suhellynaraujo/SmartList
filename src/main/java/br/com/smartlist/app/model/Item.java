package br.com.smartlist.app.model;

import java.util.List;

public class Item {
    
    private Long id;
    private String name;
    private double price;
    private double totalPrice;
    private List<Item> intens;

    public Item() {
    }

    public Item(Long id, String name, double price, double totalPrice, List<Item> intens) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.totalPrice = totalPrice;
        this.intens = intens;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<Item> getIntens() {
        return intens;
    }

    public void setIntens(List<Item> intens) {
        this.intens = intens;
    }   

}
