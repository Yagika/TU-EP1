/*
    Aufgabe 5) Zweidimensionale Arrays - Diverse Methoden
*/

import java.util.Arrays;

public class Aufgabe5 {

    private static int[][] generateFilledArray(int n) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode
        int[][] filledArray = new int[n][n];
        int start = 1;
        int end = (n * n + 1) / 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (end % 2 == 0) {
                    if (start <= end) {
                        filledArray[i][j] = start;
                        start++;
                    } else {
                        filledArray[i][j] = end;
                        end--;
                    }
                } else {
                    if (start < end) {
                        filledArray[i][j] = start;
                        start++;
                    } else {
                        filledArray[i][j] = end;
                        end--;
                    }
                }
            }
        }
        return filledArray; //Zeile kann geändert oder entfernt werden.
    }

    private static int[][] generateExtendedArray(int[] inputArray) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode
        int rows1 = inputArray[0];
        int cols1 = inputArray[1];
        int rows2 = inputArray[2];
        int cols2 = inputArray[3];
        int[][] workArray1 = new int[rows1][cols1];
        int[][] workArray2 = new int[rows2][cols2];
        int[][] workArrayfinal = new int[rows1 + rows2][Math.max(cols1, cols2)];

        int num1 = 1;
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols1; j++) {
                workArray1[i][j] = num1;
                num1++;
            }
        }
        int num2 = 1;
        for (int i = 0; i < rows2; i++) {
            for (int j = 0; j < cols2; j++) {
                workArray2[i][j] = num2++;
            }
        }
        for (int i = 0; i < rows1; i++) {
            System.arraycopy(workArray1[i], 0, workArrayfinal[i], 0, cols1);
        }

        for (int i = 0; i < rows2; i++) {
            System.arraycopy(workArray2[i], 0, workArrayfinal[i + rows1], 0, cols2);
        }

        return workArrayfinal; //Zeile kann geändert oder entfernt werden.
    }

    private static int[][] generateReformattedArray(int[][] inputArray) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode
        int max = 0;
        for (int[] row : inputArray) {
            max = Math.max(max, row.length);
        }
        int[][] workArray = new int[inputArray.length][max];
        for (int i = 0; i < inputArray.length; i++) {
            int n = 0;
            int k = max - 1;

            for (int j = 0; j < inputArray[i].length; j++) {
                if (inputArray[i][j] == 0) {
                    workArray[i][n++] = 0; 
                } else {
                    workArray[i][k--] = 1;
                }
            }
        }
        return workArray; //Zeile kann geändert oder entfernt werden.
    }

    //Vorgegebene Methode - BITTE NICHT VERÄNDERN!
    private static void printArray(int[][] inputArray) {
        if (inputArray != null) {
            for (int[] arr : inputArray) {
                for (int val : arr) {
                    System.out.print(val + "\t");
                }
                System.out.println();
            }
        }
    }

    //Vorgegebene Methode - BITTE NICHT VERÄNDERN!
    private static void printArray(int[] inputArray) {
        if (inputArray != null) {
            for (int val : inputArray) {
                System.out.print(val + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        System.out.println("Test: generateFilledArray");
        System.out.println("-----");
        int[][] array = generateFilledArray(2);
        printArray(array);
        assert (Arrays.deepEquals(array, new int[][]{{1, 2}, {2, 1}}));
        System.out.println("-----");

        array = generateFilledArray(4);
        printArray(array);
        assert (Arrays.deepEquals(array, new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {8, 7, 6, 5}, {4, 3, 2, 1}}));
        System.out.println("-----");

        array = generateFilledArray(5);
        printArray(array);
        assert (Arrays.deepEquals(array, new int[][]{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 12, 11},
                {10, 9, 8, 7, 6}, {5, 4, 3, 2, 1}}));
        System.out.println("-----");

        array = generateFilledArray(7);
        printArray(array);
        System.out.println("-----");
        System.out.println();

        System.out.println("Test: generateExtendedArray");
        System.out.println("-----");
        int[] array1 = new int[]{4, 3, 2, 6};
        int[][] array1res = generateExtendedArray(array1);
        printArray(array1res);
        assert (Arrays.deepEquals(array1res, new int[][]{{1, 2, 3}, {1, 2, 3}, {1, 2, 3}, {1, 2, 3},
                {1, 2, 3, 4, 5, 6}, {1, 2, 3, 4, 5, 6}}));
        System.out.println("-----");

        array1 = new int[]{2, 4, 1, 5};
        array1res = generateExtendedArray(array1);
        printArray(array1res);
        assert (Arrays.deepEquals(array1res, new int[][]{{1, 2, 3, 4}, {1, 2, 3, 4}, {1, 2, 3, 4, 5}}));
        System.out.println("-----");

        array1 = new int[]{1, 1, 1, 1};
        array1res = generateExtendedArray(array1);
        printArray(array1res);
        assert (Arrays.deepEquals(array1res, new int[][]{{1}, {1}}));
        System.out.println("-----");

        array1 = new int[]{4, 4, 1, 4};
        array1res = generateExtendedArray(array1);
        printArray(array1res);
        assert (Arrays.deepEquals(array1res, new int[][]{{1, 2, 3, 4}, {1, 2, 3, 4}, {1, 2, 3, 4},
                {1, 2, 3, 4}, {1, 2, 3, 4}}));
        System.out.println("-----");
        System.out.println();

        System.out.println("Test: generateReformattedArray");
        System.out.println("-----");
        int[][] array2 = new int[][]{{1, 0, 1, 1}, {0, 1, 1}, {0, 1, 0, 1, 1}, {0, 0, 0, 1, 0}, {1, 0}, {1, 1, 1, 1, 1}};
        System.out.println("Before:");
        printArray(array2);
        int[][] array2res = generateReformattedArray(array2);
        assert (Arrays.deepEquals(array2res, new int[][]{{0, 1, 1, 1}, {0, 1, 1}, {0, 0, 1, 1, 1},
                {0, 0, 0, 0, 1}, {0, 1}, {1, 1, 1, 1, 1}}));
        System.out.println("-----");
        System.out.println("After:");
        printArray(array2res);
        System.out.println("-----");

        array2 = new int[][]{{1, 0, 1, 1, 0, 0, 0, 0}, {0, 1, 1, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 1}, {1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 0, 1}, {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1}};
        System.out.println("Before:");
        printArray(array2);
        array2res = generateReformattedArray(array2);
        assert (Arrays.deepEquals(array2res, new int[][]{{0, 0, 0, 0, 0, 1, 1, 1}, {0, 0, 0, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 1, 1}, {0, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 1, 1, 1}, {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1}}));
        System.out.println("-----");
        System.out.println("After:");
        printArray(array2res);
        System.out.println("-----");

        array2 = new int[][]{{0}, {1}, {0, 0}, {0, 1}, {1, 0}, {1, 1}};
        System.out.println("Before:");
        printArray(array2);
        array2res = generateReformattedArray(array2);
        assert (Arrays.deepEquals(array2res, new int[][]{{0}, {1}, {0, 0}, {0, 1}, {0, 1}, {1, 1}}));
        System.out.println("-----");
        System.out.println("After:");
        printArray(array2res);
        System.out.println("-----");
    }
}
