package org.example;

public class Book extends Product{
    private String author;
    private int yearOfPublish;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearOfPublish() {
        return yearOfPublish;
    }

    public void setYearOfPublish(int yearOfPublish) {
        this.yearOfPublish = yearOfPublish;
    }

    public Book(String name, double price, int quantity, String category, Seller seller, String author, int yearOfPublish, String ID) {
        super(name, price, quantity, category, seller, ID);
        this.author = author;
        this.yearOfPublish = yearOfPublish;
    }
}
