package lab2;


import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;

public class ArrayMethods {

    public static void randomArray(double array[][]) {
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = random.nextInt((array.length - (-array.length)) + 1) - array.length;
            }
        }
    }

    public static double[][] sizeArray(int size) {
        double[][] array = new double[0][];
        try {
            array = new double[size][size];
        } catch (NumberFormatException | NegativeArraySizeException e) {
            throw new FileNotFound();
        }
        return array;
    }

    public static String print(double[][] array) {

        String result = " ";
        String temp[] = new String[array.length];
        Arrays.fill(temp, " ");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                String format = new DecimalFormat("#0.000").format(array[i][j]);
                if (array[i][j] < 0) temp[i] += (" " + format);
                else temp[i] += ("  " + format);
            }
            temp[i] += ("\n");
        }

        for (int i = 0; i < array.length; i++) result += temp[i];
        return result;
    }

    public static double[][] rotate(double array[][]) {
        int k = array.length;
        double temp;
        for (int i = 0; i < k / 2; i++) {
            for (int j = i; j < k - 1 - i; j++) {
                temp = array[i][j];
                array[i][j] = array[j][k - 1 - i];
                array[j][k - 1 - i] = array[k - 1 - i][k - 1 - j];
                array[k - 1 - i][k - 1 - j] = array[k - 1 - i - j][i];
                array[k - 1 - j][i] = temp;
            }
        }
        return array;
    }

    public static double[][] divSum(double array[][]) {
        double temp = 0, result = 0;
        double arraySum[][] = new double[array.length][array[0].length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (j == 0) {
                    arraySum[i][j] = array[i][j + 1];
                } else if (j == array[0].length - 1) {
                    arraySum[i][j] = array[i][j - 1];
                } else {
                    arraySum[i][j] = array[i][j - 1] + array[i][j + 1];
                }
            }
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                try {
                    if (array[i][j] == Double.NEGATIVE_INFINITY || array[i][j] == Double.POSITIVE_INFINITY || array[i][j] == 0 || arraySum[i][j] == 0) {
                        throw new DivisionByZero();
                    } else array[i][j] = array[i][j] / arraySum[i][j];
                } catch (DivisionByZero e) {
                    array[i][j] = 0;
                }
            }
        }
        return array;
    }

}
