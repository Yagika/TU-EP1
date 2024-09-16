public class Triangles {
    public static void main(String[] args) {
        int lines=3;
        System.out.print("lines="+lines);
        for (int i=0;i<=lines;i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
