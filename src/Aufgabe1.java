/*
    Aufgabe 1) Zweidimensionale Arrays - diverse Methoden
*/

import java.util.Arrays;

public class Aufgabe1 {

    private static void shiftLines(int[][] workArray) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode
        int index = 0;
        int len = workArray[0].length;
        int[] erste = workArray[0];
        for (int i = 0; i < workArray.length; i++) {
            if (workArray[i].length < len) {
                len = workArray[i].length;
                index = i;
            }
        }
        workArray[0] = workArray[index];
        workArray[index] = erste;
    }


    private static void reformatArray(int[][] inputArray) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode
        for (int i = 0; i < inputArray.length; i++) {
            int sum = 0;
            for (int j = 0; j < inputArray[i].length; j++) {
                if (inputArray[i][j] == 0) {
                    sum++;
                }
            }
            int[] workarray = new int[inputArray[i].length-sum+1];
            for (int j = 0; j < inputArray[i].length - sum; j++) {
                workarray[j] = 1;

            }
            workarray[workarray.length-1]=1;
            workarray[0] = sum;
            inputArray[i]=workarray;
        }
    }

    //Vorgegebene Methode - BITTE NICHT VERÄNDERN!
    private static void printArray(int[][] inputArray) {
        if (inputArray != null) {
            for (int i = 0; i < inputArray.length; i++) {
                for (int j = 0; j < inputArray[i].length; j++) {
                    System.out.print(inputArray[i][j] + "\t");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {

        System.out.println("Test shiftLines:");
        System.out.println("-----");
        int[][] array1 = new int[][]{{1, 3, 2}, {6, 2, 5}, {0, 7, 9}};
        System.out.println("Before:");
        printArray(array1);
        shiftLines(array1);
        assert (Arrays.deepEquals(array1, new int[][]{{1, 3, 2}, {6, 2, 5}, {0, 7, 9}}));
        System.out.println("-----");
        System.out.println("After:");
        printArray(array1);
        System.out.println("-----");

        array1 = new int[][]{{1, 5, 6, 7}, {1, 9, 6}, {4, 3}, {6, 3, 0, 6, 9}, {6, 4, 3}};
        System.out.println("Before:");
        printArray(array1);
        shiftLines(array1);
        assert (Arrays.deepEquals(array1, new int[][]{{4, 3}, {1, 9, 6}, {1, 5, 6, 7}, {6, 3, 0, 6, 9}, {6, 4, 3}}));
        System.out.println("-----");
        System.out.println("After:");
        printArray(array1);
        System.out.println("-----");

        array1 = new int[][]{{3, 2, 4, 1}, {7, 3, 6}, {4}, {5, 6, 2, 4}, {9, 1}, {3}};
        System.out.println("Before:");
        printArray(array1);
        shiftLines(array1);
        assert (Arrays.deepEquals(array1, new int[][]{{4}, {7, 3, 6}, {3, 2, 4, 1}, {5, 6, 2, 4}, {9, 1}, {3}}));
        System.out.println("-----");
        System.out.println("After:");
        printArray(array1);
        System.out.println("-----");


        System.out.println();
        System.out.println("Test: reformatArray");
        System.out.println("-----");
        int[][] array2 = new int[][]{{1, 0, 1, 1}, {0, 1, 1}, {0, 1, 0, 1, 1}, {0, 0, 0, 1, 0}, {1, 0}, {1, 1, 1, 1, 1}};
        System.out.println("Before:");
        printArray(array2);
        reformatArray(array2);
        assert (Arrays.deepEquals(array2, new int[][]{{1, 1, 1, 1}, {1, 1, 1}, {2, 1, 1, 1},
                {4, 1}, {1, 1}, {0, 1, 1, 1, 1, 1}}));
        System.out.println("-----");
        System.out.println("After:");
        printArray(array2);
        System.out.println("-----");

        array2 = new int[][]{{1, 0, 1, 1, 0, 0, 0, 0}, {0, 1, 1, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 1}, {1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 0, 1}, {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1}};
        System.out.println("Before:");
        printArray(array2);
        reformatArray(array2);
        assert (Arrays.deepEquals(array2, new int[][]{{5, 1, 1, 1}, {3, 1, 1, 1, 1, 1}, {6, 1, 1},
                {7, 1}, {5, 1, 1, 1}, {8}, {7, 1}}));
        System.out.println("-----");
        System.out.println("After:");
        printArray(array2);
        System.out.println("-----");

        array2 = new int[][]{{0}, {1}, {0, 0}, {0, 1}, {1, 0}, {1, 1}};
        System.out.println("Before:");
        printArray(array2);
        reformatArray(array2);
        assert (Arrays.deepEquals(array2, new int[][]{{1}, {0, 1}, {2}, {1, 1}, {1, 1}, {0, 1, 1}}));
        System.out.println("-----");
        System.out.println("After:");
        printArray(array2);
        System.out.println("-----");
    }
}

