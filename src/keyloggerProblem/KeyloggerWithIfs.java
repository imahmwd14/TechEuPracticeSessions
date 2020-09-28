package keyloggerProblem;

public class KeyloggerWithIfs {

    public static void main(String[] args) {
        System.out.println(extractPassword("Gs<<G>W>-P"));
        System.out.println(extractPassword("Gs<<G>W>-P"));
        System.out.println(extractPassword("kjl19<<SEP<<<---15"));
        System.out.println(extractPassword("UniS>>><<<N>>>sRI<<-<--"));
        System.out.println(extractPassword("mahmoud<<<<<<<<<<<asyraf>>>>>>>-------"));

        char c;
    }

    private static String extractPassword(String distortedInput) {
        int cursor = 0;

        StringBuilder output = new StringBuilder();

        for (char c : distortedInput.toCharArray()) {
            cursor = correctIndex(cursor, output.length());

            if (c == '<') --cursor;
            else if (c == '>') ++cursor;
            else if (c == '-' && cursor > 0) output.deleteCharAt(--cursor);
            else output.insert(cursor++, c);
        }

        return output.toString();
    }

    private static int correctIndex(int insertionIndex, int upperLimit) {
        if (insertionIndex < 0) return 0;
        else if (insertionIndex > upperLimit) return upperLimit;
        return insertionIndex;
    }
}