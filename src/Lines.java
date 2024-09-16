import codedraw.*;

public class Lines {

    public static void main(String[] args) {
        CodeDraw cd = new CodeDraw(400, 200);
        cd.setLineWidth(2);

        cd.setColor(Palette.DARK_TURQUOISE);
        cd.drawLine(0, 0, 200, 200);
        cd.drawLine(40, 0, 200, 160);
        cd.drawLine(80, 0, 200, 120);
        cd.drawLine(120, 0, 200, 80);
        cd.drawLine(160, 0, 200, 40);

        cd.setColor(Palette.DARK_ORANGE);
        cd.drawLine(400, 0, 200, 200);
        cd.drawLine(360, 0, 200, 160);
        cd.drawLine(320, 0, 200, 120);
        cd.drawLine(280, 0, 200, 80);
        cd.drawLine(240, 0, 200, 40);

        cd.show();
    }
}
