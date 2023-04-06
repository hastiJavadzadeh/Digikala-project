package org.example;

public class Carpet extends HomeAndKitchen{
    private String shape;
    private double height;
    private double width;

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public Carpet(String name, double price, int quantity, String category, Seller seller, String ID, String brand, String color, String shape, double height, double width) {
        super(name, price, quantity, category, seller, ID, brand, color);
        this.shape = shape;
        this.height = height;
        this.width = width;
    }
}
