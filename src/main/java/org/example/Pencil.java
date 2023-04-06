package org.example;

public class Pencil extends Product{
    private String color;
    private String brand;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Pencil(String name, double price, int quantity, String category, Seller seller, String color, String brand, String ID) {
        super(name, price, quantity, category, seller, ID);
        this.color = color;
        this.brand = brand;
    }
}

