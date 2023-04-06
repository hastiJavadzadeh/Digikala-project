package org.example;

public class Refrigerator extends HomeAndKitchen{
    private String modelName;
    private double height;

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }


    public Refrigerator(String name, double price, int quantity, String category, Seller seller, String ID, String brand, String color, String modelName, double height) {
        super(name, price, quantity, category, seller, ID, brand, color);
        this.modelName = modelName;
        this.height = height;
    }
}
