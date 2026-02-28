package com.warrior.calculator;

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        CalculatorService service = new CalculatorService();

        while (true) {
            System.out.println("\nScientific Calculator");
            System.out.println("1. Square Root");
            System.out.println("2. Factorial");
            System.out.println("3. Natural Log");
            System.out.println("4. Power");
            System.out.println("5. Exit");

            System.out.print("Choose option: ");
            int choice = scanner.nextInt();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter number: ");
                        System.out.println("Result: " + service.sqrt(scanner.nextDouble()));
                        break;

                    case 2:
                        System.out.print("Enter number: ");
                        System.out.println("Result: " + service.factorial(scanner.nextInt()));
                        break;

                    case 3:
                        System.out.print("Enter number: ");
                        System.out.println("Result: " + service.naturalLog(scanner.nextDouble()));
                        break;

                    case 4:
                        System.out.print("Enter base: ");
                        double base = scanner.nextDouble();
                        System.out.print("Enter exponent: ");
                        double exp = scanner.nextDouble();
                        System.out.println("Result: " + service.power(base, exp));
                        break;

                    case 5:
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}