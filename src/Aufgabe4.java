/*
    Aufgabe 4) CodeDraw Bibliothek
*/

import codedraw.CodeDraw;
import codedraw.Palette;

public class Aufgabe4 {

    public static void main(String[] args) {

        CodeDraw myDrawObj = new CodeDraw(400, 400);
        myDrawObj.setLineWidth(2);

        myDrawObj.setColor(Palette.GRAY);
        myDrawObj.fillRectangle(25, 275, 100, 100);
        myDrawObj.setColor(Palette.YELLOW);
        myDrawObj.drawLine(25, 275, 125, 375);
        myDrawObj.drawLine(125, 275, 25, 375);

        myDrawObj.setColor(Palette.BLUE);
        myDrawObj.fillCircle(200, 100, 50);
        myDrawObj.setColor(Palette.MAGENTA);
        myDrawObj.drawCircle(200, 100, 100);

        myDrawObj.setColor(Palette.RED);
        myDrawObj.fillEllipse(75, 250, 60, 15);
        myDrawObj.fillEllipse(150, 325, 15, 60);

        for (int i = 0; i <= myDrawObj.getHeight() / 2; i += 40) {
            myDrawObj.setColor(Palette.GREEN);
            myDrawObj.drawLine(300, 0, 400, 200 + i);

            myDrawObj.setColor(Palette.ORANGE);
            myDrawObj.drawLine(200, 400, 400, 200 - i);
        }

        myDrawObj.show();
    }
}
