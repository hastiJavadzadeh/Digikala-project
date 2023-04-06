package org.example;


public class Product {
    private String name;
    private double price;
    private int quantity;
    private String category;
    private Seller seller;
    private String ID; // 10 digits

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Product(String name, double price, int quantity, String category, Seller seller, String ID) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
        this.seller = seller;
        this.ID = ID;
    }
}
