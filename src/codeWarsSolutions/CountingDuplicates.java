package codeWarsSolutions;

public class CountingDuplicates {
    public static int duplicateCount(String text) {
        final String lowerCase = text.toLowerCase();

        return (int) lowerCase.chars()
                /*.distinct() *//*removes duplicates*/
                .filter(
                        a -> !(lowerCase.chars()
                                .filter(b -> a == b)
                                .count() == 1)
                )
                .distinct()
                .count();

    }
}

/*
*
* 6 3
* find x such that 6 % x == 0 and 3 % x == 0
*
*
* */


