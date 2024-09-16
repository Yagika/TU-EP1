public class ConsolePattern {
    /*public static void main(String[] args) {
        int größe=3;
        System.out.println(größe);
        for (int i=0;i<größe;i++) {
            for (int j = 0; j < größe; j++) {
                System.out.print('.');
            }
            System.out.println();
        }
    }*/
    public static void main(String[] args) {
        int g=5;
        System.out.println("Größe des Quadrats"+g);
        for (int i=0;i<g;i++) {
            for (int j = 0; j < g; j++) {
                if (i==j-i){
                    System.out.print('+');
                }else{
                System.out.print('.');
                }
            }
            System.out.println();
        }
    }
}
