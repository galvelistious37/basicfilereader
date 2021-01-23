package com.johnny.pack.age;

import javax.swing.*;
import java.io.*;
import java.text.NumberFormat;

public class Main {

    public static void main(String[] args) {
        NumberFormat cf = NumberFormat.getCurrencyInstance();
        File file = choseFile();
        BufferedReader in = getReader(file);
        Movie movie = readMovie(in);
        while (movie != null) {
            String msg = Integer.toString(movie.getYear());
            msg += ": " + movie.getTitle();
            msg += " (" + cf.format(movie.getPrice()) + ")";
            System.out.println(msg);
            movie = readMovie(in);
        }
        closeReader(in);
    }

    private static File choseFile() {
        String start = Constant.START_PATH;
        JFileChooser fc = new JFileChooser(start);
        int result = fc.showOpenDialog(null);
        if(result == JFileChooser.APPROVE_OPTION){
            return fc.getSelectedFile();
        } else {
            return null;
        }
    }

    private static BufferedReader getReader(File name) {
        BufferedReader in = null;
        try{
//            File file = new File(name);
            in = new BufferedReader(new FileReader(name));
        } catch (FileNotFoundException e){
            System.out.println("The file doesn't exist.");
            System.exit(0);
        }
        return in;
    }

    private static void closeReader(BufferedReader in) {
        try{
            in.close();
            System.out.println("Closed BufferedReader");
        } catch(IOException e){
            System.out.println("Could not close BufferedReader");
            System.exit(0);
        }
    }

    private static Movie readMovie(BufferedReader in){
        String title;
        int year;
        double price;
        String line = "";
        String[] data;

        try{
            line = in.readLine();
        } catch(IOException e){
            System.out.println("I/O Error");
            System.exit(0);
        }
        if(line == null){
            return null;
        } else {
            data = line.split("\t");
            title = data[0];
            year = Integer.parseInt(data[1]);
            price = Double.parseDouble(data[2]);
            return new Movie(title, year, price);
        }
    }
}
