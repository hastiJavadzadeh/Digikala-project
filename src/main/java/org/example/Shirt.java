package org.example;

public class Shirt extends Cloths{
    private String collarModel;
    private String type;// casual or formal or ...

    public String getCollarModel() {
        return collarModel;
    }

    public void setCollarModel(String collarModel) {
        this.collarModel = collarModel;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Shirt(String name, double price, int quantity, String category, Seller seller, String ID, String color, String size, String material, String collarModel, String type) {
        super(name, price, quantity, category, seller, ID, color, size, material);
        this.collarModel = collarModel;
        this.type = type;
    }
}
