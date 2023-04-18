package org.example;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop();
        runMenu(shop);
    }

    public static void runMenu(Shop shop) {

        Scanner input = new Scanner(System.in);
        shop.setName("Digizon");
        shop.setPhone("01234567890");
        shop.setWebAddress("www.digizon.com");

        String username = "username";
        String pass = "pass";
        String email = "email";

        Admin firstAdmin = new Admin(username, pass, email);

        shop.addAdmin(firstAdmin);

        System.out.println("Welcome to DIGIZON!");
        System.out.println("Phone number : " + shop.getPhone());
        System.out.println("Website : " + shop.getWebAddress());

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println(dateFormat.format(date));

        while (true) {
            System.out.println("Log in or Sign up ?");
            System.out.println("1.Log in");
            System.out.println("2.Sign up");
            int choice = input.nextInt();

            if (choice == 1) {//+++++++++++++log in+++++++++++++++++
                System.out.println("Do you want to log in as (1)Admin, or (2)User, or (3)Seller ?");
                int choiceTwo = input.nextInt();
                if (choiceTwo == 1) {
                    System.out.println("Enter username");
                    String UName = input.next();
                    if (shop.doesAdminExist(UName)) {
                        System.out.println("Enter password");
                        String password = input.next();
                        if (shop.isAdminPasswordCorrect(password, UName)) {
                            System.out.println("Logged in");
                            adminMenu(shop);
                        } else {
                            System.out.println("Incorrect password");
                        }
                    } else {
                        System.out.println("This admin doesn't exist");
                    }
                } else if (choiceTwo == 2) {
                    System.out.println("Enter username");
                    String UName = input.next();
                    if (shop.doesUserExist(UName)) {
                        System.out.println("Enter password");
                        String password = input.next();
                        if (shop.isUserPasswordCorrect(password, UName)) {
                            System.out.println("Logged in");
                            for (int i = 0; i < shop.users.size(); i++){
                                if (UName.equals(shop.users.get(i).getUsername())){
                                    userMenu(shop, shop.users.get(i));
                                    break;
                                }
                            }

                        } else {
                            System.out.println("Incorrect password");
                        }
                    } else {
                        System.out.println("This user doesn't exist");
                    }
                } else if (choiceTwo == 3) {
                    System.out.println("Enter company name");
                    String companyName = input.next();
                    if (shop.doesSellerExist(companyName)) {
                        System.out.println("Enter password");
                        String password = input.next();
                        if (shop.isSellerPasswordCorrect(password, companyName)) {
                            System.out.println("Logged in");
                            for (int i = 0; i < shop.sellers.size(); i++){
                                if (companyName.equals(shop.sellers.get(i).getCompanyName())){
                                    sellerMenu(shop, shop.sellers.get(i));
                                    break;
                                }
                            }
                        } else {
                            System.out.println("Incorrect password");
                        }
                    } else {
                        System.out.println("This seller doesn't exist");
                    }
                }
            } else if (choice == 2) {  // ++++++++++++++sign up+++++++++++++++++
                System.out.println("Do you want to sign up as (1)user, or (2)seller ?");
                int choiceTwo = input.nextInt();
                if (choiceTwo == 1) {
                    System.out.println("Enter username : ");
                    String UName = input.next();
                    if (!shop.doesUserExist(UName)) {
                        System.out.println("Enter password : ");
                        String password = input.next();
                        System.out.println("Confirm password : ");
                        String CPassword = input.next();
                        if (password.equals(CPassword)) {
                            System.out.println("Enter email address : ");
                            String emailAddress = input.next();
                            System.out.println("Enter phone number : ");
                            String phone = input.next();
                            System.out.println("Enter your address : ");
                            String address = input.next();

                            User newUser = new User(UName, password, phone, emailAddress, address);
                            shop.createUserAccount(newUser);
                            System.out.println("Your account has been created successfully");
                        } else {
                            System.out.println("try again!");
                        }
                    } else {
                        System.out.println("This user already exists");
                    }
                } else if (choiceTwo == 2){
                    System.out.println("Enter company name : ");
                    String CompanyName = input.next();
                    if (!shop.doesSellerExist(CompanyName)) {
                        System.out.println("Enter password : ");
                        String password = input.next();
                        System.out.println("Confirm password : ");
                        String CPassword = input.next();
                        if (password.equals(CPassword)) {
                            Seller newSeller = new Seller(CompanyName, password);
                            shop.createSellerAccount(newSeller);
                            System.out.println("Your account has been created successfully");
                        } else {
                            System.out.println("try again!");
                        }
                    } else {
                        System.out.println("This seller already exists");
                    }
                }
            }
        }
    }

    public static void userMenu(Shop shop, User user) {

        Scanner input = new Scanner(System.in);
        System.out.println("1. View all products" + "\n" + "2. Fund request" + "\n" + "3. View shopping cart" + "\n" + "4. Edit profile" + "\n" + "5. View wallet" + "\n" + "6. Add product to cart" + "\n" + "7. Search products" + "\n" + "8. Exit");
        int choice = input.nextInt();

        if (choice == 1) {
            System.out.println("Choose a category : ");
            System.out.println("1. Books And Art" + "\n" + "2. Cloths" + "\n" + "3. Electronics" + "\n" + "4. Home And Kitchen" + "\n" + "5. Personal Care" + "\n" + "6. Sport" + "\n" + "7. Exit");
            int num = input.nextInt();
            if (num == 1) {
                System.out.println("1. Book" + "\n" + "2. Pencil" + "\n" + "3. Pen");
                int numTwo = input.nextInt();
                if (numTwo == 1) {
                    for (int i = 0; i < shop.books.size(); i++) {
                        System.out.println("\n" + (i+1) + ". Name : " + shop.books.get(i).getName());
                        System.out.println("Author : " + shop.books.get(i).getAuthor());
                        System.out.println("Year of publish : " + shop.books.get(i).getYearOfPublish());
                        System.out.println("Product ID : " + shop.books.get(i).getID());
                        System.out.println("Price : " + shop.books.get(i).getPrice());
                        System.out.println("Seller : " + shop.books.get(i).getSeller().getCompanyName());
//                        if (shop.books.get(i).getQuantity() == 0) {
//                            System.out.println("Not available now!");
//                        }
                    }
                } else if (numTwo == 2) {
                    for (int i = 0; i < shop.pencils.size(); i++) {
                        System.out.println("\n" + (i+1) + ". Name : " + shop.pencils.get(i).getName());
                        System.out.println("Product ID : " + shop.pencils.get(i).getID());
                        System.out.println("Color : " + shop.pencils.get(i).getColor());
                        System.out.println("Brand : " + shop.pencils.get(i).getBrand());
                        System.out.println("Price : " + shop.pencils.get(i).getPrice());
                        System.out.println("Seller : " + shop.pencils.get(i).getSeller().getCompanyName());
                    }
                } else if (numTwo == 3) {
                    for (int i = 0; i < shop.pens.size(); i++) {
                        System.out.println("\n" + (i+1) + ". Name : " + shop.pens.get(i).getName());
                        System.out.println("Product ID : " + shop.pens.get(i).getID());
                        System.out.println("Color : " + shop.pens.get(i).getColor());
                        System.out.println("Brand : " + shop.pens.get(i).getBrand());
                        System.out.println("Price : " + shop.pens.get(i).getPrice());
                        System.out.println("Seller : " + shop.pens.get(i).getSeller().getCompanyName());
                    }
                }
            } else if (num == 2) {
                System.out.println("1. Shirt" + "\n" + "2. Pants" + "\n" + "3. Shoes");
                int numTwo = input.nextInt();

                if (numTwo == 1) {
                    for (int i = 0; i < shop.shirts.size(); i++) {
                        System.out.println("\n" + (i+1) + ". Name : " + shop.shirts.get(i).getName());
                        System.out.println("Product ID : " + shop.shirts.get(i).getID());
                        System.out.println("Color : " + shop.shirts.get(i).getColor());
                        System.out.println("Size : " + shop.shirts.get(i).getSize());
                        System.out.println("Material : " + shop.shirts.get(i).getMaterial());
                        System.out.println("Collar model : " + shop.shirts.get(i).getCollarModel());
                        System.out.println("Type : " + shop.shirts.get(i).getType());
                        System.out.println("Price : " + shop.shirts.get(i).getPrice());
                        System.out.println("Seller : " + shop.shirts.get(i).getSeller().getCompanyName());
                    }
                } else if (numTwo == 2) {
                    for (int i = 0; i < shop.pants.size(); i++) {
                        System.out.println("\n" + (i+1) + ". Name : " + shop.pants.get(i).getName());
                        System.out.println("Product ID : " + shop.pants.get(i).getID());
                        System.out.println("Color : " + shop.pants.get(i).getColor());
                        System.out.println("Size : " + shop.pants.get(i).getSize());
                        System.out.println("Material : " + shop.pants.get(i).getMaterial());
                        System.out.println("Height : " + shop.pants.get(i).getHeight());
                        System.out.println("Type : " + shop.pants.get(i).getType());
                        System.out.println("Price : " + shop.pants.get(i).getPrice());
                        System.out.println("Seller : " + shop.pants.get(i).getSeller().getCompanyName());
                    }
                } else if (numTwo == 3) {
                    for (int i = 0; i < shop.shoes.size(); i++) {
                        System.out.println("\n" + (i+1) + ". Name : " + shop.shoes.get(i).getName());
                        System.out.println("Product ID : " + shop.shoes.get(i).getID());
                        System.out.println("Color : " + shop.shoes.get(i).getColor());
                        System.out.println("Size : " + shop.shoes.get(i).getSize());
                        System.out.println("Material : " + shop.shoes.get(i).getMaterial());
                        System.out.println("Brand : " + shop.shoes.get(i).getBrand());
                        System.out.println("Price : " + shop.shoes.get(i).getPrice());
                        System.out.println("Seller : " + shop.shoes.get(i).getSeller().getCompanyName());
                    }
                }
            } else if (num == 3) {
                System.out.println("1. Camera" + "\n" + "2. Laptop" + "\n" + "3. Phone");
                int numTwo = input.nextInt();

                if (numTwo == 1) {
                    for (int i = 0; i < shop.cameras.size(); i++) {
                        System.out.println("\n" + (i+1) + ". Name : " + shop.cameras.get(i).getName());
                        System.out.println("Product ID : " + shop.cameras.get(i).getID());
                        System.out.println("Color : " + shop.cameras.get(i).getColor());
                        System.out.println("Weight : " + shop.cameras.get(i).getWeight());
                        System.out.println("Optical zoom : " + shop.cameras.get(i).getOpticalZoom());
                        System.out.println("Brand : " + shop.cameras.get(i).getBrand());
                        System.out.println("Price : " + shop.cameras.get(i).getPrice());
                        System.out.println("Seller : " + shop.cameras.get(i).getSeller().getCompanyName());
                    }
                } else if (numTwo == 2) {
                    for (int i = 0; i < shop.laptops.size(); i++) {
                        System.out.println("\n" + (i+1) + ". Name : " + shop.laptops.get(i).getName());
                        System.out.println("Product ID : " + shop.laptops.get(i).getID());
                        System.out.println("Color : " + shop.laptops.get(i).getColor());
                        System.out.println("Weight : " + shop.laptops.get(i).getWeight());
                        System.out.println("Brand : " + shop.laptops.get(i).getBrand());
                        System.out.println("OS : " + shop.laptops.get(i).getOS());
                        System.out.println("Ram : " + shop.laptops.get(i).getRam());
                        System.out.println("Storage : " + shop.laptops.get(i).getStorage());
                        System.out.println("CPU : " + shop.laptops.get(i).getCPU());
                        System.out.println("Price : " + shop.laptops.get(i).getPrice());
                        System.out.println("Seller : " + shop.laptops.get(i).getSeller().getCompanyName());
                    }
                } else if (numTwo == 3) {
                    for (int i = 0; i < shop.phones.size(); i++) {
                        System.out.println("\n" + (i+1) + ". Name : " + shop.phones.get(i).getName());
                        System.out.println("Product ID : " + shop.phones.get(i).getID());
                        System.out.println("Color : " + shop.phones.get(i).getColor());
                        System.out.println("Weight : " + shop.phones.get(i).getWeight());
                        System.out.println("Brand : " + shop.phones.get(i).getBrand());
                        System.out.println("OS : " + shop.phones.get(i).getOS());
                        System.out.println("Ram : " + shop.phones.get(i).getRam());
                        System.out.println("Storage : " + shop.phones.get(i).getStorage());
                        System.out.println("Camera quality : " + shop.phones.get(i).getCameraQuality());
                        System.out.println("Screen size : " + shop.phones.get(i).getScreenSize());
                        System.out.println("Price : " + shop.phones.get(i).getPrice());
                        System.out.println("Seller : " + shop.phones.get(i).getSeller().getCompanyName());
                    }
                }
            } else if (num == 4) {
                System.out.println("1. Bed" + "\n" + "2. Carpet" + "\n" + "3. Refrigerator");
                int numTwo = input.nextInt();

                if (numTwo == 1) {
                    for (int i = 0; i < shop.beds.size(); i++) {
                        System.out.println("\n" + (i+1) + ". Name : " + shop.beds.get(i).getName());
                        System.out.println("Product ID : " + shop.beds.get(i).getID());
                        System.out.println("Color : " + shop.beds.get(i).getColor());
                        System.out.println("Brand : " + shop.beds.get(i).getBrand());
                        System.out.println("Size : " + shop.beds.get(i).getSize());
                        System.out.println("Material :" + shop.beds.get(i).getMaterial());
                        System.out.println("Price : " + shop.beds.get(i).getPrice());
                        System.out.println("Seller : " + shop.beds.get(i).getSeller().getCompanyName());
                    }
                } else if (numTwo == 2) {
                    for (int i = 0; i < shop.carpets.size(); i++) {
                        System.out.println("\n" + (i+1) + ". Name : " + shop.carpets.get(i).getName());
                        System.out.println("Product ID : " + shop.carpets.get(i).getID());
                        System.out.println("Color : " + shop.carpets.get(i).getColor());
                        System.out.println("Brand : " + shop.carpets.get(i).getBrand());
                        System.out.println("Shape : " + shop.carpets.get(i).getShape());
                        System.out.println("Height : " + shop.carpets.get(i).getHeight());
                        System.out.println("Width :" + shop.carpets.get(i).getWidth());
                        System.out.println("Price : " + shop.carpets.get(i).getPrice());
                        System.out.println("Seller : " + shop.carpets.get(i).getSeller().getCompanyName());
                    }
                } else if (numTwo == 3) {
                    for (int i = 0; i < shop.refrigerators.size(); i++) {
                        System.out.println("\n" + (i+1) + ". Name : " + shop.refrigerators.get(i).getName());
                        System.out.println("Product ID : " + shop.refrigerators.get(i).getID());
                        System.out.println("Model name : " + shop.refrigerators.get(i).getModelName());
                        System.out.println("Color : " + shop.refrigerators.get(i).getColor());
                        System.out.println("Brand : " + shop.refrigerators.get(i).getBrand());
                        System.out.println("Height : " + shop.refrigerators.get(i).getHeight());
                        System.out.println("Price : " + shop.refrigerators.get(i).getPrice());
                        System.out.println("Seller : " + shop.refrigerators.get(i).getSeller().getCompanyName());
                    }
                }
            } else if (num == 5) {
                System.out.println("1. Perfume " + "\n" + "2. Shampoo" + "\n" + "3. Tooth brush");
                int numTwo = input.nextInt();

                if (numTwo == 1) {
                    for (int i = 0; i < shop.perfumes.size(); i++) {
                        System.out.println("\n" + (i+1) + ". Name : " + shop.perfumes.get(i).getName());
                        System.out.println("Product ID : " + shop.perfumes.get(i).getID());
                        System.out.println("Brand : " + shop.perfumes.get(i).getBrand());
                        System.out.println("Volume : " + shop.perfumes.get(i).getVolume());
                        System.out.println("Scent : " + shop.perfumes.get(i).getScent());
                        System.out.println("Age range : " + shop.perfumes.get(i).getAgeRange());
                        System.out.println("Price : " + shop.perfumes.get(i).getPrice());
                        System.out.println("Seller : " + shop.perfumes.get(i).getSeller().getCompanyName());
                    }
                } else if (numTwo == 2) {
                    for (int i = 0; i < shop.shampoos.size(); i++) {
                        System.out.println("\n" + (i+1) + ". Name : " + shop.shampoos.get(i).getName());
                        System.out.println("Product ID : " + shop.shampoos.get(i).getID());
                        System.out.println("Brand : " + shop.shampoos.get(i).getBrand());
                        System.out.println("Volume : " + shop.shampoos.get(i).getVolume());
                        System.out.println("Hair type : " + shop.shampoos.get(i).getHairType());
                        System.out.println("Age range : " + shop.shampoos.get(i).getAgeRange());
                        System.out.println("Price : " + shop.shampoos.get(i).getPrice());
                        System.out.println("Seller : " + shop.shampoos.get(i).getSeller().getCompanyName());
                    }
                } else if (numTwo == 3) {
                    for (int i = 0; i < shop.toothBrushes.size(); i++) {
                        System.out.println("\n" + (i+1) + ". Name : " + shop.toothBrushes.get(i).getName());
                        System.out.println("Product ID : " + shop.toothBrushes.get(i).getID());
                        System.out.println("Color : " + shop.toothBrushes.get(i).getColor());
                        System.out.println("Brand : " + shop.toothBrushes.get(i).getBrand());
                        System.out.println("Age range : " + shop.toothBrushes.get(i).getAgeRange());
                        System.out.println("Price : " + shop.toothBrushes.get(i).getPrice());
                        System.out.println("Seller : " + shop.toothBrushes.get(i).getSeller().getCompanyName());
                    }
                }
            } else if (num == 6) {
                System.out.println("1. Dumbbell" + "\n" + "2. Bicycle");
                int numTwo = input.nextInt();

                if (numTwo == 1) {
                    for (int i = 0; i < shop.dumbbells.size(); i++) {
                        System.out.println("\n" + (i+1) + ". Name : " + shop.dumbbells.get(i).getName());
                        System.out.println("Product ID : " + shop.dumbbells.get(i).getID());
                        System.out.println("Color : " + shop.dumbbells.get(i).getColor());
                        System.out.println("Weight : " + shop.dumbbells.get(i).getWeight());
                        System.out.println("Shape : " + shop.dumbbells.get(i).getShape());
                        System.out.println("Price : " + shop.dumbbells.get(i).getPrice());
                        System.out.println("Seller : " + shop.dumbbells.get(i).getSeller().getCompanyName());
                    }
                } else if (numTwo == 2) {
                    for (int i = 0; i < shop.bicycles.size(); i++) {
                        System.out.println("\n" + (i+1) + ". Name : " + shop.bicycles.get(i).getName());
                        System.out.println("Product ID : " + shop.bicycles.get(i).getID());
                        System.out.println("Color : " + shop.bicycles.get(i).getColor());
                        System.out.println("Weight : " + shop.bicycles.get(i).getWeight());
                        System.out.println("Age range : " + shop.bicycles.get(i).getAgeRange());
                        System.out.println("Material : " + shop.bicycles.get(i).getMaterial());
                        System.out.println("Price : " + shop.bicycles.get(i).getPrice());
                        System.out.println("Seller : " + shop.bicycles.get(i).getSeller().getCompanyName());
                    }
                }
            }
            userMenu(shop, user);
        } else if (choice == 2) {
            System.out.println("Enter your username : ");
            String username = input.next();
            System.out.println("How much fund do you need ?");
            double amount = input.nextDouble();
            shop.addFundRequest(username, amount);
            System.out.println("Working on your request. Check your wallet later to see the result.");
            userMenu(shop, user);
        } else if (choice == 3) {
            user.viewCart();
            System.out.println("______________________");
            System.out.println("1. Remove item from cart" + "\n" + "2. Increase number of an item" + "\n" + "3. Check out" + "\n" + "4. Exit");
            int choiceTwo = input.nextInt();
            if (choiceTwo == 1) {
                System.out.println("Enter product ID : ");
                String ID = input.next();
                if (user.removeProductFromCart(ID, shop)) {
                    System.out.println("Removed!");
                } else {
                    System.out.println("Try again");
                }
                userMenu(shop, user);
            } else if (choiceTwo == 2) {
                System.out.println("Enter product name : ");
                String name = input.next();
                if (user.increaseNumberOfAnItem(name)) {
                    System.out.println("Increased");
                } else {
                    System.out.println("Try again");
                }
                userMenu(shop, user);
            } else if (choiceTwo == 3) {

                System.out.println("*** Submitting New Order ***");
                shop.showOrder(user);
                System.out.println("*********************");
                System.out.println("Do you want to continue?" + "\n" + "1. Yes" + "\n" + "2. No");
                int choiceThree = input.nextInt();
                if (choiceThree == 1) {
                    if (shop.checkout(user, shop)) {
                        System.out.println("Thanks for your shopping !");
                        userMenu(shop, user);
                    } else {
                        System.out.println("Please charge your wallet and try again.");
                        userMenu(shop, user);
                    }
                } else if (choiceThree == 2) {
                    userMenu(shop, user);
                }

            } else if (choiceTwo == 4) {
                userMenu(shop, user);
            }
        } else if (choice == 4) {//*****************************

            System.out.println("Enter new username : ");
            String newUsername = input.next();
            System.out.println("Enter new password : ");
            String newPass = input.next();
            System.out.println("Enter new email : ");
            String newEmail = input.next();
            System.out.println("Enter new Address : ");
            String newAddress = input.next();
            System.out.println("Enter new phone number : ");
            String newPhone = input.next();

            shop.updateUser(user, newUsername, newPass, newPhone, newEmail, newAddress);
        } else if (choice == 5) {
            System.out.println("Enter username");
            String username = input.next();
            shop.showWallet(username);
            userMenu(shop, user);
        } else if (choice == 6) {
            System.out.println("Enter product ID : ");
            String ID = input.next();
            if (user.addProductToCart(ID, shop)) {
                System.out.println("Added successfully.");
                userMenu(shop, user);
            } else {
                System.out.println("This product doesn't exist.");
                userMenu(shop, user);
            }
        } else if (choice == 7) {

            System.out.println("Enter product name : ");
            String name = input.next();
            if (shop.doesProductExist(name)) {
                shop.searchProduct(name);
            } else {
                System.out.println("This product isn't available");
            }
            userMenu(shop, user);
        }
    }

    public static void adminMenu(Shop shop) {

        Scanner input = new Scanner(System.in);
        System.out.println("1. Add new admin" + "\n" + "2. View user profile" + "\n" + "3. View fund requests" + "\n" + "4. Exit");
        int choice = input.nextInt();

        if (choice == 1) {
            System.out.println("Enter username : ");
            String username = input.next();
            System.out.println("Enter password : ");
            String pass = input.next();
            System.out.println("Enter email address : ");
            String email = input.next();

            Admin admin = new Admin(username, pass, email);
            if (shop.addAdmin(admin)) {
                System.out.println("New admin has been added successfully");

            } else {
                System.out.println("Try again");
            }
        } else if (choice == 2) {
            System.out.println("Enter username : ");
            String username = input.next();
            shop.showUserProfile(username);
            adminMenu(shop);
        } else if (choice == 3) {

            shop.showFundRequests();
            System.out.println("***********************");
            System.out.println("If you want to add the requested fund to user's wallet, press 1 and enter their username.");
            System.out.println("If you want to exit, press 2.");
            int choiceTwo = input.nextInt();
            if (choiceTwo == 1) {
                System.out.println("Enter username : ");
                String username = input.next();
                if (shop.addFundToUserWallet(username)) {
                    System.out.println("Added successfully");
                } else {
                    System.out.println("Try again");
                }
                adminMenu(shop);
            } else if (choiceTwo == 2) {
                adminMenu(shop);
            }
        }
    }

    public static void sellerMenu(Shop shop, Seller seller) {
        Scanner input = new Scanner(System.in);
        System.out.println("1. Add a new product to your list" + "\n" + "2. View wallet" + "\n" + "3. Exit");//*****************************
        int choice = input.nextInt();

        if (choice == 1) {
            System.out.println("Enter product name : ");
            String name = input.next();
            System.out.println("Enter product price : ");
            double price = input.nextDouble();
            System.out.println("Enter product quantity : ");
            int quantity = input.nextInt();
            System.out.println("Enter product ID : ");
            String ID = input.next();
            System.out.println("Enter product category : (In lower case letters)");//book,pen,pencil,shirts,etc.
            String category = input.next();
            if (category.contains("book")) {
                System.out.println("Enter author name : ");
                String author = input.next();
                System.out.println("Enter year of publish : ");
                int yearOfPublish  = input.nextInt();
                Book newBook = new Book(name, price, quantity, category, seller, author, yearOfPublish, ID);
                seller.addBook(newBook, shop);
            } else if (category.contains("pen") && !category.contains("pencil")) {
                System.out.println("Enter product's color : ");
                String color = input.next();
                System.out.println("Enter product's brand : ");
                String brand = input.next();
                Pen newPen = new Pen(name, price, quantity, category, seller, ID, color, brand);
                seller.addPen(newPen, shop);
            } else if (category.contains("pencil")) {
                System.out.println("Enter product's color : ");
                String color = input.next();
                System.out.println("Enter product's brand : ");
                String brand = input.next();
                Pencil newPencil = new Pencil(name, price, quantity, category, seller, color, brand, ID);
                seller.addPencil(newPencil, shop);
            } else if (category.contains("shirt")) {
                System.out.println("Enter color : ");
                String color = input.next();
                System.out.println("Enter size : ");
                String size = input.next();
                System.out.println("Enter product's material : ");
                String material = input.next();
                System.out.println("Enter collar model : ");
                String collarModel = input.next();
                System.out.println("Enter type : ");
                String type = input.next();
                Shirt newShirt = new Shirt(name, price, quantity, category, seller, ID, color, size, material, collarModel, type);
                seller.addShirt(newShirt, shop);
            } else if (category.contains("pants")) {
                System.out.println("Enter color : ");
                String color = input.next();
                System.out.println("Enter size : ");
                String size = input.next();
                System.out.println("Enter product's material : ");
                String material = input.next();
                System.out.println("Enter height : ");
                int height = input.nextInt();
                System.out.println("Enter type : ");
                String type = input.next();
                Pants newPants = new Pants(name, price, quantity, category, seller, ID, color, size, material, height, type);
                seller.addPants(newPants, shop);
            } else if (category.contains("shoes")) {
                System.out.println("Enter color : ");
                String color = input.next();
                System.out.println("Enter size : ");
                String size = input.next();
                System.out.println("Enter product's material : ");
                String material = input.next();
                System.out.println("Enter brand name : ");
                String brand = input.next();
                Shoes newShoes = new Shoes(name, price, quantity, category, seller, ID, color, size, material, brand);
                seller.addShoes(newShoes, shop);
            } else if (category.contains("camera")) {
                System.out.println("color : ");
                String color = input.next();
                System.out.println("brand : ");
                String brand = input.next();
                System.out.println("weight : ");
                double weight = input.nextDouble();
                System.out.println("optical zoom : ");
                String opticalZoom = input.next();
                Camera newCamera = new Camera(name, price, quantity, category, seller, ID, color, brand, weight, opticalZoom);
                seller.addCamera(newCamera, shop);
            } else if (category.contains("laptop")) {
                System.out.println("color : ");
                String color = input.next();
                System.out.println("brand : ");
                String brand = input.next();
                System.out.println("weight : ");
                double weight = input.nextDouble();
                System.out.println("OS : ");
                String OS = input.next();
                System.out.println("ram : ");
                int ram = input.nextInt();
                System.out.println("storage : ");
                int storage = input.nextInt();
                System.out.println("CPU : ");
                String CPU = input.next();
                Laptop newLaptop = new Laptop(name, price, quantity, category, seller, ID, color, brand, weight, OS, ram, storage, CPU);
                seller.addLaptop(newLaptop, shop);
            } else if (category.contains("phone")) {
                System.out.println("color : ");
                String color = input.next();
                System.out.println("brand : ");
                String brand = input.next();
                System.out.println("weight : ");
                double weight = input.nextDouble();
                System.out.println("OS : ");
                String OS = input.next();
                System.out.println("ram : ");
                int ram = input.nextInt();
                System.out.println("storage : ");
                int storage = input.nextInt();
                System.out.println("camera quality : ");
                String cameraQuality = input.next();
                System.out.println("screen size : ");
                double screenSize = input.nextDouble();
                Phone newPhone = new Phone(name, price, quantity, category, seller, ID, color, brand, weight, OS, ram, storage, cameraQuality, screenSize);
                seller.addPhone(newPhone, shop);
            } else if (category.contains("bed")) {
                System.out.println("brand : ");
                String brand = input.next();
                System.out.println("color : ");
                String color = input.next();
                System.out.println("size : ");
                String size = input.next();
                System.out.println("material : ");
                String material = input.next();
                Bed newBed = new Bed(name, price, quantity, category, seller, ID, brand , color, size, material);
                seller.addBed(newBed, shop);
            } else if (category.contains("carpet")) {
                System.out.println("brand : ");
                String brand = input.next();
                System.out.println("color : ");
                String color = input.next();
                System.out.println("shape : ");
                String shape = input.next();
                System.out.println("height : ");
                double height = input.nextDouble();
                System.out.println("width : ");
                double width = input.nextDouble();
                Carpet newCarpet = new Carpet(name, price, quantity, category, seller, ID, brand, color, shape, height, width);
                seller.addCarpet(newCarpet, shop);
            } else if (category.contains("refrigerator")) {
                System.out.println("brand : ");
                String brand = input.next();
                System.out.println("color : ");
                String color = input.next();
                System.out.println("model name : ");
                String modelName = input.next();
                System.out.println("height : ");
                double height = input.nextDouble();
                Refrigerator newRefrigerator = new Refrigerator(name, price, quantity, category, seller, ID, brand, color, modelName, height);
                seller.addRefrigerator(newRefrigerator, shop);
            } else if (category.contains("perfume")) {
                System.out.println("brand : ");
                String brand = input.next();
                System.out.println("age range :");
                String ageRange = input.next();
                System.out.println("volume : ");
                double volume = input.nextDouble();
                System.out.println("scent : ");
                String scent = input.next();
                Perfume newPerfume = new Perfume(name, price, quantity, category, seller, ID, brand, ageRange, volume, scent);
                seller.addPerfume(newPerfume, shop);
            } else if (category.contains("shampoo")) {
                System.out.println("brand : ");
                String brand = input.next();
                System.out.println("age range :");
                String ageRange = input.next();
                System.out.println("volume : ");
                double volume = input.nextDouble();
                System.out.println("hair type : ");
                String hairType = input.next();
                Shampoo newShampoo = new Shampoo(name, price, quantity, category, seller, ID, brand, ageRange, volume, hairType);
                seller.addShampoo(newShampoo, shop);
            } else if (category.contains("toothbrush")) {
                System.out.println("brand : ");
                String brand = input.next();
                System.out.println("age range :");
                String ageRange = input.next();
                System.out.println("color : ");
                String color = input.next();
                ToothBrush newToothBrush = new ToothBrush(name, price, quantity, category, seller, ID, brand, ageRange, color);
                seller.addToothbrush(newToothBrush, shop);
            } else if (category.contains("dumbbell")) {
                System.out.println("weight : ");
                double weight = input.nextDouble();
                System.out.println("color : ");
                String color = input.next();
                System.out.println("shape : ");
                String shape = input.next();
                Dumbbell newDumbbell = new Dumbbell(name, price, quantity, category, seller, ID, weight, color, shape);
                seller.addDumbbell(newDumbbell, shop);
            } else if (category.contains("bicycle")) {
                System.out.println("weight : ");
                double weight = input.nextDouble();
                System.out.println("color : ");
                String color = input.next();
                System.out.println("age range : ");
                String ageRange = input.next();
                System.out.println("material : ");
                String material = input.next();
                Bicycle newBicycle = new Bicycle(name, price, quantity, category, seller, ID, weight, color, ageRange, material );
                seller.addBicycle(newBicycle, shop);
            } else {
                System.out.println("This category doesn't exist.");
                sellerMenu(shop, seller);
            }
            System.out.println("New product has been added successfully");
            sellerMenu(shop, seller);
        } else if (choice == 2) {
            System.out.println("Enter company name : ");
            String companyName = input.next();
            shop.showSellerWallet(companyName);
            sellerMenu(shop, seller);
        }
    }
}
