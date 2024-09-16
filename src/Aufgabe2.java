import java.util.Scanner;

/*
    Aufgabe 2) Erste Methoden
*/
public class Aufgabe2 {
    public static void printAsciiNeighbors(char character) {
        char prevChar = (char) (character - 1);
        System.out.print(prevChar);
        System.out.print(character);
        char nextChar = (char) (character + 1);
        System.out.println(nextChar);
    }

    public static void printAlphabet() {
        for (int i = 'a'; i <= 'z'; i++) {
            System.out.print((char) i + " ");
        }
        System.out.println();
    }

    public static void calcSum(int start, int end) {
        if (start > end) {
            System.out.println("Fehler");
        } else {
            int sum = 0;
            for (int i = start; i <= end; i++) {
                sum += i;
            }
            System.out.print("Sum von " + start + " bis " + end + ": ");
            System.out.println(sum);

        }
    }

    public static boolean isCharOnceInString(String text, char charecter) {
        if (text == null) {
            System.out.println("Fehler");
            return false;
        } else {
            char[] arrtext = text.toCharArray();
            int k = 0;
            for (char c : arrtext) {
                if (c == charecter) {
                    k++;
                }
            }
            return k == 1;
        }
    }

    public static String removeNumbersInString(String text) {
        if (text == null) {
            System.out.println("Fehler");
            return null;
        } else {
            System.out.println("Old Text: '" + text + "'");
            char[] arrtext = text.toCharArray();
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < text.length(); i++) {
                if (!(arrtext[i] >= '0') || !(arrtext[i] <= '9')) {
                    str.append(arrtext[i]);
                }
            }
            System.out.println("New Text: '" + str + "'");
            return str.toString();
        }
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String text = in.nextLine();
        char[] arrchar = text.toCharArray();
        if (arrchar.length > 1) {
            System.out.println("Fehler");
        } else {
            System.out.print("Nachbarn von '" + arrchar[0] + "': ");
            printAsciiNeighbors(arrchar[0]);
        }


        System.out.print("Alphabet: ");
        printAlphabet();


        System.out.print("Interval von: ");
        Scanner sin = new Scanner(System.in);
        int start = sin.nextInt();
        System.out.print("Interval bis: ");
        Scanner ein = new Scanner(System.in);
        int end = ein.nextInt();
        calcSum(start, end);


        System.out.println(isCharOnceInString("abc", 'b'));


        //DIE NACHFOLGENDEN ZEILEN SIND ZUM TESTEN DER METHODEN.
        //ENTFERNEN SIE DIE KOMMENTARE, UM IHRE METHODEN ZU TESTEN.
        /*
        assert (calcSum(-1,1) == 0);
        assert (calcSum(0,0) == 0);
        assert (calcSum(256,331) == 22306);
        assert (calcSum(0,22) == 253);
        assert (calcSum(-31,14) == -391);
        */


        assert (!isCharOnceInString("", 'a'));
        assert (isCharOnceInString("a", 'a'));
        assert (isCharOnceInString("abc", 'b'));
        assert (!isCharOnceInString("nennenswerte Worte", 'n'));
        assert (isCharOnceInString("nennenswerte Worte", 'o'));
        assert (!isCharOnceInString("nennenswerte Worte", 'z'));

        assert (removeNumbersInString("").equals(""));
        assert (removeNumbersInString("123").equals(""));
        assert (removeNumbersInString("1A2B3C").equals("ABC"));
        assert (removeNumbersInString("Das ist die Nummer 1").equals("Das ist die Nummer "));
        assert (removeNumbersInString("Es gibt keine Ziffer").equals("Es gibt keine Ziffer"));
        assert (removeNumbersInString("3 mal die 5 ist gleich 15").equals(" mal die  ist gleich "));
    }
}
