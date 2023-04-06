package org.example;

public class Laptop extends Electronics{
    private String OS;
    private int ram;
    private int storage;
    private String CPU;

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

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public Laptop(String name, double price, int quantity, String category, Seller seller, String ID, String color, String brand, double weight, String OS, int ram, int storage, String CPU) {
        super(name, price, quantity, category, seller, ID, color, brand, weight);
        this.OS = OS;
        this.ram = ram;
        this.storage = storage;
        this.CPU = CPU;
    }
}
