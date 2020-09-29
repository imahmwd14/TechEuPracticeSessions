package hackerrank;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        IntStream
                .range(1, 5)
                .filter(value -> value % 2 == 1)
                .forEach(System.out::println);
    }


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


    public static int getTotalX(List<Integer> a, List<Integer> b) {
        IntPredicate intPredicate = value -> {
            return a.stream().filter(integer -> value % integer == 0).count() == a.size()
                    && b.stream().filter(integer -> integer % value == 0).count() == b.size();
        };

        return (int) IntStream
                .range(/*the last element in a->*/a.get(a.size() - 1), /*the first element in b->*/b.get(0) + 1)
                .filter(intPredicate)
                .count();
    }


    // Complete the squares function below.
    static int squares(int a, int b) {
        // return (int) Math.floor(Math.sqrt(b) - (int) Math.ceil(Math.sqrt(a))) + 1;


        return (int) IntStream /*Class*/
                .range(/*start*/ a, /*up to*/ b + 1)
                /*choosing some of the numbers in the range*/
                .filter(value -> {
                    double sqrt = Math.sqrt(value);
                    return sqrt - Math.floor(sqrt) == 0;
                })
                .count();
    }


    public static int diagonalDifference(List<List<Integer>> arr) {
        IntStream indices = IntStream.range(0, arr.size());

        int principalDiagonal = indices
                .map(i -> arr.get(i).get(i))
                .sum();

        int secondaryDiagonal = indices
                .map(i -> arr.get((arr.size() - 1) - i).get(i))
                .sum();

        return Math.abs(principalDiagonal - secondaryDiagonal);
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

    // Complete the birthday function below.
    static int birthday(List<Integer> s, int d, int m) {
        int count = 0;

        for (int i = 0, sSize = s.size(); i < sSize; i++) {
            count += findSegment(s, i, d, m);
        }

        return count;
    }

    private static int findSegment(List<Integer> s, int i, int d, int m) {
        if (i < s.size() && d != 0 && m != 0)
            return findSegment(s, i + 1, d - s.get(i), m - 1);
        else if (d == 0 && m == 0) return 1;
        return 0;
    }

    static String angryProfessor(int k, int[] a) {
        int studentsPresent = (int) Arrays.stream(a)
                .filter(value -> value <= 0)
                .count();
        return (studentsPresent >= k) ? "NO" : "YES";
    }

    static int beautifulDays(int i, int j, int k) {
        return (int) IntStream.rangeClosed(i, j)
                .filter(value -> {
                    String integerString = String.valueOf(value);
                    String reverseString = new StringBuilder(integerString)
                            .reverse().toString();

                    int reverse = Integer.parseInt(reverseString);
                    return Math.abs(value - reverse) % k == 0;
                })
                .count();
    }

    static int[] cutTheSticks(int[] arr) {
        ArrayList<Integer> remainingSticks = new ArrayList<>();

        remainingSticks.add(arr.length);

        while (Arrays.stream(arr).filter(value -> value > 0).count() > 0) {
            int smallest = Arrays.stream(arr)
                    .filter(value -> value > 0)
                    .sorted()
                    .toArray()[0];

            arr = Arrays.stream(arr)
                    .filter(value -> value > 0)
                    .map(operand -> operand - smallest)
                    .toArray();

            int count = (int) Arrays.stream(arr)
                    .filter(value -> value > 0)
                    .count();

            if (count != 0) {
                remainingSticks.add(count);
            }
        }

        return remainingSticks.stream().mapToInt(Integer::intValue).toArray();
    }

    // Complete the designerPdfViewer function below.
    static int designerPdfViewer(int[] h, String word) {
        return word.chars()
                .map(operand -> h[operand - 'a'])
                .max().getAsInt() * word.length();
    }

    // Complete the utopianTree function below.
    static int utopianTree(int n) {
        return IntStream.rangeClosed(0, n)
                .reduce(0, (left, right) ->
                        (right % 2 == 0) ? left + 1 : left * 2);
    }
}
