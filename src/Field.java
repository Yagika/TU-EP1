import codedraw.*;

public class Field {
    public static void main(String[] args) {
        CodeDraw cd = new CodeDraw(800, 540);
        cd.setColor(Palette.GREEN);
        cd.fillRectangle(0, 0, 800, 540);

      //  for (int i=0; i<5; i=+10){
          //  cd.fillRectangle(0, 0, 780, 520);
      //  }

        cd.setColor(Palette.WHITE);
        cd.setLineWidth(3);
        cd.drawRectangle(10, 10, 780, 520);

        cd.drawRectangle(10, 100, 150, 340);
        cd.drawRectangle(10, 200, 50, 140);
        cd.fillCircle(105, 270, 5);
        cd.drawArc(105, 270, 80, Math.toRadians(-45), Math.toRadians(90));

        cd.drawRectangle(640, 100, 150, 340);
        cd.drawRectangle(740, 200, 50, 140);
        cd.fillCircle(695, 270, 5);
        cd.drawArc(695, 270, 80, Math.toRadians(135), Math.toRadians(90));

        cd.drawLine(400, 10, 400, 530);
        cd.drawCircle(400, 270, 80);
        cd.fillCircle(400, 270, 5);

        cd.show();
    }
}
