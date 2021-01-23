package com.johnny.pack.age;

public class Movie {
    private String title;
    private int year;
    private double price;

    private Movie(String title, int year, double price) {
        this.title = title;
        this.year = year;
        this.price = price;
    }

    public static Movie makeMovieObj(String title, int year, double price){
        return new Movie(title, year, price);
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
