package com.cpm;

public class Receipt {
    private static int idCounter = 0;
    private int id;
    private User user;

    Receipt() {
        this.id = ++idCounter;
    }

    Receipt(User user) {
        this.id = ++idCounter;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
