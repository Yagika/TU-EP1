/*
    Aufgabe 5) Schleifen und Zeichnen innerhalb des CodeDraw-Fensters
*/

import codedraw.CodeDraw;
import codedraw.Palette;

import java.util.Scanner;

public class Aufgabe5 {

    public static void main(String[] args) {

        System.out.print("Wie viele Kreise maximal horizontal und vertikal im CodeDraw-Fenster Platz haben sollen? (min=5,max=19)");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n >= 5 && n <= 19) {
            int cW = 300;
            int cH = 300;
            CodeDraw myDrawObj = new CodeDraw(cW, cH);
            float cHf = (float) cH;
            float cWf = (float) cW;


            myDrawObj.setLineWidth(6);
            myDrawObj.setColor(Palette.RED);
            for (float i = 0; i < myDrawObj.getHeight() - cHf / (2 * n); i += (cHf / n)) {
                myDrawObj.drawCircle(cWf / 2, i + cHf / (2 * n), cHf / (2 * n));
                if (cWf / (2 * n) + i < cWf / 2) {
                    myDrawObj.drawCircle(cWf / (2 * n) + i, cHf / (2 * n), cHf / (2 * n));
                } else {
                    myDrawObj.drawCircle(cWf / (2 * n) + i, cHf - cHf / (2 * n), cHf / (2 * n));
                }
            }
            myDrawObj.setLineWidth(2);
            myDrawObj.setColor(Palette.BLUE);
            for (float i = 0; i < myDrawObj.getHeight() - cHf / (2 * n); i += cHf / n) {
                if (Math.round((cWf / (2 * n) + i)) != cWf / 2) {
                    myDrawObj.drawCircle(cWf / (2 * n) + i, cHf / 2, cHf / (2 * n));
                }
                if (i > cHf / (2 * n) && cHf / (2 * n) + i < cHf / 2) {
                    myDrawObj.drawCircle(cWf / (2 * n), cHf / (2 * n) + i, cHf / (2 * n));
                }
            }

            myDrawObj.setColor(Palette.ORANGE);
            myDrawObj.drawCircle((cWf / 2 + cHf / (2 * n)) / 2, cHf / 4 + cHf / (4 * n), cHf / 4 - 3 * cHf / (4 * n));
            myDrawObj.show();
        } else {
            System.out.println("Fehler");
        }
    }
}

