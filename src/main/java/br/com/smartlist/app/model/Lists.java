package br.com.smartlist.app.model;

import java.util.List;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Lists {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double totalPrice;
    private double totalAvailable;
    private List<Item> items;

    public Lists() {
    }

    public Lists(Long id, String name, double totalPrice, double totalAvailable, List<Item> items) {
        this.id = id;
        this.name = name;
        this.totalPrice = totalPrice;
        this.totalAvailable = totalAvailable;
        this.items = items;
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

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getTotalAvailable() {
        return totalAvailable;
    }

    public void setTotalAvailable(double totalAvailable) {
        this.totalAvailable = totalAvailable;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
    
}
