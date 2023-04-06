package org.example;

// done,   somehow...
public class Cloths extends Product{
    private String color;
    private String size;
    private String material;


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Cloths(String name, double price, int quantity, String category, Seller seller, String ID, String color, String size, String material) {
        super(name, price, quantity, category, seller, ID);
        this.color = color;
        this.size = size;
        this.material = material;
    }

}
