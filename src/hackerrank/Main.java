package hackerrank;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        IntStream
                .range(1, 5)
                .filter(value -> value % 2 == 1)
                .forEach(System.out::println);
    }


    public static int countingValleys(int steps, String path) {
        final int[] numOfValleys = new int[1];

        path.chars()
                .mapToObj(operand -> (operand == 'U') ? 1 : -1)
                .mapToInt(Integer::intValue)
                .reduce(0, (prev, nextStep) -> {
                    int newAlt = prev + nextStep;
                    numOfValleys[0] += (newAlt == 0 && prev < 0) ? 1 : 0;
                    return newAlt;
                });

        return numOfValleys[0];
    }

    static int getMoneySpent(int[] keyboards, int[] drives, int b) {

        List<Integer> keyboardsList = Arrays.stream(keyboards)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        List<Integer> drivesList = Arrays.stream(drives)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        int max = -1;

        for (int keyboard : keyboardsList)
            for (int drive : drivesList) {
                int sum = drive + keyboard;
                if (sum <= b) {
                    max = sum;
                    break;
                }
            }

        for (int drive : drivesList)
            for (int keyboard : keyboardsList) {
                int sum = drive + keyboard;
                if (sum <= b) {
                    max = Math.max(sum, max);
                }
            }

        return max;
    }

    static String catAndMouseT(int x, int y, int z) {
        x = Math.abs(x - z); // how far is x from the mouse
        y = Math.abs(y - z); // how far is y from the mouse
        return x == y ? "Mouse C" :
                (x > y) ? "Cat B" : "Cat A";
    }

    public static int pickingNumbers(List<Integer> a) {
        int maxSize = 0;

        a.sort(Integer::compareTo);

        /*==1*/
        for (Integer integer : a) { /*how many one are there->*/
            long count = /*how many one are there->*/ 0L;
            for (Integer integer11 : a) {
                if (integer11.equals(integer)) {
                    count++;
                }
            }

            /*==0*/
            long minusOne /*==0*/ = 0L;
            for (Integer integer1 : a) {
                if (integer1.equals(integer - 1)) {
                    minusOne++;
                }
            }

            maxSize = (int) Math.max(count + minusOne, maxSize);
        }

        return maxSize;
    }
}
