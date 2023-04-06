package org.example;

public class Shoes extends Cloths{
    private String brand;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }


    public Shoes(String name, double price, int quantity, String category, Seller seller, String ID, String color, String size, String material, String brand) {
        super(name, price, quantity, category, seller, ID, color, size, material);
        this.brand = brand;
    }
}
