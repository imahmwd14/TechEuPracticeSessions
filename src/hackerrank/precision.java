package hackerrank;

import java.util.*;

public class Solution {

    // Complete the plusMinus function below.
    static void plusMinus(int[] arr) {
        double[] outputs = new double[3];

        outputs[0] = (double) Arrays.stream(arr).filter(value -> value > 0).count() / arr.length;
        outputs[1] = (double) Arrays.stream(arr).filter(value -> value < 0).count() / arr.length;
        outputs[2] = (double) Arrays.stream(arr).filter(value -> value == 0).count() / arr.length;

        for (double f : outputs) {
            System.out.printf("%.6f%n", f);
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        plusMinus(arr);

        scanner.close();
    }
}
