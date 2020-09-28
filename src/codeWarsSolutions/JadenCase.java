package codeWarsSolutions;

import java.util.Arrays;
import java.util.stream.Collectors;

public class JadenCase {

    public String toJadenCase(String phrase) {

        return (phrase == null || phrase.isEmpty() || phrase.isBlank()) ?
                null :
                Arrays.stream(phrase.split(" "))
                        .map(s -> {
                            StringBuilder stringBuilder = new StringBuilder(s);
                            stringBuilder.setCharAt(0, Character.toUpperCase(s.charAt(0)));
                            return stringBuilder.toString();
                        })
                        .collect(Collectors.joining(" "));
    }
}
