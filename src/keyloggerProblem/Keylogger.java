package keyloggerProblem;

public class Keylogger {

    public static void main(String[] args) {
        System.out.println(extractPassword("Gs<<G>W>-P"));
        System.out.println(extractPassword("kjl19<<SEP<<<---15"));
        System.out.println(extractPassword("UniS>>><<<N>>>sRI<<-<--"));
        System.out.println(extractPassword("mahmoud<<<<<<<<<<<asyraf>>>>>>>-------"));
    }

    private static String extractPassword(String distortedInput) {

        int insertionIndex = 0;

        StringBuilder output = new StringBuilder();

        for (char c : distortedInput.toCharArray()) {

            insertionIndex = correctIndex(insertionIndex, output.length());

            switch (c) {
                case '<': {
                    --insertionIndex;
                    break;
                }

                case '>': {
                    ++insertionIndex;
                    break;
                }

                case '-': {
                    if (output.length() > 0 && insertionIndex > 0) {
                        if (insertionIndex < output.length())
                            output.deleteCharAt(--insertionIndex);
                        else output.deleteCharAt(output.length() - 1);
                    }
                    break;
                }

                default: {
                    if (insertionIndex < output.length())
                        output.insert(insertionIndex, c);
                    else output.append(c);

                    ++insertionIndex;
                }
            }
        }

        return output.toString();
    }

    private static int correctIndex(int insertionIndex, int upperLimit) {
        if (insertionIndex < 0) return 0;
        else if (insertionIndex > upperLimit) return upperLimit;
        return insertionIndex;
    }
}