package org.example;

public class Bicycle extends Sport{

    private String ageRange;
    private String material;


    public String getAgeRange() {
        return ageRange;
    }

    public void setAgeRange(String ageRange) {
        this.ageRange = ageRange;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Bicycle(String name, double price, int quantity, String category, Seller seller, String ID, double weight, String color, String ageRange, String material) {
        super(name, price, quantity, category, seller, ID, weight, color);
        this.ageRange = ageRange;
        this.material = material;
    }

}
