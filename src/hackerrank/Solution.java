package hackerrank;

import java.io.*;
import java.util.*;
import java.util.function.IntPredicate;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

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

}

public class Solution {
    public static void main(String[] args) throws IOException {
        System.out.println(Result.getTotalX(Arrays.asList(1), Arrays.asList(100)));

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int total = Result.getTotalX(arr, brr);

        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
