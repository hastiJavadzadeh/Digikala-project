package org.example;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Shop {
    private String name;
    private String phone;
    private String webAddress;
    private double wallet;

//+++++++++++++++
    //Books and art
    ArrayList<Book> books = new ArrayList<>();
    ArrayList<Pencil> pencils = new ArrayList<>();
    ArrayList<Pen> pens = new ArrayList<>();

 //+++++++++++++++
    //Cloths
    ArrayList<Shirt> shirts = new ArrayList<>();
    ArrayList<Pants> pants = new ArrayList<>();
    ArrayList<Shoes> shoes = new ArrayList<>();

//+++++++++++++++++
    //Electronics
    ArrayList<Camera> cameras = new ArrayList<>();
    ArrayList<Laptop> laptops = new ArrayList<>();
    ArrayList<Phone> phones = new ArrayList<>();

//++++++++++++++++
    //Home and kitchen
    ArrayList<Bed> beds = new ArrayList<>();
    ArrayList<Carpet> carpets = new ArrayList<>();
    ArrayList<Refrigerator> refrigerators = new ArrayList<>();

//+++++++++++++++++
    //Personal care
    ArrayList<Perfume> perfumes = new ArrayList<>();
    ArrayList<Shampoo> shampoos = new ArrayList<>();
    ArrayList<ToothBrush> toothBrushes = new ArrayList<>();

//+++++++++++++++++
    //Sport
    ArrayList<Dumbbell> dumbbells = new ArrayList<>();
    ArrayList<Bicycle> bicycles = new ArrayList<>();

//+++++++++++++++++

    ArrayList<User> users = new ArrayList<>();
    ArrayList<Admin> admins = new ArrayList<>();
    ArrayList<Seller> sellers = new ArrayList<>();
    ArrayList<Product> allProducts = new ArrayList<>();

    HashMap<String, Double> fundRequests = new HashMap<String, Double>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebAddress() {
        return webAddress;
    }

    public void setWebAddress(String webAddress) {
        this.webAddress = webAddress;
    }

    public double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

    //user
    public void createUserAccount(User newUser) {
        users.add(newUser);
    }

    public boolean doesUserExist(String username) {
        for (int i = 0; i < users.size(); i++) {
            if (username.equals(users.get(i).getUsername())) {
                return true;
            }
        }
        return false;
    }

    public boolean isUserPasswordCorrect(String pass, String username) {
        for (int i = 0; i < users.size(); i++) {
            if (username.equals(users.get(i).getUsername()) && pass.equals(users.get(i).getPassword())) {
                return true;
            }
        }
        return false;
    }

    public void updateUser(User user, String newUsername, String newPassword, String newPhoneNumber, String newEmail, String newAddress) {
        //*************************
        user.setUsername(newUsername);
        user.setPassword(newPassword);
        user.setPhoneNumber(newPhoneNumber);
        user.setEmail(newEmail);
        user.setAddress(newAddress);
    }

    public void showWallet(String username) {
        for (int i = 0; i < users.size(); i++) {
            if (username.equals(users.get(i).getUsername())) {
                System.out.println(users.get(i).getWallet());
            }
        }
    }

    public void showUserProfile(String username) {
        for (int i = 0; i < users.size(); i++) {
            if (username.equals(users.get(i).getUsername())) {
                System.out.println("Username : " + users.get(i).getUsername());
                System.out.println("Password : " + users.get(i).getPassword());
                System.out.println("Address : " + users.get(i).getAddress());
                System.out.println("Email : " + users.get(i).getEmail());
                System.out.println("Phone number : " + users.get(i).getPhoneNumber());
            }
        }
    }

    public void addFundRequest(String username, double amount) {
        fundRequests.put(username, amount);
    }

    public void showOrder(User buyer) {

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println(dateFormat.format(date));

        System.out.println("Buyer info : ");
        System.out.println("Username : " + buyer.getUsername() +"\n"+ "Address : " + buyer.getAddress() +"\n"+ "Phone number : " + buyer.getPhoneNumber());
        double totalPrice = 0;
        for (int i = 0; i < buyer.cart.size(); i++) {
            System.out.println("**Product " + (i+1) + "** " + "\n" + "Name : " + buyer.cart.get(i).getName() + "\n" + "Price : " + buyer.cart.get(i).getPrice() + "\n" + "Seller : " + buyer.cart.get(i).getSeller().getCompanyName());

            totalPrice += buyer.cart.get(i).getPrice();
        }
        System.out.println("Total price : " + totalPrice);
    }

    public boolean checkout(User buyer, Shop shop) {

        double totalPrice = 0;
        for (int i = 0; i < buyer.cart.size(); i++) {
            totalPrice += buyer.cart.get(i).getPrice();
        }

        if (buyer.getWallet() >= totalPrice) {
            for (int i = 0; i < buyer.cart.size(); i++) {

                double previousFund = buyer.cart.get(i).getSeller().getWallet();
                double addedFund = (buyer.cart.get(i).getPrice()) * 0.9;

                //adding fund to seller's wallet
                buyer.cart.get(i).getSeller().setWallet(previousFund + addedFund);

                //adding fund to shop's wallet
                shop.setWallet(getWallet() + ((buyer.cart.get(i).getPrice()) * 0.1));

                //updating the product quantity
                for (int j = 0; j < allProducts.size(); j++) {
                    if (allProducts.get(j).equals(buyer.cart.get(i))) {
                        int newQuantity = allProducts.get(j).getQuantity() - 1;
                        if (newQuantity > 0) {
                            allProducts.get(j).setQuantity(newQuantity);
                        } else if (newQuantity == 0) {
                            allProducts.remove(buyer.cart.get(i));
                        }
                    }
                }
                //???
                for (int j = 0; j < buyer.cart.get(i).getSeller().getAvailableProducts().size(); j++) {
                    if (buyer.cart.get(i).getSeller().getAvailableProducts().get(j).equals(buyer.cart.get(i))) {
                        int newQuantity = buyer.cart.get(i).getSeller().getAvailableProducts().get(j).getQuantity() - 1;
                        if (newQuantity > 0) {
                            buyer.cart.get(i).getSeller().getAvailableProducts().get(j).setQuantity(newQuantity);
                        } else if (newQuantity == 0) {
                            buyer.cart.get(i).getSeller().getAvailableProducts().remove(buyer.cart.get(i));
                        }
                    }
                }

            }
            for (int i = 0; i < buyer.cart.size(); i++) {
                buyer.cart.remove(buyer.cart.get(i));
            }
            buyer.setWallet(buyer.getWallet() - totalPrice);
            return true;
        }
        return false;
    }

    //seller
    public void createSellerAccount(Seller newSeller) {
        sellers.add(newSeller);
    }

    public boolean doesSellerExist(String companyName) {
        for (int i = 0; i < sellers.size(); i++) {
            if (companyName.equals(sellers.get(i).getCompanyName())) {
                return true;
            }
        }
        return false;
    }

    public boolean isSellerPasswordCorrect(String pass, String companyName) {
        for (int i = 0; i < sellers.size(); i++) {
            if (companyName.equals(sellers.get(i).getCompanyName()) && pass.equals(sellers.get(i).getPassword())) {
                return true;
            }
        }
        return false;
    }

    public void showSellerWallet(String companyName) {
        for (int i = 0; i < sellers.size(); i++) {
            if (companyName.equals(sellers.get(i).getCompanyName())) {
                System.out.println(sellers.get(i).getWallet());
            }
        }
    }

    //admin
    public boolean addAdmin (Admin admin) {
        for (int i = 0; i < admins.size(); i++) {
            if (admin.equals(admins.get(i))) {
                return false;
            }
        }
        admins.add(admin);
        return true;
    }

    public boolean doesAdminExist(String username) {
        for (int i = 0; i < admins.size(); i++) {
            if (username.equals(admins.get(i).getUsername())) {
                return true;
            }
        }
        return false;
    }

    public boolean isAdminPasswordCorrect(String pass, String username) {
        for (int i = 0; i < admins.size(); i++) {
            if (username.equals(admins.get(i).getUsername()) && pass.equals(admins.get(i).getPassword())) {
                return true;
            }
        }
        return false;
    }

    public void showFundRequests() {
        for (String i : fundRequests.keySet()) {
            System.out.println("username: " + i + " amount: " + fundRequests.get(i));
        }
    }

    public boolean addFundToUserWallet(String username) {
        double amount = fundRequests.get(username);
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals(username)) {
                users.get(i).setWallet(users.get(i).getWallet() + amount);
                fundRequests.remove(users.get(i).getUsername());
                return true;
            }
        }
        return false;
    }
    //product
    public boolean doesProductExist(String name) {
        for (int i = 0; i < allProducts.size(); i++) {
            if (name.equals(allProducts.get(i).getName())) {
                return true;
            }
        }
        return false;
    }

    public void searchProduct(String name) {
        for (int i = 0; i < allProducts.size(); i++) {
            if (name.contains(allProducts.get(i).getName())) {
                System.out.println("Name : " + allProducts.get(i).getName());
                System.out.println("ID : " + allProducts.get(i).getID());
                System.out.println("Price : " + allProducts.get(i).getPrice());
                System.out.println("Category : " + allProducts.get(i).getCategory());
            }
        }
    }
}
