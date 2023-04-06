package org.example;

public class Sport extends Product{

    private double weight;
    private String color;

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Sport(String name, double price, int quantity, String category, Seller seller, String ID, double weight, String color) {
        super(name, price, quantity, category, seller, ID);
        this.color = color;
        this.weight = weight;
    }
}
