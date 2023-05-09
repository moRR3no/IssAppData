package org.example;

import org.example.controller.Controller;

public class Main {

    private static Controller controller = new Controller();

    public static void main(String[] args) {
        controller.getLocation();

        System.out.println(controller.getSpaceCrew());
    }
}