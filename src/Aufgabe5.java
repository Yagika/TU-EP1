/*
    Aufgabe 5) Quadrate => Rekursiv vs. Iterativ
*/

import codedraw.CodeDraw;

import java.awt.*;

public class Aufgabe5 {

    private static void drawPatternRecursively(CodeDraw myDrawObj, int x, int y, int s, boolean c) {
        if (s < 4) {
            return;
        }

        int next = s / 2;

        drawPatternRecursively(myDrawObj, x + next, y - next, next, !c);
        drawPatternRecursively(myDrawObj, x + next, y + next, next, !c);
        drawPatternRecursively(myDrawObj, x - next, y - next, next, !c);
        drawPatternRecursively(myDrawObj, x - next, y + next, next, !c);

        myDrawObj.setColor(c ? Color.GRAY : Color.CYAN);
        myDrawObj.fillRectangle(x - next, y - next, s, s);
    }

    public static void drawPatternIteratively(CodeDraw myDrawObj, int width) {
        boolean c = false;

        for (int s = 2; s <= width / 2; s = s * 2){
            for (int i = s / 2; i < width; i += s * 2){
                for (int j = s / 2; j < width; j += s * 2){
                    myDrawObj.fillSquare(i, j, s);
                }
            }

            myDrawObj.setColor(c ? Color.cyan : Color.gray);
            c=!c;
        }
       /* int s = width;
        c = true;

        while (s >= 4) {
            myDrawObj.setColor(c ? Color.GRAY : Color.CYAN);
            myDrawObj.fillSquare(width / 2, width / 2, s);

            int halfSize = s / 2;

            // Zeichne Quadrate in den vier Diagonalrichtungen
            myDrawObj.setColor(c ? Color.GRAY : Color.CYAN);
            myDrawObj.fillSquare(width / 2 - halfSize, width / 2 - halfSize, halfSize);
            myDrawObj.fillSquare(width / 2 + halfSize, width / 2 - halfSize, halfSize);
            myDrawObj.fillSquare(width / 2 - halfSize, width / 2 + halfSize, halfSize);
            myDrawObj.fillSquare(width / 2 + halfSize, width / 2 + halfSize, halfSize);

            s /= 2;
            c = !c;
        }*/

    }



    public static void main(String[] args) {

        int pixelWidth = 512;
        int pixelHeight = 512;

        CodeDraw myDrawObjR = new CodeDraw(pixelWidth, pixelHeight);
        myDrawObjR.setTitle("Output Recursive Method");
        myDrawObjR.setCanvasPositionX(100);
        myDrawObjR.setCanvasPositionY(100);
        CodeDraw myDrawObjI = new CodeDraw(pixelWidth, pixelHeight);
        myDrawObjI.setTitle("Output Iterative Method");
        myDrawObjI.setCanvasPositionX(650);
        myDrawObjI.setCanvasPositionY(100);


        drawPatternRecursively(myDrawObjR, pixelWidth / 2, pixelHeight / 2, pixelWidth / 2, true);
        myDrawObjR.show();
        drawPatternIteratively(myDrawObjI, pixelWidth);
        myDrawObjI.show();

    }
}


