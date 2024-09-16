import codedraw.*;

public class CodeDrawDebug {

    public static void main(String[] args) {
        int canvasWidth = 500;
        int canvasHeight = 350;

        int rows = 4;
        int boxLength = 429;
        int boxHeight = 286;

        // Alle Werte bis hierher sind fix und sollen nicht verändert werden

        CodeDraw cd = new CodeDraw(canvasWidth, canvasHeight);
        cd.setInstantDraw(true);
        cd.setAlwaysOnTop(true);

        double startX = (canvasWidth - boxLength) / 2.;
        double startY = (canvasHeight - boxHeight) / 2.;
        int size = boxHeight / rows;
        boolean brown = true;

        for (int row = 0; row < rows; row++) {
            double xOffset = 0;
            while (xOffset <= boxLength-size) {
                cd.setColor(brown ? Palette.DARK_ORANGE : Palette.SADDLE_BROWN);
                cd.fillSquare(startX + xOffset, startY + row * size, size);
                xOffset += size;
                brown = !brown;
            }
                brown = !brown;
        }

        cd.setColor(Palette.BLACK);
        cd.setLineWidth(2);
        cd.drawRectangle(startX, startY, boxLength, boxHeight);

        // der Aufruf auf show ist nicht nötig, da setInstantDraw(true) oben gesetzt worden ist
        // cd.show();
    }
}