package org.example;

public class Dumbbell extends Sport{

    private String shape;

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }


    public Dumbbell(String name, double price, int quantity, String category, Seller seller, String ID, double weight, String color, String shape) {
        super(name, price, quantity, category, seller, ID, weight, color);
        this.shape = shape;
    }
}
