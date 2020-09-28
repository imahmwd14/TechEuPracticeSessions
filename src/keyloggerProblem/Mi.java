package keyloggerProblem;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Mi {

    final private static List<Character> shipTypes = Arrays.asList('<', '>', '^', 'v');

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        measureInformationExchange(
                Arrays.asList(
                        Arrays.asList(Arrays.asList('*'), Arrays.asList('v'), Arrays.asList('*')),
                        Arrays.asList(Arrays.asList('>'), Arrays.asList('*'), Arrays.asList('<')),
                        Arrays.asList(Arrays.asList('*'), Arrays.asList('^'), Arrays.asList('*'))));


    }

    private static int measureInformationExchange(List<List<List<Character>>> galaxy) {
        var informationExchangeTimes = 0;

        boolean hasStarShips = true;

        while (hasStarShips) {
            hasStarShips = false;

            for (int i = 0; i < galaxy.size(); i++) {

                List<List<Character>> row = galaxy.get(i);

                for (int i1 = 0; i1 < row.size(); i1++) {

                    List<Character> cell = row.get(i1);

                    // if cell has more than 1 element then possibly there are two or more ships
                    if (cell.size() > 1) {
                        var starshipsCount = 0;
                        for (Character character : cell) {
                            if (shipTypes.contains(character)) starshipsCount++;
                        }
                        // (n*(n-1))/2
                        informationExchangeTimes += (starshipsCount * (starshipsCount - 1)) / 2;
                    }

                    // move the ships
                    for (int i2 = 0; i2 < cell.size(); i2++) {
                        Character c = cell.get(i2);
                        if (shipTypes.contains(c)) {
                            // if we reach this then we have a ship.
                            if (c == '>') row.get(i1 + 1).add(c);
                        }
                    }
                }
            }
        }

        return informationExchangeTimes;
    }
}