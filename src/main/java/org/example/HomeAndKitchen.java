package org.example;

public class HomeAndKitchen extends Product{
    private String brand;
    private String color;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public HomeAndKitchen(String name, double price, int quantity, String category, Seller seller, String ID, String brand, String color) {
        super(name, price, quantity, category, seller, ID);
        this.brand = brand;
        this.color = color;
    }
}
