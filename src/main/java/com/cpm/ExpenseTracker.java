package com.cpm;
import java.util.ArrayList;
import java.util.List;
public class ExpenseTracker {
    private int expenseId;
    private List<String> descriptions;
    private List<Integer> amounts;

    private List<ExpenseTracker> expenses;

    public ExpenseTracker() {
        // Default constructor
        this.expenses = new ArrayList<>();
        this.descriptions = new ArrayList<>();
        this.amounts = new ArrayList<>();
    }
    // Getters and setters
    public int getExpenseId() {
        return this.expenseId;
    }

    public void setExpenseId(int expenseId) {
        this.expenseId = expenseId;
    }

    public List<String> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(List<String> descriptions) {
        this.descriptions = descriptions;
    }

    public List<Integer> getAmounts() {
        return amounts;
    }
    public void setAmounts(List<Integer> amounts) {
        this.amounts = amounts;
    }

    // Method to add an expense
    // Method to add an expense
    public void addExpense(int amount, String description) {
        descriptions.add(description);
        amounts.add(amount);
        System.out.println("Expense added successfully.");
    }


    // Method to remove an expense
    public void removeExpense(int index) {
        if (index >= 0 && index < descriptions.size()) {
            descriptions.remove(index);
            amounts.remove(index);
            System.out.println("Expense removed successfully.");
        } else {
            System.out.println("Invalid expense index.");
        }
    }

    // Method to calculate total expenses
    public int total() {
        int totalAmount = 0;
        for (int amount : amounts) {
            totalAmount += amount;
        }
        return totalAmount;
    }

    public List<String> getAllExpenseDetails() {
        List<String> allExpenseDetails = new ArrayList<>();
        for (int i = 0; i < descriptions.size(); i++) {
            String detail = "Description: " + descriptions.get(i) + ", Amount: $" + amounts.get(i);
            allExpenseDetails.add(detail);
        }
        return allExpenseDetails;
    }
    public List<ExpenseTracker> getExpenses() {
        return expenses;
    }
    public void setExpenses(List<ExpenseTracker> expenses) {
        this.expenses = expenses;
    }
}
