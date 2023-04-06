package org.example;

public class Phone extends Electronics{
    private String OS;
    private int ram;
    private int storage;
    private String cameraQuality;
    private double screenSize;

    public String getOS() {
        return OS;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public String getCameraQuality() {
        return cameraQuality;
    }

    public void setCameraQuality(String cameraQuality) {
        this.cameraQuality = cameraQuality;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public Phone(String name, double price, int quantity, String category, Seller seller, String ID, String color, String brand, double weight, String OS, int ram, int storage, String cameraQuality, double screenSize) {
        super(name, price, quantity, category, seller, ID, color, brand, weight);
        this.OS = OS;
        this.ram = ram;
        this.storage = storage;
        this.cameraQuality = cameraQuality;
        this.screenSize = screenSize;
    }
}
