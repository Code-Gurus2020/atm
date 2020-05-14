package com.atm;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Account {

    Scanner textInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$' ###,##0.00");
    private int accountNumber;
    private int pin;
    private double checkingBalance = 1000;
    private double savingBalance = 500;

    //Getters Setters
    public int setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
        return accountNumber;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public int setPin(int pin) {
        this.pin = pin;
        return pin;
    }

    public int getPin() {
        return pin;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public double getSavingBalance() {
        return savingBalance;
    }

    public double calCheckingWithdrawl(double amount) {
        checkingBalance = (checkingBalance - amount);
        return checkingBalance;
    }

    public double calSavingWithdrawl(double amount) {
        savingBalance = (savingBalance - amount);
        return savingBalance;
    }

    public double calCheckingDeposit(double amount) {
        checkingBalance = (checkingBalance + amount);
        return checkingBalance;
    }

    public double calSavingDeposit(double amount) {
        savingBalance = (savingBalance + amount);
        return savingBalance;
    }

    //Checking account withdrawl

    public void getCWithdrawInput() throws InputMismatchException {

        System.out.println("Checking Balance: " + moneyFormat.format(checkingBalance));
        System.out.println("Amount to Withdraw: ");
        double amount = 0.00;
        boolean textCheck = true;
        while (textCheck = true) {
            if (!textInput.hasNextDouble()) {
                System.out.println("Integer only");
                textInput.nextLine();
            } else {
                amount = textInput.nextDouble();
                if ((checkingBalance - amount) < 0 || amount < 0) {
                    System.out.println("Amount cannot be negative. Enter the amount not exceeding the balance." + "\n");
                    textInput.nextLine();

                } else {
                    calCheckingWithdrawl(amount);
                    System.out.println("New Checking Balance: " + moneyFormat.format(checkingBalance) + "\n");
                    textCheck = false;
                    break;
                }
            }
        }
    }

    // Saving Account Withdrawl
    public void getSWithdrawInput() {
        System.out.println("Saving Balance: " + moneyFormat.format(savingBalance));
        System.out.println("Amount to Withdraw: ");
        double amount = 0.00;
        boolean textCheck = true;
        while (textCheck = true) {
            if (!textInput.hasNextDouble()) {
                System.out.println("Integer only");
                textInput.nextLine();
            } else {
                amount = textInput.nextDouble();
                if ((savingBalance - amount) < 0 || amount < 0) {
                    System.out.println("Amount cannot be negative. Enter the amount not exceeding the balance." + "\n");
                    textInput.nextLine();

                } else {
                    calSavingWithdrawl(amount);
                    System.out.println("New Saving Balance: " + moneyFormat.format(savingBalance) + "\n");
                    textCheck = false;
                    break;
                }
            }
        }
    }

// Checking Deposit

    public void getCDepositInput() {
        System.out.println("Checking Balance: " + moneyFormat.format(checkingBalance));
        System.out.println("Amount to deposit: ");
        double amount = 0.00;
        boolean textCheck = true;
        while (textCheck = true) {
            if (!textInput.hasNextDouble()) {
                System.out.println("Integer only");
                textInput.nextLine();
            } else {
                amount = textInput.nextDouble();
            }
            if ((amount < 0)) {
                System.out.println("Amount cannot be negative." + "\n");
                System.out.println("Please enter positive amount to deposit: " + "\n");
                textInput.nextLine();
            } else {
                calCheckingDeposit(amount);
                System.out.println("New Checking Balance: " + moneyFormat.format(checkingBalance) + "\n");
                textCheck = false;
                break;
            }
        }
    }

//Saving Deposit

    public void getSDepositInput() {
        System.out.println("Saving Balance: " + moneyFormat.format(savingBalance));
        System.out.println("Amount to deposit: ");
        double amount = 0.00;
        boolean textCheck = true;
        while (textCheck = true) {
            if (!textInput.hasNextDouble()) {
                System.out.println("Integer only");
                textInput.nextLine();
            } else {
                amount = textInput.nextDouble();
            }
            if ((amount < 0)) {
                System.out.println("Amount cannot be negative." + "\n");
                System.out.println("Please enter positive amount to deposit: " + "\n");
                textInput.nextLine();
            } else {
                calSavingDeposit(amount);
                System.out.println("New Saving Balance: " + moneyFormat.format(savingBalance) + "\n");
                textCheck = false;
                break;
            }
        }
    }
}