package codeWarsSolutions;

public class DescendingOrder {
    public static void main(String[] args) {
        System.out.println(FPB(12, 42));
    }

    static int FPB(
            int a,
            int b
    ) {
        return (b > 0) ?
                FPB(b, b % a) :
                a;
    }

    /*private static void calcFactors(int x, ArrayList<Integer> factorsX) {
        for (int i = 2; x > 0 && i < (x / 2) + 1; i++) {
            if (x % i == 0) {
                factorsX.add(i);
                x /= i;
                i = 2;
            }
        }
    }

    private static int powUsingFor(int k, int power) {
        if (power == 0) return 1;

        int temp = k;

        for (int j = 0; j < power; j++) {
            k *= temp;
        }

        return k;
    }

    private static int powSimpler(int i, int i1) {
        int returnVal = i;

        while (i1-- > 1) returnVal *= i;

        return returnVal;
    }

    private static int c(int[] ints,
                         int i) {
        return (i < ints.length) ?
                ints[i++] + c(ints, i) :
                0;
    }

    private static int pow(
            int k,
            int power
    ) {
        return (power > 0) ?
                k * pow(k, --power) :
                1;
    }*/
}