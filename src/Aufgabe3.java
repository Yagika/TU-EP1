import java.util.Locale;

/*
    Aufgabe 3) Rekursion
*/
public class Aufgabe3 {

    private static void printOddNumbersAscending(int start, int end) {
        System.out.print(start + " ");
        if (start != end) {
            printOddNumbersAscending(start+2, end);
        }
    }

    private static void printEvenNumbersDescending(int end) {
        if (end >= 0) {
            System.out.print(end + " ");
            printEvenNumbersDescending(end - 2);
        }
    }

    private static int countDigitsAboveFive(int number) {
        if (number == 0) {
            return 0;
        } else {
            // damit kriegt man das letzte zahl
            int lastNum = number % 10;
            // 1 wenn groesser als 5 else 0
            int counter = (lastNum > 5) ? 1 : 0;
            return counter + countDigitsAboveFive(number / 10);
        }
    }

    private static boolean checkIfStopAvailable(String text) {
        if (text.length() < 4) {
            return false;
        }

        text = text.toLowerCase(Locale.ROOT);
        if (text.startsWith("stop")) {
            return true;
        }

        // weitere Elemente ohne 1. zeichen uebergeben
        return checkIfStopAvailable(text.substring(1));

    }



    public static void main(String[] args) {
        printOddNumbersAscending(3, 15);
        System.out.println();
        printEvenNumbersDescending(14);
        System.out.println();

        System.out.println(countDigitsAboveFive(6));
        System.out.println(countDigitsAboveFive(4));
        System.out.println(countDigitsAboveFive(456));
        System.out.println(countDigitsAboveFive(1234));
        System.out.println(countDigitsAboveFive(61238));
        System.out.println(countDigitsAboveFive(93862));
        System.out.println(countDigitsAboveFive(518279463));
        System.out.println();

        System.out.println(checkIfStopAvailable(""));
        System.out.println(checkIfStopAvailable("sto"));
        System.out.println(checkIfStopAvailable("STOP"));
        System.out.println(checkIfStopAvailable("stOkP3tOp"));
        System.out.println(checkIfStopAvailable("dasStOpistda"));
        System.out.println(checkIfStopAvailable("ASTOP"));
        System.out.println(checkIfStopAvailable("asTsTopstoPb"));

        //DIE NACHFOLGENDEN ZEILEN SIND ZUM TESTEN DER METHODE.
        //**********************************************************************
        assert (countDigitsAboveFive(6) == 1);
        assert (countDigitsAboveFive(4) == 0);
        assert (countDigitsAboveFive(456) == 1);
        assert (countDigitsAboveFive(1234) == 0);
        assert (countDigitsAboveFive(61238) == 2);
        assert (countDigitsAboveFive(93862) == 3);
        assert (countDigitsAboveFive(518279463) == 4);

        assert(!checkIfStopAvailable(""));
        assert(!checkIfStopAvailable("sto"));
        assert(checkIfStopAvailable("STOP"));
        assert(!checkIfStopAvailable("stOkP3tOp"));
        assert(checkIfStopAvailable("dasStOpistda"));
        assert(checkIfStopAvailable("ASTOP"));
        assert(checkIfStopAvailable("asTsTopstoPb"));
        //**********************************************************************
    }
}

