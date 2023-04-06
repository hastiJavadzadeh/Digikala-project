package org.example;

public class Shampoo extends PersonalCare{
    private double volume;
    private String hairType;

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public String getHairType() {
        return hairType;
    }

    public void setHairType(String hairType) {
        this.hairType = hairType;
    }


    public Shampoo(String name, double price, int quantity, String category, Seller seller, String ID, String brand, String ageRange, double volume, String hairType) {
        super(name, price, quantity, category, seller, ID, brand, ageRange);
        this.volume = volume;
        this.hairType = hairType;
    }
}
