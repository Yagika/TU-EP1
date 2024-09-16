/*
    Aufgabe 1) Code Analyse - Eindimensionale Arrays
*/
public class Aufgabe1 {

    private static void printArray(int[] workArray) {
        for (int i = 0; i < workArray.length; i++) {
            System.out.print(workArray[i] + " ");
        }
        System.out.println();
    }

    private static void fillArray(int[] filledArray) {
        int number = 8;
        for (int i = 0; i < filledArray.length; i++) {
            filledArray[i] = number;
            number += 8;
        }
    }

    private static void printContentFilteredArray(int[] workArray) {
        int[] copiedArray = workArray;
        for (int i = 0; i < copiedArray.length; i++) {
            if (copiedArray[i] % 6 == 0) {
                copiedArray[i] = -1;
            }
        }
        printArray(copiedArray);
    }

    private static void fillArrayWithNewContent(int[] workArray) {
        int[] helpArray = new int[8];
        int number = 8;
        for (int i = 0; i < helpArray.length; i++) {
            helpArray[i] = number;
            number += 8;
        }
        workArray = helpArray;
        printArray(workArray);
    }

    public static void main(String[] args) {
        int[] filledArray = new int[10];
        fillArray(filledArray);
        printArray(filledArray);

        printContentFilteredArray(filledArray);
        printArray(filledArray);

        filledArray[0] = 999;
        printArray(filledArray);

        fillArrayWithNewContent(filledArray);
        printArray(filledArray);
    }

    //**************************************************************************
    //**** Notizen und Fragebeantwortungen bitte hier unterhalb durchführen! ***
    //**************************************************************************
    //Antwort zu Punkt a:
    //Hier habe ich das <= auf < korrigiert, da die Nummerierung der Array-Mitglieder in diesem Fall von 0 bis 9 geht
    //und die Länge des gesamten Arrays 10 beträgt, sodass es falsch war, <= einzufügen. Und gab einen Fehler aus,
    // weil das zehnte Mitglied des Arrays nicht existiert.

    //Antwort zu Punkt b:
    //weil Methode "fillArray" private static ist und auch einen Rückgabewert vom Typ Void hat, der angibt, dass
    // diese Methode nichts zurückgibt. Deshalb geben wir am Ende der Methode kein Array zurück. Aber das Array
    // ist mit Werten gefüllt.

    //Antwort zu Punkt c:
    //Da eine Kopie des Arrays "FilledArray" nicht explizit erstellt wurde, weil in Java werden Arrays per Referenz
    //übergeben. Deshalb traten Änderungen im ursprünglichen Array auf. Deshalb wurde in der 48 Zeile das gleiche
    //Array wie in der 47 erzeugtIn. Damit sich keine Änderungen ergeben, kann man diese Methode verwenden: System.arraycopy()

    //Antwort zu Punkt d:
    //nach Beendigung von fillArrayWithNewContent der Wert, auf den workArray verweist, sich wieder auf das alte
    //filledArray ändert. Dadurch ergibt der Aufruf in Zeile 54 wieder den alten Arrayinhalt.
}
