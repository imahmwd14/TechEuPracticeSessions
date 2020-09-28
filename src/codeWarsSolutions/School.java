package codeWarsSolutions;

import java.util.Arrays;
import java.util.stream.Collectors;

public class School {
    public static int getAverage(int[] marks) {
        int sum = Arrays.stream(marks).sum();
        return sum / marks.length;
    }
}
