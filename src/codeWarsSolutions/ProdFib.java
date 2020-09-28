package codeWarsSolutions;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProdFib { // must be public for codewars

    public static long[] productFib(long prod) {
        // your code

        List<Long> sequence = generateSequence(prod);

        for (int i = sequence.size() - 1; i >= 1; i--) {
            if (prod % sequence.get(i) == 0)
                if (sequence.get(i - 1) * sequence.get(i) == prod)
                    return new long[]{sequence.get(i - 1), sequence.get(i), 1};

        }

        for (int i = sequence.size() - 2; i >= 1; i--) {
            Long a = sequence.get(i + 1);
            Long b = sequence.get(i);
            Long c = sequence.get(i - 1);
            if (c * b < prod && prod < b * a) return new long[]{b, a, 0};
        }

        return null;
    }

    private static List<Long> generateSequence(long prod) {
        List<Long> o = new ArrayList<>(Arrays.asList(0L, 1L));

        for (long i = 0; i < prod; i++) {
            o.add(o.get(o.size() - 1) + o.get(o.size() - 2));
        }

        return o;
    }
}

