import java.util.Scanner;

/*
    Aufgabe 3) Verschachtelte Schleifen
*/
public class Aufgabe3 {

    public static void main(String[] args) {
        System.out.print("IsTrapezoid:");
        Scanner in = new Scanner(System.in);
        boolean isTr = in.nextBoolean();
        System.out.print("IsParallelogram:");
        Scanner out = new Scanner(System.in);
        boolean isPa = out.nextBoolean();
        System.out.print("What is the width?");
        Scanner sc = new Scanner(System.in);
        int width = sc.nextInt();

        if ((isTr && !isPa) || (isTr && isPa)) {
            if (width % 2 == 0) {
                for (int i = 0; i <= width; i++) {
                    if (i % 2 == 0 && i != 0) {
                        System.out.print(" ".repeat((width - i) / 2));
                        for (int j = 0; j < i; j++) {
                            System.out.print("#");
                        }
                        System.out.println(" ".repeat((width - i) / 2));
                    }
                }
            } else {
                for (int i = 0; i <= width; i++) {
                    if (i % 2 == 1 && i != 1) {
                        System.out.print(" ".repeat((width - i) / 2));
                        for (int j = 0; j < i; j++) {
                            System.out.print("#");
                        }
                        System.out.println(" ".repeat((width - i) / 2));
                    }
                }
            }
        }
        System.out.println();
        if ((isPa && !isTr) || (isTr && isPa)) {
            for (int i = 0; i < width; i++) {
                System.out.print(" ".repeat(i));
                if (i == 0 || i == width-1) {
                    System.out.println("#".repeat(width));
                } else {
                    System.out.println("#"+" ".repeat(width - 2) + "#");
                }

            }
        } else {
            System.out.println("It isn't a Parallelogram and it isn't a Trapezoid");
        }

    }
}
