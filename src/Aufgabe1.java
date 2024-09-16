/*
    Aufgabe 1) Verschachtelte Schleifen - optische Täuschung
*/

import codedraw.CodeDraw;
import codedraw.Palette;

import java.awt.*;

public class Aufgabe1 {
    public static void main(String[] args) {

        CodeDraw myDrawObj = new CodeDraw(400, 440);

        int k = 0;
        for (int i = 0; i <= myDrawObj.getHeight(); i += 40) {
            k++;
            for (int j = 0; j < myDrawObj.getWidth(); j += 40) {
                if (k % 2 == 1) {
                    myDrawObj.setColor(new Color(166, 166, 76));
                } else {
                    myDrawObj.setColor(new Color(90, 90, 0));
                }
                myDrawObj.fillRectangle(j, i, 40, 40);
                k++;

            }
        }
        for (int i = 0; i <= myDrawObj.getHeight() - 50; i += 40) {
            for (int j = 0; j < myDrawObj.getWidth() - 40; j += 40) {
                if (k % 2 == 1) {
                    myDrawObj.setColor(Palette.WHITE);
                    myDrawObj.fillRectangle(j + 38, i + 30, 4, 20);
                    myDrawObj.setColor(Palette.BLACK);
                    myDrawObj.fillRectangle(j + 30, i + 38, 20, 4);
                } else {
                    myDrawObj.setColor(Palette.WHITE);
                    myDrawObj.fillRectangle(j + 30, i + 38, 20, 4);
                    myDrawObj.setColor(Palette.BLACK);
                    myDrawObj.fillRectangle(j + 38, i + 30, 4, 20);
                }
                k++;
            }
        }


        myDrawObj.show();
    }
}
