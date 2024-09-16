/*
    Aufgabe 5) Designaufgabe
*/


import codedraw.*;

import java.awt.*;

public class Aufgabe5 {
    public static double map(double value, double start1, double stop1, double start2, double stop2) {
        return start2 + (stop2 - start2) * ((value - start1) / (stop1 - start1));
    }

    public static Color shade(double iterations) {
        int a = 255;
        int r, g, b;

        if (iterations < 1000) {
            double shade = map(iterations, 0, 1000, 0, 1);

            if (shade < 0.5) {
                r = (int) (shade * 2 * 255);
                g = 0;
            } else {
                r = 255;
                g = (int) ((shade - 0.5) * 2 * 255);
            }
            b = 0;

        } else {
            r = g = b = 0;
        }

        return new Color(r, g, b, a);
    }

    public static void main(String[] args) {

        CodeDraw Mandelbrot = new CodeDraw(800, 600);

        for (int y = 0; y < Mandelbrot.getHeight(); y++) {
            for (int x = 0; x < Mandelbrot.getWidth(); x++) {
                double cre = map(x, 0, Mandelbrot.getWidth(), -2, 0.5);
                double cim = map(y, 0, Mandelbrot.getHeight(), -1, 1);
                double x0 = 0, y0 = 0;
                int iterations = 0;

                while (x0 * x0 + y0 * y0 < 4 && iterations < 1000) {
                    double xTemp = x0 * x0 - y0 * y0 + cre;
                    y0 = 2 * x0 * y0 + cim;
                    x0 = xTemp;
                    iterations++;
                }
                Mandelbrot.setPixel(x, y, shade(iterations));
            }
        }
        Mandelbrot.show();
    }

}

