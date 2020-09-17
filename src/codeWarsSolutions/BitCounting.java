package codeWarsSolutions;

import java.util.stream.Stream;


public class BitCounting {

    public static int countBits(int n) {
        String binaryString = Integer.toBinaryString(n);
        return (int) binaryString.chars()
                .filter(a -> a == '1')
                .count();
    }

}
