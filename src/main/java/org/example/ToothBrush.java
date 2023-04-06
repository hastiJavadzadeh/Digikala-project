package org.example;

public class ToothBrush extends PersonalCare {
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public ToothBrush(String name, double price, int quantity, String category, Seller seller, String ID, String brand, String ageRange, String color) {
        super(name, price, quantity, category, seller, ID, brand, ageRange);
        this.color = color;
    }
}
