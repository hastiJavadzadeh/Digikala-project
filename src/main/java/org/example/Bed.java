package org.example;

public class Bed extends HomeAndKitchen{
    private String size;
    private String material;

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

    public Bed(String name, double price, int quantity, String category, Seller seller, String ID, String brand, String color, String size, String material) {
        super(name, price, quantity, category, seller, ID, brand, color);
        this.size = size;
        this.material = material;
    }
}
