package org.example;

import org.example.controller.Controller;

public class Main {

    private static Controller controller = new Controller();

    public static void main(String[] args) {
        System.out.println(controller.getLocation());

        System.out.println(controller.getSpaceCrew());
    }
}