package com.atm.client;

import com.atm.Menu;

import java.io.IOException;

public class Atm extends Menu {
    public static void main(String[] args) throws IOException {
        Menu menu = new Menu();
        menu.getLogin();
    }

}
