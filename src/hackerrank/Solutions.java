package hackerrank;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solutions {
    public static void main(String[] args) {
        kaprekarNumbers(1, 99999);
    }

    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        int[] output = {0, 0};

        IntStream.rangeClosed(0, 2)
                .forEach(index -> {
                    if (a.get(index) > b.get(index))
                        output[0]++;
                    else if (a.get(index) < b.get(index))
                        output[1]++;
                });

        return Arrays.stream(output).boxed().collect(Collectors.toList());
    }

    int beautifulMatrix(int[][] arr) {
        int n = (arr.length + 1) / 2;
        int m = (arr[0].length + 1) / 2;

        int[] coordinates = {0, 0};

        IntStream.range(0, arr.length).forEach(i -> {
            IntStream.range(0, arr[i].length).forEach(j -> {
                if (arr[i][j] == 1) {
                    coordinates[0] = i + 1;
                    coordinates[1] = j + 1;
                }
            });
        });

        return Math.abs(n - coordinates[0]) + Math.abs(m - coordinates[1]);
    }

    static void kaprekarNumbers(int p, int q) {
        final int[] count = {0};
        p = p == 0 ? 1 : p;

        IntStream.rangeClosed(p, q)
                .filter(integer -> {
                    if (integer == 1) return true;

                    String s = String.valueOf(integer);
                    String squared = String.valueOf((long) Math.pow(integer, 2));
                    int splittingIndex = (squared.length() - s.length());
                    String r = squared.substring(splittingIndex);
                    String l = squared.substring(0, splittingIndex);

                    if (r.length() < s.length()) return false;
                    else
                        return !l.isEmpty() && !r.isEmpty() && Long.parseLong(l) + Long.parseLong(r) == integer;
                })
                .forEach(i -> {
                    System.out.print(i + " ");
                    count[0]++;
                });
        if (count[0] == 0) System.out.println("INVALID RANGE");
    }

    static int chocolateFeast(int n, int c, int m) {
        int chocs = n / c;
        int wrappers = chocs;

        while (wrappers >= m) {
            int newChocs = wrappers / m;
            chocs += newChocs;
            wrappers %= m;
            wrappers += newChocs;
        }

        return chocs;
    }
}
