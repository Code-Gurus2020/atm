package com.atm;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;

public class Menu extends Account {

    int selection;// to choose options between 1 to 4 for account type or transaction type
    Scanner textInput = new Scanner (System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$' ###,##0.00");
    HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();


    //Login
    public void getLogin() throws IOException {
        int x = 1;
        do {
            try {
                data.put(9998888, 1122);// calling put() of HashMap to insert the key and value for mapping

                System.out.println("Welcome");//displays message to user on the console

                System.out.println("Enter your account number: ");//display message
                setAccountNumber(textInput.nextInt());// takes ac/ num from the user on the console after typing integer

                System.out.println("Enter Your PIN");
                setPin(textInput.nextInt());
            } catch (Exception e) {// Catching the IO Exception by displaying the below message.
                System.out.println("\n" + "Invalid character(s) used, please use numbers only" + "\n");
                x = 2;
            }
           for (Entry<Integer, Integer> entry : data.entrySet()) {//here we are say for each entry in the

                if (entry.getKey() == getAccountNumber() && entry.getValue() == getPin())
                {
                    getAccountType();
                }
            }
            System.out.println("\n" + "Wrong Account number or PIN. Try again!" + "\n");
        } while (x == 1);
    }
    public void doTextCheck() {
        boolean valid = false;
        while (!valid) {
            String choice = textInput.next();
            valid = choice.matches("[1-3]");
            if (valid) {
                selection= Integer.parseInt(choice);
            }
            else {
                System.out.println("Integers 1, 2, or 3 only");
            }
        }
    }

    //Display Screen
    public void getAccountType() {
        System.out.println("Select your account");
        System.out.println("Press 1 - Checking Account");
        System.out.println("Press 2 - Saving Account");
        System.out.println("Press 3 - Exit");


       // selection = textInput.nextInt();
        doTextCheck();


        switch (selection) {
            case 1:
                getChecking();
                break;
            case 2:
                getSaving();
                break;
            case 3:
                System.out.println("Thank you, bye!");
                System.exit(0);

            default:
                System.out.println("\n" + "Invalid Choice" + "\n");
                getAccountType();
        }
    }

    public void getChecking() {
        System.out.println("Checking Account:");
        System.out.println("Press 1 - View Balance");
        System.out.println("Press 2 - Withdraw Funds");
        System.out.println("Press 3 - Deposit Funds");
        System.out.println("Press 4 - Exit");
        System.out.println("Choice: ");

        //C selection = textInput.nextInt();
        doTextCheck();

        switch (selection) {

            case 1:
                System.out.println("Checking Account Balance: " + moneyFormat.format(getCheckingBalance()));
                getChecking();
                break;
            case 2:
                getCWithdrawInput();
                getChecking();
                break;
            case 3:
                getCDepositInput();
                getChecking();
                break;
            case 4:
                System.out.println("Thank you, bye!");
                System.exit(0);
            default:
                System.out.println("\n" + "Invalid Choice" + "\n");
                getChecking();
        }

    }

    public void getSaving() {
        System.out.println("Saving Account:");
        System.out.println("Press 1 - View Balance");
        System.out.println("Press 2 - Withdraw Funds");
        System.out.println("Press 3 - Deposit Funds");
        System.out.println("Press 4 - Exit");
        System.out.println("Choice: ");

       // C selection = textInput.nextInt();
        doTextCheck();

        switch (selection) {

            case 1:
                System.out.println("Saving Account Balance: " + moneyFormat.format(getSavingBalance()));
                getSaving();
                break;
            case 2:
                getSWithdrawInput();
                getSaving();
                break;
            case 3:
                getSDepositInput();
                getSaving();
                break;
            case 4:
                System.out.println("Thank you, bye!");
                System.exit(0);
            default:
                System.out.println("\n" + "Invalid Choice" + "\n");
                getSaving();
        }

    }

}


