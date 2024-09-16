/*
    Aufgabe 2) Überladen von Methoden
*/
public class Aufgabe2 {

    private static void addChar(String text, char character) {
        StringBuilder res = new StringBuilder();
        boolean isDoubleChar = true;
        for (int i=0; i < text.length(); i++) {
            res.append(text.charAt(i));
            if (i != text.length() - 1) {
                res.append((isDoubleChar) ? String.valueOf(character).repeat(2) : character);
                isDoubleChar = !isDoubleChar;
            }
        }

        System.out.println(res);
    }

    private static void addChar(int number, char character) {
        boolean isDoubleChar = true;
        String text = Integer.toString(number);
        StringBuilder res = new StringBuilder();
        for (int i=0; i < text.length(); i++) {
            res.append(text.charAt(i));
            if (i != text.length() - 1) {
                // zu res 2 character addieren, wenn isDoubleChar auf true gesetzt ist, else nur ein character
                res.append((isDoubleChar) ? String.valueOf(character).repeat(2) : character);
                // die variable nach jeden Schritt umwandeln
                isDoubleChar = !isDoubleChar;
            }
        }

        System.out.println(res);
    }

    private static void addChar(String text, String characters) {
        StringBuilder res = new StringBuilder();
        boolean isDoubleChar = true;
        // ab hier wirds kompliziert, aber ich probier es zu erklaeren

        // index iteraion ueber characters
        for (int i=0; i < characters.length(); i++) {
            // 2. schleife dazu fuer die woerter
            for (int j=0; j < text.length(); j++) {
                // gleich das erste zeichen dazu schreiben
                res.append(text.charAt(j));
                // wenn es nicht das letzte char ist
                if (j != text.length() - 1) {
                    // 2 chars addieren wenn gerade, 1 wenn ungerade
                    res.append((isDoubleChar) ? String.valueOf(characters.charAt(i)).repeat(2) : characters.charAt(i));
                    // bool variable swipen
                    isDoubleChar = !isDoubleChar;
                }
            }

            // das wort ausgeben
            System.out.println(res);

            // settings refreshen
            res = new StringBuilder();
            isDoubleChar = true;

            // next step in 1. for schleife
        }

        // ich hoffe, dass die Kommentare geholfen haben :)

    }

    private static void addChar(String text) {
        StringBuilder res = new StringBuilder();
        int counter = 0;
        for (int i=0; i < text.length(); i++) {
            res.append(text.charAt(i));
            if (i != text.length() - 1) {
                if (counter % 2 == 0) {
                    res.append(String.valueOf('=').repeat(2));
                } else {
                    res.append('=');
                }
            }

            counter++;

        }

        System.out.println(res);
    }

    public static void main(String[] args) {
        String text0 = "";
        String text1 = "A";
        String text2 = "CW";
        String text3 = "EP1";
        String text4 = "Index";

        addChar(text0, '&');
        addChar(text1, '+');
        addChar(text2, '*');
        addChar(text3, '-');
        addChar(text4, '#');
        System.out.println();

        addChar(1, '.');
        addChar(42, ':');
        addChar(148, '$');
        addChar(2048, ')');
        addChar(131719, '%');
        System.out.println();

        addChar(text2, "!O(");
        addChar(text4, "T1#+");
        System.out.println();

        addChar(text1);
        addChar(text2);
        addChar(text3);
    }
}
