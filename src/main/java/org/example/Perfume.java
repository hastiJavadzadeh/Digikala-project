package org.example;

public class Perfume extends PersonalCare{
    private double volume;
    private String scent;

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public String getScent() {
        return scent;
    }

    public void setScent(String scent) {
        this.scent = scent;
    }
    public Perfume(String name, double price, int quantity, String category, Seller seller, String ID, String brand, String ageRange, double volume, String scent) {
        super(name, price, quantity, category, seller, ID, brand, ageRange);
        this.volume = volume;
        this.scent = scent;
    }
}
