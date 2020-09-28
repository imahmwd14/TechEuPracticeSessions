package hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution2 {

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

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] ab = scanner.nextLine().split(" ");

            int a = Integer.parseInt(ab[0]);

            int b = Integer.parseInt(ab[1]);

            int result = squares(a, b);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
