import codedraw.*;

public class Aufgabe0 {
    public static void main(String[] args) {
        //"Hello World!" einmal anders.
        int width = 300;
        int height = 100;
        int x = 0, xStart = -90;

        CodeDraw cd = new CodeDraw(width, height);
        cd.setTitle("\"Hello World!\"");

        while (true) {
            cd.clear();
            if(x == width){
                x = xStart;
            }
            else{
                x++;
            }
            cd.drawText(x, height / 2.0, "Hello Yana!");
            cd.show(10);
        }
    }
}
