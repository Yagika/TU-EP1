/*
    Aufgabe 4) Rekursion
*/
public class Aufgabe4 {

    private static int countNOrderedLetters(String text, int index) {
        if (index >= text.length() - 1) {
            return 0;
        }

        text = text.toLowerCase();

        char now = text.charAt(index);
        char next = text.charAt(index+1);

        int counter = 0;

        if (Character.isLetter(now) && Character.isLetter(next)) {
            if (now <= next) {
                counter = 1;
            }
        }

        return counter + countNOrderedLetters(text, index + 1);
    }

    private static String duplicateSelectedCharHelper(String text, char character, int count) {
        if (text.length() == 0) {
            return text + (count > 0 ? Integer.toString(count) : "");
        }

        if (Character.toLowerCase(text.charAt(0)) == Character.toLowerCase(character)) {
            count++;
            return text.charAt(0) + "" + text.charAt(0) + duplicateSelectedCharHelper(text.substring(1), character, count);
        } else {
            return text.charAt(0) + duplicateSelectedCharHelper(text.substring(1), character, count);
        }
    }
    private static String duplicateSelectedChar(String text, char character) {
        return duplicateSelectedCharHelper(text, character, 0);
    }

    public static void main(String[] args) {

        String text = "bCaa12fgHIdE32zYxYz";
        System.out.println(countNOrderedLetters(text, 0));
        System.out.println(countNOrderedLetters(text, 1));
        System.out.println(countNOrderedLetters(text, 6));
        System.out.println(countNOrderedLetters(text, 13));
        System.out.println(countNOrderedLetters(text, 17));
        System.out.println();

        System.out.println(duplicateSelectedChar("", 'o'));
        System.out.println(duplicateSelectedChar("K", 'k'));
        System.out.println(duplicateSelectedChar("abcAijk", 'a'));
        System.out.println(duplicateSelectedChar("abcAijk", 'A'));
        System.out.println(duplicateSelectedChar("AbNcdnNopqnUvWN", 'n'));
        System.out.println(duplicateSelectedChar("AbNcdnNopqnUvWN", 'm'));
        System.out.println(duplicateSelectedChar("nothing", 'Z'));

        //DIE NACHFOLGENDEN ZEILEN SIND ZUM TESTEN DER METHODE.
        //**********************************************************************
        assert (countNOrderedLetters(text, 0) == 8);
        assert (countNOrderedLetters(text, 1) == 7);
        assert (countNOrderedLetters(text, 6) == 6);
        assert (countNOrderedLetters(text, 13) == 2);
        assert (countNOrderedLetters(text, 17) == 1);

        assert (duplicateSelectedChar("", 'o').equals(""));
        assert (duplicateSelectedChar("K", 'k').equals("KK1"));
        assert (duplicateSelectedChar("abcAijk", 'a').equals("aabcAAijk2"));
        assert (duplicateSelectedChar("abcAijk", 'A').equals("aabcAAijk2"));
        assert (duplicateSelectedChar("AbNcdnNopqnUvWN", 'n').equals("AbNNcdnnNNopqnnUvWNN5"));
        assert (duplicateSelectedChar("AbNcdnNopqnUvWN", 'm').equals("AbNcdnNopqnUvWN"));
        assert (duplicateSelectedChar("nothing", 'Z').equals("nothing"));
        //**********************************************************************
    }
}
