import java.util.Scanner;
/*
    Aufgabe 1) Codeanalyse, Codingstyle und Methoden
*/
public class Aufgabe1 {
    /*//TODO zu Punkt a): Beschreiben Sie hier in wenigen Sätzen was der Spaghetticode macht
    // Das Spaghetticode ist meistens ein chaotischer Code, der unlesbar ist
    // in dem Fall haben wir mehrere Stellen, wo die Klammern verschoben sind,
    // keine Kommentare gegeben sind und kein Abstand gibt.*/

    /*//TODO zu Punkt b): Beschreiben Sie in wenigen Sätzen was Sie ändern würden und warum
    //Wir sollen die Klammern formatieren, Abstaende machen....*/


    //TODO zu Punkt c): Implementieren Sie hier die Methoden Ihrer Lösung
    private static int getWidth() {
        Scanner scan = new Scanner(System.in);
        int width = 0;

        System.out.print("Geben sie die Breite an. Es muss groesser als 0 und gerade sein: ");
        while(true) {
            if (!scan.hasNextInt()) {
                System.out.println("Das ist keine gueltige Zahl. Bitte geben Sie eine ganze Zahl ein.");
                scan.next();
                System.out.print("Geben sie die Breite an. Es muss groesser als 0 und gerade sein: ");
                continue;
            }

            width = scan.nextInt();

            if (width > 0 && width % 2 == 0) {
                break;
            } else {
                System.out.println("Das ist keine gueltige Zahl. Die Zahl muss positiv und gerade sein.");
                System.out.print("Geben sie die Breite an. Es muss groesser als 0 und gerade sein: ");
            }


        }

        System.out.println("Ihre Ausgabe: " + width);

        return width;

    }

    private static void startEnd(int width) {
        System.out.print("#");
        for (int i = 1; i <= width; i++) {
            System.out.print("+");
        }
        System.out.println("#");
    }

    private static void printMid(int width, int border) {
        for (int i = 1; i < border; i++) {
            System.out.print("*");
            for (int j = 2; j <= (width/2-i+1); j++) {
                System.out.print(" ");
            }

            System.out.print("/");

            for (int j = 1; j <= 2*(i-1); j++) {
                System.out.print("+");
            }
            System.out.print("\\");

            for (int j = 2; j <= (width/2-i+1); j++) {
                System.out.print(" ");
            }

            System.out.print("*");
            System.out.println();
        }

        for (int i = 1; i < border; i++) {
            System.out.print("*");
            for (int j = 2; j <= i; j++) {
                System.out.print(" ");
            }

            System.out.print("\\");

            for (int j = 1; j <= (width - 2 * i); j++) {
                System.out.print("+");
            }

            System.out.print("/");

            for (int j = 2; j <= i; j++) {
                System.out.print(" ");
            }

            System.out.print("*");
            System.out.println();
        }

        for (int i = 1; i < border; i++) {
            System.out.print("*");
            for (int j = 2; j <= (width/2-i+1); j++) {
                System.out.print(" ");
            }

            System.out.print("/");

            for (int j = 1; j <= 2*(i-1); j++) {
                System.out.print("+");
            }

            System.out.print("\\");

            for (int j = 2; j <= (8/2-i+1); j++) {
                System.out.print(" ");
            }

            System.out.print("*");
            System.out.println();
        }

        for (int i = 1; i < border; i++) {
            System.out.print("*");
            for (int j = 2; j <= i; j++) {
                System.out.print(" ");
            }

            System.out.print("\\");

            for (int j = 1; j <= (width-2*i); j++) {
                System.out.print("+");
            }
            System.out.print("/");

            for (int j = 2; j <= i; j++) {
                System.out.print(" ");
            }

            System.out.print("*");
            System.out.println();
        }
    }
    public static void main(String args[]) {
        //********************************************************
        //TODO zu Punkt d): Implementieren Sie hier Ihre Lösung für die Angabe

        System.out.println("Nicht Spaghetticode:");

        int width = getWidth();
        int border = width - 3;

        startEnd(width);
        printMid(width, border);
        startEnd(width);

        //********************************************************
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Ausgabe Spaghetticode:");
        System.out.print("#");
        for (int i = 1; i <= 8; i++) {
            System.out.print("+");
        }
        System.out.println("#");
        for (int i = 1; i < 5; i++) {
            System.out.print("*");
            for (int j = 2; j <= (8/2-i+1); j++) {
                System.out.print(" ");            }
            System.out.print("/");
            for (int j = 1; j <= 2*(i-1); j++) {
                System.out.print("+");
            }System.out.print("\\");
            for (int j = 2; j <= (8/2-i+1); j++) { System.out.print(" ");
            }
            System.out.print("*");
            System.out.println();        }
        for (int i = 1; i < 5; i++) {
            System.out.print("*");
            for (int j = 2; j <= i; j++) {
                System.out.print(" ");
            }            System.out.print("\\");
            for (int j = 1; j <= (8 - 2 * i); j++) {System.out.print("+");
            }
            System.out.print("/");
            for (int j = 2; j <= i; j++) {System.out.print(" ");
            }
            System.out.print("*");
            System.out.println();
        }        for (int i = 1; i < 5; i++) {
            System.out.print("*");
            for (int j = 2; j <= (8/2-i+1); j++) {
                System.out.print(" ");
            }
            System.out.print("/");
            for (int j = 1; j <= 2*(i-1); j++) {
                System.out.print("+");
            }
            System.out.print("\\");
            for (int j = 2; j <= (8/2-i+1); j++) {System.out.print(" ");
            }
            System.out.print("*");
            System.out.println();
        }        for (int i = 1; i < 5; i++) {
            System.out.print("*");
            for (int j = 2; j <= i; j++) {
                System.out.print(" ");            }
            System.out.print("\\");
            for (int j = 1; j <= (8-2*i); j++) {System.out.print("+");     }
            System.out.print("/");
            for (int j = 2; j <= i; j++) {
                System.out.print(" ");
            }
            System.out.print("*");
            System.out.println();
        }
        System.out.print("#");        for (int i = 1; i <= 8; i++) {
            System.out.print("+");
        }
        System.out.println("#");
    }
}
