package br.com.smartlist.app.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "Items")
public class Item {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "lists_id")
    @JsonIgnoreProperties("items")
    private Lists lists;

    public Item() {
    }

    public Item(Long id, String name, double price, int quantity, Lists lists) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.lists = lists;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Lists getLists() {
        return lists;
    }
    
    public void setLists(Lists lists) {
        this.lists = lists;
    }
    

    
}
