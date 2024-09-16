/*
    Aufgabe 2) Eindimensionale Arrays
*/
public class Aufgabe2 {

    public static void main(String[] args) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Angabe
        //a
        int number = 2;
        int[] workArray = new int[15];
        for (int i = 0; i < workArray.length; i++) {
            workArray[i] = number * number * number;
            if (workArray[i] % 9 == 0) {
                workArray[i] = 0;
            }
            number++;
            System.out.print(workArray[i] + " ");
        }
        System.out.println();

        //b
        char[] charArray = {'a', '8', 'U', '3', ':', '9', 'd', 'F', '-', 'T'};
        int numbers = 0;
        for (char c : charArray) {
            if (Character.isDigit(c)) {
                numbers++;
            }
        }
        char[] charArraycopy = new char[charArray.length + numbers];
        int k = 0;
        for (char c : charArray) {
            if (Character.isDigit(c)) {
                charArraycopy[k] = 'Z';
                charArraycopy[k + 1] = c;
                k += 2;
            } else {
                charArraycopy[k] = c;
                k++;
            }
        }
        for (char c : charArraycopy) {
            System.out.print(c + " ");
        }
        System.out.println();

        //c
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++) {
            array[i] = array.length - i;
        }
            System.out.print("for-Schleife: ");
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 2) {
                System.out.println(array[i]);
            } else if (i % 2 == 0 && i!=array.length-2) {
                System.out.print(array[i] + ":");
            }
        }

        System.out.print("while-Schleife: ");
        int i=0;
        while( i<array.length-1) {
            if (i == array.length - 2) {
                System.out.println(array[i]);
            } else if (i % 2 == 0 && i!=array.length-2) {
                System.out.print(array[i] + ":");
            }
            i++;
        }
    }
}

