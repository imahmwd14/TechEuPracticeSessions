package tech;

import java.util.Arrays;
import java.util.Scanner;

public class Solution1 {
    public static void main(String args[]) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner s = new Scanner(System.in);

        int T = s.nextInt();

        int max = Integer.MIN_VALUE;

        int maxMemeber = Integer.MIN_VALUE;

        for (int i = 0; i < T; i++) {
            String name = s.next();

            max = Integer.max(max, name.length());

            int mmbrs = s.nextInt();

            String names = s.nextLine();

            if (names.isEmpty()) names = s.nextLine();

            maxMemeber = Math.max(maxMemeber, Arrays.stream(names.split(" ")).mapToInt(String::length).max().getAsInt());
        }

        System.out.printf("%d %d%n", max, maxMemeber);
    }
}