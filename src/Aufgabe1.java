import java.util.ArrayList;
import java.util.Collections;

/*
    Aufgabe 1) for-Schleifen
*/
public class Aufgabe1 {

    public static void main(String[] args) {
       /* a) Schreiben Sie eine for-Schleife, die alle durch 11 teilbaren Zahlen im Intervall1 ]11, 110]
        aufsummiert und das Ergebnis auf der Konsole ausgibt.
        Erwartetes Ergebnis: 594*/
        int sum = 0;
        for (int i = 12; i <= 110; i++) {
            if (i % 11 == 0) {
                sum += i;
            }
        }
        System.out.println(sum);

       /* b) Schreiben Sie eine for-Schleife, die jede 7. Zahl im Intervall [7, 49[ (beginnend mit 7) neben-einander
       durch Leerzeichen getrennt ausgibt.
                Erwartetes Ergebnis: 7 14 21 28 35 42   */
        for (int i = 7; i < 49; i += 7) {
            System.out.print(i + " ");
        }
        System.out.println();

        /*c) Schreiben Sie eine for-Schleife, die alle Zahlen, die durch 13 und 17 im Intervall von ]221,
        1105] teilbar sind, hintereinander und getrennt durch Sterne (’*’) ausgibt. Zus¨atzlich wird
        noch vor der ersten Zahl und nach der letzten Zahl ein Stern ausgegeben.
        Erwartetes Ergebnis: *442*663*884*1105*      */
        System.out.print("*");
        for (int i = 222; i <= 1105; i++) {
            if (i % 13 == 0 && i % 17 == 0) {
                System.out.print(i + "*");
            }
        }
        /*d) Schreiben Sie eine for-Schleife, die alle Zeichen der ASCII2
        -Werte im Intervall ]70, 80[ in
        absteigender Reihenfolge durch Beistriche getrennt ausgibt.
        Erwartetes Ergebnis: O,N,M,L,K,J,I,H,G     */
        System.out.println();
        ArrayList arr = new ArrayList();
        for (int i = 71; i < 80; i += 1) {
            arr.add((char) i);
        }
        Collections.reverse(arr);
        System.out.println(String.join(", ", arr.toString()));


        /*e) Schreiben Sie eine for-Schleife, die alle Vorkommen der Buchstaben ’z’ und ’Z’ im Satz
        Zehn zahme Ziegen zogen zehn Zentner zerbr¨oselten Zucker zum Zoo! z¨ahlt.
        Erwartetes Ergebnis: 10     */
        String str = "Zehn zahme Ziegen zogen zehn Zentner zerbr¨oselten Zucker zum Zoo!";
        char[] arrchar = str.toCharArray();
        int sumLetter = 0;
        for (int i = 0; i < str.length(); i++) {
            if (arrchar[i] == 'z' || arrchar[i] == 'Z') {
                sumLetter += 1;
            }
        }
        System.out.print(sumLetter);
    }
}
