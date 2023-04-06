package org.example;


public class Electronics extends Product{
    private String color;

    private String brand;
    private double weight;



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

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }


    public Electronics(String name, double price, int quantity, String category, Seller seller, String ID, String color, String brand, double weight) {
        super(name, price, quantity, category, seller, ID);
        this.color = color;
        this.brand = brand;
        this.weight = weight;
    }
}
