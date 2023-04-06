package org.example;

public class Camera extends Electronics{

    private String opticalZoom;


    public String getOpticalZoom() {
        return opticalZoom;
    }

    public void setOpticalZoom(String opticalZoom) {
        this.opticalZoom = opticalZoom;
    }

    public Camera(String name, double price, int quantity, String category, Seller seller, String ID, String color, String brand, double weight, String opticalZoom) {
        super(name, price, quantity, category, seller, ID, color, brand, weight);
        this.opticalZoom = opticalZoom;
    }
}
