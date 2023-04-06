package org.example;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class User {
    private String username;
    private String password;
    private String email;
    private String address;
    private String phoneNumber;
    private double wallet;
    ArrayList<Product> cart = new ArrayList<>();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

    //cart
    public boolean addProductToCart(String ID, Shop shop) {
        for (int i = 0; i < shop.allProducts.size(); i++) {
            if (ID.equals(shop.allProducts.get(i).getID())) {
                cart.add(shop.allProducts.get(i));
                return true;
            }
        }
        return false;
    }

    public boolean removeProductFromCart(String ID, Shop shop) {
        for (int i = 0; i < shop.allProducts.size(); i++) {
            if (ID.equals(shop.allProducts.get(i).getID())) {
                cart.remove(shop.allProducts.get(i));
                return true;
            }
        }
        return false;
    }

    public boolean increaseNumberOfAnItem(String name) {
        for (int i = 0; i < cart.size(); i++) {
            if (name.equals(cart.get(i).getName())) {
                cart.get(i).setQuantity(cart.get(i).getQuantity() + 1);
                return true;
            }
        }
        return false;
    }
    public void viewCart() {
        double totalPrice = 0;
        for (int i = 0; i < cart.size(); i++) {
            System.out.println("**Product " + (i+1) + " : ");
            System.out.println("Name : " + cart.get(i).getName());
            System.out.println("Price : " + cart.get(i).getPrice());
            totalPrice += cart.get(i).getPrice();
        }
        System.out.println("Total price : " + totalPrice);
    }


    public User(String username, String password, String phoneNumber, String email, String address) {
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email =email;
        this.address = address;
    }
}
