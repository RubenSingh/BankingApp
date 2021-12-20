package com.company;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Account {
    int balance;
    int previousTransaction;
    String customerName;
    String customerID;

    public Account(String customerName, String customerID) {
        this.customerName = customerName;
        this.customerID = customerID;
    }

    void deposit(int amount){
        if (amount != 0){
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    void withdraw(int amount){
        if(amount != 0){
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }

    void getPreviousTransaction(){
        if(previousTransaction > 0){
            System.out.println("Deposited: " + previousTransaction);
        }else if(previousTransaction <0){
            System.out.println("withrdrawn: " + Math.abs(previousTransaction));
        }else {
            System.out.println("No transaction occured");
        }
    }

    void calculatedInterest(int years){
        double interestRate = 0.185;
        double newBalance = (balance + interestRate * years) + balance;
        System.out.println("The current interest rate is " + (100 * interestRate));
        System.out.println("After " + years + " years, your balance will be " + newBalance);

    }

    void showMenu(){
        char option = '\0';
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome, "+ customerName);
        System.out.println("Your ID is: " + customerID);
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println();
        System.out.println("A. Check balance");
        System.out.println("B. Deposit");
        System.out.println("C. Withdraw");
        System.out.println("D. Previous Transaction");
        System.out.println("A. Calculate Interest");
        System.out.println("F. Exit");

        do {
            System.out.println();
            System.out.println("Enter an option: ");
            char option1 = scanner.next().charAt(0);
            option = Character.toUpperCase(option1);
            System.out.println();

            switch (option) {
                case 'A' -> {
                    System.out.println("=========================================");
                    System.out.println("Balance = $" + balance);
                    System.out.println("=========================================");
                }
                case 'B' -> {
                    System.out.println("Enter amount to deposit: ");
                    int amount = scanner.nextInt();
                    deposit(amount);
                    System.out.println();
                }
                case 'C' -> {
                    System.out.println("Enter amount to withdraw");
                    int amount2 = scanner.nextInt();
                    withdraw(amount2);
                    System.out.println();
                }
                case 'D' -> {
                    System.out.println("===========================================");
                    getPreviousTransaction();
                    System.out.println("===========================================");
                    System.out.println();
                }
                case 'E' -> {
                    System.out.println("How many years of accrued interest: ");
                    int years = scanner.nextInt();
                    calculatedInterest(years);
                }
                case 'F' -> System.out.println("===========================================");
                default -> System.out.println("Error, enter A,B,C,D,E or F");
            }
        }while(option != 'F');
        System.out.println("Thank you for banking with us");
    }
}
