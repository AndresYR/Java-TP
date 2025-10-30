package com.informatorio.chadlab.utils;

import java.util.Scanner;

public class InputUtils {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static String inputTexto(String msj) {
        System.out.println(msj);
        return SCANNER.nextLine();
    }

    public static int inputInt(String msj) {
        while (true) {
            try {
                String input = inputTexto(msj);
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número entero válido. Intente nuevamente.");
            }
        }
    }

    public static int inputIntPositivo(String msj) {
        int input = -1;

        while (input < 0) {
            input = inputInt(msj);

            if (input < 0) {
                System.out.println("Ingrese un número entero positivo.");
            }
        }
        return input;
    }


}