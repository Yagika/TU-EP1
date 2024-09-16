/*
    Aufgabe 4) Rekursion - Flood Fill Algorithmus
*/

import codedraw.*;
import codedraw.Image;

import java.awt.*;
import java.io.File;
import java.util.Scanner;

public class Aufgabe4 {

    private static int readIntValue(Scanner sc) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Angabe
        int proc;
        while (true) {
            if (sc.hasNextInt()) {
                proc = sc.nextInt();
                if (proc >= 1 && proc <= 50) {
                    break;
                } else {
                    System.out.println("The value isn't in the interval [1, 50]. Try one more time:");
                }
            } else {
                System.out.println("Error! You typed the wrong type. Try one more time:");
                sc.next();
            }
        }
        return proc; //Zeile kann geändert oder entfernt werden.
    }


    private static void floodFill(CodeDraw myDrawObj, int[][] imgArr, int sx, int sy, int gVal, int gThresh) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Angabe

        if (sx < 0 || sx >= imgArr.length || sy < 0 || sy >= imgArr[0].length) {
            return;
        }

        imgArr[sx][sy] = -1;
        myDrawObj.setPixel(sx, sy, Palette.LIME);
        if (imgArr[sx][sy] <= gVal - gVal * gThresh / 100) {
            floodFill(myDrawObj, imgArr, sx, sy + 1, gVal, gThresh);
            floodFill(myDrawObj, imgArr, sx, sy - 1, gVal, gThresh);
            floodFill(myDrawObj, imgArr, sx + 1, sy, gVal, gThresh);
            floodFill(myDrawObj, imgArr, sx - 1, sy, gVal, gThresh);
        }

    }

    // ************************************ BEREITS IMPLEMENTIERTE METHODE **************************************
    // converts RGB image into a grayscale array
    private static int[][] convertImg2Array(Image img) {
        int width = img.getWidth();
        int height = img.getHeight();
        int[][] imgArray = new int[height][width];
        Color tempColor;

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                tempColor = img.getPixel(col, row);
                imgArray[row][col] = (int) (tempColor.getRed() * 0.3 + tempColor.getGreen() * 0.59 + tempColor.getBlue() * 0.11);
            }
        }
        return imgArray;
    }

    //***********************************************************************************************************

    public static void main(String[] args) {

        String pathImage = System.getProperty("user.dir") + File.separator + "src" + File.separator + "world.png";

        // open image file
        Image img = Image.fromFile(pathImage);

        // set StdDraw window size based on the image size
        int width = img.getWidth();
        int height = img.getHeight();

        CodeDraw myDrawObj = new CodeDraw(width, height);
        EventScanner myEventSC = myDrawObj.getEventScanner();
        Scanner myScannerObj = new Scanner(System.in);

        //draw image
        myDrawObj.drawImage(0, 0, img);
        myDrawObj.show();

        // convert rgb image into grayscale array
        int[][] myImage = convertImg2Array(img);

        System.out.println("Please click on an area within the image!");

        while (!myDrawObj.isClosed()) {
            if (myEventSC.hasMouseClickEvent()) {
                MouseClickEvent currentClick = myEventSC.nextMouseClickEvent();
                int mouseX = currentClick.getX();
                int mouseY = currentClick.getY();

                //System.out.println("mouseX: " + mouseX + " mouseY: " + mouseY);
                //printArray(myImage,mouseX-10,mouseY-10,mouseX+10,mouseY+10);
                //myDrawObj.drawRectangle(mouseX-10,mouseY-10,20,20);

                // read grayscale value of clicked point and read user info for the grayscale threshold
                System.out.println("Grayvalue of the clicked position x:" + mouseX + " y:" + mouseY + " is:" + myImage[mouseY][mouseX]);

                int grayThreshold;
                do {
                    System.out.println("Please type value between 1-50% for the grayscale threshold: ");
                    grayThreshold = readIntValue(myScannerObj);
                } while (grayThreshold < 1 || grayThreshold > 50);
                floodFill(myDrawObj, myImage, mouseX, mouseY, myImage[mouseY][mouseX], grayThreshold);
                System.out.println("FloodFill finished!");
                myDrawObj.show();
            } else {
                myEventSC.nextEvent();
            }
        }
        myDrawObj.close();
        myScannerObj.close();
    }
}


