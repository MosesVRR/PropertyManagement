package com.cpm;

public class ExpenseTracker {
    private int expenseId;
    private String description;
    private int amount;

    public ExpenseTracker() {
        // Default constructor
    }

    // Getters and setters
    public int getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(int expenseId) {
        this.expenseId = expenseId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    // Method to add an expense
    public void addExpense(int amount, String description) {
        // Here you can implement the logic to add the expense
        // For demonstration, let's just set the amount and description
        this.amount = amount;
        this.description = description;
        System.out.println("Expense added successfully.");
    }

    // Method to remove an expense
    public void removeExpense(int expenseId) {
        // Here you can implement the logic to remove the expense
        // For demonstration, let's just reset the amount and description
        this.amount = 0;
        this.description = "";
        System.out.println("Expense removed successfully.");
    }

    // Method to calculate total expenses
    public int total() {
        // Here you can implement the logic to calculate the total expenses
        // For demonstration, let's just return the current amount
        return amount;
    }
}
