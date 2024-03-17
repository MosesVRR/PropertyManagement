package com.cpm;

public class Main {

    public static void main(String[] args) {
        Application app = new Application();
        app.initializeUsers();
        System.out.println("Welcome to Building Management");
        while (true) {
            app.menu();
        }
    }
}
