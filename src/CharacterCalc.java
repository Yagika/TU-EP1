public class CharacterCalc {
    public static void main(String[] args) {
        char a = '2', b = '5', c = '7';
        int diffAB = -1, diffBC = -1;
        if (a < b) {
            if (b < c && a >= '0' && c <= '9') {
// hier gilt für a, b, c: ...
                diffAB = b - a;
                diffBC = c - b;
            }
        } else {
            if (c <= b && c >= '0' && a <= '9') {
// hier gilt für a, b, c: ...
                diffAB = a - b;
                diffBC = b - c;
            }
        }
        if (diffAB < 0) {
// hier gilt für diffBC: ...
            System.out.println("Ungültige Werte");
        } else if (diffAB > diffBC) {
            System.out.println("Ja, " + diffAB + " größer " + diffBC);
        } else {
            System.out.println("Nein, " + diffAB + " nicht größer " + diffBC);
        }
    }
}