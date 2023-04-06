package org.example;

public class Pants extends Cloths{
    private int height;
    private String type;// casual or formal or ...

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Pants(String name, double price, int quantity, String category, Seller seller, String ID, String color, String size, String material, int height, String type) {
        super(name, price, quantity, category, seller, ID, color, size, material);
        this.height = height;
        this.type = type;
    }
}
