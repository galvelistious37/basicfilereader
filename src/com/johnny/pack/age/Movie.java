package com.johnny.pack.age;

public class Movie {
    private String title;
    private int year;
    private double price;

    public Movie(String title, int year, double price) {
        this.title = title;
        this.year = year;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }
}
