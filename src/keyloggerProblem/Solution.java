package keyloggerProblem;

import java.util.Arrays;
import java.util.List;


public class Solution {

    private static final List<Integer> primes = Arrays.asList(2, 3);

    public static long solve(long n) {
        for (long i = 0; ; i++) {
            long prev = n - i;
            long next = n + i;
            if (isPrime(prev)) return prev;
            if (isPrime(next)) return next;
        }
    }

    private static boolean isPrime(long i) {
        if (primes.contains((int) i)) return true;
        else if (i % 2 == 0 || i % 3 == 0) return false;

        for (int j = 2; j < Math.sqrt(i); j++) {
            if (i % j == 0) return false;
        }

        return true;
    }
}