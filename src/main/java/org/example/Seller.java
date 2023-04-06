package org.example;

//????????

import java.util.ArrayList;

public class Seller {
    private String companyName;
    private String password;
    private ArrayList<Product> availableProducts = new ArrayList<>();
    private double wallet;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Product> getAvailableProducts() {
        return availableProducts;
    }

    public void setAvailableProducts(ArrayList<Product> availableProducts) {
        this.availableProducts = availableProducts;
    }

    public double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

    //Books and art
    public void addBook(Book book, Shop shop) {
        availableProducts.add(book);
        shop.allProducts.add(book);
        shop.books.add(book);
    }

    public void addPen(Pen pen, Shop shop) {
        availableProducts.add(pen);
        shop.allProducts.add(pen);
        shop.pens.add(pen);
    }

    public void addPencil(Pencil pencil, Shop shop) {
        availableProducts.add(pencil);
        shop.allProducts.add(pencil);
        shop.pencils.add(pencil);
    }

    //Cloths
    public void addShirt(Shirt shirt, Shop shop) {
        availableProducts.add(shirt);
        shop.allProducts.add(shirt);
        shop.shirts.add(shirt);
    }

    public void addPants(Pants pants, Shop shop) {
        availableProducts.add(pants);
        shop.allProducts.add(pants);
        shop.pants.add(pants);
    }

    public void addShoes(Shoes shoes, Shop shop) {
        availableProducts.add(shoes);
        shop.allProducts.add(shoes);
        shop.shoes.add(shoes);
    }

    //Electronics
    public void addCamera(Camera camera, Shop shop) {
        availableProducts.add(camera);
        shop.allProducts.add(camera);
        shop.cameras.add(camera);
    }

    public void addLaptop(Laptop laptop, Shop shop) {
        availableProducts.add(laptop);
        shop.allProducts.add(laptop);
        shop.laptops.add(laptop);
    }

    public void addPhone(Phone phone, Shop shop) {
        availableProducts.add(phone);
        shop.allProducts.add(phone);
        shop.phones.add(phone);
    }

    //Home and kitchen
    public void addBed(Bed bed, Shop shop) {
        availableProducts.add(bed);
        shop.allProducts.add(bed);
        shop.beds.add(bed);
    }

    public void addCarpet(Carpet carpet, Shop shop) {
        availableProducts.add(carpet);
        shop.allProducts.add(carpet);
        shop.carpets.add(carpet);
    }

    public void addRefrigerator(Refrigerator refrigerator, Shop shop) {
        availableProducts.add(refrigerator);
        shop.allProducts.add(refrigerator);
        shop.refrigerators.add(refrigerator);
    }

    //Personal care
    public void addPerfume(Perfume perfume, Shop shop) {
        availableProducts.add(perfume);
        shop.allProducts.add(perfume);
        shop.perfumes.add(perfume);
    }

    public void addShampoo(Shampoo shampoo, Shop shop) {
        availableProducts.add(shampoo);
        shop.allProducts.add(shampoo);
        shop.shampoos.add(shampoo);
    }

    public void addToothbrush(ToothBrush toothBrush, Shop shop) {
        availableProducts.add(toothBrush);
        shop.allProducts.add(toothBrush);
        shop.toothBrushes.add(toothBrush);
    }

    //Sport
    public void addBicycle(Bicycle bicycle, Shop shop) {
        availableProducts.add(bicycle);
        shop.allProducts.add(bicycle);
        shop.bicycles.add(bicycle);
    }

    public void addDumbbell(Dumbbell dumbbell, Shop shop) {
        availableProducts.add(dumbbell);
        shop.allProducts.add(dumbbell);
        shop.dumbbells.add(dumbbell);
    }



    public Seller(String companyName, String password) {
        this.companyName = companyName;
        this.password = password;
    }

}
