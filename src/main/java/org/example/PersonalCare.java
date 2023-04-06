package org.example;

public class PersonalCare extends Product{

    private String brand;
    private String ageRange;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getAgeRange() {
        return ageRange;
    }

    public void setAgeRange(String ageRange) {
        this.ageRange = ageRange;
    }

    public PersonalCare(String name, double price, int quantity, String category, Seller seller, String ID, String brand, String ageRange) {
        super(name, price, quantity, category, seller, ID);
        this.brand = brand;
        this.ageRange = ageRange;
    }
}
