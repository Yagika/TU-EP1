import java.util.Collections;
import java.util.Scanner;

/*
    Aufgabe 2) while-Schleifen
*/
public class Aufgabe2 {

    public static void main(String[] args) {
        /*
        String text = "Eine nennenswerte und geeignete Sprache.";
        String test = "Anzahl der Zeichen ist nicht genug!";
        */
        //a
        Scanner in = new Scanner(System.in);
        String text = in.nextLine();
        char[] arrchar = text.toCharArray();
        String str = new String();
        int i = 0;
        while (i < text.length()) {
            if (arrchar[i] != 'n' && arrchar[i] != 'N' && i % 2 == 1) {
                str += arrchar[i];
            }
            i++;
        }
        System.out.println(str);

        //b
        Scanner out = new Scanner(System.in);
        String test = out.nextLine();
        char[] arr = test.toCharArray();
        String strarr = new String();
        int k = test.length() - 1;
        int sumN = 0;
        while (k >= 0) {
            strarr += arr[k];
            if (arr[k] == 'n') {
                sumN++;
            }
            if (sumN == 5) {
                StringBuffer nstr = new StringBuffer(strarr);
                System.out.println(nstr.reverse());
                break;
            }
            if (k == 0 && sumN < 5) {
                StringBuffer nstr1 = new StringBuffer(strarr);
                System.out.println(nstr1.reverse());
            }
            k--;
        }

        //c
        Scanner sc = new Scanner(System.in);
        String textC = sc.nextLine();
        char[] arrC = text.toCharArray();
        int sumletter = 0;
        int n = 0;
        while (n < textC.length()) {
            if ((arrC[n] >= 'a' && arrC[n] <= 'm') || (arrC[n] >= 'A' && arrC[n] <= 'M')) {
                sumletter += 1;
            }
            n++;
        }
        System.out.println(sumletter);

        //d
        int num = 20;
        while (num < 304) {
            if (num%2==0 && num%19==0) {
                System.out.print(num+" ");
            }
            num++;
        }
    }
}






