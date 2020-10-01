package hackerrank;

import java.util.*;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

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

    static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {
        if (y1 > y2) return 10_000;
        else if (m1 > m2 && y1 == y2) return (m1 - m2) * 500;
        else if (d1 > d2 && m1 == m2 && y1 == y2) return (d1 - d2) * 15;
        return 0;
    }

    public boolean checkIsStringPentagram(String sentence) {
        return (sentence
                .toLowerCase()
                .chars()
                .distinct()
                .filter(Character::isAlphabetic)
                .count() == 26);
    }

    /*
     * codewars
     * */
    public static boolean isValid(char[] walk) {
        String s = new String(walk);

        int x = s.chars()
                .filter(value -> value == 'e' || value == 'w')
                .mapToObj(value -> {
                    if (value == 'w') return -1;
                    else return 1;
                })
                .mapToInt(Integer::valueOf)
                .sum();

        int y = s.chars()
                .filter(value -> value == 'n' || value == 's')
                .mapToObj(value -> {
                    if (value == 'n') return 1;
                    else return -1;
                })
                .mapToInt(Integer::valueOf)
                .sum();

        return x == 0 && y == 0 && walk.length == 10;
    }

    /*
     * codewars
     * */
    public static String longestConsec(String[] strarr, int k) {
        if (k <= 0) return "";
        else if (k == 1) return Arrays.stream(strarr)
                .max(Comparator.comparingInt(String::length))
                .orElse("");

        return IntStream.rangeClosed(0, strarr.length - k)
                .mapToObj(i -> Arrays.stream(strarr, i, i + k).collect(Collectors.joining()))
                .max(Comparator.comparingInt(String::length))
                .orElse("");
    }

    /*
     * codewars
     * */
    public static String reverseLetter(final String str) {
        return new StringBuilder(str.chars()
                .filter(Character::isAlphabetic)
                .mapToObj(value -> Character.valueOf((char) value).toString())
                .reduce("", String::concat)).reverse().toString();
    }

    public static int getCount(String str) {
        final String vowels = "aeiou";
        return (int) str.chars()
                .filter(value -> vowels.indexOf(value) > -1)
                .count();
    }

    public static int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        IntStream.range(0, numbers.length)
                .forEach(value -> map.put(numbers[value], value));

        int[] indices = {0, 0};

        for (Integer key0 : map.keySet()) {
            int key1 = target - key0;
            if (map.containsKey(key1)) {
                indices[0] = map.get(key0);
                indices[1] = map.get(key1);
            }
        }

        return indices;
    }

    static String encode(String word) {
        word = word.toLowerCase();

        HashMap<String, Integer> map = new HashMap<>();

        for (var s : word.split("")) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        return word.chars()
                .mapToObj(value -> map.get(String.valueOf((char) value)) == 1 ? "(" : ")")
                .collect(Collectors.joining());
    }

    static long repeatedString(String s, long n) {
        // count how many a are there in the string
        long count = s.chars().filter(value -> value == (char) 'a').count();

        long l = n / s.length(); // how many times the string will repeat in the new string

        int i = (int) (n % s.length());


        long ASCount = count * l;
        if (i > 0)
            return ASCount + s.substring(0, i).chars().filter(value -> value == 'a').count();
        return ASCount;
    }

    static int equalizeArray(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        return arr.length - Collections.max(map.values());
    }

    static int[] acmTeam(String[] topic) {
        int[] maxIndices = {0, 0};

        for (int i = 0, topicLength = topic.length; i < topicLength; i++) {
            String s = topic[i];
            for (int j = 0, length = topic.length; j < length; j++) {
                String s1 = topic[j];

                maxIndices[0] = Math.max(Integer.parseInt(s) | Integer.parseInt(s1), maxIndices[0]);
            }
        }

        for (int i = 0, topicLength = topic.length; i < topicLength; i++) {
            String s = topic[i];
            for (int j = 0, length = topic.length; j < length; j++) {
                String s1 = topic[j];

                if ((Integer.parseInt(s) | Integer.parseInt(s1)) == maxIndices[0]) {
                    maxIndices[1]++;
                }
            }
        }

        return new int[]{(int) Integer.toBinaryString(maxIndices[0]).chars().filter(value -> value == '1').count(), maxIndices[1]};
    }
}
