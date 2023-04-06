package org.example;

public class Pen extends Product{
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

    public Pen(String name, double price, int quantity, String category, Seller seller, String ID, String color, String brand) {
        super(name, price, quantity, category, seller, ID);
        this.color = color;
        this.brand = brand;
    }
}
