package se.lexicon;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("kiwi");
        fruits.add("apple");
        fruits.add("citrus");
        fruits.add("pear");

        System.out.println(fruits);

        fruits.remove("apple");
        System.out.println(fruits);



    }



}
