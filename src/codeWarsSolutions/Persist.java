package codeWarsSolutions;

import java.util.stream.Stream;

public class Persist {

    public static int persistence(long n) {
        if (n > 9) {
            final int[] temp = {1};

            String.valueOf(n).chars()
                    .forEach(a -> {
                        int digit = Integer.parseInt(Character.toString(a));

                        temp[0] *= digit;
                    });

            return persistence(temp[0]) + 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(persistence(100));
    }
}


