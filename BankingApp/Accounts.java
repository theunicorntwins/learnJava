package BankingApp;

import java.util.Scanner;

public class Accounts {
    // Instance variables
    String name;
    int ID;
    int balance;
    int previousTransaction;

    Accounts(String name, int ID) {
        this.name = name;
        this.ID = ID;
    }

    void withdraw(int amount) {
        balance = balance - amount;
        previousTransaction = -amount;
    }

    void deposit(int amount) {
        balance = balance + amount;
        previousTransaction = amount;
    }
    void previousTransaction() {
        if(previousTransaction < 0) {
            System.out.println("Withdraw occured of " + previousTransaction);
        }

        else if(previousTransaction > 0) {
            System.out.println("Deposit occured of " + previousTransaction);
        }

        else {
            System.out.println("no transactions occured");
        }
    }

    void showMenu() {

        char option;

        System.out.println("Welcome " + name);
        System.out.println();

        Scanner data = new Scanner(System.in);

        System.out.println("D for deposit");
        System.out.println("W for withdraw");
        System.out.println("P for Previous Transaction");
        System.out.println("B for current balance");
        System.out.println("E for existing Menu");

        do {
            System.out.println("Enter an option: ");
            option = data.next().charAt(0);

            switch (option) {
                case 'D':
                    System.out.println("How much do you want to deposit?");
                    int amountD = data.nextInt();
                    deposit(amountD);
                    break;

                case 'W':
                    System.out.println("How much do you want to withdraw?");
                    int amountW = data.nextInt();
                    withdraw(amountW);
                    break;

                case 'B':
                    System.out.println("Your balance is " + balance);
                    break;

                case 'E':
                    System.out.println("Exit menu");
                    break;

                case 'P':
                    previousTransaction();
                    break;

                default:
                    System.out.println("Your option must be D, W, B, E, P");
            } //end switch statement
        }while (option != 'E');
    }
}