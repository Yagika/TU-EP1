/*
    Aufgabe 4) Simpler Taschenrechner mit Scanner und Methoden
*/

import java.util.Scanner;

public class Aufgabe4 {
    public static int Operanden(String prompt, Scanner scanner) {
        int operand;
        while (true) {
            System.out.println(prompt);
            if (scanner.hasNextInt()) {
                operand = scanner.nextInt();
                break;
            } else {
                System.out.println("Error. Please enter an integer.");
                scanner.next(); // Clear the invalid input
            }
        }
        return operand;
    }

    public static char Operators(Scanner scanner) {
        char operator;
        while (true) {
            System.out.println("Enter operation (+, -, *, / or %):");
            String input = scanner.next();

            if (input.length() == 1 && "+-*/%".contains(input)) {
                operator = input.charAt(0);
                break;
            } else {
                System.out.println("Error. Please enter one of the operators: +, -, *, / or %");
            }
        }
        return operator;
    }

    public static char Zeichen(Scanner scanner) {
        char symbol;
        while (true) {
            System.out.println("Enter q/Q for quitting or c/C for another calculation:");
            String input = scanner.next();
            if (input.length() == 1 && "qQcC".contains(input)) {
                symbol = input.charAt(0);
                break;
            } else {
                System.out.println("Error. Please enter q/Q for quitting or c/C for another calculation.");
            }
        }

        return symbol;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            int operand1 = Operanden("Enter the first operand:", in);
            int operand2 = Operanden("Enter the second operand:", in);
            char operator = Operators(in);
            double result = 0;
            switch (operator) {
                case '+' -> result = operand1 + operand2;
                case '-' -> result = operand1 - operand2;
                case '*' -> result = operand1 * operand2;
                case '%' -> {
                    if (operand2 != 0) {
                        result = operand1 % operand2;
                    } else {
                        System.out.println("Division by zero is not allowed.");
                    }
                }
                case '/' -> {
                    if (operand2 != 0) {
                        result = (double) operand1 / operand2;
                    } else {
                        System.out.println("Division by zero is not allowed.");
                    }
                }
            }
            if (operand2 == 0 && (operator == '%' || operator == '/')) {
                System.out.println(operand1 + " " + operator + " " + operand2 + " = Error");
            } else {
                System.out.println(operand1 + " " + operator + " " + operand2 + " = " + result);
            }

            char symbol = Zeichen(in);
            if (symbol == 'q' || symbol == 'Q') {
                System.out.println("Calculation finished!");
                break;
            } else if (symbol != 'c' && symbol != 'C') {
                System.out.println("Error. Calculation finished!");
                break;
            }
        }

        in.close();
    }

}
